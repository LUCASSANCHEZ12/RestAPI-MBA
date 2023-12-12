package upb.edu.restapimba.Models;

public class CDEModel {
    long codigoCasoEstudio=0;
    String codigoMateria="";
    String nombre="";
    String descripcion="";
    
    public CDEModel(long codigoCasoEstudio, String codigoMateria, String nombre, String descripcion) {
        this.codigoCasoEstudio = codigoCasoEstudio;
        this.codigoMateria = codigoMateria;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public long getCodigoCasoEstudio() {
        return codigoCasoEstudio;
    }

    public void setCodigoCasoEstudio(int codigoCasoEstudio) {
        this.codigoCasoEstudio = codigoCasoEstudio;
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
