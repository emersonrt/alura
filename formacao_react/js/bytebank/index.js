import {Cliente} from './Cliente.js';
import {ContaCorrente} from './ContaCorrente.js';


const c1 = new Cliente("Ricardo", 12345678910);
const c2 = new Cliente("Alicia", 12345678911);


const cc1 = new ContaCorrente(1001, c1);
cc1.depositar(500);

const cc2 = new ContaCorrente(1001, c2);

cc1.transferir(200, cc2);

console.log(c1);
console.log(c2);

console.log(cc1);
console.log(cc2);


console.log(ContaCorrente.numeroContas);