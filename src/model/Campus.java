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

public class Campus {
    private long id;
    private String nome;
    private String abreviacao;
    private int duracaoAula;
    private LocalDate dtCriacaoCampus;
    private String cidade;
    private String bairro;
    private String endereco;
    private String cep;
    private LocalDateTime dtCriacao;
    private LocalDateTime dtModificacao;

    public Campus() {
        this.dtCriacao = LocalDateTime.now();
        this.dtModificacao = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAbreviacao() {
        return abreviacao;
    }

    public void setAbreviacao(String abreviacao) {
        this.abreviacao = abreviacao;
    }

    public int getDuracaoAula() {
        return duracaoAula;
    }

    public void setDuracaoAula(int duracaoAula) {
        this.duracaoAula = duracaoAula;
    }

    public LocalDate getDtCriacaoCampus() {
        return dtCriacaoCampus;
    }

    public void setDtCriacaoCampus(LocalDate dtCriacaoCampus) {
        this.dtCriacaoCampus = dtCriacaoCampus;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
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
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 29 * hash + Objects.hashCode(this.nome);
        hash = 29 * hash + Objects.hashCode(this.abreviacao);
        hash = 29 * hash + this.duracaoAula;
        hash = 29 * hash + Objects.hashCode(this.dtCriacaoCampus);
        hash = 29 * hash + Objects.hashCode(this.cidade);
        hash = 29 * hash + Objects.hashCode(this.bairro);
        hash = 29 * hash + Objects.hashCode(this.endereco);
        hash = 29 * hash + Objects.hashCode(this.cep);
        hash = 29 * hash + Objects.hashCode(this.dtCriacao);
        hash = 29 * hash + Objects.hashCode(this.dtModificacao);
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
        final Campus other = (Campus) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.duracaoAula != other.duracaoAula) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.abreviacao, other.abreviacao)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        if (!Objects.equals(this.bairro, other.bairro)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.cep, other.cep)) {
            return false;
        }
        if (!Objects.equals(this.dtCriacaoCampus, other.dtCriacaoCampus)) {
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

    @Override
    public String toString() {
        return "Campus{" + "id=" + id + ", nome=" + nome + ", abreviacao=" + abreviacao + ", duracaoAula=" + duracaoAula + ", dtCriacaoCampus=" + dtCriacaoCampus + ", cidade=" + cidade + ", bairro=" + bairro + ", endereco=" + endereco + ", cep=" + cep + ", dtCriacao=" + dtCriacao + ", dtModificacao=" + dtModificacao + '}';
    }
    
    public String toStringMin() {
        return "Campus{" + "id=" + id + ", nome=" + nome + ", abreviacao=" + abreviacao + ", cidade=" + cidade + '}';
    }
}
