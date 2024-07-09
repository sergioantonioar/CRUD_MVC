package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

public class ConsultasPersona extends Conexion {

    PreparedStatement ps; //para consultas
    ResultSet rs; //para obtener datos

    //comprobar si la insercion fue correcta
    public boolean insertar(Persona persona) { //recibe como parametro de Persona
        Connection conexion = getConnection(); //establecer conexion a la BD
        try {
            ps = conexion.prepareStatement("insert into persona (clave,nombre,domicilio,celular,correo_electronico,fecha_nacimiento,genero) values (?,?,?,?,?,?,?)"); //lo que se va insertar

            //llenando las ?
            ps.setString(1, persona.getClave());
            ps.setString(2, persona.getNombre());
            ps.setString(3, persona.getDomicilio());
            ps.setString(4, persona.getCelular());
            ps.setString(5, persona.getCorreo_electronico());
            ps.setDate(6, persona.getFecha_nacimiento()); //tipo Date
            ps.setString(7, persona.getGenero());

            int resultado = ps.executeUpdate();

            if (resultado > 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            System.err.println("Error, " + e);
            return false; //si ocurre exception
        } 
        //Agregar finally para cerrar conexion. Siempre se ejecutara
        finally {
            try {
                conexion.close();
            } catch (Exception e) {
                System.err.println("Error, " + e);
            }
        }
    }
    
    public boolean buscar(Persona persona) { 
        Connection conexion = getConnection(); 
        try {
            ps = conexion.prepareStatement("select * from persona where clave = ?");
            ps.setString(1, persona.getClave());
            rs = ps.executeQuery();
            
            if(rs.next()){ //si se encontro contenido
                persona.setIdPersona(rs.getInt("idPersona"));
                persona.setClave(rs.getString("clave"));
                persona.setNombre(rs.getString("nombre"));
                persona.setDomicilio(rs.getString("domicilio"));
                persona.setCelular(rs.getString("celular"));
                persona.setCorreo_electronico(rs.getString("correo_electronico"));
                persona.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                persona.setGenero(rs.getString("genero"));
                
                return true;
            }else{
                return false;
            }
            
        } catch (Exception e) {
            System.err.println("Error, " + e);
            return false; //si ocurre exception
        } 
        //Agregar finally para cerrar conexion. Siempre se ejecutara
        finally {
            try {
                conexion.close();
            } catch (Exception e) {
                System.err.println("Error, " + e);
            }
        }
    }
    
    public boolean modificar(Persona persona) { 
        Connection conexion = getConnection(); 
        try {
            ps = conexion.prepareStatement("update persona set clave=?,nombre=?,domicilio=?,celular=?,correo_electronico=?,fecha_nacimiento=?,genero=? where idPersona=?"); //lo que se va modificar

            //llenando las ?
            ps.setString(1, persona.getClave());
            ps.setString(2, persona.getNombre());
            ps.setString(3, persona.getDomicilio());
            ps.setString(4, persona.getCelular());
            ps.setString(5, persona.getCorreo_electronico());
            ps.setDate(6, persona.getFecha_nacimiento()); //tipo Date
            ps.setString(7, persona.getGenero());
            ps.setInt(8, persona.getIdPersona());

            int resultado = ps.executeUpdate();

            if (resultado > 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            System.err.println("Error, " + e);
            return false; //si ocurre exception
        } 
        //Agregar finally para cerrar conexion. Siempre se ejecutara
        finally {
            try {
                conexion.close();
            } catch (Exception e) {
                System.err.println("Error, " + e);
            }
        }
    }
    
    public boolean eliminar(Persona persona) { 
        Connection conexion = getConnection(); 
        try {
            ps = conexion.prepareStatement("delete from persona where idPersona=?");
            ps.setInt(1, persona.getIdPersona());
            

            int resultado = ps.executeUpdate();

            if (resultado > 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            System.err.println("Error, " + e);
            return false; //si ocurre exception
        } 
        //Agregar finally para cerrar conexion. Siempre se ejecutara
        finally {
            try {
                conexion.close();
            } catch (Exception e) {
                System.err.println("Error, " + e);
            }
        }
    }
}
