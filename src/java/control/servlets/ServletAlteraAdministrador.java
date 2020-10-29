/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.bean.Administrador;
import model.bean.Endereco;
import model.bean.Especialidade;
import model.bean.Estado;
import model.bean.Voluntario;
import model.dao.DaoEndereco;
import model.dao.DaoEspecialidade;
import model.dao.DaoEvento;
import model.dao.DaoUsuario;

/**
 *
 * @author Home
 */
public class ServletAlteraAdministrador extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Administrador admin = new Administrador();
        DaoEndereco daoEndereco = new DaoEndereco();
        DaoUsuario dao = new DaoUsuario();
        admin.setCod((Integer) session.getAttribute("usercod"));

        try {
            dao.ExibeAdministrador(admin);
            ArrayList<Endereco> lista = daoEndereco.ConsultaEstado();
            request.setAttribute("user", admin);
            request.setAttribute("listaEstado", lista);
            request.getRequestDispatcher("altera_administrador.jsp").forward(request, response);
        } catch (SQLException ex) {
            response.getWriter().println(ex);

        }
       
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
    }
}
