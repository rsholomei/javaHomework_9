package db.service;

import db.ConnectorDB;
import db.entity.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmployeeSelect {

    public static void select() {
        Connection connection = null;
        try {
            connection = ConnectorDB.getConnection();
            Statement statement = null;
            try {
                statement = connection.createStatement();
                ResultSet resultSet = null;
                try {
                    resultSet = statement.executeQuery("SELECT * FROM EMPLOYEE ");
                    ArrayList<Employee> list = new ArrayList<>();
                    while (resultSet.next()) {
                        int id = resultSet.getInt(1);
                        String name = resultSet.getString(2);
                        list.add(new Employee(id, name));
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
