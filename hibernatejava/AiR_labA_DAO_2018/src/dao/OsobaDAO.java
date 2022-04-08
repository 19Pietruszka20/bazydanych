/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Osoba;
import java.util.List;

/**
 *
 * @author ZTI
 */
public interface OsobaDAO {

 //Zwraca listę wszystkich działów
    List<Osoba> getAll();

//Zwraca osobę o podanym id
    Osoba get(int id);

//Wstawia do bazy nową osobę
    void create(Osoba osoba);

//Aktualizuje osobę
    void update(Osoba osoba);

//Usuwa osobę
    void delete(Osoba osoba);
    
//czyści tabelę
    void clearTable();    

}
