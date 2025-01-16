package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Daotest {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://mysql-database.cvk6s8aywusg.ap-northeast-1.rds.amazonaws.com:3306/test";
        String username = "admin";
        String password = "test-password";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password)) {
            System.out.println("データベース接続成功!");


         // すべてのテーブルを削除
            String dropGenderTableSql = "DROP TABLE IF EXISTS gender";
            String dropDoctorTableSql = "DROP TABLE IF EXISTS doctor";
            String dropAdminTableSql = "DROP TABLE IF EXISTS admin";
            String dropStaffTableSql = "DROP TABLE IF EXISTS staff";

            try (PreparedStatement dropStmt = conn.prepareStatement(dropStaffTableSql)) {
                dropStmt.executeUpdate();
                System.out.println("staffテーブルを削除しました。");
            }
            try (PreparedStatement dropStmt = conn.prepareStatement(dropGenderTableSql)) {
                dropStmt.executeUpdate();
                System.out.println("genderテーブルを削除しました。");
            }
            try (PreparedStatement dropStmt = conn.prepareStatement(dropDoctorTableSql)) {
                dropStmt.executeUpdate();
                System.out.println("doctorテーブルを削除しました。");
            }
            try (PreparedStatement dropStmt = conn.prepareStatement(dropAdminTableSql)) {
                dropStmt.executeUpdate();
                System.out.println("adminテーブルを削除しました。");
            }


            // genderテーブル作成SQL
            String createGenderTableSql = "CREATE TABLE IF NOT EXISTS gender ("
                    + "gender_cd CHAR(3) NOT NULL, "
                    + "gender_name VARCHAR(10) NOT NULL, "
                    + "PRIMARY KEY (gender_cd))";
            try (PreparedStatement stmt = conn.prepareStatement(createGenderTableSql)) {
                int result = stmt.executeUpdate();
                System.out.println("genderテーブル作成成功! 結果コード: " + result);
            }

            // adminテーブル作成SQL
            String createAdminTableSql = "CREATE TABLE IF NOT EXISTS admin ("
                    + "ad_cd CHAR(6) NOT NULL, "
                    + "ad_pw VARCHAR(20) NOT NULL, "
                    + "ad_name VARCHAR(20) NOT NULL, "
                    + "PRIMARY KEY (ad_cd))";
            try (PreparedStatement stmt = conn.prepareStatement(createAdminTableSql)) {
                int result = stmt.executeUpdate();
                System.out.println("adminテーブル作成成功! 結果コード: " + result);
            }

            // doctorテーブル作成SQL
            String createDoctorTableSql = "CREATE TABLE IF NOT EXISTS doctor ("
                    + "dc_pw VARCHAR(20) NOT NULL, "
                    + "dc_name VARCHAR(20) NOT NULL, "
                    + "dc_belong VARCHAR(20) NOT NULL, "
                    + "dc_dept VARCHAR(20), "
                    + "ad_cd CHAR(6) NOT NULL, "
                    + "PRIMARY KEY (ad_cd, dc_pw),"
                    + "FOREIGN KEY (ad_cd) REFERENCES admin (ad_cd))";
            try (PreparedStatement stmt = conn.prepareStatement(createDoctorTableSql)) {
                int result = stmt.executeUpdate();
                System.out.println("doctorテーブル作成成功! 結果コード: " + result);
            }


         // staffテーブル作成SQL
            String createStaffTableSql = "CREATE TABLE IF NOT EXISTS staff ("
                    + "staff_id CHAR(8) NOT NULL, "
                    + "staff_name VARCHAR(20) NOT NULL, "
                    + "staff_age INT NOT NULL, "
                    + "staff_belong VARCHAR(20) NOT NULL, "
                    + "staff_pw VARCHAR(20) NOT NULL, "
                    + "ad_cd CHAR(6), "
                    + "staff_mail VARCHAR(30), "
                    + "gender_cd CHAR(3), "
                    + "favorite VARCHAR(20), "
                    + "detail VARCHAR(100), "
                    + "PRIMARY KEY (staff_id), "
                    + "FOREIGN KEY (ad_cd) REFERENCES admin (ad_cd), "
                    + "FOREIGN KEY (gender_cd) REFERENCES gender (gender_cd))";
	            try (PreparedStatement stmt = conn.prepareStatement(createStaffTableSql)) {
	                int result = stmt.executeUpdate();
	                System.out.println("staffテーブル作成成功! 結果コード: " + result);
	            }

	            String createSendMailTableSql = "CREATE TABLE IF NOT EXISTS sendmail (mail_id SERIAL NOT NULL, mail_address VARCHAR(40) NOT NULL, ad_cd CHAR(6) NOT NULL,PRIMARY KEY (mail_id), FOREIGN KEY (ad_cd) REFERENCES admin (ad_cd))";
	            String insertSendMailSql = "insert into sendmail (mail_address, ad_cd) values ('example@gmail.com', '000000')";

	          // genderテーブルにデータ追加
	          String insertGenderSql = "INSERT INTO gender (gender_cd, gender_name) VALUES (?, ?)";
	          try (PreparedStatement insertStmt = conn.prepareStatement(insertGenderSql)) {
	              insertStmt.setString(1, "001");
	              insertStmt.setString(2, "男");
	              insertStmt.executeUpdate();
	              System.out.println("genderデータ追加成功!");
	          }

	            // adminテーブルにデータ追加
	            String insertAdminSql = "INSERT INTO admin (ad_cd, ad_pw, ad_name) VALUES (?, ?, ?)";
	            try (PreparedStatement insertStmt = conn.prepareStatement(insertAdminSql)) {
	                insertStmt.setString(1, "000000");
	                insertStmt.setString(2, "test");
	                insertStmt.setString(3, "Kanazawa");
	                insertStmt.executeUpdate();
	                System.out.println("adminデータ追加成功!");
	            }

	          // doctorテーブルにデータ追加
	          String insertDoctorSql = "INSERT INTO doctor (dc_pw, dc_name, dc_belong, dc_dept, ad_cd) VALUES (?, ?, ?, ?, ?)";
	          try (PreparedStatement insertStmt = conn.prepareStatement(insertDoctorSql)) {
	              insertStmt.setString(1, "doctor_password");
	              insertStmt.setString(2, "doctor_password");
	              insertStmt.setString(3, "金沢医科大学病院");
	              insertStmt.setString(4, "小児科");
	              insertStmt.setString(5, "000000");
	              insertStmt.executeUpdate();
	              System.out.println("doctorデータ追加成功!");
	          }

            // staffテーブルにデータ追加
            String insertStaffSql = "INSERT INTO staff (staff_id, staff_pw, staff_name, staff_belong, staff_age, ad_cd) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement insertStmt = conn.prepareStatement(insertStaffSql)) {
                insertStmt.setString(1, "staff000");
                insertStmt.setString(2, "test");
                insertStmt.setString(3, "TAKASHI");
                insertStmt.setString(4, "秘書課");
                insertStmt.setInt(5, 100);
                insertStmt.setString(6, "000000"); // admin_cd は adminテーブルの ad_cd に対応
                insertStmt.executeUpdate();
                System.out.println("staffデータ追加成功!");
            }



          // genderテーブルのデータを選択
          String selectSql = "SELECT * FROM gender";
          System.out.println("現在のgenderテーブルデータ:");

          try (PreparedStatement selectStmt = conn.prepareStatement(selectSql);
               ResultSet rs = selectStmt.executeQuery()) {
              while (rs.next()) {
                  String cd = rs.getString("gender_cd");
                  String name = rs.getString("gender_name");
                  System.out.println("gender_cd: " + cd + ", gender_name: " + name);
              }
          }

            // staffテーブルのデータを選択
            selectSql = "SELECT * FROM staff";
            System.out.println("現在のstaffテーブルデータ:");

            try (PreparedStatement selectStmt = conn.prepareStatement(selectSql);
                 ResultSet rs = selectStmt.executeQuery()) {
                while (rs.next()) {
                    String id = rs.getString("staff_id");
                    String name = rs.getString("staff_name");
                    Integer age = rs.getInt("staff_age");
                    String belong = rs.getString("staff_belong");
                    String pw = rs.getString("staff_pw");
                    String mail = rs.getString("staff_mail");
                    String gender = rs.getString("gender_cd");
                    String favorite = rs.getString("favorite");
                    String detail = rs.getString("detail");
                    System.out.println("職員番号: " + id + ", 職員名: " + name + "年齢:" + age + ",所属:" + belong + ",パスワード:" + pw);
                    System.out.println("メール: " + mail + ", 性別: " + gender + ",趣味:" + favorite + ",所属:" + belong + ",備考:" + detail);
                }
            }

            // doctorテーブルのデータを選択
            selectSql = "SELECT * FROM doctor";
            System.out.println("現在のdoctorテーブルデータ:");

            try (PreparedStatement selectStmt = conn.prepareStatement(selectSql);
                 ResultSet rs = selectStmt.executeQuery()) {
                while (rs.next()) {
                    String pw = rs.getString("dc_pw");
                    String name = rs.getString("dc_name");
                    String belong = rs.getString("dc_belong");
                    String dept = rs.getString("dc_dept");
                    String cd = rs.getString("ad_cd");
                    System.out.println("dc_pw: " + pw + ",dc_name: " + name + ",belong:" + belong + ",dept:" + dept + ",ad_cd:" + cd);
                }
            }

            // adminテーブルのデータを選択
            selectSql = "SELECT * FROM admin";
            System.out.println("現在のadminテーブルデータ:");

            try (PreparedStatement selectStmt = conn.prepareStatement(selectSql);
                 ResultSet rs = selectStmt.executeQuery()) {
                while (rs.next()) {
                    String id = rs.getString("ad_cd");
                    String name = rs.getString("ad_name");
                    String pw = rs.getString("ad_pw");
                    System.out.println("ID: " + id + ", Name: " + name + ",pw:" + pw);
                }
            }

        } catch (Exception e) {
            System.err.println("データベース接続エラー: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
