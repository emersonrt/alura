package Cliente;

import Pedido.Pedido;
import Produto.Produto;

import javax.persistence.EntityManager;

public class ClienteDao {

    EntityManager em;

    public ClienteDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Cliente cliente) {
        this.em.persist(cliente);
    }

    public Cliente buscarPorId(Long id) {
        return em.find(Cliente.class, id);
    }

}
