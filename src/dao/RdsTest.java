package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RdsTest{

    public static void main(String[] args) {
    	System.out.println("★★★★★★★★★★★★");

        try (Connection conn = Dao.getConnection()) {

//        	System.out.println("★");
            String query = "SELECT * FROM test-database";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println("Column Value: " + rs.getString("column_name"));
            }
        } catch (Exception e) {
        	System.out.println("★★★★★★★★★★★★");
            e.printStackTrace();
        }
    }
}
