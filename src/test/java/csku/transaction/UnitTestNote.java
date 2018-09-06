package csku.transaction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTestNote {
    Transaction transaction;
    Note note;

    @BeforeEach
    void init() {
        note = new Note();
        transaction = new Transaction("Mom give me", Transaction.TRANSACTION_TYPE.INCOME,2000);
    }

    @Test
    void testIncome() {
        note.setLst_note(transaction);
        assertEquals(transaction.toString(),note.getLst_Note().get(0).toString());
    }


}
