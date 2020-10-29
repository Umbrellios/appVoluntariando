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
import model.bean.Administrador;
import model.dao.DaoUsuario;

/**
 *
 * @author Home
 */
public class ServletExcluirAdministrador extends HttpServlet {

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

        Administrador admin = new Administrador();
        DaoUsuario daoAdministrador = new DaoUsuario();

        try {
            admin.setCod(Integer.parseInt(request.getParameter("admin_cod")));
            daoAdministrador.ExcluirAdministrador(admin);
        } catch (SQLException ex) {
            response.getWriter().println(ex);
        }
        String mensagemConfirmaExclusao = "Administrador Excluido Com Sucesso";
        request.setAttribute("mensagemConfirmaExclusao", mensagemConfirmaExclusao);
        request.getRequestDispatcher("login.jsp" ).forward(request, response);
    }

}
