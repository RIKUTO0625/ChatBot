<%-- 通知用メールアドレス設定画面 jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>通知用メールアドレス設定</title>

</head>
<body>
	<h2>通知用メールアドレス設定</h2>

			<form action="AddSendMailExecute.action" method="post">
				<label>メールアドレス</label>
				<input type="text"
					   name="send_mail"
					   placeholder="メールアドレスを入力してください"
					   maxlength="30"
					   value="${send_mail}"
					   required />
				<div>${errors.get(send_mail)}</div>
				<input type="submit" value="新規作成" >
			</form>

			<form action="ViewSendMail.action" method="get">
				<input type="submit" value="戻る">
			</form>

</body>
</html>