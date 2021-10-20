package com.emersonrte.spring.data.service;

import com.emersonrte.spring.data.orm.Cargo;
import com.emersonrte.spring.data.orm.Funcionario;
import com.emersonrte.spring.data.orm.UnidadeTrabalho;
import com.emersonrte.spring.data.repository.CargoRepository;
import com.emersonrte.spring.data.repository.FuncionarioRepository;
import com.emersonrte.spring.data.repository.FuncionarioRepository;
import com.emersonrte.spring.data.repository.UnidadeTrabalhoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class CrudFuncionarioService {

    private Boolean system = true;
    private final FuncionarioRepository funcionarioRepository;
    private final UnidadeTrabalhoRepository unidadeTrabalhoRepository;
    private final CargoRepository cargoRepository;

    public CrudFuncionarioService(FuncionarioRepository funcionarioRepository, UnidadeTrabalhoRepository unidadeTrabalhoRepository, CargoRepository cargoRepository) {
        this.funcionarioRepository = funcionarioRepository;
        this.unidadeTrabalhoRepository = unidadeTrabalhoRepository;
        this.cargoRepository = cargoRepository;
    }

    public void inicial(Scanner scan) {

        while (system) {
            System.out.println("Qual acao de funcionario deseja executar?");
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

        System.out.println("Nome do Funcionario");
        String nome = scan.next();
        System.out.println("CPF do Funcionario");
        String cpf = scan.next();
        System.out.println("Salario do Funcionario");
        BigDecimal salario = scan.nextBigDecimal();

        Funcionario funcionario = new Funcionario();
        funcionario.setNome(nome);
        funcionario.setCpf(cpf);
        funcionario.setSalario(salario);
        funcionario.setUnidadeTrabalhoList(unidade(scan));

        System.out.println("Id do cargo");
        Long idCargo = scan.nextLong();
        funcionario.setCargo(cargoRepository.findById(idCargo).orElse(null));

        funcionarioRepository.save(funcionario);
        System.out.println("Salvo");
    }

    private List<UnidadeTrabalho> unidade(Scanner scanner) {
        Boolean isTrue = true;
        List<UnidadeTrabalho> unidadeTrabalhoList = new ArrayList<>();

        while (isTrue) {
            System.out.println("Digite o unidadeId (Para sair digite 0)");
            Long unidadeId = scanner.nextLong();

            if (unidadeId != 0) {
                UnidadeTrabalho unidadeTrabalho = unidadeTrabalhoRepository.findById(unidadeId).orElse(null);
                if (unidadeTrabalho != null) {
                    unidadeTrabalhoList.add(unidadeTrabalho);
                }
            } else {
                isTrue = false;
            }
        }
        return unidadeTrabalhoList;
    }

    public void atualizar(Scanner scan) {
        System.out.println("ID do Funcionario");
        Long id = scan.nextLong();

        if (!funcionarioRepository.existsById(id)) {
            System.out.println("ID inexistente");
            return;
        }

        System.out.println("Nome do Funcionario");
        String nome = scan.next();
        System.out.println("CPF do Funcionario");
        String cpf = scan.next();
        System.out.println("Salario do Funcionario");
        BigDecimal salario = scan.nextBigDecimal();

        Funcionario funcionario = new Funcionario();
        funcionario.setIdFuncionario(id);
        funcionario.setNome(nome);
        funcionario.setCpf(cpf);
        funcionario.setSalario(salario);

        funcionarioRepository.save(funcionario);

        System.out.println("Atualização feita!");
    }

    public void visualizar() {
        Iterable<Funcionario> funcionarios = funcionarioRepository.findAll();
        System.out.println();
        funcionarios.forEach(funcionario -> System.out.println(funcionario));
        System.out.println();
    }
    
    public void deletar(Scanner scan) {
        System.out.println("ID do Funcionario");
        Long id = scan.nextLong();
        funcionarioRepository.deleteById(id);
        System.out.println("Deletado");
    }

}
