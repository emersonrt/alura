import { Produto } from './produto.model';
export declare class ProdutosService {
    private readonly produtos;
    obterTodos(): Produto[];
    obterUm(id: number): Produto;
    criar(produto: Produto): void;
    alterar(produto: Produto): Produto;
    apagar(id: number): void;
}
