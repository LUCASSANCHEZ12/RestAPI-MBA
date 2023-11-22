package upb.edu.data;

import java.util.List;

import upb.edu.restapimba.Models.CargoModel;

public interface CargoDataAccessInterface
{
    public CargoModel getById(int id);

    public List<CargoModel> getAll();
}
