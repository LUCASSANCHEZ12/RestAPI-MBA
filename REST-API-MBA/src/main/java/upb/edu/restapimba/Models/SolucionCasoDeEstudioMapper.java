package upb.edu.restapimba.Models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

public class SolucionCasoDeEstudioMapper implements RowMapper<SolucionCasoDeEstudioModel> 
{
    

    @Override
    @Nullable
    public SolucionCasoDeEstudioModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        SolucionCasoDeEstudioModel solucionCasoDeEstudioModel = new SolucionCasoDeEstudioModel(rs.getLong("codigoSolucion"), rs.getLong("codigoCasoDeEstudio"), rs.getInt("calificacion"));
        return solucionCasoDeEstudioModel;
    }

}
