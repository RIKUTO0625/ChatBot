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

        List<Chat>logList = (List<Chat>) session.getAttribute("logList");		//履歴のリスト
        List<String>question_log = new ArrayList<>();	//質問の履歴リスト
        List<String>answer_log = new ArrayList<>();	//回答の履歴リスト
        String question_new;	//次の質問
        Integer qu_id;		//次の質問のID
        Integer question = null;	//質問
        Integer answer = null;		//回答
        //チャットのリスト（session）
		List<List<Integer>> chatList = (List<List<Integer>>) session.getAttribute("chatList");
		List<String> questionList = (List<String>) session.getAttribute("questionList");	//質問の一覧テーブル(session)
		List<String> answerList = (List<String>) session.getAttribute("answerList");		//回答の一覧テーブル(session)
        List<Integer> chatSubList = new ArrayList<>();		//chatListに格納するためのリスト

        // セッションから"staff"という名前でStaffオブジェクトを取得
        Staff staff = (Staff) session.getAttribute("user");

		//リクエストパラメータ―の取得 2

        String question_st = req.getParameter("qu_id");	//質問
        String answer_st = req.getParameter("answer");	//回答
        System.out.println(question_st);
        System.out.println(answer_st);

		//DBからデータ取得 3

        // 今日の日付を取得
        LocalDate today = LocalDate.now();
        // 日付フォーマットの定義 (例: yyyy-MM-dd)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // 今日の日付を文字列に変換
        String formattedDate = today.format(formatter);

		//ビジネスロジック 4

        //一覧テーブルが無かったら追加
        if (questionList == null && answerList == null){
        	questionList = cDao.getQueTextList();
        	answerList = cDao.getAnsTextList();
        	session.setAttribute("questionList", questionList);
        	session.setAttribute("answerList", answerList);
        }

        //質問と回答内容の記録
        if(answer_st != null && question_st != null && chatList == null){
        	List<List<Integer>> chatListNew = new ArrayList<>();
        	question = Integer.parseInt(question_st);	//Int型に変換
            answer = Integer.parseInt(answer_st);		//Int型に変換
            chatSubList.add(question);
            chatSubList.add(answer);
            chatListNew.add(chatSubList);
            session.setAttribute("chatList", chatListNew);
        }
        else if (answer_st != null && question_st != null){
        	question = Integer.parseInt(question_st);	//Int型に変換
            answer = Integer.parseInt(answer_st);		//Int型に変換
            chatSubList.add(question);
            chatSubList.add(answer);
            System.out.println(chatList);
            chatList.add(chatSubList);
            session.setAttribute("chatList", chatList);
        }


        //チャット履歴の取得
        if (logList == null){
        	logList = cDao.getChat(staff, formattedDate);
        	session.setAttribute("logList", logList);
        }

        if(answer != null && question != null){
        	Chat chat = new Chat();
        	chat.setAns_no(answer);
        	chat.setAns_text(answerList.get(answer-1));
        	chat.setQue_no(question);
        	chat.setQue_text(questionList.get(question-1));
        	logList.add(chat);
        	session.setAttribute("logList", logList);
        }

        System.out.println(logList);
        if(logList != null){
	        if(logList.size() != 0 && logList.size() < questionList.size()){	//質問の上限に達しているかどうか
		        // que_textだけを抽出
		        question_log = logList.stream()
		                        .map(Chat::getQue_text) // getQue_textメソッドを使用して質問を取得
		                        .collect(Collectors.toList()); // リストに収集

		        // ans_textだけを抽出
		        answer_log = logList.stream()
		                      .map(Chat::getAns_text) // getAns_textメソッドを使用して解答を取得
		                      .collect(Collectors.toList()); // リストに収集

		        System.out.println("通過");

		        qu_id = logList.size()+1;
		        question_new = questionList.get(qu_id-1);
	        	}
	        else if(logList.size() != 0){
	            // que_noだけを抽出
	  	        question_log = logList.stream()
	   	                        .map(Chat::getQue_text) // getQue_noメソッドを使用して質問を取得
	   	                        .collect(Collectors.toList()); // リストに収集
	            // ans_noだけを抽出
	   	        answer_log = logList.stream()
	                         .map(Chat::getAns_text) // getAns_noメソッドを使用して解答を取得
	   	                     .collect(Collectors.toList()); // リストに収集

	        	qu_id = 9;
	        	question_new = "以上で質問は終わりとなりますお疲れさまでした";
	        	cDao.setChat(staff, chatList);		//チャットの記録
	        	session.removeAttribute("logList"); //セッションの初期化
	        	session.removeAttribute("chatList");
	        	session.removeAttribute("questionList");
	        	session.removeAttribute("answerList");

	        }
	        else {	//初回だった場合
	        	qu_id = 1;
	        	question_new = questionList.get(qu_id-1);

	        }
        }
        else {	//初回だった場合
        	qu_id = 1;
        	question_new = questionList.get(qu_id-1);
        }
		//DBへデータ保存 5
		//なし

		//レスポンス値をセット 6
        System.out.println("Actionは大丈夫");
        req.setAttribute("question_list", question_log);	//今までの質問
        req.setAttribute("answer_list", answer_log);		//今までの回答
        req.setAttribute("question", question_new);		//次に渡される質問
        req.setAttribute("qu_id", qu_id);		//次に渡される質問ID

		//JSPへフォワード 7
		req.getRequestDispatcher("chatbot.jsp").forward(req, res);
	}
}
