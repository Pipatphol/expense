package DBNewVersion;


import newversion.TransactionNewVersion;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SpringData implements Connector {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }



    @Override
    public ArrayList<TransactionNewVersion> getTransaction() throws IOException {
        String SQL = "SELECT id,detail,type,amount,date FROM TRANSACTION";
        List<TransactionNewVersion> transactionNewVersions = jdbcTemplateObject.query(SQL, new TMapper());
        return (ArrayList<TransactionNewVersion>) transactionNewVersions;
    }

    public void insertTransaction(String detail, String type, String date, float amount) {
        String SQL = "INSERT INTO TRANSACTION (detail,type,amount,date) VALUES (?,?,?,?)"; //"INSERT INTO TRANSACTION (detail,type,amount,date) VALUES (?,?,?,?)"
        jdbcTemplateObject.update( SQL, detail, type, amount, date);
        System.out.println("insertTransaction");
        return;
    }


    public void deleteTransactionById(int id) {
        String SQL = "DELETE FROM TRANSACTION WHERE id = ?";//"DELETE FROM TRANSACTION WHERE id = '"+id+"'"
        jdbcTemplateObject.update(SQL, id);
        System.out.println("Deleted Record with ID = " + id );
        return;
    }

    public void editTransaction(String detail,float amount,int id){
        String SQL = "UPDATE TRANSACTION SET detail = ? , amount = ? where id = ?";//"UPDATE TRANSACTION SET detail = '"+detail+"' , amount = '"+amount+"' WHERE id = '"+id+"'"
        jdbcTemplateObject.update(SQL, detail, amount,id);
        System.out.println("edit" );
        return;
    }

}
