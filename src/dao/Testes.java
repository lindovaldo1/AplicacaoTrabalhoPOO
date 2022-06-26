/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import model.Servidor;

/**
 *
 * @author Lindovaldo
 */
public class Testes {
    public static void main(String[] args) {
        
        Servidor servidor = new Servidor();
        CampusDAO campusDAO = new CampusDAO();
        ServidorDAO servidordao = new ServidorDAO(campusDAO);
        



        servidordao.remove(25);
        servidordao.remove(26);

        
        for (Servidor arg : servidordao.lista()) {
            System.out.println(arg);
        }
        
    }
}
