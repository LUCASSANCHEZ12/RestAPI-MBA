package upb.edu.restapimba.Services;

import java.util.List;

import upb.edu.restapimba.Models.CargoModel;
import upb.edu.restapimba.Models.UserModel;

public interface UsersBusinessServiceInterface
{

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
    public UserModel getByCode(int code);

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

}
