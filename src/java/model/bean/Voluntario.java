package model.bean;

import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author Home
 */
public class Voluntario extends Usuario {
    private String rg;
    private Date dtnasc;
    private String cpf;
    private String descricao;
    private int acesso;
    private ArrayList<Especialidade> especialidades = new ArrayList<>();

    public void limparEspeciaidades(){
        especialidades.clear();
    }
    
    public ArrayList<Especialidade> getEspecialidades() {
        return especialidades;
    }
   
    public void add(Especialidade espec){
        especialidades.add(espec);
    }
    
    public int getAcesso() {
        return acesso;
    }

    public void setAcesso(int acesso) {
        this.acesso = acesso;
    }
    
     public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDtnasc() {
        return dtnasc;
    }

    public void setDtnasc(Date dtnasc) {
        this.dtnasc = dtnasc;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
