/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Osoba;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author ZTI
 */
public class OsobaDAO_HIB implements OsobaDAO {

    private final static SessionFactory FACTORY;

    static {
        FACTORY = new Configuration()
                .configure()
                .buildSessionFactory();
    }

    @Override
    public List<Osoba> getAll() {
        
        return null;
    }

    @Override
    public Osoba get(int id) {
        
        return null;
    }

    @Override
    public void create(Osoba dzial) {
        
    }

    @Override
    public void update(Osoba dzial) {
        
    }

    @Override
    public void delete(Osoba dzial) {
        
    }

    @Override
    public void clearTable() {
        
    }

}
