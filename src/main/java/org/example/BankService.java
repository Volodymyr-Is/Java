package org.example;

public class BankService {
    public void transfer(User user, double amount) {
        System.out.println(user.getName() + " transfered " + amount + " $.");
    }

    public void checkBalance(User user) {
        System.out.println(user.getName() + " checked balance.");
    }
}
