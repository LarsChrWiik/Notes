
# Supervisord / Suvervisor
* Supervisord is an older technology that has been around for a while since early 2000s.
* Supervisor (or Supervisord) is a process control system for Unix-like operating systems.
* Supervisor is a software project that includes the Supervisord process and a commandline tool called supervisorctl.
* It is used to manage multiple processes on a Unix-like operating system, such as Linux or macOS.
* By using Supervisord, you can start, stop, and restart these processes as needed, monitor their status, and automatically restart them if they crash.


### Supervisord vs. Docker and Docker Compose
While Docker and Supervisord both serve similar purposes in managing and monitoring processes, they have some important differences. Docker provides a containerization solution, allowing you to package an entire application and its dependencies into a single container that can be easily deployed across different environments. Supervisord, on the other hand, focuses specifically on managing individual processes and does not provide containerization.

Some points:
* Supervisord is an older technology that has been around for a while.
* Docker and Docker Compose is a newer technology that is more modern and is used more often today.
* But if you need to manage and monitor individual processes on a Unix-like system, then Supervisord may be a better choice.
