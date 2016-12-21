package db;

import db.service.*;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        CreateTable.create();
        EmployeeInsert.employeeInsertWithPreparedStatement(1, "Alex");
        EmployeeInsert.employeeInsertWithPreparedStatement(2, "Max");
        EmployeeInsert.employeeInsertWithPreparedStatement(3, "Dik");
        SalaryInsert.salaryInsertWithPreparedStatement(1, "13-11-2017", 200, 1);
        SalaryInsert.salaryInsertWithPreparedStatement(2, "13-11-2017", 300, 2);
        SalaryInsert.salaryInsertWithPreparedStatement(3, "13-11-2017", 250, 3);
        SalaryInsert.salaryInsertWithPreparedStatement(4, "13-12-2017", 400, 1);
        SalaryInsert.salaryInsertWithPreparedStatement(5, "13-12-2017", 450, 2);
        SalaryInsert.salaryInsertWithPreparedStatement(6, "13-12-2017", 400, 3);
        EmployeeSelect.select();
        SalarySelect.select();
        EmployeeTotalSalaryById.getSalary();
    }
}
