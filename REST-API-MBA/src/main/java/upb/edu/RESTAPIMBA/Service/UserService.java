package upb.edu.RESTAPIMBA.Service;

import upb.edu.RESTAPIMBA.Models.User;

import java.util.ArrayList;
import java.util.Optional;

public interface UserService {

    ArrayList<User> getAllUsers();
    Optional<User> getUserByID(long id);
    User saveUser(User u);
    boolean deleteUserByID(long id);

}
