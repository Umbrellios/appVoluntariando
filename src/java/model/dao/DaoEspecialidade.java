/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.bean.Especialidade;
import model.factory.ConnectionFactory;

/**
 *
 * @author Home
 */
public class DaoEspecialidade extends ConnectionFactory{
    
     public ArrayList<Especialidade> ConsultaEspecialidades() throws SQLException{
        Connection conexao = this.getConexao();
        ArrayList<Especialidade> listaEspecialidades = new ArrayList<>();
        PreparedStatement ps = conexao.prepareStatement ("select * from especialidades");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Especialidade espec = new Especialidade();
            espec.setEspecialidade(rs.getString("espec_descricao"));
            espec.setCodigo(rs.getInt("pk_espec_cod"));
            listaEspecialidades.add(espec);
        }
        return listaEspecialidades;
    }
}
