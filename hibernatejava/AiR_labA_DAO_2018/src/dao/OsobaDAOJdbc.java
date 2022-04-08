/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Osoba;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author Michal Siedlaczek
 */
public class OsobaDAOJdbc implements OsobaDAO {

    private final DataSource ds;

    public OsobaDAOJdbc() {
        com.mysql.jdbc.jdbc2.optional.MysqlDataSource mds = new com.mysql.jdbc.jdbc2.optional.MysqlDataSource();
        mds.setUser("root");
        mds.setPort(6033);
        mds.setPassword("");
        mds.setDatabaseName("testdao");
        ds = mds;
    }

    @Override
    public List<Osoba> getAll() {
        List<Osoba> osobaList = new ArrayList<>();
        try (ResultSet rs = ds.getConnection().createStatement().executeQuery("select * from osoby")) {
            while (rs.next()) {
                Osoba osoba = new Osoba();
                osoba.setId(rs.getInt("id_osoby"));
                osoba.setImie(rs.getString("imie"));
                osoba.setNazwisko(rs.getString("nazwisko"));
                osobaList.add(osoba);
            }
        } catch (SQLException ex) {
            System.out.println("getAll: "+ex);
        }
        return osobaList;
    }

    @Override
    public Osoba get(int id) {
       Osoba osoba = new Osoba();
        try (PreparedStatement pstmt = ds
                .getConnection().prepareStatement("select * from osoby where id_osoby=?");) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
			rs.next();
            osoba.setId(rs.getInt("id_osoby"));
            osoba.setImie(rs.getString("imie"));
            osoba.setNazwisko(rs.getString("nazwisko"));
            return osoba;
        } catch (SQLException ex) {
            System.out.println("get "+ex);
        }
        return osoba;
    }

    @Override
    public void create(Osoba osoba) {
        try (PreparedStatement pstmt = ds
                .getConnection().prepareStatement("insert into osoby(imie, nazwisko) values(?,?)");) {
            pstmt.setString(1, osoba.getImie());
            pstmt.setString(2, osoba.getNazwisko());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("create "+ex);
        }
    }

    @Override
    public void update(Osoba osoba) {
        try (PreparedStatement pstmt = ds
                .getConnection().prepareStatement("update osoby set imie=?, nazwisko=? where id_osoby = ?");) {
            pstmt.setString(1, osoba.getImie());
            pstmt.setString(2, osoba.getNazwisko());
            pstmt.setInt(3, osoba.getId());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
             System.out.println("update "+ex);
        }
    }

    @Override
    public void delete(Osoba osoba) {
        try (PreparedStatement pstmt = ds
                .getConnection().prepareStatement("delete from osoby where id_osoby= ?");) {
            pstmt.setInt(1, osoba.getId());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
             System.out.println("delete "+ex);
        }
    }

    @Override
    public void clearTable() {
       try {
            ds.getConnection().createStatement().executeUpdate("delete from osoby");
        } catch (SQLException ex) {
            System.out.println("clear table "+ex);
        }
    }

   

}