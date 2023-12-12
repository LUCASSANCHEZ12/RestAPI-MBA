package upb.edu.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import upb.edu.restapimba.Models.CDEModel;
import upb.edu.restapimba.Models.SolucionCDEModel;
import upb.edu.restapimba.Models.UserModel;

@Repository
public class CDEDataService implements CDEDataAccessInterface{

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCasosEstudioMateria'");
    }

    @Override
    public CDEModel getCasoEstudio(long codigoCasoEstudio) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCasoEstudio'");
    }

    @Override
    public List<SolucionCDEModel> getSolucionesCasoEstudio(long codigoCasoEstudio) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSolucionesCasoEstudio'");
    }

    @Override
    public boolean updateCalificacion(float calificacion, long codigoSolucion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateCalificacion'");
    }

    @Override
    public boolean createCasoEstudio(CDEModel caso) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createCasoEstudio'");
    }

    @Override
    public boolean createSolucionCasoEstudio(SolucionCDEModel solucion, List<UserModel> users) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createSolucionCasoEstudio'");
    }

    @Override
    public List<UserModel> getUsuariosSolucion(long codigoSolucion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUsuariosSolucion'");
    }
    
}
