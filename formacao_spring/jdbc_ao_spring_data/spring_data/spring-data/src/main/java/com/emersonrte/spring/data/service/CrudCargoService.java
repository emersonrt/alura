package com.emersonrte.spring.data.service;

import com.emersonrte.spring.data.orm.Cargo;
import com.emersonrte.spring.data.repository.CargoRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudCargoService {

    private final CargoRepository cargoRepository;
    private Boolean system = true;

    public CrudCargoService(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    public void inicial(Scanner scan) {

        system = true;
        while (system) {
            System.out.println("Qual acao de cargo deseja executar?");
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
        System.out.println("Descricao do Cargo");
        String descricao = scan.next();
        Cargo cargo = new Cargo();
        cargo.setDescricao(descricao);
        cargoRepository.save(cargo);
        System.out.println("Salvo");
    }

    public void atualizar(Scanner scan) {
        System.out.println("ID do Cargo");
        Long id = scan.nextLong();

        if (!cargoRepository.existsById(id)) {
            System.out.println("ID inexistente");
            return;
        }

        System.out.println("Digite a nova descrição:");
        String novaDescricao = scan.next();

        Cargo cargo = new Cargo();
        cargo.setIdCargo(id);
        cargo.setDescricao(novaDescricao);
        cargoRepository.save(cargo);

        System.out.println("Atualização feita!");
    }

    public void visualizar() {
        Iterable<Cargo> cargos = cargoRepository.findAll();
        System.out.println();
        cargos.forEach(System.out::println);
        System.out.println();
    }
    
    public void deletar(Scanner scan) {
        System.out.println("ID do Cargo");
        Long id = scan.nextLong();
        cargoRepository.deleteById(id);
        System.out.println("Deletado");
    }

}
