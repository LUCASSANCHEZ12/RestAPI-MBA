package upb.edu.restapimba;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import upb.edu.data.CargoDataAccessInterface;
import upb.edu.data.CargoDataService;
import upb.edu.data.MateriaDataAccessInterface;
import upb.edu.data.MateriaDataService;
import upb.edu.data.UsersDataAccessInterface;
import upb.edu.data.UsersDataService;
import upb.edu.restapimba.Services.CargoBusinessService;
import upb.edu.restapimba.Services.CargoBusinessServiceInterface;
import upb.edu.restapimba.Services.MateriaBusinessService;
import upb.edu.restapimba.Services.MateriaBusinessServiceInterface;
import upb.edu.restapimba.Services.UserBusinessService;
import upb.edu.restapimba.Services.UsersBusinessServiceInterface;

@Configuration
public class SpringConfig {
    @Bean(name="userBusinessService", initMethod = "init", destroyMethod = "destroy")
    @RequestScope
    public UsersBusinessServiceInterface getUsersBusiness(){
        return new UserBusinessService();
    }

    @Bean(name="usersDao")
    @RequestScope
    public UsersDataAccessInterface getDataService(){
        return new UsersDataService();
    }


    @Bean(name="cargoBusinessService", initMethod = "init", destroyMethod = "destroy")
    @RequestScope
    public CargoBusinessServiceInterface getCargoBusiness(){
        return new CargoBusinessService();
    }
    

    @Bean(name="cargosDao")
    @RequestScope
    public CargoDataAccessInterface getDataServiceCargo(){
        return new CargoDataService();
    }

    @Bean(name="materiaBusinessService", initMethod = "init", destroyMethod = "destroy")
    @RequestScope
    public MateriaBusinessServiceInterface getMateriaBusiness(){
        return new MateriaBusinessService();
    }
    

    @Bean(name="materiaDao")
    @RequestScope
    public MateriaDataAccessInterface getDataServiceCargoMateria(){
        return new MateriaDataService();
    }
    
}
