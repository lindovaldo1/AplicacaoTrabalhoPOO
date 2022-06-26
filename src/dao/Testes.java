/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.time.LocalDate;
import model.Curso;
import model.Servidor;

/**
 *
 * @author Lindovaldo
 */
public class Testes {
    public static void main(String[] args) {
        
        Curso curso = new Curso();
      
        CursoDAO cursodao = new CursoDAO();
        

        curso.setNome("Data cience");
        curso.setEstado(1);
        curso.setCampus(Long.parseLong("2"));
        curso.setAnoInicio(LocalDate.now());
        curso.setAnoTermino(LocalDate.now());
        curso.setId(1);
        
        cursodao.remove(3);

//        servidor.setId(21);
        
//        servidordao.remove(27);

        System.out.println(cursodao.buscaEspecifico(2));
//        
        for (Curso arg : cursodao.lista()) {
            System.out.println(arg);
        }
        
    }
}
