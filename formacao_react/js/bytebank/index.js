import { Cliente } from './Cliente.js';
import { Diretor } from './funcionario/Diretor.js';
import { Gerente } from './funcionario/Gerente.js';
import { SistemaAutenticacao } from './SistemaAutenticacao.js';

const diretor = new Diretor("Rodrigo", 10000, 12345678910);
diretor.cadastrarSenha("123456789");
const gerente = new Gerente("Ricardo", 5000, 12345678911);
gerente.cadastrarSenha("123456789");

const cliente = new Cliente("João", 12345678912, "123456789");
const clienteEstaLogado = SistemaAutenticacao.login(cliente, "123456789");
console.log(clienteEstaLogado);


// const gerenteEstaLogado = SistemaAutenticacao.login(gerente, "123456789");
// console.log(gerenteEstaLogado);

// const diretorEstaLogado = SistemaAutenticacao.login(diretor, "123456789");
// console.log(diretorEstaLogado);


