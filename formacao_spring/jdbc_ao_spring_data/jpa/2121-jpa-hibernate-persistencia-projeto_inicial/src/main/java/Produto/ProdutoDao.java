package Produto;

import javax.persistence.EntityManager;
import java.util.List;

public class ProdutoDao {

    private EntityManager em;

    public ProdutoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Produto produto) {
        this.em.persist(produto);
    }

    public void atualizar(Produto produto) {
        this.em.merge(produto);
    }

    public void remover(Produto produto) {
        produto = this.em.merge(produto);
        this.em.remove(produto);
    }

    public Produto buscarPorId(Long id) {
        return em.find(Produto.class, id);
    }

    public List<Produto> buscarTodos() {
        String jpql = "SELECT p FROM Produto p";
        return em.createQuery(jpql, Produto.class).getResultList();
    }

    public List<Produto> buscarPorNomeDaCategoria(String nome) {
//        String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = :nomeCategoria";
//        return em.createQuery(jpql, Produto.class)
//                .setParameter("nomeCategoria", nome)
//                .getResultList();
        return em.createNamedQuery("Produto.produtosPorCategoria", Produto.class)
                .setParameter("nomeCategoria", nome)
                .getResultList();
    }

}
