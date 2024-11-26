package login.staff;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Staff;
import dao.StaffDao;
import tool.Action;

public class StaffLoginExecuteAction extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//ローカル変数の宣言 1
		Staff staff = new Staff();
		StaffDao sDao = new StaffDao();

		//リクエストパラメータ―の取得 2
		String id = req.getParameter("staff_id");
		String password = req.getParameter("staff_pw");

		//DBからデータ取得 3
		staff = sDao.login(password,id);

		//ビジネスロジック 4

		if (staff != null) {
//			// 認証済みフラグを立てる
//			staff.setAuthenticated(true);

			//Sessionを有効にする
			HttpSession session = req.getSession(true);
			//セッションに"user"という変数名で値はStaff変数の中身
			session.setAttribute("user", staff);
			//リダイレクト
			res.sendRedirect("staff_mypage.jsp");
		} else {
			Map<String, String> errors = new HashMap<>();// エラーメッセージ
			errors.put("1", "ログインに失敗しました。職員コードまたはパスワードが違います。");
			req.setAttribute("errors", errors);
			req.getRequestDispatcher("staff_login.jsp").forward(req, res);
		}


		//DBへデータ保存 5
		//なし
		//レスポンス値をセット 6
		//なし
		//JSPへフォワード 7

//		req.getRequestDispatcher("staff_mypage.jsp").forward(req, res);
	}
}
