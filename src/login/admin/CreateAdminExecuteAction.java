package login.admin;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Admin;
import login.admin.AdminDao;
import tool.Action;

public class CreateAdminExecuteAction extends Action{

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        // ローカル変数の宣言
        HttpSession session = req.getSession(); // セッション
        AdminDao aDao = new AdminDao(); // 組織Daoを初期化

        String ad_cd = req.getParameter("ad_cd"); // 組織コード
        String ad_pw = req.getParameter("ad_pw"); // パスワード
        Admin admin = null; //職員
        Map<String, String> errors = new HashMap<>();// エラーメッセージ

        // DBへデータ保存
        admin = aDao.get(ad_cd);// 主キーのパスワードから組織インスタンスを取得
        if (admin == null) { // 組織が未登録だった場合
            // スタッフインスタンスを初期化
        	admin = new Admin();
            // インスタンスに値をセット
        	admin.setAd_cd(ad_cd); // 組織コード
        	admin.setAd_pw(ad_pw); // パスワード

        	// 組織情報を保存
            aDao.save(admin);
        } else { // 入力されたメールアドレスがDBに保存されていた場合
        	errors.put("staff_cd", "組織コードが重複します");
            return;
        }
		req.getRequestDispatcher("admin_create_comp.jsp").forward(req, res);
	}
}
