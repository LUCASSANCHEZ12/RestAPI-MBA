package upb.edu.restapimba.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import upb.edu.data.UsersDataAccessInterface;
import upb.edu.restapimba.Models.UserModel;


public class UserBusinessService implements UsersBusinessServiceInterface
{
    @Autowired
    UsersDataAccessInterface usersDao;

    @Override
    public void test() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'test'");
    }

    @Override
    public UserModel getByCode(int code) 
    {
        return usersDao.getByCode(code);
    }

    @Override
    public List<UserModel> getUsers() {
        return usersDao.getAll();
    }

    @Override
    public List<UserModel> searchUsers(String searchTerm) {
        return usersDao.searchUsers(searchTerm);
    }

    @Override
    public long addOneUser(UserModel newOrder) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addOneUser'");
    }

    @Override
    public UserModel deleteOneUser(long id) {
        return usersDao.deleteUser(id);
    }

    @Override
    public UserModel updateOneUser(long idToUpdate, UserModel updateOrder) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateOneUser'");
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        System.out.println("Destroy method");
    }

    @Override
    public void init() {
        // TODO Auto-generated method stub
        System.out.println("Init method");
    }

    @Override
    public UserModel createUser(UserModel userModel) {
        // TODO Auto-generated method stub
        return usersDao.createUser(userModel);
    }

    
}
