package upb.edu.restapimba.Models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class SolucionCDEMapper implements RowMapper<SolucionCDEModel>{

    @Override
    public SolucionCDEModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        SolucionCDEModel solucion = new SolucionCDEModel(
            rs.getLong("codigoSolucion"), 
            rs.getLong("codigoCasoDeEstudio"), 
            rs.getFloat("calificacion"),
            rs.getString("antecedentes"),
            rs.getString("diagnostico"),
            rs.getString("actoresObjetivos"),
            rs.getString("problemaCentral"),
            rs.getString("alternativas"),
            rs.getString("pros"),
            rs.getString("contras"),
            rs.getString("planDeAccion")
        );
        return solucion;
    }
    
}