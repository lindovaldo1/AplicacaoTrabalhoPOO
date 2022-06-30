/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import model.OfertaDisciplinaCurso;

/**
 *
 * @author Lindovaldo
 */
public class OfertaDisciplinaCursoDAO {

    DisciplinaDAO disciplinaDao;
    ServidorDAO servidorDao;
    CursoDAO cursoDao;
    
    public OfertaDisciplinaCursoDAO(DisciplinaDAO disciplina, ServidorDAO servidor, CursoDAO curso) {
        this.servidorDao = servidor;
        this.disciplinaDao = disciplina;
        this.cursoDao = curso;
    }
    

     public void adiciona(OfertaDisciplinaCurso obj){
        
         String sql = "insert into oferta_disciplina_curso"
                    + " (curso, disciplina, professor, ano, semestre, aulas_semanais, criacao, modificacao)"
                    + " values (?,?,?,?,?,?,?,?)";
         
        try (Connection connection = new ConnectionFactory().getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            stmt.setLong(1, obj.getCurso().getId());
            stmt.setLong(2, obj.getDisciplina().getId());
            stmt.setLong(3, obj.getProfessor().getId());
            stmt.setInt(4, obj.getAno());
            stmt.setInt(5, obj.getSemestre());
            stmt.setInt(6, obj.getAulasSemanais());
           
            stmt.setTimestamp (7, java.sql.Timestamp.valueOf(LocalDateTime.now()));
            stmt.setTimestamp (8, java.sql.Timestamp.valueOf(LocalDateTime.now()));
            
            stmt.execute();
            
            System.out.println("Elemento inserido com sucesso.");
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro, elemento não adicionado ao banco. RuntimeException");
        } 
        
    }
    
    public OfertaDisciplinaCurso buscaEspecifico(long identificador) {
        
        String sql = "select * "
                   + "from oferta_disciplina_curso "
                   + "where id = ?";
        
        OfertaDisciplinaCurso obj = new OfertaDisciplinaCurso();
        
        try (Connection connection = new ConnectionFactory().getConnection(); 
             PreparedStatement ps = connection.prepareStatement(sql)         ){
            
            ps.setLong(1, identificador);

            try (ResultSet rs = ps.executeQuery()) {
                
                while(rs.next()) {

                  long indice = rs.getLong("id");
                  long curso = rs.getLong("curso");
                  long disciplina = rs.getLong("disciplina");
                  long professor = rs.getLong("professor");
                  int ano = rs.getInt("ano");
                  int semestre = rs.getInt("semestre");
                  int aulasSemanais = rs.getInt("aulas_semanais");
                  
                  Timestamp criacaoTimestamp = rs.getTimestamp("criacao");
                  LocalDateTime criacao = criacaoTimestamp.toLocalDateTime();
                  Timestamp modificacaoTimestamp = rs.getTimestamp("modificacao");
                  LocalDateTime modificacao= modificacaoTimestamp.toLocalDateTime();

                  obj.setId(indice);
                  obj.setCurso(cursoDao.buscaEspecifico(curso));
                  obj.setDisciplina(disciplinaDao.buscaEspecifico(disciplina));
                  obj.setProfessor(servidorDao.buscaEspecifico(professor));
                  obj.setAno(ano);
                  obj.setSemestre(semestre);
                  obj.setAulasSemanais(aulasSemanais);
                  
                  obj.setDtCriacao(criacao);
                  obj.setDtModificacao(modificacao);
                    
                }
            }
        } catch (SQLException e) {
             throw new RuntimeException("Erro. Requisicao não pode ser feita. RuntimeException");
        }
        return obj;
    }
    
