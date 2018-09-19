package csku.transaction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        boolean program = true;
        Balance balance = new Balance(0);
        Note note = new Note();
        int index;

        while (program) {
            System.out.println("Program EXPENSE INCOME,");
            System.out.print("Add List select 1 | Show List select 2 | Edit List select 3 |Exit Program select 4 : ");
            int input1 = Integer.parseInt(br.readLine());
            System.out.println("-----------------------------------------------------------------");
            //Add
            if(input1 == 1){
                while (true){
                    System.out.println("Add EXPENSE or INCOME");
                    System.out.print("Add INCOME select 1 | Add EXPENSE select 2 | Exit select 3 : ");
                    int inputAdd = Integer.parseInt(br.readLine());
                    System.out.println("-----------------------------------------------------------------");
                    //income
                    if(inputAdd == 1){
                        while (true) {
                            System.out.println("Add INCOME");
                            System.out.print("1.Detail : ");
                            String income1 = br.readLine();

                            System.out.print("2.Amount : ");
                            int income2 = Integer.parseInt(br.readLine());
                            if (income1.length() > 0 && income2 != 0) {
                                note.setLst_note(new Transaction(income1, Transaction.TRANSACTION_TYPE.INCOME, income2),"income");
//                                System.out.println(note.getLst_Note().get(0).toString());
                                balance.income(income2);
//                                System.out.println(balance.getBalance());
                                System.out.println("-----------------------------------------------------------------");
                                break;
                            }
                            else {
                                System.out.println("Error");
                                System.out.println("-----------------------------------------------------------------");
                            }
                        }
                    }
                    //expense
                    else if(inputAdd == 2){
                        while (true) {
                            System.out.println("Add EXPENSE");
                            System.out.print("1.Detail : ");
                            String expense1 = br.readLine();

                            System.out.print("2.Amount : ");
                            int expense2 = Integer.parseInt(br.readLine());
                            if (expense1.length() > 0 && expense2 != 0) {
                                note.setLst_note(new Transaction(expense1, Transaction.TRANSACTION_TYPE.EXPENSE, expense2),"expense");
//                                System.out.println(note.getLst_Note().get(0).toString());
                                balance.expense(expense2);
//                                System.out.println(balance.getBalance());
                                System.out.println("-----------------------------------------------------------------");
                                break;
                            }
                            else {
                                System.out.println("Error");
                                System.out.println("-----------------------------------------------------------------");
                            }
                        }
                    }
                    else if(inputAdd == 3){
                        break;
                    }
                    else{
                        System.out.println(".: Number Wrong :.");
                        System.out.println("-----------------------------------------------------------------");
                    }
                }
            }
            //Show List
            else if(input1 == 2){
                    if(note.getLst_Note().size()==0){
                        System.out.println(".: Not have List EXPENSE INCOME:.");
                        System.out.println("-----------------------------------------------------------------");
                    }
                    else{
                        System.out.println(".: List INCOME and EXPENSE :.");
                        for(int i =0;i<note.getLst_Note().size();i++){
                            System.out.println((i+1)+": "+note.getLst_Note().get(i).toString());
                        }
                        System.out.printf("Total Amount: %d",balance.getBalance());
                        System.out.println();
                        System.out.println("-----------------------------------------------------------------");
                    }
            }
            // Edit
            else if(input1 == 3){
                if(note.getLst_Note().size()==0){
                    System.out.println(".: Not have List EXPENSE INCOME:.");
                    System.out.println("-----------------------------------------------------------------");
                }
                else {
                    while (true){
                        System.out.println("Edit EXPENSE or INCOME");
                        System.out.print("Edit INCOME select 1 | Edit EXPENSE select 2 | Exit select 3 : ");
                        int inputEdit = Integer.parseInt(br.readLine());
                        System.out.println("-----------------------------------------------------------------");
                        //edit income
                        if(inputEdit == 1){
                            while (true) {
                                System.out.println("Edit INCOME");
                                System.out.print("1.Index : ");
                                int income0 = Integer.parseInt(br.readLine());
                                System.out.print("2.Detail : ");
                                String income1 = br.readLine();

                                System.out.print("3.Amount : ");
                                int income2 = Integer.parseInt(br.readLine());
                                if (income1.length() > 0 && income2 != 0) {
                                    index = note.getLst_index(income0);
                                    note.editLst_note(income0-1,new Transaction(income1, Transaction.TRANSACTION_TYPE.INCOME, income2));
                                    balance.editLstBalance("income",index,income2);
//                                System.out.println(balance.getBalance());
                                    System.out.println("-----------------------------------------------------------------");
                                    break;
                                }
                                else {
                                    System.out.println("Error");
                                    System.out.println("-----------------------------------------------------------------");
                                }
                            }
                        }
                        //edit expense
                        else if(inputEdit == 2){
                            while (true) {
                                System.out.println("Add EXPENSE");
                                System.out.print("1.Index : ");
                                int expense0 = Integer.parseInt(br.readLine());
                                System.out.print("1.Detail : ");
                                String expense1 = br.readLine();

                                System.out.print("2.Amount : ");
                                int expense2 = Integer.parseInt(br.readLine());
                                if (expense1.length() > 0 && expense2 != 0) {
                                    index = note.getLst_index(expense0);
                                    note.editLst_note(expense0-1,new Transaction(expense1, Transaction.TRANSACTION_TYPE.EXPENSE, expense2));
                                    balance.editLstBalance("expense",index,expense2);
//                                System.out.println(balance.getBalance());
                                    System.out.println("-----------------------------------------------------------------");
                                    break;
                                }
                                else {
                                    System.out.println("Error");
                                    System.out.println("-----------------------------------------------------------------");
                                }
                            }
                        }
                        else if(inputEdit == 3){
                            break;
                        }
                        else{
                            System.out.println(".: Number Wrong :.");
                            System.out.println("-----------------------------------------------------------------");
                        }
                    }

                }
            }
            else if(input1 == 4){
                program = false;
                System.out.println(".: Exit :.");
                System.out.println("-----------------------------------------------------------------");
            }
            else{
                System.out.println(".: Select New Number :.");
                System.out.println("-----------------------------------------------------------------");
            }


        }
    }
}
