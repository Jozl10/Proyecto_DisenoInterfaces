
package Vistas;

import java.sql.*;

//Patron de diseno singleton, nos servira para solo poder cerar una sola instancia en todo nuestro programa, esto con el fin 
//de evitar que se creen muchas conexiones, con este patron siempre usaremos la misma instancia (conexion) duarnte todo 
//el prograa y evitara que dejemos muchas conexiones abiertas, lo que afectaria el rendimiento de neustro programa
public class SingletonConexion {

    //cremoas una variable del la clase conexion, la cual ya exportamos, y emepazara nulla
    private static Connection conn = null;

 
    // el constructor de la clase lo ponemos provado, con el fin de que se puedan crear nuevas  instancias 
    //de esta forma: new(), y solo podremos cerar la instancia por medio de un metodo de la clase
    private SingletonConexion(){
        
        //intentamos la conexion a la base de datos
        try{
            //senalando el driver
            Class.forName("org.sqlite.JDBC");
            //relizando la conexion a nuestra base de datos de sqlite, idnicando su direccion
            conn = DriverManager.getConnection("jdbc:sqlite:src/Vistas/Altas y bajas DB.db");
            
            
        }
        //en caso de un error 
        catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    } // Fin constructor
 
    // Método por el cual crearemos la unica intsancia
    public static Connection conectarse(){//sera publica, por lo que podemos accder a ella desde cualquier parte de nuestro 
        //programa
  //si no se a utulizado antes este metodo, se creara la instancia
        if (conn == null){
            new SingletonConexion();
        }
  // y nos devolvera la misma instancia tipo conexion, con la conexion relizada, 
        return conn;
    } // Fin getConnection
    
  
}    