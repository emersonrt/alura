import { NestResponse } from 'src/core/http/nest-response';
import { NestResponseBuilder } from './../core/http/nest-response-builder';
import { Body, Controller, Get, HttpStatus, NotFoundException, Param, Post } from '@nestjs/common';
import { Usuario } from './usuario.entity';
import { UsuarioService } from './usuario.service';

@Controller('users')
export class UsuarioController {
    constructor(private usuarioService: UsuarioService) {}

    @Get(':nomeDeUsuario')
    public buscaPorNomeDeUsuario(
        @Param('nomeDeUsuario') nomeDeUsuario: String,
    ): Usuario {
        const usuarioEncontrado = this.usuarioService.buscaPorNomeDeUsuario(nomeDeUsuario);

        if (!usuarioEncontrado) {
            throw new NotFoundException({
                statusCode: HttpStatus.NOT_FOUND,
                message: `Usuário ${nomeDeUsuario} não encontrado`,
            });
        }
        return usuarioEncontrado;
    }

    @Post()
    public cria(@Body() usuario: Usuario): NestResponse {
        const usuarioCriado = this.usuarioService.cria(usuario);
        return new NestResponseBuilder()
            .comStatus(201)
            .comHeader({
                Location: `/users/${usuarioCriado.nomeDeUsuario}`,
            })
            .comBody(usuarioCriado)
            .build();
    }
}
