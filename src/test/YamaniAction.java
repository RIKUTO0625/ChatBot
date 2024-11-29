package test;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Admin;
import bean.Doctor;
import bean.SendMail;
import bean.Staff;
import dao.AdminDao;
import dao.DoctorDao;
import dao.SendMailDao;
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


		//メール表示：〇
		SendMailDao mail_dao = new SendMailDao();
		SendMail mail = new SendMail();
		Admin mail_admin = new Admin();
		mail_admin.setAd_cd("000000");
		mail.setMail_id("3");
		mail.setSend_mail("example");
		mail.setAdmin(mail_admin);

		//メール作成：〇
//		mail_dao.createMail(mail);

		//メール削除
		mail_dao.deleteMail(mail);

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

		//職員一覧表示：〇
		List<Staff> staff_list = staff_dao.viewStaff(staff.getAdmin().getAd_cd());

		//職員検索：
		String keyword = "%" + "しゅん" + "%";
		List<Staff> search_list = staff_dao.searchStaff("000000", keyword);

		//組織ログイン：〇
		AdminDao admin_dao = new AdminDao();
	    Admin admin = admin_dao.loginAdmin("000000", "pass");

	    //医者ログイン：〇
	    DoctorDao doctor_dao = new DoctorDao();
	    Admin doctor = doctor_dao.loginDoctor("pass", "000000");

	    //メールリスト:〇
		List<SendMail> mail_list = mail_dao.viewMail("000000");
		System.out.println(mail_list);

		//医者一覧表示:〇
		List<Doctor> dc_list = doctor_dao.viewDoctor("000000");

	    req.setAttribute("staff", staff);
	    req.setAttribute("staff_list", staff_list);
	    req.setAttribute("search_list", search_list);
	    req.setAttribute("mail_list", mail_list);
	    //req.setAttribute("admin", admin);
//	    req.setAttribute("doctor", doctor);
	    req.setAttribute("dc_list", dc_list);

		req.getRequestDispatcher("yamani.jsp").forward(req, res);
	}
}
