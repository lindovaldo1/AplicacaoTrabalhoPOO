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
import model.Orientacoes;
import model.Servidor;
/**
 *
 * @author Lindovaldo
 */
public class OrientacoesDAO {
    
    ServidorDAO servidorDao;
    
    public OrientacoesDAO(ServidorDAO servidor) {
        this.servidorDao = servidor;
    }
    
    
    
    public void adiciona(Orientacoes obj){
        
         String sql = "insert into orientacoes"
                    + " (tipo_orientacao,nome_aluno,servidor,horas_semanais,data_inicio,data_termino,criacao,modificacao)"
                    + " values (?,?,?,?,?,?,?,?)";
         
        try (Connection connection = new ConnectionFactory().getConnection();
            
            PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            stmt.setInt(1, obj.getTipoOrientacao());
            stmt.setString(2, obj.getNomeAluno());
            stmt.setLong(3, obj.getServidor().getId());
            stmt.setDouble(4, obj.getHorasSemanais());
            stmt.setDate(5, java.sql.Date.valueOf(obj.getDtInicio()));
            stmt.setDate(6, java.sql.Date.valueOf(obj.getDtTermino()));
           
            stmt.setTimestamp (7, java.sql.Timestamp.valueOf(LocalDateTime.now()));
            stmt.setTimestamp (8, java.sql.Timestamp.valueOf(LocalDateTime.now()));
            
            stmt.execute();
            
            System.out.println("Elemento inserido com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro, elemento não adicionado ao banco. RuntimeException");
        } 
        
    }
    
    public Orientacoes buscaEspecifico(long identificador) {
        
        String sql = "select * "
                   + "from orientacoes "
                   + "where id = ?";
        
        Orientacoes obj = new Orientacoes();
        
        try (Connection connection = new ConnectionFactory().getConnection(); 
             PreparedStatement ps = connection.prepareStatement(sql)         ){
            
            ps.setLong(1, identificador);

            try (ResultSet rs = ps.executeQuery()) {
                
                while(rs.next()) {

                  Long indice = rs.getLong("id");
                  int tipoOrientacao = rs.getInt("tipo_orientacao");
                  String nomeAluno = rs.getString("nome_aluno");
                  Servidor servidor = servidorDao.buscaEspecifico(rs.getLong("servidor"));
                  double horasSemanais = rs.getDouble("horas_semanais");
                  Date dataInicio = rs.getDate("data_inicio");
                  LocalDate dtInicio = dataInicio.toLocalDate();
                  Date dataTermino = rs.getDate("data_termino");
                  LocalDate dtTermino = dataTermino.toLocalDate();
                  Timestamp criacaoTimestamp = rs.getTimestamp("criacao");
                  LocalDateTime criacao = criacaoTimestamp.toLocalDateTime();
                  Timestamp modificacaoTimestamp = rs.getTimestamp("modificacao");
                  LocalDateTime modificacao= modificacaoTimestamp.toLocalDateTime();

                  obj.setId(indice);
                  obj.setTipoOrientacao(tipoOrientacao);
                  obj.setNomeAluno(nomeAluno);
                  obj.setServidor(servidor);
                  obj.setHorasSemanais(horasSemanais);
                  obj.setDtInicio(dtInicio);
                  obj.setDtTermino(dtTermino);
                  
                  obj.setDtCriacao(criacao);
                  obj.setDtModificacao(modificacao);
                    
                }
            }
        } catch (SQLException e) {
             throw new RuntimeException("Erro. Requisicao não pode ser feita. RuntimeException");
        }
        return obj;
    }
    
