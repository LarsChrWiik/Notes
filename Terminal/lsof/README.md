
# lsof
List open files and the process that uses them. 

### Example
To view the port associated with a daemon:
```
lsof -i -n -P
```

### -i
Means: Filter on network connections. 

### -n
Means: Do not resolve hostnames (no DNS). This will make the command faster to run. 

### -P
Means: Display port number in the NAME colunn. 
