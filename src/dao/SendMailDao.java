package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Admin;
import bean.Doctor;

public class SendMailDao extends Dao {


    public boolean createDoctor(Doctor doctor)throws Exception {

    	int count = 0;

		//コネクションを確立
		Connection connection = getConnection();
		//プリペアードステートメント
		PreparedStatement statement = null;


		try {

			String sql = "insert into doctor "
			+ "(dc_pw, dc_name, dc_belong, dc_dept, ad_cd)"
		    + "values (? ,? ,? ,? ,?)";

			//プリペアードステートメントにINSERT文をセット
			statement = connection
			.prepareStatement (sql);
			// プリペアードステートメントに値をバインド
			statement.setString(1,doctor.getDc_pw());
			statement.setString(2,doctor.getDc_name());
			statement.setString(3,doctor.getDc_belong());
			statement.setString(4,doctor.getDc_dept());
			statement.setString(5,doctor.getAdmin().getAd_cd());


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

	public boolean doctor_delete (Doctor doctor) throws Exception {
		//コネクションを確立
		Connection connection = getConnection();
		//プリペアードステートメント
		PreparedStatement statement = null;
		// 実行件数
		Boolean success = false;

		try {

			//プリペアードステートメントにUPDATE文をセット
			statement = connection
			.prepareStatement ("update doctor set is_deleted = ? where dc_pw=? ");
			// プリペアードステートメントに値をバインド
			statement.setBoolean(1,true);
			statement.setString(2,doctor.getDc_pw());

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