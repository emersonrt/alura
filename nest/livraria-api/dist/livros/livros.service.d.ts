import { Livro } from './livro.model';
export declare class LivrosService {
    private livroModel;
    constructor(livroModel: typeof Livro);
    obterTodos(): Promise<Livro[]>;
    obterUm(id: number): Promise<Livro>;
    criar(livro: Livro): Promise<void>;
    alterar(livro: Livro): Promise<[number, Livro[]]>;
    apagar(id: number): Promise<void>;
}
