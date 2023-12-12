package upb.edu.restapimba.Models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CDEMapper implements RowMapper<CDEModel>{

    @Override
    public CDEModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        CDEModel cde = new CDEModel(
            rs.getLong("codigoCasoDeEstudio"),
            rs.getString("codigoMateria"),
            rs.getString("nombre"),
            rs.getString("descripcion")
        );
        return cde;
    }   
}
