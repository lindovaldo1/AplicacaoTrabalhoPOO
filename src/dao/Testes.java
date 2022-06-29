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
import model.Servidor;

/**
 *
 * @author Lindovaldo
 */
public class Testes {

    public static void main(String[] args) {
        
//        Servidor obj = new Servidor();
//        ServidorDAO objdao = new ServidorDAO();
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
//        AtaReunioesDAO objdao = new AtaReunioesDAO();
//        AtaReunioes obj = new AtaReunioes();
         
        long indiceBusca = 5;
//
//        obj.setId(indiceBusca);
//        obj.setComissao(3);
//        obj.setDtReuniao(LocalDate.now());
//        obj.setAtaConteudo("conteudo alterado");
//        obj.setSecretario(18);
//        
//        obj.setDtCriacao(LocalDateTime.now());
//        obj.setDtModificacao(LocalDateTime.now());

//        objdao.adiciona(obj);
//        objdao.remove(7);
//        objdao.altera(obj);
//        System.out.println(objdao.buscaEspecifico(indiceBusca));
        
        Servidor s3 = new Servidor();
        s3.setNome("Administrador");
        s3.setEmail("Administrador@administrador.br");
//        s3.setCampus(Long.parseLong("2"));
        s3.setCargo(1);
        s3.setLogin("admin");
        s3.setSenha("admin");
        s3.setTipoUsuario(1);
//        objdao.adiciona(s3);
        
        Servidor s4 = new Servidor();
        s4.setNome("Usuario Comum");
        s4.setEmail("comum@comum.br");
//        s4.setCampus(Long.parseLong("2"));
        s4.setCargo(1);
        s4.setLogin("user");
        s4.setSenha("user");
        s4.setTipoUsuario(2);
//        objdao.adiciona(s4);
        
//        for (Servidor arg : objdao.lista()) {
//            System.out.println(arg);
//        }
        
    }
}
