package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Admin;
import bean.Doctor;

public class DoctorDao extends Dao {

	// 職員ログイン時
    public Doctor loginDoctor(String dc_pw, String ad_cd) throws Exception{

    	Doctor doctor = null;

    	//school_cdによってJOIN SCHOOLさせて、SCHOOL_nameがゲットできるように
        String sql = "SELECT * FROM doctor where dc_pw = ? and ad_cd = ? and is_deleted = false";

        Connection conn = getConnection();
	    PreparedStatement stmt = conn.prepareStatement(sql);
	    stmt.setString(1, dc_pw);
	    stmt.setString(2, ad_cd);

	    ResultSet rs = stmt.executeQuery();

        if (rs.next()) { // 認証成功の場合（該当アカウントがあった場合）
        	String pw = rs.getString("dc_pw");
            String name = rs.getString("dc_name");
            String belong = rs.getString("dc_belong");
            String cd = rs.getString("ad_cd");
            String dept = rs.getString("dc_dept");
            Boolean deleted = rs.getBoolean("is_deleted");

	        doctor = new Doctor();
	        Admin admin = new Admin();

	        doctor.setDc_pw(pw);
	        admin.setAd_cd(cd);
            doctor.setAdmin(admin);
	        doctor.setDc_name(name);
	        doctor.setDc_belong(belong);
	        doctor.setDc_dept(dept);
	        doctor.setIs_deleted(deleted);

        }

        return doctor;
    }


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

	private List<Doctor> changeList(ResultSet rSet) throws Exception {

		// リストを初期化
	    List<Doctor> list = new ArrayList<>();

	    try {
	        // リザルトセットを全権走査
	        while (rSet.next()) {
	            // 職員インスタンスを初期化
	            Doctor doctor = new Doctor();
	            Admin admin = new Admin();

	            // 学生インスタンスに検索結果をセット
	            doctor.setDc_pw(rSet.getString("dc_pw"));
	            doctor.setDc_name(rSet.getString("dc_name"));
	            doctor.setDc_belong(rSet.getString("dc_belong"));
	            doctor.setDc_dept(rSet.getString("dc_dept"));
	            admin.setAd_cd(rSet.getString("ad_cd"));
	            doctor.setAdmin(admin);

	            // リストに追加
	            list.add(doctor);
	        }

	    } catch (SQLException | NullPointerException e) {
	        e.printStackTrace();
	    }

	    return list;
	}


	//フィルター
	public List<Doctor> viewDoctor(String admin_cd) throws Exception {


		//リストを作り、職員を
		List<Doctor> dc_list = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement statement = null;
        ResultSet rSet = null;

        try {
            statement = connection.prepareStatement(
            "SELECT * FROM doctor " +
            	" where ad_cd = ? and is_deleted = false " +
				" ORDER BY dc_belong ASC, dc_name ASC ");

            statement.setString(1,admin_cd) ;

            rSet = statement.executeQuery();
            dc_list = changeList(rSet);

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

        return dc_list;
	}


}