package pl.altkom;

import pl.altkom.model.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        CustomerDAO customerDAO = new CustomerDAOImpl();
        customerDAO.addCustomer(new Customer(2, "Bogdan"));
        List<Customer> customers = customerDAO.readAllCustomers();
        customers.forEach(System.out::println);
//        try {
//            Connection connection
//                    = DriverManager
//                    .getConnection("jdbc:sqlite:/home/student/database.sqlite");
//            Statement statement = connection.createStatement();
//            statement.executeUpdate(
//                    "CREATE TABLE Customer (" +
//                            "id INTEGER PRIMARY KEY," +
//                            "name TEXT)");
//            statement.executeUpdate("INSERT INTO Customer VALUES (1, 'Pawel')");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
