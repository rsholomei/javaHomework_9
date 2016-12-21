package db.service;

import db.ConnectorDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeTotalSalaryById {
    public static void getSalary()
    {
        Connection connection = null;
        try {
            connection = ConnectorDB.getConnection();
            Statement statement = null;
            try {
                statement = connection.createStatement();
                ResultSet resultSet = null;
                try {
                    resultSet = statement.executeQuery("SELECT * FROM EMPLOYEE, SALARY WHERE EMPLOYEE.id = SALARY.emp_id");
                    int totalSalary = 0;
                    while (resultSet.next()) {
                        totalSalary += resultSet.getInt(5);
                    }
                    if (totalSalary > 0) {
                        System.out.println("Total salary = " + totalSalary);
                    } else {
                        System.out.println("Not found");
                    }
                } finally {
                    if (resultSet != null) {
                        resultSet.close();
                    } else {
                        System.err.println("Помилка зчитування з БД");
                    }
                }
            } finally {
                if (statement != null) {
                    statement.close();
                } else {
                    System.err.println("Statement не створений");
                }
            }
        } catch (SQLException e) {
            System.err.println("DB connection error: " + e);
        } finally {
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
