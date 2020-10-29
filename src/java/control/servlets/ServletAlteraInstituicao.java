/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.servlets;

import classes.Instituicoes;
import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.bean.Endereco;
import model.bean.Estado;
import model.bean.Instituicao;
import model.dao.DaoEndereco;
import model.dao.DaoUsuario;

/**
 *
 * @author Home
 */
public class ServletAlteraInstituicao extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        DaoUsuario daoUsuario = new DaoUsuario();
        Instituicao inst = new Instituicao();
        DaoEndereco daoEndereco = new DaoEndereco();
        inst.setCod((Integer) session.getAttribute("usercod"));

        try {
            daoUsuario.ExibeInstituicao(inst);
            ArrayList<Endereco> lista = daoEndereco.ConsultaEstado();
            request.setAttribute("user", inst);
            request.setAttribute("listaEstado", lista);
            request.getRequestDispatcher("altera_instituicao.jsp").forward(request, response);
        } catch (SQLException ex) {
            response.getWriter().println(ex);

        }
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
