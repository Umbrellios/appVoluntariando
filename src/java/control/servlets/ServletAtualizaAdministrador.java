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
import model.bean.Administrador;
import model.bean.Cidade;
import model.bean.Endereco;
import model.bean.Estado;
import model.dao.DaoUsuario;

/**
 *
 * @author Home
 */
public class ServletAtualizaAdministrador extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Administrador admin = new Administrador();
        DaoUsuario daoUsuario = new DaoUsuario();
        Endereco end = new Endereco();
        Cidade cidade = new Cidade();
        Estado estado = new Estado();
        try {
            admin.setCod(Integer.parseInt(request.getParameter("admin_cod")));
            admin.setNome(request.getParameter("admin_nome"));
            admin.setRg(request.getParameter("admin_rg"));
            admin.setCpf(request.getParameter("admin_cpf"));
            admin.setEmail(request.getParameter("admin_email"));
            end.setEndereco(request.getParameter("admin_endereco"));
            admin.setTelefone (request.getParameter("admin_telefone"));
            cidade.setId(Integer.parseInt(request.getParameter("cidade")));
            estado.setId(Integer.parseInt(request.getParameter("estado")));
            end.setCidade(cidade);
            end.setEstado(estado);
            admin.setEndereco(end);
            daoUsuario.AtualizaAdministrador(admin);
            daoUsuario.ExibeAdministrador(admin);
            request.setAttribute("user", admin);
            request.getRequestDispatcher("dados_administrador.jsp").forward(request, response);
                    
        } catch (SQLException ex) {
                response.getWriter().println(ex);
            }
        
       
    }   
    
 }
 