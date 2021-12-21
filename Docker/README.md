
# Docker
* Docker’s native platform is Linux, as it’s based on features provided by the Linux kernel. 
* Docker is currently the most popular container platform. 
* A container is not a full virtual machine (A container uses the host machine kernel) and uses less resources. 
* Docker logic can be added on top of an existing docke image. 
* *Hub.docker.com* is a place to find images that has been distributed. 



# Normal Flow in Docker
* Create a Dockerfile (or download an existing Dockerfile) 
* Build the Dockerfile into an Image (or download an existing Image by pulling from Docker Hub)
* Run a container using the Image
* Stop the container



# Image
* An image is a package containing necessary information to run the application with the required configuration as container(s). 
* Images are defined using a ***dockerfile***, which is a list of steps (terminal commands) to setup the environment.



# Difference between Image and Contianer
* Images are frozen immutable snapshots of live containers. Containers are running (or stopped) instances of some image. 



# Dockerfile
* Dockerfiles enable you to create your own images and contains a set of instructions (terminal commands) that specify what environment to use and which commands to run. 
* In the dockerfile, we can specify the source file that will be run in the docker container. 
```
FROM <base-image>
ENV NAME <name-of-env>
RUN <run linux command>

ADD <host-machine-src-path> <dest-path-in-container>
PORT <port-to-listen-to>
WORKDIR <set-working-directory>
```
* **FROM** tells Docker which image we base our image on. 
* **ENV**: sets environment variables. 
* **RUN**: runs a command in container. 
* **ADD / COPY**: ADD and COPY are similar. It allow us to copy files or directories from host machine into the Docker image. It takes source and destination path. 
* **WORKDIR**: set working directory in the container. 
* **VOLUME**: create mount point for a volume. 
* **CMD**: tells Docker to execute the command when the image loads. 



# Commands in Docker

### Build Image using a Dockerfile
```
docker build . -t name:tag
```
Example:
```
docker build . -t ubuntu:latest
```

### Download Image from Docker hub
```
docker pull \<docker-image-from-docker-hub\>:\<version\>
```

### List all running containers
```
docker ps
```

### List all running and stopped containers
```
docker ps -a
```

### List all Images
```
docker images
```

### Stop container
```
docker stop \<container-name\>
```

### Stop all containers
```
docker stop $(docker ps -q)
```

### Start a stopped container
```
docker start \<container-id-or-name\>
```

### Run Docker Image
*Non-interactive mode*
```
docker run \<image-name\>
```

*Interactive mode*
```
docker run -it \<image-name\>
```
* *NB: windows require "winpty" before the command to run in interactive mode*

*Interactive mode as Daemon*
```
docker run -it -d \<image-name\>
```

*Interactive mode + run command in running container*

Example of running the "bash" command in a running comtainer:
```
docker exec -it jupyter-notebook bash
```

### Remove container
```
docker rm \<container-name-or-id\>
```

### Remove all containers
```
docker rm $(docker ps -a -q)
```

### Remove Image
```
docker rmi \<image-name-og-id\>
```
Or use the command:
```
docker image rm \<image-name-og-id\>
```

### Remove all Images
```
docker rmi $(docker images -q)
```

### Run docker-compose file
```
docker-compose up -d
```

### Copy file into docker container
```
* docker cp foo.txt mycontainer:/foo.txt
```

### Get logs from container
```
docker logs
```

### Create a new Image from a modified container
*NB: image name must be lowercase*
```
docker commit \<container-name\> \<image-name\>
```

