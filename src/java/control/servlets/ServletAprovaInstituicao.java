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
import model.bean.Instituicao;
import model.dao.DaoUsuario;

/**
 *
 * @author Home
 */
public class ServletAprovaInstituicao extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Instituicao inst = new Instituicao();
        DaoUsuario daoUsuario = new DaoUsuario();
        try {
            inst.setCod(Integer.parseInt(request.getParameter("inst_cod")));
            inst.setAdmin_autorizacao(Integer.parseInt(request.getParameter("admin_cod")));
            inst.setAutorizacao(1);
            daoUsuario.AprovaInstituicao(inst);
        } catch (SQLException ex) {
                response.getWriter().println(ex);
            }
        request.getRequestDispatcher("libera_instituicao.jsp" ).forward(request, response);
    }
}
