/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.time.LocalDate;
import java.time.LocalDateTime;
import model.Atividades;
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
//        Orientacoes obj = new Orientacoes();
//        OrientacoesDAO objdao = new OrientacoesDAO();
////        Disciplina obj = new Disciplina();
//        DisciplinaDAO objdao = new DisciplinaDAO();
//          Curso obj = new Curso();
//          CursoDAO objdao = new CursoDAO();
Atividades obj = new Atividades();
AtividadesDAO objdao = new AtividadesDAO();        
        
        long indiceBusca = 2;

        obj.setDescricao("oxi");
        obj.setHorasSemanais(2);
        obj.setDtInicio(LocalDate.now());
        obj.setServidor(18);
        obj.setDtFim(LocalDate.now());
        obj.setId(indiceBusca);
        obj.setDtCriacao(LocalDateTime.now());
        obj.setDtModificacao(LocalDateTime.now());
        



//        objdao.adiciona(obj);
//        objdao.remove(1);
//        objdao.altera(obj);

        System.out.println(objdao.buscaEspecifico(2));
//        

        for (Atividades arg : objdao.lista()){
            System.out.println(arg);
        }
////        
    }
}
