package login.doctor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Doctor;
import dao.DoctorDao;
import tool.Action;

public class DeleteDoctorAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//ローカル変数の宣言 1
		HttpSession session = req.getSession(); // セッション
	    DoctorDao dDao = new DoctorDao();
	    Doctor doctor = null; //医者
	    Map<String, String> errors = new HashMap<>();//エラーメッセージ
		//リクエストパラメータ―の取得 2
	    String admin_cd = req.getParameter("ad_cd");
	    String dc_name = req.getParameter("dc_name");

		//DBからデータ取得 3
	    doctor = dDao.loginDoctor(admin_cd,dc_name);
		//ビジネスロジック 4
		//なし
		//DBへデータ保存 5
		//なし
		//レスポンス値をセット 6
		//なし
		//JSPへフォワード 7
		req.getRequestDispatcher("doctor_delete.jsp").forward(req, res);
	}

}
