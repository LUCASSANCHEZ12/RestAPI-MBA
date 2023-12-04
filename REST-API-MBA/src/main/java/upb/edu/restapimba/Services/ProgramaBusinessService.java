package upb.edu.restapimba.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import upb.edu.data.ProgramaDataAccessInterface;
import upb.edu.restapimba.Models.ProgramaModel;
import upb.edu.restapimba.Models.UserModel;

public class ProgramaBusinessService implements ProgramaBusinessServiceInterface{

    @Autowired
    ProgramaDataAccessInterface programaDAO;

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
    public ProgramaModel crearPrograma(ProgramaModel programa) {
        return programaDAO.crearPrograma(programa);
    }

    @Override
    public UserModel asignarPrograma(long CodigoUsuario, String programa) {
        return programaDAO.asignarPrograma(CodigoUsuario, programa);
    }

    @Override
    public ProgramaModel verProgramasAsignados(long user) {
        return programaDAO.verProgramasAsignados(user);
    }

    @Override
    public List<ProgramaModel> verProgramas() {
        return programaDAO.verProgramas();
    }

    @Override
    public ProgramaModel quitarPrograma(String programa) {
        return programaDAO.quitarPrograma(programa);
    }

    @Override
    public ProgramaModel getByID(String programa) {
        return programaDAO.getByID(programa);
    }
    
}
