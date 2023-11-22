package upb.edu.restapimba.Services;

import java.util.List;

import upb.edu.restapimba.Models.CargoModel;

public interface CargoBusinessServiceInterface
{
    public void test();
    
    public CargoModel getById(int id);

    public List<CargoModel> getAllCargos();

    public void destroy();
    
    public void init();
   
}
