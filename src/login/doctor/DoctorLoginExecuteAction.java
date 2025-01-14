package login.doctor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Doctor;
import dao.DoctorDao;
import tool.Action;

public class DoctorLoginExecuteAction extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//ローカル変数の宣言 1
		Doctor doctor = new Doctor();
		DoctorDao dDao = new DoctorDao();

		//リクエストパラメータ―の取得 2
		String admin_cd = req.getParameter("ad_cd");
		String password = req.getParameter("doctor_pw");

		//DBからデータ取得 3
		doctor = dDao.loginDoctor(password, admin_cd);



		//ビジネスロジック 4

		if (doctor != null) {
//			// 認証済みフラグを立てる
//			staff.setAuthenticated(true);

			//Sessionを有効にする
			HttpSession session = req.getSession(true);

			//セッションに"user"という変数名で値はStaff変数の中身
			session.setAttribute("user", doctor);
			//リダイレクト
			res.sendRedirect("User.action");
		} else {
			Map<String, String> errors = new HashMap<>();// エラーメッセージ
			errors.put("1", "ログインに失敗しました。組織コードまたはパスワードが違います。");
			req.setAttribute("errors", errors);
			req.getRequestDispatcher("doctor_login.jsp").forward(req, res);
		}

		//JSPへフォワード 7

//		req.getRequestDispatcher("doctor_mypage.jsp").forward(req, res);
	}
}
