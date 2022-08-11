# Django Models

### Meta attributes
Meta information about the Django model.

Django automatically created a database table according to the name of your model class and the app that contains it `<MyAppName>_<MyModelName>`.

Most used:
* **abstract**: (bool) whether the class in an abstract base class.
* **base_manager_name**: (str) name of the manager, example `objects`.
* **db_table**: (str) overwite table name.
* **managed**: (bool) whether Django should manage the database life cycle. Defaults to True.
* **permissions**: Extra permissions for the model. `add`, `change`, `delete`, and `view` permissions are automatically created for each model. The default permissions can also be changed using `default_permissions`.
**unique_together**: (list(list)) Specify fields that must be unique. unique_together cannot be used with `ManyToManyField`.
**index_together**: list(list) Specify fields that will be indexed together.

Ordering:
* **get_latest_by**: used to being able to sort the objects, for example using a `date` column within the table.
* **order_with_respect_to**:
* **get_latest_by**:


### Django Model Data Types
See: https://www.webforefront.com/django/modeldatatypesandvalidation.html


### Relating tables in Django
See: https://www.webforefront.com/django/setuprelationshipsdjangomodels.html
* **models.ForeignKey(Menu)**
    * Used for "many-to-one" and "one-to-many"
* **models.ManyToManyField()**
* **models.OneToOneField()**

Examples:
```python

class Pet(models.Model):
    # One Pet only belongs to one Owner
    # But one Owner can have multiple Pets
    owner = models.ForeignKey(Person, on_delete=models.CASCADE, related_name='pets')
```


### Example

```python
from django.db import models

class MyPerson(models.Model):

    name = models.CharField(max_length=256)
    tlf = models.CharField(max_length=256)

    class Meta:
        permissions = [('can_view_person', 'Can view person')]
        unique_together = [['name', 'tlf']]

    def save(self, *args, **kwargs):
        ...
        return super().save(*args, **kwargs)
```
