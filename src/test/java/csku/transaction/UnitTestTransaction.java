package csku.transaction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class UnitTestTransaction {

    Transaction transaction1,transaction2;
    Date date;
    @BeforeEach
    void init() {
        date = new Date();
        transaction1 = new Transaction("Mom give me", Transaction.TRANSACTION_TYPE.INCOME,2000);
        transaction2 = new Transaction("Milk",Transaction.TRANSACTION_TYPE.EXPENSE,2000);
    }

    @Test
    void testIncomeToString() {
        assertEquals("Type: INCOME | Detail: Mom give me | Amount: 2000 | Date: "+date.toString(), transaction1.toString());

    }

    @Test
    void testExpenseToString() {
        assertEquals("Type: EXPENSE | Detail: Milk | Amount: 2000 | Date: "+date.toString(), transaction2.toString());
    }
//    @Test
//    @DisplayName("throws NotEnoughBalanceException when withdraw more than balance")
//    void testWithdrawMoreThanBalance() {
//        assertThrows(NotEnoughBalanceException.class,
//                () -> account.withdraw(10000));
//        assertEquals(initialBalance, account.getBalance());
//    }
}
