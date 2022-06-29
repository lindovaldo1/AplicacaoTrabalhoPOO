/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import model.Campus;
import model.Curso;
import model.Servidor;

/**
 *
 * @author Lindovaldo
 */
public class UserAdmin {
    
    GUI gui;
    Espaco espaco;
    CampusDAO campusDao;
    ServidorDAO servidorDao;
    CursoDAO cursoDao;
    DisciplinaDAO disciplinaDao;
    OfertaDisciplinaCursoDAO ofertaDao;
    OrientacoesDAO orientacoesDao;
    AtividadesDAO atividadesDao;
    ComissoesDAO comissaoDao;
    ServidoresComissoesDAO servidorComissaoDao;
    AtaReunioesDAO ataReuniaoDao;
    AtaReunioesPresentesDAO ataReuniaoPresentesDao;

    Scanner s = new Scanner(System.in);
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateTimeFormatter fmtAno = DateTimeFormatter.ofPattern("yyyy");
    
    public UserAdmin(CampusDAO campusdao, ServidorDAO servidordao, CursoDAO cursodao, DisciplinaDAO disciplinadao,
                     OfertaDisciplinaCursoDAO ofertadao, OrientacoesDAO orientacoesdao, AtividadesDAO atividadesdao,
                     ComissoesDAO comissoesdao, ServidoresComissoesDAO servidorComissaodao, AtaReunioesDAO atareunioesdao,
                     AtaReunioesPresentesDAO ataReunioesPresentesdao, GUI gui, Espaco espaco){
        
        this.gui = gui;
        this.campusDao = campusdao;
        this.servidorDao = servidordao;
        this.cursoDao = cursodao;
        this.disciplinaDao = disciplinadao;
        this.ofertaDao = ofertadao;
        this.orientacoesDao = orientacoesdao;
        this.atividadesDao = atividadesdao;
        this.comissaoDao = comissoesdao;
        this.servidorComissaoDao =servidorComissaodao;
        this.ataReuniaoDao = atareunioesdao;
        this.ataReuniaoPresentesDao= ataReunioesPresentesdao;
        this.espaco = espaco;
        
        this.menu();
    }
    
  
    
