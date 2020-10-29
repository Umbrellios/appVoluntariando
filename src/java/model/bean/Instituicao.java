/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Home
 */
public class Instituicao extends Usuario{
    private String cnpj;
    private String dadosBanco;
    private String nomeResp;
    private String cpfResp;
    private String necessidades;
    private int autorizacao;
    private int admin_autorizacao;

    public int getAdmin_autorizacao() {
        return admin_autorizacao;
    }

    public void setAdmin_autorizacao(int admin_autorizacao) {
        this.admin_autorizacao = admin_autorizacao;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getDadosBanco() {
        return dadosBanco;
    }

    public void setDadosBanco(String dadosBanco) {
        this.dadosBanco = dadosBanco;
    }

    public String getNomeResp() {
        return nomeResp;
    }

    public void setNomeResp(String nomeResp) {
        this.nomeResp = nomeResp;
    }

    public String getCpfResp() {
        return cpfResp;
    }

    public void setCpfResp(String cpfResp) {
        this.cpfResp = cpfResp;
    }

    public String getNecessidades() {
        return necessidades;
    }

    public void setNecessidades(String necessidades) {
        this.necessidades = necessidades;
    }

    public int getAutorizacao() {
        return autorizacao;
    }

    public void setAutorizacao(int autorizacao) {
        this.autorizacao = autorizacao;
    }
    
    
    
    
}
