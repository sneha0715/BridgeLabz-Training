import java.util.*;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String msg) {
        super(msg);
    }
}

interface TransferService {
    void transfer(Wallet from, Wallet to, double amount) throws InsufficientBalanceException;
}

class WalletTransfer implements TransferService {
    public void transfer(Wallet from, Wallet to, double amount) throws InsufficientBalanceException {
        from.withdraw(amount);
        to.addMoney(amount);
        System.out.println("Wallet to Wallet transfer successful");
    }
}

class BankTransfer implements TransferService {
    public void transfer(Wallet from, Wallet to, double amount) throws InsufficientBalanceException {
        from.withdraw(amount + 10);
        to.addMoney(amount);
        System.out.println("Bank transfer successful (₹10 charge applied)");
    }
}

class User {
    int id;
    String name;

    User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Transaction {
    String type;
    double amount;

    Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }
}

class Wallet {
    User user;
    double balance;
    List<Transaction> history = new ArrayList<>();

    Wallet(User user) {
        this.user = user;
        this.balance = 0;
    }

    void addMoney(double amount) {
        balance += amount;
        history.add(new Transaction("Add", amount));
    }

    void withdraw(double amount) throws InsufficientBalanceException {
        if (balance < amount) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        balance -= amount;
        history.add(new Transaction("Withdraw", amount));
    }

    void showHistory() {
        System.out.println("\nTransaction History of " + user.name);
        for (Transaction t : history) {
            System.out.println(t.type + " : ₹" + t.amount);
        }
        System.out.println("Current Balance: ₹" + balance);
    }
}

public class DigitalWalletSystem {
    public static void main(String[] args) {

        User u1 = new User(1, "Sneha");
        User u2 = new User(2, "Amit");

        Wallet w1 = new Wallet(u1);
        Wallet w2 = new Wallet(u2);

        w1.addMoney(1000);

        TransferService walletTransfer = new WalletTransfer();
        TransferService bankTransfer = new BankTransfer();

        try {
            walletTransfer.transfer(w1, w2, 300);
            bankTransfer.transfer(w1, w2, 200);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }

        w1.showHistory();
        w2.showHistory();
    }
}
