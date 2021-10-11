package com.emersonrt.gerenciador.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/entrada")
public class MonitoramentoFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        long antes = System.currentTimeMillis();

        String acao = servletRequest.getParameter("acao");

        //executa a acao
        filterChain.doFilter(servletRequest, servletResponse);

        long depois = System.currentTimeMillis();
        System.out.println("Tempo de execução: " + (depois - antes) + ", Ação: " + acao);//teste commit
    }

    @Override
    public void destroy() {

    }
}
