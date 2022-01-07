import { Container, Typography } from "@material-ui/core";
import "./App.css";
import FormularioCadastro from "./components/FormularioCadastro/FormularioCadastro";
import "typeface-roboto";

function App() {
    return (
        <Container maxWidth="sm" component="article">
            <Typography variant="h3" component="h1" align="center">
                Formulário de Cadastro
            </Typography>
            <FormularioCadastro />
        </Container>
    );
}

export default App;
