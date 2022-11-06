# Security in Django


### REST api
* Using SSL/TLS for security is a must
* Add permissions / role checks
* A normal user shouldn’t be able to access information of another user or an admin. Or guess their ID.
    * Add filters: https://www.django-rest-framework.org/api-guide/filtering/
    * Return 404 instead of 401 or 403 when an attacker is fishing for IDs / Primary keys (pk)
    * Use `PrimaryKeyRelatedField` in Serializers and filer on the `user`.
    * Do not sens IDs in urls.
    * Use UUIDs do IDs cannot be guessed
