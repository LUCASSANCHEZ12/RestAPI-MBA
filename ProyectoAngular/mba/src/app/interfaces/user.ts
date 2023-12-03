export interface User {
    valor1: Usuario;
    valor2: Valor;
}

interface Usuario {
    cargoId: number;
    password: string;
    segundoNombre: string;
    codigoUsuario: number;
    primerNombre: string;
    apellidoPaterno: string;
    apellidoMaterno: string;
    email: string;
    telefono: number;
  }

interface Valor {
    cargoID: number;
    nombreCargo: string;
    descripcion: string;
}
