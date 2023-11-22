package upb.edu.restapimba.Services;

import java.util.List;

import upb.edu.restapimba.Models.UserModel;

public interface UsersBusinessServiceInterface
{

    public void test();
    
    public UserModel getByCode(long id);

    public List<UserModel> getUsers();

    public List<UserModel> searchUsers(String searchTerm);

    public long addOneUser(UserModel newOrder);

    public boolean deleteOneUser(long id);

    public UserModel updateOneUser(long idToUpdate, UserModel updateOrder);

    public void destroy();
    
    public void init();

}
