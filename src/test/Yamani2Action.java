package test;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Admin;
import bean.Staff;
import dao.ChatDao;
import dao.StaffDao;
import tool.Action;

public class Yamani2Action extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

	    HttpSession session = req.getSession();
	    StaffDao sDao = new ChatDao();
	    Map<String, String> errors = new HashMap<>();

	    // Adminオブジェクトを作成
	    Admin admin = new Admin();
	    admin.setAd_cd(admin_str);

	    // スタッフオブジェクトを作成
	    Staff staff = new Staff();
	    staff.setAdmin(admin);
	    staff.setStaff_name(staff_name);
	    staff.setStaff_mail(staff_mail);
	    staff.setStaff_pw(staff_pw);
	    staff.setStaff_belong(staff_belong);
	    staff.setStaff_id(staff_id);

	    // データベース処理
	    boolean success = sDao.createStaff(staff);
	}
}
