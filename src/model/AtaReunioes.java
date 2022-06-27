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
public class AtaReunioes {
    
    private long id;
    private long comissao;
    private LocalDate dtReuniao;
    private String ataConteudo;
    private long secretario;
    private LocalDateTime dtCriacao;
    private LocalDateTime dtModificacao;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getComissao() {
        return comissao;
    }

    public void setComissao(long comissao) {
        this.comissao = comissao;
    }

    public LocalDate getDtReuniao() {
        return dtReuniao;
    }

    public void setDtReuniao(LocalDate dtReuniao) {
        this.dtReuniao = dtReuniao;
    }

    public String getAtaConteudo() {
        return ataConteudo;
    }

    public void setAtaConteudo(String ataConteudo) {
        this.ataConteudo = ataConteudo;
    }

    public long getSecretario() {
        return secretario;
    }

    public void setSecretario(long secretario) {
        this.secretario = secretario;
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
        return "AtaReunioes{" + "id=" + id + ", comissao=" + comissao + ", dtReuniao=" + dtReuniao + ", ataConteudo=" + ataConteudo + ", secretario=" + secretario + ", dtCriacao=" + dtCriacao + ", dtModificacao=" + dtModificacao + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 17 * hash + (int) (this.comissao ^ (this.comissao >>> 32));
        hash = 17 * hash + Objects.hashCode(this.dtReuniao);
        hash = 17 * hash + Objects.hashCode(this.ataConteudo);
        hash = 17 * hash + (int) (this.secretario ^ (this.secretario >>> 32));
        hash = 17 * hash + Objects.hashCode(this.dtCriacao);
        hash = 17 * hash + Objects.hashCode(this.dtModificacao);
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
        final AtaReunioes other = (AtaReunioes) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.comissao != other.comissao) {
            return false;
        }
        if (this.secretario != other.secretario) {
            return false;
        }
        if (!Objects.equals(this.ataConteudo, other.ataConteudo)) {
            return false;
        }
        if (!Objects.equals(this.dtReuniao, other.dtReuniao)) {
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
