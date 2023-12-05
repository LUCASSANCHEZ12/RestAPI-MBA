package upb.edu.data;

import java.util.List;

import upb.edu.restapimba.Models.ProgramaModel;
import upb.edu.restapimba.Models.UserModel;

public interface ProgramaDataAccessInterface {
    public void test();

    public void destroy();
    
    public void init();

    // POST
    public ProgramaModel crearPrograma(ProgramaModel programaModel);

    // PUT
    public UserModel asignarPrograma(long CodigoUsuario, String programa);

    // GET
    public ProgramaModel verProgramasAsignados(long user);

    // GET
    public List<ProgramaModel> verProgramas();

    // DELETE
    public ProgramaModel quitarPrograma(String programa);

    // GET
    public ProgramaModel getByID(String programa);
}
