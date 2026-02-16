package com.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    public void Test_Deposit_ValidAmount() {
        BankAccount account = new BankAccount(1000);

        account.deposit(500);

        assertEquals(1500, account.getBalance());
    }

    @Test
    public void Test_Deposit_NegativeAmount() {
        BankAccount account = new BankAccount(1000);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-200);
        });

        assertEquals("Deposit amount cannot be negative", exception.getMessage());
    }

    @Test
    public void Test_Withdraw_ValidAmount() {
        BankAccount account = new BankAccount(1000);

        account.withdraw(400);

        assertEquals(600, account.getBalance());
    }

    @Test
    public void Test_Withdraw_InsufficientFunds() {
        BankAccount account = new BankAccount(500);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(1000);
        });

        assertEquals("Insufficient funds.", exception.getMessage());
    }
}
