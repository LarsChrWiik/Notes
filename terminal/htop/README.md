# htop
* Needs to be installed, for example using brew.


### How to find memory usage of a process
Find process with:
```sh
ps aux | grep <process name>
```
Then use the PID to find the memory usage of the process:
```sh
htop -p <PID>
```
The column `RES` means the memory usage of the process in KB.
To get MB, divide by 1000.
