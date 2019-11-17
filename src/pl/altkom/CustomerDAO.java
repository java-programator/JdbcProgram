package pl.altkom;

import pl.altkom.model.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> readAllCustomers();
    void addCustomer(Customer customer);
}
