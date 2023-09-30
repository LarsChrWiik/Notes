
# Query Set API
The QuerySet API is used for `creating`, `retrieving`, `updating`, and `deleting` records in the database to abstract away complex SQL queries.

## QuerySet Characteristics
* **Lazy Loading**: evaluated when explicitly requested.
* **Chainable**: Multiple QuerySet methods can be chained together and will return a single QuerySet.
* **Immutable Chaining**: If you chain a queryset with another queryset, the original queryset is not modifed. Instead, a new queryset is created.
* **Caching**: Once a QuerySet is evaluated, it caches the results. This means that operations on the same QuerySet do not hit the database.


# Example Model
Example of a Django model we will use throughout this document:
```python
from django.db import models

class Author(models.Model):
    name = models.CharField(max_length=100)

class Book(models.Model):
    title = models.CharField(max_length=100)
    author = models.ForeignKey(Author, on_delete=models.CASCADE)
```


# Core Methods of the QuerySet API
* **.all()**: Get all records.
* **.filter()**: Get all recods that match the given condition.
* **.exclude()**: Get all recods except when they match the given condition.
* **.get()**: Force return the single object that matches the query. NB: This return the object, not a QuerySet.
* **.create()**: Create new object with the given parameters.
* **.save()**: Save the given object to the database.
* **.update()**: Updates the objects in the QuerySet.
* **.delete()**: Deletes the objects in the QuerySet.
* **.count()**: Returns the number of objects in the QuerySet.
* **.exists()**: Returns True if the QuerySet contains any records with the given condition, False otherwise. Without a condition, it is the same as .count() > 0. Or len(queryset) > 0. It is more efficient as it doesn’t fetch or load any records into Python memory but instead checks at the database level for the firt record that meets the criteria. It uses the `EXISTS` SQL keyword to be more efficient.
* **.order_by()**: Returns a new QuerySet sorted by the given fields.


## Nesting Attribute Querying
To be able to nest attributes in Django, you can use the double underscore syntax.
```py
books_by_john_doe = Book.objects.filter(author__name='John Doe')
```
Note here that author is an attribute of Book, and name is an attribute of Author. We can traverse the obects by using the double underscore syntax author__name.


## Filter

### Filter in exact attribute value
```python
MyModel.objects.filter(id=123)
```

### Filter on nested attribute
```python
has_books = Book.objects.filter(title__icontains='Python')
```


## Exclude

### Exclude exact attribute value
```python
MyModel.objects.exclude(id=123)
```

### Exclude on nested attribute
```python
MyModel.objects.exclude(title__icontains='Python')
```


## Exists
```python
MyModel.objects.filter(title__icontains='Python')
```


# Field Lookups
The QuerySet API supports different types of comparisons when querying data.
These types of comparisons are called field lookups.

The `i` in front of some of the lookups means that the comparison is case-insensitive.

### contains
```python
books_containing_python = Book.objects.filter(title__contains='Python')
```

### icontains
```python
books_containing_python = Book.objects.filter(title__icontains='python')  # Case insensitive
```

### exact
```python
specific_book = Book.objects.filter(title__exact='Python Programming')
```

### iexact
```python
specific_book = Book.objects.filter(title__iexact='python programming')  # Case insensitive
```

### gt (Greater Than)
```python
books_after_id_10 = Book.objects.filter(id__gt=10)  # Get all books with ID greater than 10
```

### lt (Less Than)
```python
books_before_id_10 = Book.objects.filter(id__lt=10)  # Get all books with ID less than 10
```

## on_delete CASCADE on foreign key
Assume you have ModelA that has an attribute X that is a foreign key to ModelB.
If you use `on_delete=models.CASCADE` on the `ForeignKey`, it means that if you delete ModelA, it's related ModelB will also be deleted. But not the other way around.

Example:
```python
class PostalCode(models.Model):
    postal_code = models.CharField(max_length=10, unique=True)
    city = models.CharField(max_length=100)
    state = models.CharField(max_length=100)
    country = models.CharField(max_length=100)

class Address(models.Model):
    street = models.CharField(max_length=100)
    postal_code = models.ForeignKey(PostalCode, on_delete=models.CASCADE)
```

In this case, each Address instance is associated with one PostalCode instance, implying that multiple addresses can share the same postal code.

Here, if a PostalCode instance is deleted, then all the Address instances associated with that postal code will also be deleted due to on_delete=models.CASCADE.

And if an Address instance is deleted, then the associated PostalCode instance will not be deleted.

In short, deleting an object that has `on_cascade`` should not cause a chain reaction of deletions. But when deleting an object, check if any other models has on_cascade on the object you are deleting - in that case, those objects will also be deleted.

ON_CASCADE logic should never be circular. It is always a DAG.
