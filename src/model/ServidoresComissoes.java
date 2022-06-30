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
public class ServidoresComissoes {
    
    private long id;
    private Comissoes comissao;
    private Servidor servidor;
    private int papel; // 1 - presidente, 2 - vice, 3- secretario, 4- participante, 5- suplemente
    private LocalDate dtEntrada;
    private LocalDate dtSaida;
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

    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }

    public int getPapel() {
        return papel;
    }

    public void setPapel(int papel) {
        this.papel = papel;
    }

    public LocalDate getDtEntrada() {
        return dtEntrada;
    }

    public void setDtEntrada(LocalDate dtEntrada) {
        this.dtEntrada = dtEntrada;
    }

    public LocalDate getDtSaida() {
        return dtSaida;
    }

    public void setDtSaida(LocalDate dtSaida) {
        this.dtSaida = dtSaida;
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
        return "ServidoresComissoes{" + "id=" + id + ", comissao=" + comissao.getComissao() + ", servidor=" + servidor.getNome() + ", papel=" + papel + ", dtEntrada=" + dtEntrada + ", dtSaida=" + dtSaida + ", dtCriacao=" + dtCriacao + ", dtModificacao=" + dtModificacao + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 89 * hash + Objects.hashCode(this.comissao);
        hash = 89 * hash + Objects.hashCode(this.servidor);
        hash = 89 * hash + this.papel;
        hash = 89 * hash + Objects.hashCode(this.dtEntrada);
        hash = 89 * hash + Objects.hashCode(this.dtSaida);
        hash = 89 * hash + Objects.hashCode(this.dtCriacao);
        hash = 89 * hash + Objects.hashCode(this.dtModificacao);
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
        final ServidoresComissoes other = (ServidoresComissoes) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.papel != other.papel) {
            return false;
        }
        if (!Objects.equals(this.comissao, other.comissao)) {
            return false;
        }
        if (!Objects.equals(this.servidor, other.servidor)) {
            return false;
        }
        if (!Objects.equals(this.dtEntrada, other.dtEntrada)) {
            return false;
        }
        if (!Objects.equals(this.dtSaida, other.dtSaida)) {
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
