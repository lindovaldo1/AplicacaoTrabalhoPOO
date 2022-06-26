/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author Lindovaldo
 */
public class Comissoes {

    private long id;
    private String comissao;
    private double hSemanais;
    private LocalDate dtInicio;
    private LocalDate dtFim;
    private int estado; // 1 == Ativa | 0 == inativa
    private LocalDateTime dtCriacao;
    private LocalDateTime dtModificacao;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComissao() {
        return comissao;
    }

    public void setComissao(String comissao) {
        this.comissao = comissao;
    }

    public double gethSemanais() {
        return hSemanais;
    }

    public void sethSemanais(double hSemanais) {
        this.hSemanais = hSemanais;
    }

    public LocalDate getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(LocalDate dtInicio) {
        this.dtInicio = dtInicio;
    }

    public LocalDate getDtFim() {
        return dtFim;
    }

    public void setDtFim(LocalDate dtFim) {
        this.dtFim = dtFim;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public LocalDateTime getDtCriacao() {
        return dtCriacao;
    }

    public void setDtCriacao(LocalDateTime dtCriacao) {
        this.dtCriacao = dtCriacao;
    }

    public LocalDateTime getDtModificacao() {
        return dtModificacao;
    }

    public void setDtModificacao(LocalDateTime dtModificacao) {
        this.dtModificacao = dtModificacao;
    }

    @Override
    public String toString() {
        return "Comissoes{" + "id=" + id + ", comissao=" + comissao + ", hSemanais=" + hSemanais + ", dtInicio=" + dtInicio + ", dtFim=" + dtFim + ", estado=" + estado + ", dtCriacao=" + dtCriacao + ", dtModificacao=" + dtModificacao + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 79 * hash + Objects.hashCode(this.comissao);
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.hSemanais) ^ (Double.doubleToLongBits(this.hSemanais) >>> 32));
        hash = 79 * hash + Objects.hashCode(this.dtInicio);
        hash = 79 * hash + Objects.hashCode(this.dtFim);
        hash = 79 * hash + this.estado;
        hash = 79 * hash + Objects.hashCode(this.dtCriacao);
        hash = 79 * hash + Objects.hashCode(this.dtModificacao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Comissoes other = (Comissoes) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.hSemanais) != Double.doubleToLongBits(other.hSemanais)) {
            return false;
        }
        if (this.estado != other.estado) {
            return false;
        }
        if (!Objects.equals(this.comissao, other.comissao)) {
            return false;
        }
        if (!Objects.equals(this.dtInicio, other.dtInicio)) {
            return false;
        }
        if (!Objects.equals(this.dtFim, other.dtFim)) {
            return false;
        }
        if (!Objects.equals(this.dtCriacao, other.dtCriacao)) {
            return false;
        }
        if (!Objects.equals(this.dtModificacao, other.dtModificacao)) {
            return false;
        }
        return true;
    }

    
    
    
}
