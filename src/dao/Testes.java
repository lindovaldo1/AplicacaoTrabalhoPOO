/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.time.LocalDate;
import model.Curso;
import model.Servidor;
import model.Disciplina;
   
/**
 *
 * @author Lindovaldo
 */
public class Testes {
    public static void main(String[] args) {
        
        Disciplina obj = new Disciplina();
        DisciplinaDAO objdao = new DisciplinaDAO();
//        CursoDAO objdao = new CursoDAO();
        long indiceBusca = 2;

        obj.setNome("Analise de dados");
        obj.setCurso(Long.parseLong("1"));
        obj.setCargaHoraria(2.5);
        obj.setPeriodicidade(1);
        
        obj.setId(indiceBusca);
        
//        objdao.adiciona(obj);;
//        objdao.remove(indiceBusca);
//        objdao.altera(obj);

        System.out.println(objdao.buscaEspecifico(indiceBusca));
//        
        for (Disciplina arg : objdao.lista()){
            System.out.println((Disciplina)arg);
        }
//        
    }
}
