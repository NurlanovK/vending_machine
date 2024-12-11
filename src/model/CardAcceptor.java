package model;
import java.util.Scanner;

public class CardAcceptor implements PaymentProcessor {

    private double balance;
    private final String cardNumber;
    private final String pin;

    public CardAcceptor(double initialBalance, String cardNumber, String pin) {
        this.balance = initialBalance;
        this.cardNumber = cardNumber;
        this.pin = pin;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void deduct(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Списано: " + amount + " с карты.");
        } else {
            System.out.println("Недостаточно средств на карте.");
        }
    }

    public boolean processPayment(double amount) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер карты (8 цифр): ");
        String inputCardNumber = scanner.nextLine();
        System.out.print("Введите PIN (4 цифры): ");
        String inputPin = scanner.nextLine();

        if (inputCardNumber.equals(cardNumber) && inputPin.equals(pin)) {
            balance += amount;
            System.out.println("Баланс карты пополнен на: " + amount);
            return true;
        } else {
            System.out.println("Ошибка: неверный номер карты или PIN.");
            return false;
        }
    }
}
