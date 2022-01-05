export default class Categorias {

    constructor() {
        this.categorias = [];
        this._inscritos = [];
    }

    adicionarCategoria(categoria) {
        this.categorias.push(categoria);
        this.notificar();
    }

    inscrever(func) {
        this._inscritos.push(func);
    }

    notificar() {
        this._inscritos.forEach(func => func(this.categorias));
    }

    desinscrever(func) {
        this._inscritos = this._inscritos.filter(f => f !== func);
    }

}
