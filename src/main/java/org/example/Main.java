package org.example;

import org.example.Customer.Customer;
import org.example.Customer.CustomerDAO;
import org.example.Order.Order;
import org.example.Order.OrderDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        CustomerDAO customerDAO = context.getBean(CustomerDAO.class);
        customerDAO.create(new Customer("Bob", "bob@example.com"));

        OrderDAO orderDAO = context.getBean(OrderDAO.class);
        orderDAO.create(new Order(2, LocalDate.now(), 10));

        context.close();
    }
}