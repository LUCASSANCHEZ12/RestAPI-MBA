package upb.edu.restapimba.Models;

public class UserModel {
    int CodigoUsuario = 0;
    String PrimerNombre="";
    String SegundoNombre="";
    String ApellidoPaterno="";
    String ApellidoMaterno="";
    String Email="";
    Long Telefono=0L;
    String Password="";
    int CargoId=0;
    String CodigoPrograma="";
    
    public UserModel(int codigoUsuario, String primerNombre, String segundoNombre, String apellidoPaterno,
            String apellidoMaterno, String email, Long telefono, String password, int cargoId, String codigoPrograma) {
        CodigoUsuario = codigoUsuario;
        PrimerNombre = primerNombre;
        SegundoNombre = segundoNombre;
        ApellidoPaterno = apellidoPaterno;
        ApellidoMaterno = apellidoMaterno;
        Email = email;
        Telefono = telefono;
        Password = password;
        CargoId = cargoId;
        CodigoPrograma = codigoPrograma;
    }

    

    @Override
    public String toString() {
        return "UserModel [CodigoUsuario=" + CodigoUsuario + ", PrimerNombre=" + PrimerNombre + ", SegundoNombre="
                + SegundoNombre + ", ApellidoPaterno=" + ApellidoPaterno + ", ApellidoMaterno=" + ApellidoMaterno
                + ", Email=" + Email + ", Telefono=" + Telefono + ", Password=" + Password + ", CargoId=" + CargoId
                + ", CodigoPrograma=" + CodigoPrograma
                + "]";
    }

    

    public int getCodigoUsuario() {
        return CodigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        CodigoUsuario = codigoUsuario;
    }

    public String getPrimerNombre() {
        return PrimerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        PrimerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return SegundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        SegundoNombre = segundoNombre;
    }

    public String getApellidoPaterno() {
        return ApellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        ApellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return ApellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        ApellidoMaterno = apellidoMaterno;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Long getTelefono() {
        return Telefono;
    }

    public void setTelefono(Long telefono) {
        Telefono = telefono;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getCargoId() {
        return CargoId;
    }

    public void setCargoId(int cargoId) {
        CargoId = cargoId;
    }

    public String getCodigoPrograma(){
        return CodigoPrograma;
    }

    public void setCodigoPrograma(String codigoPrograma) {
        CodigoPrograma = codigoPrograma;
    }
    
}
