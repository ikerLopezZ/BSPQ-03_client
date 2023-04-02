# BSPQ-03_client

A continuación se indican los comandos que puedes ejecutar en la línea de comandos para lanzar el cliente de la aplicación "DeustoTickets".

Limpiar el cliente por si hubiera algún problema. 

      mvn clean

Compilar el programa.

      mvn compile
      
Si el servidor está lanzado y funcionando correctamente, existe la opción de ejecutar el programa desde línea de comando. Para ello, hay que introducir el siguiente comando:

    	mvn exec:java -Dexec.mainClass="com.deustotickets.app.App"	

*Nota: Para ejecutar el programa, no es estrictamente necesario seguir estos pasos. Se puede ejecutar directamente desde el editor de texto. 