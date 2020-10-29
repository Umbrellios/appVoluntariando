/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.bean.Cidade;
import model.bean.Endereco;
import model.bean.Especialidade;
import model.bean.Estado;
import model.bean.Voluntario;
import model.dao.DaoUsuario;

/**
 *
 * @author Home
 */
public class ServletAtualizaVoluntario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            Voluntario vol = new Voluntario();
            Endereco end = new Endereco();
            Cidade cidade = new Cidade();
            Estado estado = new Estado();
            DaoUsuario daoUsuario = new DaoUsuario();
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date data = (Date)formato.parse(request.getParameter("vol_dtnasc"));
            
            try {
                vol.setCod((Integer) session.getAttribute("usercod"));
                vol.setNome(request.getParameter("vol_nome"));
                vol.setRg(request.getParameter("vol_rg"));
                vol.setCpf(request.getParameter("vol_cpf"));
                vol.setEmail(request.getParameter("vol_email"));
                vol.setSenha(request.getParameter("vol_senha"));
                vol.setTelefone(request.getParameter("vol_telefone"));
                vol.setDescricao(request.getParameter("vol_descricao"));
                vol.setDtnasc(data);
                estado.setId(Integer.parseInt(request.getParameter("estado")));
                cidade.setId(Integer.parseInt(request.getParameter("cidade")));
                end.setEndereco(request.getParameter("vol_endereco"));
                end.setCidade(cidade);
                end.setEstado(estado);
                vol.setEndereco(end);
                String[] arrayEspec = request.getParameterValues("vol_espec");
                    for(int i=0; i<arrayEspec.length;i++){
                        Especialidade espec = new Especialidade();
                        espec.setCodigo(Integer.parseInt(String.valueOf(arrayEspec[i])));
                        vol.add(espec);
                    }
                daoUsuario.AtualizaVoluntario(vol);
                vol.limparEspeciaidades();
                daoUsuario.ExibeVoluntario(vol);
            } catch (SQLException ex) {
                response.getWriter().println(ex);
            }
            request.setAttribute("user", vol);
            request.getRequestDispatcher("dados_voluntario.jsp").forward(request, response);
            
        } catch (ParseException ex) {
            Logger.getLogger(ServletAtualizaVoluntario.class.getName()).log(Level.SEVERE, null,ex);
        }
            
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("ServletDadosVoluntario").forward(request, response);
        
                
    }

}
    
        

        

    


