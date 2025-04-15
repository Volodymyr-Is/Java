package org.example.Order;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrdersRowMapper implements RowMapper<Order> {

    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Order(rs.getInt(1),rs.getInt(2),rs.getDate(3).toLocalDate(),rs.getInt(4));
    }
}