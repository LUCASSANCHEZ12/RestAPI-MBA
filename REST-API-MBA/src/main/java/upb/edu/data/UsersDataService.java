package upb.edu.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import upb.edu.restapimba.Models.CargoMapper;
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
    public void test() {
        System.out.println("Test Method");
    }

    @Override
    public void destroy() {
        System.out.println("Destroy Method");
    }

    @Override
    public void init() {
        System.out.println("Init Method");
    }

    @Override
    public UserModel getByCode(long code) {
        String query = "SELECT * FROM usuarios WHERE codigoUsuario="+ Long.toString(code)+";";
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
    public boolean verifyCredentials(long code, String passwd) {
        UserModel getUser = getByCode(code);
        return (getUser.getPassword() == passwd);
    }

    @Override
    public CargoModel getCargo(long user) {
        String query = String.format("SELECT c.* FROM usuarios u JOIN cargos c ON u.cargoID = c.cargoID WHERE u.codigoUsuario = %d;", 
            user
        );
        CargoModel cargo = jdbcTemplate.query(query, new CargoMapper()).get(0);
        return cargo;
    }

    @Override
    public List<UserModel> getUsers() {
        String query = """
                SELECT * FROM usuarios
                ORDER BY codigoUsuario DESC;
                """;
        List<UserModel> users = jdbcTemplate.query(query, new UsersMapper());
        return users;
    }

    @Override
    public List<UserModel> searchUsers(String searchTerm) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchUsers'");
    }

    @Override
    public UserModel createUser(UserModel userModel) {
        UserModel user = userModel;
        UserModel lastUser = getUsers().get(-1);
        user.setCodigoUsuario(lastUser.getCodigoUsuario()+1);
        String values = String.format(
            "(%d,'%s','%s','%s','%s','%s',%d,'%s',%d)",
            user.getCodigoUsuario(),
            user.getPrimerNombre(),
            user.getSegundoNombre(),
            user.getApellidoPaterno(),
            user.getApellidoMaterno(),
            user.getEmail(),
            user.getTelefono(),
            user.getPassword(),
            user.getCargoId()
        );
        String query = String.format("INSERT INTO usuarios (codigoUsuario,primerNombre,segundoNombre,apellidoPaterno,apellidoMaterno,email,telefono,password,cargoID) VALUES %s;",values);
        jdbcTemplate.execute(query);
        return user;
    }

    @Override
    public UserModel updateUser(UserModel userModel) {
        String query = String.format(
            "UPDATE usuarios SET primerNombre='%s',segundoNombre='%s',apeliidoPaterno='%s',apellidoMaterno='%s',email='%s',telefono=%d,password='%s' WHERE codigoUsuario=%d;", 
            userModel.getPrimerNombre(),
            userModel.getSegundoNombre(),
            userModel.getApellidoPaterno(),
            userModel.getApellidoMaterno(),
            userModel.getEmail(),
            userModel.getTelefono(),
            userModel.getPassword(),
            userModel.getCodigoUsuario()
            );
        jdbcTemplate.execute(query);
        UserModel user = getByCode(userModel.getCodigoUsuario());
        return user;
    }

    @Override
    public UserModel deleteOneUser(long id) {
        String query = String.format("DELETE FROM usuarios WHERE codigoUsuario=%d;", id);
        UserModel user = getByCode(id);
        jdbcTemplate.execute(query);
        return user;

    }
    
}
