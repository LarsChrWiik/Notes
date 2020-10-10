
# MyPy
**MyPy** is an optional static type checker - similar to **PyLint**.

Website: http://mypy-lang.org/
Github: https://github.com/python/mypy

### Type check third party libraries
MyPy uses stub files. If a third party library dies not have a stub file, we can ignore type checking with:
```
import someRandomLibrary # type: ignore
```

We can also create a mypy.ini file and spesifcy globally which libraries we should ignore type checking from. 
```
[someRandomLibrary.*]
ignore-missing-imports = True
```

To skip analyzing all third party libraries with missing stubs, run my by with:
```
mypy --ignore-missing-imports .
```
