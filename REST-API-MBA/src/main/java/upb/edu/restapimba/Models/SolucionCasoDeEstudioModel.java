package upb.edu.restapimba.Models;

public class SolucionCasoDeEstudioModel 
{
    private Long codigoSolucion;
    private Long codigoCasoDeEstudio;
    private int calificacion;
    
    public SolucionCasoDeEstudioModel(Long codigoSolucion, Long codigoCasoDeEstudio, int calificacion) {
        this.codigoSolucion = codigoSolucion;
        this.codigoCasoDeEstudio = codigoCasoDeEstudio;
        this.calificacion = calificacion;
    }

    public Long getCodigoSolucion() {
        return codigoSolucion;
    }

    public void setCodigoSolucion(Long codigoSolucion) {
        this.codigoSolucion = codigoSolucion;
    }

    public Long getCodigoCasoDeEstudio() {
        return codigoCasoDeEstudio;
    }

    public void setCodigoCasoDeEstudio(Long codigoCasoDeEstudio) {
        this.codigoCasoDeEstudio = codigoCasoDeEstudio;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    
}
