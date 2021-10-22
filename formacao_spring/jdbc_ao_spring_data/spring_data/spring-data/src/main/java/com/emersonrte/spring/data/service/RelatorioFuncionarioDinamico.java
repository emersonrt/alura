package com.emersonrte.spring.data.service;

import com.emersonrte.spring.data.orm.Funcionario;
import com.emersonrte.spring.data.repository.FuncionarioRepository;
import com.emersonrte.spring.data.specification.SpecificationFuncionario;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@Service
public class RelatorioFuncionarioDinamico {

    private final FuncionarioRepository funcionarioRepository;
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public RelatorioFuncionarioDinamico(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public void inicial(Scanner scan) {
        System.out.println("Digite um nome");
        String nome = scan.next();

        if (nome.equalsIgnoreCase("null")) {
            nome = null;
        }

        System.out.println("Digite o cpf");
        String cpf = scan.next();

        if (cpf.equalsIgnoreCase("null")) {
            cpf = null;
        }

        System.out.println("Digite o salario");
        Double salario = scan.nextDouble();

        if (salario == 0) {
            salario = null;
        }

        System.out.println("Digite a data de contratacao");
        String data = scan.next();

        LocalDate dataContratacao;
        if (data.equalsIgnoreCase("null")) {
            dataContratacao = null;
        } else {
            dataContratacao = LocalDate.parse(data, dtf);
        }

        List<Funcionario> list = funcionarioRepository.findAll(Specification
                .where(
                        SpecificationFuncionario.nome(nome)
                                .or(SpecificationFuncionario.cpf((cpf)))
                                .or(SpecificationFuncionario.salario((salario)))
                                .or(SpecificationFuncionario.dataContratacao((dataContratacao)))
                ));
        list.forEach(System.out::println);
    }
}
