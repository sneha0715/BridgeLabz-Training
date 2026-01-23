import java.util.*;

class BankAccount implements Comparable<BankAccount> {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public String getAccountHolder() {
        return accountHolder;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void deposit(double amount) {
        this.balance += amount;
    }
    
    public boolean withdraw(double amount) {
        if (amount <= balance) {
            this.balance -= amount;
            return true;
        }
        return false;
    }
    
    @Override
    public int compareTo(BankAccount other) {
        return Double.compare(other.balance, this.balance);
    }
    
    @Override
    public String toString() {
        return "Account{" +
                "Number='" + accountNumber + '\'' +
                ", Holder='" + accountHolder + '\'' +
                ", Balance=" + balance +
                '}';
    }
}

class WithdrawalRequest {
    private String accountNumber;
    private double amount;
    private long timestamp;
    
    public WithdrawalRequest(String accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.timestamp = System.currentTimeMillis();
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public long getTimestamp() {
        return timestamp;
    }
    
    @Override
    public String toString() {
        return "WithdrawalRequest{" +
                "Account='" + accountNumber + '\'' +
                ", Amount=" + amount +
                '}';
    }
}

public class BankingSystem {
    private HashMap<String, BankAccount> accounts;
    private Queue<WithdrawalRequest> withdrawalQueue;
    
    public BankingSystem() {
        this.accounts = new HashMap<>();
        this.withdrawalQueue = new LinkedList<>();
    }
    
    public void createAccount(String accountNumber, String accountHolder, double initialBalance) {
        if (!accounts.containsKey(accountNumber)) {
            accounts.put(accountNumber, new BankAccount(accountNumber, accountHolder, initialBalance));
            System.out.println("Account created successfully");
        } else {
            System.out.println("Account already exists");
        }
    }
    
    public BankAccount getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }
    
    public void deposit(String accountNumber, double amount) {
        BankAccount account = accounts.get(accountNumber);
        if (account != null) {
            account.deposit(amount);
            System.out.println("Deposit successful. New balance: " + account.getBalance());
        } else {
            System.out.println("Account not found");
        }
    }
    
    public void requestWithdrawal(String accountNumber, double amount) {
        BankAccount account = accounts.get(accountNumber);
        if (account != null) {
            withdrawalQueue.add(new WithdrawalRequest(accountNumber, amount));
            System.out.println("Withdrawal request added to queue");
        } else {
            System.out.println("Account not found");
        }
    }
    
    public void processWithdrawal() {
        if (withdrawalQueue.isEmpty()) {
            System.out.println("No pending withdrawal requests");
            return;
        }
        
        WithdrawalRequest request = withdrawalQueue.remove();
        BankAccount account = accounts.get(request.getAccountNumber());
        
        if (account != null) {
            if (account.withdraw(request.getAmount())) {
                System.out.println("Withdrawal processed: " + request);
                System.out.println("New balance: " + account.getBalance());
            } else {
                System.out.println("Insufficient funds for withdrawal");
                withdrawalQueue.add(request);
            }
        }
    }
    
    public void displayAllAccounts() {
        System.out.println("=== All Accounts ===");
        for (BankAccount account : accounts.values()) {
            System.out.println(account);
        }
    }
    
    public void displayAccountsSortedByBalance() {
        System.out.println("=== Accounts Sorted by Balance (High to Low) ===");
        List<BankAccount> sortedAccounts = new ArrayList<>(accounts.values());
        Collections.sort(sortedAccounts);
        for (BankAccount account : sortedAccounts) {
            System.out.println(account);
        }
    }
    
    public void displayPendingWithdrawals() {
        System.out.println("=== Pending Withdrawal Requests ===");
        if (withdrawalQueue.isEmpty()) {
            System.out.println("No pending requests");
        } else {
            for (WithdrawalRequest request : withdrawalQueue) {
                System.out.println(request);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankingSystem bank = new BankingSystem();
        
        bank.createAccount("ACC001", "Alice Johnson", 50000);
        bank.createAccount("ACC002", "Bob Smith", 30000);
        bank.createAccount("ACC003", "Carol Davis", 75000);
        bank.createAccount("ACC004", "David Wilson", 20000);
        
        boolean running = true;
        while (running) {
            System.out.println("=== Banking System ===");
            System.out.println("1. Create account");
            System.out.println("2. Deposit money");
            System.out.println("3. Request withdrawal");
            System.out.println("4. Process withdrawal");
            System.out.println("5. View account");
            System.out.println("6. Display all accounts");
            System.out.println("7. Display accounts sorted by balance");
            System.out.println("8. Display pending withdrawals");
            System.out.println("9. Exit");
            System.out.println("Enter choice:");
            
            int choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.println("Enter account number:");
                    String accNum = sc.nextLine();
                    System.out.println("Enter account holder name:");
                    String holder = sc.nextLine();
                    System.out.println("Enter initial balance:");
                    double initialBalance = sc.nextDouble();
                    bank.createAccount(accNum, holder, initialBalance);
                    break;
                case 2:
                    System.out.println("Enter account number:");
                    String depAccNum = sc.nextLine();
                    System.out.println("Enter amount to deposit:");
                    double depAmount = sc.nextDouble();
                    bank.deposit(depAccNum, depAmount);
                    break;
                case 3:
                    System.out.println("Enter account number:");
                    String withAccNum = sc.nextLine();
                    System.out.println("Enter withdrawal amount:");
                    double withAmount = sc.nextDouble();
                    bank.requestWithdrawal(withAccNum, withAmount);
                    break;
                case 4:
                    bank.processWithdrawal();
                    break;
                case 5:
                    System.out.println("Enter account number:");
                    String viewAccNum = sc.nextLine();
                    BankAccount account = bank.getAccount(viewAccNum);
                    if (account != null) {
                        System.out.println(account);
                    } else {
                        System.out.println("Account not found");
                    }
                    break;
                case 6:
                    bank.displayAllAccounts();
                    break;
                case 7:
                    bank.displayAccountsSortedByBalance();
                    break;
                case 8:
                    bank.displayPendingWithdrawals();
                    break;
                case 9:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        
        sc.close();
    }
}
