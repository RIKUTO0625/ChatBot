package login.staff;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

        List<Chat>list = new ArrayList<>();		//履歴のリスト
        List<String>question_list = new ArrayList<>();	//質問の履歴リスト
        List<String>answer_list = new ArrayList<>();	//回答の履歴リスト
        String question_new;	//次の質問
        Integer qu_id;		//次の質問のID

        // セッションから"staff"という名前でStaffオブジェクトを取得
        Staff staff = (Staff) session.getAttribute("user");

		//リクエストパラメータ―の取得 2

        String question_st = req.getParameter("qu_id");	//質問
        String answer_st = req.getParameter("answer");		//回答

		//DBからデータ取得 3

		//ビジネスロジック 4
        System.out.println(answer_st);
        System.out.println(question_st);

        //質問と回答内容の記録
        if (answer_st != null && question_st != null){
            Integer question = Integer.parseInt(question_st);	//Int型に変換
            Integer answer = Integer.parseInt(answer_st);		//Int型に変換
        	cDao.setChat(staff, answer, question);
        }

        // 今日の日付を取得
        LocalDate today = LocalDate.now();

        // 日付フォーマットの定義 (例: yyyy-MM-dd)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // 今日の日付を文字列に変換
        String formattedDate = today.format(formatter);

        //チャット履歴の取得
        list = cDao.getChat(staff, formattedDate);
        System.out.println(list);


        if(list != null){	//履歴の格納
	        // que_noだけを抽出
	        List<Integer> que_no_list = list.stream()
	                                   	.map(Chat::getQue_no) // getQue_noメソッドを使用して質問を取得
	                                   	.collect(Collectors.toList()); // リストに収集

	        // ans_noだけを抽出
	        List<Integer> ans_no_list = list.stream()
	                                   	.map(Chat::getAns_no) // getAns_noメソッドを使用して解答を取得
	                                   	.collect(Collectors.toList()); // リストに収集

	        System.out.println(que_no_list);
	        System.out.println(ans_no_list);

	        //質問内容のリスト化
	        for (Integer data : que_no_list){
	        	question_list.add(cDao.getQueText(data));
	        }

	        //回答内容のリスト化
	        for (Integer data : ans_no_list){
	        	answer_list.add(cDao.getAnsText(data));
	        }
	        System.out.println("通過");

	        qu_id = list.size()+1;
	        question_new = cDao.getQueText(qu_id);

        }
        else {	//初回だった場合
        	qu_id = 1;
        	question_new = cDao.getQueText(qu_id);

        }
		//DBへデータ保存 5
		//なし

		//レスポンス値をセット 6
        System.out.print("Actionは大丈夫");
        req.setAttribute("question_list", question_list);	//今までの質問
        req.setAttribute("answer_list", answer_list);		//今までの回答
        req.setAttribute("question", question_new);		//次に渡される質問
        req.setAttribute("qu_id", qu_id);		//次に渡される質問ID

		//JSPへフォワード 7
		req.getRequestDispatcher("chatbot.jsp").forward(req, res);
	}
}
