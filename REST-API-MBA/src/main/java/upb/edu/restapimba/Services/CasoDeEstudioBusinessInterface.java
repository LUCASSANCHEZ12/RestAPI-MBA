package upb.edu.restapimba.Services;

import java.util.List;

import upb.edu.restapimba.Models.CasoDeEstudioModel;
import upb.edu.restapimba.Models.Tuple;
import upb.edu.restapimba.Models.UserModel;

public interface CasoDeEstudioBusinessInterface 
{
    public void test();

    public void destroy();
    
    public void init();

    // POST
    public CasoDeEstudioModel crearPrograma();

    // POST
    public Tuple<CasoDeEstudioModel, UserModel> asignarPrograma();

    // GET
    public List<CasoDeEstudioModel> verProgramasAsignados();

    // GET
    public List<CasoDeEstudioModel> verProgramas();

    // DELETE
    public CasoDeEstudioModel quitarPrograma();
}
