package com.emersonrte.spring.data.service;

import com.emersonrte.spring.data.orm.Funcionario;
import com.emersonrte.spring.data.repository.FuncionarioRepository;
import com.emersonrte.spring.data.specification.SpecificationFuncionario;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Scanner;

public class RelatorioFuncionarioDinamico {

    private final FuncionarioRepository funcionarioRepository;

    public RelatorioFuncionarioDinamico(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public void inicial(Scanner scan) {
        System.out.println("Digite um nome");
        String nome = scan.next();

        List<Funcionario> list = funcionarioRepository
                .findAll(Specification.where(SpecificationFuncionario.nome(nome)));

        list.forEach(System.out::println);
    }
}
