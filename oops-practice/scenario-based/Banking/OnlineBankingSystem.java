import java.util.ArrayList;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

interface BankService {
    void deposit(double amount);
    void withdraw(double amount) throws InsufficientBalanceException;
    double calculateInterest();
}

abstract class AccountBank implements BankService {
    protected double balance;
    protected ArrayList<String> transactionHistory = new ArrayList<>();
    AccountBank(double balance) {
        this.balance = balance;
    }
    @Override
    public synchronized void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposited: ₹" + amount);
        System.out.println("Deposited ₹" + amount);
    }
    @Override
    public synchronized void withdraw(double amount) throws InsufficientBalanceException {
        if (balance < amount) {
            throw new InsufficientBalanceException("Insufficient balance.");
        }
        balance -= amount;
        transactionHistory.add("Withdrawn: ₹" + amount);
        System.out.println("Withdrawn ₹" + amount);
    }
    public double getBalance() {
        return balance;
    }
}

class SavingsAccount extends AccountBank {
    SavingsAccount(double balance) {
        super(balance);
    }
    @Override
    public double calculateInterest() {
        return balance * 0.04;
    }
}

class CurrentAccount extends AccountBank {
    CurrentAccount(double balance) {
        super(balance);
    }
    @Override
    public double calculateInterest() {
        return balance * 0.02;
    }
}

class FundTransfer extends Thread {
    AccountBank from;
    AccountBank to;
    double amount;
    FundTransfer(AccountBank from, AccountBank to, double amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }
    @Override
    public void run() {
        try {
            synchronized (AccountBank.class) {
                from.withdraw(amount);
                to.deposit(amount);
                System.out.println("Transferred ₹" + amount);
            }
        } catch (InsufficientBalanceException e) {
            System.out.println("Transfer Failed: " + e.getMessage());
        }
    }
}

public class OnlineBankingSystem {
    public static void main(String[] args) {
        AccountBank savings = new SavingsAccount(5000);
        AccountBank current = new CurrentAccount(3000);
        System.out.println("Savings Interest: ₹" + savings.calculateInterest());
        System.out.println("Current Interest: ₹" + current.calculateInterest());
        FundTransfer t1 = new FundTransfer(savings, current, 1000);
        FundTransfer t2 = new FundTransfer(current, savings, 500);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
        System.out.println("Final Savings Balance: ₹" + savings.getBalance());
        System.out.println("Final Current Balance: ₹" + current.getBalance());
    }
}
