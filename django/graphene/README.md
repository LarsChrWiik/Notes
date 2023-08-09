# Graphene with django and GraphQL


### Django Model
```py
class MyModel(TimestampMixin):
    variable1 = models.PositiveIntegerField(default=False)
    variable2 = models.BooleanField(default=False)
    variable3 = models.BooleanField(default=False)
    myNestedVariable = JSONField(validators=[dict_with_floats], default=dict, blank=True, null=False)
    ...
```


### InputObjectType vs. DjangoObjectType
both `InputObjectType` and `DjangoObjectType` can be used as types in GraphQL queries.
* **InputObjectType**: Is used when we want to spesifically state the types of the fields in the query.
* **DjangoObjectType**: Is used when we want to use the Django model as the type of the field in the query.

The `DjangoObjectType` from graphene_django that is used to map Django models into GraphQL types.
It is common to use the `fields = '__all__'` in Meta for auto-generating the fields for GraphQL from the Django model.
And use `GenericScalar` for any custom objects.


```py
class MyModelType(DjangoObjectType):
    myNestedVariable = GenericScalar()

    class Meta:
        model = MyModel
        fields = '__all__'
```

```py
class MyModelType(InputObjectType):
    variable1 = graphene.Int()
    variable2 = graphene.Boolean()
    variable3 = graphene.Boolean()
    myNestedVariable = GenericScalar()  # Custom object
```


### GenericScalar
The `GenericScalar` scalar type from graphene that represents a generic GraphQL scalar.
The value of a field can be any valid JSON-serializable data value:
* String
* Boolean
* Int
* Float
* List
* Object


### Graphene Query
The fragment name can be anything, but the GraphQL object must match the name of the Django model.

Example:
* Fragment: MyModelType
```ts
export default gql`
  fragment MyFragment on MyModelType {
    variable1
    variable2
    variable3
    myNestedVariable {
      variable4
    }
  }
  ${zodiacSettingsFragment}
`;
```
