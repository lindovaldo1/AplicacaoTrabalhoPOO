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
public class Orientacoes {
    
    private long id;
    private int tipoOrientacao; // 1 - ensino, 2 - pesquisa, 3 - extensão, 4 - estagio, 5 - tcc, 6 - mestrado, 7 - doutorado
    private String nomeAluno;
    private double horasSemanais;
    private long servidor;
    private LocalDate dtInicio;
    private LocalDate dtTermino;
    private LocalDateTime dtCriacao;
    private LocalDateTime dtModificacao;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getTipoOrientacao() {
        return tipoOrientacao;
    }

    public void setTipoOrientacao(int tipoOrientacao) {
        this.tipoOrientacao = tipoOrientacao;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public double getHorasSemanais() {
        return horasSemanais;
    }

    public void setHorasSemanais(double horasSemanais) {
        this.horasSemanais = horasSemanais;
    }

    public long getServidor() {
        return servidor;
    }

    public void setServidor(long servidor) {
        this.servidor = servidor;
    }

    public LocalDate getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(LocalDate dtInicio) {
        this.dtInicio = dtInicio;
    }

    public LocalDate getDtTermino() {
        return dtTermino;
    }

    public void setDtTermino(LocalDate dtTermino) {
        this.dtTermino = dtTermino;
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
        return "Orientacoes{" + "id=" + id + ", tipoOrientacao=" + tipoOrientacao + ", nomeAluno=" + nomeAluno + ", horasSemanais=" + horasSemanais + ", servidor=" + servidor + ", dtInicio=" + dtInicio + ", dtTermino=" + dtTermino + ", dtCriacao=" + dtCriacao + ", dtModificacao=" + dtModificacao + '}';
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 83 * hash + this.tipoOrientacao;
        hash = 83 * hash + Objects.hashCode(this.nomeAluno);
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.horasSemanais) ^ (Double.doubleToLongBits(this.horasSemanais) >>> 32));
        hash = 83 * hash + (int) (this.servidor ^ (this.servidor >>> 32));
        hash = 83 * hash + Objects.hashCode(this.dtInicio);
        hash = 83 * hash + Objects.hashCode(this.dtTermino);
        hash = 83 * hash + Objects.hashCode(this.dtCriacao);
        hash = 83 * hash + Objects.hashCode(this.dtModificacao);
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
        final Orientacoes other = (Orientacoes) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.tipoOrientacao != other.tipoOrientacao) {
            return false;
        }
        if (this.horasSemanais != other.horasSemanais) {
            return false;
        }
        if (!Objects.equals(this.nomeAluno, other.nomeAluno)) {
            return false;
        }
        if (!Objects.equals(this.servidor, other.servidor)) {
            return false;
        }
        if (!Objects.equals(this.dtInicio, other.dtInicio)) {
            return false;
        }
        if (!Objects.equals(this.dtTermino, other.dtTermino)) {
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
