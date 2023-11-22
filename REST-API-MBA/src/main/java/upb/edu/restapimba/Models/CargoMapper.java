package upb.edu.restapimba.Models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

public class CargoMapper implements RowMapper<CargoModel> {

    @Override
    @Nullable
    public CargoModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        CargoModel cargo = new CargoModel(rs.getInt("cargoID"), rs.getString("nombreCargo"), rs.getString("descripcion"));
        return cargo;
    }
}
