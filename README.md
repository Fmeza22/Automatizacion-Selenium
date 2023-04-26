####Automatizacion-Selenium
####Descripción: Automatización a nivel de interfaz Web para el sistema Trello, se tendrán en cuenta los siguientes test:
Login con usuario y password
Crear un nuevo Tablero
Añadir una lista al nuevo Tablero
Si el escenario falla tome una captura de pantalla

####Requsitos del entorno:
Navegador Google Chrome Versión 112.0.5615.138

En el archivo config.properties se encuentran definidas las variables Globales que nos permiten realizar los 
test requeridos, son las siguientes y su respectivo uso:
url_base= La url del sitio que queremos automatizar, en este caso la de trello
username= correo del usuario (previamente registrado en la plataforma)
password_user= contraseña del usuario   
nameTablero= nombre deseado al tablero de prueba
nameLista = nombre deseado a la lista de prueba
nameTarjeta= nombre deseado a la tarjeta de prueba

,Luego de asignar los valores a la variable, podrá ejecutar el proyecto.
