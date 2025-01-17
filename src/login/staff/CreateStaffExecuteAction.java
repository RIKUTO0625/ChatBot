package login.staff;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Admin;
import bean.Staff;
import dao.StaffDao;
import tool.Action;

public class CreateStaffExecuteAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
	    HttpSession session = req.getSession();
	    StaffDao sDao = new StaffDao();
	    Map<String, String> errors = new HashMap<>();

	    try {
	        // フォームデータの取得
	        String admin_str = req.getParameter("admin");
	        String staff_name = req.getParameter("staff_name");
	        String staff_mail = req.getParameter("staff_mail");
	        String staff_pw = req.getParameter("staff_pw");
	        String staff_belong = req.getParameter("staff_belong");
	        String staff_id = req.getParameter("staff_id");

	        // Adminオブジェクトを作成
	        Admin admin = new Admin();
	        admin.setAd_cd(admin_str);

	        // スタッフオブジェクトを作成
	        Staff staff = new Staff();
	        staff.setAdmin(admin);
	        staff.setStaff_name(staff_name);
	        staff.setStaff_mail(staff_mail);
	        staff.setStaff_pw(staff_pw);
	        staff.setStaff_belong(staff_belong);
	        staff.setStaff_id(staff_id);

	        // データベース処理
	        boolean success = sDao.createStaff(staff);
	        if (success) {
	            res.sendRedirect("staff_create_comp.jsp");
	        } else {
	            // 作成に失敗した場合の処理
	            session.setAttribute("errorMessage", "作成に失敗しました。組織コードまたは職員IDが違います。");
	            res.sendRedirect("staff_create.jsp"); // エラーメッセージを持ったまま戻る
	        }
	    } catch (Exception e) {
	        // 例外発生時の処理
	        e.printStackTrace(); // ログに詳細を出力（本番環境では適切なログ出力を行う）
	        session.setAttribute("errorMessage", "作成に失敗しました。組織コードまたは職員IDが違います。");
	        res.sendRedirect("staff_create.jsp"); // エラーメッセージを持ったまま戻る
	    }
	}

}
