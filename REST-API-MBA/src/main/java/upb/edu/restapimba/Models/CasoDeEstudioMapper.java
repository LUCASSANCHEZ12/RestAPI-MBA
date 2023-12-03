package upb.edu.restapimba.Models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

public class CasoDeEstudioMapper implements RowMapper<CasoDeEstudioModel> {
    

    @Override
    @Nullable
    public CasoDeEstudioModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        CasoDeEstudioModel casoDeEstudioModel = new CasoDeEstudioModel(rs.getLong("codigoCasoDeEstudio"), rs.getString("nombre"), rs.getString("descripcion"), rs.getString("codigoMateria"));
        return casoDeEstudioModel;
    }

}