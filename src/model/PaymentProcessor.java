package model;

public interface PaymentProcessor {
    double getBalance();

    void deduct(double amount);
}