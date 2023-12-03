package upb.edu.restapimba.Services;

import java.util.List;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import upb.edu.restapimba.Models.UserModel;

public interface UsersBusinessServiceInterface
{

    public void test();
    
    
    public UserModel getByCode(int code);

    public List<UserModel> getUsers();

    public List<UserModel> searchUsers(String searchTerm);

    public UserModel createUser(UserModel userModel);

    public long addOneUser(UserModel newOrder);

    public UserModel deleteOneUser(long id);

    public UserModel updateOneUser(long idToUpdate, UserModel updateOrder);

    public void destroy();
    
    public void init();

}
