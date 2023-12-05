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

import upb.edu.restapimba.Models.MateriaModel;
import upb.edu.restapimba.Models.ProgramaModel;
import upb.edu.restapimba.Models.Tuple;
import upb.edu.restapimba.Models.UserModel;
import upb.edu.restapimba.Services.MateriaBusinessServiceInterface;
import upb.edu.restapimba.Services.ProgramaBusinessServiceInterface;
import upb.edu.restapimba.Services.UsersBusinessServiceInterface;

@RestController
@RequestMapping("/MBA/program")
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

    @PostMapping("/materia/create")
    public MateriaModel createMateria(@RequestBody MateriaModel materia){
        try {
            return serviceMateria.crearMateria(materia);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/materia/get/{code}")
    public MateriaModel getMateriaById(@PathVariable(name="code") String code){
        try {
            return serviceMateria.getById(code);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/materia/getall")
    public List<MateriaModel> getAllMaterias()
    {
        try {
            return serviceMateria.verMaterias();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PutMapping("/materia/update")
    public MateriaModel updateMateria(@RequestBody MateriaModel materia){
        try {
            return serviceMateria.updateMateria(materia);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @DeleteMapping("/materia/delete/program/{materia}/{programa}")
    public Tuple<MateriaModel, ProgramaModel> deleteMateriaPrograma(@PathVariable(name="materia") String materia, @PathVariable(name="programa") String programa){
        try {
            return serviceMateria.quitarMateriaPrograma(programa, materia);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping("/materia/asign/{materia}/{programa}")
    public Tuple<MateriaModel, ProgramaModel> asignMateriaPrograma(@PathVariable(name="materia") String materia, @PathVariable(name="programa") String programa){
        try {
            return serviceMateria.asignarMateriaPrograma(programa, materia);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/getall")
    public List<ProgramaModel> getAllProgramas()
    {
        try {
            return serviceProgram.verProgramas();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/user/getProgram/{code}")
    public ProgramaModel getProgrambyUser(@PathVariable(name="code") long code)
    {
        try {
            return serviceProgram.verProgramasAsignados(code);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/getProgram/{program}")
    public ProgramaModel getProgram(@PathVariable(name="program") String program)
    {
        try {
            return serviceProgram.getByID(program);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping("/create")
    public ProgramaModel createProgram(@RequestBody ProgramaModel programa)
    {
        try {
            return serviceProgram.crearPrograma(programa);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PutMapping("/user/asign/{code}/{program}")
    public UserModel asignarProgram(@PathVariable(name="code") long code,@PathVariable(name="program") String program)
    {
        try {
            return serviceProgram.asignarPrograma(code, program);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @DeleteMapping("/delete/{program}")
    public ProgramaModel deleteProgram(@PathVariable(name="program") String program)
    {
        try {
            return serviceProgram.quitarPrograma(program);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