    public List<Orientacoes> lista() {

          String sql = "select * from orientacoes";


          ArrayList<Orientacoes> arr = new ArrayList<>();

          try (Connection connection = new ConnectionFactory().getConnection();
                  PreparedStatement stmt = connection.prepareStatement(sql);
                  ResultSet rs = stmt.executeQuery(sql)) {

              while (rs.next()) {
                   
                 Long indice = rs.getLong("id");
                  int tipoOrientacao = rs.getInt("tipo_orientacao");
                  String nomeAluno = rs.getString("nome_aluno");
                  Servidor servidor = servidorDao.buscaEspecifico(rs.getLong("servidor"));
                  double horasSemanais = rs.getDouble("horas_semanais");
                  Date dataInicio = rs.getDate("data_inicio");
                  LocalDate dtInicio = dataInicio.toLocalDate();
                  Date dataTermino = rs.getDate("data_termino");
                  LocalDate dtTermino = dataTermino.toLocalDate();
                  Timestamp criacaoTimestamp = rs.getTimestamp("criacao");
                  LocalDateTime criacao = criacaoTimestamp.toLocalDateTime();
                  Timestamp modificacaoTimestamp = rs.getTimestamp("modificacao");
                  LocalDateTime modificacao= modificacaoTimestamp.toLocalDateTime();
;
                  
                  Orientacoes obj = new Orientacoes();

                  obj.setId(indice);
                  obj.setTipoOrientacao(tipoOrientacao);
                  obj.setNomeAluno(nomeAluno);
                  obj.setServidor(servidor);
                  obj.setHorasSemanais(horasSemanais);
                  obj.setDtInicio(dtInicio);
                  obj.setDtTermino(dtTermino);
                  
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
       String sql = "delete from orientacoes where id = ?";

       try ( Connection connection = new ConnectionFactory().getConnection();  
             PreparedStatement stmt = connection.prepareStatement(sql)) {

           stmt.setLong(1, id);
           stmt.execute();

       } catch (SQLException e) {
           throw new RuntimeException("Erro, elemento não removido do banco. RuntimeException");
       }
    }

    public void altera(Orientacoes obj){
        
        String sql = "update orientacoes "
                   + "set tipo_orientacao = ?, "
                   + "nome_aluno = ?,"
                   + "servidor  = ?,"
                   +"horas_semanais = ?,"
                   +"data_inicio = ?,"
                   +"data_termino = ?,"
                   +"modificacao = ?"
                   + "where id = ?";
        
         try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            stmt.setInt(1, obj.getTipoOrientacao());
            stmt.setString(2, obj.getNomeAluno());
            stmt.setLong(3, obj.getServidor().getId());;
            stmt.setDouble(4, obj.getHorasSemanais());;
            
            stmt.setDate(5, java.sql.Date.valueOf(obj.getDtInicio()));
            stmt.setDate(6, java.sql.Date.valueOf(obj.getDtTermino()));
            stmt.setTimestamp(7, java.sql.Timestamp.valueOf(LocalDateTime.now()));
            stmt.setLong(8, obj.getId());
            
            
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
        
        txt.append("\t\t\t === Orientacoes === \n\n");
        List<Orientacoes> obj = this.lista();

            for(Orientacoes orientacoes : obj){
               txt.append("\n\tNome Aluno: " + orientacoes.getNomeAluno()+"\t\t\t ID: " + orientacoes.getId() +"\n"); 
               if( orientacoes.getTipoOrientacao() == 1){
                   txt.append("\tTipo Orientacao: ensino"+"\n"); 
               }else if( orientacoes.getTipoOrientacao() == 2){
                   txt.append("\tTipo Orientacao: pesquisa"+"\n"); 
               }else if( orientacoes.getTipoOrientacao() == 3){
                   txt.append("\tTipo Orientacao: extensao"+"\n"); 
               }else if( orientacoes.getTipoOrientacao() == 4){
                   txt.append("\tTipo Orientacao: estagio"+"\n"); 
               }else if( orientacoes.getTipoOrientacao() == 5){
                   txt.append("\tTipo Orientacao: tcc"+"\n"); 
               }else if( orientacoes.getTipoOrientacao() == 6){
                   txt.append("\tTipo Orientacao: mestrado"+"\n"); 
               }else if( orientacoes.getTipoOrientacao() == 7){
                   txt.append("\tTipo Orientacao: doutorado"+"\n"); 
               }               
               txt.append("\tServidor: " + orientacoes.getServidor().getNome()+"\n"); 
               txt.append("\tHoras Semanais: " + orientacoes.getHorasSemanais()+"\n"); 
               txt.append("\tAno Inicio: " + orientacoes.getDtInicio().format(fmtAno)+"\n"); 
               txt.append("\tAno Termino: " + orientacoes.getDtTermino().format(fmtAno)+"\n"); 
               txt.append("\tData de Criacao: " + orientacoes.getDtCriacao().format(fmtAno)+"\n"); 
               txt.append("\tUltima Data de Modificação: " + orientacoes.getDtModificacao().format(fmt) +"\n\n\n"); 

               
            }
  
        return txt.toString();
    }
    
    
    public String toStringMin() {
        
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        DateTimeFormatter fmtAno = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        StringBuilder txt = new StringBuilder();
        
        txt.append("\t\t\t === Orientacoes === \n\n");
        List<Orientacoes> obj = this.lista();
        
            for(Orientacoes orientacoes : obj){
               txt.append("\n\tNome Aluno: " + orientacoes.getNomeAluno()+"\t\t\t ID: " + orientacoes.getId() +"\n"); 
               txt.append("\tNome Servidor: " + orientacoes.getServidor().getNome()+"\n"); 
    
            }
  
        return txt.toString();
    }
}
