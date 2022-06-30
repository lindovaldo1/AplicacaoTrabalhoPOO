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
import model.ServidoresComissoes;

/**
 *
 * @author Lindovaldo
 */
public class ServidoresComissoesDAO {
    
    ComissoesDAO comissaoDao;
    ServidorDAO servidorDao;

    public ServidoresComissoesDAO(ComissoesDAO comissaoDao, ServidorDAO servidorDao) {
        this.comissaoDao = comissaoDao;
        this.servidorDao = servidorDao;
    }


    public void adiciona(ServidoresComissoes obj){
        
         String sql = "insert into servidor_comissao"
                    + " (comissao,servidor,papel,data_entrada,data_saida,criacao,modificacao)"
                    + " values (?,?,?,?,?,?,?)";
         
        try (Connection connection = new ConnectionFactory().getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            stmt.setLong(1, obj.getComissao().getId());
            stmt.setLong(2, obj.getServidor().getId());
            stmt.setInt(3, obj.getPapel());
            stmt.setDate(4, java.sql.Date.valueOf(obj.getDtEntrada()));
            stmt.setDate(5, java.sql.Date.valueOf(obj.getDtSaida()));
           
            stmt.setTimestamp (6, java.sql.Timestamp.valueOf(LocalDateTime.now()));
            stmt.setTimestamp (7, java.sql.Timestamp.valueOf(LocalDateTime.now()));
            
            stmt.execute();
            
            System.out.println("Elemento inserido com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro, elemento não adicionado ao banco. RuntimeException");
        } 
        
    }
    
    public ServidoresComissoes buscaEspecifico(long identificador) {
        
        String sql = "select * "
                   + "from servidor_comissao "
                   + "where id = ?";
        
        ServidoresComissoes obj = new ServidoresComissoes();
        
        try (Connection connection = new ConnectionFactory().getConnection(); 
             PreparedStatement ps = connection.prepareStatement(sql)         ){
            
            ps.setLong(1, identificador);

            try (ResultSet rs = ps.executeQuery()) {
                
                while(rs.next()) {
                    
                  long indice = rs.getLong("id");
                  long comissao = rs.getLong("comissao");
                  long servidor = rs.getLong("servidor");
                  int papel = rs.getInt("papel");
                  Date dtEntradaDate  = rs.getDate("data_entrada");
                  LocalDate dtEntrada = dtEntradaDate.toLocalDate();
                  Date dtSaidaDate  = rs.getDate("data_saida");
                  LocalDate dtSaida = dtSaidaDate.toLocalDate();
             
                  Timestamp criacaoTimestamp = rs.getTimestamp("criacao");
                  LocalDateTime criacao = criacaoTimestamp.toLocalDateTime();
                  Timestamp modificacaoTimestamp = rs.getTimestamp("modificacao");
                  LocalDateTime modificacao= modificacaoTimestamp.toLocalDateTime();

                  obj.setId(indice);
                  obj.setComissao(comissaoDao.buscaEspecifico(comissao));
                  obj.setServidor(servidorDao.buscaEspecifico(servidor));
                  obj.setPapel(papel);
                  obj.setDtEntrada(dtEntrada);
                  obj.setDtSaida(dtSaida);

                  obj.setDtCriacao(criacao);
                  obj.setDtModificacao(modificacao);
                    
                }
            }
        } catch (SQLException e) {
             throw new RuntimeException("Erro. Requisicao não pode ser feita. RuntimeException");
        }
        return obj;
    }
    
    public List<ServidoresComissoes> lista() {

          String sql = "select * from servidor_comissao";


          ArrayList<ServidoresComissoes> arr = new ArrayList<>();

          try (Connection connection = new ConnectionFactory().getConnection();
                  PreparedStatement stmt = connection.prepareStatement(sql);
                  ResultSet rs = stmt.executeQuery(sql)) {

              while (rs.next()) {
                   
                  long indice = rs.getLong("id");
                  long comissao = rs.getLong("comissao");
                  long servidor = rs.getLong("servidor");
                  int papel = rs.getInt("papel");
                  Date dtEntradaDate  = rs.getDate("data_entrada");
                  LocalDate dtEntrada = dtEntradaDate.toLocalDate();
                  Date dtSaidaDate  = rs.getDate("data_saida");
                  LocalDate dtSaida = dtSaidaDate.toLocalDate();
             
                  Timestamp criacaoTimestamp = rs.getTimestamp("criacao");
                  LocalDateTime criacao = criacaoTimestamp.toLocalDateTime();
                  Timestamp modificacaoTimestamp = rs.getTimestamp("modificacao");
                  LocalDateTime modificacao= modificacaoTimestamp.toLocalDateTime();
                  
                  ServidoresComissoes obj = new ServidoresComissoes();
                  
                  obj.setId(indice);
                  obj.setComissao(comissaoDao.buscaEspecifico(comissao));
                  obj.setServidor(servidorDao.buscaEspecifico(servidor));
                  obj.setPapel(papel);
                  obj.setDtEntrada(dtEntrada);
                  obj.setDtSaida(dtSaida);

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
       String sql = "delete from servidor_comissao where id = ?";

       try ( Connection connection = new ConnectionFactory().getConnection();  
             PreparedStatement stmt = connection.prepareStatement(sql)) {

           stmt.setLong(1, id);
           stmt.execute();

       } catch (SQLException e) {
           throw new RuntimeException("Erro, elemento não removido do banco. RuntimeException");
       }
    }

    public void altera(ServidoresComissoes obj){
        
        String sql = "update servidor_comissao "
                   +"set comissao = ?, "
                   +"servidor = ?, "
                   +"papel = ?, "
                   +"data_entrada = ?, "
                   +"data_saida = ?, "
                   +"modificacao = ? "
                   + "where id = ? ";
        
         try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
                  
            stmt.setLong(1, obj.getComissao().getId());
            stmt.setLong(2, obj.getServidor().getId());
            stmt.setInt(3, obj.getPapel());;
            stmt.setDate(4, java.sql.Date.valueOf(obj.getDtEntrada()));
            stmt.setDate(5, java.sql.Date.valueOf(obj.getDtSaida()));
            
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
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        StringBuilder txt = new StringBuilder();
        
        List<ServidoresComissoes> obj = this.lista();
        
        for (ServidoresComissoes arr : obj) {
            txt.append("\tComissao: "+arr.getComissao().getComissao()+"\t\t\t ID: "+arr.getId() +"\n");
            txt.append("\tServidor: "+arr.getServidor().getNome()+"\n");
            txt.append("\tPapel: "+arr.getPapel()+"\n");
            txt.append("\tData Entrada: " + arr.getDtEntrada().format(fmt) + "\n");
            txt.append("\tData Saida: " + arr.getDtSaida().format(fmt) + "\n");
            txt.append("\tData Criação: "+arr.getDtCriacao().format(fmt)+"\n");
            txt.append("\tData Modificação: "+arr.getDtModificacao().format(fmt)+"\n\n");
                
         }
        
       return txt.toString();
    }
    
    public String toStringMin(){
        
        StringBuilder txt = new StringBuilder();
        
        List<ServidoresComissoes> obj = this.lista();
        
        txt.append("\t\t\t === Servidores Comissao === \n\n");
        
        for (ServidoresComissoes arr : obj) {
            txt.append("\tComissao: "+arr.getComissao().getComissao()+"\t\t\t ID: "+arr.getId() +"\n");
            txt.append("\tServidor: "+arr.getServidor().getNome()+"\n");
        }
        
        return txt.toString();
    }
}
