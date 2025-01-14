package login.doctor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Admin;
import bean.Doctor;
import dao.DoctorDao;
import tool.Action;

public class DeleteDoctorAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//ローカル変数の宣言 1
		HttpSession session = req.getSession(); // セッション
		Admin admin = (Admin)session.getAttribute("user");// ログインユーザーを取得
	    DoctorDao dDao = new DoctorDao();
	    Doctor doctor = null; //医者
		//リクエストパラメータ―の取得 2
	    String admin_cd = admin.getAd_cd();
	    String password = req.getParameter("password");

		//DBからデータ取得 3
	    doctor = dDao.loginDoctor(password,admin_cd);
		//ビジネスロジック

	    System.out.println(doctor);

		//セッションに"doctor"という変数名で値はdoctor変数の中身
		session.setAttribute("doctor", doctor);

		//DBへデータ保存 5

		//レスポンス値をセット 6
		//JSPへフォワード 7
		req.getRequestDispatcher("doctor_delete.jsp").forward(req, res);
	}

}
