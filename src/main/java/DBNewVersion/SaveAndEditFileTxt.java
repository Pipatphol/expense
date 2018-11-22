package DBNewVersion;

import newversion.TransactionNewVersion;

import java.io.*;
import java.util.ArrayList;

public class SaveAndEditFileTxt implements Connector {


    public void createFile(ArrayList<TransactionNewVersion> transactionNewVersions, String total) throws IOException {
        ArrayList<String> lst = new ArrayList<String>();
        String text = ".: List INCOME and EXPENSE :.";
        String text2 ="ID/Type/Detail/Amount/Date";
        BufferedWriter output = null;
        for(int i = 0; i< transactionNewVersions.size(); i++){
            lst.add(transactionNewVersions.get(i).toStringTxtForSave());
        }
        try {
            File file = new File("txt\\expense.txt");
            output = new BufferedWriter(new FileWriter(file));
            output.write(text);
            output.newLine();
            output.write(text2);
            for(int i = 0; i< transactionNewVersions.size(); i++){
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

    public ArrayList<TransactionNewVersion> getTransaction() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("txt\\expense.txt"));
        try {
            ArrayList<String[]> lst = new ArrayList<String[]>();
            ArrayList<TransactionNewVersion> lst_t = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                lst.add(line.split("/"));
                line = br.readLine();
            }
            for(int i=0;i<lst.size();i++){
                if(i>1 && i<lst.size()-1){
                    lst_t.add(new TransactionNewVersion(Integer.parseInt(lst.get(i)[0]),lst.get(i)[2],lst.get(i)[1],lst.get(i)[4],Float.parseFloat(lst.get(i)[3])));
                }
            }
            return lst_t;
        } finally {
            br.close();
        }
    }

//    public ArrayList<Integer> getIdTransaction() throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("txt\\expense.txt"));
//        try {
//            ArrayList<String[]> lst = new ArrayList<String[]>();
//            ArrayList<Integer> lst_t = new ArrayList<>();
//            StringBuilder sb = new StringBuilder();
//            String line = br.readLine();
//            while (line != null) {
//                lst.add(line.split("/"));
//                line = br.readLine();
//            }
//            for(int i=0;i<lst.size();i++){
//                if(i>1 && i<lst.size()-1){
//                    lst_t.add(Integer.parseInt(lst.get(i)[0]));
//                }
//            }
//            return lst_t;
//        } finally {
//            br.close();
//        }
//    }

}
