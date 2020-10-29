/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.bean.Especialidade;
import model.bean.Evento;
import model.bean.Instituicao;
import model.bean.JavaMailApp;
import model.dao.DaoEvento;
import model.dao.DaoUsuario;


/**
 *
 * @author Home
 */
public class ServletCadastraEvento extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Evento evento = new Evento();
        Instituicao inst = new Instituicao();
        DaoEvento daoEvento = new DaoEvento();
        DaoUsuario daoUsuario = new DaoUsuario();
        JavaMailApp sendMail = new JavaMailApp();
        HttpSession session = request.getSession();
        try {
            evento.setIdadeFaixa1(Integer.parseInt(request.getParameter("even_idade_faixa1")));
            evento.setIdadeFaixa2(Integer.parseInt(request.getParameter("even_idade_faixa2")));
            evento.setData((request.getParameter("even_data")));
            evento.setDescricao(request.getParameter("even_descricao"));
            evento.setLocal(request.getParameter("even_local"));
            String[] arrayEspec = request.getParameterValues("even_espec");
            for(int i=0; i<arrayEspec.length;i++){
                Especialidade espec = new Especialidade();
                espec.setCodigo(Integer.parseInt(String.valueOf(arrayEspec[i])));
                evento.addEspec(espec);
            }
            inst.setCod((Integer) session.getAttribute("usercod"));
            evento.setInstituicao(inst);
            daoUsuario.ExibeInstituicao(inst);
            daoEvento.CadastraEvento(evento);
            ArrayList<Evento> listaemail = daoEvento.ListaEmail(evento);
            
            sendMail.EnviarEmail(listaemail, inst);
            response.sendRedirect("ServletEvento");
        } catch (SQLException ex) {
            response.getWriter().println(ex);
        }
    }
}
