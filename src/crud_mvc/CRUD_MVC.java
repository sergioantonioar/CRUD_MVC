package crud_mvc;

import controlador.ControladorPersona;
import modelo.ConsultasPersona;
import modelo.Persona;
import vista.VistaPersona;

/**
 *
 * @author SERGIO
 */
public class CRUD_MVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        VistaPersona vista = new VistaPersona();
        Persona persona = new Persona();
        ConsultasPersona modelo = new ConsultasPersona();
        ControladorPersona controlador  = new ControladorPersona(vista, persona, modelo);
        
        //controlador.iniciar();
        vista.setVisible(true);
    }
    
}
