package connectionPoolExample;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class DataSource {
    private static volatile DataSource dataSource;
    private ComboPooledDataSource cpds;

    private DataSource() throws PropertyVetoException {
        cpds = new ComboPooledDataSource();
        cpds.setDriverClass("org.postgresql.Driver"); // регистрация драйвера
        cpds.setJdbcUrl("jdbc:postgresql://localhost:5432/exampleDB"); // бд
        cpds.setUser("root");
        cpds.setPassword("root");
        cpds.setMinPoolSize(1);
        cpds.setMaxPoolSize(10);
    }

    public static DataSource getInstance(){
        if (dataSource == null) {
            synchronized (DataSource.class) {
                if (dataSource == null){
                    try {
                        dataSource = new DataSource();
                    } catch (PropertyVetoException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return dataSource;
    }

    public Connection connection() throws SQLException {
        return cpds.getConnection();
    }

    public static Connection getConnection() throws SQLException {
        return getInstance().connection();
    }
}

class ConnectionPool {
    public static void main(String[] args) throws SQLException {
//        https://github.com/java-ifmo/lessons/blob/master/src/db/JDBCExample.java
        Connection connection = DataSource.getConnection();
    }
}
