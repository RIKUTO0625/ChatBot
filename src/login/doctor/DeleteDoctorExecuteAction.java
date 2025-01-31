package login.doctor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Admin;
import bean.Doctor;
import dao.DoctorDao;
import tool.Action;

public class DeleteDoctorExecuteAction extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		//ローカル変数の宣言
		HttpSession session = req.getSession();//セッション
		Doctor doctor = (Doctor)session.getAttribute("doctor");// 医者情報を取得
		Map<String, String> errors = new HashMap<>();//エラーメッセージ
		Admin admin = (Admin)session.getAttribute("user");// ログインユーザーを取得
		req.setAttribute("ad_name", admin.getAd_name()); // 名前

		DoctorDao dDao = new DoctorDao();

		System.out.println(doctor);

		//ビジネスロジック

		if (doctor != null) {
			// インスタンスに値をセット

			System.out.println("条件分岐１");

			dDao.doctor_delete(doctor);

			session.removeAttribute("doctor");
			//JSPへフォワード
			req.getRequestDispatcher("doctor_delete_comp.jsp").forward(req, res);


		} else {

			System.out.println("条件分岐２");

			errors.put("delete", "削除が出来ませんでした");
			//JSPへフォワード
			req.getRequestDispatcher("doctor_delete.jsp").forward(req, res);
		}
	}

}
