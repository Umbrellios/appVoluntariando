/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Especialidade;
import model.dao.DaoEspecialidade;


/**
 *
 * @author Home
 */
public class ServletNovoEvento extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        DaoEspecialidade daoEspecialidades = new DaoEspecialidade();
          
        try{
            ArrayList<Especialidade> listaEspecialidades = daoEspecialidades.ConsultaEspecialidades();
            request.setAttribute("listaEspecialidades", listaEspecialidades);
            request.getRequestDispatcher("cadastra_evento.jsp").forward(request, response);
        }catch (SQLException ex) {
            response.getWriter().println(ex);
        }
}

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
}
