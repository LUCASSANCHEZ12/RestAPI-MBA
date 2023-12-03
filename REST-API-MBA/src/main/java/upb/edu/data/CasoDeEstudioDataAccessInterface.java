package upb.edu.data;

import java.util.List;

import upb.edu.restapimba.Models.CasoDeEstudioModel;
import upb.edu.restapimba.Models.Tuple;
import upb.edu.restapimba.Models.UserModel;

public interface CasoDeEstudioDataAccessInterface 
{
    public void test();

    public void destroy();
    
    public void init();

    // POST
    public CasoDeEstudioModel crearCasoDeEstudio(String Codigo, String Nombre, String Descripcion, String CodigoMateria);

    // POST
    public Tuple<CasoDeEstudioModel, UserModel> asignarCasoDeEstudio(int CodigoUsuario, String CodigoCasoDeEstudio);

    // GET
    public List<CasoDeEstudioModel> verCasosDeEstudioAsignados(int CodigoUsuario);

    // GET
    public List<CasoDeEstudioModel> verCasosDeEstudio();

    // DELETE
    public CasoDeEstudioModel quitarCasoDeEstudio(int CodigoUsuario);
}
