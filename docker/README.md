
# Docker
* Docker’s native platform is Linux, as it’s based on features provided by the Linux kernel.
* Docker is currently the most popular container platform.
* A container is not a full virtual machine (A container uses the host machine kernel) and uses less resources.
* *Hub.docker.com* is a place to find images that has been distributed.


## Normal flow in Docker
* Create a Dockerfile (or download an existing Dockerfile)
* Build the Dockerfile into an Image (or download an existing Image by pulling from Docker Hub)
* Run a container using the Image
* Stop the container


## Image vs. Container
* An image is a package containing necessary information to run the application with the required configuration as container(s)
* Images are defined using a ***dockerfile***, which is a list of steps (terminal commands) to setup the environment
* Images are frozen immutable snapshots of live containers, while containers are running (or stopped) instances of some image



## Dockerfile
* Dockerfiles enable you to create your own images and contains a set of instructions (terminal commands) that specify what environment to use and which commands to run.
* In the dockerfile, we can specify the source file that will be run in the docker container.

```docker
FROM <base-image>
ENV NAME <name-of-env>
RUN <run linux command>

ADD <host-machine-src-path> <dest-path-in-container>
PORT <port-to-listen-to>
WORKDIR <set-working-directory>
```

* **FROM** tells Docker which image we base our image on.
* **ENV**: sets environment variables.
* **RUN**: runs a command in container. There can be multiple RUN commands in a dockerfile.
* **ADD / COPY**: ADD and COPY are similar. It allow us to copy files or directories from host machine into the Docker image. It takes source and destination path.
* **WORKDIR**: set working directory in the container.
* **VOLUME**: create mount point for a volume.
* **CMD**: tells Docker to execute the command when the image loads. There can only be one CMD command, which is the final command.



## Commands in Docker


## Create / Get

### Build Image using a Dockerfile
```bash
docker build . -t name:tag
```
Example:
```bash
docker build . -t myImageName:latest
docker build -t <package>:<new-image-name> <location-of-dockerfile>
```
```bash
docker build -t myDockerFile .
```
```bash
docker build . -t myImageName:latest --build-arg myEnvVariable=value
```
* To force re-build with no cache, then use "--no-cache"

### Download Image from Docker hub
```bash
docker pull myDockerImageFromDockerHub:latest
```


## List

### List all running containers
```
docker pull <docker-image-from-docker-hub>:<version>
```

### List all running containers
```bash
docker ps
```

### List all running and stopped containers
```bash
docker ps -a
```

### List all Images
```bash
docker images
```


## Run

### Run Docker Image
*Non-interactive mode*
```bash
docker run myImageName
```

### Run Docker Image
*Non-interactive mode*
```bash
docker run \<image-name\>
```

*Interactive mode*
```bash
docker run -it myImageName
```
* *NB: windows require "winpty" before the command to run in interactive mode*

*Interactive mode + detach*
```bash
docker run -it -d myImageName
```

*Interactive mode + run command in running container*

Example of running the "bash" command in a running comtainer:
docker run -it <image-name>
```
* *NB: windows require "winpty" before the command to run in interactive mode*

*Interactive mode as Daemon*
```bash
docker run -it -d <image-name>
```

### Run with environment variable
```bash
docker run -e API_KEY="secret" myImageName
```
```bash
docker run --env-file ./.env myImageName
```

### Run docker-compose file
```bash
docker-compose up -d
```


## Start

### Start a stopped container
```bash
docker start myContainerIdOrName
```


## Stop

### Stop container
```bash
docker stop myContainer
```

### Stop all containers
```bash
docker stop $(docker ps -q)
```


## Remove

### Remove container
```bash
docker rm myContainerIdOrName
```

### Remove all containers
```bash
docker rm $(docker ps -a -q)
```

#### Remove all stopped containers
```bash
docker container prune
```

### Remove Image
```bash
docker rmi myImageIdOrName
```
Or use the command:
```bash
docker image rm myImageIdOrName
```

### Remove all Images
```bash
docker rmi $(docker images -q)
```


## Other

### Copy file into docker container
```bash
* docker cp foo.txt mycontainer:/foo.txt
```

### Get logs from container
```bash
docker logs
```

#### Create a new Image from a modified container
*NB: image name must be lowercase*
```bash
docker commit myContainerName myImageName
```

### SSH into container
```bash
docker exec -it bash
```
```bash
docker exec -it jupyter-notebook bash
```
