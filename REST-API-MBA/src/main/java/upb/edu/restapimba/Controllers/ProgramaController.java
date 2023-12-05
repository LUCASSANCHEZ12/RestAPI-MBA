package upb.edu.restapimba.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import upb.edu.restapimba.Models.CargoModel;
import upb.edu.restapimba.Models.ProgramaModel;
import upb.edu.restapimba.Models.Tuple;
import upb.edu.restapimba.Models.UserModel;
import upb.edu.restapimba.Services.CargoBusinessServiceInterface;
import upb.edu.restapimba.Services.MateriaBusinessServiceInterface;
import upb.edu.restapimba.Services.ProgramaBusinessServiceInterface;
import upb.edu.restapimba.Services.UsersBusinessServiceInterface;

@RestController
@RequestMapping("/MBA/Chatbot/program")
public class ProgramaController {
    
    @Autowired
    UsersBusinessServiceInterface serviceUser;

    @Autowired
    ProgramaBusinessServiceInterface serviceProgram;

    @Autowired
    MateriaBusinessServiceInterface serviceMateria;

    public ProgramaController(UsersBusinessServiceInterface serviceUser, ProgramaBusinessServiceInterface serviceProgram, MateriaBusinessServiceInterface serviceMateria)
    {
        this.serviceUser = serviceUser;
        this.serviceMateria = serviceMateria;
        this.serviceProgram = serviceProgram;
    }

    @GetMapping("/getall")
    public List<ProgramaModel> getAll()
    {
        return serviceProgram.verProgramas();
    }

    @GetMapping("/user/getProgram/{code}")
    public ProgramaModel getProgrambyUser(@PathVariable(name="code") long code)
    {
        return serviceProgram.verProgramasAsignados(code);
    }

    @GetMapping("/getProgram/{program}")
    public ProgramaModel getProgram(@PathVariable(name="program") String program)
    {
        return serviceProgram.getByID(program);
    }

    @PostMapping("/create")
    public ProgramaModel createProgram(@RequestBody ProgramaModel programa)
    {
        return serviceProgram.crearPrograma(programa);
    }

    @PostMapping("/user/asign/{code}/{program}")
    public UserModel asignarProgram(@PathVariable(name="code") long code,@PathVariable(name="program") String program)
    {
        return serviceProgram.asignarPrograma(code, program);
    }

    @DeleteMapping("/delete/{program}")
    public ProgramaModel deleteProgram(@PathVariable(name="program") String program)
    {
        return serviceProgram.quitarPrograma(program);
    }

}
