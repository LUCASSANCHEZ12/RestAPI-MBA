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
    public UserModel getByCode(int code) 
    {
        String query = "SELECT * FROM usuarios WHERE codigoUsuario="+ Integer.toString(code);
        List <UserModel> users = jdbcTemplate.query(query, new UsersMapper());
        if (!users.isEmpty())
        {
            return users.get(0);
        }
        else
        {
            return null;
        }
    }

    @Override
    public CargoModel getCargo(UserModel user) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<UserModel> searchUsers(String searchTerm) {

        List<UserModel> users = jdbcTemplate.query("SELECT * FROM usuarios", new UsersMapper());

        for (int i = 0; i < users.size(); i++) {
            UserModel userModel = users.get(i);

            if(!(userModel.getSegundoNombre().equals(searchTerm) | userModel.getPrimerNombre().equals(searchTerm) | userModel.getApellidoPaterno().equals(searchTerm) | userModel.getApellidoMaterno().equals(searchTerm))){
                System.out.print(users.get(i));
                users.remove(i);
            }
        }

        return users;
    }

    @Override
    public boolean verifyCredentials(int codde, String passwd) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
