package com.albert.bankManagementSystem;

import com.albert.bankManagementSys.Account;
import com.albert.bankManagementSys.SavingsAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountTest {

    private Account account;

    @BeforeEach
    void setUp(){
        account = new SavingsAccount(1, "Alice", 1000, 5);
    }

    @Test
    void depositShouldIncreaseBalance(){
        account.deposit(500);
        assertEquals(1500, account.getBalance(), 0.01);
    }

    @Test
    void withdrawShouldDecreaseBalance(){
        account.withdraw(500);
        assertEquals(500, account.getBalance(), 0.01);
    }

    @Test
    void withdrawMoreThanBalanceShouldThrow(){
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(5000));
    }

    @Test
    void withdrawNegativeAmountShouldThrow(){
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-50));
    }

    @Test
    void withdrawZeroShouldDoNothing(){
        account.withdraw(0);
        assertEquals(1000, account.getBalance());
    }


}
