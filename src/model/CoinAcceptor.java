package model;

public class CoinAcceptor implements PaymentProcessor {
    private double balance;

    public CoinAcceptor(double initialBalance) {
        this.balance = initialBalance;
    }

    public void addCoins(double amount) {
        balance += amount;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void deduct(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Списано: " + amount + " монет.");
        } else {
            System.out.println("Недостаточно средств.");
        }
    }
}