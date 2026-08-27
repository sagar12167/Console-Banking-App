import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        boolean running = true;

        while (running) {
            System.out.println("\n===== BANKING APPLICATION =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View Balance");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter account number: ");
                    String accountNumber = sc.nextLine();

                    System.out.print("Enter account holder name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter initial balance: ");
                    double balance = sc.nextDouble();
                    sc.nextLine();

                    System.out.println("1. Savings Account");
                    System.out.println("2. Current Account");
                    System.out.print("Choose account type: ");
                    int type = sc.nextInt();
                    sc.nextLine();

                    Account account;

                    if (type == 1) {
                        account = new SavingsAccount(
                                accountNumber, name, balance);
                    } else {
                        account = new CurrentAccount(
                                accountNumber, name, balance);
                    }

                    bank.createAccount(account);
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    accountNumber = sc.nextLine();

                    Account depositAccount = bank.findAccount(accountNumber);

                    if (depositAccount != null) {
                        System.out.print("Enter deposit amount: ");
                        double amount = sc.nextDouble();
                        sc.nextLine();

                        depositAccount.deposit(amount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    accountNumber = sc.nextLine();

                    Account withdrawAccount = bank.findAccount(accountNumber);

                    if (withdrawAccount != null) {
                        System.out.print("Enter withdrawal amount: ");
                        double amount = sc.nextDouble();
                        sc.nextLine();

                        withdrawAccount.withdraw(amount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter account number: ");
                    accountNumber = sc.nextLine();

                    bank.viewBalance(accountNumber);
                    break;

                case 5:
                    running = false;
                    System.out.println("Thank you for using the Banking App!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}