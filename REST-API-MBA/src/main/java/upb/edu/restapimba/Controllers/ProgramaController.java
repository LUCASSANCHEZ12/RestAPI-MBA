package upb.edu.restapimba.Controllers;

import java.util.ArrayList;
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

    @PostMapping("/materia/asign/{programa}")
    public List<MateriaModel> asignMateriaPrograma(@PathVariable(name="programa") String programa, @RequestBody List<MateriaModel> materias){
        try {
            List<MateriaModel> materiasAsignadas = new ArrayList<MateriaModel>();
            for (MateriaModel materiaModel : materias) {
                materiasAsignadas.add(serviceMateria.asignarMateriaPrograma(programa, materiaModel.getCodigoMateria()).getValor1());
            }
            return materiasAsignadas;
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

    @PutMapping("/update")
    public ProgramaModel putMethodName(@RequestBody ProgramaModel programa) {
        try {
            return serviceProgram.updatePrograma(programa);
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

    @GetMapping("/user/{cargo}/materias/{code}")
    public List<MateriaModel> getMethodName(@PathVariable(name="cargo") int cargo, @PathVariable(name="code") long code) {
        try {
            switch (cargo) {
                case 2:
                    return serviceMateria.verMateriasDocente(code);
                case 3:
                    return serviceMateria.verMateriasEstudiante(code);
                default:
                    return null;
            }
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

    @GetMapping("/getMateriasPrograma/{programa}")
    public List<MateriaModel> getMethodName(@PathVariable(name="programa") String program) {
            try {
                return serviceProgram.verMaterias(program);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return null;
            }
    }

    @GetMapping("/materia/getall/users/{materia}/{code}")
    public List<UserModel> getUsuariosMateria(@PathVariable(name="materia") String materia, @PathVariable(name="code") long code) {
        try {
            return serviceMateria.getUsuariosMateria(materia, code);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
}
