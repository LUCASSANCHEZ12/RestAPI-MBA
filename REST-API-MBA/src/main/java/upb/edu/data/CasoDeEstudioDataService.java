package upb.edu.data;

import java.util.List;

import upb.edu.restapimba.Models.CasoDeEstudioModel;
import upb.edu.restapimba.Models.Tuple;
import upb.edu.restapimba.Models.UserModel;

public class CasoDeEstudioDataService implements CasoDeEstudioDataAccessInterface
{

    @Override
    public void test() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'test'");
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'destroy'");
    }

    @Override
    public void init() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'init'");
    }

    @Override
    public CasoDeEstudioModel crearCasoDeEstudio(String Codigo, String Nombre, String Descripcion,
            String CodigoMateria) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearCasoDeEstudio'");
    }

    @Override
    public Tuple<CasoDeEstudioModel, UserModel> asignarCasoDeEstudio(int CodigoUsuario, String CodigoCasoDeEstudio) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'asignarCasoDeEstudio'");
    }

    @Override
    public List<CasoDeEstudioModel> verCasosDeEstudioAsignados(int CodigoUsuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verCasosDeEstudioAsignados'");
    }

    @Override
    public List<CasoDeEstudioModel> verCasosDeEstudio() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verCasosDeEstudio'");
    }

    @Override
    public CasoDeEstudioModel quitarCasoDeEstudio(int CodigoUsuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'quitarCasoDeEstudio'");
    }
    
}
