package upb.edu.data;

import java.util.List;

import javax.sql.DataSource;

import upb.edu.restapimba.Models.CargoMapper;
import upb.edu.restapimba.Models.CargoModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CargoDataService implements CargoDataAccessInterface
{
    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public CargoModel getById(int id) 
    {
        String query = "SELECT * FROM cargos WHERE cargoID="+ Integer.toString(id);
        List <CargoModel> cargos = jdbcTemplate.query(query, new CargoMapper());
        if (!cargos.isEmpty())
        {
            return cargos.get(0);
        }
        else
        {
            return null;
        }
        
    }

    @Override
    public List<CargoModel> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }
    
}
