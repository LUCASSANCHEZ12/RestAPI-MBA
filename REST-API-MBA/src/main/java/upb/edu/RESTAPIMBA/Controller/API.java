package upb.edu.RESTAPIMBA.Controller;

import upb.edu.RESTAPIMBA.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import upb.edu.RESTAPIMBA.Repository.UserRepository;
import upb.edu.RESTAPIMBA.Service.UserService;

import java.util.ArrayList;
import java.util.Optional;

@Controller // This means that this class is a Controller
@RequestMapping("API")
public class API {
    @Autowired
    private UserService userService;

    private UserRepository userRepository;

    @GetMapping("/all")
    public ArrayList<User> GetAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/find/{id}")
    public Optional<User> getUserById(@PathVariable("id") long id){
        return userService.getUserByID(id);
    }

    @PostMapping("/save")
    public User saveUser(@RequestBody User u){
        return userService.saveUser(u);
    }

    @DeleteMapping("/delete/{id}")
    public String DeleteUserByID(@PathVariable("id") long id){
        if (userService.deleteUserByID(id)){
            return "Se ha eliminado el usuario: ";
        }else{
            return  "No se ha eliminado el usuario";
        }
    }

}
