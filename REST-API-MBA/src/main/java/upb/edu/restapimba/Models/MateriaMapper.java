package upb.edu.restapimba.Models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

public class MateriaMapper implements RowMapper<MateriaModel> {
    

    @Override
    @Nullable
    public MateriaModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        MateriaModel usermateria = new MateriaModel(
            rs.getLong("codigoDocente"), 
            rs.getString("codigoMateria"), 
            rs.getString("nombreMateria"), 
            rs.getString("descripcion"), 
            rs.getString("semestre"),
            rs.getDate("fechaInicio"),
            rs.getDate("fechaFinal")
            );
        return usermateria;
    }

}
