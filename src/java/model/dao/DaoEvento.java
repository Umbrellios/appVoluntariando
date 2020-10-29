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
import model.bean.Evento;
import model.bean.Instituicao;
import model.bean.Voluntario;
import model.factory.ConnectionFactory;

/**
 *
 * @author Home
 */


public class DaoEvento extends ConnectionFactory {
    
    public void CadastraEvento (Evento evento) throws SQLException{
            Instituicao inst = new Instituicao();
            Connection conexao = this.getConexao();
            PreparedStatement ps = conexao.prepareStatement("INSERT INTO evento (even_data, even_descricao, even_inst_cod, even_faixa_idade1, even_faixa_idade2, even_vol_especialidade1, even_vol_especialidade2, even_vol_especialidade3, even_local) values (?,?,?,?,?,?,?,?,?)");
            ps.setString(1, evento.getData());
            ps.setString(2, evento.getDescricao());
            ps.setInt(3, evento.getInstituicao().getCod());
            ps.setInt(4, evento.getIdadeFaixa1());
            ps.setInt(5, evento.getIdadeFaixa2());
            ps.setInt(6, evento.getEspecialidades().get(0).getCodigo());
            ps.setInt(7, evento.getEspecialidades().get(1).getCodigo());
            ps.setInt(8, evento.getEspecialidades().get(2).getCodigo());
            ps.setString(9, evento.getLocal());
            ps.execute();
            ps.close();
            conexao.close();
          
    }
    
    public ArrayList<Evento> ExibeEventos(Instituicao inst) throws SQLException {
        Connection conexao = this.getConexao();
        ArrayList<Evento> listaEventos = new ArrayList<>();
        PreparedStatement ps = conexao.prepareStatement("select e.pk_even_cod, e.even_faixa_idade1, e.even_faixa_idade2, e.even_data, e.even_local, e.even_descricao, ec1.espec_descricao as especialidade1, ec2.espec_descricao as especialidade2, ec3.espec_descricao as especialidade3 from evento AS e\n" +
        "\n" +
        "join especialidades AS ec1 on e.even_vol_especialidade1 = ec1.pk_espec_cod \n" +
        "join especialidades AS ec2 on e.even_vol_especialidade2 = ec2.pk_espec_cod \n" +
        "join especialidades AS ec3 on e.even_vol_especialidade3 = ec3.pk_espec_cod\n" +
        "\n" +
        "where even_inst_cod = ? and even_ativo=1");
            ps.setInt(1, inst.getCod());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Evento evento = new Evento();
                evento.setCodigo(rs.getInt("pk_even_cod"));
                evento.setIdadeFaixa1(rs.getInt("even_faixa_idade1"));
                evento.setIdadeFaixa2(rs.getInt("even_faixa_idade2"));
                evento.setData(rs.getString("even_data"));
                evento.setLocal(rs.getString("even_local"));
                evento.setDescricao(rs.getString("even_descricao"));
                for (int i=1; i<4;i++){
                    Especialidade espec = new Especialidade();
                    espec.setEspecialidade(rs.getString("especialidade"+i));
                    //espec.setCodigo(rs.getInt("even_vol_especialidade"+i));
                    evento.addEspec(espec);                    
                }
            listaEventos.add(evento);
            }
            return listaEventos;
        }
        
    public void ExcluirEvento(Evento evento) throws SQLException {
        Connection conexao = this.getConexao();
        PreparedStatement ps = conexao.prepareStatement("Update evento SET even_ativo = '0' where pk_even_cod = ? and even_inst_cod = ?");
        ps.setInt(1, evento.getCodigo());
        ps.setInt(2, evento.getInstituicao().getCod());
        ps.executeQuery();
        ps.close();
        conexao.close();
    }
    
   
    
    public Evento ConsultaEvento (Evento eventos) throws SQLException{
        ResultSet rs = null;
        Connection conexao = this.getConexao();
        PreparedStatement ps = conexao.prepareStatement("select e.even_vol_especialidade1, e.even_vol_especialidade2, e.even_vol_especialidade3, e.pk_even_cod, e.even_faixa_idade1, e.even_faixa_idade2, e.even_data, e.even_local, e.even_descricao, ec1.espec_descricao as especialidade1, ec2.espec_descricao as especialidade2, ec3.espec_descricao as especialidade3 from evento AS e\n" +
        "\n" +
        "join especialidades AS ec1 on e.even_vol_especialidade1 = ec1.pk_espec_cod \n" +
        "join especialidades AS ec2 on e.even_vol_especialidade2 = ec2.pk_espec_cod \n" +
        "join especialidades AS ec3 on e.even_vol_especialidade3 = ec3.pk_espec_cod\n" +
        "\n" +
        "where pk_even_cod = ? and even_ativo=1");
        ps.setInt(1, eventos.getCodigo());
        rs = ps.executeQuery();
        
        if(rs.next()){
            eventos.setData(rs.getString ("even_data"));
            eventos.setDescricao(rs.getString("even_descricao"));
            eventos.setIdadeFaixa1(rs.getInt("even_faixa_idade1"));
            eventos.setIdadeFaixa2(rs.getInt("even_faixa_idade2"));
            eventos.setLocal(rs.getString("even_local"));
            for (int i=1; i<4;i++){
                Especialidade espec = new Especialidade();
                espec.setEspecialidade(rs.getString("especialidade"+i));
                espec.setCodigo(rs.getInt("even_vol_especialidade"+i));
                eventos.addEspec(espec);                    
            }
        }        
        return eventos;
    }
    
    public void AtualizaEvento(Evento evento) throws SQLException {
        Connection conexao = this.getConexao();
        PreparedStatement ps = conexao.prepareStatement("Update evento SET even_descricao = ? , even_faixa_idade1  = ?, even_faixa_idade2 = ?, even_vol_especialidade1 = ?, even_vol_especialidade2 = ?, even_vol_especialidade3 = ?, even_local = ?, even_data = ? where pk_even_cod = ? and even_inst_cod = ?");
        ps.setString(1, evento.getDescricao());
        ps.setInt(2, evento.getIdadeFaixa1());
        ps.setInt(3, evento.getIdadeFaixa2());
        ps.setInt(4, evento.getEspecialidades().get(0).getCodigo());
        ps.setInt(5, evento.getEspecialidades().get(1).getCodigo());
        ps.setInt(6, evento.getEspecialidades().get(2).getCodigo());
        ps.setString(7, evento.getLocal());
        ps.setString(8, evento.getData());
        ps.setInt(9, evento.getCodigo());
        ps.setInt(10, evento.getInstituicao().getCod());
        ps.executeUpdate();
    }
    
    public ArrayList<Evento> ListaEmail(Evento evento) throws SQLException {
        Connection conexao = this.getConexao();
        ArrayList<Evento> listaEmail = new ArrayList<>();
        PreparedStatement ps = conexao.prepareStatement("select vol_email, vol_nome from voluntario where vol_idade>=? and vol_idade<=?");
        ps.setInt(1, evento.getIdadeFaixa1());
        ps.setInt(2, evento.getIdadeFaixa2());
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Voluntario vol = new Voluntario();
            Evento eventos = new Evento();
            vol.setEmail(rs.getString("vol_email"));
            vol.setNome(rs.getString("vol_nome"));
            eventos.addVol(vol);
            listaEmail.add(eventos);
        }
        return listaEmail;
    }
}
