package upb.edu.restapimba.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import upb.edu.restapimba.Models.CDEModel;
import upb.edu.restapimba.Models.SolucionCDEModel;
import upb.edu.restapimba.Models.Tuple;
import upb.edu.restapimba.Models.UserModel;
import upb.edu.restapimba.Services.CDEBusinessServiceInterface;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/MBA/cde")
public class CDEController {
    
    @Autowired
    CDEBusinessServiceInterface cdeService;

    @GetMapping("/getall")
    public List<CDEModel> getMethodName() {
        return cdeService.getallCDE();
    }
    
    
    @GetMapping("/get/solucion/{code}")
    public SolucionCDEModel getSolucion(@PathVariable(name="code") Long code) {
        try {
            return cdeService.getSolucion(code);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/get/soluciones/{code}")
    public List<SolucionCDEModel> getSolucionesCDE(@PathVariable(name="code") Long code) {
        try {
            return cdeService.getSolucionesCasoEstudio(code);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/materia/getall/cde/{code}")
    public List<CDEModel> getCDEMateriaAll(@PathVariable(name="code") String code) {
        try {
            return cdeService.getCasosEstudioMateria(code);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/materia/get/cde/{code}")
    public CDEModel getCDEMateria(@PathVariable(name="code") long code) {
        try {
            return cdeService.getCasoEstudio(code);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }    
    
    @PutMapping("/update/solucion/{score}/{id}")
    public boolean putCalificacion(@PathVariable(name="score") Float score,@PathVariable(name="id") long code) {
        try {
            return cdeService.updateCalificacion(score, code);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    @PutMapping("/update/")
    public CDEModel putCalificacion(@RequestBody CDEModel cde) {
        try {
            return cdeService.updateCDE(cde);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping("/create/cde")
    public boolean postCDE(@RequestBody CDEModel cde) {
        try {
            return cdeService.createCasoEstudio(cde);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @PostMapping("/create/solucion")
    public boolean postSolucion(@RequestBody Tuple<SolucionCDEModel ,List<UserModel>> tuple) {
        try {
            return cdeService.createSolucionCasoEstudio(tuple.getValor1(), tuple.getValor2());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    @GetMapping("/usuarios/solucion/{code}")
    public List<UserModel> getUsuariosSolucion(@PathVariable(name="code") long code) {
        try {
            return cdeService.getUsuariosSolucion(code);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @DeleteMapping("/delete/{caso}")
    public boolean deleteCDE(@PathVariable(name="caso") long caso){
        return cdeService.deleteCDE(caso);
    }
    
}