package Page;


import DBNewVersion.Connector;
import DBNewVersion.DatabaseConnector;
import DBNewVersion.SaveAndEditFileTxt;
import newversion.TransactionNewVersion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PageMain {
    //spring Jdbc
    ApplicationContext contextSpringJDBC = new ClassPathXmlApplicationContext("springdatasource.xml");
    Connector dcJdbc = (Connector) contextSpringJDBC.getBean("data");

    //spring Ioc
    ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
    Connector dc = context.getBean("connector", Connector.class);

    SaveAndEditFileTxt saveAndEditFileTxt = new SaveAndEditFileTxt();
    String date;
    Date timeStamp = new Date();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    DatabaseConnector db ;
    //label
    @FXML
    private Label totalAmount;


    //add
    @FXML
    private TextField detailAdd;

    @FXML
    private ComboBox<String> typeAdd;

    @FXML
    private TextField amountAdd;


    //Edit
    @FXML
    private ComboBox<Integer> idEdit;

    @FXML
    private TextField detailEdit;

    @FXML
    private TextField amountEdit;


    //Delete
    @FXML
    private ComboBox<Integer> idDelet;


    //table
    @FXML
    private TableView<TransactionNewVersion> table_info;

    @FXML
    private TableColumn<TransactionNewVersion, String> col_id;

    @FXML
    private TableColumn<TransactionNewVersion, String> col_detail;

    @FXML
    private TableColumn<TransactionNewVersion, String> col_type;

    @FXML
    private TableColumn<TransactionNewVersion, String> col_amount;

    @FXML
    private TableColumn<TransactionNewVersion, String> col_date;


    @FXML
    public void initialize() {
        setCBox();
        initTable();
        totalAmount.setText("0.0");
//        loadData();

    }




    @FXML
    public void setCBox(){
        typeAdd.setItems(FXCollections.observableArrayList(
                "EXPENSE","INCOME"));

        idDelet.setItems(FXCollections.observableArrayList(
                getIdTransaction()));

        idEdit.setItems(FXCollections.observableArrayList(
                getIdTransaction()));
        setCBoxNull();
    }
    public void setCBoxNull(){
        typeAdd.getSelectionModel().select("");
        idDelet.getSelectionModel().select(null);
        idEdit.getSelectionModel().select(null);

        //Text
        detailEdit.setText("");
        amountEdit.setText("");

        detailAdd.setText("");
        amountAdd.setText("");
    }


    @FXML
    public void saveFileTxt(){
        ArrayList<TransactionNewVersion> lst_t = new ArrayList<>();
        try {
            db = new DatabaseConnector();
            lst_t = db.getTransaction();
            saveAndEditFileTxt.createFile(lst_t,("Total Amount: "+totalAmount(lst_t,"ALL")));



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void addTransaction(){
        if(detailAdd.getText().length()>0 && !(typeAdd.getValue()+"").equals("null") && Float.parseFloat(amountAdd.getText())>0){
            date = simpleDateFormat.format(timeStamp);
            try {
                db = new DatabaseConnector();
                db.insertTransaction(detailAdd.getText(),typeAdd.getValue(),date,Float.parseFloat(amountAdd.getText()));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            setCBox();
            saveFileTxt();
            loadData();
            System.out.println("ADD DONE");
        }
        else {
            System.out.println("ERROR ADD");
        }

    }

    @FXML
    public void deleteTransaction(){
        if(!(idDelet.getValue()+"").equals("null")){
            try {
                db = new DatabaseConnector();
                db.deleteTransactionById(idDelet.getValue());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            setCBox();
            saveFileTxt();
            loadData();
            System.out.println("DELETE DONE");
        }
        else {
            System.out.println("ERROR DELETE ");
        }

    }

    @FXML
    public void editTransaction(){
        if(detailEdit.getText().length()>0 && !(idEdit.getValue()+"").equals("null") && Float.parseFloat(amountEdit.getText())>0){
            date = simpleDateFormat.format(timeStamp);
            try {
                db = new DatabaseConnector();
                db.editTransaction(detailEdit.getText(),Float.parseFloat(amountEdit.getText()),idEdit.getValue());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            setCBox();
            saveFileTxt();
            loadData();
            System.out.println("Edit DONE");
        }
        else {
            System.out.println("ERROR Edit");
        }


    }


    @FXML
    public ArrayList<Integer> getIdTransaction(){
        ArrayList<Integer> integers = new ArrayList<>();
        try {
            ArrayList<TransactionNewVersion> transactionNewVersions = dcJdbc.getTransaction();
            for(TransactionNewVersion t: transactionNewVersions){
                integers.add(Integer.parseInt(t.getId()));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return integers;
    }



    private void initTable(){
        initCols();
    }
    private void initCols(){

        col_id.setCellValueFactory(new PropertyValueFactory<TransactionNewVersion, String>("id"));
        col_detail.setCellValueFactory(new PropertyValueFactory<TransactionNewVersion, String>("detail"));
        col_type.setCellValueFactory(new PropertyValueFactory<TransactionNewVersion, String>("type"));
        col_amount.setCellValueFactory(new PropertyValueFactory<TransactionNewVersion, String>("amount"));
        col_date.setCellValueFactory(new PropertyValueFactory<TransactionNewVersion, String>("date"));

        editTableCols();
    }
    private void editTableCols(){
        col_id.setCellFactory(TextFieldTableCell.<TransactionNewVersion>forTableColumn());

        col_id.setOnEditCommit(e-> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setId(e.getNewValue());
        });


        col_detail.setCellFactory(TextFieldTableCell.<TransactionNewVersion>forTableColumn());

        col_detail.setOnEditCommit( e-> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setDetail(e.getNewValue());
        });

        col_type.setCellFactory(TextFieldTableCell.<TransactionNewVersion>forTableColumn());

        col_type.setOnEditCommit( e-> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setType(e.getNewValue());
        });

        col_amount.setCellFactory(TextFieldTableCell.<TransactionNewVersion>forTableColumn());

        col_amount.setOnEditCommit( e-> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setAmount(e.getNewValue());
        });

        col_date.setCellFactory(TextFieldTableCell.<TransactionNewVersion>forTableColumn());

        col_date.setOnEditCommit( e-> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setDate(e.getNewValue());
        });


        table_info.setEditable(true);

    }

    //load_data

    @FXML
    private void loadData(){
        ObservableList<TransactionNewVersion> data_table = FXCollections.observableArrayList();
        ArrayList<TransactionNewVersion> lst_t = new ArrayList<>();
        try {
            lst_t = dcJdbc.getTransaction();
            for(int i =0;i<lst_t.size();i++){
                    data_table.add(lst_t.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        table_info.setItems(data_table);
        totalAmount.setText(totalAmount(lst_t,"ALL")+"");
        setCBox();

    }

    @FXML
    private void loadDataExpense(){
        ObservableList<TransactionNewVersion> data_table = FXCollections.observableArrayList();
        ArrayList<TransactionNewVersion> lst_t = new ArrayList<>();
        ArrayList<TransactionNewVersion> lst_tsave = new ArrayList<>();
        try {
            lst_t = dcJdbc.getTransaction();
            for(int i =0;i<lst_t.size();i++){
                if(lst_t.get(i).getType().equals("EXPENSE")){
                    data_table.add(lst_t.get(i));
                    lst_tsave.add(lst_t.get(i));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        table_info.setItems(data_table);
        totalAmount.setText(totalAmount(lst_tsave,"EXPENSE")+"");
        setCBox();
    }

    @FXML
    private void loadDataIncome(){
        ObservableList<TransactionNewVersion> data_table = FXCollections.observableArrayList();
        ArrayList<TransactionNewVersion> lst_t = new ArrayList<>();
        ArrayList<TransactionNewVersion> lst_tsave = new ArrayList<>();
        try {
            lst_t = dcJdbc.getTransaction();
            for(int i =0;i<lst_t.size();i++){
                if(lst_t.get(i).getType().equals("INCOME")){
                    data_table.add(lst_t.get(i));
                    lst_tsave.add(lst_t.get(i));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        table_info.setItems(data_table);
        totalAmount.setText(totalAmount(lst_tsave,"INCOME")+"");
        setCBox();

    }

    private Float totalAmount(ArrayList<TransactionNewVersion> data, String type){
        Float f = 0.0f;
        for(TransactionNewVersion t:data){
            if(type.equals("EXPENSE")){
                f -= Float.parseFloat(t.getAmount());
            }
            else if(type.equals("ALL")){
                if(t.getType().equals("EXPENSE")){
                    f -= Float.parseFloat(t.getAmount());
                }
                else {
                    f += Float.parseFloat(t.getAmount());
                }

            }
            else{
                f += Float.parseFloat(t.getAmount());
            }
        }
        return f;
    }



}
