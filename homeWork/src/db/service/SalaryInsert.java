package db.service;

import db.ConnectorDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SalaryInsert {
    public static void salaryInsertWithPreparedStatement(int id, String date, int value, int emp_id)
    {
        Connection connection = ConnectorDB.getConnection();
        PreparedStatement insertPreparedStatement = null;
        String insertQuery = "INSERT INTO SALARY"+"(id, date, value, emp_id) VALUES"+"(?,?,?,?)";
        try {
            insertPreparedStatement = connection.prepareStatement(insertQuery);
            insertPreparedStatement.setInt(1, id);
            insertPreparedStatement.setString(2, date);
            insertPreparedStatement.setInt(3, value);
            insertPreparedStatement.setInt(4, emp_id);
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
