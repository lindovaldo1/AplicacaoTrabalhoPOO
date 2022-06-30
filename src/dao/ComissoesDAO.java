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
import model.Comissoes;

/**
 *
 * @author Lindovaldo
 */
public class ComissoesDAO {
    
    public void adiciona(Comissoes obj){
        
         String sql = "insert into comissoes"
                    + " (comissao,horas_semanais,data_inicio,data_termino,estado,criacao,modificacao)"
                    + " values (?,?,?,?,?,?,?)";
         
        try (Connection connection = new ConnectionFactory().getConnection();
            
            PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            stmt.setString(1, obj.getComissao());
            stmt.setDouble(2, obj.gethSemanais());
            stmt.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
            stmt.setDate(4, java.sql.Date.valueOf(obj.getDtFim()));
            stmt.setInt(5, obj.getEstado());
            
            stmt.setTimestamp (6, java.sql.Timestamp.valueOf(LocalDateTime.now()));
            stmt.setTimestamp (7, java.sql.Timestamp.valueOf(LocalDateTime.now()));
            
            stmt.execute();
            
            System.out.println("Elemento inserido com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro, elemento não adicionado ao banco. RuntimeException");
        } 
        
    }
    
    public Comissoes buscaEspecifico(long identificador) {
        
        String sql = "select * "
                   + "from comissoes "
                   + "where id = ?";
        
        Comissoes obj = new Comissoes();
        
        try (Connection connection = new ConnectionFactory().getConnection(); 
             PreparedStatement ps = connection.prepareStatement(sql)         ){
            
            ps.setLong(1, identificador);

            try (ResultSet rs = ps.executeQuery()) {
                
                while(rs.next()) {
                    
                  Long indice = rs.getLong("id");
                  String comissao = rs.getString("comissao");
                  double horasSemanais = rs.getDouble("horas_semanais");
                  Date dataInicio = rs.getDate("data_inicio");
                  LocalDate dtInicio = dataInicio.toLocalDate();
                  Date dataTermino = rs.getDate("data_termino");
                  LocalDate dtTermino = dataTermino.toLocalDate();
                  int estado = rs.getInt("estado");
                  
                  Timestamp criacaoTimestamp = rs.getTimestamp("criacao");
                  LocalDateTime criacao = criacaoTimestamp.toLocalDateTime();
                  Timestamp modificacaoTimestamp = rs.getTimestamp("modificacao");
                  LocalDateTime modificacao= modificacaoTimestamp.toLocalDateTime();

                  obj.setId(indice);
                  obj.setComissao(comissao);
                  obj.sethSemanais(horasSemanais);
                  obj.setDtInicio(dtInicio);
                  obj.setDtFim(dtTermino);
                  obj.setEstado(estado);
                  
                  obj.setDtCriacao(criacao);
                  obj.setDtModificacao(modificacao);
                    
                }
            }
        } catch (SQLException e) {
             throw new RuntimeException("Erro. Requisicao não pode ser feita. RuntimeException");
        }
        return obj;
    }
    
    public List<Comissoes> lista() {

          String sql = "select * from comissoes";


          ArrayList<Comissoes> arr = new ArrayList<>();

          try (Connection connection = new ConnectionFactory().getConnection();
                  PreparedStatement stmt = connection.prepareStatement(sql);
                  ResultSet rs = stmt.executeQuery(sql)) {

              while (rs.next()) {
                   
                 Long indice = rs.getLong("id");
                  String comissao = rs.getString("comissao");
                  double horasSemanais = rs.getDouble("horas_semanais");
                  Date dataInicio = rs.getDate("data_inicio");
                  LocalDate dtInicio = dataInicio.toLocalDate();
                  Date dataTermino = rs.getDate("data_termino");
                  LocalDate dtTermino = dataTermino.toLocalDate();
                  int estado = rs.getInt("estado");
                  
                  Timestamp criacaoTimestamp = rs.getTimestamp("criacao");
                  LocalDateTime criacao = criacaoTimestamp.toLocalDateTime();
                  Timestamp modificacaoTimestamp = rs.getTimestamp("modificacao");
                  LocalDateTime modificacao= modificacaoTimestamp.toLocalDateTime();
                  
                  Comissoes obj = new Comissoes();
                  
                  obj.setId(indice);
                  obj.setComissao(comissao);
                  obj.sethSemanais(horasSemanais);
                  obj.setDtInicio(dtInicio);
                  obj.setDtFim(dtTermino);
                  obj.setEstado(estado);
                  
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
       String sql = "delete from comissoes where id = ?";

       try ( Connection connection = new ConnectionFactory().getConnection();  
             PreparedStatement stmt = connection.prepareStatement(sql)) {

           stmt.setLong(1, id);
           stmt.execute();
           
           System.out.println("Elemento removido com sucesso do banco de dados");
           
       } catch (SQLException e) {
           throw new RuntimeException("Erro, elemento não removido do banco. RuntimeException");
       }
    }

    public void altera(Comissoes obj){

        String sql = "update comissoes "
                   + "set comissao = ?, "
                   + "horas_semanais = ?, "
                   +"data_inicio = ?, "
                   +"data_termino = ?, "
                   +"estado = ?, "
                   +"modificacao = ? "
                   + "where id = ?";
        
         try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            

            stmt.setString(1, obj.getComissao());
            stmt.setDouble(2, obj.gethSemanais());
            stmt.setDate(3, java.sql.Date.valueOf(obj.getDtInicio()));
            stmt.setDate(4, java.sql.Date.valueOf(obj.getDtFim()));
            stmt.setInt(5, obj.getEstado());
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
        
        txt.append("\t\t\t === Comissoes === \n\n");
        List<Comissoes> obj = this.lista();
        
            for(Comissoes comissoes : obj){
               txt.append("\n\tNome Comissao: " + comissoes.getComissao()+"\t\t\t ID: " + comissoes.getId() +"\n"); 
               txt.append("\tHoras Semanais: " + comissoes.gethSemanais()+"\n"); 
               txt.append("\tData Inicio: " + comissoes.getDtInicio()+"\n"); 
               txt.append("\tData Termino: " + comissoes.getDtFim().format(fmtAno)+"\n");
               if(comissoes.getEstado() == 1){
                   txt.append("\tEstado: ativo"+"\n");
               }else if(comissoes.getEstado() == 2){
                   txt.append("\tEstado: inativa"+"\n");
               }
               txt.append("\tData de Criacao: " + comissoes.getDtCriacao().format(fmtAno)+"\n"); 
               txt.append("\tUltima Data de Moificação: " + comissoes.getDtModificacao().format(fmt) +"\n\n\n"); 
    
            }
  
        return txt.toString();
    }
    
    
    public String toStringMin() {
        
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        DateTimeFormatter fmtAno = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        StringBuilder txt = new StringBuilder();
        
        txt.append("\t\t\t === Comissoes === \n\n");
        List<Comissoes> obj = this.lista();
        
            for(Comissoes comissoes : obj){
               txt.append("\tNome Comissao: " + comissoes.getComissao()+"\t\t\t ID: " + comissoes.getId() +"\n"); 
            }
  
        return txt.toString();
    }
}
