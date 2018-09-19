package csku.transaction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTestBalance {
    Balance balance;

    @BeforeEach
    void init() {
        balance = new Balance(0);
    }

    @org.junit.jupiter.api.Test
    void testIncome() {
        balance.income(200);
        assertEquals(200,balance.getBalance());
    }

    @Test
    void testExpense() {
        balance.expense(200);
        assertEquals(-200,balance.getBalance());
    }

    @Test
    void testgetBalance() {
        assertEquals(0,balance.getBalance());
    }

    @Test
    void editLstBalance(){
        balance.income(200);
        balance.expense(200);
        assertEquals(0,balance.getBalance());


    }
}
