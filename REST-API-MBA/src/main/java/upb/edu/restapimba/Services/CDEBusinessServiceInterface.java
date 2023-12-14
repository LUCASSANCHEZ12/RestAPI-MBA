package upb.edu.restapimba.Services;

import java.util.List;

import upb.edu.restapimba.Models.CDEModel;
import upb.edu.restapimba.Models.SolucionCDEModel;
import upb.edu.restapimba.Models.UserModel;

public interface CDEBusinessServiceInterface {

    public void test();

    public void destroy();

    public void init();

    //GET
    public List<CDEModel> getallCDE();

    //GET
    public SolucionCDEModel getSolucion(long solucion);
    
    //GET
    public List<CDEModel> getCasosEstudioMateria(String CodigoMateria);

    //GET
    public CDEModel getCasoEstudio(long codigoCasoEstudio);

    //GET
    public List<SolucionCDEModel> getSolucionesCasoEstudio(long codigoCasoEstudio);

    //PUT
    public boolean updateCalificacion(float calificacion, long codigoSolucion);

    //POST
    public boolean createCasoEstudio(CDEModel caso);

    //POST
    public boolean createSolucionCasoEstudio(SolucionCDEModel solucion, List<UserModel> users);

    //GET
    public List<UserModel> getUsuariosSolucion(long codigoSolucion);

    //DELETE
    public boolean deleteCDE(long caso);
}