    public List<OfertaDisciplinaCurso> lista() {

          String sql = "select * from oferta_disciplina_curso";


          ArrayList<OfertaDisciplinaCurso> arr = new ArrayList<>();
          OfertaDisciplinaCurso obj = new OfertaDisciplinaCurso();
          
          try (Connection connection = new ConnectionFactory().getConnection();
                  PreparedStatement stmt = connection.prepareStatement(sql);
                  ResultSet rs = stmt.executeQuery(sql)) {

              while (rs.next()) {
                   
                 long indice = rs.getLong("id");
                  long curso = rs.getLong("curso");
                  long disciplina = rs.getLong("disciplina");
                  long professor = rs.getLong("professor");
                  int ano = rs.getInt("ano");
                  int semestre = rs.getInt("semestre");
                  int aulasSemanais = rs.getInt("aulas_semanais");
                  
                  Timestamp criacaoTimestamp = rs.getTimestamp("criacao");
                  LocalDateTime criacao = criacaoTimestamp.toLocalDateTime();
                  Timestamp modificacaoTimestamp = rs.getTimestamp("modificacao");
                  LocalDateTime modificacao= modificacaoTimestamp.toLocalDateTime();

                  obj.setId(indice);
                  obj.setCurso(cursoDao.buscaEspecifico(curso));
                  obj.setDisciplina(disciplinaDao.buscaEspecifico(disciplina));
                  obj.setProfessor(servidorDao.buscaEspecifico(professor));
                  obj.setAno(ano);
                  obj.setSemestre(semestre);
                  obj.setAulasSemanais(aulasSemanais);
                  
                  obj.setDtCriacao(criacao);
                  obj.setDtModificacao(modificacao);
                  
                          
                  arr.add(obj);

              }
          } catch (SQLException e) {
               throw new RuntimeException("Erro, Arquivos não retornados. RuntimeException");
          }

          return arr;
      }
    
    public void remove(long id) {
       String sql = "delete from oferta_disciplina_curso where id = ?";

       try ( Connection connection = new ConnectionFactory().getConnection();  
             PreparedStatement stmt = connection.prepareStatement(sql)) {

           stmt.setLong(1, id);
           stmt.execute();
           
           System.out.println("Elemento removido com sucesso do banco de dados");
           
       } catch (SQLException e) {
           throw new RuntimeException("Erro, elemento não removido do banco. RuntimeException");
       }
    }

    public void altera(OfertaDisciplinaCurso obj){

        String sql = "update oferta_disciplina_curso "
                   + "set curso = ?, "
                   + "disciplina = ?, "
                   +"professor = ?, "
                   +"ano = ?, "
                   +"semestre = ?, "
                   +"aulas_semanais = ?, "
                   +"modificacao = ? "
                   + "where id = ?";
        
         try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            

            stmt.setLong(1, obj.getCurso().getId());
            stmt.setLong(2, obj.getDisciplina().getId());
            stmt.setLong(3, obj.getProfessor().getId());
            stmt.setInt(4, obj.getAno());
            stmt.setInt(5, obj.getSemestre());
            stmt.setInt(6, obj.getAulasSemanais());
              
            stmt.setTimestamp(7, java.sql.Timestamp.valueOf(LocalDateTime.now()));
            stmt.setLong(8, obj.getId());
            
            stmt.execute();
            
            System.out.println("Elemento alterado com sucesso.");
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro, elemento não foi alterado. RuntimeException");
        }
    }
    
     @Override
    public String toString() {
        
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        DateTimeFormatter fmtAno = DateTimeFormatter.ofPattern("yyy");
        StringBuilder txt = new StringBuilder();
        
        txt.append("\t\t\t === Oferta === \n\n");
        List<OfertaDisciplinaCurso> obj = this.lista();
        
            for(OfertaDisciplinaCurso oferta : obj){
               txt.append("\tCurso: " + oferta.getCurso().getNome()+"\t\t\t ID: " + oferta.getId() +"\n"); 
               txt.append("\tDisciplina: " + oferta.getDisciplina().getNome()+"\n"); 
               txt.append("\tProfessor: " + oferta.getProfessor().getNome()+"\n"); 
               txt.append("\tAno: "+ oferta.getAno()+"\n");
               txt.append("\tSemestre: "+ oferta.getSemestre()+"\n");
               txt.append("\tAulas Semanais: "+ oferta.getAulasSemanais()+"\n");
               txt.append("\tData de Criação: " + oferta.getDtCriacao().format(fmt) +"\n"); 
               txt.append("\tUltima Data de Moificação: " + oferta.getDtModificacao().format(fmt) +"\n\n\n"); 
    
            }
  
        return txt.toString();
    }
    
    
    public String toStringMin() {
        
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        DateTimeFormatter fmtAno = DateTimeFormatter.ofPattern("yyyy");
        StringBuilder txt = new StringBuilder();
        
        txt.append("\t\t\t === Oferta === \n\n");
        List<OfertaDisciplinaCurso> obj = this.lista();
        
            for(OfertaDisciplinaCurso oferta : obj){
               txt.append("\tDisciplina: "+ oferta.getDisciplina().getNome()+"\t\t\t ID: "+ oferta.getId()+"\n");
               txt.append("\tSemestre: "+oferta.getSemestre()+"\n");
            }
  
        return txt.toString();
    }
}
