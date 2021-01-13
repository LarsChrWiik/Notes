
# Setup
**setup.py** is a python file that indicates that the module/package in the repository is distributed with **Distutils**.
**Distutils** is a mechanism to distribute Python packages and extensions provided in the Python standard library since Python 1.6.

Avoid calling the setup file directly.
To install the package using the setup file, run:
```
pip install . 
```

Requirements are usually within the setup.py.
**requirements.txt** therefore needs to point to the setup file to allow installation through the requirements file.
```
# Read dependencies from setup.py in same folder
.
```
