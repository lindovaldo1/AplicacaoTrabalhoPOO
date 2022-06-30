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
import model.AtaReunioes;
import model.AtaReunioesPresentes;
import model.Atividades;
import model.Campus;
import model.Comissoes;
import model.Curso;
import model.Disciplina;
import model.OfertaDisciplinaCurso;
import model.Orientacoes;
import model.Servidor;
import model.ServidoresComissoes;

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
                    System.out.println(obj.toStringMin());
                    System.out.println("Informe o identificador do Campus para buscar: ");                    
                    Campus r = obj.buscaEspecifico(Long.parseLong(s.nextLine()));
                    espaco.darEspaco();
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
                    System.out.println(obj.toStringMin());
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
                    System.out.println(obj.toString());
                    break;

                case 2:
                    espaco.darEspaco();
                    System.out.println(obj.toStringMin());
                    System.out.println("Informe o identidficador do Servidor para buscar: ");                    
                    Servidor r = obj.buscaEspecifico(Long.parseLong(s.nextLine()));
                    espaco.darEspaco();
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
                    System.out.println(obj.toStringMin());
                    System.out.println("Informe o identificador do Servidor para remover: ");                    
                    obj.remove(Long.parseLong(s.nextLine()));
                    break;

                case 5:
                    espaco.darEspaco();

                    Servidor alterar = new Servidor();
                    
                    System.out.println(obj.toStringMin());
                    System.out.println("Informe o identificador do Servidor para alterar: ");
                    alterar.setId(Long.parseLong(s.nextLine()));
