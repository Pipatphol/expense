package DB;

import csku.transaction.TransactionDB;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;

public class DatabaseConnector {
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

    public void deleteTransaction(String detail, String type, String date, float amount){
        try {
            connect();


            Statement stmt = conn.createStatement();

            String query = ("DELETE FROM TRANSACTION WHERE detail = '"+detail+"' AND type = '"+type+"' AND date = '"+date+"' AND amount = '"+amount+"'");
            stmt.execute(query);


            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTransactionALL(){
        try {
            connect();

            Statement stmt = conn.createStatement();

            String query = ("DELETE FROM TRANSACTION");
            stmt.execute(query);


            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<TransactionDB> getTransaction() {
        ArrayList<TransactionDB> p = new ArrayList<>();
        try {
            connect();

            Statement stmt = conn.createStatement();
            String query = "SELECT detail,type,amount,date FROM TRANSACTION";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String detail = rs.getString("detail");
                String type = rs.getString("type");
                float amount = rs.getFloat("amount");
                String date= rs.getString("date");
                TransactionDB product = new TransactionDB(detail, type ,date,amount);
                p.add(product);
            }

            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    public ArrayList<TransactionDB> getTransactionByType(String data) {
        ArrayList<TransactionDB> p = new ArrayList<>();
        try {
            connect();

            Statement stmt = conn.createStatement();
            String query = "SELECT detail,type,amount,date FROM TRANSACTION WHERE type = '"+data+"'";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String detail = rs.getString("detail");
                String type = rs.getString("type");
                float amount = rs.getFloat("amount");
                String date= rs.getString("date");
                TransactionDB product = new TransactionDB(detail, type ,date,amount);
                p.add(product);
            }

            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

}
