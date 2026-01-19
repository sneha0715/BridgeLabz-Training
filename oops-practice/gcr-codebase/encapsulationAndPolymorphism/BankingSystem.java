package encapsulationAndPolymorphism;
import java.util.*;

public class BankingSystem {

    public static void main(String[] args) {

        List<BankAccount> accounts = new ArrayList<>();

        accounts.add(new SavingsAccount("SA101", "Sneha", 50000));
        accounts.add(new CurrentAccount("CA202", "Rahul", 100000));

        for (BankAccount acc : accounts) {

            acc.displayAccountDetails();
            acc.deposit(5000);
            acc.withdraw(3000);

            System.out.println("Interest: " + acc.calculateInterest());

            if (acc instanceof Loanable) {
                Loanable loan = (Loanable) acc;
                loan.applyForLoan();
                System.out.println("Loan Eligibility: " +
                        loan.calculateLoanEligibility());
            }

        }
    }
}

abstract class BankAccount {

    private String accountNumber;   
    private String holderName;     
    protected double balance;      

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }


    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public abstract double calculateInterest();

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + holderName);
        System.out.println("Balance: " + balance);
    }
}

interface Loanable {
    void applyForLoan();
    double calculateLoanEligibility();
}

class SavingsAccount extends BankAccount implements Loanable {

    private static final double INTEREST_RATE = 0.04; 

    public SavingsAccount(String accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    public double calculateInterest() {
        return balance * INTEREST_RATE;
    }

    @Override
    public void applyForLoan() {
        System.out.println("Loan applied under Savings Account");
    }

    @Override
    public double calculateLoanEligibility() {
        return balance * 2; // eligible up to 2x balance
    }
}

class CurrentAccount extends BankAccount implements Loanable {

    private static final double INTEREST_RATE = 0.02; // 2%

    public CurrentAccount(String accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    public double calculateInterest() {
        return balance * INTEREST_RATE;
    }

    @Override
    public void applyForLoan() {
        System.out.println("Loan applied under Current Account");
    }

    @Override
    public double calculateLoanEligibility() {
        return balance * 3; 
    }
}
