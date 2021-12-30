export class Funcionario {

    constructor (nome, salario, cpf) {

        if (this.constructor === Funcionario) {
            throw new Error("Não é possível instanciar Funcionario diretamente, pois esta é uma classe abstrata.");
        }

        this._nome = nome;
        this._salario = salario;
        this._cpf = cpf;

        this._bonificacao = 1;
        this._senha;
    }

    autenticar(senha) {
        return this._senha === senha;
    }

    cadastrarSenha(senha) {
        this._senha = senha;
    }

}