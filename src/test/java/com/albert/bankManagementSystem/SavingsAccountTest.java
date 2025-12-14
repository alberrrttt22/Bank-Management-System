package com.albert.bankManagementSystem;

import com.albert.bankManagementSys.SavingsAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SavingsAccountTest {
    private SavingsAccount account;

    @BeforeEach
    void setUp(){
        account = new SavingsAccount(1, "Alice", 100,5);
    }

    @Test
    void interestShouldBeAdded(){
        account.addInterest();
        assertEquals(105, account.getBalance());
    }
}
