/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.servlets;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.bean.Administrador;
import model.dao.DaoUsuario;


public class ServletValidaLoginAdmin extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(); //obtem a sessao do usuario, caso exista
        
        Administrador admin = new Administrador();
        admin.setEmail(request.getParameter("admin_email")); // Pega o Login vindo do formulario
        admin.setSenha(request.getParameter("admin_senha")); //Pega a senha vinda do formulario
 
        try {
            DaoUsuario dao = new DaoUsuario(); //cria uma instancia do DAO usuario
            dao.listaAdministrador(admin);
            if (admin.getCod() == 0) {
                session.invalidate();
                String mensagemLogin = "Falha de Login";
                request.setAttribute("mensagemLoginAdmin", mensagemLogin);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                session.setAttribute("userperfil", admin.getPerfil());
                session.setAttribute("usernome", admin.getNome());
                session.setAttribute("usercod", admin.getCod());
                request.setAttribute("user", admin);
                request.getRequestDispatcher("index.jsp").forward(request, response);

            }
        }
        catch (SQLException ex) {
            response.getWriter().println(ex);

 
        }
 
        
    }
        
    

    

}
