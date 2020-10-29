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
public class Avaliacao {
    private int cod;
    private int nota;
    private int cod_vol;
    private int cod_inst;

    public int getCod_vol() {
        return cod_vol;
    }

    public void setCod_vol(int cod_vol) {
        this.cod_vol = cod_vol;
    }

    public int getCod_inst() {
        return cod_inst;
    }

    public void setCod_inst(int cod_inst) {
        this.cod_inst = cod_inst;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
    
    
}
