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
import model.bean.Instituicao;
import model.dao.DaoUsuario;

/**
 *
 * @author Home
 */
public class ServletBuscaAvaliaInst extends HttpServlet {

     
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Instituicao inst = null;
        Instituicao instituicao = new Instituicao();
        DaoUsuario dao = new DaoUsuario();
        
        try{
        instituicao.setCod(Integer.parseInt(request.getParameter("inst_cod")));
        inst = dao.BuscaInstituicao(instituicao);
        } catch (SQLException ex) {
                response.getWriter().println(ex);
        }
        
        session.setAttribute("inst", inst);
        request.getRequestDispatcher("editar_avaliacao.jsp" ).forward(request, response);
        
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   

}