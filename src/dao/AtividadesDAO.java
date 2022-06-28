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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import model.Atividades;


/**
 *
 * @author Lindovaldo
 */
public class AtividadesDAO {
      
    public void adiciona(Atividades obj){
        
         String sql = "insert into atividades"
                    + " (descricao,horas_semanais,servidor,data_inicio,data_termino,criacao,modificacao)"
                    + " values (?,?,?,?,?,?,?)";
         
        try (Connection connection = new ConnectionFactory().getConnection();
            
            PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            stmt.setString(1, obj.getDescricao());
            stmt.setDouble(2, obj.getHorasSemanais());
            stmt.setLong(3, obj.getServidor());
            stmt.setDate(4, java.sql.Date.valueOf(obj.getDtInicio()));
            stmt.setDate(5, java.sql.Date.valueOf(obj.getDtFim()));
           
            stmt.setTimestamp (6, java.sql.Timestamp.valueOf(LocalDateTime.now()));
            stmt.setTimestamp (7, java.sql.Timestamp.valueOf(LocalDateTime.now()));
            
            stmt.execute();
            
            System.out.println("Elemento inserido com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro, elemento não adicionado ao banco. RuntimeException");
        } 
        
    }
    
    public Atividades buscaEspecifico(long identificador) {
        
        String sql = "select * "
                   + "from atividades "
                   + "where id = ?";
        
        Atividades obj = new Atividades();
        
        try (Connection connection = new ConnectionFactory().getConnection(); 
             PreparedStatement ps = connection.prepareStatement(sql)         ){
            
            ps.setLong(1, identificador);

            try (ResultSet rs = ps.executeQuery()) {
                
                while(rs.next()) {
                    
                            
                  Long indice = rs.getLong("id");
                  String descricao = rs.getString("descricao");
                  double horasSemanais = rs.getDouble("horas_semanais");
                  long servidor = rs.getLong("servidor");
                  Date dataInicio = rs.getDate("data_inicio");
                  LocalDate dtInicio = dataInicio.toLocalDate();
                  Date dataTermino = rs.getDate("data_termino");
                  LocalDate dtTermino = dataTermino.toLocalDate();
                  Timestamp criacaoTimestamp = rs.getTimestamp("criacao");
                  LocalDateTime criacao = criacaoTimestamp.toLocalDateTime();
                  Timestamp modificacaoTimestamp = rs.getTimestamp("modificacao");
                  LocalDateTime modificacao= modificacaoTimestamp.toLocalDateTime();

                  obj.setId(indice);
                  obj.setDescricao(descricao);
                  obj.setHorasSemanais(horasSemanais);
                  obj.setServidor(servidor);
                  obj.setDtInicio(dtInicio);
                  obj.setDtFim(dtTermino);
                  
                  obj.setDtCriacao(criacao);
                  obj.setDtModificacao(modificacao);
                    
                }
            }
        } catch (SQLException e) {
             throw new RuntimeException("Erro. Requisicao não pode ser feita. RuntimeException");
        }
        return obj;
    }
    
    public List<Atividades> lista() {

          String sql = "select * from atividades";


          ArrayList<Atividades> arr = new ArrayList<>();

          try (Connection connection = new ConnectionFactory().getConnection();
                  PreparedStatement stmt = connection.prepareStatement(sql);
                  ResultSet rs = stmt.executeQuery(sql)) {

              while (rs.next()) {
                   
                  Long indice = rs.getLong("id");
                  String descricao = rs.getString("descricao");
                  double horasSemanais = rs.getDouble("horas_semanais");
                  long servidor = rs.getLong("servidor");
                  Date dataInicio = rs.getDate("data_inicio");
                  LocalDate dtInicio = dataInicio.toLocalDate();
                  Date dataTermino = rs.getDate("data_termino");
                  LocalDate dtTermino = dataTermino.toLocalDate();
                  Timestamp criacaoTimestamp = rs.getTimestamp("criacao");
                  LocalDateTime criacao = criacaoTimestamp.toLocalDateTime();
                  Timestamp modificacaoTimestamp = rs.getTimestamp("modificacao");
                  LocalDateTime modificacao= modificacaoTimestamp.toLocalDateTime();
                  
                  Atividades obj = new Atividades();
                  
                  obj.setId(indice);
                  obj.setDescricao(descricao);
                  obj.setHorasSemanais(horasSemanais);
                  obj.setServidor(servidor);
                  obj.setDtInicio(dtInicio);
                  obj.setDtFim(dtTermino);
                  
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
       String sql = "delete from atividades where id = ?";

       try ( Connection connection = new ConnectionFactory().getConnection();  
             PreparedStatement stmt = connection.prepareStatement(sql)) {

           stmt.setLong(1, id);
           stmt.execute();

       } catch (SQLException e) {
           throw new RuntimeException("Erro, elemento não removido do banco. RuntimeException");
       }
    }

    public void altera(Atividades obj){
        
        String sql = "update atividades "
                   + "set descricao = ?, "
                   + "horas_semanais = ?, "
                   +"servidor = ?, "
                   +"data_inicio = ?, "
                   +"data_termino = ?, "
                   +"modificacao = ? "
                   + "where id = ?";
        
         try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            

            stmt.setString(1, obj.getDescricao());
            stmt.setDouble(2, obj.getHorasSemanais());
            stmt.setLong(3, obj.getServidor());;
            stmt.setDate(4, java.sql.Date.valueOf(obj.getDtInicio()));
            stmt.setDate(5, java.sql.Date.valueOf(obj.getDtFim()));
            stmt.setTimestamp(6, java.sql.Timestamp.valueOf(LocalDateTime.now()));
            stmt.setLong(7, obj.getId());
            
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
        
        txt.append("\t\t\t === Atividades === \n\n");
        List<Atividades> obj = this.lista();
        
            for(Atividades atividades : obj){
               txt.append("\tDescricao: " + atividades.getDescricao()+"\t\t\t ID: " + atividades.getId() +"\n"); 
               txt.append("\tHoras Semanais: " + atividades.getHorasSemanais()+"\n"); 
               txt.append("\tServidor: " + atividades.getServidor()+"\n"); 
               txt.append("\tAno Inicio: " + atividades.getDtInicio()+"\n"); 
               txt.append("\tAno Termino: " + atividades.getDtFim().format(fmtAno)+"\n"); 
               txt.append("\tData de Criação: " + atividades.getDtCriacao().format(fmt) +"\n"); 
               txt.append("\tUltima Data de Moificação: " + atividades.getDtModificacao().format(fmt) +"\n\n\n"); 
    
            }
  
        return txt.toString();
    }
    
    
    public String toStringMin() {
        
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        DateTimeFormatter fmtAno = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        StringBuilder txt = new StringBuilder();
        
        txt.append("\t\t\t === Atividades === \n\n");
        List<Atividades> obj = this.lista();
        
            for(Atividades atividades : obj){
               txt.append("\n\tDescricao: " + atividades.getDescricao()+"\t\t\t ID: " + atividades.getId() +"\n"); 
               txt.append("\tServidor: " + atividades.getServidor()+"\n"); 
    
            }
  
        return txt.toString();
    }
}
