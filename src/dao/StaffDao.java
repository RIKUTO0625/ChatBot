package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Admin;
import bean.Staff;

public class StaffDao extends Dao {

    // ログイン処理
    public Staff login(String staff_id, String staff_pw) throws Exception{

    	Staff staff = null;
    	Admin admin = null;

        String sql = "SELECT * FROM staff where staff_id = ? and staff_pw = ?";

        Connection conn = getConnection();
	    PreparedStatement stmt = conn.prepareStatement(sql);
	    stmt.setString(1, staff_id);
	    stmt.setString(2, staff_pw);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) { // 認証成功の場合（該当アカウントがあった場合）

        	String id = rs.getString("staff_id");
            String name = rs.getString("staff_name");
            Integer age = rs.getInt("staff_age");
            String belong = rs.getString("staff_belong");
            String pass = rs.getString("staff_pw");
            String ad_cd = rs.getString("ad_cd");
            String mail = rs.getString("staff_mail");
            String gen_cd = rs.getString("gender_cd");
            String favorite = rs.getString("favorite");
            String detail = rs.getString("detail");

            staff = new Staff();
            admin = new Admin();

            staff.setStaff_id(id);
            staff.setStaff_name(name);
            staff.setStaff_age(age);
            staff.setStaff_belong(belong);
            staff.setStaff_pw(pass);
            admin.setAd_cd(ad_cd);
            staff.setAdmin(admin);
            staff.setStaff_mail(mail);
            staff.setGender_cd(gen_cd);
            staff.setFavorite(favorite);
            staff.setDetail(detail);

            // 認証済みフラグを設定
//            staff.setAuthenticated(true);
        }


        //ログインされたteacherのデータを返す
        return staff;



    }
}



//try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password)){
//    System.out.println("データベース接続成功!");
//
//    // SQLクエリを準備
//    String sql = "CREATE TABLE IF NOT EXISTS admin(ad_cd CHAR(6) NOT NULL, ad_pw VARCHAR(20) NOT NULL, ad_name VARCHAR(20) NOT NULL, PRIMARY KEY(ad_cd))";
//    PreparedStatement stmt = conn.prepareStatement(sql);
//    // クエリの実行
//    int result = stmt.executeUpdate(); // 変更点: executeUpdate() を使用
//    System.out.println("テーブル作成成功! 結果コード: " + result);
//
//
//    // SQLクエリを準備
//    sql = "CREATE TABLE IF NOT EXISTS staff(staff_id CHAR(8)  NOT NULL, staff_name VARCHAR(20) NOT NULL, staff_age INT NOT NULL, staff_belong VARCHAR(20), staff_pw VARCHAR(20), PRIMARY KEY(staff_id), FOREIGN KEY(ad_cd)REFERENCES ADMIN(ad_cd))";
//    stmt = conn.prepareStatement(sql);
//    // クエリの実行
//    result = stmt.executeUpdate(); // 変更点: executeUpdate() を使用
//    System.out.println("テーブル作成成功! 結果コード: " + result);
//
//}catch (SQLException e) {
//    System.err.println("データベース接続エラー: " + e.getMessage());
//    e.printStackTrace();
//}


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
