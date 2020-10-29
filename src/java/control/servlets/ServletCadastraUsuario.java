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
import model.bean.Endereco;
import model.bean.Especialidade;
import model.bean.Estado;
import model.dao.DaoEndereco;
import model.dao.DaoEspecialidade;
import model.dao.DaoEvento;
import model.dao.DaoUsuario;

/**
 *
 * @author Home
 */
public class ServletCadastraUsuario extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        DaoEspecialidade daoEspecialidades = new DaoEspecialidade();
        DaoEndereco daoEndereco = new DaoEndereco();
        String perfil = request.getParameter("userperfil");
        
        try {
            if (perfil.equals("vol")) {
                ArrayList<Especialidade> listaEspecialidades = daoEspecialidades.ConsultaEspecialidades();
                ArrayList<Endereco> lista = daoEndereco.ConsultaEstado();
                request.setAttribute("listaEspecialidades", listaEspecialidades);
                request.setAttribute("listaEstado", lista);
                request.getRequestDispatcher("cadastra_voluntario.jsp").forward(request, response);
            }if (perfil.equals("inst")) {
                ArrayList<Especialidade> listaEspecialidades = daoEspecialidades.ConsultaEspecialidades();
                ArrayList<Endereco> lista = daoEndereco.ConsultaEstado();
                request.setAttribute("listaEspecialidades", listaEspecialidades);
                request.setAttribute("listaEstado", lista);
                request.getRequestDispatcher("cadastra_instituicao.jsp").forward(request, response);
            }if (perfil.equals("admin")){
                ArrayList<Especialidade> listaEspecialidades = daoEspecialidades.ConsultaEspecialidades();
                ArrayList<Endereco> lista = daoEndereco.ConsultaEstado();
                request.setAttribute("listaEspecialidades", listaEspecialidades);
                request.setAttribute("listaEstado", lista);
                request.getRequestDispatcher("cadastra_administrador.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            response.getWriter().println(ex);

        }
    }
       
    

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
       
    }

    

}
