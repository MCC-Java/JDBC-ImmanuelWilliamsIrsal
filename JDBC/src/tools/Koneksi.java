package tools;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author ASUS-PC BigBoss
 */
public class Koneksi {
    private Connection connection;
    
    /**
     * Connection method is for accessing the database
     * Please set server name, port, db name and user according your needs.
     * @return 
     */
    
    public Connection getConnection(){
        try {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setServerName("localhost");
            dataSource.setPort(3306);
            dataSource.setDatabaseName("mccoc");
            dataSource.setUser("root");
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
