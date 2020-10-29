/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.bean.Voluntario;
import model.dao.DaoUsuario;

/**
 *
 * @author Home
 */
@WebServlet(name = "ServletAlteraSenha", urlPatterns = {"/ServletAlteraSenha"})
public class ServletAlteraSenhaVol extends HttpServlet {

   

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Voluntario vol = new Voluntario();
        DaoUsuario dao = new DaoUsuario();
        vol.setCod((Integer) session.getAttribute("usercod"));
        vol.setSenha(request.getParameter("vol_senha"));
        try{
            dao.AtualizaSenhaVol(vol);
            session.invalidate();
            PrintWriter out = response.getWriter();
            request.getRequestDispatcher("login.jsp").forward(request, response);
            
        }catch(SQLException ex) {
            response.getWriter().println(ex);
        }
    }
}
