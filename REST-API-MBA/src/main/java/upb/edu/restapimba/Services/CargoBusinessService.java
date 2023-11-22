package upb.edu.restapimba.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import upb.edu.data.CargoDataAccessInterface;
import upb.edu.restapimba.Models.CargoModel;

public class CargoBusinessService implements CargoBusinessServiceInterface
{

    @Autowired
    CargoDataAccessInterface cargosDao;

    @Override
    public void test() {
        // TODO Auto-generated method stub
        System.out.println("Test Method");
    }

    @Override
    public CargoModel getById(int id) 
    {
        return cargosDao.getById(id);
    }

    @Override
    public List<CargoModel> getAllCargos() {
        return cargosDao.getAll();
    }

    @Override
    public void destroy() {
        System.out.println("Destroy method");
    }

    @Override
    public void init() {
        System.out.println("Init method");
    }
    
}
