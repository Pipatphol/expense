package csku.transaction;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
    String detail,type,date;
    int amount;
    enum TRANSACTION_TYPE { INCOME, EXPENSE };
    Date timeStamp = new Date();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");


    public Transaction(String detail,TRANSACTION_TYPE TYPE,int amount){
        this.detail = detail;
        this.type = TYPE+"";
        this.amount = amount;
        this.date = simpleDateFormat.format(timeStamp);
    }

    public String toStringTxtForSave(String index){
        return (index+"/"+this.type+"/"+ this.detail+"/"+this.amount+"/"+this.date);
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return ("Type: "+this.type+" | Detail: "+ this.detail+" | Amount: "+this.amount+" | Date: "+this.date);
    }
}
