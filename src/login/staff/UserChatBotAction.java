package login.staff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        ChatDao cDao = new ChatDao();

        List<Chat>list = new ArrayList<>();

        // セッションから"staff"という名前でStaffオブジェクトを取得
        Staff staff = (Staff) session.getAttribute("user");

		//リクエストパラメータ―の取得 2
        Integer question = req.getParameter("question");		//質問
        Integer answer = req.getParameter("answer");		//解答

		//DBからデータ取得 3
        list = cDao.getChat(staff, 1, 1);
        System.out.println(list);


		//ビジネスロジック 4

        //質問と回答内容の記録
        if (answer != null && question != null){
        	cDao.setChat(staff, answer, question);
        }

        // 質問だけを抽出
        List<Integer> questionlist = list.stream()
                                   	.map(Chat::getQue_no) // getQue_noメソッドを使用して質問を取得
                                   	.collect(Collectors.toList()); // リストに収集

        // 解答だけを抽出
        List<Integer> answerlist = list.stream()
                                   	.map(Chat::getAns_no) // getAns_noメソッドを使用して解答を取得
                                   	.collect(Collectors.toList()); // リストに収集

        System.out.println(questionlist);
        System.out.println(answerlist);

		//DBへデータ保存 5
		//なし

		//レスポンス値をセット 6
        req.setAttribute("question_list", questionlist);	//今までの質問
        req.setAttribute("answer_list", answerlist);		//今までの解答
        req.setAttribute("question", question);		//次に渡される質問

		//JSPへフォワード 7
		req.getRequestDispatcher("chatbot.jsp").forward(req, res);
	}
}
