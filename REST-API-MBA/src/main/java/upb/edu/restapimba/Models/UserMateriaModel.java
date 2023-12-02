package upb.edu.restapimba.Models;

public class UserMateriaModel {
    
    int codigoUsuario=0;
    String codigoMateria="";
    String nombre="";
    String descripcion="";

    public UserMateriaModel(int codigoUsuario, String codigoMateria, String nombre, String descripcion) {
        this.codigoUsuario = codigoUsuario;
        this.codigoMateria = codigoMateria;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "UserMateriaModel [codigoUsuario=" + codigoUsuario + ", codigoMateria=" + codigoMateria + ", nombre="
                + nombre + ", descripcion=" + descripcion + "]";
    }

    public int getCodigoUsuario() {
        return codigoUsuario;
    }
    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }
    public String getCodigoMateria() {
        return codigoMateria;
    }
    public void setCodigoMateria(String codigoMateria) {
        this.codigoMateria = codigoMateria;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    

}
