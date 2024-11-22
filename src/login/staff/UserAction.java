package login.staff;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Staff;
import dao.StaffDao;
import tool.Action;

public class UserAction extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//ローカル変数の宣言 1
		
		StaffDao sDao = new StaffDao();
		List<Staff> staffs = null;

		//リクエストパラメータ―の取得 2

		staff = req.getParameter("f1");

		//DBからデータ取得 3

		//AWSとのデータの受け渡し処理★★★

		//ビジネスロジック 4
		//なし
		//DBへデータ保存 5
		//なし
		//レスポンス値をセット 6
		//なし
		//JSPへフォワード 7
		req.getRequestDispatcher(".jsp").forward(req, res);
	}
}
