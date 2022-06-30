/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author Lindovaldo
 */
public class AtaReunioesPresentes {
    private long id;
    private Comissoes comissao;
    private AtaReunioes ataReuniao;
    private Servidor servidor;
    private LocalDateTime dtCriacao;
    private LocalDateTime dtModificacao;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Comissoes getComissao() {
        return comissao;
    }

    public void setComissao(Comissoes comissao) {
        this.comissao = comissao;
    }

    public AtaReunioes getAtaReuniao() {
        return ataReuniao;
    }

    public void setAtaReuniao(AtaReunioes ataReuniao) {
        this.ataReuniao = ataReuniao;
    }

    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
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
        return "AtaReunioesPresentes{" + "id=" + id + ", comissao=" + comissao.getComissao() + ", ataReuniao=" + ataReuniao.getDtReuniao() + ", servidor=" + servidor.getNome() + ", dtCriacao=" + dtCriacao + ", dtModificacao=" + dtModificacao + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 43 * hash + Objects.hashCode(this.comissao);
        hash = 43 * hash + Objects.hashCode(this.ataReuniao);
        hash = 43 * hash + Objects.hashCode(this.servidor);
        hash = 43 * hash + Objects.hashCode(this.dtCriacao);
        hash = 43 * hash + Objects.hashCode(this.dtModificacao);
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
        final AtaReunioesPresentes other = (AtaReunioesPresentes) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.comissao, other.comissao)) {
            return false;
        }
        if (!Objects.equals(this.ataReuniao, other.ataReuniao)) {
            return false;
        }
        if (!Objects.equals(this.servidor, other.servidor)) {
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
