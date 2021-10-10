package com.emersonrt.gerenciador.modelo;

import java.util.Objects;

public class Usuario {

    private String login;
    private String senha;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean equals(String usuario, String senha) {
        return Objects.equals(this.login, usuario) && Objects.equals(this.senha, senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, senha);
    }
}