;
                    System.out.println("Nome do servidor: ");
                    alterar.setNome(s.nextLine());
                    
                    System.out.println("E-mail do servidor: ");
                    alterar.setEmail(s.nextLine());
                    
                    System.out.println(campusDao.toStringMin());
                    System.out.println("Campus do servidor: ");
                    alterar.setCampus(campusDao.buscaEspecifico(Long.parseLong(s.nextLine())));

                    System.out.println("Cargo do servidor <1 - Professor> <2 - Tecnico Administrativo>: ");
                    alterar.setCargo(Integer.parseInt(s.nextLine()));
                        
                    System.out.println("Login do servidor: ");
                    alterar.setLogin(s.nextLine());
                    
                    System.out.println("Senha do servidor: ");
                    alterar.setSenha(s.nextLine());
                    
                    System.out.println("Tipo do usuário <1 - Administrador> <2 - Comum>: ");
                    alterar.setTipoUsuario(Integer.parseInt(s.nextLine()));
                    
                    obj.altera(alterar);
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
                        System.out.println(obj.toString());
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
                            System.out.println(campusDao.toStringMin());
                            System.out.println("Informe o Campus do curso: ");
                            nObj.setCampus(campusDao.buscaEspecifico(Long.parseLong(s.nextLine())));
                        } while(nObj.getCampus() == null);
                        System.out.println("Informe o estado do curso (1 = ativo, 0 = inativo): ");
                        nObj.setEstado(Integer.parseInt(s.nextLine()));
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
                            System.out.println(obj.toStringMin());
                            System.out.println("Informe o identificador do Curso para alterar: ");
                            vObj = cursoDao.buscaEspecifico(Long.parseLong(s.nextLine()));
                            System.out.println((vObj != null) ? vObj.toString() : "Curso não encontrado.");
                        } while(vObj == null);
                        
                        Curso aObj = new Curso();
                        System.out.println("Nome do Curso:");
                        aObj.setNome(s.nextLine());
                        do {
                            System.out.println(campusDao.toStringMin());
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

    private void subMenuDisciplina(DisciplinaDAO obj) {
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
                    System.out.println(obj.toStringMin());
                    System.out.println("Informe o nome da disciplina para buscar: ");                    
                    Disciplina r = disciplinaDao.buscaEspecifico(Long.parseLong(s.nextLine()));
                    System.out.println((r != null) ? r.toString() : "Disciplina não encontrado.");
                    break;

                case 3:
                    espaco.darEspaco();
                    Disciplina nObj = new Disciplina();
                    System.out.println("Nome da disciplina: ");
                    nObj.setNome(s.nextLine());
                    System.out.println("Informe a carga horaria da disciplina: ");
                    nObj.setCargaHoraria(Integer.parseInt(s.nextLine()));
                    do {
                        System.out.println("Informe a periodicidade da disciplina <1 - Semestral> <2 - Anual>:");
                        nObj.setPeriodicidade(Integer.parseInt(s.nextLine()));
                    } while(nObj.getPeriodicidade() != 1 && nObj.getPeriodicidade() != 2);                    
                    do {
                        System.out.println(cursoDao.toStringMin());
                        System.out.println("Informe o curso que a disciplina está vinculado: ");
                        nObj.setCurso(cursoDao.buscaEspecifico(Long.parseLong(s.nextLine())));
                    } while(nObj.getCurso() == null);
                    obj.adiciona(nObj);
                    break;

                case 4:
                    espaco.darEspaco();
                    System.out.println(obj.toStringMin());
                    System.out.println("Informe o identificador da disciplina para remover: ");                    
                    obj.remove(Long.parseLong(s.nextLine()));
                    break;

                case 5:
                    espaco.darEspaco();

                    Disciplina vObj = new Disciplina();
                    do {
                        System.out.println(disciplinaDao.toStringMin());
                        System.out.println("Informe o nome da disciplina para alterar: ");
                        vObj = disciplinaDao.buscaEspecifico(Long.parseLong(s.nextLine()));
                        System.out.println((vObj != null) ? vObj.toString() : "Disciplina não encontrada.");
                    } while(vObj == null);

                    Disciplina aObj = new Disciplina();
                    aObj.setId(vObj.getId());
                    System.out.println("Nome da disciplina: ");
                    aObj.setNome(s.nextLine());
                    System.out.println("Informe a carga horaria da disciplina: ");
                    aObj.setCargaHoraria(Integer.parseInt(s.nextLine()));
                    do {
                        System.out.println("Informe a periodicidade da disciplina <1 - Semestral> <2 - Anual>:");
                        aObj.setPeriodicidade(Integer.parseInt(s.nextLine()));
                    } while(aObj.getPeriodicidade() != 1 && aObj.getPeriodicidade() != 2);                    
                    do {
                        System.out.println(cursoDao.toStringMin());
                        System.out.println("Informe o curso que a disciplina está vinculado: ");
                        aObj.setCurso(cursoDao.buscaEspecifico(Long.parseLong(s.nextLine())));
                    } while(aObj.getCurso() == null);
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

    private void subMenuAtividade(AtividadesDAO obj) {
        int escolha = 0;
        Atividades nObj = new Atividades();
        
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
                    
                    System.out.println(obj.toStringMin());
                    System.out.println("Informe o identidicador da atividade que está procurando");
                    Long id = Long.parseLong(s.nextLine());
                    System.out.println(atividadesDao.buscaEspecifico(id));                    
                    break;

                case 3:
                    espaco.darEspaco();               
                    
                    System.out.println("Informe a descricao da atividade: ");
                    nObj.setDescricao(s.nextLine());
                    
                    System.out.println(servidorDao.toStringMin());
                    System.out.println("Informe o identificador do servidor responsavel: ");
                    nObj.setServidor(servidorDao.buscaEspecifico(Long.parseLong(s.nextLine())));

                    System.out.println("Informe as horas semanais dessa atividade: ");
                    nObj.setHorasSemanais(Double.parseDouble(s.nextLine()));

                    System.out.println("Informe a data de inicio da atividade(dd/MM/yyyy): ");
                    nObj.setDtInicio(LocalDate.parse(s.nextLine(), fmt));

                    System.out.println("Informe a data de Fim da atividade(dd/MM/yyyy): ");
                    nObj.setDtFim(LocalDate.parse(s.nextLine(), fmt));

                    obj.adiciona(nObj);
                    break;

                case 4:
                    espaco.darEspaco();
                    
                    System.out.println(obj.toStringMin());
                    System.out.println("Informe o identificador da atividade para poder remover: ");
                    obj.remove(Long.parseLong(s.nextLine()));
                    break;

                case 5:
                    espaco.darEspaco();
                    
                    Atividades altera = new Atividades();
                    
                    System.out.println(obj.toStringMin());
                    System.out.println("Informe o indentificador da Atividade que deseja alterar: ");
                    altera.setId(Long.parseLong(s.nextLine()));

                    System.out.println("Informe a nova Descricao da Atividade: ");
                    altera.setDescricao(s.nextLine());        
                    
                    System.out.println(servidorDao.toStringMin());
                    System.out.println("Informe o identificador do novo servidor responsavel: ");
                    altera.setServidor(servidorDao.buscaEspecifico(Long.parseLong(s.nextLine())));

                    System.out.println("Informe a nova quantidade de horas semanais dessa atividade: ");
                    altera.setHorasSemanais(Integer.parseInt(s.nextLine()));    

                    System.out.println("Informe a nova data de inicio da atividade(dd/MM/yyyy): ");
                    altera.setDtInicio(LocalDate.parse(s.nextLine(), fmt));

                    System.out.println("Informe a nova data de fim da atividade(dd/MM/yyyy): ");
                    altera.setDtFim(LocalDate.parse(s.nextLine(),fmt));


                    obj.altera(altera);
                    break;

                case 6:
                    espaco.darEspaco();
                    break;

                default:
                    espaco.darEspaco();
                    System.out.println("Escolha invalida.");
                    break;
            }
        }while(escolha != 6);  

    }
    
    private void subMenuComissao(ComissoesDAO obj) {
     
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
                        System.out.println(obj.toStringMin());
                        System.out.println("Informe a identificador da comisao que está procurando");
                        String aux = s.nextLine();
                        System.out.println((comissaoDao.buscaEspecifico(Long.parseLong(aux)) != null) ? comissaoDao.buscaEspecifico(Long.parseLong(aux)).toString() : "Comissao não encontrado.");
                        break;

                    case 3:
                        espaco.darEspaco();                    
                        Comissoes nObj = new Comissoes();
                        
                        System.out.println("Informe o nome da Comissao: ");
                        nObj.setComissao(s.nextLine());

                        System.out.println("Informe a quantidade de horas semanais da comissao: ");
                        nObj.sethSemanais(Integer.parseInt(s.nextLine()));

                        System.out.println("Informe o estado da comissao <1- Ativada | 2- Desativada>: ");
                        nObj.setEstado((Integer.parseInt(s.nextLine())));

                        System.out.println("Informe a data de Fim da comisaao(dd/MM/yyyy): ");
                        nObj.setDtFim(LocalDate.parse(s.nextLine(), fmt));
                        
                        obj.adiciona(nObj);
                        break;

                    case 4:
                        espaco.darEspaco();
                        
                        System.out.println(obj.toStringMin());
                        System.out.println("Informe o identificador da Comissão para poder remover: ");
                        aux = s.nextLine();

                        obj.remove(Long.parseLong(aux));
                        break;

                    case 5:
                        espaco.darEspaco();
                        Comissoes altera = new Comissoes();
                        
                        System.out.println(obj.toStringMin());
                        System.out.println("Informe o identificador da Comissão que deseja alterar: ");
                        altera.setId(Long.parseLong(s.nextLine()));

                        System.out.println("Informe o nome da nova Comissão: ");
                        altera.setComissao(s.nextLine());

                        System.out.println("Informe a nova quantidade de horas semanais dessa Comissão: ");
                        altera.sethSemanais(Integer.parseInt(s.nextLine()));

                        System.out.println("Informe a nova data de inicio da Comissao(dd/MM/yyyy): ");
                        altera.setDtInicio(LocalDate.parse(s.nextLine(), fmt));

                        System.out.println("Informe a data nova de Fim da Comissão(dd/MM/yyyy): ");
                        altera.setDtFim(LocalDate.parse(s.nextLine(), fmt));
                        
                        System.out.println("Informe o novo estado da Comissão  <1- Ativada  |   2- Desativada>: ");
                        altera.setEstado(Integer.parseInt(s.nextLine()));
                        
                        
                        obj.altera(altera);
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
    
    private void subMenuAtaReuniao(AtaReunioesDAO obj) {
        
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
                        
                        System.out.println(obj.toStringMin());
                        System.out.println("Informe o identificador da ata da reuniao que deseja procurar");
                        System.out.println(ataReuniaoDao.buscaEspecifico(Long.parseLong(s.nextLine())));
                        break;
                        
                    case 3:
                        espaco.darEspaco();
                        AtaReunioes nObj = new AtaReunioes();
                        
                        System.out.println("Informe o conteudo da ata da reunião: ");
                        nObj.setAtaConteudo(s.nextLine());
                        
                        System.out.println(comissaoDao.toStringMin());
                        System.out.println("Informe o identificador da Comissao: ");
                        nObj.setComissao(comissaoDao.buscaEspecifico(Long.parseLong(s.nextLine())));
                        
                        System.out.println(servidorDao.toStringMin());
                        System.out.println("Informe o identificador do Servidor: ");
                        nObj.setSecretario(servidorDao.buscaEspecifico(Long.parseLong(s.nextLine())));
                        
                        System.out.println("Informe a data da reuniao(dd/MM/yyyy): ");
                        nObj.setDtReuniao(LocalDate.parse(s.nextLine(), fmt));
                        
                        obj.adiciona(nObj);
                        break;
                        
                    case 4:
                        espaco.darEspaco();
                        
                        System.out.println(obj.toStringMin());
                        System.out.println("Informe o identificador da ata da reuniao para poder remover");
                        
                        obj.remove(Long.parseLong(s.nextLine()));
                        break;
                        
                    case 5:
                        espaco.darEspaco();
                        AtaReunioes altera = new AtaReunioes();
                        
                        System.out.println(obj.toStringMin());
                        
                        System.out.println("Informe o identificador da ata da reuniao que deseja procurar");
                        altera.setId(Long.parseLong(s.nextLine()));
                        altera.setComissao(ataReuniaoDao.buscaEspecifico(altera.getId()).getComissao());
                        
                        System.out.println("Informe o novo conteudo da ata: ");
                        altera.setAtaConteudo(s.nextLine());         

                        System.out.println(servidorDao.toStringMin());
                        System.out.println("Informe o novo secretario: ");
                        altera.setSecretario(servidorDao.buscaEspecifico(Long.parseLong(s.nextLine())));
                                
                        System.out.println("Informe a nova data da ata da reuniao(dd/MM/yyyy): ");
                        altera.setDtReuniao(LocalDate.parse(s.nextLine(), fmt));
                                
                        obj.altera(altera);
                        
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
    
    private void subMenuOferta(OfertaDisciplinaCursoDAO obj) {
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
                        
                        System.out.println(obj.toStringMin());
                        System.out.println("Informe o identificador da oferta: ");                    
                        System.out.println(ofertaDao.buscaEspecifico(Long.parseLong(s.nextLine())));
                        break;
                    case 3:
                        espaco.darEspaco();             

                        OfertaDisciplinaCurso adiciona = new OfertaDisciplinaCurso();
                        
                        System.out.println(cursoDao.toStringMin());
                        System.out.println("Informe o identificador do curso: ");        
                        adiciona.setCurso(cursoDao.buscaEspecifico(Long.parseLong(s.nextLine())));
                        
                        System.out.println(disciplinaDao.toStringMin());
                        System.out.println("Informe o identificador da disciplina");
                        adiciona.setDisciplina(disciplinaDao.buscaEspecifico(Long.parseLong(s.nextLine())));
                        
                        System.out.println(servidorDao.toStringMin());
                        System.out.println("Informe o identificador do professor");
                        adiciona.setProfessor(servidorDao.buscaEspecifico(Long.parseLong(s.nextLine())));
                        
                        System.out.println("Informe o ano: ");
                        adiciona.setAno(Integer.parseInt(s.nextLine()));
                        
                        System.out.println("Informe o semestre: ");
                        adiciona.setSemestre(Integer.parseInt(s.nextLine()));
                        
                        System.out.println("Informe o aulas semanais: ");
                        adiciona.setAulasSemanais(Integer.parseInt(s.nextLine()));
                        
                        obj.adiciona(adiciona);
                        break;

                    case 4:
                        espaco.darEspaco();
                        System.out.println(obj.toStringMin());
                        System.out.println("Informe o identificador da oferta para ser removida: ");
                        obj.remove(Long.parseLong(s.nextLine()));
                        break;
                        
                    case 5:
                        espaco.darEspaco();
                        
                        OfertaDisciplinaCurso alterar = new OfertaDisciplinaCurso();
                        
                        System.out.println(obj.toStringMin());
                        System.out.println("Informe o identificador para poder alterar: ");
                        alterar.setId(Long.parseLong(s.nextLine()));
                        
                        System.out.println(cursoDao.toStringMin());
                        System.out.println("Informe o identificador do curso: ");        
                        alterar.setCurso(cursoDao.buscaEspecifico(Long.parseLong(s.nextLine())));
                        
                        System.out.println(disciplinaDao.toStringMin());
                        System.out.println("Informe o identificador da disciplina");
                        alterar.setDisciplina(disciplinaDao.buscaEspecifico(Long.parseLong(s.nextLine())));
                        
                        System.out.println(servidorDao.toStringMin());
                        System.out.println("Informe o identificador do professor");
                        alterar.setProfessor(servidorDao.buscaEspecifico(Long.parseLong(s.nextLine())));
                        
                        System.out.println("Informe o ano: ");
                        alterar.setAno(Integer.parseInt(s.nextLine()));
                        
                        System.out.println("Informe o semestre: ");
                        alterar.setSemestre(Integer.parseInt(s.nextLine()));
                        
                        System.out.println("Informe o aulas semanais: ");
                        
                        obj.altera(alterar);
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
    
    private void subMenuServidorComissao(ServidoresComissoesDAO obj) {
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
                    System.out.println(obj.toStringMin());
                    System.out.println("Informe o identifivador da comisao que está procurando");
                    long idProcura = Long.parseLong(s.nextLine());
                    
                    System.out.println( servidorComissaoDao.buscaEspecifico(idProcura));

                    break;

                case 3:
                    espaco.darEspaco();                 
                    ServidoresComissoes nObj = new ServidoresComissoes();
                    
                    System.out.println(comissaoDao.toStringMin());
                    System.out.println("Informe o nome da Comissao: ");
                    nObj.setComissao(comissaoDao.buscaEspecifico(Long.parseLong(s.nextLine())));
                    
                    System.out.println(servidorDao.toStringMin());
                    System.out.println("Informe o nome do Servidor: ");
                    nObj.setServidor(servidorDao.buscaEspecifico(Long.parseLong(s.nextLine())));

                    System.out.println("Informe o papel do servidor <1 - presidente, 2 - vice, 3- secretario, 4- participante, 5- suplemente>: ");
                    nObj.setPapel(Integer.parseInt(s.nextLine()));

                    System.out.println("Informe a data de inicio na comissao(dd/MM/yyyy): ");
                    nObj.setDtEntrada(LocalDate.parse(s.nextLine(), fmt));

                    System.out.println("Informe a data de Fim na comisaao(dd/MM/yyyy): ");
                    nObj.setDtSaida(LocalDate.parse(s.nextLine(), fmt));

                    obj.adiciona(nObj);
                    break;

                case 4:
                    espaco.darEspaco();
                    System.out.println(obj.toStringMin());
                    System.out.println("Informe a identificador da comisao servidor para poder remover");
                    
                    obj.remove(Long.parseLong(s.nextLine()));
                    break;

                case 5:
                    espaco.darEspaco();                 
                    
                    ServidoresComissoes alterar = new ServidoresComissoes();
                    
                    System.out.println(obj.toStringMin());
                    System.out.println("Informe o codigo do servidor comissões");
                    alterar.setId(Long.parseLong(s.nextLine()));
                    
                    System.out.println(comissaoDao.toStringMin());
                    System.out.println("Informe o nome da Comissao: ");
                    alterar.setComissao(comissaoDao.buscaEspecifico(Long.parseLong(s.nextLine())));
                    
                    System.out.println(servidorDao.toStringMin());
                    System.out.println("Informe o nome do Servidor: ");
                    alterar.setServidor(servidorDao.buscaEspecifico(Long.parseLong(s.nextLine())));

                    System.out.println("Informe o papel do servidor <1 - presidente, 2 - vice, 3- secretario, 4- participante, 5- suplemente>: ");
                    alterar.setPapel(Integer.parseInt(s.nextLine()));

                    System.out.println("Informe a data de inicio na comissao(dd/MM/yyyy): ");
                    alterar.setDtEntrada(LocalDate.parse(s.nextLine(), fmt));

                    System.out.println("Informe a data de Fim na comisaao(dd/MM/yyyy): ");
                    alterar.setDtSaida(LocalDate.parse(s.nextLine(), fmt));

                    obj.altera(alterar);
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

    private void subMenuAtaReuniaoPresentes(AtaReunioesPresentesDAO obj) {
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
                    
                    System.out.println(obj.toStringMin());
                    System.out.println("Informe o identificador da presenca que deseja buscar: ");
                    System.out.println(obj.buscaEspecifico(Long.parseLong(s.nextLine())));
                    
                    break;

                case 3:
                    espaco.darEspaco();
                    
                    AtaReunioesPresentes adicionar = new AtaReunioesPresentes();

                    
                    System.out.println(comissaoDao.toStringMin());
                    System.out.println("Informe o identificador da comissão: ");
                    adicionar.setComissao(comissaoDao.buscaEspecifico(Long.parseLong(s.nextLine())));
                    
                    System.out.println(servidorDao.toStringMin());
                    System.out.println("Informe o identificador do servidor: ");
                    adicionar.setServidor(servidorDao.buscaEspecifico(Long.parseLong(s.nextLine())));
                    
                    System.out.println(ataReuniaoDao.toStringMin());
                    System.out.println("Informe o identificador da data da ata da reuniao: ");
                    adicionar.setAtaReuniao(ataReuniaoDao.buscaEspecifico(Long.parseLong(s.nextLine())));

                    obj.adiciona(adicionar);
                    break;

                case 4:
                    espaco.darEspaco();
                    
                    System.out.println(ataReuniaoPresentesDao.toStringMin());
                    System.out.println("Informe o identificador da da presenca que deseja remover: ");
                    obj.remove(Long.parseLong(s.nextLine()));
                    
                    break;

                case 5:
                    espaco.darEspaco();
                    
                    AtaReunioesPresentes alterar = new AtaReunioesPresentes();

                    System.out.println(obj.toStringMin());
                    System.out.println("Informe o identificador da presenca que deseja alterar: ");
                    alterar.setId(Long.parseLong(s.nextLine()));
                    
                    System.out.println(comissaoDao.toStringMin());
                    System.out.println("Informe o identificador da comissão: ");
                    alterar.setComissao(comissaoDao.buscaEspecifico(Long.parseLong(s.nextLine())));
                    
                    System.out.println(servidorDao.toStringMin());
                    System.out.println("Informe o identificador do servidor: ");
                    alterar.setServidor(servidorDao.buscaEspecifico(Long.parseLong(s.nextLine())));
                    
                    System.out.println(ataReuniaoDao.toStringMin());
                    System.out.println("Informe o identificador da data da ata da reuniao: ");
                    alterar.setAtaReuniao(ataReuniaoDao.buscaEspecifico(Long.parseLong(s.nextLine())));
                    
                    obj.altera(alterar);
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

    private void subMenuOrientacao(OrientacoesDAO obj) {
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
                    System.out.println(obj.toStringMin());
                    System.out.println("Informe o identificador da Orientação");
                    System.out.println(obj.buscaEspecifico(Long.parseLong(s.nextLine())));
                    break;

                case 3:
                    Orientacoes adicionar = new Orientacoes();
                    
                    System.out.println("Infome o tipo de orientação(1 - ensino, 2 - pesquisa, 3 - extensão, 4 - estagio, 5 - tcc, 6 - mestrado, 7 - doutorado): ");
                    adicionar.setTipoOrientacao(Integer.parseInt(s.nextLine()));
                    
                    System.out.println("Informe o nome do aluno");
                    adicionar.setNomeAluno(s.nextLine());
                    
                    System.out.println(servidorDao.toStringMin());
                    System.out.println("Informe o identificador do servidor: ");
                    adicionar.setServidor(servidorDao.buscaEspecifico(Long.parseLong(s.nextLine())));
                    
                    System.out.println("Informe as horas semanais: ");
                    adicionar.setHorasSemanais(Integer.parseInt(s.nextLine()));
                    
                    System.out.println("Informe a data de inicio da atividade: ");
                    adicionar.setDtInicio(LocalDate.parse(s.nextLine(), fmt));
                    
                    System.out.println("Informe a data de termino da atividade: ");
                    adicionar.setDtTermino(LocalDate.parse(s.nextLine(), fmt));
                    
                    obj.adiciona(adicionar);
                    break;

                case 4:
                    espaco.darEspaco();

                    System.out.println(obj.toStringMin());
                    System.out.println("Informe o identificador para a orientação ser removida: ");
                    obj.remove(Long.parseLong(s.nextLine()));
                    
                    break;

                case 5:
                    espaco.darEspaco();
                    
                    Orientacoes altera = new Orientacoes();
                    
                    System.out.println(obj.toStringMin());
                    System.out.println("Informe o identificador para alterar: ");
                    altera.setId(Long.parseLong(s.nextLine()));
                    
                    System.out.println("Infome o tipo de orientação(1 - ensino, 2 - pesquisa, 3 - extensão, 4 - estagio, 5 - tcc, 6 - mestrado, 7 - doutorado): ");
                    altera.setTipoOrientacao(Integer.parseInt(s.nextLine()));
                    
                    System.out.println("Informe o nome do aluno");
                    altera.setNomeAluno(s.nextLine());
                    
                    System.out.println(servidorDao.toStringMin());
                    System.out.println("Informe o identificador do servidor: ");
                    altera.setServidor(servidorDao.buscaEspecifico(Long.parseLong(s.nextLine())));
                    
                    System.out.println("Informe as horas semanais: ");
                    altera.setHorasSemanais(Integer.parseInt(s.nextLine()));
                    
                    System.out.println("Informe a data de inicio da atividade: ");
                    altera.setDtInicio(LocalDate.parse(s.nextLine(), fmt));
                    
                    System.out.println("Informe a data de termino da atividade: ");
                    altera.setDtTermino(LocalDate.parse(s.nextLine(), fmt));
                    
                    obj.altera(altera);
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


    
}
