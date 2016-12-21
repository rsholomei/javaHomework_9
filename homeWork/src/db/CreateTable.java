package db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    public static void  create()
    {
        Connection connection = null;
        try {
            connection = ConnectorDB.getConnection();
            Statement statement = null;
            try {
                statement = connection.createStatement();
                statement.execute("CREATE TABLE EMPLOYEE(id INT PRIMARY KEY, name VARCHAR (255))");
                statement.execute("CREATE TABLE SALARY(id INT PRIMARY KEY, date VARCHAR (255), value INT, emp_id INT )");
            }finally {
                if (statement != null) {
                    statement.close();
                } else {
                    System.err.println("Statement не створений");
                }
        }
    }catch (SQLException e)
        {
            System.err.println("DB connection error: " + e);
        }finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("Connection close error: " + e);
                }
            }
        }
    }
}
