package com.emersonrte.spring.data;

import com.emersonrte.spring.data.service.*;
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
    private final RelatoriosService relatoriosService;
    private final RelatorioFuncionarioDinamico relatorioFuncionarioDinamicoService;

	public SpringDataApplication(CrudCargoService cargoService, CrudFuncionarioService funcionarioService, CrudUnidadeTrabalhoService unidadeTrabalhoService, RelatoriosService relatoriosService, RelatorioFuncionarioDinamico relatorioFuncionarioDinamicoService) {
		this.cargoService = cargoService;
		this.funcionarioService = funcionarioService;
		this.unidadeTrabalhoService = unidadeTrabalhoService;
        this.relatoriosService = relatoriosService;
        this.relatorioFuncionarioDinamicoService = relatorioFuncionarioDinamicoService;
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
            System.out.println("4 - Relatorios");
            System.out.println("5 - Relatorio dinamico");

            int action = scan.nextInt();
            selecionaAcao(scan, action);
        }
    }

    private void selecionaAcao(Scanner scan, int action) {
        switch (action) {
            case 1:
                cargoService.inicial(scan);
                break;
            case 2:
                funcionarioService.inicial(scan);
                break;
            case 3:
                unidadeTrabalhoService.inicial(scan);
                break;
            case 4:
                relatoriosService.inicial(scan);
                break;
            case 5:
                relatorioFuncionarioDinamicoService.inicial(scan);
                break;
            default:
                system = false;
                break;
        }
    }
}
