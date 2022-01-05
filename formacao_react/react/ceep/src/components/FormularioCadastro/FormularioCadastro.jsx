import React, { Component } from "react";
import "./estilo.css";

class FormularioCadastro extends Component {

    constructor(props) {
        super(props);
        this.titulo = "";
        this.texto = "";
        this.categoria = "Sem Categoria";
        this.state = { categorias: [] };

        this._novasCategorias = this._novasCategorias.bind(this);
    }

    componentDidMount() {
        this.props.categorias.inscrever(this._novasCategorias);
        
    }

    componentWillUnmount() {
        this.props.categorias.desinscrever(this._novasCategorias);
    }

    _novasCategorias(categorias) {
        this.setState({ ...this.state, categorias });
    }

    _handleMudancaTitulo(evento) {
        evento.stopPropagation();
        this.titulo = evento.target.value;
    }

    _handleMudancaTexto(evento) {
        evento.stopPropagation();
        this.texto = evento.target.value;
    }

    _handleMudancaCategoria(evento) {
        evento.stopPropagation();
        this.categoria = evento.target.value;
    }

    _criarNota(evento) {
        evento.preventDefault();
        evento.stopPropagation();
        this.props.criarNota(this.titulo, this.texto, this.categoria);
    }

    render() {
        return (
            <form className="form-cadastro"
                onSubmit={this._criarNota.bind(this)}>
                <select
                    name="categorias"
                    id="categorias"
                    className="form-cadastro_input"
                    onChange={this._handleMudancaCategoria.bind(this)}>
                    <option>Sem Categoria</option>

                    {this.state.categorias.map((categoria, index) => {
                        return <option key={index}>{categoria}</option>
                    })}

                </select>
                <input
                    type="text"
                    placeholder="titulo"
                    className="form-cadastro_input"
                    onChange={this._handleMudancaTitulo.bind(this)}
                />
                <textarea
                    name="escrevaNota"
                    id="escrevaNota"
                    rows={15}
                    placeholder="Escreva sua nota..."
                    className="form-cadastro_input"
                    onChange={this._handleMudancaTexto.bind(this)} />
                <button className="form-cadastro_unput form-cadastro_submit">
                    Criar Nota
                </button>
            </form>
        );
    }

}

export default FormularioCadastro;