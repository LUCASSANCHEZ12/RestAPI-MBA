package upb.edu.restapimba.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import upb.edu.data.MateriaDataAccessInterface;
import upb.edu.restapimba.Models.MateriaModel;
import upb.edu.restapimba.Models.ProgramaModel;
import upb.edu.restapimba.Models.Tuple;
import upb.edu.restapimba.Models.UserModel;

public class MateriaBusinessService implements MateriaBusinessServiceInterface{

    @Autowired
    MateriaDataAccessInterface materiaDAO;

    @Override
    public void test() {
        System.out.println("Test Method");
    }

    @Override
    public void destroy() {
        System.out.println("Destroy Method");
    }

    @Override
    public void init() {
        System.out.println("Init Method");
    }

    @Override
    public MateriaModel crearMateria(MateriaModel materia) {
       return materiaDAO.crearMateria(materia);
    }

    @Override
    public Tuple<MateriaModel, ProgramaModel> asignarMateriaPrograma(String CodigoPrograma, String CodigoMateria) {
        return materiaDAO.asignarMateriaPrograma(CodigoPrograma, CodigoMateria);
    }

    @Override
    public List<MateriaModel> verMateriasEstudiante(long CodigoUsuario) {
        return materiaDAO.verMateriasEstudiante(CodigoUsuario);
    }

    @Override
    public List<MateriaModel> verMateriasDocente(long CodigoUsuario) {
        return materiaDAO.verMateriasDocente(CodigoUsuario);
    }

    @Override
    public List<MateriaModel> verMaterias() {
        return materiaDAO.verMaterias();
    }

    @Override
    public Tuple<MateriaModel, ProgramaModel> quitarMateriaPrograma(String CodigoPrograma, String CodigoMateria) {
        return materiaDAO.quitarMateriaPrograma(CodigoPrograma, CodigoMateria);
    }

    @Override
    public MateriaModel getById(String code){
        return materiaDAO.getById(code);
    }

    @Override
    public MateriaModel updateMateria(MateriaModel materia) {
        return materiaDAO.updateMateria(materia);
    }

    @Override
    public MateriaModel eliminarMateria(String codigo) {
        return materiaDAO.eliminarMateria(codigo);
    }

    @Override
    public List<UserModel> getUsuariosMateria(String Materia) {
        return materiaDAO.getUsuariosMateria(Materia);
    }
    
}
