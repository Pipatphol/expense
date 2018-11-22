package DBNewVersion;

import newversion.TransactionNewVersion;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseConnector implements Connector {

    private final String DB_NAME = "expense";
    private final String DB_BASE = "localhost";
    private final String DB_URL = DB_BASE + "/" + DB_NAME;
    private final String DB_USER = "root";
    private final String DB_PASS = "";
    private final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private Connection conn;

    public DatabaseConnector() throws ClassNotFoundException {
        Class.forName(DB_DRIVER);

    }

    private void connect() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://" + DB_URL, DB_USER, DB_PASS);
    }

    private void disconnect() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }






    public void insertTransaction(String detail, String type, String date, float amount) {
        try {
            connect();

            String query = "INSERT INTO TRANSACTION (detail,type,amount,date) VALUES (?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, detail);
            stmt.setString(2, type);
            stmt.setFloat(3, amount);
            stmt.setString(4, date);
            stmt.execute();


            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editTransaction(String detail,float amount,int id){
//        UPDATE `transaction` SET `id`=[value-1],`detail`=[value-2],`type`=[value-3],`amount`=[value-4],`date`=[value-5] WHERE 1
        try {
            connect();


            Statement stmt = conn.createStatement();

            String query = ("UPDATE TRANSACTION SET detail = '"+detail+"' , amount = '"+amount+"' WHERE id = '"+id+"'");
            stmt.execute(query);


            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void deleteTransactionById(int id){
        try {
            connect();


            Statement stmt = conn.createStatement();

            String query = ("DELETE FROM TRANSACTION WHERE id = '"+id+"'");
            stmt.execute(query);


            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public ArrayList<TransactionNewVersion> getTransaction() {
        ArrayList<TransactionNewVersion> p = new ArrayList<>();
        try {
            connect();

            Statement stmt = conn.createStatement();
            String query = "SELECT id,detail,type,amount,date FROM TRANSACTION";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String detail = rs.getString("detail");
                String type = rs.getString("type");
                float amount = rs.getFloat("amount");
                String date= rs.getString("date");
                TransactionNewVersion product = new TransactionNewVersion(id,detail, type ,date,amount);
                p.add(product);
            }

            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

//    public ArrayList<Integer> getIdTransaction(){
//        ArrayList<Integer> lstID = new ArrayList<Integer>();
//
//        try {
//            connect();
//
//            Statement stmt = conn.createStatement();
//            String query = "SELECT id FROM TRANSACTION";
//            ResultSet rs = stmt.executeQuery(query);
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                lstID.add(id);
//            }
//
//            disconnect();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return lstID;
//
//    }


    public ArrayList<TransactionNewVersion> getTransactionByType(String data) {
        ArrayList<TransactionNewVersion> p = new ArrayList<>();
        try {
            connect();

            Statement stmt = conn.createStatement();
            String query = "SELECT id,detail,type,amount,date FROM TRANSACTION WHERE type = '"+data+"'";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String detail = rs.getString("detail");
                String type = rs.getString("type");
                float amount = rs.getFloat("amount");
                String date= rs.getString("date");
                TransactionNewVersion product = new TransactionNewVersion(id,detail, type ,date,amount);
                p.add(product);
            }

            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }


}
