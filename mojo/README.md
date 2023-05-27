# Mojo
* Mojo is designed as a superset of Python.
* Mojo combines the usability of Python with the performance of C.
* Mojo is designed for both systems programming and AI development.
* Mojo can run existing Python ecosystem of packages.
* Mojo Provide predictable low-level performance and low-level control.
* Mojo is 100% import compatible with Python because it uses CPython for interoperability (Can use CPython runtime environment and its features).
* Although you can still use dynamic types just like in Python, Mojo also allows you to use strong type checking in your program.


### What is CPython?
* By default, when you run normal Python code using the standard Python interpreter, it is executed by CPython.
* CPython is the default and most widely used implementation of Python.
* It is responsible for interpreting and executing Python code.
* It takes the Python source code as input, compiles it into bytecode, and then executes the bytecode using the Python Virtual Machine (PVM).
* It is written in C and provides runtime environment and interpreter for executing Python code.
* Other implementations of Python, such as Jython, IronPython, PyPy, and others, exist as well.


### Basic Syntax
* **let**: Immutable declaration.
* **var**: Mutable declaration.


### Static dispatching
* In statically typed languages, the types of variables, parameters, and return values are known and checked at compile time.
* Static dispatch takes advantage of this type information to resolve method calls at compile time, which can lead to more efficient code execution.
* Static dispatching offers Performance, Predictability, and Optimization opportunities.
* However, it lacks the flexibility provided by **dynamic dispatch**.
* Dynamic dispatch is commonly associated with polymorphism and is often used in object-oriented programming languages.


### Struct
* Similar to a class.
* But are staitically bound at compile time.
* All instance properties in a `struct` **must** be explicitly declared with a `var` or `let` declaration.
* **Struct fields are bound statically**:
    * Structs aren't looked up with a dictionary indirection.
    * Meaning that the pointers between the fields and their values within the struct are established at compile time and do not change during runtime.
    * In many programming languages, when you access a field of an object or struct, it typically involves a lookup process, often using a dictionary or hash table to map the field name to its value.
    * As such, you cannot `del` a method or reassign it at runtime.

    * This enables the Mojo compiler to perform guaranteed static dispatch, use guaranteed static access to fields, and inline a struct into the stack frame or enclosing type that uses it without indirection or other overheads.

```py
struct MyPair:
    var first: Int
    var second: Int

    fn __init__(inout self, first: Int, second: Int):
        self.first = first
        self.second = second
```


### Strong typing
* A struct definition in Mojo defines a compile-time-bound name and is one of the primary ways to employ strong type checking.


### fn vs. def
* **def**: is designed to be very dynamic where arguments are mutable, local variables are declared on first use, and where scope is not enforced.
* **fn**: is designed to be very static. Acts like a "strict" version of `def`. Aruments are immutable, require type spesification. No return type is inferred as None, but it still allows the return of `object`.
* There is nothing a def can provide that a fn cannot (or vice versa)


### Importing Python modules
```py
from PythonInterface import Python

# This is equivalent to Python's `import numpy as np`
let np = Python.import_module("numpy")

# Now use numpy as if writing in Python
array = np.array([1, 2, 3])
print(array)
```


### SIMD
* Represents a small vector.
* SIMD allows a single instruction to be executed across the multiple data elements of the vector.
* The size of the SIMD vector needs to be a positive number and a power of 2.

https://docs.modular.com/mojo/MojoStdlib/SIMD.html


### DType
* **address**: = address Represents a pointer type whose bitwidth is the same as the bitwidth of the hardware’s pointer type (32-bit on 32-bit machines and 64-bit on 64-bit machines).
**bool**: bool Represents a boolean data type.
**f16**: f16 Represents a floating point value whose bitwidth is 16.
**f32**: f32 Represents a floating point value whose bitwidth is 32.
**f64**: f64 Represents a floating point value whose bitwidth is 64.
**f8**: f8 Represents a floating point value whose bitwidth is 8.
**index**: index Represents an integral type whose bitwidth is the maximum integral value on the system.
**invalid**: invalid Represents an invalid or unknown data type.
**si16**: si16 Represents a signed integer type whose bitwidth is 16.
**si32**: si32 Represents a signed integer type whose bitwidth is 32.
**si64**: si64 Represents a signed integer type whose bitwidth is 64.
**si8**: si8 Represents a signed integer type whose bitwidth is 8.
**type**: dtype
**ui16**: ui16 Represents an unsigned integer type whose bitwidth is 16.
**ui32**: ui32 Represents an unsigned integer type whose bitwidth is 32.
**ui64**: ui64 Represents an unsigned integer type whose bitwidth is 64.
**ui8**: ui8 Represents an unsigned integer type whose bitwidth is 8.

https://docs.modular.com/mojo/MojoStdlib/DType.html


## Pyhton vs Mojo - Calculate prime numbers

### Python
```py
%%python
import math
def pyhton_is_prime(x):
    if x in [0, 1]:
        return True
    for i in range(2, math.ceil(math.sqrt(x))):
        if x % i == 0:
            return False
    return True
```
```py
%%python
import time
time_start = time.time()

last = -1
for i in range(0, 5000000):
    if pyhton_is_prime(i):
        last = i

time_end = time.time()
time_taken = time_end - time_start

print("PYTHON : Time spent MS:", time_taken * 1000)
print("Last = ", last)
```
Results:
```
Last prime number =  4999999
PYTHON : Time spent MS: 29682
```

### Mojo

```py
from Math import sqrt, ceil
from DType import DType

fn mojo_is_prime(x: Int) -> Bool:
    if x == 0:
        return True
    if x == 1:
        return True
    let root_x = sqrt[1, DType.f32](x)
    let root_x_ceil = ceil[1, DType.f32](root_x).cast[DType.ui16]().to_int()
    for i in range(2, root_x_ceil):
        if x % i == 0:
            return False
    return True
```
```py
from Time import now
let eval_begin: Int = now()

let lll = []
var latest = -1
for i in range(0, 5000000):
    if mojo_is_prime(i):
        latest = i

let eval_end: Int = now()
print("latest =", latest)
print("MOJO : Time spent MS:", (eval_end - eval_begin) // 1000000)
```
Results:
```
Last prime number = 4999999
MOJO : Time spent MS: 1999
```
