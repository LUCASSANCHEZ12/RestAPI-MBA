package upb.edu.restapimba.Services;

import java.util.List;

import upb.edu.restapimba.Models.MateriaModel;
import upb.edu.restapimba.Models.Tuple;
import upb.edu.restapimba.Models.UserModel;

public interface MateriaBusinessServiceInterface {
    
    public void test();

    public void destroy();
    
    public void init();

    // POST
    public MateriaModel crearMateria();

    // POST
    public Tuple<MateriaModel, UserModel> asignarMateria();

    // GET
    public List<MateriaModel> verMateriasAsignadas();

    // GET
    public List<MateriaModel> verMaterias();

    // DELETE
    public MateriaModel quitarMateria();

}
