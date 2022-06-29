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
import model.Disciplina;
/**
 *
 * @author Lindovaldo
 */
public class DisciplinaDAO {

    CursoDAO cursoDao;
        
    public DisciplinaDAO(CursoDAO curso) {
        this.cursoDao = curso;
    }
    
    
    
    public void adiciona(Disciplina obj){
        
         String sql = "insert into disciplinas"
                    + " (nome,carga_horaria,periodicidade,curso,criacao,modificacao)"
                    + " values (?,?,?,?,?,?)";
         
        try (Connection connection = new ConnectionFactory().getConnection();
            
            PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            stmt.setString(1, obj.getNome());
            stmt.setDouble(2, obj.getCargaHoraria());
            stmt.setInt(3, obj.getPeriodicidade());
            stmt.setLong(4, obj.getCurso().getId());
            stmt.setTimestamp (5, java.sql.Timestamp.valueOf(LocalDateTime.now()));
            stmt.setTimestamp (6, java.sql.Timestamp.valueOf(LocalDateTime.now()));
            
            stmt.execute();
            
            System.out.println("Elemento inserido com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro, elemento não adicionado ao banco. RuntimeException");
        } 
        
    }
    
    public Disciplina buscaEspecifico(long identificador) {
        
        String sql = "select * "
                   + "from disciplinas "
                   + "where id = ?";
        
        Disciplina obj = new Disciplina();
        
        try (Connection connection = new ConnectionFactory().getConnection(); 
             PreparedStatement ps = connection.prepareStatement(sql)         ){
            
            ps.setLong(1, identificador);

            try (ResultSet rs = ps.executeQuery()) {
                
                while(rs.next()) {

                  Long indice = rs.getLong("id");
                  String nome = rs.getString("nome");
                  double cargaHoraria = rs.getDouble("carga_horaria");
                  int periodicidade = rs.getInt("periodicidade");
                  Long curso = rs.getLong("curso");
                  
                  Timestamp criacaoTimestamp = rs.getTimestamp("criacao");
                  LocalDateTime criacao = criacaoTimestamp.toLocalDateTime();
                  Timestamp modificacaoTimestamp = rs.getTimestamp("modificacao");
                  LocalDateTime modificacao= modificacaoTimestamp.toLocalDateTime();
                  
                  obj.setId(indice);
                  obj.setNome(nome);
                  obj.setCargaHoraria(cargaHoraria);
                  obj.setPeriodicidade(periodicidade);
                  obj.setCurso(cursoDao.buscaEspecifico(curso));
                  
                  obj.setDtCriacao(criacao);
                  obj.setDtModificacao(modificacao);
                    
                }
            }
        } catch (SQLException e) {
             throw new RuntimeException(e);
        }
        return obj;
    }
    
    public List<Disciplina> lista() {

          String sql = "select * from disciplinas";


          ArrayList<Disciplina> arr = new ArrayList<>();

          try (Connection connection = new ConnectionFactory().getConnection();
                  PreparedStatement stmt = connection.prepareStatement(sql);
                  ResultSet rs = stmt.executeQuery(sql)) {

              while (rs.next()) {
                   
                  Long indice = rs.getLong("id");
                  String nome = rs.getString("nome");
                  double cargaHoraria = rs.getDouble("carga_horaria");
                  int periodicidade = rs.getInt("periodicidade");
                  Long curso = rs.getLong("curso");
                  
                  Timestamp criacaoTimestamp = rs.getTimestamp("criacao");
                  LocalDateTime criacao = criacaoTimestamp.toLocalDateTime();
                  Timestamp modificacaoTimestamp = rs.getTimestamp("modificacao");
                  LocalDateTime modificacao= modificacaoTimestamp.toLocalDateTime();
                  
                  Disciplina obj = new Disciplina();
                  
                  obj.setId(indice);
                  obj.setNome(nome);
                  obj.setCargaHoraria(cargaHoraria);
                  obj.setPeriodicidade(periodicidade);
                  obj.setCurso(cursoDao.buscaEspecifico(curso));
                  
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
       String sql = "delete from disciplinas where id = ?";

       try ( Connection connection = new ConnectionFactory().getConnection();  
             PreparedStatement stmt = connection.prepareStatement(sql)) {

           stmt.setLong(1, id);
           stmt.execute();

       } catch (SQLException e) {
           throw new RuntimeException("Erro, elemento não removido do banco. RuntimeException");
       }
    }

    public void altera(Disciplina obj){
        
        String sql = "update disciplinas "
                   + "set nome = ?, "
                   + "carga_horaria = ?,"
                   + "periodicidade = ?,"
                   + "curso = ?,"
                   + "modificacao = ?"
                   + "where id = ?";
        
         try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            stmt.setString(1, obj.getNome());
            stmt.setDouble(2, obj.getCargaHoraria());
            stmt.setInt(3, obj.getPeriodicidade());
            stmt.setTimestamp(4, java.sql.Timestamp.valueOf(obj.getDtCriacao()));
            stmt.setTimestamp(5, java.sql.Timestamp.valueOf(LocalDateTime.now()));
            stmt.setLong(6, obj.getId());
            
            
            stmt.execute();
            
            System.out.println("Elemento alterado com sucesso.");
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro, elemento não foi alterado. RuntimeException");
        }
    }
    
     @Override
    public String toString() {
        
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        DateTimeFormatter fmtAno = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        StringBuilder txt = new StringBuilder();
        
        txt.append("\t\t\t === Disciplinas === \n\n");
        List<Disciplina> obj = this.lista();
        
            for(Disciplina disciplina : obj){
               txt.append("\n\tNome Campus: " + disciplina.getNome() +"\t\t\t ID: " + disciplina.getId() +"\n"); 
               txt.append("\tCarga Horaria: " + disciplina.getCargaHoraria()+"\n"); 
               if(disciplina.getPeriodicidade()== 1){
                   txt.append("\tPeriodicidade: Semestral" +"\n"); 
               }else if(disciplina.getPeriodicidade()== 2){
                   txt.append("\tPeriodicidade: Anual" +"\n");
               }
               txt.append("\tCurso: " + disciplina.getCurso().getNome()+"\n"); 
               txt.append("\tData de Criacao: " + disciplina.getDtCriacao().format(fmtAno)+"\n"); 
               txt.append("\tUltima Data de Moificação: " + disciplina.getDtModificacao().format(fmt) +"\n\n\n"); 
               
                }
  
        return txt.toString();
    }
    
    public String toStringMin() {
        
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        DateTimeFormatter fmtAno = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        StringBuilder txt = new StringBuilder();

        txt.append("\t\t\t === Disciplinas=== \n\n");
        List<Disciplina> obj = this.lista();

        for(Disciplina disciplina : obj){
           txt.append("\n\tNome Disciplina: " + disciplina.getNome() +"\t\t\t ID: " + disciplina.getId() +"\n"); 
           txt.append("\tCampus: " + disciplina.getCurso().getNome()+"\n"); 

        }
  
        return txt.toString();
    }
    
}
