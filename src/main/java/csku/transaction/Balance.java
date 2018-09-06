package csku.transaction;


public class Balance {

    int balance;

    public Balance(int balance){
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void income(int balance) {
        this.balance += balance;
    }
    public void expense(int balance) {
        this.balance -= balance;
    }

}
