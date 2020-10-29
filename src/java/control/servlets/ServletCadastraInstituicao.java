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
import model.bean.Cidade;
import model.bean.Endereco;
import model.bean.Estado;
import model.bean.Instituicao;
import model.bean.JavaMailApp;
import model.dao.DaoUsuario;

public class ServletCadastraInstituicao extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Instituicao inst = new Instituicao();
        Endereco end = new Endereco();
        DaoUsuario daoUsuario = new DaoUsuario();
        Cidade cidade = new Cidade();
        Estado estado = new Estado();
        JavaMailApp email = new JavaMailApp();
        HttpSession session = request.getSession();
        try {
            inst.setNome(request.getParameter("inst_nome"));
            inst.setCnpj(request.getParameter("inst_cnpj"));
            inst.setNomeResp((request.getParameter("inst_nomeresp")));
            inst.setCpfResp(request.getParameter("inst_cpfresp"));
            inst.setEmail(request.getParameter("inst_email"));
            inst.setTelefone(request.getParameter("inst_telefone"));
            inst.setNecessidades(request.getParameter("inst_necessidades"));
            inst.setSenha(request.getParameter("inst_senha"));
            inst.setDadosBanco(request.getParameter("inst_dadosbanco"));
            end.setEndereco(request.getParameter("inst_endereco"));
            cidade.setId(Integer.parseInt(request.getParameter("cidade")));
            estado.setId(Integer.parseInt(request.getParameter("estado")));
            end.setCidade(cidade);
            end.setEstado(estado);
            inst.setEndereco(end);
            daoUsuario.CadastraInstituicao(inst);
            email.NotificaCadastroInstituicao(inst);
            String mensagemConfirmaCadastro = "Instituicao Cadastrada Com Sucesso";
            session.setAttribute("mensagemConfirmaCadastroInst", mensagemConfirmaCadastro);
            response.sendRedirect("login.jsp#instituicao");
        } catch (Exception ex) {
            response.getWriter().println(ex);
        }
       
        
             
    }

  

}
