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
import model.bean.Cidade;
import model.bean.Endereco;
import model.bean.Estado;
import model.bean.Instituicao;
import model.dao.DaoUsuario;

/**
 *
 * @author Home
 */
public class ServletAtualizaInstituicao extends HttpServlet {

    
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Instituicao inst = new Instituicao();
        Endereco end = new Endereco();
        DaoUsuario daoUsuario = new DaoUsuario();
        Cidade cidade = new Cidade();
        Estado estado = new Estado();
        HttpSession session = request.getSession();
        try {
            inst.setCod((Integer) session.getAttribute("usercod"));
            inst.setNome(request.getParameter("inst_nome"));
            inst.setCnpj(request.getParameter("inst_cnpj"));
            inst.setNomeResp((request.getParameter("inst_nomeresp")));
            inst.setCpfResp(request.getParameter("inst_cpfResp"));
            inst.setEmail(request.getParameter("inst_email"));
            inst.setTelefone(request.getParameter("inst_telefone"));
            inst.setNecessidades(request.getParameter("inst_necessidades"));
            inst.setDadosBanco(request.getParameter("inst_dadosbanco"));
            end.setEndereco(request.getParameter("inst_endereco"));
            estado.setId(Integer.parseInt(request.getParameter("estado")));
            cidade.setId(Integer.parseInt(request.getParameter("cidade")));
            end.setCidade(cidade);
            end.setEstado(estado);
            inst.setEndereco(end);
            daoUsuario.AtualizaInstituicao(inst);
            daoUsuario.ExibeInstituicao(inst);
            
        } catch (SQLException ex) {
            response.getWriter().println(ex);
        }
        response.sendRedirect("ServletDadosInstituicao");
    }
}
