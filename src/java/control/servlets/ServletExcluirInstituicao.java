/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
public class ServletExcluirInstituicao extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Instituicao inst = new Instituicao();
        DaoUsuario daoUsuario = new DaoUsuario();
        HttpSession session = request.getSession();
        
        try{
            inst.setCod(Integer.parseInt(request.getParameter("inst_cod")));
            
        }catch(Exception e){
         e.printStackTrace();
            
        }
       
        daoUsuario.ExcluirInstituicao(inst);
        session.invalidate();
        response.sendRedirect("index.jsp");
    }

   

}
