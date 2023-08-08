# REST API's RESTFul do 0 à AWS c. Spring Boot 3 Java e Docker
### Rodar MySQL Local
    $ docker-compose up
### Configuração de Conexão
    
    # Caso o ip já esteja em uso, redefini-lo no arquivo docker-compose.yml"
    host: 172.21.0.2
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
### TESTE