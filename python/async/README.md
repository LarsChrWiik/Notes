
# Async
* Supported in Python 3.5+
* Async is **not multithreading**
* Async is **not multiprocessing**
* Used to prevent idling the thread when doing **API calls** tasks or **IO** tasks + do not need to use the results immediately
* We can use async if we need to run multiple API calls, for example in a loop. We can start all requests, then await all responses.
* Async allows concurrency within the same **thread** - meaning that no additional thread is created (saves time since no thread needs to be created)
* Async provides a more controlled task switching environment compared to traditional Python threads (where interpreter switching between threads can be expensive)
* Remember that threading in Python is inefficient due to the **GIL** (Global Interpreter Lock)
* Note that task switching only starts when we encounter an **await**.


### Async basics
There are three main types of awaitable objects:
* `Coroutine`: is an async function
* `Tasks`: a wrapped `Coroutine` using `asyncio.create_task()`
* `Futures`: as an awaitable result of an async function. These allow callback functionallity.


### Async is different that threading
Threading in Python is inefficient due to the **GIL** (Global Interpreter Lock) and cannot run in parallel (Python threads are using the same core). Additionally, Python uses an interpreter switch between threads that can make it slower too.

Async is not creating a new thread, but rather executing code sequentually in multiple places by switching between work within the same thread. The power of async comes with the fact that we can start an API call or an IO operation, and then continue with others things until we really need the result of the API or require the IO operation to be completed. And we can do all of this without using time to create a new thread and only do task switching when we need to.


### "Await" in Python
* Signals that its safe to run another job/coroutine while we wait for the result.


### How to run an async function
```python
import asyncio

async def my_async_func(i):
    print(f"start {i}")
    await asyncio.sleep(1)
    print(f"end {i}")

for i in range(3):
    asyncio.run(my_async_func(i))
```


### Async - How to start multiple requests

```python
async def ccc():
    x1 = aaa()
    x2 = bbb()
    await x2
    await x1
```
In the example above **aaa()** will not start before **bbb()** has completed.

To start **aaa()** and **bbb()** together and then wait for both, we can do:
```python
async def ccc():
    x1 = await aaa()
    x2 = await bbb()
```


### Event loop
* The event loop is the core of every asyncio application
* The event loop runs async tasks, perform IO, network, run subprocesses, etc


### What about treading?
* In theading, we usually end up requiring locking - and risk deadlocking
* Creating threads create overhead and context switching
