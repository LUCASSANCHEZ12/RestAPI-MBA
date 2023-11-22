package upb.edu.restapimba.Models;

public class CargoModel {
    
    int cargoID=0;
    String nombreCargo="";
    public CargoModel(int cargoID, String nombreCargo) {
        this.cargoID = cargoID;
        this.nombreCargo = nombreCargo;
    }
    public int getCargoID() {
        return cargoID;
    }
    public void setCargoID(int cargoID) {
        this.cargoID = cargoID;
    }
    public String getNombreCargo() {
        return nombreCargo;
    }
    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }

}
