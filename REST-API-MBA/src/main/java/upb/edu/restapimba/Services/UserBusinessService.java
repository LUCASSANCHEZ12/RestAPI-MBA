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
        return usersDao.getByCode(code);
    }

    @Override
    public boolean verifyCredentials(long code, String passwd) {
        return usersDao.verifyCredentials(code, passwd);
    }

    @Override
    public CargoModel getCargo(long user) {
        return usersDao.getCargo(user);
    }

    @Override
    public List<UserModel> getUsers() {
        return usersDao.getUsers();
    }

    @Override
    public List<UserModel> searchUsers(String searchTerm) {
        return usersDao.searchUsers(searchTerm);
    }

    @Override
    public UserModel createUser(UserModel userModel) {
        return usersDao.createUser(userModel);
    }

    @Override
    public UserModel updateUser(UserModel userModel) {
        return usersDao.updateUser(userModel);
    }

    @Override
    public UserModel deleteOneUser(long id) {
        return usersDao.deleteOneUser(id);
    }

}
