
public class CurrentAccount extends Account {

    private double overdraftLimit = 5000;

    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance + overdraftLimit) {
            balance -= amount;
            System.out.println("Withdrawal successful!");
        } else {
            System.out.println("Withdrawal limit exceeded.");
        }
    }
}