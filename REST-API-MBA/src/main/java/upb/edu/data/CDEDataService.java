package upb.edu.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import upb.edu.restapimba.Models.CDEMapper;
import upb.edu.restapimba.Models.CDEModel;
import upb.edu.restapimba.Models.SolucionCDEMapper;
import upb.edu.restapimba.Models.SolucionCDEModel;
import upb.edu.restapimba.Models.UserModel;
import upb.edu.restapimba.Models.UsersMapper;

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
        String query = String.format("""
            SELECT *
            FROM casoDeEstudio
            WHERE codigoMateria = '%s';
            """,
            CodigoMateria
        );

        return jdbcTemplate.query(query, new CDEMapper());
    }

    @Override
    public CDEModel getCasoEstudio(long codigoCasoEstudio) {
        String query = String.format("""
            SELECT * FROM casoDeEstudio
            WHERE codigoCasoDeEstudio = %d;
            """,
            codigoCasoEstudio
        );
        CDEModel cde = jdbcTemplate.query(query, new CDEMapper()).get(0);
        return cde;
    }

    @Override
    public List<SolucionCDEModel> getSolucionesCasoEstudio(long codigoCasoEstudio) {
        String query = String.format("""
            SELECT *
            FROM solucionCasoDeEstudio
            WHERE codigoCasoDeEstudio = %d;
            """,
            codigoCasoEstudio
        );

        return jdbcTemplate.query(query, new SolucionCDEMapper());
    }

    @Override
    public boolean updateCalificacion(float calificacion, long codigoSolucion) {
        String query = String.format(
            """
                UPDATE solucionCasoDeEstudio 
                SET calificacion=%d 
                WHERE codigoSolucion=%d;
            """,
            calificacion,
            codigoSolucion
        );

        try {
            jdbcTemplate.execute(query);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean createCasoEstudio(CDEModel caso) {
        String query = String.format("""
            INSERT INTO casoDeEstudio (nombre,descripcion,codigoMateria)
            VALUES ('%s','%s','%s');
            """, 
            caso.getNombre(),
            caso.getDescripcion(),
            caso.getCodigoMateria()
        );

        try {
            jdbcTemplate.execute(query);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean createSolucionCasoEstudio(SolucionCDEModel solucion, List<UserModel> users) {
        String query1 = String.format("""
            INSERT INTO solucionCasoDeEstudio (
                codigoCasoDeEstudio, 
                calificacion, 
                antecedentes, 
                diagnostico,
                actoresObjetivos,
                problemaCentral,
                alternativas,
                pros,
                contras,
                planDeAccion)
            VALUES (%d,%.2f,'%s','%s','%s','%s','%s','%s','%s','%s');
            """, 
            solucion.getCodigoCasoEstudio(),
            solucion.getCalificacion(),
            solucion.getAntecedentes(),
            solucion.getDiagnostico(),
            solucion.getActoresObjetivos(),
            solucion.getProblemaCentral(),
            solucion.getAlternativas(),
            solucion.getPros(),
            solucion.getContras(),
            solucion.getPlanAccion()
        );
        try {
            jdbcTemplate.execute(query1);
            solucion = getUltimaSolucion();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

        String query2 = "INSERT INTO usuarioSolucion VALUES (%d,%d);";
        for (UserModel userModel : users) {
            try {
                jdbcTemplate.execute(String.format(query2,solucion.getCodigoSolucion(),userModel.getCodigoUsuario()));
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return false;
            }
        }
        return true;
    }

    @Override
    public SolucionCDEModel getSolucion(long solucion){
        String query = String.format("""
                SELECT * FROM solucionCasoDeEstudio
                WHERE codigoSolucion=%d;
                """,
                solucion
            );

        return jdbcTemplate.query(query, new SolucionCDEMapper()).get(0);
    }
    @Override
    public SolucionCDEModel getUltimaSolucion(){
        String query = """
            SELECT * FROM solucionCasoDeEstudio 
            ORDER BY codigoSolucion DESC;
            """;
        return jdbcTemplate.query(query, new SolucionCDEMapper()).get(0);
    }

    @Override
    public List<UserModel> getUsuariosSolucion(long codigoSolucion) {
        String query = String.format("""
            SELECT u.* FROM usuarios u JOIN usuarioSolucion us ON u.codigoUsuario = us.codigoUsuario WHERE us.codigoSolucion=%d;
        """, 
            codigoSolucion
        );
        return jdbcTemplate.query(query,new UsersMapper());
    }
}
