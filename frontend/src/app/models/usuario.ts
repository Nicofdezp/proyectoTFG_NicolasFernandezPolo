
export class User {
    id !: String;
    nombre_usuario !: String;
    email !: String;
    password !: String;
    nombre_completo !: String;
    fecha_nacimiento !: Date;
    genero !: String;
    tarjeta_bancaria !: String;
    trabajador !: boolean;

    constructor(
    id: String,
    nombre_usuario: String,
    email: String,
    password: String,
    nombre_completo: String,
    fecha_nacimiento: Date,
    genero: String,
    tarjeta_bancaria: String,
    trabajador: boolean,
    ){}
}