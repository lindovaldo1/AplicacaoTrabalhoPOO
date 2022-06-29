/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import extra.Login;
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
import model.Campus;
import model.Servidor;

/**
 *
 * @author Lindovaldo
 */
public class ServidorDAO {
    
    CampusDAO campusdao;
    
    public ServidorDAO(CampusDAO campus){
        this.campusdao = campus;
    }
    
    public void adiciona(Servidor obj){
        
         String sql = "insert into servidores"
                    + " (nome,email,campus,cargo,login,senha,tipo_usuario,criacao,modificacao)"
                    + " values (?,?,?,?,?,?,?,?,?)";
         
        try (Connection connection = new ConnectionFactory().getConnection();
            
            PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getEmail());
            long longCampus = obj.getCampus().getId();
            stmt.setInt(3, (int)(long)longCampus);
            stmt.setInt(4, obj.getCargo());
            stmt.setString(5, obj.getLogin());
            stmt.setString(6, obj.getSenha());
            stmt.setInt(7, obj.getTipoUsuario());
           
            stmt.setTimestamp (8, java.sql.Timestamp.valueOf(LocalDateTime.now()));
            stmt.setTimestamp (9, java.sql.Timestamp.valueOf(LocalDateTime.now()));
            
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
        
        Servidor obj = new Servidor();
        
        try (Connection connection = new ConnectionFactory().getConnection(); 
             PreparedStatement ps = connection.prepareStatement(sql)         ){
            
            ps.setLong(1, identificador);

            try (ResultSet rs = ps.executeQuery()) {
                
                while(rs.next()) {

                  Long indice = rs.getLong("id");
                  String nome = rs.getString("nome");
                  String email = rs.getString("email");
                  long longCampus = rs.getLong("campus");
                  int cargo = rs.getInt("cargo");
                  String login = rs.getString("login");
                  String senha = rs.getString("senha");
                  int tipoUsuario = rs.getInt("tipo_usuario");
                  Timestamp criacaoTimestamp = rs.getTimestamp("criacao");
                  LocalDateTime criacao = criacaoTimestamp.toLocalDateTime();
                  Timestamp modificacaoTimestamp = rs.getTimestamp("modificacao");
                  LocalDateTime modificacao= modificacaoTimestamp.toLocalDateTime();

                  obj.setId(indice);
                  obj.setNome(nome);
                  obj.setEmail(email);
                  obj.setCampus(campusdao.buscaEspecifico(longCampus));
                  obj.setCargo(cargo);
                  obj.setLogin(login);
                  obj.setSenha(senha);
                  obj.setTipoUsuario(tipoUsuario);
                  obj.setDtCriacao(criacao);
                  obj.setDtModificacao(modificacao);
                    
                }
            }
        } catch (SQLException e) {
             throw new RuntimeException("Erro. Requisicao não pode ser feita. RuntimeException");
        }
        return obj;
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
                  long longCampus = rs.getLong("campus");
                  int cargo = rs.getInt("cargo");
                  String login = rs.getString("login");
                  String senha = rs.getString("senha");
                  int tipoUsuario = rs.getInt("tipo_usuario");
                  Timestamp criacaoTimestamp = rs.getTimestamp("criacao");
                  LocalDateTime criacao = criacaoTimestamp.toLocalDateTime();
                  Timestamp modificacaoTimestamp = rs.getTimestamp("modificacao");
                  LocalDateTime modificacao= modificacaoTimestamp.toLocalDateTime();
                  
                  Servidor obj = new Servidor();
                  Campus campus = campusdao.buscaEspecifico(longCampus);
                  
                  obj.setId(indice);
                  obj.setNome(nome);
                  obj.setEmail(email);
                  obj.setCampus(campus);
                  obj.setCargo(cargo);
                  obj.setLogin(login);
                  obj.setSenha(senha);
                  obj.setTipoUsuario(tipoUsuario);
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
                   +"tipo_usuario = ?,"
                   +"modificacao = ? "
                   + "where id = ? ";
        
         try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
                  
                  
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getEmail());
            long longCampus = obj.getCampus().getId();
            stmt.setLong(3, longCampus);;
            stmt.setInt(4, obj.getCargo());
            stmt.setString(5, obj.getLogin());
            stmt.setString(6, obj.getSenha());
            stmt.setInt(7, obj.getTipoUsuario());
            stmt.setTimestamp(8, java.sql.Timestamp.valueOf(LocalDateTime.now()));
            stmt.setLong(9, obj.getId());
            
            
            stmt.execute();
            
            System.out.println("Elemento alterado com sucesso.");
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro, elemento não foi alterado. RuntimeException");
        }
    }
    
    public Servidor buscaLogin(Login login){
        
        List<Servidor> arr = this.lista();
        
        for(Servidor servidor : arr){
            if(servidor.getLogin().equals(login.getLogin()) && servidor.getSenha().equals(login.getSenha())){
                return servidor;
            }
        }
        
        return null;
    }
    
    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        StringBuilder txt = new StringBuilder();
        
        List<Servidor> obj = this.lista();
       
        for (Servidor arr : obj) {
            txt.append("\tNome: "+arr.getNome()+"\t\t\t ID: "+ arr.getId() + "\n");
            txt.append("\tEmail: "+arr.getEmail()+"\n");
            txt.append("\tCampus: "+arr.getCampus().toStringMin()+"\n");
            txt.append("\tCargo: "+arr.getCargo()+"\n");
            txt.append("\tLogin: "+arr.getLogin()+"\n");
            txt.append("\tSenha: "+arr.getSenha()+"\n");
            txt.append("\tTipo Usuario: "+arr.getTipoUsuario()+"\n");
            txt.append("\tData Criação: "+arr.getDtCriacao().format(fmt)+"\n");
            txt.append("\tData Modificação: "+arr.getDtModificacao().format(fmt)+"\n\n");
                
         }
        
       return txt.toString();
    }
    
    public String toStringMin(){
        
        StringBuilder txt = new StringBuilder();
        
        List<Servidor> obj = this.lista();
        
        txt.append("\t\t\t === Servidores === \n\n");
        
        for (Servidor servidor : obj) {
            txt.append("\tNome Servidor: " + servidor.getNome() +"\t\t\t ID: " + servidor.getId() +"\n"); 
        }
        
        return txt.toString();
    }

    
}

