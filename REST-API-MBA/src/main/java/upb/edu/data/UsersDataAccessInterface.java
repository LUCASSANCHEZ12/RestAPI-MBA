package upb.edu.data;

import java.util.List;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Repository;

import upb.edu.restapimba.Models.UserModel;
import upb.edu.restapimba.Models.CargoModel;

@Repository
public interface UsersDataAccessInterface {
    
    public UserModel getByCode(long code);

    public List<UserModel> getAll();

    public List<UserModel> searchUsers(String searchTerm);

    // Metodos Login
    public boolean verifyCredentials(int code, String passwd);

    public CargoModel getCargo(UserModel user);

    //Metodos para vista de Admin Users
    public UserModel createUser(UserModel newUser);

    public UserModel deleteUser(long code);
}