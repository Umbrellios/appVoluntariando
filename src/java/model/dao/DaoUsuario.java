package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.bean.Administrador;
import model.bean.Avaliacao;
import model.bean.Cidade;
import model.bean.Endereco;
import model.bean.Especialidade;
import model.bean.Estado;
import model.bean.Instituicao;
import model.bean.Voluntario;
import model.factory.ConnectionFactory;

public class DaoUsuario extends ConnectionFactory {

//AÇôes do Voluntario
//Consultar, Adicionar, Excluir
    

    public void ExcluirVoluntario(Voluntario vol) throws SQLException {

            Connection conexao = this.getConexao();
            PreparedStatement ps = conexao.prepareStatement("Update voluntario SET vol_ativo = '0' where pk_vol_cod = ?");
            ps.setInt(1, vol.getCod());
            ps.executeQuery();
            ps.close();
            conexao.close();
    }

    public Voluntario listaVoluntario(Voluntario vol) throws SQLException {
        ResultSet rs = null;

        Connection conexao = this.getConexao();
        PreparedStatement ps = conexao.prepareStatement("select pk_vol_cod, vol_nome, vol_perfil from voluntario where vol_email= ? and vol_senha = ? and vol_ativo = '1'");
        ps.setString(1, vol.getEmail());
        ps.setString(2, vol.getSenha());

        rs = ps.executeQuery();

        if (rs.next()) {

            vol.setCod(rs.getInt("pk_vol_cod"));
            vol.setNome(rs.getString("vol_nome"));
            vol.setPerfil(rs.getString("vol_perfil"));
        }
        return vol;
    }

    public Voluntario ExibeVoluntario(Voluntario vol) throws SQLException {
        ResultSet rs = null;
        Connection conexao = this.getConexao();
        PreparedStatement ps = conexao.prepareStatement("select voluntario.*, vol_espec_cod_1, vol_espec_cod_2, vol_espec_cod_3, est_nome, cid_nome, espec1.espec_descricao as especialidade1, espec2.espec_descricao as especialidade2, espec3.espec_descricao as especialidade3\n" +
"from voluntario \n" +
"inner join tb_estado on (vol_estado = est_id) \n" +
"inner join tb_cidade on (vol_cidade = cid_id) \n" +
"inner join especialidades as espec1 on (vol_espec_cod_1 = espec1.pk_espec_cod)\n" +
"inner join especialidades  as espec2 on (vol_espec_cod_2 = espec2.pk_espec_cod)\n" +
"inner join especialidades  as espec3 on (vol_espec_cod_3 = espec3.pk_espec_cod)   \n" +
"where pk_vol_cod =? and vol_ativo = '1'");
        ps.setInt(1, vol.getCod());

        rs = ps.executeQuery();
       Endereco end = new Endereco();
       Cidade cidade = new Cidade();
       Estado estado = new Estado();
        if (rs.next()) {

            vol.setCod(rs.getInt("pk_vol_cod"));
            vol.setEmail(rs.getString("vol_email"));
            vol.setSenha(rs.getString("vol_senha"));
            vol.setNome(rs.getString("vol_nome"));
            vol.setRg(rs.getString("vol_rg"));
            vol.setCpf(rs.getString("vol_cpf"));
            end.setEndereco(rs.getString("vol_end"));
            estado.setNome(rs.getString("est_nome"));
            cidade.setNome(rs.getString("cid_nome"));
            estado.setId(rs.getInt("vol_estado"));
            cidade.setId(rs.getInt("vol_cidade"));
            end.setCidade(cidade);
            end.setEstado(estado);
            vol.setEndereco(end);
            vol.setDescricao(rs.getString("vol_descricao"));
            vol.setDtnasc(rs.getDate("vol_dtnasc"));
            vol.setTelefone(rs.getString("vol_tel"));
            vol.setPerfil(rs.getString("vol_perfil"));
            for (int i=1; i<4; i++){
              Especialidade espec = new Especialidade();
              espec.setEspecialidade(rs.getString("especialidade"+i));
              espec.setCodigo(rs.getInt("vol_espec_cod_"+i));
              vol.add(espec);
            }
        }
        return vol;
    }

