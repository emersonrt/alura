package com.emersonrt.gerenciador.servlet;

import com.emersonrt.gerenciador.acao.Acao;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter("/entrada")
public class ControladorFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws ServletException, IOException {

        System.out.println("ControlladorFilter");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String paramAcao = request.getParameter("acao");
        String nomeDaClasse = "com.emersonrt.gerenciador.acao." + paramAcao;

        Class classe = null;
        String nome = null;
        try {
            classe = Class.forName(nomeDaClasse);
            Acao acao = (Acao) classe.newInstance();
            nome = acao.executa(request, response);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new ServletException();
        }


        String[] tipoEndereco = nome.split(":");
        if (tipoEndereco[0].equals("forward")) {
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/" + tipoEndereco[1]);
            rd.forward(request, response);
        } else if (tipoEndereco[0].equals("redirect")){
            response.sendRedirect(tipoEndereco[1]);
        }

    }
}
