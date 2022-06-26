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
import model.Campus;

/**
 *
 * @author Lindovaldo
 */
public class CampusDAO {
    
    public void adiciona(Campus obj){
        
         String sql = "insert into campus"
                    + " (nome,abreviacao,duracao_aulas,data_criacao_campus,cidade,bairro,endereco,cep,criacao,modificacao)"
                    + " values (?,?,?,?,?,?,?,?,?,?)";
         
        try (Connection connection = new ConnectionFactory().getConnection();
            
            PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getAbreviacao());
            stmt.setInt(3, obj.getDuracaoAula());
            stmt.setTimestamp(4, java.sql.Timestamp.valueOf(obj.getDtCriacao()));
            stmt.setString(5, obj.getCidade());
            stmt.setString(6, obj.getBairro());
            stmt.setString(7, obj.getEndereco());
            stmt.setString(8, obj.getCep());
            stmt.setTimestamp (9, java.sql.Timestamp.valueOf(LocalDateTime.now()));
            stmt.setTimestamp (10, java.sql.Timestamp.valueOf(LocalDateTime.now()));
            
            stmt.execute();
            
            System.out.println("Elemento inserido com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro, elemento não adicionado ao banco. RuntimeException");
        } 
        
    }
    
    public Campus buscaEspecifico(long identificador) {
        
        String sql = "select * "
                   + "from campus "
                   + "where id = ?";
        
        Campus campus = new Campus();
        
        try (Connection connection = new ConnectionFactory().getConnection(); 
             PreparedStatement ps = connection.prepareStatement(sql)         ){
            
            ps.setLong(1, identificador);
            
            
            
            try (ResultSet rs = ps.executeQuery()) {
                
                while(rs.next()) {

                  Long indice = rs.getLong("id");
                  String nome = rs.getString("nome");
                  String abreviacao = rs.getString("abreviacao");
                  int duracaoAulas= rs.getInt("duracao_aulas");
                  Date dataCriacaoDate = rs.getDate("data_criacao_campus");
                  LocalDate dtCriacao = dataCriacaoDate.toLocalDate();
                  String cidade = rs.getString("cidade");
                  String bairro = rs.getString("bairro");
                  String endereco = rs.getString("endereco");
                  String cep = rs.getString("cep");
                  Timestamp criacaoTimestamp = rs.getTimestamp("criacao");
                  LocalDateTime criacao = criacaoTimestamp.toLocalDateTime();
                  Timestamp modificacaoTimestamp = rs.getTimestamp("criacao");
                  LocalDateTime modificacao= modificacaoTimestamp.toLocalDateTime();

                  campus.setId(indice);
                  campus.setNome(nome);
                  campus.setAbreviacao(abreviacao);
                  campus.setDuracaoAula(duracaoAulas);
                  campus.setDtCriacaoCampus(dtCriacao);
                  campus.setCidade(cidade);
                  campus.setBairro(bairro);
                  campus.setEndereco(endereco);
                  campus.setCep(cep);
                  campus.setDtCriacao(criacao);
                  campus.setDtModificacao(modificacao);
                    
                }
            }
        } catch (SQLException e) {
             throw new RuntimeException(e);
        }
        return campus;
    }
    
    public List<Campus> lista() {

          String sql = "select * from campus";


          ArrayList<Campus> arr = new ArrayList<>();

          try (Connection connection = new ConnectionFactory().getConnection();
                  PreparedStatement stmt = connection.prepareStatement(sql);
                  ResultSet rs = stmt.executeQuery(sql)) {

              while (rs.next()) {
                  Long indice = rs.getLong("id");
                  String nome = rs.getString("nome");
                  String abreviacao = rs.getString("abreviacao");
                  int duracaoAulas= rs.getInt("duracao_aulas");
                  Date dataCriacaoDate = rs.getDate("data_criacao_campus");
                  LocalDate dtCriacao = dataCriacaoDate.toLocalDate();
                  String cidade = rs.getString("cidade");
                  String bairro = rs.getString("bairro");
                  String endereco = rs.getString("endereco");
                  String cep = rs.getString("cep");
                  Timestamp criacaoTimestamp = rs.getTimestamp("criacao");
                  LocalDateTime criacao = criacaoTimestamp.toLocalDateTime();
                  Timestamp modificacaoTimestamp = rs.getTimestamp("criacao");
                  LocalDateTime modificacao= modificacaoTimestamp.toLocalDateTime();

                  Campus campus = new Campus();
                  campus.setId(indice);
                  campus.setNome(nome);
                  campus.setAbreviacao(abreviacao);
                  campus.setDuracaoAula(duracaoAulas);
                  campus.setDtCriacaoCampus(dtCriacao);
                  campus.setCidade(cidade);
                  campus.setBairro(bairro);
                  campus.setEndereco(endereco);
                  campus.setCep(cep);
                  campus.setDtCriacao(criacao);
                  campus.setDtModificacao(modificacao);

                  arr.add(campus);

              }
          } catch (SQLException e) {
               throw new RuntimeException("Erro, Arquivos não retornados. RuntimeException");
          }

          return arr;
      }
    
    public void remove(long id) {
       String sql = "delete from campus where id = ?";

       try ( Connection connection = new ConnectionFactory().getConnection();  
             PreparedStatement stmt = connection.prepareStatement(sql)) {

           stmt.setLong(1, id);
           stmt.execute();

       } catch (SQLException e) {
           throw new RuntimeException("Erro, elemento não removido do banco. RuntimeException");
       }
    }

    public void altera(Campus obj){
        
        String sql = "update campus "
                   + "set nome = ?, "
                   + "abreviacao = ?,"
                   +"duracao_aulas = ?,"
                   +"data_criacao_campus = ?,"
                   +"cidade = ?,"
                   +"bairro = ?,"
                   +"endereco = ?,"
                   +"cep = ?,"
                   +"modificacao = ?"
                   + "where id = ?";
        
         try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getAbreviacao());
            stmt.setInt(3, obj.getDuracaoAula());;
            stmt.setTimestamp(4, java.sql.Timestamp.valueOf(obj.getDtCriacao()));
            stmt.setString(5, obj.getCidade());
            stmt.setString(6, obj.getBairro());
            stmt.setString(7, obj.getEndereco());
            stmt.setString(8, obj.getCep());
            stmt.setTimestamp(9, java.sql.Timestamp.valueOf(LocalDateTime.now()));
            stmt.setLong(10, obj.getId());
            
            
            stmt.execute();
            
            System.out.println("Elemento alterado com sucesso.");
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro, elemento não foi alterado. RuntimeException");
        }
    }
    
}
