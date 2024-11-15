package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StaffdDao{

    public void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://mysql-database.cvk6s8aywusg.ap-northeast-1.rds.amazonaws.com:3306/test";
        String username = "admin";
        String password = "test-password";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password)){
            System.out.println("データベース接続成功!");

            // SQLクエリを準備
            String sql = "CREATE TABLE IF NOT EXISTS admin(ad_cd CHAR(6) NOT NULL, ad_pw VARCHAR(20) NOT NULL, ad_name VARCHAR(20) NOT NULL, PRIMARY KEY(ad_cd))";
            PreparedStatement stmt = conn.prepareStatement(sql);
            // クエリの実行
            int result = stmt.executeUpdate(); // 変更点: executeUpdate() を使用
            System.out.println("テーブル作成成功! 結果コード: " + result);


    	    // SQLクエリを準備
    	    sql = "CREATE TABLE IF NOT EXISTS staff(staff_id CHAR(8)  NOT NULL, staff_name VARCHAR(20) NOT NULL, staff_age INT NOT NULL, staff_belong VARCHAR(20), staff_pw VARCHAR(20), PRIMARY KEY(staff_id), FOREIGN KEY(ad_cd)REFERENCES ADMIN(ad_cd))";
    	    stmt = conn.prepareStatement(sql);
    	    // クエリの実行
    	    result = stmt.executeUpdate(); // 変更点: executeUpdate() を使用
    	    System.out.println("テーブル作成成功! 結果コード: " + result);

    	}catch (SQLException e) {
            System.err.println("データベース接続エラー: " + e.getMessage());
            e.printStackTrace();
        }

    }
}




//	public void add_staff(){
//
//	    // データを追加
//	    String insertSql = "INSERT INTO admin (ad_cd) VALUES (?),(ad_pw) VALUES (?),(ad_name) VALUES (?)";
//	    try (PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
//	        insertStmt.setString(1, "000000");
//	        insertStmt.setString(2, "test");
//	        insertStmt.setString(3, "Kanazawa");
//	        insertStmt.executeUpdate();
//	        System.out.println("データ追加成功!");
//	    }
//
//	}
//
//	public void add_admin(){
//
//	    // データを追加
//	    String insertSql = "INSERT INTO staff (staff_id) VALUES (?),(staff_pw) VALUES (?),(staff_name) VALUES (?),(staff_belong) VALUES (?),(staff_age) VALUES (?),(admin_cd) VALUES (?)";
//	    try (PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
//	        insertStmt.setString(1, "staff000");
//	        insertStmt.setString(2, "test");
//	        insertStmt.setString(3, "TAKASHI");
//	        insertStmt.setString(4, "秘書課");
//	        insertStmt.setInt(5, 100);
//	        insertStmt.setString(6, "000000");
//	        insertStmt.executeUpdate();
//	        System.out.println("データ追加成功!");
//	    }
//	}
//
//	public void select_staff(){
//
//	    String selectSql = "SELECT * FROM staff";
//	    System.out.println("現在のテーブルデータ:");
//
//	    try (PreparedStatement selectStmt = conn.prepareStatement(selectSql);
//	         ResultSet rs = selectStmt.executeQuery()) {
//	        while (rs.next()) {
//	            String id = rs.getString("staff_id");
//	            String name = rs.getString("satff_name");
//	            System.out.println("ID: " + id + ", Name: " + name);
//	        }
//	    }
//
//	}
//
//	public void select_admin(){
//
//	    String selectSql = "SELECT * FROM admin";
//	    System.out.println("現在のテーブルデータ:");
//
//	    try (PreparedStatement selectStmt = conn.prepareStatement(selectSql);
//
//	        ResultSet rs = selectStmt.executeQuery()) {
//
//	        while (rs.next()) {
//	            String id = rs.getString("ad_cd");
//	            String name = rs.getString("ad_name");
//	            System.out.println("ID: " + id + ", Name: " + name);
//	        }
//	    }
//
//	}

