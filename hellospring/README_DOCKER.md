# Dockerizovani aplikace:

## Nejjednodussi, ale ve firme to asi nepouzijete:

    mvn clean spring-boot:build-image
    docker run --rm -it -p 9090:9090 hellospring:0.0.1-SNAPSHOT

## Nepekne pomoci Dockerfile:

    mvn clean package
    docker build --tag hellospring2 .
    docker run --rm -it -p 9090:9090 hellospring2

## Nejspravnejsi pomoci JIB Maven Plugin:

    mvn clean compile jib:build

- POZOR!!! JIB automaticky provadi push do Docker registry

Docker registry:

- Docker Hub (nejjednodussi, ale free je pouze public)
- Github
- Gitlab
