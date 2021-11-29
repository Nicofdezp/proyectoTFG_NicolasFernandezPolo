export interface UsuarioModel {
    id: String;
    nombre_usuario: String;
    email: String;
    password: String;
    nombre_completo: String;
    fecha_nacimiento: Date;
    genero: String;
    tarjeta_bancaria: String;
    trabajador: boolean;
}

export interface LoginResponse {
    success: boolean;
    user: UsuarioModel;
}

export interface TarjetaBancaria {
    id: String;
    id_usuario: String;
    numero_tarjeta: String;
    saldo: number;
}

export interface ActividadModel {
    id: String;
    nombre_actividad: String;
    tipo_actividad: String;
    descripcion: String;
    dificultad: String;
    materiales_proporcionados: Array<String>;
    materiales_necesarios: Array<String>;
    fecha_inicio: Date;
    fecha_fin: Date;
    precio: number;
    capacidad_minima: number;
    capacidad_maxima: number;
    capacidad_monitor: number;
}