# Drango folder structure

### Example
```bash
├── __init__.py
├── management  # Base manage commands
│   ├── __init__.py
│   └── commands
│       ├── __init__.py
│       ├── my_custom_command.py
├── apps  # All apps are in this folder
│   ├── __init__.py
│   ├── my_app_name
│   │   ├── __init__.py
│   │   ├── apps.py  # Set additional application configuration for the app
│   │   ├── admin.py  # Registering models to be accessible from the Django admin panel
│   │   ├── management  # App based manage commands
│   │   │   ├── __init__.py
│   │   │   └── commands
│   │   │       ├── __init__.py
│   │   │       ├── ...
│   │   ├── migrations  # History of migrations.
│   │   │   ├── __init__.py
│   │   │   ├── 0001_initial.py
│   │   │   └──...
│   │   ├── models.py  # Django models that are stored in the database
│   │   ├── mutations.py  # Django mutation for this model
│   │   ├── signals.py  # Cross app notification triggers (ex. post_save and pre_delete)
│   │   ├── tasks.py
│   │   ├── tests
│   │   │   ├── __init__.py
│   │   │   ├── conftest.py
│   │   │   ├── test_training_data.py
│   │   │   └── test_views.py
│   │   ├── types.py
│   │   ├── urls.py
│   │   └── views.py
│   ├── my_other_app_name
│   │   ├── __init__.py
│   │   └── ...
├── utils
│   ├── __init__.py
│   ├── auth.py
│   ├── errors.py
│   ├── validators.py
│   └── ...
├── settings
│   └── ...
├── tests
│   └── ...
├── logging.py
├── urls.py
├── views.py
```
