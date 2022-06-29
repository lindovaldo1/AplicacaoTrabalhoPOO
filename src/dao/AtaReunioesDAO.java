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
import model.AtaReunioes;

/**
 *
 * @author Lindovaldo
 */
public class AtaReunioesDAO {
    
    ComissoesDAO comissoesDao;
    ServidorDAO servidorDao;

    public AtaReunioesDAO(ComissoesDAO comissoes, ServidorDAO servidor) {
        this.comissoesDao = comissoes;
        this.servidorDao = servidor;
    }
    
    
    
     public void adiciona(AtaReunioes obj){
        
         String sql = "insert into ata_reunioes"
                    + " (comissao, data_reuniao, conteudo_ata, servidor_secretario, criacao, modificacao)"
                    + " values (?,?,?,?,?,?)";
         
        try (Connection connection = new ConnectionFactory().getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            stmt.setLong(1, obj.getComissao().getId());
            stmt.setDate(2, java.sql.Date.valueOf(obj.getDtReuniao()));
            stmt.setString(3, obj.getAtaConteudo());
            stmt.setLong(4, obj.getSecretario().getId());

            stmt.setTimestamp (5, java.sql.Timestamp.valueOf(LocalDateTime.now()));
            stmt.setTimestamp (6, java.sql.Timestamp.valueOf(LocalDateTime.now()));
            
            stmt.execute();
            
            System.out.println("Elemento inserido com sucesso.");
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro, elemento não adicionado ao banco. RuntimeException");
        } 
        
    }
    
    public AtaReunioes buscaEspecifico(long identificador) {
        
        String sql = "select * "
                   + "from ata_reunioes "
                   + "where id = ?";
        
        AtaReunioes obj = new AtaReunioes();
        
        try (Connection connection = new ConnectionFactory().getConnection(); 
             PreparedStatement ps = connection.prepareStatement(sql)         ){
            
            ps.setLong(1, identificador);

            try (ResultSet rs = ps.executeQuery()) {
                
                while(rs.next()) {


                  Long indice = rs.getLong("id");
                  long comissao = rs.getLong("comissao");
                  Date dataReuniao = rs.getDate("data_reuniao");
                  LocalDate dtReuniao = dataReuniao.toLocalDate();
                  String conteudo = rs.getString("conteudo_ata");
                  long servidor = rs.getLong("servidor_secretario");
                  
                  Timestamp criacaoTimestamp = rs.getTimestamp("criacao");
                  LocalDateTime criacao = criacaoTimestamp.toLocalDateTime();
                  Timestamp modificacaoTimestamp = rs.getTimestamp("modificacao");
                  LocalDateTime modificacao= modificacaoTimestamp.toLocalDateTime();

                  obj.setId(indice);
                  obj.setComissao(comissoesDao.buscaEspecifico(comissao));
                  obj.setDtReuniao(dtReuniao);
                  obj.setAtaConteudo(conteudo);
                  obj.setSecretario(servidorDao.buscaEspecifico(servidor));
                  
                  obj.setDtCriacao(criacao);
                  obj.setDtModificacao(modificacao);
                    
                }
            }
        } catch (SQLException e) {
             throw new RuntimeException("Erro. Requisicao não pode ser feita. RuntimeException");
        }
        return obj;
    }
    
    public List<AtaReunioes> lista() {

          String sql = "select * from ata_reunioes";


          ArrayList<AtaReunioes> arr = new ArrayList<>();

          try (Connection connection = new ConnectionFactory().getConnection();
                  PreparedStatement stmt = connection.prepareStatement(sql);
                  ResultSet rs = stmt.executeQuery(sql)) {

              while (rs.next()) {
                   
                 Long indice = rs.getLong("id");
                  long comissao = rs.getLong("comissao");
                  Date dataReuniao = rs.getDate("data_reuniao");
                  LocalDate dtReuniao = dataReuniao.toLocalDate();
                  String conteudo = rs.getString("conteudo_ata");
                  long servidor = rs.getLong("servidor_secretario");
                  
                  Timestamp criacaoTimestamp = rs.getTimestamp("criacao");
                  LocalDateTime criacao = criacaoTimestamp.toLocalDateTime();
                  Timestamp modificacaoTimestamp = rs.getTimestamp("modificacao");
                  LocalDateTime modificacao= modificacaoTimestamp.toLocalDateTime();
                  
                  AtaReunioes obj = new AtaReunioes();
                  
                  obj.setId(indice);
                  obj.setComissao(comissoesDao.buscaEspecifico(comissao));
                  obj.setDtReuniao(dtReuniao);
                  obj.setAtaConteudo(conteudo);
                  obj.setSecretario(servidorDao.buscaEspecifico(servidor));
                  
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
       String sql = "delete from ata_reunioes where id = ?";

       try ( Connection connection = new ConnectionFactory().getConnection();  
             PreparedStatement stmt = connection.prepareStatement(sql)) {

           stmt.setLong(1, id);
           stmt.execute();
           
           System.out.println("Elemento removido com sucesso do banco de dados");
           
       } catch (SQLException e) {
           throw new RuntimeException("Erro, elemento não removido do banco. RuntimeException");
       }
    }

    public void altera(AtaReunioes obj){

                
        String sql = "update ata_reunioes "
                   + "set comissao = ?, "
                   + "data_reuniao = ?, "
                   +"conteudo_ata = ?, "
                   +"servidor_secretario = ?, "
                   +"modificacao = ? "
                   + "where id = ?";
        
         try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            

            stmt.setLong(1, obj.getComissao().getId());
            stmt.setDate(2, java.sql.Date.valueOf(obj.getDtReuniao()));
            stmt.setString(3, obj.getAtaConteudo());
            stmt.setLong(4, obj.getSecretario().getId());
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
        
        txt.append("\t\t\t === Ata Reunioes === \n\n");
        List<AtaReunioes> obj = this.lista();
        
            for(AtaReunioes ataReunioes : obj){
               txt.append("\tAta Conteudo: " + ataReunioes.getAtaConteudo()+"\t\t\t ID: " + ataReunioes.getId() +"\n"); 
               txt.append("\tComissao: " + ataReunioes.getComissao().getComissao()+"\n"); 
               txt.append("\tData Reuniao: " + ataReunioes.getDtReuniao()+"\n"); 
               txt.append("\tSecretario: " + ataReunioes.getSecretario().getNome()+"\n"); 
               txt.append("\tData de Criação: " + ataReunioes.getDtCriacao().format(fmt) +"\n"); 
               txt.append("\tUltima Data de Moificação: " + ataReunioes.getDtModificacao().format(fmt) +"\n\n\n"); 
    
            }
  
        return txt.toString();
    }
    
    
    public String toStringMin() {
        
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        DateTimeFormatter fmtAno = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        StringBuilder txt = new StringBuilder();
        
        txt.append("\t\t\t === Ata Reunioes === \n\n");
        List<AtaReunioes> obj = this.lista();
        
            for(AtaReunioes ataReunioes : obj){
               txt.append("\tData de Criacao: " + ataReunioes.getDtCriacao().format(fmtAno)+"\t\t\t ID: " + ataReunioes.getId() +"\n");  
            }
  
        return txt.toString();
    }
}
