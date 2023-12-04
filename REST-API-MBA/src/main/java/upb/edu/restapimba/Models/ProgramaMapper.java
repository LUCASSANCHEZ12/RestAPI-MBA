package upb.edu.restapimba.Models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

public class ProgramaMapper implements RowMapper<ProgramaModel> 
{
    
    @Override
    @Nullable
    public ProgramaModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        ProgramaModel programaModel = new ProgramaModel(rs.getString("codigoPrograma"), rs.getString("nombre"), rs.getString("descripcion"));
        return programaModel;
    }

}
