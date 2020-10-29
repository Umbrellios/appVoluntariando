/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.util.ArrayList;

/**
 *
 * @author Home
 */
public class Evento {
    private int codigo;
    private int idadeFaixa1;
    private int idadeFaixa2;
    private String data;
    private String descricao;
    private String local;
    private Instituicao instituicao;
    private ArrayList<Voluntario> voluntarios = new ArrayList<>();
    private ArrayList<Especialidade> especialidades = new ArrayList<>();

    public void limpaEspecialidades(){
        especialidades.clear();
    }
    
    public void limpaVoluntarios(){
        voluntarios.clear();
    }
    
    public ArrayList<Voluntario> getVoluntarios() {
        return voluntarios;
    }

    public void addVol(Voluntario vol) {
        voluntarios.add(vol);
    }

    public ArrayList<Especialidade> getEspecialidades() {
        return especialidades;
    }

    public void addEspec(Especialidade espec) {
       especialidades.add(espec);
    }
   
    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }
        
    public int getIdadeFaixa2() {
        return idadeFaixa2;
    }

    public void setIdadeFaixa2(int idadeFaixa2) {
        this.idadeFaixa2 = idadeFaixa2;
    }

    public int getIdadeFaixa1() {
        return idadeFaixa1;
    }

    public void setIdadeFaixa1(int idadeFaixa1) {
        this.idadeFaixa1 = idadeFaixa1;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
