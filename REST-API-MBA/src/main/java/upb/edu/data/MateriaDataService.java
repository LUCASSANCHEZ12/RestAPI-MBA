package upb.edu.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import upb.edu.restapimba.Models.MateriaModel;
import upb.edu.restapimba.Models.Tuple;
import upb.edu.restapimba.Models.UserModel;

@Repository
public class MateriaDataService implements MateriaDataAccessInterface{


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
    public MateriaModel crearMateria(String Codigo, String Nombre, String Descripcion) {
        String query = "INSERT INTO materias (codigoMateria, nombreMateria, descripcion) VALUES(${Codigo}, ${Nombre}, ${Descripcion})";
        System.out.println(query);
        throw new UnsupportedOperationException("Unimplemented method 'crearMateria'");
    }

    @Override
    public Tuple<MateriaModel, UserModel> asignarMateria(int CodigoUsuario, String CodigoMateria) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'asignarMateria'");
    }

    @Override
    public List<MateriaModel> verMateriasAsignadas(int CodigoUsuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verMateriasAsignadas'");
    }

    @Override
    public List<MateriaModel> verMaterias() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verMaterias'");
    }

    @Override
    public MateriaModel quitarMateria(int CodigoUsuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'quitarMateria'");
    }


    
}
