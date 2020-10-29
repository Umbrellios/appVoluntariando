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
import model.bean.Administrador;
import model.dao.DaoUsuario;

/**
 *
 * @author Home
 */
public class ServletAlteraSenhaAdmin extends HttpServlet {

   
   

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Administrador admin = new Administrador();
        DaoUsuario dao = new DaoUsuario();
        admin.setCod((Integer) session.getAttribute("usercod"));
        admin.setSenha(request.getParameter("vol_senha"));
        try{
            dao.AtualizaSenhaAdmin(admin);
            session.invalidate();
            PrintWriter out = response.getWriter();
            request.getRequestDispatcher("login.jsp").forward(request, response);
            
        } catch(SQLException ex) {
            response.getWriter().println(ex);
            
        }
        
    }


}
