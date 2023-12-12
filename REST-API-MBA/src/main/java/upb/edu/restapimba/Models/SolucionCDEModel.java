package upb.edu.restapimba.Models;

public class SolucionCDEModel {
    long codigoSolucion=0;
    long codigoCasoEstudio=0;
    float calificacion=0;
    String Antecedentes="";
    String Diagnostico="";
    String ActoresObjetivos="";
    String ProblemaCentral="";
    String Alternativas="";
    String Pros="";
    String Contras="";
    String PlanAccion="";
    
    public SolucionCDEModel(long codigoSolucion, long codigoCasoEstudio, float calificacion, String antecedentes,
            String diagnostico, String actoresObjetivos, String problemaCentral, String alternativas, String pros,
            String contras, String planAccion) {
        this.codigoSolucion = codigoSolucion;
        this.codigoCasoEstudio = codigoCasoEstudio;
        this.calificacion = calificacion;
        Antecedentes = antecedentes;
        Diagnostico = diagnostico;
        ActoresObjetivos = actoresObjetivos;
        ProblemaCentral = problemaCentral;
        Alternativas = alternativas;
        Pros = pros;
        Contras = contras;
        PlanAccion = planAccion;
    }

    public long getCodigoSolucion() {
        return codigoSolucion;
    }
    public void setCodigoSolucion(long codigoSolucion) {
        this.codigoSolucion = codigoSolucion;
    }
    public long getCodigoCasoEstudio() {
        return codigoCasoEstudio;
    }
    public void setCodigoCasoEstudio(long codigoCasoEstudio) {
        this.codigoCasoEstudio = codigoCasoEstudio;
    }
    public float getCalificacion() {
        return calificacion;
    }
    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }
    public String getAntecedentes() {
        return Antecedentes;
    }
    public void setAntecedentes(String antecedentes) {
        Antecedentes = antecedentes;
    }
    public String getDiagnostico() {
        return Diagnostico;
    }
    public void setDiagnostico(String diagnostico) {
        Diagnostico = diagnostico;
    }
    public String getActoresObjetivos() {
        return ActoresObjetivos;
    }
    public void setActoresObjetivos(String actoresObjetivos) {
        ActoresObjetivos = actoresObjetivos;
    }
    public String getProblemaCentral() {
        return ProblemaCentral;
    }
    public void setProblemaCentral(String problemaCentral) {
        ProblemaCentral = problemaCentral;
    }
    public String getAlternativas() {
        return Alternativas;
    }
    public void setAlternativas(String alternativas) {
        Alternativas = alternativas;
    }
    public String getPros() {
        return Pros;
    }
    public void setPros(String pros) {
        Pros = pros;
    }
    public String getContras() {
        return Contras;
    }
    public void setContras(String contras) {
        Contras = contras;
    }
    public String getPlanAccion() {
        return PlanAccion;
    }
    public void setPlanAccion(String planAccion) {
        PlanAccion = planAccion;
    }
}
