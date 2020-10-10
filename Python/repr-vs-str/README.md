
# repr and str
*repr()* and *str()* are both built-in functions (special python methods) (methods reserved by python).

### Repr
* should be implemented to return the **"official"** string representation of the object.  
* is mainly used for **debugging and development**.
* The string should be acceptable to eval(). 

### Str
* should be implemented to return the **"printable"** string representation of the object. 
* is used for creating **output for end user**. 

### Difference
The difference between *str(object)* and *repr(object)* is that *str(object)* does not always attempt to return a string that is acceptable to eval(); its goal is to return a printable string. 

### Example of difference
```
>>> import datetime
>>> today = datetime.datetime.now()
>>> str(today)
'2012-03-14 09:21:58.130922'
>>> repr(today)
'datetime.datetime(2012, 3, 14, 9, 21, 58, 130922)'
```

### Example of implementation
```
class Person:

    def __init__(self, name):
        self.__name = name

    def __str__(self, key):
        return self.__name
```
