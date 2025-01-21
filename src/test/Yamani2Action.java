package test;


import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ChatDao;
import tool.Action;

public class Yamani2Action extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {


		ChatDao chatDao = new ChatDao();

	    res.sendRedirect("yamani.jsp");
	}
}
