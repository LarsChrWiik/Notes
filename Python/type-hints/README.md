
# Type Hints in Python

### Why should we care about types?
* It makes the code way more readable
* Simplify bug finding
* Code editors can take advantage of types for code completion
* Makes refactoring easier

### Important releases regarding type hints:
* Python < 3.5 - Type hints are comment based
* Python 3.5 - Function type hints was released
* Python 3.6 - Variable type hints was released
* Python 3.7 - Future annotations was released (It must be placed before all other imports)
* Python 3.8 - TypedDict was added
* Python 3.9 - No need anymore to import the *typing* module for standard types, it is now incorporated
* Python 4.0 - Future annotations will supposedly be incorporated without needing import

### How to use Type Annotations - Example
```
from typing import List

x: List[int] = [1, 2, 3, 4]
y: str = "hello"
```

### Variable Type Annotations (Python version < 3.6) - Example
```
from typing import List

x = [1, 2, 3, 4] # type: List[int] 
```

### More examples type hints
```
from typing import Callable, List, Dict, Any

def my_func1(my_string: str, my_int: int) -> int:
    ...

def my_func(func: Callable, my_list: List[int]) -> List[int]):
    ...

def my_func2(my_dict: Dict[Any, int]) -> Dict[Any, int]:
    ...
```

### None
The None type is compatable with everything. So if this creates problems, implement an if statement such as:
```
def my_func(value: int) -> int:
    if not value:
        # Handle None input
    ...
```

#### How to specify multiple types? Use *union*!
*value* can be either int or float.
```
from typing import Union

def my_func(value: Union[int, float]) -> int:
    ...
```

#### Optional
*Optional[int]* is the same as *Union[int, None]*. Generally, we should try to avoid returning Optional, since then the user of the return value need to check if the value actually exists. 
```
from typing import Optional

def my_func(id: int) -> Optional[int]:
    ...
```

#### Overload decorator - Speficy Optional return
The overload functions are purely for telling the type checker the return type based on the input type. 
```
from typing import Optional, overload

def my_func(id: Optional[int]) -> Optional[int]:
    ...

@overload
def my_func(id: int) -> int:
    pass

@overload
def my_func(id: None) -> None:
    pass

```

### Forward referencing
We cannot use type hints for classes that is not been created yet. The example below a class called *MyClass* that tries to type hint the return type of the function *my_func*:
```
class MyClass:
    def my_func(self) -> MyClass:
        return Bar()
```

This will not work out of the box since MyClass does not exist yet. 

However, we can achieve this by doing *forward referencing*, which essentially is delaying the evaulation 

### Known issues
Cyclic dependenies may occur when importing classes from other files - Example A.py imports B.py and B.py import A.py. 

The solution is shown below with:
```
from typing import TYPE_CHECKING
if TYPE_CHECKING:
    from myOtherFile import MyClass
```

### Type hints for User Defined Classes cross files
There is not an elegant way of handling that. The best approach seems to:
```
from typing import TYPE_CHECKING
if TYPE_CHECKING:
    from myOtherFile import MyClass

# Type hint of a user defined class from other file
def my_func() -> MyClass:
    ...
```

Alternativly, we can import all user defined classes within a single file **my_class_types.py** containing all types within the project. And future annotation import if python version supports it:
```
from __future__ import annotations
from typing import TYPE_CHECKING
if TYPE_CHECKING:
    from myOtherFile1 import MyClass1
    from myOtherFile2 import MyClass2
    from myOtherFile3 import MyClass3
    ...
```

And then import *my_class_types* within all other scripts. 
```
from my_class_types import *
```
