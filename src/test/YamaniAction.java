package test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Admin;
import bean.Staff;
import dao.AdminDao;
import dao.DoctorDao;
import dao.StaffDao;
import dao.rds;
import tool.Action;

public class YamaniAction extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("テスト開始");

		rds test = new rds();

		StaffDao staff_dao = new StaffDao();
		Staff staff = staff_dao.loginStaff("staff000", "pass");


		AdminDao admin_dao = new AdminDao();
	    Admin admin = admin_dao.loginAdmin("000000", "pass");

	    DoctorDao doctor_dao = new DoctorDao();
	    Admin doctor = doctor_dao.loginDoctor("pass", "000000");

	    req.setAttribute("staff", staff);
	    req.setAttribute("admin", admin);
	    req.setAttribute("doctor", doctor);

		req.getRequestDispatcher("yamani.jsp").forward(req, res);
	}
}