    public void menu() {
        int escolha; 
        espaco.darEspaco();

        do {
            escolha = gui.escolha();
            switch(escolha) {

                case 1:
                    espaco.darEspaco();
                    subMenuCampus(campusDao);
                    break;

                case 2:
                    espaco.darEspaco();
                    subMenuServidor(servidorDao);
                    break;
                
                case 3:
                    espaco.darEspaco();
                    subMenuCurso(cursoDao);
                    break;
                
                case 4:
                    espaco.darEspaco();
                    subMenuDisciplina(disciplinaDao);
                    break;
                
                case 5:
                    espaco.darEspaco();
                    subMenuOferta(ofertaDao);
                    break;
                
                case 6:
                    espaco.darEspaco();
                    subMenuOrientacao(orientacoesDao);
                    break;
                
                case 7:
                    espaco.darEspaco();
                    subMenuAtividade(atividadesDao);
                    break;

                case 8:
                    espaco.darEspaco();
                    subMenuComissao(comissaoDao);
                    break;
                
                case 9:
                    espaco.darEspaco();
                    subMenuServidorComissao(servidorComissaoDao);
                    break;
                
                case 10:
                    espaco.darEspaco();
                    subMenuAtaReuniao(ataReuniaoDao);
                    break;
                
                case 11:
                    espaco.darEspaco();
                    subMenuAtaReuniaoPresentes(ataReuniaoPresentesDao);
                    break;   
                   
                case 12:
                    espaco.darEspaco();
                    
                    System.out.println("\t\tRelatorio Atas das Reuniões\n\n");
                    
//                    System.out.print("\tInforme o nome da comissao: ");
//                    Comissao comissao = ComissaoDAO.busca(s.nextLine());
//                    
//                    System.out.print("\tInforme a data de inicio para filtrar: ");
//                    LocalDate inicio = LocalDate.parse(s.nextLine(), fmt);
//                    
//                    System.out.print("\tInforme a data de fim para filtrar: ");
//                    LocalDate fim = LocalDate.parse(s.nextLine(), fmt);
//                    
//                    System.out.println((ataReuniaoDao.relatorioPeriodo(comissao, inicio, fim) != null) ? ataReuniaoDao.relatorioPeriodo(comissao, inicio, fim) : "Não tem nenhuma informação para gerar um relatorio"); 
                    break;
                
                    
                case 13:
                    espaco.darEspaco();
                    System.out.println("\t\t Relatorio das Informações de Aulas\n\n");
//                    
//                    System.out.print("\tInforme o nome do campus: ");
//                    Campus campus = CampusDAO.busca(s.nextLine());
//                    
//                    System.out.println((ofertaDao.relatorioInfoAulas(campus) != null) ? ofertaDao.relatorioInfoAulas(campus) : "Não tem nenhuma informação para gerar um relatorio"); 
                    break;
                    
                case 14:
//                    espaco.darEspaco();
//                    StringBuilder rel = new StringBuilder();                                        
//                    Servidor serv = new Servidor();
//                    int cont = 0;
//
//                    do {
//                        System.out.println("Informe o nome do Servidor: ");
//                        serv = ServidorDAO.busca(s.nextLine());
//                    } while(serv == null);
//                    
//                    Oferta oferta[] = new Oferta[10];
//                    for(int i = 0; i < OfertaDAO.arr.length; i++) {
//                        if(OfertaDAO.arr[i] != null) {
//                            if(OfertaDAO.arr[i].getProfessor().getId() == serv.getId()) {
//                                oferta[cont] = OfertaDAO.arr[i];
//                                cont++;
//                            }
//                        }
//                    }
//                    
//                    cont = 0;
//                    Comissao comiss[] = new Comissao[10];
//                    for(int i = 0; i < ComissaoDAO.arr.length; i++) {
//                        if(ComissaoDAO.arr[i] != null) {
//                            for(int j = 0; j < ServidorComissaoDAO.arr.length; j++) {
//                                if(ServidorComissaoDAO.arr[j] != null) {
//                                    if(ComissaoDAO.arr[i].getComissao().equals(ServidorComissaoDAO.arr[j].getComissao()) && 
//                                            ServidorComissaoDAO.arr[j].getServidor() == serv) {
//                                        comiss[cont] = ComissaoDAO.arr[i];
//                                        cont++;                            
//                                    }
//                                }
//                            }
//                        }
//                    }
//                    
//                    cont = 0;
//                    Atividade ativid[] = new Atividade[10];
//                    for(int i = 0; i < AtividadeDAO.arr.length; i++) {
//                        if(AtividadeDAO.arr[i] != null) {
//                            if(AtividadeDAO.arr[i].getServidor() == serv) {
//                                ativid[cont] = AtividadeDAO.arr[i];
//                                cont++;
//                            }
//                        }
//                    }
//                    
//                    cont = 0;
//                    Orientacao ori[] = new Orientacao[10];
//                    for(int i = 0; i < OrientacaoDAO.arr.length; i++) {
//                        if(OrientacaoDAO.arr[i] != null) {
//                            if(OrientacaoDAO.arr[i].getServidor() == serv) {
//                                ori[cont] = OrientacaoDAO.arr[i];
//                                cont++;
//                            }
//                        }
//                    }
//                    
//                    rel = servidorDao.relatorioTrabalho(serv, oferta, comiss, ativid, ori);
//                    System.out.println(rel);
                    break;
                    
                case 15:
                    break;
                    
                default:
                    espaco.darEspaco();
                    System.out.println("Escolha invalida.");
                    break;
            }
        }while(escolha != 15);
    }

