package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
}