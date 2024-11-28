package login.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SendMailDao;
import tool.Action;

public class ViewSendMailAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//ローカル変数の宣言 1
		SendMailDao smDao = new SendMailDao();
		//リクエストパラメータ―の取得 2
		//なし
		//DBからデータ取得 3

		//ビジネスロジック 4


		//DBへデータ保存 5
		//なし
		//レスポンス値をセット 6
		//なし
		//JSPへフォワード 7
		req.getRequestDispatcher("admin_mail_list.jsp").forward(req, res);
	}

}
