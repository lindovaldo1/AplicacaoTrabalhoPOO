/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import model.Curso;
/**
 *
 * @author Lindovaldo
 */
public class CursoDAO {
    
     
    
    public void adiciona(Curso obj){
        
         String sql = "insert into cursos"
                    + " (nome,estado,campus,ano_inicio,ano_termino,criacao,modificacao)"
                    + " values (?,?,?,?,?,?,?)";
         
        try (Connection connection = new ConnectionFactory().getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            stmt.setString(1, obj.getNome());
            stmt.setInt(2, (obj.getEstado()));
            stmt.setInt(3, (int)(long)obj.getCampus());
            stmt.setDate(4, java.sql.Date.valueOf(obj.getAnoInicio()));
            stmt.setDate(5, java.sql.Date.valueOf(obj.getAnoTermino()));
            stmt.setTimestamp (6, java.sql.Timestamp.valueOf(LocalDateTime.now()));
            stmt.setTimestamp (7, java.sql.Timestamp.valueOf(LocalDateTime.now()));
            
            stmt.execute();
            
            System.out.println("Elemento inserido com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro, elemento não adicionado ao banco. RuntimeException");
        } 
        
    }
    
    public Curso buscaEspecifico(long identificador) {
        
        String sql = "select * "
                   + "from cursos "
                   + "where id = ?";
        
        Curso curso = new Curso();
        
        try (Connection connection = new ConnectionFactory().getConnection(); 
             PreparedStatement ps = connection.prepareStatement(sql)         ){
            
            ps.setLong(1, identificador);

            try (ResultSet rs = ps.executeQuery()) {
                
                while(rs.next()) {

                  Long indice = rs.getLong("id");
                  String nome = rs.getString("nome");
                  int estado = rs.getInt("estado");
                  long campus = rs.getLong("campus");
                  Date anoInicioDate = rs.getDate("ano_inicio");
                  LocalDate anoInicio = anoInicioDate.toLocalDate();
                  Date anoTerminoDate = rs.getDate("ano_termino");
                  LocalDate anoTermino = anoTerminoDate.toLocalDate();
                  Timestamp criacaoTimestamp = rs.getTimestamp("criacao");
                  LocalDateTime criacao = criacaoTimestamp.toLocalDateTime();
                  Timestamp modificacaoTimestamp = rs.getTimestamp("criacao");
                  LocalDateTime modificacao= modificacaoTimestamp.toLocalDateTime();

                  curso.setId(indice);
                  curso.setNome(nome);
                  curso.setEstado(estado);
                  curso.setCampus(campus);
                  curso.setAnoInicio(anoInicio);
                  curso.setAnoTermino(anoTermino);
                  curso.setDtCriacao(criacao);
                  curso.setDtModificacao(modificacao);
                    
                }
            }
        } catch (SQLException e) {
             throw new RuntimeException(e);
        }
        return curso;
    }
    
    public List<Curso> lista() {

          String sql = "select * from cursos";


          ArrayList<Curso> arr = new ArrayList<>();

          try (Connection connection = new ConnectionFactory().getConnection();
                  PreparedStatement stmt = connection.prepareStatement(sql);
                  ResultSet rs = stmt.executeQuery(sql)) {

              while (rs.next()) {
                   
                  Long indice = rs.getLong("id");
                  String nome = rs.getString("nome");
                  int estado = rs.getInt("estado");
                  long campus = rs.getLong("campus");
                  Date anoInicioDate = rs.getDate("ano_inicio");
                  LocalDate anoInicio = anoInicioDate.toLocalDate();
                  Date anoTerminoDate = rs.getDate("ano_termino");
                  LocalDate anoTermino = anoTerminoDate.toLocalDate();
                  Timestamp criacaoTimestamp = rs.getTimestamp("criacao");
                  LocalDateTime criacao = criacaoTimestamp.toLocalDateTime();
                  Timestamp modificacaoTimestamp = rs.getTimestamp("criacao");
                  LocalDateTime modificacao= modificacaoTimestamp.toLocalDateTime();
                  
                  Curso curso = new Curso();
                  
                  curso.setId(indice);
                  curso.setNome(nome);
                  curso.setEstado(estado);
                  curso.setCampus(campus);
                  curso.setAnoInicio(anoInicio);
                  curso.setAnoTermino(anoTermino);
                  curso.setDtCriacao(criacao);
                  curso.setDtModificacao(modificacao);

                  arr.add(curso);

              }
          } catch (SQLException e) {
               throw new RuntimeException("Erro, Arquivos não retornados. RuntimeException");
          }

          return arr;
      }
    
    public void remove(long id) {
       String sql = "delete from cursos where id = ?";

       try ( Connection connection = new ConnectionFactory().getConnection();  
             PreparedStatement stmt = connection.prepareStatement(sql)) {

           stmt.setLong(1, id);
           stmt.execute();

       } catch (SQLException e) {
           throw new RuntimeException("Erro, elemento não removido do banco. RuntimeException");
       }
    }

    public void altera(Curso obj){
        
        String sql = "update cursos "
                   +"set nome = ?, "
                   +"estado = ?, "
                   +"campus = ?,"
                   +"ano_inicio = ?, "
                   +"ano_termino = ?, "
                   +"modificacao = ? "
                   +"where id = ? ";
        
         try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
                  
                  
            stmt.setString(1, obj.getNome());
            stmt.setInt(2, obj.getEstado());
            stmt.setInt(3, (int)(long)obj.getCampus());
            stmt.setDate(4, java.sql.Date.valueOf(obj.getAnoInicio()));;
            stmt.setDate(5, java.sql.Date.valueOf(obj.getAnoTermino()));
            stmt.setTimestamp(6, java.sql.Timestamp.valueOf(LocalDateTime.now()));
            stmt.setLong(7, obj.getId());
            
            
            stmt.execute();
            
            System.out.println("Elemento alterado com sucesso.");
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro, elemento não foi alterado. RuntimeException");
        }
    }
    
}
