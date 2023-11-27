import java.util.Scanner;

// User Account Class
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

// ATM Machine Class
public class ATM {
    private BankAccount userAccount;
    private Scanner scanner;

    public ATM(double initialBalance) {
        userAccount = new BankAccount(initialBalance);
        scanner = new Scanner(System.in);
    }
    public void displayMenu() {
        System.out.println();
        System.out.println("Welcome to the MyATM Machine!");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
    }

    public void run() {
        boolean isRunning = true;
        while (isRunning) {
            displayMenu();
            System.out.print("Select an option (1-4): ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    displayBalance();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    System.out.println("Thank you for using the MyATM Machine!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid option. Please select a valid option.");
            }
        }
    }

    private void displayBalance() {
        System.out.println();
        System.out.println("Your account balance is: $" + userAccount.getBalance());
    }

    private void depositMoney() {
        System.out.print("Enter the amount you'd like to deposit (in dollars): $");
        double depositAmount = scanner.nextDouble();
        userAccount.deposit(depositAmount);
        System.out.println();
        System.out.println("Deposit successful! You have added $" + depositAmount + " to your account.");
        displayBalance(); // Show the updated balance
    }

    private void withdrawMoney() {
        System.out.print("Enter the amount you'd like to withdraw from your account (in dollars): $");
        double withdrawAmount = scanner.nextDouble();
        if (userAccount.withdraw(withdrawAmount)) {
            System.out.println();
            System.out.println("Withdrawal successful! You have withdrawn $" + withdrawAmount + " from your account.");
        } else {
            System.out.println("Insufficient balance. Withdrawal failed.");
        }
        displayBalance(); // Show the updated balance
    }

    public static void main(String[] args) {
        ATM atm = new ATM(1000.0); // Initialize with a balance of $1000
        atm.run();
    }
}
