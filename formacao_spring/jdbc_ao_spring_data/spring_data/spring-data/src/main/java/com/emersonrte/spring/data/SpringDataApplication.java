package com.emersonrte.spring.data;

import com.emersonrte.spring.data.orm.Cargo;
import com.emersonrte.spring.data.repository.CargoRepository;
import com.emersonrte.spring.data.service.CrudCargoService;
import com.emersonrte.spring.data.service.CrudFuncionarioService;
import com.emersonrte.spring.data.service.CrudUnidadeTrabalhoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

    private Boolean system = true;

    private final CrudCargoService cargoService;
	private final CrudFuncionarioService funcionarioService;
	private final CrudUnidadeTrabalhoService unidadeTrabalhoService;

	public SpringDataApplication(CrudCargoService cargoService, CrudFuncionarioService funcionarioService, CrudUnidadeTrabalhoService unidadeTrabalhoService) {
		this.cargoService = cargoService;
		this.funcionarioService = funcionarioService;
		this.unidadeTrabalhoService = unidadeTrabalhoService;
	}

	public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Scanner scan = new Scanner(System.in);

        while (system) {
            System.out.println("Qual acao voce quer executar");
            System.out.println("0 - Sair");
            System.out.println("1 - Cargo");
            System.out.println("2 - Funcionario");
            System.out.println("3 - Unidade Trabalho");

            int action = scan.nextInt();
            if (action == 1) {
                cargoService.inicial(scan);
            } else if (action == 2) {
                funcionarioService.inicial(scan);
            } else if (action == 3) {
                unidadeTrabalhoService.inicial(scan);
            } else {
                system = false;
            }
        }
    }
}
