package Negocio.Control;

/**
 *
 * @author vgremlin
 */
public class Persona {
    
    public String identificacion;
    public String nombres;
    public String apellidos;
    public String fechaNac;
    public String telefono;
    public String celular;
    
    public Persona (){}
    
    public Persona ( String identificacion, String nombres, String apellidos, String fechaNac,String telefono,String celular){
        this.identificacion=identificacion;
        this.nombres=nombres;
        this.apellidos=apellidos;
        this.fechaNac=fechaNac;
        this.telefono=telefono;
        this.celular=celular;
        
        
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCelular() {
        return celular;
    }

}
