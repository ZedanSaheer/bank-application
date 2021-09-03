package com.bankApplication;

import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        BankAccount objectOne = new BankAccount("Customer" , "BA001");
        objectOne.showMenu();
    }
}

class BankAccount{
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    BankAccount(String cName ,String cid){
        customerName=cName;
        customerId=cid;
    }

    void deposit(int amount){
        if(amount!= 0){
            balance= balance + amount;
            previousTransaction = amount;
        }
    }
    void withdraw(int amount){
        if(amount !=0){
            balance= balance - amount;
            previousTransaction = -amount;
        }
    }
    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited :" + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn :" + previousTransaction);
        }
        else{
            System.out.println("No Transactions occured!");
        }
    }
    void showMenu(){
        char option;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome" + " " + customerName);
        System.out.println("Your ID :" + customerId);
        System.out.println('\n');


        do {
            System.out.println("A. Check Balance");
            System.out.println("B. Withdraw");
            System.out.println("C. Deposit");
            System.out.println("D. Previous Transactions");
            System.out.println("E. Exit Application");
            System.out.println("\n");
            System.out.println("__________________________________________");
            System.out.println("Enter an option!");
            System.out.println("__________________________________________");
            option = scanner.next().charAt(0);
            System.out.println("\n");

            switch (option) {
                case 'A' -> {
                    System.out.println("__________________________________________");
                    System.out.println("Balance is :" + balance);
                    System.out.println("__________________________________________");
                }
                case 'B' -> {
                    System.out.println("__________________________________________");
                    System.out.println("Enter an amount to withdraw :");
                    System.out.println("__________________________________________");
                    int amountWithdraw = scanner.nextInt();
                    withdraw(amountWithdraw);
                    System.out.println("\n");
                }
                case 'C' -> {
                    System.out.println("__________________________________________");
                    System.out.println("Enter an amount to deposit :");
                    System.out.println("__________________________________________");
                    int amountDep = scanner.nextInt();
                    deposit(amountDep);
                    System.out.println("\n");
                }
                case 'D' -> {
                    System.out.println("__________________________________________");
                    getPreviousTransaction();
                    System.out.println("__________________________________________");
                    System.out.println('\n');
                }
                case 'E' -> System.out.println("____________________");
                default -> {System.out.println("Invalid Option , Please Try Again!");
                    System.out.println('\n');
                }
            }
        }while (option != 'E');
            System.out.println("Thank you for using zedan's bank!");
    }
}
