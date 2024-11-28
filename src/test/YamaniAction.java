package test;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Staff;
import dao.StaffDao;
import dao.rds;
import tool.Action;

public class YamaniAction extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("テスト開始");

		rds test = new rds();

        //職員ログイン：〇
		StaffDao staff_dao = new StaffDao();
		Staff staff = staff_dao.loginStaff("staff000", "pass");


		//職員アカウント作成：〇
//		Staff created_staff = new Staff();
//		Admin created_admin = new Admin();
//		created_admin.setAd_cd("000000");
//
//		created_staff.setStaff_id("staff002");
//		created_staff.setStaff_name("削除用");
//		created_staff.setStaff_belong("総務課");
//		created_staff.setStaff_pw("pass");
//		created_staff.setStaff_mail("example@gmail.com");
//		created_staff.setAdmin(created_admin);
//		staff_dao.createStaff(created_staff);

        //プロフィール編集：〇
//		staff.setFavorite("read book");
//		staff.setStaff_mail("example@gmail.com");
//		staff_dao.editStaff(staff);

		//職員一覧表示：
		List<Staff> staff_list = staff_dao.viewStaff(staff.getAd_cd());

		//組織ログイン：〇
//		AdminDao admin_dao = new AdminDao();
//	    Admin admin = admin_dao.loginAdmin("000000", "pass");

	    //医者ログイン：〇
	    //DoctorDao doctor_dao = new DoctorDao();
	    //Admin doctor = doctor_dao.loginDoctor("pass", "000000");


	    req.setAttribute("staff", staff);
	    req.setAttribute("staff_list", staff_list);
	    //req.setAttribute("admin", admin);
	    //req.setAttribute("doctor", doctor);

		req.getRequestDispatcher("yamani.jsp").forward(req, res);
	}
}
