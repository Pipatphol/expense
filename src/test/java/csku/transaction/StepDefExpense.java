package csku.transaction;


import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.jupiter.api.Assertions.*;

public class StepDefExpense {
//    Transaction transaction;
    Balance balance ;
    Note note;



    @Before
    public void init() {
        balance = new Balance(0);
        note = new Note();
//        transaction = new Transaction("Mom", Transaction.TRANSACTION_TYPE.INCOME,2000);
    }

    @When("I record income is in with  with detail is (.*) amount (.*) baht")
    public void i_record_income_is_in (String detail, int amount){
        note.setLst_note(new Transaction(detail, Transaction.TRANSACTION_TYPE.INCOME,amount));
        balance.income(amount);
    }

    @When("I record expense is in with  with detail is (.*) amount (.*) baht")
    public void i_record_expense_is_in (String detail, int amount){
        note.setLst_note(new Transaction(detail, Transaction.TRANSACTION_TYPE.EXPENSE,amount));
        balance.expense(amount);
    }

    @Then("total is (.*)")
    public void total_is(int total) {
        assertEquals(total,balance.getBalance());
    }

}
