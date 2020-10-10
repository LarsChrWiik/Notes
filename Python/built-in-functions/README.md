
# Built-in functions
Doc: https://docs.python.org/3/library/functions.html

### Magic Dunder functions
Functions with this format: **\_\_func\_\_** are called **magic functions**, or **dunder functions**.

Examples: \_\_str\_\_, \_\_iter\_\_, \_\_len\_\_, and many more.

### Some built-in functions support overwrite
For built in function *X* that can be overwritten: 
* **X(my_object)** returns **my_object.\_\_X\_\_()**

X can be overwritten within the my_object class like this:
```
class my_Object:

    def __X__(self):
        ...
```

### Top built-in functions I use
* **abs(x)**: return absolute value of a number. 
* **all(iter_obj)**: Return True if all elements in iter_obj is True, or it iter_obj is empty. 
* **any(iter_obj)**: Return True if any elements in iter_obj is True. Return False if iter_obj is empty. 
* **bool(x)**: Return a boolean. 
* **dict()**: Creates a dict object. 
* **enumerate(obj)**: Returns an object consisting of pairs with index and value. 
* **filter(func, iter_obj)**: same as "(x for x in iter_obj if func(x))". 
* **float()**: Convert to float. 
* **frozenset()**: Returns an immutable version of a Python set object. Frozenset is a built-in class. 
* **int()**: Convert to int. 
* **isinstance(obj, class)**: Return bool of whether the object is instance of class. 
* **issubclass(obj, class)**: Return bool of whether the object is a subclass of class. 
* **len(ojb)**: Returns the length of the object. 
* **list**: Creates a list. 
* **map(func, iter_obj)**: Applies func to every item in iter_obj. 
* **max(iter_obj)** / **max(x, y)**: Return the largest item. 
* **min(iter_obj)** / **min(x, y)**: Return the smallest item. 
* **next(iter_obj)**: Get next item from in iterable. 
* **open()**: Used for open files. 
* **pow(x, y)**: Return x to the power of y. 
* **print(x)**: Print x. 
* **range(start, stop)**: creates an iterable range between two values. 
* **reversed(obj)**: Return a reverse iterator of the object. 
* **round(number, decimal_count)**: Rounds a number ot closest digit with given decimal count. 
* **set()**: Returns a set object. 
* **sorted(obj)**: Sorts the object / iterator. 
* **staticmethod()**: Transform a method into a static method. Also used as a decorator. 
* **str(obj)**: Convert object to string. 
* **sum(iter_obj)**: Return the sum of the iter_obj. 
* **super()**: Returns the parent object. 
* **tuple()**: Return a tuple object. 
* **type(obj)**: Return the type of the object. 
* **zip(*iters)**: Creates an iterator that aggregates from each of the iterators. 

### Other built-in functions
* **ascii(obj)**: Similar to *repr*, ascii return a printable version of the object, but the difference is that ascii excapes non-ascii characters. This string whould be similar to repr from Python 2.
* **bin(x)**: Convert int to binary string. 
* **breakpoint()**: Starts debugger - works as a breakpoint. 
* **bytearray()**: Return a new array of bytes. 
* **bytes()**: Return byte object. 
* **callable(x)**: Return True if x is callable, else False. Instances are callable if they have a \_\_call\_\_() function. 
* **chr(i)**: Returns the Unicode character at index i. chr() is the inverse of ord(). 
* **@classmethod**: Decotrator. A class method can be called either on the class (such as C.f()) or on an instance (such as C().f()).
* **compile**(): Compile the source into a code or AST object. Code objects can be executed by exec() or eval(). Source can either be a normal string, a byte string, or an AST object. 
* **complex**(): return a complex number. 
* **dir()**: Returns list of attributes within scope. 
* **divmod(a, b)**: returns a tuple: (a // b, a % b)
* **eval(str_expression)**: Evaluates the string expression. 
* **exec()**: dynamicly executes of Python code. 
* **format(value, formating)**: Convert a value to a “formatted” representation. 
* **globals**: Return a doct of global attribute. 
* **hash(obj)**: Return the hash value of an obj. 
* **help()**: Used to print info that will help the developer about to use the object. 
* **hex()**: Convert int to hexadecimal. 
* **id(obj)**: Return a unique id for the object. Two objects might have the same id if id() is used independently in non-overlapping lifetimes of two objects. 
* **input**: Allow the user to input into a variable. 
* **iter(obj)**: Return an iterator object of obj. 
* **locals()**: Return the local variables. 
* **oct()**: Convert int to octal string. 
* **ord(c)**: Conver a character c to the corresponding unicode integer. 
* **property**: Return a property attribute. Property can be used as a decorator as well. Property can be used so we can access an attribute but actually invoking a function. 
* **repr(obj)**: Return the string representation of the object (used for developers). 
* **slice()**: Return a slice object. 
* **vars(obj)**: return the varaibles within an object. 

### Built-in functions for Attributes
* **delattr(obj, attr_name)**: Deletes attribute. delattr(x, 'foobar') is equivalent to del x.foobar. 
* **getattr(obj, attr)**: Return the value of the given attribute within obj. 
* **hasattr(obj, attr)**: return boolean of whether the attribute attr exist in the object obj. 
* **setattr(obj, name, value)**: Counterpart to getattr(). Sets the attribute with name with value. 
