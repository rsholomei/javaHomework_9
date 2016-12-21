package db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DropTable {
    public static void drop(String name)
    {
        Connection connection = ConnectorDB.getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE " + name.toUpperCase());
        }catch (SQLException e)
        {
            System.out.println("SQLException e " + e.getMessage());
        }
    }
}
