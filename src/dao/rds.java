package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class rds extends Dao {

    // ログイン処理
    public void select() throws Exception{

        String sql = "SELECT * FROM ADMIN";

        Connection conn = getConnection();
	    PreparedStatement stmt = conn.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();

    }

}
