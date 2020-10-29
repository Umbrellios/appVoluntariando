package control.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.bean.Instituicao;
import model.dao.DaoUsuario;

public class ServletDadosInstituicao extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Instituicao inst = new Instituicao();
        inst.setCod((Integer) session.getAttribute("usercod"));

        try {
            DaoUsuario dao = new DaoUsuario();
            dao.ExibeInstituicao(inst);
            if (inst.getCod() == 0) {
                session.invalidate();
                String mensagemLogin = "Dados Não Encontrados";
                request.setAttribute("mensagemLogin", mensagemLogin);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                request.setAttribute("user", inst);
                request.getRequestDispatcher("dados_instituicao.jsp").forward(request, response);

            }

        } catch (SQLException ex) {
            response.getWriter().println(ex);
        }

    }
}
