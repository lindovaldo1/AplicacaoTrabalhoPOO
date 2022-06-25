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

/**
 *
 * @author Lindovaldo
 */
public class Main {
    
    CampusDAO campusDao = new CampusDAO();
    ServidorDAO servidorDao = new ServidorDAO(campusDao);
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
        
    
    }
    
    public static void main(String[] args) {
        Main main = new Main();
    }
}