    private void subMenuCampus(CampusDAO obj) {
       
        int escolha = 0;
        espaco.darEspaco();
        
        do {
            escolha = gui.daoAdm();
            switch(escolha) {

                case 1:
                   espaco.darEspaco();
                    System.out.println(obj.toString());
                    break;

                case 2:
                    espaco.darEspaco();
                    System.out.println("Informe o nome do Campus para buscar: ");                    
                    Campus r = obj.buscaEspecifico(Long.parseLong(s.nextLine()));
                    System.out.println((r != null) ? r.toString() : "Campus não encontrado.");
                    break;

                case 3:
                    espaco.darEspaco();
                    Campus nObj = new Campus();
                    System.out.println("Nome do campus:");
                    nObj.setNome(s.nextLine());
                    System.out.println("Abreviação do campus:");
                    nObj.setAbreviacao(s.nextLine());
                    System.out.println("Duração da aula no campus:");
                    nObj.setDuracaoAula(Integer.parseInt(s.nextLine()));
                    System.out.println("Cidade do campus:");
                    nObj.setCidade(s.nextLine());
                    System.out.println("Bairro do campus:");
                    nObj.setBairro(s.nextLine());
                    System.out.println("Endereço do campus:");
                    nObj.setEndereco(s.nextLine());
                    System.out.println("CEP do campus:");
                    nObj.setCep(s.nextLine());
                    obj.adiciona(nObj);
                    break;

                case 4:
                    espaco.darEspaco();
                    System.out.println("Informe o nome do identificador para remover: ");                    
                    obj.remove(Long.parseLong(s.nextLine()));
                    break;

                case 5:
                    espaco.darEspaco();
                    
                    Campus aObj = new Campus();
                    
                    System.out.println(obj.toStringMin());
                    System.out.println("Informe o identificador do Campus para alterar: ");
                    aObj = campusDao.buscaEspecifico(Long.parseLong(s.nextLine()));;
  
                    System.out.println("Nome do campus:");
                    aObj.setNome(s.nextLine());
                    System.out.println("Abreviação do campus:");
                    aObj.setAbreviacao(s.nextLine());
                    System.out.println("Duração da aula no campus:");
                    aObj.setDuracaoAula(Integer.parseInt(s.nextLine()));
                    System.out.println("Data de criação do campus: ");
                    aObj.setDtCriacaoCampus(LocalDate.parse(s.nextLine(),fmt));
                    System.out.println("Cidade do campus:");
                    aObj.setCidade(s.nextLine());
                    System.out.println("Bairro do campus:");
                    aObj.setBairro(s.nextLine());
                    System.out.println("Endereço do campus:");
                    aObj.setEndereco(s.nextLine());
                    System.out.println("CEP do campus:");
                    aObj.setCep(s.nextLine());
                    obj.altera(aObj);
                    break;

                case 6:
                    break;

                default:
                    espaco.darEspaco();
                    System.out.println("Escolha invalida.");
                    break;
               
            }
        }while(escolha != 6);
        
    }

    private void subMenuServidor(ServidorDAO obj) {
        int escolha = 0;
        espaco.darEspaco();
        
        do {
            escolha = gui.daoAdm();
            switch(escolha) {

                case 1:
                    espaco.darEspaco();
                    System.out.println(obj.lista());
                    break;

                case 2:
                    espaco.darEspaco();
                    System.out.println(obj.toStringMin());
                    System.out.println("Informe o identidficador do Servidor para buscar: ");                    
                    Servidor r = obj.buscaEspecifico(Long.parseLong(s.nextLine()));
                    System.out.println((r != null) ? r.toString() : "Servidor não encontrado.");
                    break;

                case 3:
                    espaco.darEspaco();

                    Servidor nObj = new Servidor();
                    System.out.println("Nome do servidor: ");
                    nObj.setNome(s.nextLine());
                    System.out.println("E-mail do servidor: ");
                    nObj.setEmail(s.nextLine());
                    do {
                        System.out.println(campusDao.toStringMin());
                        System.out.println("Campus do servidor: ");
                        nObj.setCampus(campusDao.buscaEspecifico(Long.parseLong(s.nextLine())));
                    } while(nObj.getCampus() == null);
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
                    obj.adiciona(nObj);
                    break;

                case 4:
                   espaco.darEspaco();
                    System.out.println("Informe o identificador do Servidor para remover: ");                    
                    obj.remove(Long.parseLong(s.nextLine()));
                    break;

                case 5:
                    espaco.darEspaco();

                    Servidor vObj = new Servidor();
                    do {
                        System.out.println("Informe o identificador do Servidor para alterar: ");
                        vObj = servidorDao.buscaEspecifico(Long.parseLong(s.nextLine()));
                        System.out.println((vObj != null) ? vObj.toString() : "Servidor não encontrado.");
                    } while(vObj == null);

                    Servidor aObj = new Servidor();
                    System.out.println("Nome do servidor: ");
                    aObj.setNome(s.nextLine());
                    System.out.println("E-mail do servidor: ");
                    aObj.setEmail(s.nextLine());
                    do {
                        System.out.println("Campus do servidor: ");
                        aObj.setCampus(campusDao.buscaEspecifico(Long.parseLong(s.nextLine())));
                    } while(aObj.getCampus() == null);
                    do {
                        System.out.println("Cargo do servidor <1 - Professor> <2 - Tecnico Administrativo>: ");
                        aObj.setCargo(Integer.parseInt(s.nextLine()));
                    } while(aObj.getCargo() != 1 && aObj.getCargo() != 2);
                    System.out.println("Login do servidor: ");
                    aObj.setLogin(s.nextLine());
                    System.out.println("Senha do servidor: ");
                    aObj.setSenha(s.nextLine());
                    System.out.println("Tipo do usuário <1 - Administrador> <2 - Comum>: ");
                    aObj.setTipoUsuario(Integer.parseInt(s.nextLine()));
                    obj.altera(aObj);
                    break;

                case 6:
                    break;

                default:
                    espaco.darEspaco();
                    System.out.println("Escolha invalida.");
                    break;
            }
            
        }while(escolha != 6);
    }

