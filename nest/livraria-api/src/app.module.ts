import { Module } from '@nestjs/common';
import { ConfigModule } from '@nestjs/config';
import { SequelizeModule } from '@nestjs/sequelize';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { Livro } from './livros/livro.model';
import { LivrosController } from './livros/livros.controller';
import { LivrosService } from './livros/livros.service';

@Module({
    imports: [
        ConfigModule.forRoot(),
        SequelizeModule.forRoot({
            dialect: 'postgres',
            host: 'localhost',
            port: 5432,
            username: process.env.USUARIO_BANCO_DADOS,
            password: process.env.SENHA_BANCO_DADOS,
            database: 'livraria',
            autoLoadModels: true,
            synchronize: true,
        }),
        SequelizeModule.forFeature([Livro]),
    ],
    controllers: [AppController, LivrosController],
    providers: [AppService, LivrosService],
})
export class AppModule {}
