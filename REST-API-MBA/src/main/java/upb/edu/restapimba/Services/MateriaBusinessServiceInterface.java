package upb.edu.restapimba.Services;

import java.util.List;

import upb.edu.restapimba.Models.MateriaModel;

public interface MateriaBusinessServiceInterface {
    
    public void test();

    public void destroy();
    
    public void init();

    // POST
    public MateriaModel crearMateria(MateriaModel materia);

    // POST
    public int asignarMateriaPrograma(String CodigoPrograma, String CodigoMateria);

    // GET
    public List<MateriaModel> verMateriasAsignadas(int CodigoUsuario);

    // GET
    public List<MateriaModel> verMaterias();

    // DELETE
    public int quitarMateria(String CodigoPrograma, String CodigoMateria);
}
