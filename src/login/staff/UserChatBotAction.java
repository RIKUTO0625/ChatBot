package login.staff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Chat;
import bean.Staff;
import dao.ChatDao;
import tool.Action;

public class UserChatBotAction extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//ローカル変数の宣言 1
        // セッションからログイン中のスタッフ情報を取得
        HttpSession session = req.getSession(); // セッション取得
        Map<String, String> errors = new HashMap<>(); // エラーメッセージ

        // セッションから"staff"という名前でStaffオブジェクトを取得
        Staff staff = (Staff) session.getAttribute("user");

		//リクエストパラメータ―の取得 2
		
        
        
		//DBからデータ取得 3

        ChatDao chat = new ChatDao();
        List<Chat>list = new ArrayList<>();
		//ビジネスロジック 4
        list = chat.getChat(staff, 1, 1);
        System.out.println(list);



		//DBへデータ保存 5
		//なし
		//レスポンス値をセット 6
		//なし
		//JSPへフォワード 7
		req.getRequestDispatcher("chatbot.jsp").forward(req, res);
	}
}
