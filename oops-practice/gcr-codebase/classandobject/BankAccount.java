class BankAccount {
    String accountHolder;
    long accountNumber;
    double balance;

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Amount Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount");
        }
    }

    void displayBalance() {
        System.out.println("Current Balance: " + balance);
        System.out.println();
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        account.accountHolder = "Rohan";
        account.accountNumber = 1234567890;
        account.balance = 10000.0;

        System.out.println("Account Holder: " + account.accountHolder);
        System.out.println("Account Number: " + account.accountNumber);
        account.displayBalance();

        account.deposit(5000);
        account.displayBalance();

        account.withdraw(3000);
        account.displayBalance();

        account.withdraw(15000); 
    }
}
