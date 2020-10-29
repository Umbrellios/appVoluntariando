/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Endereco;
import model.dao.DaoEndereco;


/**
 *
 * @author Home
 */
public class ServletListaCidade extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        //Endereco end = new Endereco();
        DaoEndereco daoEndereco = new DaoEndereco();
        int idestado = Integer.parseInt(request.getParameter("codigoestado"));
        
            try{
            ArrayList<Endereco> listaCidade = daoEndereco.ConsultaCidade(idestado);
            StringBuilder sb = new StringBuilder("");
            for(int i =0; i < listaCidade.size(); i++)
                sb.append(listaCidade.get(i).getCidade().getId()+ "-" + listaCidade.get(i).getCidade().getNome()+ ":");
                out.write(sb.toString());
            
            } catch (SQLException ex) {
                response.getWriter().println(ex);
            }
                
                
             
       
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
