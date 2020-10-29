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
import model.bean.Administrador;
import model.bean.Cidade;
import model.bean.Endereco;
import model.bean.Estado;
import model.bean.JavaMailApp;
import model.dao.DaoUsuario;

/**
 *
 * @author Home
 */
public class ServletCadastraAdministrador extends HttpServlet {

   

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Administrador admin = new Administrador();
        Endereco end = new Endereco();
        DaoUsuario daoUsuario = new DaoUsuario();
        Cidade cidade = new Cidade();
        Estado estado = new Estado(); 
        JavaMailApp email = new JavaMailApp();
        HttpSession session = request.getSession();
        
        try {
            admin.setNome(request.getParameter("admin_nome"));
            admin.setRg(request.getParameter("admin_rg"));
            admin.setCpf(request.getParameter("admin_cpf"));
            admin.setEmail(request.getParameter("admin_email"));
            admin.setTelefone(request.getParameter("admin_telefone"));
            admin.setSenha(request.getParameter("admin_senha"));
            cidade.setId(Integer.parseInt(request.getParameter("cidade")));
            estado.setId(Integer.parseInt(request.getParameter("estado")));
            end.setEndereco(request.getParameter("admin_endereco"));
            end.setCidade(cidade);
            end.setEstado(estado);
            admin.setEndereco(end);
            daoUsuario.CadastraAdministrador(admin);
            email.NotificaCadastroAdministrador(admin);
            String mensagemConfirmaCadastro = "Administrador Cadastrado Com Sucesso";
            session.setAttribute("mensagemConfirmaCadastroAdmin", mensagemConfirmaCadastro);
            response.sendRedirect("login.jsp#administrador");
        
        } catch (Exception ex) {
            response.getWriter().println(ex);
        }
        
    }

    

}
