package com.emersonrte.spring.data.service;

import com.emersonrte.spring.data.orm.UnidadeTrabalho;
import com.emersonrte.spring.data.repository.UnidadeTrabalhoRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudUnidadeTrabalhoService {

    private final UnidadeTrabalhoRepository unidadeTrabalhoRepository;
    private Boolean system = true;

    public CrudUnidadeTrabalhoService(UnidadeTrabalhoRepository unidadeTrabalhoRepository) {
        this.unidadeTrabalhoRepository = unidadeTrabalhoRepository;
    }

    public void inicial(Scanner scan) {

        system = true;
        while (system) {
            System.out.println("Qual acao de unidadeTrabalho deseja executar?");
            System.out.println("0 - Sair");
            System.out.println("1 - Salvar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Visualizar Todos");
            System.out.println("4 - Deletar");

            int action = scan.nextInt();
            switch (action) {
                case 1:
                    salvar(scan);
                    break;
                case 2:
                    atualizar(scan);
                    break;
                case 3:
                    visualizar();
                    break;
                case 4:
                    deletar(scan);
                    break;
                default:
                    system = false;
                    break;
            }

        }
    }

    public void salvar(Scanner scan) {

        System.out.println("Descrição da Unidade Trabalho");
        String descricao = scan.next();
        System.out.println("Endereço da Unidade Trabalho");
        String endereco = scan.next();

        UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();
        unidadeTrabalho.setDescricao(descricao);
        unidadeTrabalho.setEndereco(endereco);

        unidadeTrabalhoRepository.save(unidadeTrabalho);
        System.out.println("Salvo");
    }

    public void atualizar(Scanner scan) {

        System.out.println("ID da Unidade Trabalho");
        Long id = scan.nextLong();

        if (!unidadeTrabalhoRepository.existsById(id)) {
            System.out.println("ID inexistente");
            return;
        }

        System.out.println("Descrição da Unidade Trabalho");
        String descricao = scan.next();
        System.out.println("Endereço da Unidade Trabalho");
        String endereco = scan.next();

        UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();
        unidadeTrabalho.setIdUnidadeTrabalho(id);
        unidadeTrabalho.setDescricao(descricao);
        unidadeTrabalho.setEndereco(endereco);

        unidadeTrabalhoRepository.save(unidadeTrabalho);
        System.out.println("Atualização feita!");
    }

    public void visualizar() {
        Iterable<UnidadeTrabalho> unidadeTrabalhoList = unidadeTrabalhoRepository.findAll();
        System.out.println();
        unidadeTrabalhoList.forEach(System.out::println);
        System.out.println();
    }
    
    public void deletar(Scanner scan) {
        System.out.println("ID da Unidade Trabalho");
        Long id = scan.nextLong();
        unidadeTrabalhoRepository.deleteById(id);
        System.out.println("Deletado");
    }

}
