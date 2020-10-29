/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Avaliacao;
import model.dao.DaoUsuario;

/**
 *
 * @author Home
 */
public class ServletAtualizaAvaliacaoInst extends HttpServlet {

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Avaliacao aval = new Avaliacao();
        DaoUsuario daoUsuario = new DaoUsuario();
        try{
        aval.setCod_inst(Integer.parseInt(request.getParameter("inst_cod")));
        aval.setCod_vol(Integer.parseInt(request.getParameter("vol_cod")));
        aval.setNota(Integer.parseInt(request.getParameter("inst_nota")));
        daoUsuario.AtualizaAvaliacao(aval);
        
        } catch (SQLException ex) {
                response.getWriter().println(ex);
            }
        String mensagemConfirmaAvaliacao = "Avaliação Atualizada Com Sucesso";
        request.setAttribute("mensagemConfirmaAvaliacao", mensagemConfirmaAvaliacao);
        request.getRequestDispatcher("instituicoes.jsp" ).forward(request, response);

    }

}