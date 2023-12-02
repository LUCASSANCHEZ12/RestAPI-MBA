package upb.edu.data;

import java.util.List;

import upb.edu.restapimba.Models.MateriaModel;
import upb.edu.restapimba.Models.Tuple;
import upb.edu.restapimba.Models.UserModel;

public interface MateriaDataAccessInterface {
    
    public void test();

    public void destroy();
    
    public void init();

    // POST
    public MateriaModel crearMateria(String Codigo, String Nombre, String Descripcion);

    // POST
    public Tuple<MateriaModel, UserModel> asignarMateria(int CodigoUsuario, String CodigoMateria);

    // GET
    public List<MateriaModel> verMateriasAsignadas(int CodigoUsuario);

    // GET
    public List<MateriaModel> verMaterias();

    // DELETE
    public MateriaModel quitarMateria(int CodigoUsuario);
}
