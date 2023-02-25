# Springboot
Repositorio Springboot
El repositorio "Springboot" es una aplicación de ejemplo creada con el framework Spring Boot en Java. Spring Boot es un framework de desarrollo de aplicaciones Java que facilita la creación de aplicaciones web y servicios RESTful.

Este repositorio es un proyecto de código abierto y está disponible públicamente en GitHub. Contiene una aplicación web básica con funcionalidades como registro de usuarios, inicio de sesión y creación de publicaciones.

## Estructura del repositorio
El repositorio está estructurado de la siguiente manera:

La carpeta "src" contiene todo el código fuente de la aplicación.
La carpeta "resources" contiene los archivos de configuración y otros recursos necesarios para la aplicación.
La carpeta "test" contiene las pruebas unitarias para la aplicación.
El archivo "pom.xml" es el archivo de configuración de Maven para la aplicación.

## Cómo ejecutar la aplicación
Para ejecutar la aplicación, primero debes tener instalado Java en tu computadora. Luego, sigue estos pasos:

1. Clona el repositorio en tu computadora usando el comando git clone https://github.com/Ftorresnun/Springboot.git.
2. Abre una terminal en la carpeta raíz del repositorio.
3. Ejecuta el comando mvn spring-boot:run para iniciar la aplicación.
4. Abre un navegador web y visita la dirección http://localhost:8080 para ver la aplicación en acción.
![plot](./images/1.png)
5. Con la aplicacion abierta se pueden ver 2 opciones para jugar la primera es un wordle normal y corriente, en el que al escribir una palabra con el maximo de letras permitido te muestra cuales letras son las que estan dentro de la palabra en amarillo pero no en la posicion, rojo si no esta dentro de la palabra correcta y verde si esta en la palabra y en la posicion correcta. Tambien si al fallar la palabra te indica los intentos que te quedan
![plot](./images/2.png)
6. Cuando pierdes todas tus intentos, te indica que has perdido y muestra la palabra correcta.
![plot](./images/3.png)
Ademas puedes buscar tu intento ingresando el numero del intento.
![plot](./images/4.png)
Y cuando ganas te lo indica, con la capacidad de seguir buscando tus anteriores intentos
![plot](./images/5.png)
7. La segunda opcion del menu es el modo contrarrelog en el que funciona igual que el juego anterior pero tienes 60 segundos para encontrar la solucion y al acabar el tiempo te indica que perdiste como en el juego normal
![plot](./images/6.png)
![plot](./images/7.png)

## Contribuciones
Este repositorio es un proyecto de código abierto y se aceptan contribuciones de cualquier persona interesada en mejorar la aplicación.

## Licencia
Este repositorio está bajo la Licencia MIT, lo que significa que puedes usar, modificar y distribuir el código fuente de la aplicación para cualquier propósito, incluso para proyectos comerciales, siempre y cuando se incluya la atribución adecuada.
