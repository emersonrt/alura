import { Exclude, Expose } from "class-transformer";
import { IsEmail, IsNotEmpty, IsString } from "class-validator";
import { IsNomeDeUsuarioUnico } from "./is-nome-de-usuario-unico.validator";

export class Usuario {
   
    id: number;


    @Expose({
        name: "username",
    })
    @IsNomeDeUsuarioUnico({
        message: "Nome de usuário já cadastrado"
    })
    @IsNotEmpty({
        message: "O nome de usuário não pode ser vazio"
    })
    @IsString()
    nomeDeUsuario: string;


    @Expose({
        name: "email",
    })
    @IsEmail()
    email: string;


    @Expose({
        name: "password"
    })
    @Exclude({
        toPlainOnly: true
    })
    @IsNotEmpty({
        message: "A senha deve ser informada"
    })
    senha: string;


    @Expose({
        name: "fullName",
    })
    @IsNotEmpty({
        message: "O nome completo é obrigatório"
    })
    nomeCompleto: string;

    @Expose({
        name: "joinDate",
    })
    dataDeEntrada: Date;    
}