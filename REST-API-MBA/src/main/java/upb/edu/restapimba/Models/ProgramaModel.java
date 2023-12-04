package upb.edu.restapimba.Models;

public class ProgramaModel 
{
    private String codigoPrograma;
    private String nombre;
    private String descripcion;

    public ProgramaModel(String codigoPrograma, String nombre, String descripcion) 
    {
        this.codigoPrograma = codigoPrograma;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getCodigoPrograma() {
        return codigoPrograma;
    }

    public void setCodigoPrograma(String codigoPrograma) {
        this.codigoPrograma = codigoPrograma;
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