    public Voluntario AtualizaVoluntario(Voluntario vol) throws SQLException {
        Connection conexao = this.getConexao();
        PreparedStatement ps = conexao.prepareStatement("Update voluntario SET vol_nome = ?, vol_rg = ?, vol_cpf = ?,vol_email = ?, vol_tel = ?, vol_end = ?, "
                + "vol_descricao = ?, vol_dtnasc = ?, vol_estado= ?, vol_cidade= ?, vol_espec_cod_1= ?, vol_espec_cod_2= ?, vol_espec_cod_3= ? where pk_vol_cod = ?");
        
        ps.setString(1, vol.getNome());
        ps.setString(2, vol.getRg());
        ps.setString(3, vol.getCpf());
        ps.setString(4, vol.getEmail());
        ps.setString(5, vol.getTelefone());
        ps.setString(6, vol.getEndereco().getEndereco());
        ps.setString(7, vol.getDescricao());
        ps.setDate(8, new java.sql.Date(vol.getDtnasc().getTime()));
        ps.setInt(9, vol.getEndereco().getEstado().getId());
        ps.setInt(10, vol.getEndereco().getCidade().getId());
        ps.setInt(11, vol.getEspecialidades().get(0).getCodigo());
        ps.setInt(12, vol.getEspecialidades().get(1).getCodigo());
        ps.setInt(13, vol.getEspecialidades().get(2).getCodigo());
        ps.setInt(14, vol.getCod());
        ps.executeUpdate();
        return null;
    }

    public Voluntario AtualizaSenhaVol(Voluntario vol) throws SQLException {
        ResultSet rs = null;

        Connection conexao = this.getConexao();
        PreparedStatement ps = conexao.prepareStatement("Update voluntario SET vol_senha = ? where pk_vol_cod = ?");
        ps.setString(1, vol.getSenha());
        ps.setInt(2, vol.getCod());
        ps.executeUpdate();
        return null;

    }
    
