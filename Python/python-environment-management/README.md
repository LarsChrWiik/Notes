
# Python's Virtualenv
We can use virtualenv in Python to create isolated Python environments. This is nice to isolate dependencies for seach projects we are working on.

Virtualenv works by installing files in a directory and then modifying the PATH environment variable to point to the custom bin directory in the virtualenv folder structure. A copy of Python is also within the environment, and Python will look for libraries where python is installed. 

To organize your python environments, it is normal to store them within a spesific `Environments` folder, for example at `~/Environments`.

See: https://packaging.python.org/guides/installing-using-pip-and-virtual-environments/



## Create a virtualenv (Python 2)
Unlike Python 3, Python 2 does not include virtualenv my default. Install with:
```bash
pip install virtualenv
```

Then create virtualenv with:
```bash
virtualenv -p <path-to-python> envName
```

*NB: The pain with this approach is that we need to install different Pyhton versions on out computer to be able to create that spesific Python version.*



## Create a virtualenv (Python 3)
Virtualenv is included in Python 3 and is called `venv`.
```bash
python3 -m venv <env-name>
```

To create a venv for a spesific Python version, we need to install that version first.

*NB: The pain with this approach is that we need to install different Python versions on out computer to be able to create that spesific Python version.*



## Usefull commands when working with virtualenvs
To enter an environment:
```bash
source <path-to-env>/bin/activate
```

When we enter a virtualenv, the `python` command from the terminal will point to the python within the virtualenv. We can check this with:
```bash
which python
```

#### How to install packages:
```bash
pip install <packageName>
```
or:
```bash
python3 -m pip install <packageName>
```

#### How to install spesific packages version:
```bash
pip install pandas==1.3.3
```

#### How to install from `requirements.txt`
```bash
pip install -r requirements.txt
```

#### Show installed packages:
```bash
pip freeze
```

#### Exit virtualenv:
```bash
deactivate
```



## Pyvenv
pyvenv (NOT `pyenv`) is a script for Python 3, but was deprecated in Python 3.6. It was replaced with
```bash
python3 -m venv
```



## Virtualenvwrapper
virtualenvwrapper is an extention of virtualenv and is a nice tool when working with mutiple virtualenvs. 



## Conda
Conda is Python package management system for multiple langauges (Python included - and was originally created for Python spesifically). Conda works as an alternative to PIP (Preferred Installer Program), which is the default package manager for Python packages.

Conda is also an environment manager, which allows users to run different versions of Python. 

Conda package and environment managers are included in all versions of *Anaconda* and *Miniconda*. 

#### Anaconda vs. Miniconda
**Anaconda** is a full distribution of software from PyData (includes hunderes of third party packages), while **Miniconda** is only an installer for a conda environment where the users needs to install packages themself. 

#### List installed packages
```bash
conda list
```

#### List all conda envs
```bash
conda env list
```
OR
```bash
conda info --envs
```

#### How to activate conda env
```bash
conda activate <env-name>
```
OR
```bash
conda activate <path-to-env>
```

#### How to create env with conda
```bash
conda create --name <myenv>
```

#### Create env with spesific Python version
```bash
conda create -n myenv3.6.7 python=3.6.7
```

#### How to create env in a spesific location
```bash
conda create --prefix ./myenv python=3.8.0
```

#### How to install packages with conda
This will create a env in the default location for conda on the computer.
```bash
conda install -n myenv scipy=0.15.0
```

#### How conda channel
```bash
conda config --show channels
```

#### How to install packages from different conda channel
```bash
conda install -c <channel-name> <package>
```

#### How to add channel to conda permanently
NB: Channels are added to conda globally, not only for the env.
```bash
conda config --add channels <channel-name>
```

#### environment.yml
TODO



## Pyenv + Pyenv-virtualenv
**Pyenv** is used to manage multiple versions of Python on a single machine. The Python versions are stored in `~/.pyenv/shims`. 

Pyenv looks in 4 places to decide which version of Python to use, in priority order:
* PYENV_VERSION
* .python-version (file in current directory)
* First found .python-version file in each parent directory until root
* The global python version

How to set python version (create .python-version file):
```bash
pyenv local 3.4.0
```

**Pyenv-virtualenv** can be used to create virtualenv with pyenv. 

#### List all virtualenvs
```bash
pyenv virtualenvs
```

#### Activate virtualenv
```bash
pyenv activate <env-name>
```

#### Remove / Delete virtualenv
```bash
pyenv uninstall <env-name>
```



## Pyenv-virtualenvwrapper
Allows virtualenvwrapper commands when using pyenv environments. 



## Pipenv
Combines `Pipfile`, pip, and virtualenv into one tool. pipenv is meant to be used when developing Python applications, not libraries. An alternative to pipenv is `poetry`.

Pipfile allows us to store lock files for our dependencies to make sure we use the excact same dependencies. 



## poetry
Poetry is kind of like Maven (in Java) for Python, in other words, a build management tool. With Poetry, we ca build, package and publish our application. Among others, it allows us to write lock files. It also gives insite into dependecies. 
