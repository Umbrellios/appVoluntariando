/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.bean.Voluntario;
import model.dao.DaoUsuario;

/**
 *
 * @author Home
 */
public class ServletExcluirVoluntario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Voluntario vol = new Voluntario();
        DaoUsuario daoUsuario = new DaoUsuario();

        try {
            vol.setCod(Integer.parseInt(request.getParameter("vol_cod")));
            daoUsuario.ExcluirVoluntario(vol);
        } catch (Exception e) {
            e.printStackTrace();

        }
        session.invalidate();
        response.sendRedirect("index.jsp");
        
    }

}
