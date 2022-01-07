import { Model } from 'sequelize-typescript';
export declare class Livro extends Model<Livro> {
    codigo: string;
    nome: string;
    preco: number;
}
