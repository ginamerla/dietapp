# dietapp
Creacion de un plan de alimentacion semanal
## Descripcion
Esta aplicacion genera un plan semanal con las comidas elegidas y su lista de compras
##Como correr en maven
ejecutar comando: 

    mvn clean install
    
## Como correr el servicio en local
1.- Primero debemos compilar la aplicacion ejecutando el comando:

    mvn clean package
    
2.- Una vez que se haya generado el .war file, ahora si podemos correr la aplicacion usando el spring boot command:

    mvn spring-boot:run
    
3.- Para verificar si el servicio esta corriendo, podemos revisar este endpoint:
    http://localhost:8080/healthcheck
    
4.- Tenemos otro endpoint de prueba, donde se ejecuta una consulta en "memoria" de un usuario, si se hace esta llamada:
http://localhost:8080/api/v1/usuarios/1

