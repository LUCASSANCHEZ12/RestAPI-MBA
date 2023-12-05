package upb.edu.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import upb.edu.restapimba.Models.MateriaMapper;
import upb.edu.restapimba.Models.MateriaModel;
import upb.edu.restapimba.Models.ProgramaModel;
import upb.edu.restapimba.Models.Tuple;

@Repository
public class MateriaDataService implements MateriaDataAccessInterface{

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    ProgramaDataAccessInterface programa;

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
        String query = String.format("INSERT INTO materia VALUES %s;",values);
        jdbcTemplate.execute(query);
        return materia;
    }

    @Override
    public Tuple<MateriaModel, ProgramaModel> asignarMateriaPrograma(String CodigoPrograma, String CodigoMateria) {
        String values = String.format("('%s','%s')", CodigoPrograma, CodigoMateria );
        String query = String.format("INSERT INTO programaMateria VALUES %s;",values);
        jdbcTemplate.execute(query);
        return new Tuple<MateriaModel,ProgramaModel>(getById(CodigoMateria), programa.getByID(CodigoPrograma));
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
        String query = "SELECT * FROM materia;";
        List<MateriaModel> materias = jdbcTemplate.query(query, new MateriaMapper());
        return materias;
    }

    @Override
    public Tuple<MateriaModel, ProgramaModel> quitarMateriaPrograma(String CodigoPrograma, String CodigoMateria) {
        String query = String.format("DELETE FROM programaMateria WHERE codigoPrograma='%s' AND codigoMateria='%s';", CodigoPrograma, CodigoMateria);
        jdbcTemplate.execute(query);
        return new Tuple<MateriaModel,ProgramaModel>(getById(CodigoMateria), programa.getByID(CodigoPrograma));
    }
   
    @Override
    public MateriaModel getById(String code){
        String query = String.format("SELECT * FROM materia WHERE codigoMateria='%s';", code);
        return jdbcTemplate.query(query, new MateriaMapper()).get(0);
    }

    @Override
    public MateriaModel updateMateria(MateriaModel materia) {
        String query = String.format(
            "UPDATE materia SET nombreMateria='%s',descripcion='%s',codigoDocente=%d,semestre='%s',fechaInicio='%s',fechaFinal='%s' WHERE codigoMateria='%s';",
            materia.getNombre(),
            materia.getDescripcion(),
            materia.getcodigoDocente(),
            materia.getSemestre(),
            materia.getFechaInicio(),
            materia.getFechaFinal(),
            materia.getCodigoMateria()
        );
        jdbcTemplate.execute(query);
        return materia;
    }

    @Override
    public MateriaModel eliminarMateria(String codigo) {
        MateriaModel materia = getById(codigo);
        String query = String.format("DELETE * FROM materia WHERE codigoMateria='%s';", 
            codigo
        );
        jdbcTemplate.execute(query);
        return materia;
    }
}
