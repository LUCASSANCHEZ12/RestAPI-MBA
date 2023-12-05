import { User } from "./user";

export interface UserTuple {
    valor1: User;
    valor2: Valor;
}

interface Valor {
    cargoID: number;
    nombreCargo: string;
    descripcion: string;
}
