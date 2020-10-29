package control.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.bean.Especialidade;
import model.bean.Evento;
import model.dao.DaoEspecialidade;
import model.dao.DaoEvento;

/**
 *
 * @author Home
 */
public class ServletAlteraEvento extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Evento eventos = new Evento();
        DaoEvento daoEventos = new DaoEvento();
        DaoEspecialidade daoEspecialidades = new DaoEspecialidade();
        eventos.setCodigo(Integer.parseInt(request.getParameter("even_cod")));
        try{
            ArrayList<Especialidade> listaEspecialidades = daoEspecialidades.ConsultaEspecialidades();
            daoEventos.ConsultaEvento(eventos);
            session.setAttribute("evencod", eventos.getCodigo());
            request.setAttribute("listaEspecialidades", listaEspecialidades);
            request.setAttribute("eventos", eventos);
            request.getRequestDispatcher("altera_evento.jsp").forward(request, response);
        }catch (SQLException ex) {
            response.getWriter().println(ex);
        }
       // response.sendRedirect("ServletEvento");
    }
}
