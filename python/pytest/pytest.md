
# Pytest



### Conftest
**conftest.py** is a file that is automatically run the pytest and will be shared for all tests in the same folder and subfolders.

We can have one big conftest or smaller conftests in different test folders to prevent slow startup.

The conftest file usually contains:
* Fixtures
* Helper functions
* Hooks


### Fixture
* **@pytest.fixture**
* Fixtures are run before test functions
* Used to feed predefined / objects to tests such as database connections, URLs, and input data
* The name of the function will become the parameter in the test using the fixture
* Fixtures are usually defined in **conftest.py**.

```python
import pytest

@pytest.fixture
def input_value():
    input = 39
    return input

def test_divisible_by_3(input_value):
    # input_value = 39
    assert input_value % 3 == 0
```

### monkeypatch fixture
**monkeypatch** is a predefined fixture that is used to set/delete ENV variables or to remove sys.path for importing.

```python
def set_API_KEY(monkeypatch):
    api_key = 'test-api-key'
    monkeypatch.setattr('myModule.myPythonFile.API_KEY', api_key)
```


### caplog fixture
Built in fixture in logging that changes the log level.
```python
def test_foo(caplog):
    caplog.set_level(logging.INFO)
    pass
```

### Hooks
See: https://docs.pytest.org/en/6.2.x/reference.html#hooks

Example:
```python
def pytest_runtest_setup(item):
    """ called before ``pytest_runtest_call(item). """
    #do some stuff`
```
