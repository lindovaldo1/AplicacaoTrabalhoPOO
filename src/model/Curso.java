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
public class Curso {

    
    private long id;
    private String nome;
    private int estado = 0; // 1 = ativo, 0 = inativo
    private Campus campus;
    private LocalDate anoInicio;
    private LocalDate anoTermino;
    private LocalDateTime dtCriacao;
    private LocalDateTime dtModificacao;

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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public LocalDate getAnoInicio() {
        return anoInicio;
    }

    public void setAnoInicio(LocalDate anoInicio) {
        this.anoInicio = anoInicio;
    }

    public LocalDate getAnoTermino() {
        return anoTermino;
    }

    public void setAnoTermino(LocalDate anoTermino) {
        this.anoTermino = anoTermino;
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
        return "Curso{" + "id=" + id + ", nome=" + nome + ", estado=" + estado + ", campus=" + campus + ", anoInicio=" + anoInicio + ", anoTermino=" + anoTermino + ", dtCriacao=" + dtCriacao + ", dtModificacao=" + dtModificacao + '}';
    }
    

    public String toStringMin() {
        return "Curso{" + "id=" + id + ", nome=" + nome + ", estado=" + estado + "\n campus=" + campus.toStringMin() + ", anoInicio=" + anoInicio + ", anoTermino=" + anoTermino + ", dtCriacao=" + dtCriacao + ", dtModificacao=" + dtModificacao + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + this.estado;
        hash = 97 * hash + Objects.hashCode(this.campus);
        hash = 97 * hash + Objects.hashCode(this.anoInicio);
        hash = 97 * hash + Objects.hashCode(this.anoTermino);
        hash = 97 * hash + Objects.hashCode(this.dtCriacao);
        hash = 97 * hash + Objects.hashCode(this.dtModificacao);
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
        final Curso other = (Curso) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.estado != other.estado) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.campus, other.campus)) {
            return false;
        }
        if (!Objects.equals(this.anoInicio, other.anoInicio)) {
            return false;
        }
        if (!Objects.equals(this.anoTermino, other.anoTermino)) {
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
