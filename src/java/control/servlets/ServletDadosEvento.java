package control.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.bean.Evento;
import model.bean.Instituicao;
import model.dao.DaoEvento;

public class ServletDadosEvento extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Instituicao inst = new Instituicao();
        DaoEvento daoEvento = new DaoEvento();
        HttpSession session = request.getSession();
        inst.setCod((Integer) session.getAttribute("usercod"));
        try {
            ArrayList<Evento>exibeEventos = new ArrayList<Evento>();
            exibeEventos = daoEvento.ExibeEventos(inst);
            if (exibeEventos.isEmpty()){
                String mensagemEventos = "Nenhum Evento Encontrado";
                request.setAttribute("mensagemEventos", mensagemEventos);
                request.getRequestDispatcher("eventos.jsp").forward(request, response);
            } else {
                request.setAttribute("eventos", exibeEventos);
                request.getRequestDispatcher("eventos.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            response.getWriter().println(ex);
        }
    }
}
