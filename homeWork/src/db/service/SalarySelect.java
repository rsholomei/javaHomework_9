package db.service;

import db.ConnectorDB;
import db.entity.Salary;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SalarySelect {
    public static void select() {
        Connection connection = null;
        try {
            connection = ConnectorDB.getConnection();
            Statement statement = null;
            try {
                statement = connection.createStatement();
                ResultSet resultSet = null;
                try {
                    resultSet = statement.executeQuery("SELECT * FROM SALARY ");
                    ArrayList<Salary> list = new ArrayList<>();
                    while (resultSet.next()) {
                        int id = resultSet.getInt(1);
                        String date = resultSet.getString(2);
                        int value = resultSet.getInt(3);
                        int emp_id = resultSet.getInt(4);
                        list.add(new Salary(id, date, value, emp_id));
                    }
                    if (list.size() > 0) {
                        System.out.println(list);
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
