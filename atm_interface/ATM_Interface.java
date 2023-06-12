package com.mycompany.atm_interface;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;    
public class ATM_Interface {
    public static void main(String[] args) {
        
        Acc account1 = new Acc("user1", "2525", 5000.0);
        Acc account2 = new Acc("user2", "9090", 3000.0);
        Acc account3 = new Acc("user3", "4545", 15000.0);
        Acc account4 = new Acc("user4", "6565", 53000.0);

        Scanner scanner = new Scanner(System.in);
        System.out.print("\n\nEnter your user ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter your PIN: ");
        String userPin = scanner.nextLine();

        Acc currentAccount = null;

    
        if (account1.getUserID().equals(userId) && account1.validatePin(userPin)) {
            currentAccount = account1;
        } else if (account2.getUserID().equals(userId) && account2.validatePin(userPin)) {
            currentAccount = account2;
        } else if (account3.getUserID().equals(userId) && account3.validatePin(userPin)) {
            currentAccount = account3;
        } else if (account4.getUserID().equals(userId) && account4.validatePin(userPin)) {
            currentAccount = account4;
        } else {
            System.out.println("Invalid user ID or PIN. Exiting...");
            System.exit(0);
        }

        System.out.println("Login successful!");
        System.out.println("Welcome, " + currentAccount.getUserID() + "!");
        System.out.println("Your current balance: $" + currentAccount.getBalance());

        boolean quit = false;

        while (!quit) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. View transaction history");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\nTransaction History:");
                    List<Trans> transactions = currentAccount.getTransactionHistory();
                    if (transactions.isEmpty()) {
                        System.out.println("No transactions found.");
                    } else {
                        for (Trans transaction : transactions) {
                            System.out.println(transaction.getType() + ": $" + transaction.getAmount());
                        }
                    }
                    break;
                case 2:
                    System.out.print("Enter the amount to withdraw: $");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine(); 

                    if (currentAccount.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawal successful. Current balance: $" + currentAccount.getBalance());
                    } else {
                        System.out.println("Insufficient balance.");
                    }
                    break;
                case 3:
                    System.out.print("Enter the amount to deposit: $");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine(); 

                    currentAccount.deposit(depositAmount);
                    System.out.println("Deposit successful. Current balance: $" + currentAccount.getBalance());
                    break;
                case 4:
                    System.out.print("Enter the recipient's user ID: ");
                    String recipientId = scanner.nextLine();
                    System.out.print("Enter the amount to transfer: $");
                    double transferAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline character

                    Acc recipientAccount = null;
                    if (account1.getUserID().equals(recipientId)) {
                        recipientAccount = account1;
                    } else if (account2.getUserID().equals(recipientId)) {
                        recipientAccount = account2;
                    }

                    if (recipientAccount != null) {
                        currentAccount.transfer(recipientAccount, transferAmount);
                        System.out.println("Transfer successful. Current balance: $" + currentAccount.getBalance());
                    } else {
                        System.out.println("Recipient not found.");
                    }
                    break;
                case 5:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        System.out.println("Thank you for using the ATM. Goodbye!");
    }
}



