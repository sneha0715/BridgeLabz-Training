
class BankAccount {
    private final String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }


    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Withdrawal failed! Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
        }
    }


    public void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }
}

public class BankAccountManager {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("ACC101", 5000);
        System.out.println("===== Bank Account Operations =====");
        account.checkBalance();
        account.deposit(2000);
        account.checkBalance();
        account.withdraw(3000);
        account.checkBalance();
        account.withdraw(6000); 
    }
}
