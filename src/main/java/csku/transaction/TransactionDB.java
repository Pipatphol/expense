package csku.transaction;

public class TransactionDB {
    String detail,type,date;
    float amount;

    public TransactionDB(String detail, String type, String date, float amount) {
        this.detail = detail;
        this.type = type;
        this.date = date;
        this.amount = amount;
    }

    public float getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return ("Type: "+this.type+" | Detail: "+ this.detail+" | Amount: "+this.amount+" | Date: "+this.date);
    }
}
