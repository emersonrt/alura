package Testes;

import Categoria.Categoria;
import Categoria.CategoriaDao;
import Produto.Produto;
import Produto.ProdutoDao;
import Util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class Testes {


    public static void main(String[] args) {
        cadastrarProduto();

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);

        Produto p = produtoDao.buscarPorId(6l);
        System.out.println(p.getPreco());

        List<Produto> produtos = produtoDao.buscarTodos();
        produtos.forEach(p2 -> System.out.println(p2.getNome()));
    }

    public static void cadastrarProduto( ) {
        Categoria celulares = new Categoria("CELULARES");

        Produto celular = new Produto("Xiaomi",
                "Muito Legal",
                new BigDecimal("800"),
                celulares
        );

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);

        em.getTransaction().begin();
        categoriaDao.cadastrar(celulares);
        produtoDao.cadastrar(celular);
        em.close();
    }

}
