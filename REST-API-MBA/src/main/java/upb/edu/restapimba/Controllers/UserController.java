package upb.edu.restapimba.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import upb.edu.restapimba.Models.CargoModel;
import upb.edu.restapimba.Models.Tuple;
import upb.edu.restapimba.Models.UserModel;
import upb.edu.restapimba.Services.CargoBusinessServiceInterface;
import upb.edu.restapimba.Services.UsersBusinessServiceInterface;

@RestController
@RequestMapping("/MBA/Chatbot/user")
public class UserController 
{
    @Autowired
    UsersBusinessServiceInterface serviceUser;

    @Autowired
    CargoBusinessServiceInterface serviceCargo;
    
    public UserController(UsersBusinessServiceInterface serviceUser, CargoBusinessServiceInterface serviceCargo) 
    {
        this.serviceUser = serviceUser;
        this.serviceCargo = serviceCargo;
    }

    @GetMapping("/getall")
    public List<UserModel> showAllUsers() 
    { 
        try {
            List<UserModel> users = serviceUser.getUsers();
            return users;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/login/{code}/{passwd}")
    public boolean verifyCredentials(@PathVariable(name="code") long code, @PathVariable(name="passwd") String passwd){
        return serviceUser.verifyCredentials(code, passwd);
    }

    @GetMapping("/getUser/{code}")
    public Tuple<UserModel, CargoModel> userLogin(@PathVariable(name="code") long code)
    {      
        try {
            UserModel user = serviceUser.getByCode(code);
            CargoModel cargo = serviceCargo.getById(user.getCargoId());
            return new Tuple<UserModel,CargoModel>(user, cargo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping("/create")
    public UserModel createUser(@RequestBody UserModel userModel)
    {
        try {
            return serviceUser.createUser(userModel);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    @DeleteMapping("/delete/{code}")
    public UserModel deleteModel(@PathVariable(name="code") long code)
    {
        try {
            return serviceUser.deleteOneUser(code);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PutMapping("/update")
    public UserModel updateUser(@RequestBody UserModel userModel)
    {
        try {
            return serviceUser.updateUser(userModel);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
