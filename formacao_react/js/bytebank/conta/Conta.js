//Classe abstrata
export class Conta {

    constructor(saldo, cliente, agencia) {

        if (this.constructor === Conta) {
            throw new Error("Não é possível instanciar Conta diretamente, pois esta é uma classe abstrata.");
        }

        this._saldo = saldo;
        this._cliente = cliente;
        this._agencia = agencia;
    }

    set cliente(cliente) {
        if (cliente instanceof Cliente) {
            this._cliente = cliente;
        }
    }

    get cliente() {
        return this._cliente;
    }

    get saldo() {
        return this._saldo;
    }

    //Método abstrato
    sacar(valor) {
        throw new Error("O método sacar deve ser implementado em uma classe filha.");
    }

    _sacar(valor, taxa) {
        const valorSacado = taxa * valor;
        if (this._saldo < valorSacado) return 0;

        this._saldo -= valorSacado;
        return valorSacado;
    }

    depositar(valor) {

        if (valor < 0) return;
        this._saldo += valor;
    }

    transferir(valor, conta) {
        const valorSacado = this.sacar(valor);
        conta.depositar(valorSacado);
    }
}