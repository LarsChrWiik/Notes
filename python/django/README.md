
# Django
Django is a tool for building web application with Python. It simplifies web development by including essential packages. Django provides the following several features, among others:
* Admin page
* Authentication
* Caching
* Object relational mapper

### Django best practice
* Let the frontend handle the HTML rendering with for example (React, Angular, or Vue), while the Django backend handles the data.
* Let Django become the application API.

### MVT pattern
* **Model**: Database data handling (Automatic SQL). Model logic is stored in `models.py` files.
* **View**: The API endpoints. `urls.py` routes each request URL to the correct view that handles the request and return the response. View logic is stord in `view.py`. If we want to use Django as a standalone API, the we only need to return the JSON response in the views without caring about templates.
* **Template**: A dynamic web page / text file (like an HTML file).


### Install
```shell
pip install django djangorestframework
```

### Create project
```shell
django-admin startproject myProjectName
```

Will create:
* manage.py
* settings.py
* urls.py
* and more

### Create Django app
We need a Django app to create views or models for example.
```
python manage startapp myAppName
```

### Run server
```shell
python manage.py runserver 8000
```

### URLs and Views
`urls.py` recieve the request URL and decides what function to run in `views.py`. The response is then sent to the browser.

### Django views as API
Django views can be used similar to a Flask endpoint.
```python
from django.views.generic.base import View
from django.http.response import JsonResponse

class GetMyCustomView(View):
    def get(self, request, *args, my_custom_parameter_1: str, **kwargs):
        if my_custom_parameter_1 not None:
            return JsonResponse({"We have an error"}, status=400)
        my_data = my_custom_server_function()
        return JsonResponse({'data': my_data}, status=200)
```

### Django request validation
We can validate Django requuest with `Model`.

Models can be stored in a folder called `models` within the spesific Django app.

```python
from django.db import models

class MyCustomModel(models.Model):
    class MyInternalEnums(models.TextChoices):
        Val1 = 'A'
        Val2 = 'B'

    # DB ForeignKey
    variable1 = models.ForeignKey(AnotherModel, on_delete=models.CASCADE, related_name='OtherVariable')

    name = models.CharField(choices=MyInternalEnums.choices, max_length=50, default=MyInternalEnums.Val1.value)

    # Unique combination
    class Meta:
        unique_together = ('variable1', 'name')
```


**urls.py**:
```python
from django.conf.urls import url
from django.contrib.urls import admin

urlpatterns = [
    url('admin/', admin.site.urls),
    urls(r'^about/$',)
    urls(r'^$',)  # home page
]
```


### Django backend


