package com.emersonrt.gerenciador.servlet;

import com.emersonrt.gerenciador.modelo.Banco;
import com.emersonrt.gerenciador.modelo.Empresa;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListaEmpresasService", value = "/empresas")
public class ListaEmpresasService extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Empresa> empresas = new Banco().getEmpresas();

        String valor = request.getHeader("Accept");
        System.out.println("retornar o tipo: " + valor);

        Gson gson = new Gson();
        String json = gson.toJson(empresas);

        response.setContentType("application/json");
        response.getWriter().print(json);
    }

}
