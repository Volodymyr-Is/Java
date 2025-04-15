package org.example.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerImpl implements CustomerDAO{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate=jdbcTemplate;
    }

    @Override
    public List<Customer> getAll() {
        String query="select * from customers";
        return jdbcTemplate.query(query,new CustomersRowMapper());
    }

    @Override
    public Customer getById(int id) {
        String query="select * from customers where id=?";
        return jdbcTemplate.queryForObject(query,new Object[]{id},new CustomersRowMapper());
    }

    @Override
    public void create(Customer customer) {
        String query="insert into customers(name,email) values(?,?)";
        jdbcTemplate.update(query,customer.getName(),customer.getEmail());

    }

    @Override
    public void delete(int id) {
        String query="delete customers where id=?";
        jdbcTemplate.update(query,id);

    }

    @Override
    public void update(int id, Customer customer) {
        String query="update customers set name=?,email=? where id=?";
        jdbcTemplate.update(query,customer.getName(),customer.getEmail(),id);

    }
}