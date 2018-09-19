package csku.transaction;


import java.util.ArrayList;

public class Balance {

    int balance;
    ArrayList<Integer> lstIncome = new ArrayList<Integer>();
    ArrayList<Integer> lstExpense = new ArrayList<Integer>();
    int income,expense;

    public Balance(int balance){
        this.balance = balance;
    }

    public int getBalance() {
        return totalIncomeExpense("income")-totalIncomeExpense("expense");
    }

    public void income(int data) {
        this.lstIncome.add(data);
    }
    public void expense(int data) {
        this.lstExpense.add(data);
    }

    public int totalIncomeExpense(String data){
        if(data.equals("income")){
        income = 0;
            for(int i:lstIncome){
                income+=i;

            }
            return income;
        }else{
            expense=0;
            for(int i:lstExpense){
                expense+=i;

            }
            return expense;
        }
    }

    public void editLstBalance(String type,int index,int data){
        if(type.equals("income")){
            lstIncome.set(index,data);
        }
        else{
            lstExpense.set(index,data);
        }
    }


}
