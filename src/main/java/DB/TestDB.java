package DB;

import csku.transaction.TransactionDB;

import java.util.ArrayList;

public class TestDB {
    public static void main(String[] args) {
        try {
            DatabaseConnector db = new DatabaseConnector();
//
//            db.insertTransaction("test","t","17-07-1997",100.25f);
//            db.insertTransaction("test2","exx","17-07-1997",200.25f);

//            db.deleteTransaction("test","exx","17-07-1997",100.25f);
            db.deleteTransactionALL();


            ArrayList<TransactionDB> t = db.getTransactionByType("exx");
            for(TransactionDB i:t){
                System.out.println( i.toString());
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
