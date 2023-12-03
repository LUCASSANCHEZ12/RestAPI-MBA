package upb.edu.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import upb.edu.restapimba.Models.ProgramaModel;
import upb.edu.restapimba.Models.Tuple;
import upb.edu.restapimba.Models.UserModel;

public class ProgramaDataService implements ProgramaDataAccessInterface
{
    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void test() {
        System.out.println("Test Method Materiadataservice");
    }

    @Override
    public void destroy() {
        System.out.println("Test Method Materiadataservice");
    }

    @Override
    public void init() {
        System.out.println("Test Method Materiadataservice");
    }

    @Override
    public ProgramaModel crearPrograma(String Codigo, String Nombre, String Descripcion) {
        //String query = "INSERT INTO materias (codigoMateria, nombreMateria, descripcion) VALUES(${Codigo}, ${Nombre}, ${Descripcion})";
        //System.out.println(query);
        throw new UnsupportedOperationException("Unimplemented method 'crearMateria'");
    }

    @Override
    public Tuple<ProgramaModel, UserModel> asignarPrograma(int CodigoUsuario, String CodigoPrograma) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'asignarMateria'");
    }

    @Override
    public List<ProgramaModel> verProgramasAsignados(int CodigoUsuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verMateriasAsignadas'");
    }

    @Override
    public List<ProgramaModel> verProgramas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verMaterias'");
    }

    @Override
    public ProgramaModel quitarPrograma(int CodigoUsuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'quitarMateria'");
    }
    
}
