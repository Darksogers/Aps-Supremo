/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author makefake
 */
public class GastosMensais {

    private long codGasto;
    private String descricao;
    private Double valor;
    private Boolean fgAtivo;

    public long getCodGasto() {
        return codGasto;
    }

    public void setCodGasto(long codGasto) {
        this.codGasto = codGasto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Boolean getFgAtivo() {
        return fgAtivo;
    }

    public void setFgAtivo(Boolean fgAtivo) {
        this.fgAtivo = fgAtivo;
    }
    
    
}
