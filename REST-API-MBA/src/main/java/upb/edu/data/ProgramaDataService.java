package upb.edu.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import upb.edu.restapimba.Models.ProgramaMapper;
import upb.edu.restapimba.Models.ProgramaModel;
import upb.edu.restapimba.Models.UserModel;
import upb.edu.restapimba.Models.UsersMapper;

@Repository
public class ProgramaDataService implements ProgramaDataAccessInterface{

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
    public ProgramaModel crearPrograma(ProgramaModel programaModel) {
        String values = String.format(
            "('%s','%s','%s')",
            programaModel.getCodigoPrograma(),
            programaModel.getNombre(),
            programaModel.getDescripcion()           
        );
        String query = String.format("INSERT INTO programa VALUES %s;",values);
        jdbcTemplate.execute(query);
        return programaModel;
    }

    @Override
    public UserModel asignarPrograma(long CodigoUsuario, String programa) {
        String query = String.format(
             "UPDATE usuarios SET codigoPrograma = '%s' WHERE codigoUsuario = %d;",
             programa,
             CodigoUsuario           
        );
        jdbcTemplate.execute(query);
        return jdbcTemplate.query("SELECT * FROM usuarios WHERE codigoUsuario="+Long.toString(CodigoUsuario)+";", new UsersMapper()).get(0);
    }

    @Override
    public ProgramaModel verProgramasAsignados(int user) {
        String query = String.format(
            "SELECT p.codigoPrograma, p.nombre AS nombrePrograma, p.descripcion AS descripcionPrograma FROM usuarios u JOIN programa p ON u.codigoPrograma = p.codigoPrograma WHERE u.codigoUsuario=%d;",
            user
        );
        ProgramaModel programa = jdbcTemplate.query(query, new ProgramaMapper()).get(0);
        return programa;
    }

    @Override
    public List<ProgramaModel> verProgramas() {
        String query = "SELECt * FROM programas";
        return jdbcTemplate.query(query, new ProgramaMapper());
    }

    @Override
    public ProgramaModel quitarPrograma(String programa) {
        String query1 =  String.format("SELECT * FROM usuarios WHERE codigoPrograma='%s';", programa);
        List<UserModel> usuarios = jdbcTemplate.query(query1, new UsersMapper());

        for (UserModel userModel : usuarios) {
            String update =  String.format("UPDATE usuarios SET codigoPrograma = NULL WHERE codigoUsuario = %d;",userModel.getCodigoUsuario());
            jdbcTemplate.execute(update);
        }

        String query2 = String.format("DELETE FROM programa WHERE codigoPrograma='%s';",programa);
        
        ProgramaModel programaEliminado = getByID(programa);
        
        jdbcTemplate.execute(query2);

        return programaEliminado;
    }

    @Override
    public ProgramaModel getByID(String programa) {
        String query1 =  String.format("SELECT * FROM programa WHERE codigoPrograma='%s';", programa);
        return jdbcTemplate.query(query1, new ProgramaMapper()).get(0);
    }

}
