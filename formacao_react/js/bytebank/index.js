import { Cliente } from './Cliente.js';
import { ContaCorrente } from './ContaCorrente.js';
import { ContaPoupanca } from './ContaPoupanca.js';
import { ContaSalario } from './ContaSalario.js';


const cliente = new Cliente("Ricardo", 12345678910);

const contaCorrente = new ContaCorrente(cliente, 1001);
const contaPoupanca = new ContaPoupanca(50, cliente, 1001);
const contaSalario = new ContaSalario(cliente);

console.log(contaSalario.saldo);

contaSalario.depositar(1000);
contaSalario.sacar(100);

console.log(contaSalario.saldo);