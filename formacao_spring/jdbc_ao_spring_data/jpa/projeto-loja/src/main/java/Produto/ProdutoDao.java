package Produto;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.time.LocalDate;
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

    public List<Produto> buscarPorParametros(String nome, BigDecimal preco, LocalDate dataCadastro) {
        String jpql = "SELECT p FROM Produto p WHERE TRUE";
        if (nome != null && !nome.trim().isEmpty()) {
            jpql += "AND p.nome = :nome ";
        }
        if (preco != null) {
            jpql += "AND p.preco = :preco ";
        }
        if (dataCadastro != null) {
            jpql += "AND p.dataCadastro = :dataCadastro ";
        }

        TypedQuery<Produto> q = em.createQuery(jpql, Produto.class);
        if (nome != null && !nome.trim().isEmpty()) {
            q.setParameter("nome", nome);
        }
        if (preco != null) {
            q.setParameter("preco", preco);
        }
        if (dataCadastro != null) {
            q.setParameter("dataCadastro", dataCadastro);
        }
        return q.getResultList();
    }

    public List<Produto> buscarPorParametrosComCriteria(String nome, BigDecimal preco, LocalDate dataCadastro) {

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Produto> query = builder.createQuery(Produto.class);
        Root<Produto> from = query.from(Produto.class);

        Predicate filtros = builder.and();
        if (nome != null && !nome.trim().isEmpty()) {
            filtros = builder.and(filtros, builder.equal(from.get("nome"), nome));
        }
        if (preco != null) {
            filtros = builder.and(filtros, builder.equal(from.get("preco"), preco));
        }
        if (dataCadastro != null) {
            filtros = builder.and(filtros, builder.equal(from.get("dataCadastro"), dataCadastro));
        }

        query.where(filtros);
        return em.createQuery(query).getResultList();
    }

}
