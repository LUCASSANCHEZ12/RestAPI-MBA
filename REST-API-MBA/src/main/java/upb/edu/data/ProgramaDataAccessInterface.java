package upb.edu.data;

import java.util.List;

import upb.edu.restapimba.Models.ProgramaModel;
import upb.edu.restapimba.Models.Tuple;
import upb.edu.restapimba.Models.UserModel;

public interface ProgramaDataAccessInterface
{
    public void test();

    public void destroy();
    
    public void init();

    // POST
    public ProgramaModel crearPrograma(String Codigo, String Nombre, String Descripcion);

    // POST
    public Tuple<ProgramaModel, UserModel> asignarPrograma(int CodigoUsuario, String CodigoPrograma);

    // GET
    public List<ProgramaModel> verProgramasAsignados(int CodigoUsuario);

    // GET
    public List<ProgramaModel> verProgramas();

    // DELETE
    public ProgramaModel quitarPrograma(int CodigoUsuario);   
}
