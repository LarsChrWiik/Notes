
# Tox
https://tox.readthedocs.io/en/latest/

### What is Tox used for?
Tox is used to automate python testing.

### What is Tox?
Tox is generic virtualenv management and test command line tool.

Tox can do the following:
* Run your tests easily
* Tests installation of the package for different pythion versions

### How to install Tox?
```
pip install tox
```

### How to setup tox?
* Create a *tox.ini* file
* Add your desired test logic in tox.ini

### Example
```
[tox]
envlist = py27,py36

[testenv]
deps=
    pytest==3.0.4
    -rrequirements.txt
```
