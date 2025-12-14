package com.albert.bankManagementSystem;

import com.albert.bankManagementSys.Account;
import com.albert.bankManagementSys.CurrentAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CurrentAccountTest {

    private Account account;

    @BeforeEach
    void setUp(){
        account = new CurrentAccount(2, "Bob", 200, 500);
    }

    @Test
    void withdrawWithinOverdraftShouldWork(){
        account.withdraw(500);
        assertEquals(-300, account.getBalance());
    }

    @Test
    void withdrawBeyondOverdraftShouldThrow(){
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(800));
    }

}
