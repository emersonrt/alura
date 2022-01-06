import React from 'react';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import { FormControlLabel, Switch } from '@material-ui/core';

function FormularioCadastro() {

    return (
        <form>

            <TextField id="nome" label="Nome" variant="outlined" fullWidth margin="normal" />
            <TextField id="sobrenome" label="Sobrenome" variant="outlined" fullWidth margin="normal" />
            <TextField id="cpf" label="CPF" variant="outlined" fullWidth margin="normal" />

            <FormControlLabel
                control={
                    <Switch
                        defaultChecked
                        color="primary"
                        name="promocoes"
                        inputProps={{ 'aria-label': 'primary checkbox' }}
                    />
                }
                label="Promoções"
            />

            <FormControlLabel
                control={
                    <Switch
                        defaultChecked
                        color="primary"
                        name="novidades"
                        inputProps={{ 'aria-label': 'primary checkbox' }}
                    />
                }
                label="Novidades"
            />

            <Button variant="contained" color="primary" type="submit">Cadastrar</Button>
        </form>
    );

}

export default FormularioCadastro;