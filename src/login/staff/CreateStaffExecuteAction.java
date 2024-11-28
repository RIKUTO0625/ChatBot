package login;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Staff;
import dao.StaffDao;
import tool.Action;

public class CreateStaffExecuteAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
	    // セッションの取得
	    HttpSession session = req.getSession();

	    // スタッフDaoの初期化
	    StaffDao sDao = new StaffDao();
	    // エラーメッセージ用のMap
	    Map<String, String> errors = new HashMap<>();

	    // フォームから送信されたデータの取得
	    String ad_cd = req.getParameter("ad_cd"); // 組織コード
	    String staff_name = req.getParameter("staff_name"); // 職員名
	    String staff_mail = req.getParameter("staff_mail"); // 職員メールアドレス
	    String staff_pw = req.getParameter("staff_pw"); // パスワード
	    String staff_belong = req.getParameter("staff_belong"); // 所属
	    String staff_id = req.getParameter("staff_id"); // id

	    // 入力値チェック（ifだと最初に見つかったエラーのみの処理が行われるため全部ifで記述）
	    if (ad_cd == null || ad_cd.isEmpty()) {
	        errors.put("ad_cd", "組織コードを入力してください。"); //未入力の確認
	    }
	    if (staff_name == null || staff_name.isEmpty()) {
	        errors.put("staff_name", "職員名を入力してください。"); //未入力の確認
	    }
	    if (staff_mail == null || staff_mail.isEmpty() || !staff_mail.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
	        errors.put("staff_mail", "有効なメールアドレスを入力してください。");
	      //未入力、メールアドレスが正しい形式かの確認
	    }
	    if (staff_pw == null || staff_pw.isEmpty()) {
	        errors.put("staff_pw", "パスワードを入力してください。"); //未入力の確認
	    }
	    if (staff_belong == null || staff_belong.isEmpty()) {
	        errors.put("staff_belong", "所属を入力してください。"); //未入力の確認
	    }
	    if (staff_id == null || staff_id.isEmpty()) {
	        errors.put("staff_id", "IDを入力してください。"); //未入力の確認
	    }

	    // エラーがある場合は、エラーメッセージをセッションに保存して戻る
	    if (!errors.isEmpty()) {
	        session.setAttribute("errors", errors);
	        res.sendRedirect("staff_create.jsp"); // 入力フォームページへ戻る
	        return;
	    }

	    // 入力が正しければ、新しいスタッフオブジェクトを作成
	    Staff staff = new Staff();
	    staff.setAd_cd(ad_cd); // 組織コード
	    staff.setStaff_name(staff_name); // 職員名
	    staff.setStaff_mail(staff_mail); // 職員メールアドレス
	    staff.setStaff_pw(staff_pw); // パスワード
	    staff.setStaff_belong(staff_belong); // 所属
	    staff.setStaff_id(staff_id); // id

	    // データベースにスタッフ情報を保存
	    Boolean success = sDao.createStaff(staff);
	    if (success) {
	        res.sendRedirect("staff_create_comp.jsp"); // 登録完了ページへ遷移
	    } else {
	        errors.put("database", "データベースエラーが発生しました。");
	        session.setAttribute("errors", errors);
	        res.sendRedirect("staff_create.jsp"); // 入力フォームページへ戻る
	    }
	}
}
