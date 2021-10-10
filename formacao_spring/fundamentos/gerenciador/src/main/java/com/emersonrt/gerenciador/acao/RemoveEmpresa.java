package com.emersonrt.gerenciador.acao;

import com.emersonrt.gerenciador.modelo.Banco;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RemoveEmpresa implements Acao {

    public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {

        System.out.println("Removendo empresa");

        String paramId = request.getParameter("id");
        Integer id = Integer.valueOf(paramId);

        System.out.println(id);

        Banco banco = new Banco();
        banco.removeEmpresa(id);

        return "redirect:entrada?acao=ListaEmpresas";
    }

}
