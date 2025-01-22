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

import tool.Action;

public class Yamani2Action extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {


        String host = "smtp.gmail.com"; // SMTPサーバー
        String port = "587";           // ポート番号
        String username = "dunking0625@gmail.com"; // 送信者のメールアドレス
        String password = "Yoshikawa0625";       // 送信者のメールパスワード（またはアプリパスワード）

        // メール内容
        String to = "gojira1974612@gmail.com."; // 宛先メールアドレス
        String subject = "テストメール";
        String body = "こんにちは、これはEclipseから送信されたテストメールです。";

        // プロパティの設定
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        // セッションの作成
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // メールメッセージの作成
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);

            // メール送信
            Transport.send(message);

            System.out.println("メールが送信されました！");
        } catch (MessagingException e) {
            e.printStackTrace();
        }

	    res.sendRedirect("yamani.jsp");
	}
}
