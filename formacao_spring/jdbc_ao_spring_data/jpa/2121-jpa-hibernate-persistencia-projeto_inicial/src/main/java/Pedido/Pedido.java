package Pedido;

import Cliente.Cliente;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Table(name = "pedidos")
@Entity
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedidos", nullable = false)
    private Long idPedido;
    @Column(name = "valor_total")
    private BigDecimal valorTotal = new BigDecimal(0);
    private LocalDate data = LocalDate.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_clientes")
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemPedido> itemPedidoList = new ArrayList<>();

    public void setItemPedidoList(List<ItemPedido> itemPedidoList) {
        this.itemPedidoList = itemPedidoList;
    }

    public List<ItemPedido> getItemPedidoList() {
        return itemPedidoList;
    }

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pedido() {

    }

    public void adicionarItem(ItemPedido item) {
        item.setPedido(this);
        this.itemPedidoList.add(item);
        this.valorTotal = this.valorTotal.add(item.getValor());
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}