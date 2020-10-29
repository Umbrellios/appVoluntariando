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

public class ServletDadosAdministrador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Administrador admin = new Administrador();
        DaoUsuario dao = new DaoUsuario();
       
        admin.setCod((Integer) session.getAttribute("usercod"));

        try {
            dao.ExibeAdministrador(admin);
            if (admin.getCod() == 0) {
                session.invalidate();
                String mensagemLogin = "Dados Não Encontrados";
                request.setAttribute("mensagemLogin", mensagemLogin);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                request.setAttribute("user", admin);
                request.getRequestDispatcher("dados_administrador.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            response.getWriter().println(ex);
        }
    }
}
