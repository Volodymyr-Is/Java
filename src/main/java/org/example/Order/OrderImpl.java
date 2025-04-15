package org.example.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderImpl implements OrderDAO{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate=jdbcTemplate;
    }

    @Override
    public List<Order> getAll() {
        String query="select * from orders";
        return jdbcTemplate.query(query,new OrdersRowMapper());
    }

    @Override
    public Order getById(int id) {
        String query="select * from orders where OrderID=? ";
        return jdbcTemplate.queryForObject(query,new Object[]{id},new OrdersRowMapper());
    }

    @Override
    public void create(Order order) {
        String query="insert into orders(CustomerID,OrderDate,Amount) values(?,?,?)";
        jdbcTemplate.update(query,order.getCustomerId(),order.getOrderDate(),order.getAmount());

    }

    @Override
    public void delete(int id) {
        String query="delete orders where OrderID=?";
        jdbcTemplate.update(query,id);

    }

    @Override
    public void update(int id, Order order) {
        String query="update orders set CustomerID=?,OrderDate=?,Amount=? where OrderID=?";
        jdbcTemplate.update(query,order.getCustomerId(),order.getOrderDate(),order.getAmount());

    }
}