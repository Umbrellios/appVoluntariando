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
public class ServletBuscaInstituicao extends HttpServlet {

    
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
        session.setAttribute("inst", inst);
        request.getRequestDispatcher("avalia_instituicao.jsp" ).forward(request, response);
        }catch (SQLException ex) {
            response.getWriter().println(ex);
        }
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   

}
