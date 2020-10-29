/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.bean.Evento;
import model.bean.Instituicao;
import model.dao.DaoEvento;

/**
 *
 * @author Home
 */
public class ServletExcluirEvento extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        Evento evento = new Evento ();
        Instituicao inst = new Instituicao();
        DaoEvento daoEvento = new DaoEvento();
        HttpSession session = request.getSession();
        
        evento.setCodigo(Integer.parseInt(request.getParameter("even_cod")));
        inst.setCod((Integer)session.getAttribute("usercod"));
        evento.setInstituicao(inst);
        try{
            daoEvento.ExcluirEvento(evento);
        } catch (SQLException ex) {
                response.getWriter().println(ex);
        }
        response.sendRedirect("ServletEvento");
    }
}
