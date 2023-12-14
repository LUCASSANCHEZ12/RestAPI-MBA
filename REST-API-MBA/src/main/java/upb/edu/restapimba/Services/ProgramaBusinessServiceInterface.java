package upb.edu.restapimba.Services;

import java.util.List;

import upb.edu.restapimba.Models.MateriaModel;
import upb.edu.restapimba.Models.ProgramaModel;
import upb.edu.restapimba.Models.UserModel;

public interface ProgramaBusinessServiceInterface 
{
    public void test();

    public void destroy();
    
    public void init();

    // POST
    public ProgramaModel crearPrograma(ProgramaModel programaModel);

    // POST
    public UserModel asignarPrograma(long CodigoUsuario, String programa);

    //PUT
    public ProgramaModel updatePrograma(ProgramaModel programa);

    // GET
    public ProgramaModel verProgramasAsignados(long user);

    // GET
    public List<ProgramaModel> verProgramas();

    // DELETE
    public ProgramaModel quitarPrograma(String programa);

    // GET
    public ProgramaModel getByID(String programa);

    //GET
    public List<MateriaModel> verMaterias(String programa);
   
}
