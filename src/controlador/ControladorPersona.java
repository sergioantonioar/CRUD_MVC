package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.JOptionPane;
import modelo.ConsultasPersona;
import modelo.Persona;
import vista.VistaPersona;

/**
 *
 * @author SERGIO
 */
public class ControladorPersona implements ActionListener{ //Para relacionar con la vista
    private VistaPersona vista;
    private Persona persona;
    private ConsultasPersona modelo;

    public ControladorPersona(VistaPersona vista, Persona persona, ConsultasPersona modelo) {
        this.vista = vista;
        this.persona = persona;
        this.modelo = modelo;
        
        //Se indica de donde se utilizará el ActionListener
        vista.botonInsertar.addActionListener(this);
        vista.botonLimpiar.addActionListener(this);
        vista.botonBuscar.addActionListener(this);
        vista.botonModificar.addActionListener(this);
        vista.botonEliminar.addActionListener(this);
    }
    
//    public void iniciar(){
//        vista.setTitle("CRUD MVC");
//        vista.setLocationRelativeTo(null);
//        vista.campoID.setVisible(false); //para que no sea visible
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //se usa el objeto e de ActionEvent
        if(e.getSource() == vista.botonInsertar){ //si desde la vista se a seleccionado o presionado el botonInsertar
            persona.setClave(vista.campoClave.getText()); //se obtine de vista y se guarda en el objeto persona
            persona.setNombre(vista.campoNombre.getText());
            persona.setDomicilio(vista.campoDomicilio.getText());
            persona.setCelular(vista.campoCelular.getText());
            persona.setCorreo_electronico(vista.campoCorreoElectronico.getText());
            persona.setFecha_nacimiento(Date.valueOf(vista.campoFechaNacimiento.getText()));
            persona.setGenero(vista.comboGenero.getSelectedItem().toString());
            
            if(modelo.insertar(persona)){ //si la insercion de la persona fue correcta
                JOptionPane.showMessageDialog(null, "Registro insertado correctamente");
                limpiarCampos(); // luego de insertar
            }else{
                JOptionPane.showMessageDialog(null, "Error al insertar registro");
                limpiarCampos(); // luego de insertar
            }
        }
        if(e.getSource() == vista.botonLimpiar){
            limpiarCampos();
        }
        if(e.getSource() == vista.botonBuscar){
            persona.setClave(vista.campoBuscar.getText());
            
            if(modelo.buscar(persona)){ //si existe
                vista.campoID.setText(String.valueOf(persona.getIdPersona()));
                vista.campoClave.setText(persona.getClave());
                vista.campoNombre.setText(persona.getNombre());
                vista.campoDomicilio.setText(persona.getDomicilio());
                vista.campoCelular.setText(persona.getCelular());
                vista.campoCorreoElectronico.setText(persona.getCorreo_electronico());
                vista.campoFechaNacimiento.setText(String.valueOf(persona.getFecha_nacimiento()));
                vista.comboGenero.setSelectedItem(persona.getGenero());
            }else{
                JOptionPane.showMessageDialog(null, "No existe una persona con esa clave");
                limpiarCampos();
            }
        }
        if(e.getSource() == vista.botonModificar){
            
            persona.setIdPersona(Integer.parseInt(vista.campoID.getText()));
            persona.setClave(vista.campoClave.getText()); 
            persona.setNombre(vista.campoNombre.getText());
            persona.setDomicilio(vista.campoDomicilio.getText());
            persona.setCelular(vista.campoCelular.getText());
            persona.setCorreo_electronico(vista.campoCorreoElectronico.getText());
            persona.setFecha_nacimiento(Date.valueOf(vista.campoFechaNacimiento.getText()));
            persona.setGenero(vista.comboGenero.getSelectedItem().toString());
            
            if(modelo.modificar(persona)){
                JOptionPane.showMessageDialog(null, "Registro modificado correctamente");
                limpiarCampos();
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo modificar el registro");
                limpiarCampos();
            }
        }
        
        if(e.getSource() == vista.botonEliminar){
            persona.setIdPersona(Integer.parseInt(vista.campoID.getText()));
            
            if(modelo.eliminar(persona)){
                JOptionPane.showMessageDialog(null, "Registro eliminado correctamente");
                limpiarCampos();
                
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro");
                limpiarCampos();
            }
        }
    }
    
    public void limpiarCampos(){
        vista.campoID.setText(null);
        vista.campoBuscar.setText(null);
        vista.campoClave.setText(null);
        vista.campoNombre.setText(null);
        vista.campoDomicilio.setText(null);
        vista.campoCelular.setText(null);
        vista.campoCorreoElectronico.setText(null);
        vista.campoFechaNacimiento.setText(null);
        vista.comboGenero.setSelectedIndex(0);
    }
    
    
}
