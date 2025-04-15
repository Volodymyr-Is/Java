package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        BankService bankService = (BankService)context.getBean("bankService");

        User admin = new User("John", "ADMIN");
        User user = new User("Bob", "USER");

        try {
            bankService.transfer(admin, 1000);
            bankService.checkBalance(admin);
            bankService.transfer(user, 500);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}