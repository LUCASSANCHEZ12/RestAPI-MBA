package upb.edu.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
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
    public UserModel getByCode(long code) 
    {
        String query = "SELECT * FROM usuarios WHERE codigoUsuario="+ Long.toString(code);
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

    @Override
    public UserModel createUser(UserModel newUser){
        
        UserModel user = newUser;
        String values = String.format("(%d,'%s','%s','%s','%s','%s',%d,'%s',%d)",user.getCodigoUsuario(),user.getPrimerNombre(),user.getSegundoNombre(),user.getApellidoPaterno(),user.getApellidoMaterno(),user.getEmail(),user.getTelefono(),user.getPassword(),user.getCargoId());
        String query = String.format("INSERT INTO usuarios (codigoUsuario,primerNombre,segundoNombre,apellidoPaterno,apellidoMaterno,email,telefono,password,cargoID) VALUES %s;",values);
        jdbcTemplate.execute(query);
        return user;
    }

    @Override
    public UserModel deleteUser(long code) {
        String query = String.format("DELETE FROM usuarios WHERE codigoUsuario=%d", code);
        UserModel user = getByCode(code);
        jdbcTemplate.execute(query);
        return user;
    }
    
}
