package com.Task3;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Account {
    private int pin;
    private double balance;

    public Account(int pin, double balance) {
        this.pin = pin;
        this.balance = balance;
    }

    public boolean authenticate(int inputPin) {
        return this.pin == inputPin;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful! New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful! Remaining balance: $" + balance);
            return true;
        } else if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
        return false;
    }
}

public class ATMSimulationSystem {
	private static Map<Integer, Account> accounts = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    private static Account currentAccount = null;

    static {
        // Sample accounts: (AccountNumber -> PIN, Balance)
        accounts.put(12345, new Account(1111, 5000.00));
        accounts.put(67890, new Account(2222, 3000.00));
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the ATM!");
        authenticateUser();
        mainMenu();
    }

    private static void authenticateUser() {
        while (true) {
            System.out.print("Enter Account Number: ");
            int accountNumber = scanner.nextInt();

            System.out.print("Enter PIN: ");
            int pin = scanner.nextInt();

            if (accounts.containsKey(accountNumber) && accounts.get(accountNumber).authenticate(pin)) {
                currentAccount = accounts.get(accountNumber);
                System.out.println("Login successful!");
                break;
            } else {
                System.out.println("Invalid account number or PIN. Please try again.");
            }
        }
    }

    private static void mainMenu() {
        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Balance Inquiry");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    withdraw();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    private static void withdraw() {
        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();
        currentAccount.withdraw(amount);
    }

    private static void deposit() {
        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();
        currentAccount.deposit(amount);
    }

    private static void checkBalance() {
        System.out.println("Your balance: $" + currentAccount.getBalance());
    }
}

