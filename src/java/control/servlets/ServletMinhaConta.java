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
import model.bean.Instituicao;
import model.bean.Usuario;
import model.bean.Voluntario;
import model.dao.DaoUsuario;

/**
 *
 * @author Home
 */
public class ServletMinhaConta extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Usuario user = new Usuario();
        Voluntario vol = new Voluntario();
        Instituicao inst = new Instituicao();
        Administrador admin = new Administrador();
        String perfil = (String) session.getAttribute("userperfil");

        try {
            if (perfil.equals("vol")) {
                vol.setCod((Integer) session.getAttribute("usercod"));
                DaoUsuario dao = new DaoUsuario();//cria uma instancia do DAO usuario
                dao.ExibeVoluntario(vol);
                request.setAttribute("user", vol);
                request.getRequestDispatcher("dashboard.jsp").forward(request, response);
            }if (perfil.equals("inst")) {
                inst.setCod((Integer) session.getAttribute("usercod"));
                DaoUsuario dao = new DaoUsuario();//cria uma instancia do DAO usuario
                dao.ExibeInstituicao(inst);
                request.setAttribute("user", inst);
                request.getRequestDispatcher("dashboard.jsp").forward(request, response);
            }if (perfil.equals("admin")){
                admin.setCod((Integer) session.getAttribute("usercod"));
                DaoUsuario dao = new DaoUsuario();//cria uma instancia do DAO usuario
                dao.ExibeAdministrador(admin);
                request.setAttribute("user", admin);
                request.getRequestDispatcher("dashboard.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            response.getWriter().println(ex);

        }
    }

}
