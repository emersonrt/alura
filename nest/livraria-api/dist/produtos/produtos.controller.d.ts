import { Produto } from './produto.model';
import { ProdutosService } from './produtos.service';
export declare class ProdutosController {
    private produtosService;
    constructor(produtosService: ProdutosService);
    obterTodos(): Produto[];
    obterUm(params: any): Produto;
    criar(produto: Produto): void;
    alterar(produto: Produto): Produto;
    apagar(params: any): void;
}
