package csku.transaction;

import java.util.ArrayList;

public class Note {
    ArrayList<Transaction> lst_note = new ArrayList<Transaction>();
    ArrayList<Integer> lst_index = new ArrayList<Integer>();
    int indexIncome = 0;
    int indexExpense = 0;

    public ArrayList<Transaction> getLst_Note() {
        return lst_note;
    }

    public int getLst_index(int index) {
        return lst_index.get(index-1);
    }

    public void setLst_note(Transaction lst_note, String type) {
        this.lst_note.add(lst_note);
        if(type.equals("income")){
            this.lst_index.add(indexIncome);
            indexIncome++;
        }
        else {
            this.lst_index.add(indexExpense);
            indexExpense++;
        }
    }

    public void editLst_note(int index,Transaction data){
        lst_note.set(index, data);
    }


}
