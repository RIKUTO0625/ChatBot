package login.doctor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Admin;
import bean.Doctor;
import dao.DoctorDao;
import tool.Action;

public class ViewDoctorAction extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession();
		DoctorDao dDao = new DoctorDao();
		List<Doctor> doctor = null; // 職員
		Admin admin = (Admin)session.getAttribute("user");// ログインユーザーを取得

		doctor = dDao.viewDoctor(admin.getAd_cd());

		req.setAttribute("doctorList", doctor);


		//JSPへフォワード 7
		req.getRequestDispatcher("doctor_member.jsp").forward(req, res);
	}
}

