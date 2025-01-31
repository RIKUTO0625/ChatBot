package login.adm;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Admin;
import dao.AdminDao;
import tool.Action;

public class DeleteAdminExecuteAction extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//ローカル変数の宣言
		HttpSession session = req.getSession();//セッション
		Admin admin = (Admin)session.getAttribute("user");// ログインユーザーを取得
		Map<String, String> errors = new HashMap<>();//エラーメッセージ

		AdminDao aDao = new AdminDao();

		//ビジネスロジック

		if (admin != null) {
			// インスタンスに値をセット

			aDao.admin_delete(admin);

			session.removeAttribute("user");
			//JSPへフォワード
			req.getRequestDispatcher("admin_delete_comp.jsp").forward(req, res);


		} else {
			errors.put("delete", "削除が出来ませんでした");
			//JSPへフォワード
			req.getRequestDispatcher("admin_delete.jsp").forward(req, res);
		}
	}
}
