package upb.edu.restapimba.Models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

public class UsersMapper implements RowMapper<UserModel> {

    @Override
    @Nullable
    public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserModel user = new UserModel(rs.getInt("codigoUsuario"), rs.getString("primerNombre"), rs.getString("segundoNombre"), rs.getString("apellidoPaterno"), rs.getString("apellidoMaterno"), rs.getString("email"), rs.getLong("telefono"), rs.getString("password"), rs.getInt("cargoID"), rs.getString("codigoPrograma"));
        return user;
    }
    
}
