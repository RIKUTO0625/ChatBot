package login.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class AddSendMailExecuteAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//ローカル変数の宣言 1
		//なし
		//リクエストパラメータ―の取得 2
		//なし
		//DBからデータ取得 3
		//なし
		//ビジネスロジック 4
		//なし
		//DBへデータ保存 5
		//なし
		//レスポンス値をセット 6
		//なし
		//JSPへフォワード 7

//エラー発生時、作成画面から動かない
//		if(){
//			req.getRequestDispatcher("admin_mail_create.jsp").forward(req, res);
//		}
		req.getRequestDispatcher("admin_mail_create_comp.jsp").forward(req, res);
	}

}
