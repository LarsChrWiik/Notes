# self.id in Django
* self.id represents the primary key (PK) of an object
* It is automatically generated unique identifier assigned to each object when it is saved to the database. **However, it's important to note that self.id is not set until the object has been saved**.


### self.id is None means creation of new object
When you create a new instance of a Django model, the *id* attribute is initially *None* or *null*. It gets assigned a value when the object is saved for the first time. Until then, *self.id* remains *None*, indicating that the object has not been saved to the database yet.

For example, we can check for *self.id* is None in the .save() method to determine if the object is being created for the first time or updated.


### Key points to understand about self.id in Django:

* Object Modification: Once an object has been saved and assigned an id, subsequent modifications to the object will not change its id. Therefore, during updates or modifications, the self.id attribute remains the same as the original value assigned when the object was first saved.
* Database Lookup: When you retrieve an object from the database using Django's query APIs (e.g., Model.objects.get()), the retrieved object will have the id attribute populated with the corresponding primary key value from the database.
* Checking Object State: The if self.id check is commonly used to determine if an object has been saved or not. If self.id is None, it implies that the object has not been saved, and if it has a value, it indicates that the object exists in the database.

Here's an example to illustrate the usage of self.id:
```py
class MyModel(models.Model):
    name = models.CharField(max_length=100)

# Creating a new object
obj = MyModel(name="Example")
print(obj.id)  # Output: None

# Saving the object to the database
obj.save()
print(obj.id)  # Output: 1 (or the assigned primary key value)

# Modifying the object
obj.name = "Updated Example"
obj.save()
print(obj.id)  # Output: 1 (remains the same)

# Retrieving an object from the database
retrieved_obj = MyModel.objects.get(id=1)
print(retrieved_obj.id)  # Output: 1
```

In summary, self.id in Django represents the primary key of an object and allows you to determine the object's state, whether it has been saved or not, and retrieve its unique identifier.

