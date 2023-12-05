package upb.edu.restapimba.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import upb.edu.data.UsersDataAccessInterface;
import upb.edu.restapimba.Models.CargoModel;
import upb.edu.restapimba.Models.UserModel;


public class UserBusinessService implements UsersBusinessServiceInterface
{
    @Autowired
    UsersDataAccessInterface usersDao;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByCode'");
    }

    @Override
    public boolean verifyCredentials(long code, String passwd) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verifyCredentials'");
    }

    @Override
    public CargoModel getCargo(long user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCargo'");
    }

    @Override
    public UserModel getByCode(int code) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByCode'");
    }

    @Override
    public List<UserModel> getUsers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUsers'");
    }

    @Override
    public List<UserModel> searchUsers(String searchTerm) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchUsers'");
    }

    @Override
    public UserModel createUser(UserModel userModel) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createUser'");
    }

    @Override
    public UserModel updateUser(UserModel userModel) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }

    @Override
    public UserModel deleteOneUser(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteOneUser'");
    }




    
    
    
}
