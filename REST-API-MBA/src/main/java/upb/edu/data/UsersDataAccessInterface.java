package upb.edu.data;

import java.util.List;

import org.springframework.stereotype.Repository;

import upb.edu.restapimba.Models.UserModel;
import upb.edu.restapimba.Models.CargoModel;

@Repository
public interface UsersDataAccessInterface {
    
    public UserModel getByCode(int code);

    public List<UserModel> getAll();

    public List<UserModel> searchUsers(String searchTerm);

    // Metodos Login
    public boolean verifyCredentials(int codde, String passwd);

    public CargoModel getCargo(UserModel user);

}