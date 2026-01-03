public class BankSystem {
    public static void main(String[] args) {

        BankAccount2[] accounts = {
            new SavingsAccount(101, 5000.0, 4.5),
            new CheckingAccount(102, 8000.0, 2000.0),
            new FixedDepositAccount(103, 20000.0, 5)
        };

        for (BankAccount2 acc : accounts) {
            acc.displayAccountType();
            acc.displayDetails();
        }
    }
}
