package upb.edu.restapimba.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import upb.edu.data.MateriaDataAccessInterface;
import upb.edu.restapimba.Models.MateriaModel;
import upb.edu.restapimba.Models.ProgramaModel;
import upb.edu.restapimba.Models.Tuple;

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
    public List<MateriaModel> verMateriasAsignadas(int CodigoUsuario) {
        return materiaDAO.verMateriasAsignadas(CodigoUsuario);
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
    
}
