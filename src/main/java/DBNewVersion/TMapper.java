package DBNewVersion;

import newversion.TransactionNewVersion;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TMapper implements RowMapper<TransactionNewVersion> {


    public TransactionNewVersion mapRow(ResultSet rs, int rowNum) throws SQLException {
        TransactionNewVersion transactionNewVersion = new TransactionNewVersion();
        //int id,String detail, String type, String date, float amount
        transactionNewVersion.setId(rs.getInt("id")+"");
        transactionNewVersion.setDetail(rs.getString("detail"));
        transactionNewVersion.setType(rs.getString("type"));
        transactionNewVersion.setDate(rs.getString("date"));
        transactionNewVersion.setAmount(rs.getFloat("amount")+"");

        return transactionNewVersion;
    }

}
