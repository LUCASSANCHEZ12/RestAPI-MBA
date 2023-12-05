package upb.edu.restapimba.Services;

import java.util.List;

import upb.edu.restapimba.Models.MateriaModel;
import upb.edu.restapimba.Models.ProgramaModel;
import upb.edu.restapimba.Models.Tuple;

public interface MateriaBusinessServiceInterface {
    
    public void test();

    public void destroy();
    
    public void init();

    // POST
    public MateriaModel crearMateria(MateriaModel materia);

    // POST
    public Tuple<MateriaModel, ProgramaModel> asignarMateriaPrograma(String CodigoPrograma, String CodigoMateria);

    // GET
    public List<MateriaModel> verMateriasAsignadas(long CodigoUsuario);

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
}
