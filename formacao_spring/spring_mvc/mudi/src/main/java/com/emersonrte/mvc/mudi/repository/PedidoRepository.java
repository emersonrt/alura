package com.emersonrte.mvc.mudi.repository;

import com.emersonrte.mvc.mudi.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
