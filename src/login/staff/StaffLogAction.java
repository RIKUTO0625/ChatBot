package login.staff;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Staff;
import dao.ChatDao;
import tool.Action;

public class StaffLogAction extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//ローカル変数の宣言 1
		HttpSession session = req.getSession();//セッション
		ChatDao cDao = new ChatDao();
		Integer year;	//年
		Staff staff = (Staff) session.getAttribute("user");
		List<List<Integer>>staff_log = new ArrayList<>();	//質問の履歴リスト

		//リクエストパラメータ―の取得 2
		String years = req.getParameter("year");
		String month = req.getParameter("month");

		//DBからデータ取得 3


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
                if (sum == 0) {
                    percentages.add(0.0); // 合計が0の場合、割合も0
                } else {
                    // 各要素がそのサブリストの合計に占める割合を計算し、小数点以下2桁に丸める
                    BigDecimal percentage = BigDecimal.valueOf((num / sum) * 100)
                        .setScale(1, RoundingMode.HALF_UP); // 小数点以下1桁、四捨五入
                    percentages.add(percentage.doubleValue());
                }
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
		req.getRequestDispatcher("staff_log.jsp").forward(req, res);
	}
}
