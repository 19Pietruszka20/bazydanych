/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import dao.OsobaDAOJdbc;
import dao.OsobaDAO_HIB;
import java.util.List;
import entities.Osoba;
import dao.OsobaDAO;

/**
 *
 * @author ZTI
 */
public class TestDao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        OsobaDAO osobaDAO = new OsobaDAOJdbc();
//         OsobaDAO osobaDAO = new OsobaDAO_HIB();
        osobaDAO.clearTable();
        for (int i = 0; i < 5; i++) {
            Osoba osoba = new Osoba("imie_"+i, "nazwisko_"+i);
            osobaDAO.create(osoba);
        }
        
        List<Osoba> osoby = osobaDAO.getAll();
        osoby.forEach(System.out::println);
        
        osobaDAO.delete(osoby.get(0));
        Osoba osoba = osoby.get(1);
        osoba.setImie("zmodyfikowany");
        osobaDAO.update(osoba);
        
        //inne testy
       
    }
    
}
