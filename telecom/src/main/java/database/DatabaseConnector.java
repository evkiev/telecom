package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private  Connection connection;
    private static DatabaseConnector ourInstance = new DatabaseConnector();

    public static DatabaseConnector getInstance() {
        return ourInstance;
    }

    private DatabaseConnector() {
        try {
            this.connection= DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/telecom?user=root&password=kiev2014&useSSL=false");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
