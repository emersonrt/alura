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

        system = true;
        while (system) {
            System.out.println("Qual acao de cargo deseja executar?");

            for (RelatoriosServiceEnum action : RelatoriosServiceEnum.values()) {
                System.out.println(action.getTexto());
            }

            Integer codigoAcao = scan.nextInt();
            RelatoriosServiceEnum rse = RelatoriosServiceEnum.getActionByCodigo(codigoAcao);
            switch (rse) {
                case BUSCAR_FUNCIONARIO_NOME:
                    buscarFuncionarioNome(scan);
                    break;
                case BUSCAR_FUNCIONARIO_NOME_SALARIO_MARIO_DATA:
                    buscaFuncionarioNomeSalarioMaiorData(scan);
                    break;
                case BUSCAR_FUNCIONARIO_DATA_CONTRATACAO:
                    buscaFuncionarioDataContratacao(scan);
                    break;
                case PESQUISA_FUNCIONARIO_SALARIO:
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

        System.out.println("Qual data contratacao deseja pesquisa");
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
