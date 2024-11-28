package login.doctor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Doctor;
import dao.DoctorDao;
import tool.Action;

public class DeleteDoctorExecuteAction extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		//ローカル変数の宣言
		HttpSession session = req.getSession();//セッション
		Doctor doctor = (Doctor)session.getAttribute("doctor");// ログインユーザーを取得
		Map<String, String> errors = new HashMap<>();//エラーメッセージ

		DoctorDao dDao = new DoctorDao();

		//ビジネスロジック

		if (doctor != null) {
			// インスタンスに値をセット

			dDao.doctor_delete(doctor);

			session.removeAttribute("doctor");
			//JSPへフォワード
			req.getRequestDispatcher("doctor_delete_comp.jsp").forward(req, res);


		} else {
			errors.put("delete", "削除が出来ませんでした");
			//JSPへフォワード
			req.getRequestDispatcher("doctor_delete.jsp").forward(req, res);
		}
	}

}
