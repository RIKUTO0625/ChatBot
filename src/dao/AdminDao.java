package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Admin;

public class AdminDao extends Dao {

	// 職員ログイン時
    public Admin loginAdmin(String ad_cd, String pass) throws Exception{

    	Admin admin = null;

    	//school_cdによってJOIN SCHOOLさせて、SCHOOL_nameがゲットできるように
        String sql = "SELECT * FROM admin where ad_cd = ? and ad_pw = ? and is_deleted = false";

        Connection conn = getConnection();
	    PreparedStatement stmt = conn.prepareStatement(sql);
	    stmt.setString(1, ad_cd);
	    stmt.setString(2, pass);

	    ResultSet rs = stmt.executeQuery();

        if (rs.next()) { // 認証成功の場合（該当アカウントがあった場合）

        	String cd = rs.getString("ad_cd");
            String name = rs.getString("ad_name");
            String pw = rs.getString("ad_pw");
            Boolean deleted = rs.getBoolean("is_deleted");

	        admin = new Admin();

	        admin.setAd_cd(cd);
	        admin.setAd_name(name);
	        admin.setAd_pw(pw);
	        admin.setIs_deleted(deleted);
        }

        return admin;
    }

    public boolean createAdmin(Admin admin)throws Exception {

    	int count = 0;

		//コネクションを確立
		Connection connection = getConnection();
		//プリペアードステートメント
		PreparedStatement statement = null;


		try {

			String sql = "insert into admin "
			+ "(ad_cd, ad_pw, ad_name)"
		    + "values (? ,? ,?)";

			//プリペアードステートメントにINSERT文をセット
			statement = connection
			.prepareStatement (sql);
			// プリペアードステートメントに値をバインド
			statement.setString(1,admin.getAd_cd());
			statement.setString(2,admin.getAd_pw());
			statement.setString(3,admin.getAd_name());

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

	public boolean admin_delete (Admin admin) throws Exception {
		//コネクションを確立
		Connection connection = getConnection();
		//プリペアードステートメント
		PreparedStatement statement = null;
		// 実行件数
		Boolean success = false;

		try {

			//プリペアードステートメントにUPDATE文をセット
			statement = connection
			.prepareStatement ("update doctor set is_deleted = ? where ad_cd=? ");
			// プリペアードステートメントに値をバインド
			statement.setBoolean(1,true);
			statement.setString(2,admin.getAd_cd());
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