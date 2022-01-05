import { Component } from 'react';
import FormularioCadastro from './components/FormularioCadastro';
import ListaDeNotas from './components/ListaDeNotas';
import ListaDeCategorias from './components/ListaDeCategorias';
import "./assets/App.css";
import "./assets/index.css";
import ArrayDeNotas from './dados/Notas';
import Categorias from './dados/Categorias';

class App extends Component {

	constructor() {
		super();
		this.categorias = new Categorias();
		this.notas = new ArrayDeNotas();
	}

	render() {
		return (
			<div className="conteudo">
				<FormularioCadastro
					criarNota={this.notas.adicionarNota.bind(this.notas)}
					categorias={this.categorias} />
				<main className="conteudo-principal">
					<ListaDeCategorias
						categorias={this.categorias}
						adicionarCategoria={this.categorias.adicionarCategoria.bind(this.categorias)} />
					<ListaDeNotas
						notas={this.notas}
						apagarNota={this.notas.apagarNota.bind(this.notas)} />
				</main>
			</div>

		);
	}
}

export default App;
