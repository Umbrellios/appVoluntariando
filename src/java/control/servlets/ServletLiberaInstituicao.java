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
import model.bean.Instituicao;
import model.dao.DaoUsuario;

public class ServletLiberaInstituicao extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(); //obtem a sessao do usuario, caso exista

        Instituicao instituicao = null;

        try {
            DaoUsuario dao = new DaoUsuario(); //cria uma instancia do DAO usuario
            instituicao = dao.InstituicaoPendenteAutorizacao();
        } catch (Exception e) {

        }

        if (instituicao == null) {
            session.invalidate();
            String mensagemLiberaInst = "Nenhuma Instituição Pendente de Autorização";
            request.setAttribute("mensagemLiberaInst", mensagemLiberaInst);
            request.getRequestDispatcher("administrador.jsp").forward(request, response);
        } else {
            //se o dao retornar um usuario, coloca o mesmo na sessao
            session.setAttribute("inst", instituicao);
            request.getRequestDispatcher("libera_instituicao.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
