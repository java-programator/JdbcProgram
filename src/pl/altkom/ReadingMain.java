package pl.altkom;

import java.sql.*;

public class ReadingMain {
    public static void main(String[] args) {
        try {
            Connection connection
                    = DriverManager
                    .getConnection("jdbc:sqlite:/home/student/database.sqlite");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Customer");

            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1));
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getString("name"));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
