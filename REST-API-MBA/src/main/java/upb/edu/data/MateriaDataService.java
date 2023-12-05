package upb.edu.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import upb.edu.restapimba.Models.MateriaMapper;
import upb.edu.restapimba.Models.MateriaModel;

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
    public MateriaModel crearMateria(MateriaModel materia) {
        String values = String.format(
            "('%s','%s','%s',%d,'%s','%s','%s')",
            materia.getCodigoMateria(), 
            materia.getNombre(), 
            materia.getDescripcion(), 
            materia.getcodigoDocente(), 
            materia.getSemestre(), 
            materia.getFechaInicio(), 
            materia.getFechaFinal()
        );
        String query = String.format("INSERT INTO materias VALUES %s;",values);
        jdbcTemplate.execute(query);
        return materia;
    }

    @Override
    public int asignarMateriaPrograma(String CodigoPrograma, String CodigoMateria) {
        String values = String.format("('%s','%s')", CodigoPrograma, CodigoMateria );
        String query = String.format("INSERT INTO programaMateria VALUES %s;",values);
        jdbcTemplate.execute(query);

        return 0;
    }

    @Override
    public List<MateriaModel> verMateriasAsignadas(int CodigoUsuario) {
        String query = """
            SELECT m.codigoMateria, m.nombreMateria, m.descripcion
            FROM usuarios u
            JOIN programa p ON u.codigoPrograma = p.codigoPrograma
            JOIN programaMateria pm ON p.codigoPrograma = pm.codigoPrograma
            JOIN materia m ON pm.codigoMateria = m.codigoMateria
            WHERE u.codigoUsuario = 
        """;
        List<MateriaModel> materias = jdbcTemplate.query(query+Integer.toString(CodigoUsuario)+";", new MateriaMapper());
        return materias;
    }

    @Override
    public List<MateriaModel> verMaterias() {
        String query = "SELECT * FROM materias";
        List<MateriaModel> materias = jdbcTemplate.query(query, new MateriaMapper());
        return materias;
    }

    @Override
    public int quitarMateria(String CodigoPrograma, String CodigoMateria) {
        String query = String.format("DELETE FROM programaMateria WHERE codigoPrograma='%s' AND codigoMateria='%s';", CodigoPrograma, CodigoMateria);
        jdbcTemplate.execute(query);

        return 0;
    }
   
}
