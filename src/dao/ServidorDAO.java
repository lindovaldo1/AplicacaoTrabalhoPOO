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
import java.util.ArrayList;
import java.util.List;
import model.Campus;
import model.Servidor;

/**
 *
 * @author Lindovaldo
 */
public class ServidorDAO {

    CampusDAO campusDao;

    public ServidorDAO(CampusDAO campusDAO) {
        this.campusDao = campusDao;
    }
    
    public void setCampusDao(CampusDAO campusDao) {
        this.campusDao = campusDao;
    }
    
    
    
    public void adiciona(Servidor obj){
        
         String sql = "insert into servidores"
                    + " (nome,email,campus,cargo,login,senha,criacao,modificacao)"
                    + " values (?,?,?,?,?,?,?,?)";
         
        try (Connection connection = new ConnectionFactory().getConnection();
            
            PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getEmail());
            stmt.setInt(3, (int)(long)obj.getCampus());
            stmt.setInt(4, obj.getCargo());
            stmt.setString(5, obj.getLogin());
            stmt.setString(6, obj.getSenha());
           
            stmt.setTimestamp (7, java.sql.Timestamp.valueOf(LocalDateTime.now()));
            stmt.setTimestamp (8, java.sql.Timestamp.valueOf(LocalDateTime.now()));
            
            stmt.execute();
            
            System.out.println("Elemento inserido com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro, elemento não adicionado ao banco. RuntimeException");
        } 
        
    }
    
    public Servidor buscaEspecifico(long identificador) {
        
        String sql = "select * "
                   + "from servidores "
                   + "where id = ?";
        
        Servidor servidor = new Servidor();
        
        try (Connection connection = new ConnectionFactory().getConnection(); 
             PreparedStatement ps = connection.prepareStatement(sql)         ){
            
            ps.setLong(1, identificador);

            try (ResultSet rs = ps.executeQuery()) {
                
                while(rs.next()) {

                  Long indice = rs.getLong("id");
                  String nome = rs.getString("nome");
                  String email = rs.getString("email");
                  Long campus = rs.getLong("campus");
                  int cargo = rs.getInt("cargo");
                  String login = rs.getString("login");
                  String senha = rs.getString("senha");
                  Timestamp criacaoTimestamp = rs.getTimestamp("criacao");
                  LocalDateTime criacao = criacaoTimestamp.toLocalDateTime();
                  Timestamp modificacaoTimestamp = rs.getTimestamp("criacao");
                  LocalDateTime modificacao= modificacaoTimestamp.toLocalDateTime();

                  servidor.setId(indice);
                  servidor.setNome(nome);
                  servidor.setEmail(email);
                  servidor.setCampus(campus);
                  servidor.setCargo(cargo);
                  servidor.setLogin(login);
                  servidor.setSenha(senha);
                  servidor.setDtCriacao(criacao);
                  servidor.setDtModificacao(modificacao);
                    
                }
            }
        } catch (SQLException e) {
             throw new RuntimeException(e);
        }
        return servidor;
    }
    
    public List<Servidor> lista() {

          String sql = "select * from servidores";


          ArrayList<Servidor> arr = new ArrayList<>();

          try (Connection connection = new ConnectionFactory().getConnection();
                  PreparedStatement stmt = connection.prepareStatement(sql);
                  ResultSet rs = stmt.executeQuery(sql)) {

              while (rs.next()) {
                   
                  Long indice = rs.getLong("id");
                  String nome = rs.getString("nome");
                  String email = rs.getString("email");
                  Long campus = rs.getLong("campus");
                  int cargo = rs.getInt("cargo");
                  String login = rs.getString("login");
                  String senha = rs.getString("senha");
                  Timestamp criacaoTimestamp = rs.getTimestamp("criacao");
                  LocalDateTime criacao = criacaoTimestamp.toLocalDateTime();
                  Timestamp modificacaoTimestamp = rs.getTimestamp("criacao");
                  LocalDateTime modificacao= modificacaoTimestamp.toLocalDateTime();
                  
                  Servidor servidor = new Servidor();

                  servidor.setId(indice);
                  servidor.setNome(nome);
                  servidor.setEmail(email);
                  servidor.setCampus(campus);
                  servidor.setCargo(cargo);
                  servidor.setLogin(login);
                  servidor.setSenha(senha);
                  servidor.setDtCriacao(criacao);
                  servidor.setDtModificacao(modificacao);

                  arr.add(servidor);

              }
          } catch (SQLException e) {
               throw new RuntimeException("Erro, Arquivos não retornados. RuntimeException");
          }

          return arr;
      }
    
    public void remove(long id) {
       String sql = "delete from servidores where id = ?";

       try ( Connection connection = new ConnectionFactory().getConnection();  
             PreparedStatement stmt = connection.prepareStatement(sql)) {

           stmt.setLong(1, id);
           stmt.execute();

       } catch (SQLException e) {
           throw new RuntimeException("Erro, elemento não removido do banco. RuntimeException");
       }
    }

    public void altera(Servidor obj){
        
        String sql = "update servidores "
                   +"set nome = ?, "
                   +"email = ?, "
                   +"campus = ?, "
                   +"cargo = ?, "
                   +"login = ?, "
                   +"senha = ?, "
                   +"modificacao = ? "
                   + "where id = ? ";
        
         try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
                  
                  
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getEmail());
            stmt.setLong(3, obj.getCampus());;
            stmt.setInt(4, obj.getCargo());
            stmt.setString(5, obj.getLogin());
            stmt.setString(6, obj.getSenha());
            stmt.setTimestamp(7, java.sql.Timestamp.valueOf(LocalDateTime.now()));
            stmt.setLong(8, obj.getId());
            
            
            stmt.execute();
            
            System.out.println("Elemento alterado com sucesso.");
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro, elemento não foi alterado. RuntimeException");
        }
    }
}
