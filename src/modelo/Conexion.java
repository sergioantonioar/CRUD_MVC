package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author SERGIO
 */

//Luego de crear la clase conexion, importamos la libreria para la conexion a la BD
public class Conexion {
    public static final String URL = "jdbc:mysql://localhost:3306/escuela?autoReconnet=true&useSSL=false"; // buena practica
    public static final String USUARIO = "root";
    public static final String CONTRASENA = "admin";
    
    public Connection getConnection(){
        Connection conexion = null;
        
        try {
            //conexion a la BD
            //Class.forName("com.mysql.cj.jdbc.Driver"); //obsoleta : com.mysql.jdbc.Driver
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            
        } catch (Exception e) {
            System.out.println("Error, "+e);
        }
        return conexion;
    }
}
