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

                    int indice = rs.getInt("id");
                    String nome = rs.getString("nome");
                    String abreviacao = rs.getString("abreviacao");
                    int duracaoAulas= rs.getInt("duracao_aulas");
    //                LocalDatetime dtCriacao = rs.getDate("data_criacao");
                    String cidade = rs.getString("cidade");
                    String bairro = rs.getString("bairro");
                    String endereco = rs.getString("endereco");
                    String cep = rs.getString("cep");
    //                LocalDateTime criacao = rs.getDate("criacao");
    //                LocalDateTime modificacao= rs.getDate("modificacao");

                    campus.setId(indice);
                    campus.setNome(nome);
                    campus.setAbreviacao(abreviacao);
                    campus.setDuracaoAula(duracaoAulas);
    //                campus.setDtCriacaoCampus(dtCriacao);
                    campus.setCidade(cidade);
                    campus.setBairro(bairro);
                    campus.setEndereco(endereco);
                    campus.setCep(cep);
    //                campus.setDtCriacao(criacao);
    //                campus.setDtModificacao(modificacao);campus.set
                    
                }
            }
        } catch (SQLException e) {
             throw new RuntimeException(e);
        }
        return campus;
    }
    

    
    public Campus buscaEspecifico(int id) throws SQLException{
        
         String sql = "select * "
                   + "from campus "
                   + "where id = ?";
         
        Campus campus = new Campus();
        
        try (Connection connection = new ConnectionFactory().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql)) {
            
            while (rs.next()) {

                int indice = rs.getInt("id");
                String nome = rs.getString("nome");
                String abreviacao = rs.getString("abreviacao");
                int duracaoAulas= rs.getInt("duracao_aulas");
//                LocalDatetime dtCriacao = rs.getDate("data_criacao");
                String cidade = rs.getString("cidade");
                String bairro = rs.getString("bairro");
                String endereco = rs.getString("endereco");
                String cep = rs.getString("cep");
//                LocalDateTime criacao = rs.getDate("criacao");
//                LocalDateTime modificacao= rs.getDate("modificacao");

                campus.setId(indice);
                campus.setNome(nome);
                campus.setAbreviacao(abreviacao);
                campus.setDuracaoAula(duracaoAulas);
//                campus.setDtCriacaoCampus(dtCriacao);
                campus.setCidade(cidade);
                campus.setBairro(bairro);
                campus.setEndereco(endereco);
                campus.setCep(cep);
//                campus.setDtCriacao(criacao);
//                campus.setDtModificacao(modificacao);campus.set

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        return campus;
    }

}
