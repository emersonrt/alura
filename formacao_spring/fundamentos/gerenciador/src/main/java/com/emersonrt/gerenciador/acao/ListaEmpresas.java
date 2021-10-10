package com.emersonrt.gerenciador.acao;

import com.emersonrt.gerenciador.modelo.Banco;
import com.emersonrt.gerenciador.modelo.Empresa;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListaEmpresas implements Acao {

    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("listando empresa");

        Banco banco = new Banco();
        List<Empresa> lista = banco.getEmpresas();

        request.setAttribute("empresas", lista);

        return "forward:listaEmpresas.jsp";
    }

}
