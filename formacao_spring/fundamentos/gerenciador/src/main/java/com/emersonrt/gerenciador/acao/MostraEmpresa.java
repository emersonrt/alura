package com.emersonrt.gerenciador.acao;

import com.emersonrt.gerenciador.modelo.Banco;
import com.emersonrt.gerenciador.modelo.Empresa;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MostraEmpresa implements Acao {

    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Mostrando empresa");

        String paramId = request.getParameter("id");
        Integer id = Integer.valueOf(paramId);

        Banco banco = new Banco();

        Empresa empresa = banco.buscaEmpresaPelaId(id);

        System.out.println(empresa.getNome());

        request.setAttribute("empresa", empresa);

        return "forward:formAlteraEmpresa.jsp";
    }

}
