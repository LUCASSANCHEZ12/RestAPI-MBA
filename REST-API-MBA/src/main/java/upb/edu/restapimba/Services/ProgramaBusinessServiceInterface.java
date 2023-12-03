package upb.edu.restapimba.Services;

import java.util.List;

import upb.edu.restapimba.Models.ProgramaModel;
import upb.edu.restapimba.Models.Tuple;
import upb.edu.restapimba.Models.UserModel;

public interface ProgramaBusinessServiceInterface 
{
    public void test();

    public void destroy();
    
    public void init();

    // POST
    public ProgramaModel crearPrograma();

    // POST
    public Tuple<ProgramaModel, UserModel> asignarPrograma();

    // GET
    public List<ProgramaModel> verProgramasAsignados();

    // GET
    public List<ProgramaModel> verProgramas();

    // DELETE
    public ProgramaModel quitarPrograma();
   
}
