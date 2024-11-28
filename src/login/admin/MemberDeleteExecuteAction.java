package login.admin;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Staff;
import dao.StaffDao;
import tool.Action;

public class MemberDeleteExecuteAction  extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		//ローカル変数の宣言
		HttpSession session = req.getSession();//セッション
		Staff staff = (Staff)session.getAttribute("staff");// ログインユーザーを取得
		Map<String, String> errors = new HashMap<>();//エラーメッセージ

		StaffDao sDao = new StaffDao();

		//ビジネスロジック
		if (staff != null) {
			// インスタンスに値をセット

			sDao.staff_delete(staff);

			//レスポンス値をセット
			req.setAttribute("staff_name", staff.getStaff_name());

			session.removeAttribute("staff");

			//JSPへフォワード
			req.getRequestDispatcher("admin_member_delete_comp.jsp").forward(req, res);


		} else {
			errors.put("delete", "削除が出来ませんでした");

			//JSPへフォワード
			req.getRequestDispatcher("admin_member_delete.jsp").forward(req, res);
		}
	}

}

