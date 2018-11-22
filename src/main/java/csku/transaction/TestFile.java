package csku.transaction;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TestFile {
    public static void main(String[] args) throws IOException {
        SaveAndEditFileTxt saveAndEditFileTxt = new SaveAndEditFileTxt();
////        saveAndEditFileTxt.testCreate();
            int count = 0;

            for(String[] str:saveAndEditFileTxt.OpenFile()){
                if(count > 1 &&count != saveAndEditFileTxt.OpenFile().size()-1){
                    System.out.print(str[0]);
                    System.out.print(str[1]);
                    System.out.print(str[2]);
                    System.out.print(str[3]);
                    System.out.println(str[4]);
                }
                count++;
            }
    }
}
