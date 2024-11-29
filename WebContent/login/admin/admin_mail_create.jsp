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
	<div class="midasi"> <!-- 見出し -->
		<h2>通知用メールアドレス設定</h2>
	</div>
	<div> <!-- メインページ -->
		<form action="AddSendMailExecute.action" method="post">
		<div class="input_box">
			<label>メールアドレス</label>
				<input type="text" name="send_mail" placeholder="メールアドレスを入力してください"
					   maxlength="30" value="${send_mail}" required />
				<div>${errors.get(send_mail)}</div>
		</div>
			<div class="button">
				<a href="ViewSendMail.action">戻る</a>
				<input type="submit" value="新規登録">
			</div>
		</form>
	</div>
</body>

</html>