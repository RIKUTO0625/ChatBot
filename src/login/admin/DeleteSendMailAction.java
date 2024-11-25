package login.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class DeleteSendMailAction  extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		//JSPへフォワード 7
		req.getRequestDispatcher("admin_mail_delete.jsp").forward(req, res);
	}

}