    public Voluntario CadastraVoluntario(Voluntario vol) throws SQLException {
        
        Connection conexao = this.getConexao();
            PreparedStatement ps = conexao.prepareStatement("INSERT INTO voluntario (vol_nome, vol_rg, vol_cpf, vol_email, vol_tel, vol_senha, vol_end, vol_descricao, vol_espec_cod_1, vol_espec_cod_2, vol_espec_cod_3, vol_dtnasc, vol_cidade, vol_estado) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, vol.getNome());
            ps.setString(2, vol.getRg());
            ps.setString(3, vol.getCpf());
            ps.setString(4, vol.getEmail());
            ps.setString(5, vol.getTelefone());
            ps.setString(6, vol.getSenha());
            ps.setString(7, vol.getEndereco().getEndereco());
            ps.setString(8, vol.getDescricao());
            ps.setInt(9, vol.getEspecialidades().get(0).getCodigo());
            ps.setInt(10, vol.getEspecialidades().get(1).getCodigo());
            ps.setInt(11, vol.getEspecialidades().get(2).getCodigo());
            ps.setDate(12, new java.sql.Date(vol.getDtnasc().getTime()));
            ps.setInt(13, vol.getEndereco().getCidade().getId());
            ps.setInt(14, vol.getEndereco().getEstado().getId());
            ps.execute();
            ps.close();
        
        return null;
       
    }

    public Avaliacao CadastraAvaliacao(Avaliacao aval) throws SQLException {

        ResultSet rs;
        
            Connection conexao = this.getConexao();
            PreparedStatement ps = conexao.prepareStatement("INSERT INTO avaliacao (aval_vol_cod, aval_inst_cod, aval_nota) values(?,?,?)");
            ps.setInt(1, aval.getCod_vol());
            ps.setInt(2, aval.getCod_inst());
            ps.setInt(3, aval.getNota());

            ps.executeQuery();

            ps.close();
            conexao.close();
        return null;
    }

    public Avaliacao AtualizaAvaliacao(Avaliacao aval) throws SQLException {

        ResultSet rs;
            Connection conexao = this.getConexao();
            PreparedStatement ps = conexao.prepareStatement("update avaliacao SET aval_vol_cod = ?, aval_inst_cod = ?,  aval_nota= ? where aval_inst_cod = ? and aval_vol_cod = ?");
            ps.setInt(1, aval.getCod_vol());
            ps.setInt(2, aval.getCod_inst());
            ps.setInt(3, aval.getNota());
            ps.setInt(4, aval.getCod_inst());
            ps.setInt(5, aval.getCod_vol());

            ps.executeQuery();

            ps.close();
            conexao.close();
        return null;
    }

    public Instituicao BuscaInstituicao(Instituicao instituicao) throws SQLException  {
        ResultSet rs;
            Connection conexao = this.getConexao();
            PreparedStatement ps = conexao.prepareStatement("select * from instituicao where pk_inst_cod= ? and inst_autorizacao = 1");
            ps.setInt(1, instituicao.getCod());
            rs = ps.executeQuery();
            if (rs.next()) {
                Instituicao inst = new Instituicao();
                Endereco end = new Endereco();
                inst.setCod(rs.getInt("pk_inst_cod"));
                inst.setEmail(rs.getString("inst_email"));
                inst.setSenha(rs.getString("inst_senha"));
                inst.setNome(rs.getString("inst_nome"));
                inst.setCnpj(rs.getString("inst_cnpj"));
                inst.setNomeResp(rs.getString("inst_resp"));
                inst.setCpfResp(rs.getString("inst_resp_cpf"));
                end.setEndereco(rs.getString("inst_end"));
                inst.setEndereco(end);
                inst.setNecessidades(rs.getString("inst_necess"));
                inst.setTelefone(rs.getString("inst_tel"));
                inst.setDadosBanco(rs.getString("inst_dados_banco"));
                inst.setAutorizacao(rs.getInt("inst_autorizacao"));
                return inst;
            }
        return null;
    }

//Açôes da Instituição
//Consultar, Adicionar, Excluir
    public void ExcluirInstituicao(Instituicao inst) {

        try {
            Connection conexao = this.getConexao();
            PreparedStatement ps = conexao.prepareStatement("Update instituicao SET inst_ativo = '0' where pk_inst_cod = ?");
            ps.setInt(1, inst.getCod());
            ps.executeQuery();
            ps.close();
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Instituicao ExibeInstituicao(Instituicao inst) throws SQLException {
        ResultSet rs = null;
        Connection conexao = this.getConexao();
        PreparedStatement ps = conexao.prepareStatement("select instituicao.*, est_nome, cid_nome from instituicao inner join tb_estado on (inst_estado = est_id) inner join tb_cidade on (inst_cidade = cid_id) where pk_inst_cod =? and inst_ativo = '1'");
        ps.setInt(1, inst.getCod());

        rs = ps.executeQuery();

        if (rs.next()) {
            Endereco end = new Endereco();
            Cidade cidade = new Cidade();
            Estado estado = new Estado();
            inst.setCod(rs.getInt("pk_inst_cod"));
            inst.setEmail(rs.getString("inst_email"));
            inst.setSenha(rs.getString("inst_senha"));
            inst.setNome(rs.getString("inst_nome"));
            inst.setCnpj(rs.getString("inst_cnpj"));
            inst.setCpfResp(rs.getString("inst_resp_cpf"));
            inst.setNomeResp(rs.getString("inst_resp"));
            end.setEndereco(rs.getString("inst_end"));
            inst.setNecessidades(rs.getString("inst_necess"));
            inst.setTelefone(rs.getString("inst_tel"));
            estado.setNome(rs.getString("est_nome"));
            cidade.setNome(rs.getString("cid_nome"));
            inst.setPerfil(rs.getString("inst_perfil"));
            estado.setId(rs.getInt("inst_estado"));
            cidade.setId(rs.getInt("inst_cidade"));
            inst.setDadosBanco(rs.getString("inst_dados_banco"));
            end.setCidade(cidade);
            end.setEstado(estado);
            inst.setEndereco(end);
        }
        return inst;
    }

    public Instituicao listaInstituicao(Instituicao inst) throws SQLException {

        ResultSet rs = null;

        Connection conexao = this.getConexao();
        PreparedStatement ps = conexao.prepareStatement("select pk_inst_cod, inst_nome, inst_perfil from instituicao where inst_email = ? and inst_senha = ? and inst_autorizacao = 1 and inst_ativo = '1'");
        ps.setString(1, inst.getEmail());
        ps.setString(2, inst.getSenha());

        rs = ps.executeQuery();

        if (rs.next()) {
            inst.setCod(rs.getInt("pk_inst_cod"));
            inst.setNome(rs.getString("inst_nome"));
            inst.setPerfil(rs.getString("inst_perfil"));

            return inst;

        }

        return null;
    }
    
    public Instituicao AtualizaSenhaInst(Instituicao inst) throws SQLException {
        ResultSet rs = null;
        Connection conexao = this.getConexao();
        PreparedStatement ps = conexao.prepareStatement("Update instituicoes SET inst_senha = ? where pk_inst_cod = ?");
        ps.setString(1, inst.getSenha());
        ps.setInt(2, inst.getCod());
        ps.executeUpdate();
        return null;
    }

    public Instituicao AtualizaInstituicao(Instituicao inst) throws SQLException {
        ResultSet rs = null;
        Connection conexao = this.getConexao();
        PreparedStatement ps = conexao.prepareStatement("Update instituicao SET inst_cnpj = ?, inst_tel = ?, inst_end = ?, inst_dados_banco = ?, inst_resp = ?, inst_resp_cpf = ?, "
                    + "inst_necess = ?, inst_email = ?, inst_nome = ?, inst_estado =?, inst_cidade =? where pk_inst_cod = ?");
        
        ps.setString(1, inst.getCnpj());
        ps.setString(2, inst.getTelefone());
        ps.setString(3, inst.getEndereco().getEndereco());
        ps.setString(4, inst.getDadosBanco());
        ps.setString(5, inst.getNomeResp());
        ps.setString(6, inst.getCpfResp());
        ps.setString(7, inst.getNecessidades());
        ps.setString(8, inst.getEmail());
        ps.setString(9, inst.getNome());
        ps.setInt(10, inst.getEndereco().getEstado().getId());
        ps.setInt(11, inst.getEndereco().getCidade().getId());
        ps.setInt(12, inst.getCod());
        ps.executeQuery();
        ps.close();
        conexao.close();
        
        return null;

    }

    public Instituicao CadastraInstituicao(Instituicao inst) throws SQLException {

            Connection conexao = this.getConexao();
            PreparedStatement ps = conexao.prepareStatement("INSERT INTO instituicao (inst_tel, inst_end, inst_dados_banco, inst_resp,"
                    + "inst_senha, inst_necess, inst_email, inst_nome, inst_cnpj, inst_resp_cpf, inst_cidade, inst_estado) values(?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, inst.getTelefone());
            ps.setString(2, inst.getEndereco().getEndereco());
            ps.setString(3, inst.getDadosBanco());
            ps.setString(4, inst.getNomeResp());
            ps.setString(5, inst.getSenha());
            ps.setString(6, inst.getNecessidades());
            ps.setString(7, inst.getEmail());
            ps.setString(8, inst.getNome());
            ps.setString(9, inst.getCnpj());
            ps.setString(10, inst.getCpfResp());
            ps.setInt(11, inst.getEndereco().getCidade().getId());
            ps.setInt(12, inst.getEndereco().getEstado().getId());
            ps.execute();

            ps.close();
            conexao.close();
            return null;
    }

//Açôes do Administrador
//Consultar, Adicionar, Excluir
    
    public Voluntario AtualizaSenhaAdmin(Administrador admin) throws SQLException {
        ResultSet rs;

        Connection conexao = this.getConexao();
        PreparedStatement ps = conexao.prepareStatement("Update administrador SET admin_senha = ? where pk_admin_cod = ?");
        ps.setString(1, admin.getSenha());
        ps.setInt(2, admin.getCod());
        ps.executeUpdate();
        return null;

    }
    public void ExcluirAdministrador(Administrador admin) throws SQLException {

            Connection conexao = this.getConexao();
            PreparedStatement ps = conexao.prepareStatement("update administrador set admin_ativo = '0' where pk_admin_cod = ?");
            ps.setInt(1, admin.getCod());
            ps.executeQuery();
            ps.close();
            conexao.close();
    }
    
    public Administrador listaAdministrador(Administrador admin) throws SQLException {

        ResultSet rs = null;
        Connection conexao = this.getConexao();
        PreparedStatement ps = conexao.prepareStatement("select pk_admin_cod, admin_nome, admin_perfil from administrador where admin_email = ? and admin_senha = ? and admin_autorizacao = 1 and admin_ativo = '1'");
        ps.setString(1, admin.getEmail());
        ps.setString(2, admin.getSenha());

        rs = ps.executeQuery();

        if (rs.next()) {
            admin.setNome(rs.getString("admin_nome"));
            admin.setCod(rs.getInt("pk_admin_cod"));
            admin.setPerfil(rs.getString("admin_perfil"));
        }
        return admin;
    }
    
    public Administrador ExibeAdministrador(Administrador admin) throws SQLException {
        ResultSet rs = null;
        Connection conexao = this.getConexao();
        PreparedStatement ps = conexao.prepareStatement("select administrador.*, est_nome, cid_nome from administrador inner join tb_estado on (admin_estado = est_id) inner join tb_cidade on (admin_cidade = cid_id) where pk_admin_cod =? and admin_ativo = '1'");
        ps.setInt(1, admin.getCod());

        rs = ps.executeQuery();

        if (rs.next()) {
            Endereco end = new Endereco();
            Cidade cidade = new Cidade();
            Estado estado = new Estado();
            admin.setCod(rs.getInt("pk_admin_cod"));
            admin.setEmail(rs.getString("admin_email"));
            admin.setSenha(rs.getString("admin_senha"));
            admin.setNome(rs.getString("admin_nome"));
            admin.setRg(rs.getString("admin_rg"));
            admin.setCpf(rs.getString("admin_cpf"));
            end.setEndereco(rs.getString("admin_endereco"));
            admin.setTelefone(rs.getString("admin_telefone"));
            admin.setPerfil(rs.getString("admin_perfil"));
            estado.setNome(rs.getString("est_nome"));
            cidade.setNome(rs.getString("cid_nome"));
            estado.setId(rs.getInt("admin_estado"));
            cidade.setId(rs.getInt("admin_cidade"));
            end.setCidade(cidade);
            end.setEstado(estado);
            admin.setEndereco(end);

        }
        return admin;
    }

    public Administrador CadastraAdministrador(Administrador admin) throws SQLException {
             
            Connection conexao = this.getConexao();
            PreparedStatement ps = conexao.prepareStatement("INSERT INTO administrador (admin_nome, admin_rg, admin_cpf, admin_email, admin_telefone, admin_senha, admin_endereco, admin_cidade, admin_estado) values(?,?,?,?,?,?,?,?,?)");
            ps.setString(1, admin.getNome());
            ps.setString(2, admin.getRg());
            ps.setString(3, admin.getCpf());
            ps.setString(4, admin.getEmail());
            ps.setString(5, admin.getTelefone());
            ps.setString(6, admin.getSenha());
            ps.setString(7, admin.getEndereco().getEndereco());
            ps.setInt(8, admin.getEndereco().getCidade().getId());
            ps.setInt(9, admin.getEndereco().getEstado().getId());
            ps.execute();
            ps.close();
            conexao.close();
       
        return null;

    }

    public Administrador AtualizaAdministrador(Administrador admin) throws SQLException {
        
            Connection conexao = this.getConexao();
            PreparedStatement ps = conexao.prepareStatement("Update administrador SET admin_nome = ?, admin_rg = ?, admin_cpf = ?, admin_email = ?, admin_telefone = ?, admin_endereco = ?, admin_cidade = ?, admin_estado= ?  where pk_admin_cod = ?");
            ps.setString(1, admin.getNome());
            ps.setString(2, admin.getRg());
            ps.setString(3, admin.getCpf());
            ps.setString(4, admin.getEmail());
            ps.setString(5, admin.getTelefone());
            ps.setString(6, admin.getEndereco().getEndereco());
            ps.setInt(7, admin.getEndereco().getCidade().getId());
            ps.setInt(8, admin.getEndereco().getEstado().getId());
            ps.setInt(9, admin.getCod());
            ps.executeQuery();
            ps.close();
            conexao.close();
        return null;
    }

    public Instituicao InstituicaoPendenteAutorizacao() throws SQLException {

        ResultSet rs;
            Connection conexao = this.getConexao();
            PreparedStatement ps = conexao.prepareStatement("select pk_inst_cod from instituicao where inst_autorizacao = 0");
            rs = ps.executeQuery();

            if (rs.next()) {
                Instituicao instituicao = new Instituicao();
                instituicao.setCod(rs.getInt("pk_inst_cod"));
                return instituicao;
            }

        return null;
    }

    public Instituicao AprovaInstituicao(Instituicao inst) throws SQLException {
        ResultSet rs;
        Connection conexao = this.getConexao();
        PreparedStatement ps = conexao.prepareStatement("Update instituicao SET inst_autorizacao = ?, inst_cod_admin_autoriza = ? where pk_inst_cod = ?");
        ps.setInt(1, inst.getAutorizacao());
        ps.setInt(2, inst.getAdmin_autorizacao());
        ps.setInt(3, inst.getCod());

        ps.executeQuery();

        ps.close();
        conexao.close();
    return null;

    }

}
