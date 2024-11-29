package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Admin;
import bean.Staff;

public class StaffDao extends Dao {


    // ログイン処理
    public Staff loginStaff(String staff_id, String staff_pw) throws Exception{

    	Staff staff = null;
    	Admin admin = null;

        String sql = "SELECT * FROM staff where staff_id = ? and staff_pw = ? and is_deleted = false";

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
            Boolean deleted = rs.getBoolean("is_deleted");

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
            staff.setIs_deleted(deleted);

            // 認証済みフラグを設定
//            staff.setAuthenticated(true);
        }


        //ログインされたteacherのデータを返す
        return staff;



    }

    public boolean createStaff(Staff staff)throws Exception {

    	int count = 0;

		//コネクションを確立
		Connection connection = getConnection();
		//プリペアードステートメント
		PreparedStatement statement = null;


		try {

			String sql = "insert into staff "
			+ "(staff_id, staff_name, staff_belong, staff_pw, staff_mail, ad_cd)"
		    + "values (? ,? ,? ,? ,? ,? )";

			//プリペアードステートメントにINSERT文をセット
			statement = connection
			.prepareStatement (sql);
			// プリペアードステートメントに値をバインド
			statement.setString(1,staff.getStaff_id());
			statement.setString(2,staff.getStaff_name());
			statement.setString(3,staff.getStaff_belong());
			statement.setString(4,staff.getStaff_pw());
			statement.setString(5,staff.getStaff_mail());
			statement.setString(6,staff.getAdmin().getAd_cd());


			//プリペアードステートメントを実行
			count = statement.executeUpdate ();

		}catch(Exception e) {
				throw e;
		}finally {
			// プリペアードステートメントを閉じる
			if (statement != null) {
				try {
					statement. close ();
				}catch (SQLException sqle) {
					throw sqle;
				}
			}
			//コネクションを閉じる
			if (connection != null) {
				try {
					connection.close ();
				}catch (SQLException sqle) {
					throw sqle;
				}
			}
		}
		if (count > 0) {
			//実行件数が1件以上ある場合
			return true;
		}else{
		    //実行件数が0件の場合
		    return false;
		}

    }

    public boolean editStaff (Staff staff) throws Exception {
		//コネクションを確立
		Connection connection = getConnection();
		//プリペアードステートメント
		PreparedStatement statement = null;
		// 実行件数
		int count = 0;

		try {

			String sql = "update staff set "
			+ "staff_name = ?, staff_age = ?, staff_belong = ?, "
			+ "staff_mail = ?, favorite = ?, detail = ?, staff_pw = ? "
			+ "where staff_id = ? and is_deleted = false ";

			//プリペアードステートメントにUPDATE文をセット
			statement = connection
			.prepareStatement (sql);
			// プリペアードステートメントに値をバインド
			statement.setString(1,staff.getStaff_name());
			statement.setInt(2,staff.getStaff_age());
			statement.setString(3,staff.getStaff_belong());
			statement.setString(4,staff.getStaff_mail());
			statement.setString(5,staff.getFavorite());
			statement.setString(6,staff.getDetail());
			statement.setString(7,staff.getStaff_pw());
			statement.setString(8,staff.getStaff_id());

			//プリペアードステートメントを実行
			count = statement.executeUpdate ();

		}catch(Exception e) {
				throw e;
		}finally {
			// プリペアードステートメントを閉じる
			if (statement != null) {
				try {
					statement. close ();
				}catch (SQLException sqle) {
					throw sqle;
				}
			}
			//コネクションを閉じる
			if (connection != null) {
				try {
					connection.close ();
				}catch (SQLException sqle) {
					throw sqle;
				}
			}
		}
		if (count > 0) {
			//実行件数が1件以上ある場合
			return true;
		}else{
		    //実行件数が0件の場合
		    return false;
		}
	}

	private List<Staff> changeList(ResultSet rSet) throws Exception {

		// リストを初期化
	    List<Staff> list = new ArrayList<>();

	    try {
	        // リザルトセットを全権走査
	        while (rSet.next()) {
	            // 職員インスタンスを初期化
	            Staff staff = new Staff();
	            Admin admin = new Admin();

	            // 学生インスタンスに検索結果をセット
	            staff.setStaff_id(rSet.getString("staff_id"));
	            staff.setStaff_name(rSet.getString("staff_name"));
	            staff.setStaff_age(rSet.getInt("staff_age"));
	            staff.setStaff_belong(rSet.getString("staff_belong"));
	            staff.setStaff_pw(rSet.getString("staff_pw"));
	            admin.setAd_cd(rSet.getString("ad_cd"));
	            staff.setAdmin(admin);
	            staff.setStaff_mail(rSet.getString("staff_mail"));
	            staff.setGender_cd(rSet.getString("gender_cd"));
	            staff.setFavorite(rSet.getString("favorite"));
	            staff.setDetail(rSet.getString("detail"));

	            // リストに追加
	            list.add(staff);
	        }

	    } catch (SQLException | NullPointerException e) {
	        e.printStackTrace();
	    }

	    return list;
	}


	//フィルター
	public List<Staff> viewStaff(String admin_cd) throws Exception {


		//リストを作り、職員を
		List<Staff> staff_list = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement statement = null;
        ResultSet rSet = null;

        try {
            statement = connection.prepareStatement(
            "SELECT * FROM staff " +
            	" where ad_cd = ? and is_deleted = false " +
				" ORDER BY staff_belong ASC, staff_name ASC ");

            statement.setString(1,admin_cd) ;

            rSet = statement.executeQuery();
            staff_list = changeList(rSet);

        }catch(Exception e){
			throw e;

		}finally {

            if (statement != null) {
            	try {
            		statement.close();
				} catch (SQLException sqle) {
					throw sqle;
				}

            }
            if (connection != null) {
            	try {
            		 connection.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
            }
        }

        return staff_list;
	}

	//フィルター
	public List<Staff> searchStaff(String admin_cd, String keyword) throws Exception {


		//リストを作り、職員を
		List<Staff> staff_list = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement statement = null;
        ResultSet rSet = null;

        try {
            statement = connection.prepareStatement(
            "SELECT * FROM staff " +
            	"WHERE ad_cd = ? and staff_name ILIKE ? " +
				" ORDER BY staff_belong ASC, staff_name ASC ");

            statement.setString(1, admin_cd) ;
            statement.setString(2, keyword) ;

            rSet = statement.executeQuery();
            staff_list = changeList(rSet);

        }catch(Exception e){
			throw e;

		}finally {

            if (statement != null) {
            	try {
            		statement.close();
				} catch (SQLException sqle) {
					throw sqle;
				}

            }
            if (connection != null) {
            	try {
            		 connection.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
            }
        }

        return staff_list;
	}




	public boolean staff_delete (Staff staff) throws Exception {
		//コネクションを確立
		Connection connection = getConnection();
		//プリペアードステートメント
		PreparedStatement statement = null;
		// 実行件数
		Boolean success = false;

		try {

			//プリペアードステートメントにUPDATE文をセット
			statement = connection
			.prepareStatement ("update staff set is_deleted = ? where staff_id=? ");
			// プリペアードステートメントに値をバインド
			statement.setBoolean(1,true);
			statement.setString(2,staff.getStaff_id());

			statement.executeUpdate ();

			success = true;

		}catch(Exception e) {
				throw e;

		}finally {
			// プリペアードステートメントを閉じる
			if (statement != null) {
				try {
					statement. close ();
				}catch (SQLException sqle) {
					throw sqle;
				}
			}
			//コネクションを閉じる
			if (connection != null) {
				try {
					connection.close ();
				}catch (SQLException sqle) {
					throw sqle;
				}
			}
		}

		return success;

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

