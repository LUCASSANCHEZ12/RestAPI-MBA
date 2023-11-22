package upb.edu.restapimba.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import upb.edu.restapimba.Models.UserModel;
import upb.edu.restapimba.Services.UsersBusinessServiceInterface;

@RestController
@RequestMapping("/api/v1/users")
public class UserController 
{
    @Autowired
    UsersBusinessServiceInterface service;
    
    public UserController(UsersBusinessServiceInterface service) {
        this.service = service;
    }

    @GetMapping("/getall")
    public List<UserModel> showAllUsers() { 
        List<UserModel> users = service.getUsers();
        return users;
    }

    @GetMapping("/search/{searchTerm}")
    public List<UserModel> searchUsers(@PathVariable(name="searchTerm") String searchTerm)
    {
        List<UserModel> users = service.searchUsers(searchTerm);
        return users;
    }

    /*
    @PostMapping("/add/")
    public long addOrder(@RequestBody UserModel model){
        return service.addOne(model);
    }

    @GetMapping("/getOrder/{id}")
    public OrderModel getById(@PathVariable(name="id") long id){
        return service.getByid(id);
    }
    */
}
