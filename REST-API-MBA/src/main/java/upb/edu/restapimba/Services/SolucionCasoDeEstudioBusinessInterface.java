package upb.edu.restapimba.Services;

import java.util.List;
import upb.edu.restapimba.Models.SolucionCasoDeEstudioModel;
import upb.edu.restapimba.Models.Tuple;
import upb.edu.restapimba.Models.UserModel;

public interface SolucionCasoDeEstudioBusinessInterface 
{
    public void test();

    public void destroy();
    
    public void init();

    // POST
    public SolucionCasoDeEstudioModel crearPrograma();

    // POST
    public Tuple<SolucionCasoDeEstudioModel, UserModel> asignarPrograma();

    // GET
    public List<SolucionCasoDeEstudioModel> verProgramasAsignados();

    // GET
    public List<SolucionCasoDeEstudioModel> verProgramas();

    // DELETE
    public SolucionCasoDeEstudioModel quitarPrograma();   
}
