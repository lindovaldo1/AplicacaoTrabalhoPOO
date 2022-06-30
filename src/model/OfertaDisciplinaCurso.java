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
public class OfertaDisciplinaCurso {
    
    private long id;
    private Disciplina disciplina;
    private Servidor professor;
    private Curso curso;
    private int ano;
    private int semestre;
    private int aulasSemanais;    
    private LocalDateTime dtCriacao;
    private LocalDateTime dtModificacao;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Servidor getProfessor() {
        return professor;
    }

    public void setProfessor(Servidor professor) {
        this.professor = professor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getAulasSemanais() {
        return aulasSemanais;
    }

    public void setAulasSemanais(int aulasSemanais) {
        this.aulasSemanais = aulasSemanais;
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

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "OfertaDisciplinaCurso{" + "id=" + id + ", disciplina=" + disciplina.getNome() + ", professor=" + professor.getNome() + ", curso=" + curso.getNome() + ", ano=" + ano + ", semestre=" + semestre + ", aulasSemanais=" + aulasSemanais + ", dtCriacao=" + dtCriacao + ", dtModificacao=" + dtModificacao + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 71 * hash + Objects.hashCode(this.disciplina);
        hash = 71 * hash + Objects.hashCode(this.professor);
        hash = 71 * hash + Objects.hashCode(this.curso);
        hash = 71 * hash + Objects.hashCode(this.ano);
        hash = 71 * hash + this.semestre;
        hash = 71 * hash + this.aulasSemanais;
        hash = 71 * hash + Objects.hashCode(this.dtCriacao);
        hash = 71 * hash + Objects.hashCode(this.dtModificacao);
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
        final OfertaDisciplinaCurso other = (OfertaDisciplinaCurso) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.semestre != other.semestre) {
            return false;
        }
        if (this.aulasSemanais != other.aulasSemanais) {
            return false;
        }
        if (!Objects.equals(this.disciplina, other.disciplina)) {
            return false;
        }
        if (!Objects.equals(this.professor, other.professor)) {
            return false;
        }
        if (!Objects.equals(this.curso, other.curso)) {
            return false;
        }
        if (!Objects.equals(this.ano, other.ano)) {
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
