package com.emersonrte.spring.data.service;

import com.emersonrte.spring.data.orm.Funcionario;
import com.emersonrte.spring.data.orm.FuncionarioProjecao;
import com.emersonrte.spring.data.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@Service
public class RelatoriosService {

    private Boolean system = true;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final FuncionarioRepository funcionarioRepository;

    public RelatoriosService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public void inicial(Scanner scan) {

        while (system) {
            System.out.println("Qual acao de cargo deseja executar?");
            System.out.println("0 - Sair");
            System.out.println("1 - Buscar funcionario nome");
            System.out.println("2 - Buscar funcionario nome, salario e data contratação");
            System.out.println("3 - Buscar funcionario data contratação");
            System.out.println("4 - Pesquisa funcionario salário");

            int action = scan.nextInt();
            switch (action) {
                case 1:
                    buscarFuncionarioNome(scan);
                    break;
                case 2:
                    buscaFuncionarioNomeSalarioMaiorData(scan);
                    break;
                case 3:
                    buscaFuncionarioDataContratacao(scan);
                    break;
                case 4:
                    pesquisaFuncionarioSalario();
                    break;
                default:
                    system = false;
                    break;
            }

        }
    }

    private void buscarFuncionarioNome(Scanner scan) {
        System.out.println("Qual nome deseja pesquisar");
        String nome = scan.next();
        List<Funcionario> funcionarioList = funcionarioRepository.findByNome(nome);

        System.out.println();
        funcionarioList.forEach(System.out::println);
        System.out.println();
    }

    private void buscaFuncionarioNomeSalarioMaiorData(Scanner scan) {
        System.out.println("Qual nome deseja pesquisar");
        String nome = scan.next();

        System.out.println("Qual data contrtacao deseja pesquisa");
        String data = scan.next();
        LocalDate localDate = LocalDate.parse(data, formatter);

        System.out.println("Qual salario deseja pesquisa");
        BigDecimal salario = scan.nextBigDecimal();

        System.out.println();
        List<Funcionario> funcionarioList = funcionarioRepository
                .findNomeSalarioMaiorDataContratacao(nome, salario, localDate);
        funcionarioList.forEach(System.out::println);
        System.out.println();
    }

    public void buscaFuncionarioDataContratacao(Scanner scan) {
        System.out.println("Qual data contrtacao deseja pesquisa");
        String data = scan.next();
        LocalDate localDate = LocalDate.parse(data, formatter);

        List<Funcionario> list = funcionarioRepository.findDataContratacaoMaior(localDate);
        list.forEach(System.out::println);
    }

    public void pesquisaFuncionarioSalario( ) {
        List<FuncionarioProjecao> list = funcionarioRepository.findFuncionarioSalario();
        list.forEach(funcionarioProjecao ->
                System.out.println("Funcionario id : " + funcionarioProjecao.getIdFuncionario() +
                " | nome: " + funcionarioProjecao.getNome() + " | salario: " + funcionarioProjecao.getSalario())
        );
    }

}
