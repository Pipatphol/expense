package csku.transaction;


import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.jupiter.api.Assertions.*;

public class StepDefExpense {
    Balance balance;
    Note note;



    @Before
    public void init() {
        balance = new Balance(0);
        note = new Note();

    }

    @When("I record income is in with detail is by (.*) amount (\\d+) baht")
    public void i_record_income_is_in (String detail, int amount){
        note.setLst_note(new Transaction(detail, Transaction.TRANSACTION_TYPE.INCOME,amount),"income");
        balance.income(amount);
    }
    @When("I record expense is in with detail is by (.*) amount (\\d+) baht")
    public void i_record_expense_is_in (String detail, int amount){
        note.setLst_note(new Transaction(detail, Transaction.TRANSACTION_TYPE.EXPENSE,amount),"expense");
        balance.expense(amount);
    }
    @When("I edit icome id (\\d+) with detail is (.*) and amount is (\\d+) exists")
    public void i_edit_income_by_id (int id,String detail,int amount){
        int index = note.getLst_index(id);
        note.editLst_note(id-1,new Transaction(detail, Transaction.TRANSACTION_TYPE.INCOME, amount));
        balance.editLstBalance("income",index,amount);
    }
    @When("I edit expense id (\\d+) with detail is (.*) and amount is (\\d+) exists")
    public void i_edit_expense_by_id (int id,String detail,int amount){
        int index = note.getLst_index(id);
        note.editLst_note(id-1,new Transaction(detail, Transaction.TRANSACTION_TYPE.EXPENSE, amount));
        balance.editLstBalance("expense",index,amount);
    }


    @Then("total is (\\d+)")
    public void total_is(int total) {
        assertEquals(total,balance.getBalance());
    }
    @Then("total is -(\\d+)")
    public void total_is_negative_value(int total) {
        assertEquals(total,balance.getBalance()*-1);
    }



}
