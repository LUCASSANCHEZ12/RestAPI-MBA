package upb.edu.api.controllers;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import upb.edu.api.models.UserModel;
import upb.edu.api.services.UserService;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController
{
    @Autowired
    private UserService userService;

    @GetMapping
    public ArrayList<UserModel>  getUsers()
    {
        return this.userService.getUsers();
    }

    @PostMapping
    public UserModel saveUser(@RequestBody UserModel user)
    {
        return this.userService.saveUser(user);
    }

    @GetMapping(path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable Long id)
    {
        return this.userService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public UserModel updateUserById(@RequestBody UserModel request, @PathVariable Long id)
    {
        return this.userService.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteByID(@PathVariable Long id)
    {
        boolean deleted = this.userService.deleteUser(id);

        if(deleted)
        {
            return "El usuario de id: " + id + " fue eliminado";
        }
        else
        {
            return "El usuario de id: " + id + " no pudo ser eliminado";
        }
    }

}
