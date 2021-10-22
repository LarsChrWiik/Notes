# Python Packaging
See: https://packaging.python.org/glossary


## Overview / History
See: https://www.pypa.io/en/latest/history/
* **Year 2000 - Distutils**: Old tool for packaging through setup.py. 
* **Year 2003 - PyPi**: Python Package Index (PyPi) released, which is an index for Python packages. 
* **Year 2004 - Setuptools**: Better version of distutils + easy_install.
* **Year 2008 - Pip**: Replacement for easy_install. 
* **Year 2013 - Wheels**: Support for building and installing wheel files were added. 
* **Year 2014 - Automatic pip**: Pip becomes dominant from Python 3.4. Pip no longer require setuptools to install wheels.
* **Year 2017 - Pipenv**: The new Pipenv tool stated to be the recommended Python packaging tool, but then no release in 2 years.
* **Year 2020 - Pip dependency resolver**: Pip 20.3 added dependency resolver feature.



## Distutils
Distutils (distribution utilities) is the **dinosaur** tool that helps Python packages (mainly non-pure-python packages) to install. 

Distutils packages contain by convention a **setup.py** file, a **source distribution**, and a **binary distribution**. 

Distutils was added in Python 1.6 in year 2000.

Most Python users does **not want to use distutels directly**, but rather **Setuptools**. 



## Setuptools
Setuptools is an enhanced/newest version of **Distutils**. Setuptools also tried to do dependency resolution and supports application plugin systems.

EasyInstall is a package manager bundled with setuptools used to install libraries basedon the eggs format. *pip* has replaced setuptools.

**pip** runs all scripts with setuptools by default, even files that imports distutils.



## Setup file
**setup.py** is a python file that indicates that the project is a distributable package.

A basic setup file look like this: 
```python
from distutils.core import setup
setup(
    name='my_module_name',
    version='1.0',
    py_modules=['my_module_name'],
)
```

Avoid calling the setup file directly. Rather install the package using the setup file with:
```bash
pip install .
```

Dependency requirements are usually within the setup.py using the **install_requires** keyword. setup.py should declare the loosest possible dependency versions that are still workable. The **requirements.txt**, on the other hand, is a deployment file that defines the installation job. The **install_requires** section looks very similar to the **requirements.txt** file:
```python
install_requires = [
   'A>=1.1,<2.5',
   'B>=0.61'
]
```

It is not considered good practice to pin dependencies to spesific versions, or specifying transitive dependencies - reason is to allow the user the benefit of dependency upgrades.

**requirements.txt** are thought of as a list of requirements for a python environment, while the **install_requires** list is thought of as a list of dependencies for project. **requirements.txt** files often contain pinned versions used by repeatable build scripts, while **install_requires** should be as broad as possible. We can also use lock files to ensure repeatable builds instead of relying on open source versions not being modified.

### setup.cfg
TODO


## Source Distribution
Source distribution file format (sdist) are generated using:
```bash
python setup.py sdist
```
Source distribution contains metadata to install the package.



## Built distribution
Built distributions contains files and metadata that only need to be moved to the correct lib location for the project. An example of a built distribuiton format is *wheel*. 



## Wheel file format
Wheel files makes installing your package for your end user much easier.

A Python *.whl* file is essentially a ZIP file with the *.whl* filename. **A wheel is a pre-built distribution format**, meaning it is ready to be installed and do not need to be built from source (sdist) - so no special compiler is needed. Wheel files are smaller in size compared to source distributions, meaning less networking traffic.

To create a wheel file from setup.py, run:
```bash
python setup.py bdist_wheel
```

### Types of wheels
There are sessentially **3 types of wheels**:
* Universal (suppoerted by Python2 and 4)
* Pure-Python (Supports either Python 2 or 3)
* Platform (Supported by a platform). 

You can read from the wheel name what type of wheel we are looking at - see {python} and {platform} in "Wheel naming convention". 

### Wheel naming convention
A wheel filename has the following format:
```bash
{dist}-{version}(-{build})?-{python}-{abi}-{platform}.whl
```

The `py2.py3-none-any.whl` is very common to use.

Example:
```bash
chardet-3.0.4-py2.py3-none-any.whlwhl
```
* chardet = package name
* 3.0.4 = package version
* py2.py3 = it supports Python 2 and 3
* none = no ABI
* any = any platform

Advanced Example:
```bash
cryptography-2.92-cp35-abi3-macosx_10_9_x86_64.whl
```
* cryptography = package name
* 2.9.2 = package version
* cp35 = Python version (menaing CPython 3.5)
* abi3 = ABI (meaning the "application binary interface", in this case for Python C API, since we are using CPython)
* macosx_10_9_x86_64 = platform


## Egg format
Egg is a built distribution format that came with setuptools, with filetype *.egg*. *.egg* files are actually a *.zip* file with some metadata.

**"Eggs are to Pythons as Jars are to Java"**.

Egg files are being replaced by wheel files.



## Wheel vs. Egg
