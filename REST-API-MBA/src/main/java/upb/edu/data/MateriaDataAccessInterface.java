package upb.edu.data;

import java.util.List;

import upb.edu.restapimba.Models.MateriaModel;
import upb.edu.restapimba.Models.ProgramaModel;
import upb.edu.restapimba.Models.Tuple;
import upb.edu.restapimba.Models.UserModel;

public interface MateriaDataAccessInterface {
    
    public void test();

    public void destroy();
    
    public void init();

    // POST
    public MateriaModel crearMateria(MateriaModel materia);

    // POST
    public Tuple<MateriaModel, ProgramaModel> asignarMateriaPrograma(String CodigoPrograma, String CodigoMateria);

    // GET
    public List<MateriaModel> verMateriasEstudiante(long CodigoUsuario);

    // GET
    public List<MateriaModel> verMateriasDocente(long CodigoUsuario);

    // GET
    public List<MateriaModel> verMaterias();

    // DELETE
    public Tuple<MateriaModel, ProgramaModel> quitarMateriaPrograma(String CodigoPrograma, String CodigoMateria);

    //DELETE
    public MateriaModel eliminarMateria(String codigo);

    //GET
    public MateriaModel getById(String code);

    //PUT
    public MateriaModel updateMateria(MateriaModel materia);

    //GET
    public List<UserModel> getUsuariosMateria(String Materia);

}
