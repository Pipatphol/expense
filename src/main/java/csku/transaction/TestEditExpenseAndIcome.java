package csku.transaction;

import java.io.BufferedReader;


public class TestEditExpenseAndIcome {
    public static void main(String[] args) {
        Balance balance = new Balance(0);
        String d = "mon";
        int b = 200;
        String d1 = "milk";
        int b1 = 200;
        Note note = new Note();
        //------------------------------------------------------------------------------------------
        note.setLst_note(new Transaction(d, Transaction.TRANSACTION_TYPE.INCOME, b),"income");
        System.out.println(note.getLst_Note().get(0).toString());
        balance.income(b);
//        System.out.println(balance.getBalance());

        note.setLst_note(new Transaction(d1, Transaction.TRANSACTION_TYPE.EXPENSE, b1),"expense");
        System.out.println(note.getLst_Note().get(1).toString());
        balance.expense(b1);
//        System.out.println(balance.getBalance());
        note.setLst_note(new Transaction("5555", Transaction.TRANSACTION_TYPE.EXPENSE, 300),"expense");
        System.out.println(note.getLst_Note().get(2).toString());
        balance.expense(300);

        //-----------------------------------------------------------------------------------------------
        System.out.println(".: List INCOME and EXPENSE :.");
        for(int i =0;i<note.getLst_Note().size();i++){
            System.out.println((i+1)+": "+note.getLst_Note().get(i).toString());
        }
        System.out.printf("Total Amount: %d",balance.getBalance());
        int index = note.getLst_index(1);
        note.editLst_note(1-1,new Transaction("dad", Transaction.TRANSACTION_TYPE.INCOME, 500));
        balance.editLstBalance("income",index,500);
        System.out.println("");
        //-----------------------------------------------------------------------------------------------
        System.out.println(".: List INCOME and EXPENSE :.");
        for(int i =0;i<note.getLst_Note().size();i++){
            System.out.println((i+1)+": "+note.getLst_Note().get(i).toString());
        }
        System.out.printf("Total Amount: %d",balance.getBalance());
        index = note.getLst_index(2);
        note.editLst_note(2-1,new Transaction("mandm", Transaction.TRANSACTION_TYPE.EXPENSE, 450));
        balance.editLstBalance("expense",index,450);
        System.out.println("");
        //-----------------------------------------------------------------------------------------------
        System.out.println(".: List INCOME and EXPENSE :.");
        for(int i =0;i<note.getLst_Note().size();i++){
            System.out.println((i+1)+": "+note.getLst_Note().get(i).toString());
        }
        System.out.printf("Total Amount: %d",balance.getBalance());

        index = note.getLst_index(3);
        note.editLst_note(3-1,new Transaction("mandm", Transaction.TRANSACTION_TYPE.EXPENSE, 10));
        balance.editLstBalance("expense",index,10);
        System.out.println("");
//-----------------------------------------------------------------------------------------------
        System.out.println(".: List INCOME and EXPENSE :.");
        for(int i =0;i<note.getLst_Note().size();i++){
            System.out.println((i+1)+": "+note.getLst_Note().get(i).toString());
        }
        System.out.printf("Total Amount: %d",balance.getBalance());



    }
}
