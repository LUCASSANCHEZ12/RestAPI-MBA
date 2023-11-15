package upb.edu.RESTAPIMBA.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upb.edu.RESTAPIMBA.Models.User;
import upb.edu.RESTAPIMBA.Repository.UserRepository;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public ArrayList<User> getAllUsers() {
        return (ArrayList<User>) userRepository.findAll();
    }

    @Override
    public Optional<User> getUserByID(long id) {
        return userRepository.findById(id);
    }

    @Override
    public User saveUser(User u) {
        return userRepository.save(u);
    }

    @Override
    public boolean deleteUserByID(long id) {
        try {
            Optional<User> u = getUserByID(id);
            userRepository.delete(u.get());
            return  true;
        }catch(Exception e){
            return false;
        }
    }
}
