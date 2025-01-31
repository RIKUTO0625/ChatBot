package login.adm;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Admin;
import dao.AdminDao;
import tool.Action;

public class CreateAdminExecuteAction extends Action{

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        // ローカル変数の宣言
        HttpSession session = req.getSession(); // セッション
        AdminDao aDao = new AdminDao(); // 組織Daoを初期化
        String ad_cd = req.getParameter("ad_cd"); // 組織コード
        String ad_pw = req.getParameter("ad_pw"); // パスワード
        Map<String, String> errors = new HashMap<>();// エラーメッセージ

     // 入力値チェック
        if (ad_cd == null || ad_cd.isEmpty()) {
            errors.put("ad_cd", "組織コードを入力してください。"); // 未入力の確認
        }
        if (ad_pw == null || ad_pw.isEmpty()) {
            errors.put("ad_pw", "パスワードを入力してください。"); // 未入力の確認
        }

        // エラーがある場合は、エラーメッセージをセッションに保存して戻る
        if (!errors.isEmpty()) {
            session.setAttribute("errors", errors);
            res.sendRedirect("admin_create.jsp"); // 入力フォームページへ戻る
            return;
        }

        // 入力が正しければ、新しい管理者オブジェクトを作成
        Admin admin = new Admin();
        admin.setAd_cd(ad_cd); // 組織コード
        admin.setAd_pw(ad_pw); // パスワード

        // データベースに管理者情報を保存
        Boolean success = aDao.createAdmin(admin);
        if (success) {
            res.sendRedirect("admin_create_comp.jsp"); // 登録完了ページへ遷移
        } else {
            errors.put("database", "データベースエラーが発生しました。");
            session.setAttribute("errors", errors);
            res.sendRedirect("admin_create.jsp"); // 入力フォームページへ戻る
        }
	}
}
