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
import model.bean.Cidade;
import model.bean.Endereco;
import model.bean.Estado;
import model.factory.ConnectionFactory;

/**
 *
 * @author Home
 */
public class DaoEndereco extends ConnectionFactory {
    
    public ArrayList<Endereco> ConsultaEstado() throws SQLException {
        
        Connection conexao = this.getConexao();
        ArrayList<Endereco> listaEstado = new ArrayList<>();
        PreparedStatement ps = conexao.prepareStatement("select * from tb_estado");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Endereco end = new Endereco();
            Estado estado = new Estado();
            estado.setId(rs.getInt("est_id"));
            estado.setNome(rs.getString("est_nome"));
            end.setEstado(estado);
            listaEstado.add(end);
        }
        return listaEstado;
    }

    public ArrayList<Endereco> ConsultaCidade(int idestado) throws SQLException {

        Connection conexao = this.getConexao();
        ArrayList<Endereco> listaCidade = new ArrayList<>();
        PreparedStatement ps;
            ps = conexao.prepareStatement("select * from tb_cidade where id_estado = ?");
            ps.setInt(1, idestado);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Endereco end = new Endereco();
                Cidade cidade = new Cidade();
                Estado estado = new Estado();
                cidade.setId(rs.getInt("cid_id"));
                cidade.setNome(rs.getString("cid_nome"));
                estado.setId(rs.getInt("id_estado"));
                end.setCidade(cidade);
                end.setEstado(estado);
                listaCidade.add(end);
            }
        return listaCidade;
    }
}
