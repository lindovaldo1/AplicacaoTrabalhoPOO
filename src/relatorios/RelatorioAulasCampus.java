package relatorios;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import dao.CampusDAO;
import dao.CursoDAO;
import dao.DisciplinaDAO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import model.Campus;

import model.Curso;
import model.Disciplina;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lindovaldo
 */
public class RelatorioAulasCampus {
    
    String caminhoArquivo = "C:\\Users\\Lindovaldo\\Desktop\\AplicacaoTrabalhoPOO\\relatorios";
    
    Campus campus;
    CampusDAO campusDao;
    CursoDAO cursoDao;
    DisciplinaDAO disciplinaDao;
    
    public RelatorioAulasCampus(Campus campus,CampusDAO campusDao, CursoDAO cursoDao, DisciplinaDAO disciplinaDao) {
        this.campusDao = campusDao;
        this.campus = campus;
        this.cursoDao = cursoDao;
        this.disciplinaDao = disciplinaDao;
        
        this.main();
    }
    

    
    public void main(){
        
        List<Curso> arrCurso = cursoDao.lista();
        List<Disciplina> arrDisciplina = disciplinaDao.lista();
    
        List<Curso> cursos = new ArrayList<>();
        List<Disciplina> disciplinas = new ArrayList<>();;
        List<Disciplina> atividades = new ArrayList<>();
        
        for (Curso curso : arrCurso) {
            if(curso.getCampus().getId() == campus.getId()){
                cursos.add(curso);
            }
        }
        
        for (Disciplina disciplina : arrDisciplina) {
            for (Curso curso : cursos) {
                if(disciplina.getCurso().getId() == curso.getId()){
                    atividades.add(disciplina);
                }
            }
            
        }
        String nomeArquivo = "Relatorio atividade do campus " + campus.getNome();
        
        String cabecalho = "Nome: "+campus.getNome() +"\t\t\t\t"+ " \n" + "Abreviação" + campus.getAbreviacao() +"\n";
        cabecalho += "Cidade: " + campus.getCidade() + "\t\t\t\t" + "Endereco: "+campus.getEndereco() +"\n";
        cabecalho += "Duração da aulas: "+campus.getDuracaoAula() +"\n\n\n";
        
        String saida = "";
        
        for (Disciplina object : atividades) {
            saida += String.format("Nome do curso: %s \t\t\t\t Nome da disciplina: %s  \t\t\t\t Carga Horaria:  ",object.getCurso().getNome(), object.getNome(), object.getCargaHoraria() +"\n");
        }
        
        relatorioPdf(nomeArquivo, cabecalho, saida);
    }
    
    
     private void relatorioPdf(String nomeArquivo, String cabecalho, String saida) {

        try (OutputStream file = new FileOutputStream(new File(caminhoArquivo + nomeArquivo + ".pdf"));) {
            Document document = new Document();

            PdfWriter.getInstance(document, file);

            document.open();
            document.add(new Paragraph(cabecalho, FontFactory.getFont(FontFactory.HELVETICA, 10)));
            document.add(new Paragraph(saida, FontFactory.getFont(FontFactory.HELVETICA, 10)));
            document.close();
            
            System.out.println("Relatório gerado com sucesso!");
            
        } catch (DocumentException | IOException e) {
            System.out.println("Erro");
        }

        
    }
}
