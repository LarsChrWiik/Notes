
# Graphene-Django


### DjangoObjectType
```python
from graphene_django.types import DjangoObjectType

from project.apps.person.models.my_person import MyPerson


class PersonType(DjangoObjectType):

    name = graphene.Field(id=graphene.ID())

    class Meta:
        model = MyPerson
        fields = '__all__'
```
