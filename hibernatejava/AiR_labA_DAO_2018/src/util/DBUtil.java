package util;

import java.sql.SQLException;
import javax.sql.DataSource;

/**
 *
 * @author ZTI
 */
public class DBUtil {
    private final String databaseName = "testdao";
    private final String sqlCreateTable = "CREATE TABLE osoby ("
                                    +" id_osoby int NOT NULL auto_increment,"
                                    +" imie varchar(20),"
                                    +" nazwisko varchar(20),"
                                    +" PRIMARY KEY  (id_osoby))"
                                    +" ENGINE=InnoDB;"; 
    private final String sqlDropTable = "DROP TABLE IF EXISTS osoby"; 
    private DataSource ds;
    
    private DBUtil() {
        com.mysql.jdbc.jdbc2.optional.MysqlDataSource mds = new com.mysql.jdbc.jdbc2.optional.MysqlDataSource();
        mds.setUser("root");
        mds.setPort(6033);
        mds.setPassword("");
        mds.setDatabaseName(databaseName);
        ds = mds;
    }
    
    private void createTable(){
        try {
            ds.getConnection().createStatement().executeUpdate(sqlCreateTable);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    private void dropTable(){
        try {
            ds.getConnection().createStatement().executeUpdate(sqlDropTable);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public static void main(String[] args) {
        DBUtil dbUtil = new DBUtil();
        dbUtil.dropTable();
        dbUtil.createTable();
    }
    
}
