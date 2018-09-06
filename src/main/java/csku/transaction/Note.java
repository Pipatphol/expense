package csku.transaction;

import java.util.ArrayList;

public class Note {
    ArrayList<Transaction> lst_note = new ArrayList<Transaction>();

    public ArrayList<Transaction> getLst_Note() {
        return lst_note;
    }



    public void setLst_note(Transaction lst_note) {
        this.lst_note.add(lst_note);
    }

}
