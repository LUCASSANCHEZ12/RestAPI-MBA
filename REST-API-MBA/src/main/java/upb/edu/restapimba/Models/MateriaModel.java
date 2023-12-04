package upb.edu.restapimba.Models;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class MateriaModel {
    
    long codigoDocente=0;
    String codigoMateria=""; // NombreMateria-Año-Gestion-Paralelo
    String nombre="";
    String descripcion="";
    String semestre="";
    Date fechaInicio;
    Date fechaFinal;

    public MateriaModel(long codigoDocente, String codigoMateria, String nombre, String descripcion, String semestre,
            Date fechaInicio, Date fechaFinal) {
        this.codigoDocente = codigoDocente;
        this.codigoMateria = codigoMateria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.semestre = semestre;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
    }

    

    @Override
    public String toString() {
        return "MateriaModel [codigoDocente=" + codigoDocente + ", codigoMateria=" + codigoMateria + ", nombre="
                + nombre + ", descripcion=" + descripcion + ", semestre=" + semestre + ", fechaInicio=" + fechaInicio
                + ", fechaFinal=" + fechaFinal + "]";
    }



    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getFechaInicio() {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = formato.format(fechaInicio);
        return fecha;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinal() {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = formato.format(fechaFinal);
        return fecha;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public long getcodigoDocente() {
        return codigoDocente;
    }
    public void setcodigoDocente(long codigoDocente) {
        this.codigoDocente = codigoDocente;
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
