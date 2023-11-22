package upb.edu.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import upb.edu.restapimba.Models.CargoModel;
import upb.edu.restapimba.Models.UserModel;
import upb.edu.restapimba.Models.UsersMapper;


@Repository
public class UsersDataService implements UsersDataAccessInterface{

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<UserModel> getAll() {
        List<UserModel> users = jdbcTemplate.query("SELECT * FROM usuarios", new UsersMapper());
        return users;
    }

    @Override
    public UserModel getByCode(int code) {
        String query = "SELECT * FROM usuarios WHERE codigoUsuarios="+ Integer.toString(code);
        UserModel user = jdbcTemplate.query(query, new UsersMapper()).get(0);
        return user;
    }

    @Override
    public CargoModel getCargo(UserModel user) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<UserModel> searchUsers(String searchTerm) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean verifyCredentials(int codde, String passwd) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
