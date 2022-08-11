
# Django migration
* Migrations works as version control of the database schema.
* Django migrations allow the user to modify/migrate Django models (that corresponds to Database tables) and will change the database schema.
* All model changes are added in a migration (even it does not affect the database) since we want to be able to reconstruct all fields correctly.
* Each migration depend an another migration.
* Migrations are per-app
*

### Commands
* **makemigrations**: Create a migration file according to changes in Django models.
    * `--name`: to name the migration something meaningful
* **migrate**: Do the migration.
* **sqlmigrate**: display the SQL that will be run when migrating.
* **showmigrations**: list the projects migrations.


### File location
Migration scripts should be in:
`myProject/apps/myApp/migrations`.


### Backend support
* **PostgreSQL**: The most capable choice due to schema support.
* **MySQL**: Does not support atomic transaction when migrating. Lacks some support for schema changes. MySQL will fully reqrite the table for almost all schema operations - making it slow. MySQL also has some limit on the number of indexes.
* **SQLite**: More of a learning tool for Django and should not be used in production systems. It has very little built-in schema support - it creates new tables when altering.


### Django migrations
``` bash
# Scan changes in Django models
python manage.py makemigrations
# Creates: myAppName/migrations/0027_auto.py
```
```bash
# Run the migration
python manage.py migrate
```
```bash
# revert to migration number "0026"
python manage.py migrate myAppName 0026
```

### Atmoic migration scripts
On databases that support DDL transactions (SQLite and PostgreSQL) migrations will run as an atomic transaction by default. MySQL or Oracle will not use atomic.

To force migrations to not use an atomic transaction we can use:
```python
class Migration(migrations.Migration):
    atomic = False
    ...
```

### Migration scripts
PostgreSQL supports atomic transaction when migrating, but does not allow you to mix schema changes and data changes in the same transaction.

Attempting to do both within a single migration/transaction will result in an error.

