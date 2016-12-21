package db.service;

import db.ConnectorDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeInsert {
    public static void employeeInsertWithPreparedStatement(int id, String name)
    {
        Connection connection = ConnectorDB.getConnection();
        PreparedStatement insertPreparedStatement = null;
        String insertQuery = "INSERT INTO EMPLOYEE"+"(id, name) VALUES"+"(?,?)";
        try {
            insertPreparedStatement = connection.prepareStatement(insertQuery);
            insertPreparedStatement.setInt(1, id);
            insertPreparedStatement.setString(2, name);
            insertPreparedStatement.executeUpdate();
            insertPreparedStatement.close();
        }catch (SQLException e)
        {
            System.out.println("SQLException e : " + e.getMessage());
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
