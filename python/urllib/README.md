# Urllib
Urllib is a built in Pyhton module that can be used for working with URLs. 

### urllib.request
Simply opening and reading URLs as HTML:
```python
urllib.request.urlopen("https://google.com").read()
```

### Json
The Json library can be used for serialization and deserialization.

**How to send and recieve Response between client and server**:
```python
url = "https://api.mywebsite.com/api/v1?api_key=" + "api_key_123"
headers = {"Content-Type": "application/json"}
body = {
    ...
}
data = json.dumps(body).encode("utf-8")
request = urllib.request.Request(url=url, headers=headers, data=data)
response = urllib.request.urlopen(request)
response_content = json.loads(response.read().decode("UTF-8"))
```
