export class Cliente {

    constructor(nome, cpf, senha) {
        this._nome = nome;
        this._cpf = cpf;
        this._senha = senha;
    }

    autenticar(senha) {
        return this._senha === senha;
    }

    get nome() {
        return this._nome;
    }

    get cpf() {
        return this._cpf;
    }

}