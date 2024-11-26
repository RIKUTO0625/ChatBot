package login.doctor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tool.Action;

public class DeleteDoctorExecuteAction extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		//ローカル変数の宣言
		HttpSession session=req.getSession();

		//ビジネスロジック
		session.removeAttribute("dc_name");

		//JSPへフォワード 7
		req.getRequestDispatcher("doctor_delete_comp.jsp").forward(req, res);
	}

}
