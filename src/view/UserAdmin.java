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
        
        this.main();
    }
    
    private void main(){
        System.out.println("Admin");
    }
    
}
