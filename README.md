# REST API's RESTFul do 0 à AWS c. Spring Boot 3 Java e Docker
### Rodar MySQL Local
    $ docker run --name some-mysql -e  MYSQL_DATABASE=rest_with_spring_boot_udemy -e MYSQL_ROOT_PASSWORD=admin123 -d mysql:5.7
### Configuração de Conexão
    host: 172.17.0.2
    port: 3306
    banco: rest_with_spring_boot_udemy
    senha: admin123