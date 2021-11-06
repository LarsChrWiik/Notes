# Regex
Pattern matching in text.

### Search using Regex in text editors
There are usually a button (**.\***) indicating to allow regex mattern matching. VSCode, for example, allows this.

## Syntax

### General syntax
* . = anything
* \d = digit in 0123456789
* \D = non-digit
* \w = word (letters and digits)
* \W = non-word
* space = space
* \t = tab
* \r = return
* \n = new line
* \s = whitespace (space, \t, \r, \n)
* \S = non-whitespace
* X* = 0 or more repetitions of X (this will allow non-matching!)
* X+ = 1 or more repetitions of X
* X? = 0 or 1 instance of X
* X{m} = exactly *m* instances of X
* X{m,} = at least *m* instances of X
* X{m,n} = Between *m* and *n* (inclusive) instances of X
* ^ = beginning of string
* $ = end of string
* \b = word boundary (meaning beginning or end of word)
* \B = non word boundary
* (X|Y) = = X or Y
* [A-Z] = uppercase characters
* [a-z] = lowercase characters
* /ABC/i = case insensitive for word ABC

### Special characters
{}, [], (), ^, $, ., |, *, +, ?, (- inside [])
These characters have special meaning in Regex, and they needs to be escaped with \

Example:
If we wish to search for an actally dot, we can excape it with a backslah "\."

Matching on larswiik.com:
```
larswiik\.com
```

And if we wish to search for an actally bashslash, we can excape it with another backslah "\\"

### Lazy vs greedy
Regex is usualy greedy, to be fast. Some regex engines support the "?" symbol to make the queries lazy instead of greedy.

Example, given the sentences:
```
That is exactly what I mean!!!
```
* "\be.*\b" match on:
That is **exactly what I mean**!!!
* "\be.*?\b" match on:
That is **exactly** what I mean!!!

## Examples:

#### Match the word "Lars" within a huge string:
```
sfjdksljfksdlLarsfkldjflksdfl
```
Solution: \BLars\B
sfjdksljfksdl**Lars**fkldjflksdfl

#### Match words that start with an or ae:
```
You and I are entertainers!
```
Solution: \b(a|e)n.*?\b
You **and** I are **entertainers**!

#### Match words that ends with "ing" and ignore case difference
```
Everything is SOMETHING for someone!
```
Solution: \b\S*ing\b
**Everything** is **SOMETHING** for someone!
Note: VsCode has its own button for case sensitivity
