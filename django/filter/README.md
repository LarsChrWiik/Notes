
# Django Filter functions


### Filter in exact attribute
```python
MyModel.objects.filter(id=123)
```


### Filter on nested attribute
```python
MyModel.objects.filter(myVarOne__myVarOneAttribute__myVarOneAttribute2__endswith="@email.com"):
```
