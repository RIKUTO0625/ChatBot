
package login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class TestAction extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("★★★★★★★★★★");

		req.getRequestDispatcher("homepage.jsp").forward(req, res);
	}
}
