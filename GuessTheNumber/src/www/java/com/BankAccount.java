package www.java.com;

import java.util.Scanner;

public class BankAccount 
{
	    private double balance;

	    public BankAccount(double initialBalance)
	    {
	        this.balance = initialBalance;
	    }

	    public double getBalance() 
	    {
	        return balance;
	    }

	    public void deposit(double amount) 
	    {
	        balance += amount;
	    }

	    public boolean withdraw(double amount) 
	    {
	        if (amount <= balance)
	        {
	            balance -= amount;
	            return true;
	        } else {
	            return false; // Insufficient funds
	        }
	    }
	}

	class ATM {
	    private BankAccount userAccount;

	    public ATM(BankAccount account) 
	    {
	        this.userAccount = account;
	    }

	    public void displayOptions() 
	    {
	        System.out.println("1. Withdraw");
	        System.out.println("2. Deposit");
	        System.out.println("3. Check Balance");
	    }

	    public void processOption(int option) 
	    {
	        Scanner scanner = new Scanner(System.in);

	        switch (option) 
	        {
	            case 1:
	                System.out.println("Enter withdrawal amount:");
	                double withdrawAmount = scanner.nextDouble();
	                if (userAccount.withdraw(withdrawAmount)) 
	                {
	                    System.out.println("Withdrawal successful. Remaining balance: " + userAccount.getBalance());
	                } else 
	                {
	                    System.out.println("Insufficient funds. Withdrawal failed.");
	                }
	                break;
	            case 2:
	                System.out.println("Enter deposit amount:");
	                double depositAmount = scanner.nextDouble();
	                userAccount.deposit(depositAmount);
	                System.out.println("Deposit successful. New balance: " + userAccount.getBalance());
	                break;
	            case 3:
	                System.out.println("Current balance: " + userAccount.getBalance());
	                break;
	            default:
	                System.out.println("Invalid option. Please choose a valid option.");
	        }
	    }
	}

	class Main {
	    public static void main(String[] args) 
	    {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Enter initial balance for your account:");
	        double initialBalance = scanner.nextDouble();

	        BankAccount userAccount = new BankAccount(initialBalance);
	        ATM atm = new ATM(userAccount);

	        int userOption;

	        do {
	            atm.displayOptions();
	            System.out.println("Enter your choice (0 to exit):");
	            userOption = scanner.nextInt();
	            
	            if (userOption != 0) 
	            {
	                atm.processOption(userOption);
	            }

	        } 
	        while (userOption != 0);

	        System.out.println("Thank you for using the ATM. Have a great day!");;
	}
}






