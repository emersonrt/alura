package com.emersonrt.gerenciador.servlet;

import com.emersonrt.gerenciador.acao.Acao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String paramAcao = request.getParameter("acao");

        HttpSession sessao = request.getSession();
        Boolean usuarioNaoEstaLogado = sessao.getAttribute("usuarioLogado") == null;
        Boolean ehUmaAcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));

        if (ehUmaAcaoProtegida && usuarioNaoEstaLogado) {
            response.sendRedirect("entrada?acao=LoginForm");
            return;
        }

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
