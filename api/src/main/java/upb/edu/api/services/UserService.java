package upb.edu.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upb.edu.api.models.UserModel;
import upb.edu.api.repositories.IUserRepository;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService
{
    @Autowired
    IUserRepository userRepository;

    public ArrayList<UserModel> getUsers()
    {
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public UserModel saveUser(UserModel user)
    {
        return userRepository.save(user);
    }

    public Optional<UserModel> getById(Long id)
    {
        return userRepository.findById(id);
    }

    public UserModel updateById(UserModel request, Long id)
    {
        UserModel user = userRepository.findById(id).get();
        user.setPrimerNombre(request.getPrimerNombre());
        user.setSegundoNombre(request.getSegundoNombre());
        user.setApellidoMaterno(request.getApellidoMaterno());
        user.setApellidoPaterno(request.getApellidoPaterno());
        user.setEmail(request.getEmail());
        user.setTelefono(request.getTelefono());
        user.setCargoID(request.getCargoID());

        return user;
    }

    public Boolean deleteUser(Long id)
    {
        try
        {
            userRepository.deleteById(id);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
