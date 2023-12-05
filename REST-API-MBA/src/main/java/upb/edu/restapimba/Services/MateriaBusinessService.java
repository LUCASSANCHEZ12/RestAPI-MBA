package upb.edu.restapimba.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import upb.edu.data.MateriaDataAccessInterface;
import upb.edu.restapimba.Models.MateriaModel;

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
    public int asignarMateriaPrograma(String CodigoPrograma, String CodigoMateria) {
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
    public int quitarMateria(String CodigoPrograma, String CodigoMateria) {
        return materiaDAO.quitarMateria(CodigoPrograma, CodigoMateria);
    }

   
}
