
# Async
* Supported in Python 3.5+
* Async is **not multithreading**
* Async is **not multiprocessing**
* Async is used to prevent idling the thread when doing **IO** tasks such as API calls, file operations, etc.
* We can use async if we need to run multiple API calls, for example in a loop. We can start all requests, then await all responses
    * NB: Make sure to use a library that supports async, for example **aiohttp**, not **requests**
* Async allows simulated concurrency within the same **thread** - meaning that no additional thread is created (This saves time since no thread needs to be created)
* Async provides a more controlled task switching environment compared to traditional Python threads (where interpreter switching between threads can be expensive)
* Remember that threading in Python is inefficient due to the **GIL** (Global Interpreter Lock)
* Note that task switching only starts when we encounter an **await**.


### Event loop
Yes, asyncio has a built-in existing event loop. When you run an asyncio program, the event loop is automatically created and managed for you. You can access the event loop using `asyncio.get_event_loop()`.

In Python asynchronous programming, the **event loop** is at the center of everything. The event loop is responsible for executing tasks, such as coroutines, that are scheduled with the event loop's schedule method.

In some cases it might be good to create multiple event loops. For example, if you want to run two different event loops in parallel, you can create two event loops and run them in separate threads. This is useful if you want to run two different applications in parallel.

Most used event loop functions:
* `asyncio.get_event_loop()`: returns the current event loop
* `asyncio.set_event_loop()`: sets the current event loop
* `asyncio.run()`: runs a coroutine
* `asyncio.create_task()`: creates a task from a coroutine
* `asyncio.gather()`: waits for multiple coroutines to complete


### Threads, Processes, GIL, and Async
Creating a **thread** in any programming language can be more expensive than executing a task in a single thread due to the overhead involved in creating and managing the threads. All threads run within the same process and share the same memory space.

Thread overhead in Python is especially true since the **GIL prevents multiple threads within the same process from executing in parallel**. This is why Python threads are not a good solution for CPU-bound tasks. A better solution for CPU-bound tasks is to use **multiprocessing** instead of threading. The multiprocessing module provides a way to run multiple processes in parallel, each with its own Python interpreter and memory space. This allows CPU-bound tasks to run in parallel on multiple cores, without the limitations imposed by the GIL.

If we use **async**, we can start multiple tasks using `asyncio.create_task()` and then await them all at once using `asyncio.gather()`. This is much more efficient than creating a thread for each task and then waiting for all threads to complete.


### Async basics
There are three main types of awaitable objects:
* `Coroutine`: is an async function
* `Tasks`: a wrapped `Coroutine` using `asyncio.create_task()`
* `Futures`: as an awaitable result of an async function. These allow callback functionallity.


### Async is different that threading
Threading in Python is inefficient due to the **GIL** (Global Interpreter Lock) and cannot run in parallel (Python threads are using the same core). Additionally, Python uses an interpreter switch between threads that can make it slower too.

**Async is not creating a new thread**, but rather executing code sequentually in multiple places by switching between work within the same thread. The power of async comes with the fact that we can start an API call or an IO operation, and then continue with others things until we really need the result of the API or require the IO operation to be completed. And we can do all of this without using time to create a new thread and only do task switching when we need to.


### "Await" in Python
* Signals that its safe to run another job/coroutine while we wait for the result.
* Multiple async tasks should be created using `asyncio.create_task()` and then awaited using `asyncio.gather()`.


### asyncio.create_task()
* Creates a task from a coroutine
* Returns a `Task` object
* The task is scheduled to run soon
* The task is not started immediately


### asyncio.gather()
* Waits for multiple coroutines to complete
* Returns a `Future` object
* The `Future` object will contain a list of the results of the coroutines


### How to run an async function
```python
import asyncio

async def my_async_func():
    print(f"start")
    await asyncio.sleep(1)
    print(f"end")

asyncio.run(my_async_func())
```


### Async - How to start multiple requests
```python
async def myfunc():
    x1 = asyncio.create_task(aaa())
    x2 = asyncio.create_task(bbb())

    result1, result2 = await asyncio.gather(x1, x2)
```
In the example above **aaa()** and **bbb()** will asyncronously start together, and then we will wait for both to complete before continuing.


### Library support of async
It is important that the library we use supports async, before we can use async await on its function. For example, **requests** does not support async, but **aiohttp** does. This is beacuse the internal source code of requests is not async, and therefore we cannot use async await on it. This is because the source code is not awaiting the API response and releasing the thread to do other things.


### Async - aiohttp vs requests
* **aiohttp** is a library that supports async
* **requests** is a library that does not support async

Example of using **aiohttp**:
```python
import asyncio
import aiohttp

async def fetch_data(url):
    async with aiohttp.ClientSession() as session:
        async with session.get(url) as response:
            return await response.json()

async def main():
    url1 = "https://jsonplaceholder.typicode.com/posts/1"
    url2 = "https://jsonplaceholder.typicode.com/posts/2"

    # Run the two fetch_data calls asynchronously
    data1 = asyncio.create_task(fetch_data(url1))  # Could also use "await fetch_data(url1)"
    data2 = asyncio.create_task(fetch_data(url2))  # Could also use "await fetch_data(url2)"

    # Wait for both tasks to complete
    result1, result2 = await asyncio.gather(data1, data2)
    print(result1, result2)

asyncio.run(main())
```


### Common mistakes
Not awaiting the returns of the API.
This will lead to a blocking call, and the code will not run async since each call will wait for the return of the API call to be able to call ".json" on it.
Example:
```python
async def fetch_data(url):
    async with aiohttp.ClientSession() as session:
        async with session.get(url) as response:
            return response.json()  # <--- Not awaiting the return
```
