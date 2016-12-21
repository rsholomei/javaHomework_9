package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorDB {
    public static Connection getConnection()
    {
        Connection dbConnection = null;
        try {
            Class.forName("org.h2.Driver");
        }catch (ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection("jdbc:h2:~/db", "root", "root");
            return dbConnection;
        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }
}
