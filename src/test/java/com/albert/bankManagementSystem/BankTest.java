package com.albert.bankManagementSystem;

import com.albert.bankManagementSys.Account;
import com.albert.bankManagementSys.Bank;
import com.albert.bankManagementSys.SavingsAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {

    @Test
    void addAccountShouldStoreAccount(){
        Bank bank = new Bank();
        Account acc = new SavingsAccount(1, "Alice", 100, 5);
        bank.addAccount(acc);
        assertEquals(acc, bank.findAccount(1));
    }

    @Test
    void findNonExistingAccountShouldReturnNull(){
        Bank bank = new Bank();
        assertNull(bank.findAccount(123));
    }

    @Test
    void transferFundShouldMoveMoney(){
        Bank bank = new Bank();
        Account firstAcc = new SavingsAccount(1, "Alice", 100, 5);
        Account secondAcc = new SavingsAccount(2, "Bob", 200, 4);
        bank.addAccount(firstAcc);
        bank.addAccount(secondAcc);

        bank.transferFund(1, 2, 50);
        assertEquals(50, firstAcc.getBalance());
        assertEquals(250, secondAcc.getBalance());
    }

    @Test
    void transferFundShouldThrowIfInsufficient(){
        Bank bank = new Bank();
        Account firstAcc = new SavingsAccount(1, "Alice", 100, 5);
        Account secondAcc = new SavingsAccount(2, "Bob", 200, 4);
        bank.addAccount(firstAcc);
        bank.addAccount(secondAcc);

        assertThrows(IllegalArgumentException.class, () -> bank.transferFund(1, 2, 1000));

    }
}
