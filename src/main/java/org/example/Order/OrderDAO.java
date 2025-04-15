package org.example.Order;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface OrderDAO {
    void setJdbcTemplate(JdbcTemplate jdbcTemplate);
    public List<Order> getAll();
    public Order getById(int id);
    public void create(Order order);
    public void delete(int id);
    public void update(int id, Order order);
}
