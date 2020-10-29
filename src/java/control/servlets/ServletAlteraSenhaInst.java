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
public class ServletAlteraSenhaInst extends HttpServlet {

   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Instituicao inst = new Instituicao();
        DaoUsuario daoUsuario = new DaoUsuario();
        inst.setCod((Integer) session.getAttribute("usercod"));
        inst.setSenha(request.getParameter("inst_senha"));
        try{
            daoUsuario.AtualizaSenhaInst(inst);
            session.invalidate();
            PrintWriter out = response.getWriter();
            request.getRequestDispatcher("login.jsp").forward(request, response);
            
        } catch(SQLException ex) {
            response.getWriter().println(ex);
        }
    }
}

    
