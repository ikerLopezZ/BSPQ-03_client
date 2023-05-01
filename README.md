# BSPQ-03_client

A continuación se muestran los comandos que se deben ejecutar en la línea de comandos para lanzar el cliente de la aplicación "DeustoTickets".

Limpiar los archivos y directorios generados por Maven durante su compilación. 

      mvn clean

Compilar el proyecto.

      mvn compile
      
En caso de que se prefiera lanzar el cliente dese la línea de comandos, siempre y cuando se haya ejecutado previamente el proyecto servidor y este funcione correctamente, ejecutar el siguiente comando:

      mvn exec:java -Dexec.mainClass="com.deustotickets.app.App"	

*Nota: Para ejecutar el programa, no es estrictamente necesario seguir estos pasos. Es posible ejecutar el cliente directamente desde el entorno de desarrollo integrado (IDE) utilizado.

Comando para ejecutar las pruebas unitarias:

      mvn test