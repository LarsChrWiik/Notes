
# Async
* Supported in Python 3.5+


### What is a synchronous program?
* A program that is executed one step at a time in a sequential sequence.


### What is an asynchronous program?
* Runs one execution step at a time (similar to synchronous programs)
* Asynchronous programs run on a single thread as well (similar to synchronous programs)
* Asynchronous may not wait for an execution step to finish


### When to use asynchronous pattern?
We can use the asynchronous functions to prevent wasting time waiting for other functions/services to complete/respond. An example would be if we do a call to database, then the CPU becomes idle waiting for a reply.

One example if if a web server want to do batch processing. We really do not want the API wait for the batch job to complete, since that usually takes long time. We would rather start the job asynchronously and then return "job created" to the user.


### Event loop
* The event loop is the core of every asyncio application
* The event loop runs async tasks, perform IO, network, run subprocesses, etc
* 


### What about treading?
* In theading, we usually end up requiring locking - and risk deadlocking
* Creating threads create overhead and context switching


### Blocking vs. non-blocking code
We need to think differently when we develop asynchronous programs.


### What is not Async
* Async is not multithresding
* Async is not multiprocessing


### Await in Python
* `await` forces the asynchronous function to wait to resolve the seleted line
* Signals that its safe to run another job/coroutine while we wait for the result

There are three main types of awaitable objects:
* `Coroutine`: is an async function
* `Tasks`: a wrapped `Coroutine` using `asyncio.create_task()`
* `Futures`: as an awaitable result of an async function. These allow callback functionallity.


### Example of starting async job and await afterwards
```Python
import asyncio

async def myFunc():
    return 42

my_future = myFunc()
done, pending = await my_future
```
