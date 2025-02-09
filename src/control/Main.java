/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.AtaReunioesDAO;
import dao.AtaReunioesPresentesDAO;
import dao.AtividadesDAO;
import dao.CampusDAO;
import dao.ComissoesDAO;
import dao.CursoDAO;
import dao.DisciplinaDAO;
import dao.OfertaDisciplinaCursoDAO;
import dao.OrientacoesDAO;
import dao.ServidorDAO;
import dao.ServidoresComissoesDAO;
import extra.Espaco;
import extra.Login;
import java.util.Scanner;
import model.Servidor;
import view.GUI;
import view.UserAdmin;
import view.UserComum;

/**
 *
 * @author Lindovaldo
 */
public class Main {
    
    GUI gui = new GUI();
    Login login = new Login();
    Espaco espaco = new Espaco();
    
    CampusDAO campusDao = new CampusDAO();
    ServidorDAO servidorDao = new ServidorDAO();
    CursoDAO cursoDao = new CursoDAO();
    DisciplinaDAO disciplinaDao = new DisciplinaDAO();
    OfertaDisciplinaCursoDAO ofertaDao = new OfertaDisciplinaCursoDAO();
    OrientacoesDAO orientacoesDao = new OrientacoesDAO();
    AtividadesDAO atividadesDao = new AtividadesDAO();
    ComissoesDAO comissaoDao = new ComissoesDAO();
    ServidoresComissoesDAO servidorComissaoDao = new ServidoresComissoesDAO();
    AtaReunioesDAO ataReuniaoDao = new AtaReunioesDAO();
    AtaReunioesPresentesDAO ataReuniaoPresentesDao = new AtaReunioesPresentesDAO();
    
    public Main(){
        
//        int opcaoLogin = gui.telaIniLog(); //Login Padrao
        
        int opcaoLogin = 1; // Apagar Testes tem Login
//        int opcaoLogin = 2; // Apagar Testes Cadastrar
        
        while(opcaoLogin <= 2){
            
            System.out.println(opcaoLogin);
            
//            login = gui.temLog();
//            Servidor servidor = servidorDao.buscaLogin(login);
            

//            login = gui.loginCacheAdm(); // Apagar Login Administrativo
            login = gui.loginCacheUser(); //Apagar Login Usuario Comun
            
            Servidor servidor = servidorDao.buscaLogin(login);
            
            if(opcaoLogin == 1 && servidor != null){
                
                if(servidor.getTipoUsuario() == 2){
                   
                   espaco.darEspaco();
                   System.out.println("  ** Login feito com sucesso. Seja bem vindo "+servidor.getNome()+"**\n\n");
                   
                   UserComum userComum = new UserComum(campusDao, servidorDao, cursoDao, disciplinaDao, ofertaDao,
                                                    orientacoesDao, atividadesDao, comissaoDao, servidorComissaoDao,
                                                    ataReuniaoDao, ataReuniaoPresentesDao, gui);
                   
                   
                }else if(servidor.getTipoUsuario() == 1){
                    
                    System.out.println("  ** Login feito com sucesso. Seja bem vindo "+servidor.getNome()+"**\n\n");
                    
                    UserAdmin userAdmin = new UserAdmin(campusDao, servidorDao, cursoDao, disciplinaDao, ofertaDao,
                                                    orientacoesDao, atividadesDao, comissaoDao, servidorComissaoDao,
                                                    ataReuniaoDao, ataReuniaoPresentesDao, gui);
                    
                }  
                
                opcaoLogin = 3;
                
            }else if (opcaoLogin == 2 ){
                
                System.out.println("       == Cadastrando Servidor == \n\n");
                Scanner s = new Scanner(System.in);

                Servidor nObj = new Servidor();
                System.out.println("Nome do servidor: ");
                nObj.setNome(s.nextLine());
                
                System.out.println("E-mail do servidor: ");
                nObj.setEmail(s.nextLine());
                
                System.out.println("Campus do servidor: "); 
                nObj.setCampus(Long.parseLong(s.nextLine()));
                

                do {
                    System.out.println("Cargo do servidor <1 - Professor> <2 - Tecnico Administrativo>: ");
                    nObj.setCargo(Integer.parseInt(s.nextLine()));
                } while(nObj.getCargo() != 1 && nObj.getCargo() != 2);

                System.out.println("Login do servidor: ");
                nObj.setLogin(s.nextLine());
                
                System.out.println("Senha do servidor: ");
                nObj.setSenha(s.nextLine());
                
                System.out.println("Tipo do usuário <1 - Administrador> <2 - Comum>: ");
                nObj.setTipoUsuario(Integer.parseInt(s.nextLine()));
                
                servidorDao.adiciona(nObj);
                
                opcaoLogin = 1;
            }
        }
    
    }
    
    public static void main(String[] args) {
        Main main = new Main();
    }
}
