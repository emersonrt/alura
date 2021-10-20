package com.emersonrte.spring.data.repository;

import com.emersonrte.spring.data.orm.Cargo;
import com.emersonrte.spring.data.orm.Funcionario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Long> {

}
