package csku.transaction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTestNote {
    Transaction transaction,editTransaction;
    Note note;

    @BeforeEach
    void init() {
        note = new Note();
        transaction = new Transaction("Mom give me", Transaction.TRANSACTION_TYPE.INCOME,2000);
        editTransaction = new Transaction("Dad give me", Transaction.TRANSACTION_TYPE.INCOME,20);
    }

    @Test
    void testIncome() {
        note.setLst_note(transaction,"income");
        assertEquals(transaction.toString(),note.getLst_Note().get(0).toString());
    }

    @Test
    void testEditLst_note(){
        note.setLst_note(transaction,"income");
        note.editLst_note(0,editTransaction);
        assertEquals(editTransaction.toString(),note.getLst_Note().get(0).toString());
    }


}
