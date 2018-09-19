package csku.transaction;

import java.io.*;
import java.util.ArrayList;

public class SaveAndEditFileTxt {


    public void createFile(ArrayList<Transaction> transactions,String total) throws IOException {
        ArrayList<String> lst = new ArrayList<String>();
        String text = ".: List INCOME and EXPENSE :.";
        String text2 ="ID/Type/Detail/Amount/Date";
        BufferedWriter output = null;
        for(int i = 0;i<transactions.size();i++){
            lst.add(transactions.get(i).toStringTxtForSave((i+1)+""));
        }
        try {
            File file = new File("E:\\SE\\expense\\txt\\expense.txt");
            output = new BufferedWriter(new FileWriter(file));
            output.write(text);
            output.newLine();
            output.write(text2);
            for(int i = 0;i<transactions.size();i++){
                output.newLine();
                output.write(lst.get(i));
            }
            output.newLine();
            output.write(total);
        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
            if ( output != null ) {
                output.close();
            }
        }
    }

    public ArrayList<String[]> OpenFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("E:\\SE\\expense\\txt\\expense.txt"));
        try {
            ArrayList<String[]> lst = new ArrayList<String[]>();
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
//            int count = 0;
            while (line != null) {
                lst.add(line.split("/"));
                line = br.readLine();
            }
            return lst;
        } finally {
            br.close();
        }
    }

//    public void testCreate() throws IOException {
//        ArrayList<String> lst = new ArrayList<String>();
//        String text = ".: List INCOME and EXPENSE :.";
//        String text2 ="ID/Type/Detail/Amount/Date";
//        BufferedWriter output = null;
//        for(int i = 0;i<10;i++){
//            lst.add(i+"/INCOME/1/100/2018-09-19");
//        }
//        try {
//            File file = new File("E:\\SE\\expense\\txt\\example.txt");
//            output = new BufferedWriter(new FileWriter(file));
//            output.write(text);
//            output.newLine();
//            output.write(text2);
//            for(int i = 0;i<10;i++){
//                output.newLine();
//                output.write(lst.get(i)+"");
//            }
//        } catch ( IOException e ) {
//            e.printStackTrace();
//        } finally {
//            if ( output != null ) {
//                output.close();
//            }
//        }
//    }
}
