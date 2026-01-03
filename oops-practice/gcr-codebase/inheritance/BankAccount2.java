class BankAccount2 {
    int accountNumber;
    double balance;

    BankAccount2(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void displayAccountType() {
        System.out.println("Bank Account");
    }

    void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}
class SavingsAccount extends BankAccount2 {
    double interestRate;

    SavingsAccount(int accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    @Override
    void displayAccountType() {
        System.out.println("Savings Account");
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Interest Rate: " + interestRate);
    }
}


class CheckingAccount extends BankAccount2 {
    double withdrawalLimit;

    CheckingAccount(int accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    @Override
    void displayAccountType() {
        System.out.println("Checking Account");
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Withdrawal Limit: " + withdrawalLimit);
    }
}



class FixedDepositAccount extends BankAccount2 {
    int tenure;

    FixedDepositAccount(int accountNumber, double balance, int tenure) {
        super(accountNumber, balance);
        this.tenure = tenure;
    }

    @Override
    void displayAccountType() {
        System.out.println("Fixed Deposit Account");
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Tenure: " + tenure);
    }
}

