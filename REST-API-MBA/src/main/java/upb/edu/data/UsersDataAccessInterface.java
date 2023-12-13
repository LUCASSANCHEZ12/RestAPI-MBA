package upb.edu.data;

import java.util.List;

import org.springframework.stereotype.Repository;

import upb.edu.restapimba.Models.UserModel;
import upb.edu.restapimba.Models.CargoModel;

@Repository
public interface UsersDataAccessInterface {
    
    public void test();

    public void destroy();
    
    public void init();
    
    //GET
    public UserModel getByCode(long code);

    // GET
    public boolean verifyCredentials(long code, String passwd);

    //GET
    public CargoModel getCargo(long user);

    //GET
    public List<UserModel> getUsers();
    
    //GET
    public List<UserModel> searchUsers(String searchTerm);

    //POST
    public UserModel createUser(UserModel userModel);

    //PUT
    public UserModel updateUser(UserModel userModel);

    //DELETE
    public UserModel deleteOneUser(long id);

    //GET
    public String getUsuarioProgramado(long id);
}