    private void subMenuCurso(CursoDAO obj) {
        int escolha = 0;
        espaco.darEspaco();
        
        do{
                escolha = gui.daoAdm();
                switch(escolha) {

                    case 1:
                        espaco.darEspaco();
                        System.out.println(obj.lista());
                        break;

                    case 2:
                        espaco.darEspaco();
                        System.out.println(obj.toStringMin());
                        System.out.println("Informe o identificaddor do Curso para buscar: ");                    
                        Curso r = obj.buscaEspecifico(Long.parseLong(s.nextLine()));
                        System.out.println((r != null) ? r.toString() : "Curso não encontrado.");
                        break;

                    case 3:
                        espaco.darEspaco();
                        Curso nObj = new Curso();
                        System.out.println("Nome do Curso:");
                        nObj.setNome(s.nextLine());
                        do {
                            System.out.println("Informe o Campus do curso: ");
                            nObj.setCampus(campusDao.buscaEspecifico(Long.parseLong(s.nextLine())));
                        } while(nObj.getCampus() == null);
                        System.out.println("Data de criação do curso");
                        nObj.setAnoInicio(LocalDate.parse(s.nextLine(),fmt));                        
                        System.out.println("Data de encerramento do curso");
                        nObj.setAnoTermino(LocalDate.parse(s.nextLine(),fmt));
                        obj.adiciona(nObj);
                        break;

                    case 4:
                        espaco.darEspaco();
                        System.out.println(cursoDao.toStringMin());
                        System.out.println("Informe o identificador do Curso para remover: ");                    
                       obj.remove(Long.parseLong(s.nextLine()));
                        break;

                    case 5:
                        espaco.darEspaco();

                        Curso vObj = new Curso();
                        do {
                            System.out.println("Informe o identificador do Curso para alterar: ");
                            vObj = cursoDao.buscaEspecifico(Long.parseLong(s.nextLine()));
                            System.out.println((vObj != null) ? vObj.toString() : "Curso não encontrado.");
                        } while(vObj == null);
                        
                        Curso aObj = new Curso();
                        System.out.println("Nome do Curso:");
                        aObj.setNome(s.nextLine());
                        do {
                            System.out.println("Informe o Campus do curso: ");
                            aObj.setCampus(campusDao.buscaEspecifico(Long.parseLong(s.nextLine())));
                        } while(aObj.getCampus() == null);
                        System.out.println("Data de criação do curso");
                        aObj.setAnoInicio(LocalDate.parse(s.nextLine(),fmt));                        
                        System.out.println("Data de encerramento do curso");
                        aObj.setAnoTermino(LocalDate.parse(s.nextLine(),fmt));
                        obj.altera(aObj);
                        break;

                    case 6:
                        break;

                    default:
                        espaco.darEspaco();
                        System.out.println("Escolha invalida.");
                        break;
                }

        }while(escolha != 6);
    }

    private void subMenuDisciplina(DisciplinaDAO disciplinaDao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void subMenuOferta(OfertaDisciplinaCursoDAO ofertaDao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void subMenuComissao(ComissoesDAO comissaoDao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void subMenuServidorComissao(ServidoresComissoesDAO servidorComissaoDao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void subMenuAtaReuniaoPresentes(AtaReunioesPresentesDAO ataReuniaoPresentesDao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void subMenuAtaReuniao(AtaReunioesDAO ataReuniaoDao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void subMenuOrientacao(OrientacoesDAO orientacoesDao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void subMenuAtividade(AtividadesDAO atividadesDao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
    
}
