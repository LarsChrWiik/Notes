
# Itertools.count
Can be used to create complex iterators.

### Require 1 additional iteration
Since itertools.count require 1 more iteration before it finishes.
But it still result in the same list as a result.

But a problem arise when we try to use a `zip` with a fized size list and a generator that uses itertools.count. **In this case, the additional iteration is never completed and the generator is not completed**.

```python
from itertools import count

def f():
    for i in count():
        print("itertools.counter =", i)
        value = i*i
        if value >= 3:
            break
        yield value

l1 = [-1, -2]

for i, j in enumerate(f()):
    print(f"{l1[i]}, {j}")
print("\n")

for i, j in zip(l1, f()):
    print(f"{i}, {j}")
print("\n")


"""
Result:

itertools.counter = 0
-1, 0
itertools.counter = 1
-2, 1
itertools.counter = 2


itertools.counter = 0
-1, 0
itertools.counter = 1
-2, 1
"""
```
