/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.filters;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Home
 */
public class FiltroAdministrador implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        
        //VERIFICA SE O USUARIO NA SESSAO EH UMA INSTITUICAO
        String perfil = (String) session.getAttribute("userperfil");
        if (perfil.equals("admin")) {
            chain.doFilter(request, response); //ACEITA A REQUISICAO E REDIRECIONA PARA A SERVLET
        } else {
            resp.sendRedirect("PERFIL INVALIDO"); //NAO ACEITA A REQUISICAO E REDIRECIONA PARA A PAGINA DE ERRO
        }
    }

    @Override
    public void destroy() {
    }
    
    
    
}
