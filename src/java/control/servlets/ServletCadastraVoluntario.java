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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.bean.Cidade;
import model.bean.Endereco;
import model.bean.Especialidade;
import model.bean.Estado;
import model.bean.JavaMailApp;
import model.bean.Voluntario;
import model.dao.DaoUsuario;

/**
 *
 * @author Home
 */
public class ServletCadastraVoluntario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        Voluntario vol = new Voluntario();
        DaoUsuario daoUsuario = new DaoUsuario();
        Endereco end = new Endereco();
        Cidade cidade = new Cidade();
        Estado estado = new Estado();
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        
        try {
            Date data = formato.parse(request.getParameter("vol_dtnasc"));
            try {
                vol.setNome(request.getParameter("vol_nome"));
                vol.setRg(request.getParameter("vol_rg"));
                vol.setCpf(request.getParameter("vol_cpf"));
                vol.setEmail(request.getParameter("vol_email"));
                vol.setTelefone(request.getParameter("vol_telefone"));
                vol.setDescricao(request.getParameter("vol_descricao"));
                vol.setDtnasc(data);
                vol.setSenha(request.getParameter("vol_senha"));
                String[] arrayEspec = request.getParameterValues("vol_espec");
                    for(int i=0; i<arrayEspec.length;i++){
                        Especialidade espec = new Especialidade();
                        espec.setCodigo(Integer.parseInt(String.valueOf(arrayEspec[i])));
                        vol.add(espec);
                    }
                end.setEndereco(request.getParameter("vol_endereco"));
                estado.setId(Integer.parseInt(request.getParameter("estado")));
                cidade.setId(Integer.parseInt(request.getParameter("cidade")));
                end.setCidade(cidade);
                end.setEstado(estado);
                vol.setEndereco(end);
                daoUsuario.CadastraVoluntario(vol);
                JavaMailApp email = new JavaMailApp();
                email.NotificaCadastroVoluntario(vol);
                String mensagemConfirmaCadastro = "Voluntario Cadastrado Com Sucesso";
                HttpSession session = request.getSession();
                session.setAttribute("mensagemConfirmaCadastroVol", mensagemConfirmaCadastro);
                response.sendRedirect("login.jsp#voluntario");
            } catch (SQLException ex) {
                response.getWriter().println(ex);
            }
        } catch (ParseException ex) {
            response.getWriter().println(ex);
        }
    }
}
