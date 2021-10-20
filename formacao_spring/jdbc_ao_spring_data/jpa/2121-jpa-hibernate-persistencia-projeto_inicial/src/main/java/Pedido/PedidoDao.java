package Pedido;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class PedidoDao {

    private final EntityManager em;

    public PedidoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Pedido pedido) {
        this.em.persist(pedido);
    }

    public BigDecimal valorTotalVendido() {
        String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p";
        return em.createQuery(jpql, BigDecimal.class)
                .getSingleResult();
    }

    public List<RelatorioDeVendasDto> relatorioDeVendas() {
        String jpql = "" +
                "SELECT new Pedido.RelatorioDeVendasDto(" +
                "       produto.nome, " +
                "       SUM(item.quantidade), " +
                "       MAX(pedido.data)) " +
                "FROM Pedido pedido " +
                "JOIN pedido.itemPedidoList item " +
                "JOIN item.produto produto " +
                "GROUP BY produto.nome " +
                "ORDER BY SUM(item.quantidade) DESC";
        return em.createQuery(jpql, RelatorioDeVendasDto.class)
                .getResultList();
    }

}
