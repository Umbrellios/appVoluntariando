package control.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Voluntario;
import model.dao.DaoUsuario;

public class ServletValidaLoginVol extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(); //obtem a sessao do usuario, caso exista
    
        Voluntario vol = new Voluntario();

        vol.setEmail(request.getParameter("vol_email")); // Pega o Login vindo do formulario
        vol.setSenha(request.getParameter("vol_senha")); //Pega a senha vinda do formulario

        try {
            DaoUsuario dao = new DaoUsuario(); //cria uma instancia do DAO usuario
            dao.listaVoluntario(vol);
            //int autenticacao = vol.getCod();
            if (vol.getCod() == 0) {
                session.invalidate();
                String mensagemLogin = "Falha de Login";
                request.setAttribute("mensagemLoginVol", mensagemLogin);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                session.setAttribute("userperfil", vol.getPerfil());
                session.setAttribute("usernome", vol.getNome());
                session.setAttribute("usercod", vol.getCod());
                request.setAttribute("user", vol);
                request.getRequestDispatcher("index.jsp").forward(request, response);

            }

        } catch (SQLException ex) {
            response.getWriter().println(ex);

        }

    }
}
