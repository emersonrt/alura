import { Injectable } from '@nestjs/common';
import { Usuario } from './usuario.entity';

@Injectable()
export class UsuarioService {
    private usuarios: Array<Usuario> = [
        {
            id: 1,
            nomeDeUsuario: 'usuario1',
            email: 'teste@alura.com',
            senha: '123456',
            nomeCompleto: 'Usuario 1',
            dataDeEntrada: new Date(),
        },
    ];

    public buscaPorNomeDeUsuario(usuario: String): Usuario {
        return this.usuarios.find(
            (usuarioEncontrado) => usuarioEncontrado.nomeDeUsuario === usuario,
        );
    }

    public cria(usuario: Usuario): Usuario {
        this.usuarios.push(usuario);
        return usuario;
    }
}
