/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import extra.Espaco;
import extra.Login;
import java.util.Scanner;

/**
 *
 * @author Lindovaldo
 */
public class GUI {
    
    Scanner s = new Scanner(System.in);
    int escolha = 0;
    
    public int escolha()
    {        
        StringBuilder menu = new StringBuilder();
        
        menu.append("\nTRABALHO DE PROGRAMAÇÃO ORIENTADA A OBJETOS");
        menu.append("\n01 - Campus");
        menu.append("\n02 - Servidores");
        menu.append("\n03 - Curso");
        menu.append("\n04 - Disciplina");
        menu.append("\n05 - Oferta");
        menu.append("\n06 - Orientacao");
        menu.append("\n07 - Atividades");
        menu.append("\n08 - Comissões");
        menu.append("\n09 - Servidores Comissões");
        menu.append("\n10 - Ata das Reuniões");
        menu.append("\n11 - Ata reunioes presentes");
        menu.append("\n12 - Relatorio das Reuniões por periodo");
        menu.append("\n13 - Relatorio das Informações de Aulas");
        menu.append("\n14 - Relatorio de Trabalho por Servidor");
        menu.append("\n15 - Sair");
        menu.append("\n\nEscolha:>_");
        
        System.out.println(menu.toString());
                    
        return Integer.parseInt(s.nextLine());
        
    }
        
    public int daoAdm()
    {
        StringBuilder dao = new StringBuilder();
        
        dao.append("\nESCOLHA UMA OPÇÃO: ");
        dao.append("\n1 - Listar");
        dao.append("\n2 - Procurar");
        dao.append("\n3 - Adicionar");
        dao.append("\n4 - Remover");
        dao.append("\n5 - Alterar");
        dao.append("\n6 - Voltar");
        dao.append("\n\nEscolha:>_");
        
        System.out.println(dao.toString());
        
        return Integer.parseInt(s.nextLine());
    }
    
    public int daoCom()
    {
        StringBuilder dao = new StringBuilder();
        
        dao.append("\nESCOLHA UMA OPÇÃO: ");
        dao.append("\n1 - Listar");
        dao.append("\n2 - Procurar");
        dao.append("\n3 - Voltar");
        dao.append("\n\nEscolha:>_");
        
        System.out.println(dao.toString());
        
        return Integer.parseInt(s.nextLine());
    }
    
    
    
    public int telaIniLog(){
        
        Scanner s = new  Scanner(System.in);
        StringBuilder text= new StringBuilder();
        int opcao;
        
        text.append("\t\t === Login ===");
        text.append("\n\n\n\t1- Já tenho conta");
        text.append("\n\t2 - Tenho que fazer cadasttro");
        text.append("\n\t3 - Sair");
        text.append("\n\n\tEscolha a opcao:>_ ");
        
        System.out.print(text.toString());
        opcao = Integer.parseInt(s.nextLine());
        
        return opcao;
    } 
    
    public Login temLog(){
        Scanner s = new  Scanner(System.in);
        Espaco espaco = new Espaco();
        Login l = new Login();
        
        System.out.println("\t\t == Login == ");
        System.out.print("\n\n\tInforme o seu login: ");
        l.setLogin(s.nextLine());
        System.out.print("\tInforme a sua senha: ");
        l.setSenha(s.nextLine());
        
        return l;
    }
     

    public int alteraServidorComissao(){
       Scanner s = new  Scanner(System.in);
        StringBuilder text= new StringBuilder();
        int opcao;
        
        text.append("\t\t === Opções para Alteração Relação Servidor Comissão ===");
        text.append("\n\n\n\t1- Comissao");
        text.append("\n\t2 - Servidor");
        text.append("\n\t3 - Papel");
        text.append("\n\t4 - Data de Entrada");
        text.append("\n\t5 - Data de Saida");
        text.append("\n\t6 - voltar");
        text.append("\n\n\tEscolha a opcao:>_ ");
        
        System.out.print(text.toString());
        opcao = Integer.parseInt(s.nextLine());
        
        return opcao;
    }
    
    public Login loginCacheAdm(){
        Login adm = new Login();
        
        adm.setLogin("admin");
        adm.setSenha("admin");
        
        return adm;
    }
    
    public Login loginCacheUser(){
        Login user = new Login();
        
        user.setLogin("user");
        user.setSenha("user");
        
        return user;
    }

}
