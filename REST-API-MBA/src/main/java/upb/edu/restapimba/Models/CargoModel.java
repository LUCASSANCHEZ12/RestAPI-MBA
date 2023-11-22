package upb.edu.restapimba.Models;

public class CargoModel {
    
    int cargoID=0;
    String nombreCargo="";
    String descripcion="";
    public CargoModel(int cargoID, String nombreCargo, String descripcion) {
        this.cargoID = cargoID;
        this.nombreCargo = nombreCargo;
        this.descripcion = descripcion;
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
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
