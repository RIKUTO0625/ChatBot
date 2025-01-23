package login.doctor;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Staff;
import dao.ChatDao;
import dao.StaffDao;
import tool.Action;

public class UserLogAction extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//ローカル変数の宣言 1
		HttpSession session = req.getSession();//セッション
		StaffDao sDao = new StaffDao();
		ChatDao cDao = new ChatDao();
		Integer year;	//年
		Staff staff;	//職員情報
		List<List<Integer>>staff_log = new ArrayList<>();	//質問の履歴リスト

		//リクエストパラメータ―の取得 2
		String years = req.getParameter("year");
		String month = req.getParameter("month");
		String staff_id = req.getParameter("no");
		String staff_pw = req.getParameter("pw");

		//DBからデータ取得 3

		if(staff_id != null && staff_pw != null){
			staff = sDao.loginStaff(staff_id, staff_pw);
			session.setAttribute("staff", staff);
		}
		else{
			staff = (Staff)session.getAttribute("staff");// 職員情報を取得
		}

		if(years != null){
			year = Integer.parseInt(years);
		}
		else {
			year = Year.now().getValue();
		}

		staff_log = cDao.getHis(staff, year);
		System.out.println(staff_log);


        // 各リストの要素の割合を格納するリスト
        List<List<Double>> percentageList = new ArrayList<>();

        // 各サブリストの合計を計算し、その中での割合を求める
        for (List<Integer> sublist : staff_log) {
            double sum = 0;
            for (int num : sublist) {
                sum += num;
            }

            List<Double> percentages = new ArrayList<>();
            for (int num : sublist) {
                // 各要素がそのサブリストの合計に占める割合を計算
                percentages.add((sum == 0) ? 0.0 : (num / sum) * 100);
            }
            percentageList.add(percentages);
        }

		//質問ごとの回答の統計を渡す処理
        // カウントを1からスタートする
        int index = 1;
        for (List<Double> sublist : percentageList) {
            String key = "list" + index; // キー名を list1, list2, ... とする
            req.setAttribute(key, sublist); // サーブレットのリクエストオブジェクトに設定
            index++;
        }


		//ビジネスロジック 4
		//なし
		//DBへデータ保存 5
		//なし
		//レスポンス値をセット 6
		req.setAttribute("staffLog", staff_log);
        req.setAttribute("name", staff.getStaff_name());
		//JSPへフォワード 7
		req.getRequestDispatcher("user_log.jsp").forward(req, res);
	}
}
