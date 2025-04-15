package org.example.Customer;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface CustomerDAO {
    void setJdbcTemplate(JdbcTemplate jdbcTemplate);
    public List<Customer> getAll();
    public Customer getById(int id);
    public void create(Customer customer);
    public void delete(int id);
    public void update(int id, Customer customer);
}
