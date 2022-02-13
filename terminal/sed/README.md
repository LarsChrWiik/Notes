
# Sed
SED stands for Stream EDitor and is used to apply function on a data stream, and is often used for the search and replace functionallity.
With SED, we can manipulate files without opening them. 

NB: Sed does not modify the actual file, but rather outputs the result to stdout.

### Subtitute / Replace "s/" and "/g"
Pattern:
```
sed 's/X/Y/' myfile.txt
```
Where X is the word to replace, and Y is the replacing word.

### Modify the original file "-i"
```
sed -i 's/X/Y/' myfile.txt
```

### Regex
TODO

### Regex with parameters
TODO

## Examples

### Replacing the first word instance "Lars" with "Mr. Lars" in each line in the file *xyz.txt*.
Input file:
```
Lars was here.
Lars is cool. This is another line that Lars wrote.
```
Solution:
```
sed 's/Lars/Mr. Lars/' xyz.txt
```
Outputs:
```
Mr. Lars was here.
Mr. Lars is cool. This is another line that Lars wrote.
```

## Replacing all instances of "Lars" with "Mr. Lars" on the file *xyz.txt*.
Input file:
```
Lars was here.
Lars is cool. This is another line that Lars wrote.
```
Solution:
```
sed 's/Lars/Mr. Lars/g' xyz.txt
```
Outputs:
```
Mr. Lars was here.
Mr. Lars is cool. This is another line that Mr. Lars wrote.
```

### Remove everything before the regex match "2021-08-17.*"
```
cat res2.txt | sed 's/^.*\(2021-08-17.*\)".*$/\1/' > res3.txt
```
