/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.bean.Especialidade;
import model.bean.Evento;
import model.bean.Instituicao;
import model.dao.DaoEvento;

/**
 *
 * @author Home
 */
public class ServletAtualizaEvento extends HttpServlet {

   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Evento evento = new Evento ();
        Instituicao inst = new Instituicao();
        DaoEvento daoEvento = new DaoEvento();
        HttpSession session = request.getSession();
        
        try{
            inst.setCod((Integer) session.getAttribute("usercod"));
            evento.setCodigo((Integer) session.getAttribute("evencod"));
            evento.setData(request.getParameter("even_data"));
            evento.setIdadeFaixa1(Integer.parseInt(request.getParameter("even_idade_faixa1")));
            evento.setIdadeFaixa2(Integer.parseInt(request.getParameter("even_idade_faixa2")));
            evento.setDescricao(request.getParameter("even_descricao"));
            evento.setLocal(request.getParameter("even_local"));
            evento.setInstituicao(inst);
            String[] arrayEspec = request.getParameterValues("even_espec");
            for(int i=0; i<arrayEspec.length;i++){
                Especialidade espec = new Especialidade();
                espec.setCodigo(Integer.parseInt(String.valueOf(arrayEspec[i])));
                evento.addEspec(espec);
            }
            daoEvento.AtualizaEvento(evento);
                       
        } catch (Exception ex) {
            response.getWriter().println(ex);
        }
        evento.limpaEspecialidades();
        response.sendRedirect("ServletEvento");
    }
}