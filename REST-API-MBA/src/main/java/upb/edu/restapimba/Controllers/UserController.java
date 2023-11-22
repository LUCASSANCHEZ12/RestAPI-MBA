package upb.edu.restapimba.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import upb.edu.restapimba.Models.CargoModel;
import upb.edu.restapimba.Models.Tuple;
import upb.edu.restapimba.Models.UserModel;
import upb.edu.restapimba.Services.CargoBusinessServiceInterface;
import upb.edu.restapimba.Services.UsersBusinessServiceInterface;

@RestController
@RequestMapping("/MBA/Chatbot")
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
        List<UserModel> users = serviceUser.getUsers();
        return users;
    }

    @GetMapping("/search/{searchTerm}")
    public List<UserModel> searchUsers(@PathVariable(name="searchTerm") String searchTerm)
    {
        List<UserModel> users = serviceUser.searchUsers(searchTerm);
        return users;
    }

    @GetMapping("/login")
    public Tuple<UserModel, CargoModel> userLogin(@RequestBody UserModel model)
    {
        System.out.println(model.toString());
        UserModel user = serviceUser.getByCode(model.getCodigoUsuario());
        //return (user != null && user.getPassword().equals(model.getPassword()));
        if (user != null && user.getPassword().equals(model.getPassword()))
        {
            CargoModel cargo = serviceCargo.getById(user.getCargoId());
            return new Tuple<UserModel,CargoModel>(user, cargo);
        }
        return null;
    }
}
