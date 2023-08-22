# REST API's RESTFul do 0 à AWS c. Spring Boot 3 Java e Docker
### Rodar MySQL Local
    $ docker-compose up
### Configuração de Conexão
    
    # Caso o ip já esteja em uso, redefini-lo no arquivo docker-compose.yml"
    host: localhost
    port: 3306
    banco: rest_with_spring_boot_udemy
    senha: admin123

### Comandos para rodar as migrations do flyway via terminal

    # Acessa o projeto via terminal e roda o projeto
    mvn clean package spring-boot:run
    # Ou desta forma para pular os testes
    mvn clean package spring-boot:run -DskipTests

    # Ou acessa o projeto via terminal e roda apenas as migrations
    mvn flyway:migrate

### Comando para gerar o .jar
    # Pelo terminal acesse a pasta do arquivo pom.xml do projeto e executo o comando abaixo
    mvn clean package -DskipTests

### Comando para subir a aplicação via docker-compose
[![Docker Hub Repo](https://img.shields.io/docker/pulls/jefersont/rest-with-spring-boot-erudio.svg)](https://hub.docker.com/repository/docker/jefersont/rest-with-spring-boot-erudio)
    
    # Pelo terminal acesse a pasta do arquivo docker-compose.yml do projeto e executo o comando abaixo
    docker-compose up -d --build

### Dockerizando a Aplicação
[![Continuous Integration with Github Actions](https://github.com/jefersont/udemy-rest-with-spring-boot-and-java-erudio/actions/workflows/continuous-integration.yml/badge.svg)](https://github.com/jefersont/udemy-rest-with-spring-boot-and-java-erudio/actions/workflows/ACTION_SCRIPT_FILENAME.yml)
Ao realizar o teste local, ajusta o workdir no application.yml(Test) apenas para `Code/UploadDir`

    