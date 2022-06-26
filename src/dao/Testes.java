/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.time.LocalDate;
import java.time.LocalDateTime;
import model.Campus;
import model.Orientacoes;
   
/**
 *
 * @author Lindovaldo
 */
public class Testes {
    public static void main(String[] args) {
        
//        
//        Campus obj = new Campus();
//        CampusDAO objdao = new CampusDAO();
        Orientacoes obj = new Orientacoes();
        OrientacoesDAO objdao = new OrientacoesDAO();
////        Disciplina obj = new Disciplina();
//        DisciplinaDAO objdao = new DisciplinaDAO();
//          Curso obj = new Curso();
//          CursoDAO objdao = new CursoDAO();
        
        
        long indiceBusca = 3;

        obj.setNomeAluno("Lindovaldo");
        obj.setServidor(indiceBusca);
        obj.setTipoOrientacao(1);
        obj.setHorasSemanais(20);
        obj.setDtInicio(LocalDate.now());
        obj.setDtTermino(LocalDate.now());
        obj.setId(5);
        obj.setDtCriacao(LocalDateTime.now());
        obj.setDtModificacao(LocalDateTime.now());
        



//        objdao.adiciona(obj);
//        objdao.remove(4);
//        objdao.altera(obj);

        System.out.println(objdao.buscaEspecifico(5));
//        

        for (Orientacoes arg : objdao.lista()){
            System.out.println(arg);
        }
//        
    }
}
