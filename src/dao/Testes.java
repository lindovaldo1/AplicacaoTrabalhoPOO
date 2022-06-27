/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import model.AtaReunioes;
import model.Atividades;
import model.Campus;
import model.Orientacoes;
import model.Comissoes;

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
////      Disciplina obj = new Disciplina();
//        DisciplinaDAO objdao = new DisciplinaDAO();
//        Curso obj = new Curso();
//        CursoDAO objdao = new CursoDAO();
//        Atividades obj = new Atividades();
//        AtividadesDAO objdao = new AtividadesDAO();
//        Comissoes obj = new Comissoes();
//        ComissoesDAO objdao = new ComissoesDAO();
        AtaReunioesDAO objdao = new AtaReunioesDAO();
        AtaReunioes obj = new AtaReunioes();
         
        long indiceBusca = 6;

        obj.setId(indiceBusca);
        obj.setComissao(3);
        obj.setDtReuniao(LocalDate.now());
        obj.setAtaConteudo("conteudo");
        obj.setSecretario(18);
        
        obj.setDtCriacao(LocalDateTime.now());
        obj.setDtModificacao(LocalDateTime.now());

//        objdao.adiciona(obj);
//        objdao.remove(6);
//        objdao.altera(obj);
//        System.out.println(objdao.buscaEspecifico(indiceBusca));
//        

        for (AtaReunioes arg : objdao.lista()) {
            System.out.println(arg);
        }
////        
    }
}
