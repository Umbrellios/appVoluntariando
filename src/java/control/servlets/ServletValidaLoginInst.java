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
import javax.servlet.http.HttpSession;
import model.bean.Instituicao;

import model.dao.DaoUsuario;

/**
 *
 * @author Home
 */
public class ServletValidaLoginInst extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(); //obtem a sessao do usuario, caso exista
        
        Instituicao inst = new Instituicao();
        inst.setEmail(request.getParameter("inst_email")); // Pega o Login vindo do formulario
        inst.setSenha(request.getParameter("inst_senha")); //Pega a senha vinda do formulario

        try {
            DaoUsuario dao = new DaoUsuario(); //cria uma instancia do DAO usuario
            dao.listaInstituicao(inst);
            if (inst.getCod() == 0) {
                String mensagemLogin = "Falha de Login";
                session.invalidate();
                request.setAttribute("mensagemLoginInst", mensagemLogin);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                //se o dao retornar um usuario, coloca o mesmo na sessao
                session.setAttribute("userperfil", inst.getPerfil());
                session.setAttribute("usernome", inst.getNome());
                session.setAttribute("usercod", inst.getCod());
                request.setAttribute("user", inst);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }

        } catch (SQLException ex) {
            response.getWriter().println(ex);

        }
    }
}