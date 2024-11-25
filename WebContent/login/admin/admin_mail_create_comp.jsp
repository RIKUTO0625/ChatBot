<%-- 通知用メールアドレス作成完了画面 jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>通知用メールアドレス作成完了</title>
</head>

<body>
	<div>
		<!-- メールアドレス一覧へ -->
		<form action="./ViewSendMail.action" method="get">
			<h2>メールアドレス作成完了</h2>
			<input type="submit" value="一覧へ戻る">
		</form>
	</div>
</body>

</html>