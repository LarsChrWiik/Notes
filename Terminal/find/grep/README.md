
# Grep
Global regular expression print

### Example
```
grep "Lars" names.txt
```

### Options for grep
* -**w**: Means return the excact word
* -**in**: Will show the line with the match
* -**B**: Shows n lines before the match
* -**A**: Shows n lines after the match

### How to run grep in a directory
```
grep "Lars" ./*
```
```
grep "Lars" ./*.txt
```

### Pipe with grep
```
names.txt | grep "Lars"
```

### grep options
* **-E**: (--extended-regexp) extends grep regex.
* **-P**: (--perl-regexp) Perl modifier for perl regex. 
* **-o**: Shows only what is matching the grep.

### Regular expression
Mac uses **BSD grep**, while Linux uses **GNU-grep**.
We can see this with:
```
grep -V
```

The mac version of grep does not support the *Perl Compatible Regular Expressions* in the same way as the Linux version does. But it is possible to install grep GNU on a mac using HomeBrew.
```
brew install grep --with-default-names
```

### Non-greedy match
Grep doesn't support non-greedy modifiers by default. But we can use the Perl modifier **-P** to allow this:

**problem**: How to grep on lines with "client=\<someword\>" and then "/".

The problem with this task is that grep will return the earliest match, which might be "client=myClient/folder1/folder2/folder3" if there are multiple backslashes after client. But we want "client=myClient"

We can solve this by "**?**" from Perl to allow non-greedy modifiers.
The command to get the shortest match is:
```
grep -P -o client=.+?\/ out.txt
```

And to get unique values, we can do:
```
grep -P -o client=.+?\/ out.txt | sort | uniq
```
