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

        while (program) {
            System.out.println("โปรแกรม รายรับรายจ่าย");
            System.out.print("เพิ่มรายการ พิม 1 | แสดงรายการที่บันทึก พิม 2 | ออกจากโปรแกรม พิม 3 : ");
            int input1 = Integer.parseInt(br.readLine());
            System.out.println("-----------------------------------------------------------------");
            if(input1 == 1){
                while (true){
                    System.out.println("ต้องการเพิ่มรายรับหรือจ่าย");
                    System.out.print("เพิ่มรายรับ พิม 1 | เพิ่มรายจ่าย พิม 2 | ออก พิม 3 : ");
                    int inputAdd = Integer.parseInt(br.readLine());
                    System.out.println("-----------------------------------------------------------------");
                    //income
                    if(inputAdd == 1){
                        while (true) {
                            System.out.println("เพิ่มรายรับ");
                            System.out.print("1.รายละเอียด ตัวอย่างเช่น เงินเดือน,ค่าขนม : ");
                            String income1 = br.readLine();

                            System.out.print("2.จำนวนเงิน : ");
                            int income2 = Integer.parseInt(br.readLine());
                            if (income1.length() > 0 && income2 != 0) {
                                note.setLst_note(new Transaction(income1, Transaction.TRANSACTION_TYPE.INCOME, income2));
//                                System.out.println(note.getLst_Note().get(0).toString());
                                balance.income(income2);
//                                System.out.println(balance.getBalance());
                                System.out.println("-----------------------------------------------------------------");
                                break;
                            }
                            else {
                                System.out.println("กรอกข้อมูลผิดพลาด");
                                System.out.println("-----------------------------------------------------------------");
                            }
                        }
                    }
                    //expense
                    else if(inputAdd == 2){
                        while (true) {
                            System.out.println("เพิ่มรายจ่าย");
                            System.out.print("1.รายละเอียด ตัวอย่างเช่น น้ำ,เดินทาง : ");
                            String expense1 = br.readLine();

                            System.out.print("2.จำนวนเงิน : ");
                            int expense2 = Integer.parseInt(br.readLine());
                            if (expense1.length() > 0 && expense2 != 0) {
                                note.setLst_note(new Transaction(expense1, Transaction.TRANSACTION_TYPE.EXPENSE, expense2));
//                                System.out.println(note.getLst_Note().get(0).toString());
                                balance.expense(expense2);
//                                System.out.println(balance.getBalance());
                                System.out.println("-----------------------------------------------------------------");
                                break;
                            }
                            else {
                                System.out.println("กรอกข้อมูลผิดพลาด");
                                System.out.println("-----------------------------------------------------------------");
                            }
                        }
                    }
                    else if(inputAdd == 3){
                        break;
                    }
                    else{
                        System.out.println(".: กรุณา พิมหมายเลขใหม่ :.");
                        System.out.println("-----------------------------------------------------------------");
                    }
                }
            }
            else if(input1 == 2){
                while (true) {
                    if(note.getLst_Note().size()==0){
                        System.out.println(".: ไม่รายการ รายรับ และ รายจ่าย :.");
                        System.out.println("-----------------------------------------------------------------");
                        break;
                    }
                    else{
                        System.out.println(".: รายการ รายรับ และ รายจ่าย :.");
                        for(int i =0;i<note.getLst_Note().size();i++){
                            System.out.println(note.getLst_Note().get(i).toString());
                        }
                        System.out.printf("Total Amount: %d",balance.getBalance());
                        System.out.println();
                        System.out.println("-----------------------------------------------------------------");
                        break;
                    }
                }
            }
            else if(input1 == 3){
                program = false;
                System.out.println(".: ออกจากระบบ :.");
                System.out.println("-----------------------------------------------------------------");
            }
            else{
                System.out.println(".: กรุณา พิมหมายเลขใหม่ :.");
                System.out.println("-----------------------------------------------------------------");
            }


        }
    }
}
