package upb.edu.restapimba.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import upb.edu.data.CDEDataAccessInterface;
import upb.edu.restapimba.Models.CDEModel;
import upb.edu.restapimba.Models.SolucionCDEModel;
import upb.edu.restapimba.Models.UserModel;

public class CDEBusinessService implements CDEBusinessServiceInterface{

    @Autowired
    CDEDataAccessInterface cdeDAO;
    
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
    public List<CDEModel> getCasosEstudioMateria(String CodigoMateria) {
        return cdeDAO.getCasosEstudioMateria(CodigoMateria);
    }

    @Override
    public CDEModel getCasoEstudio(long codigoCasoEstudio) {
        return cdeDAO.getCasoEstudio(codigoCasoEstudio);
    }

    @Override
    public List<SolucionCDEModel> getSolucionesCasoEstudio(long codigoCasoEstudio) {
        return cdeDAO.getSolucionesCasoEstudio(codigoCasoEstudio);
    }

    @Override
    public boolean updateCalificacion(float calificacion, long codigoSolucion) {
        return cdeDAO.updateCalificacion(calificacion, codigoSolucion);
    }

    @Override
    public boolean createCasoEstudio(CDEModel caso) {
        return cdeDAO.createCasoEstudio(caso);
    }

    @Override
    public boolean createSolucionCasoEstudio(SolucionCDEModel solucion, List<UserModel> users) {
        return cdeDAO.createSolucionCasoEstudio(solucion, users);
    }

    @Override
    public List<UserModel> getUsuariosSolucion(long codigoSolucion) {
        return cdeDAO.getUsuariosSolucion(codigoSolucion);
    }

    public SolucionCDEModel getSolucion(long solucion){
        return cdeDAO.getSolucion(solucion);
    }

    @Override
    public List<CDEModel> getallCDE() {
        return cdeDAO.getallCDE();
    }
    
}
