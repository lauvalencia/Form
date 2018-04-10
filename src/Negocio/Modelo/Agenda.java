package Negocio.Modelo;
import Negocio.Control.Persona;
import java.awt.Component;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author vgremlin
 */
public class Agenda {
    Vector vector = new Vector();
    Persona persona=new Persona();
    
    
    public void GuardarPersona(Persona persona){
        vector.add(persona);
            JOptionPane.showMessageDialog(null, "Se ha agregado correctamente la persona");
        }
    
    public String MostrarAgenda(){
        String Linea="",Linea2;
        for(int x=0; x<vector.size();x++){
            persona=(Persona)vector.get(x);
            Linea2=persona.identificacion + " - " + persona.nombres + " - " + persona.apellidos + " - " + persona.fechaNac + " - " +" - " + persona.telefono + " - " + persona.celular;
                    
            Linea=Linea + Linea2 + "\n";
        }
        return Linea;
    }
     
        public String Buscar(String seleccion, String identificacion){
        seleccion = JOptionPane.showInputDialog(null,"Input dialog",JOptionPane.QUESTION_MESSAGE);
        String datos = null;
        for(int x=0; x<vector.size();x++){
            if(persona.identificacion.equals(seleccion)){
                persona=(Persona)vector.get(x);
                datos = persona.identificacion + " - " + persona.nombres + " - " + persona.apellidos + " - " + persona.fechaNac + " - " +  " - " + persona.telefono + " - " + persona.celular; 
                JOptionPane.showMessageDialog(null, datos);
                 
            }
            else{
                JOptionPane.showMessageDialog(null, "El documento no esta agregado");
            }
        }
        return "";
    }
        
    public void Eliminar(){
        
    }
}