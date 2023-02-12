# IO vs CPU bound


### CPU bound
A CPU bound task is a task that requires a lot of CPU power to complete. For example, a task that requires a lot of calculations.


### IO bound
An IO bound task is a task that requires a lot of IO to complete. For example, a task that requires a lot of API calls, database queries, or file operations.


### CPU blocking
A task is CPU blocking if it monopolizes the CPU. This means that the CPU is not able to do other things while the task is running. This can result in slower performance, decreased system responsiveness, and can even cause the system to become completely unresponsive if the blocked processes are important system processes.

An example is when we need rendering together with a lot of calculations. If we do the calculations in the main thread, the rendering will be blocked and the UI will not be responsive. This is because the main thread is blocked by the calculations.


### CPU Throttling
CPU throttling, also known as dynamic frequency scaling or CPU slowdown, is the practice of slowing down the clock speed of a computer's central processing unit (CPU) in order to conserve energy and reduce heat. This is achieved by reducing the voltage and clock speed of the CPU, which in turn reduces its performance. This is done when the CPU is not being used to its full capacity, and is therefore not using all of its power. This is done by the CPU itself, and is not something we can control.

Throttling is typically implemented by the operating system or system firmware, and can be triggered by a number of factors such as high CPU temperatures, low battery levels, or high system load.

The goal of throttling is to prevent the CPU from overheating and to extend the battery life.


