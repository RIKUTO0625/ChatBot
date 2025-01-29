package login.staff;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
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
		Integer year = null;	//年
		Integer month = null;	//月
		Staff staff = (Staff) session.getAttribute("user");
		List<List<Integer>>staff_log = new ArrayList<>();	//質問の履歴リスト

		//リクエストパラメータ―の取得 2
		String years = req.getParameter("year");
		String months = req.getParameter("month");

		//DBからデータ取得 3

		if(years != null){	//年をINT型に変更
			year = Integer.parseInt(years);
		}
		else {
			year = Year.now().getValue();
		}
		System.out.println(months);
		if(months != null ){	//月をINT型に変更
			if(!months.equals("なし")){
				month = Integer.parseInt(months);
			}
		}

		if(months == null || months.equals("なし")){
			staff_log = cDao.getHis(staff, year);
		}
		else{
			staff_log = cDao.getHisMonth(staff, year, month);
		}
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
        // staff_log の内容をチェックしてエラーメッセージを設定
     // Java 9以降の List.of を Java 8 以下の環境に対応させる
        boolean isError = true;
        for (List<Integer> sublist : staff_log) {
            if (!sublist.equals(Arrays.asList(0, 0, 0, 0, 0))) {
                isError = false; // 1つでも異なるサブリストがあればエラーではない
                break;
            }
        }

        // エラーメッセージの設定
        if (isError) {
            req.setAttribute("errorMessage", "データはまだありません");
        } else {
            req.setAttribute("staffLog", staff_log);
            req.setAttribute("name", staff.getStaff_name());
        }

		//JSPへフォワード 7
        System.out.println(staff_log);
		req.getRequestDispatcher("staff_log.jsp").forward(req, res);
	}
}
