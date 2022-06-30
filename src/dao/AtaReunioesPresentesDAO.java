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
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;
import model.AtaReunioesPresentes;

/**
 *
 * @author Lindovaldo
 */
public class AtaReunioesPresentesDAO {
    
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    AtaReunioesDAO ataReuniaoDao;
    ComissoesDAO comissaoDao;
    ServidorDAO servidorDao;

    public AtaReunioesPresentesDAO(AtaReunioesDAO ataReuniaoDao, ComissoesDAO comissaoDao, ServidorDAO servidorDao) {
        this.ataReuniaoDao = ataReuniaoDao;
        this.comissaoDao = comissaoDao;
        this.servidorDao = servidorDao;
    }
    
    
    public void adiciona(AtaReunioesPresentes obj){
        
         String sql = "insert into ata_reunioes_presentes"
                    + " (comissao,servidor,ata_reuniao,criacao,modificacao)"
                    + " values (?,?,?,?,?)";
         
        try (Connection connection = new ConnectionFactory().getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            stmt.setLong(1, obj.getComissao().getId());
            stmt.setLong(2, obj.getServidor().getId());
            stmt.setLong(3, obj.getAtaReuniao().getId());
           
            stmt.setTimestamp (4, java.sql.Timestamp.valueOf(LocalDateTime.now()));
            stmt.setTimestamp (5, java.sql.Timestamp.valueOf(LocalDateTime.now()));
            
            stmt.execute();
            
            System.out.println("Elemento inserido com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro, elemento não adicionado ao banco. RuntimeException");
        } 
        
    }
    
    public AtaReunioesPresentes buscaEspecifico(long identificador) {
        
        String sql = "select * "
                   + "from ata_reunioes_presentes "
                   + "where id = ?";
        
        AtaReunioesPresentes obj = new AtaReunioesPresentes();
        
        try (Connection connection = new ConnectionFactory().getConnection(); 
             PreparedStatement ps = connection.prepareStatement(sql)         ){
            
            ps.setLong(1, identificador);

            try (ResultSet rs = ps.executeQuery()) {
                
                while(rs.next()) {
                            
                  long indice = rs.getLong("id");
                  long comissao = rs.getLong("comissao");
                  long servidor = rs.getLong("servidor");
                  long ataReuniao = rs.getLong("ata_reuniao");

                  Timestamp criacaoTimestamp = rs.getTimestamp("criacao");
                  LocalDateTime criacao = criacaoTimestamp.toLocalDateTime();
                  Timestamp modificacaoTimestamp = rs.getTimestamp("modificacao");
                  LocalDateTime modificacao= modificacaoTimestamp.toLocalDateTime();

                  obj.setId(indice);
                  obj.setComissao(comissaoDao.buscaEspecifico(comissao));
                  obj.setServidor(servidorDao.buscaEspecifico(servidor));
                  obj.setAtaReuniao(ataReuniaoDao.buscaEspecifico(ataReuniao));

                  obj.setDtCriacao(criacao);
                  obj.setDtModificacao(modificacao);
                    
                }
            }
        } catch (SQLException e) {
             throw new RuntimeException("Erro. Requisicao não pode ser feita. RuntimeException");
        }
        return obj;
    }
    
    public List<AtaReunioesPresentes> lista() {

          String sql = "select * from ata_reunioes_presentes";


          ArrayList<AtaReunioesPresentes> arr = new ArrayList<>();

          try (Connection connection = new ConnectionFactory().getConnection();
                  PreparedStatement stmt = connection.prepareStatement(sql);
                  ResultSet rs = stmt.executeQuery(sql)) {

              while (rs.next()) {
                   
                  long indice = rs.getLong("id");
                  long comissao = rs.getLong("comissao");
                  long servidor = rs.getLong("servidor");
                  long ataReuniao = rs.getLong("ata_reuniao");

                  Timestamp criacaoTimestamp = rs.getTimestamp("criacao");
                  LocalDateTime criacao = criacaoTimestamp.toLocalDateTime();
                  Timestamp modificacaoTimestamp = rs.getTimestamp("modificacao");
                  LocalDateTime modificacao= modificacaoTimestamp.toLocalDateTime();
                  
                  AtaReunioesPresentes obj = new AtaReunioesPresentes();
                  
                  obj.setId(indice);
                  obj.setComissao(comissaoDao.buscaEspecifico(comissao));
                  obj.setServidor(servidorDao.buscaEspecifico(servidor));
                  obj.setAtaReuniao(ataReuniaoDao.buscaEspecifico(ataReuniao));

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
       String sql = "delete from ata_reunioes_presentes where id = ?";

       try ( Connection connection = new ConnectionFactory().getConnection();  
             PreparedStatement stmt = connection.prepareStatement(sql)) {

           stmt.setLong(1, id);
           stmt.execute();

       } catch (SQLException e) {
           throw new RuntimeException("Erro, elemento não removido do banco. RuntimeException");
       }
    }

    public void altera(AtaReunioesPresentes obj){
        
        String sql = "update ata_reunioes_presentes "
                   +"set comissao = ?, "
                   +"servidor = ?, "
                   +"ata_reuniao = ?, "
                   +"modificacao = ? "
                   + "where id = ? ";
        
         try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
                  
            stmt.setLong(1, obj.getComissao().getId());
            stmt.setLong(2, obj.getServidor().getId());
            stmt.setLong(3, obj.getAtaReuniao().getId());;

            stmt.setTimestamp(4, java.sql.Timestamp.valueOf(LocalDateTime.now()));
            stmt.setLong(5, obj.getId());
            
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
        
        List<AtaReunioesPresentes> obj = this.lista();
        
        for (AtaReunioesPresentes arr : obj) {
            txt.append("\tComissao: "+arr.getComissao().getComissao()+"\t\t\t ID: "+arr.getId() +"\n");
            txt.append("\tServidor: "+arr.getServidor().getNome()+"\n");
            txt.append("\tData da Ata Reunião: "+arr.getAtaReuniao().getDtReuniao().format(fmt)+"\n");
            txt.append("\tData Criação: "+arr.getDtCriacao().format(fmt)+"\n");
            txt.append("\tData Modificação: "+arr.getDtModificacao().format(fmt)+"\n\n");
                
         }
        
       return txt.toString();
    }
    
    public String toStringMin(){
        
        StringBuilder txt = new StringBuilder();
        
        List<AtaReunioesPresentes> obj = this.lista();
        
        txt.append("\t\t\t === Ata Reunioes Presentes === \n\n");
        
        for (AtaReunioesPresentes arr : obj) {
            txt.append("\tComissao: "+arr.getComissao().getComissao()+"\t\t\t ID: "+arr.getId() +"\n");
            txt.append("\tServidor: "+arr.getServidor().getNome()+"\n");
            txt.append("\tData da Ata Reunião: "+arr.getAtaReuniao().getDtReuniao().format(fmt)+"\n");
        }
        
        return txt.toString();
    }
}
