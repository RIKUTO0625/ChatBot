package login.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class DeleteSendMailAction  extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		//削除予定のメールアドレスを表示させる
		//「(削除するメールアドレス)を削除しますか？」の処理

		//JSPへフォワード
		req.getRequestDispatcher("admin_mail_delete.jsp").forward(req, res);
	}

}

