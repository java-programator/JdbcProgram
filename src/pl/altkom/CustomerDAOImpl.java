package pl.altkom;

import pl.altkom.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    private Connection connection;

    public CustomerDAOImpl() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:/home/student/database.sqlite");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Customer> readAllCustomers() {
        Statement statement = null;
        ResultSet resultSet = null;
        List<Customer> result = new ArrayList<>();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Customer");

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                Customer c = new Customer(id, name);
                result.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public void addCustomer(Customer customer) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(
                    String.format(
                            "INSERT INTO Customer VALUES (%d, '%s')",
                            customer.getId(),
                            customer.getName()
                    )
            );
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
    }
}
