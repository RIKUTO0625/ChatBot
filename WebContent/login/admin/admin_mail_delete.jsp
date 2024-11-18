<%-- 通知用メールアドレス削除画面 jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>通知用メールアドレス削除</title>

</head>
<body>
	<form action="DeleteAdminExecute.action" method="post">
		<h2>通知用メールアドレス削除</h2>
		<p>${send_mail}を削除しますか？</p>
		<input type="submit" value="はい">
	</form>

	<!-- 組織メンバー一覧へ -->
	<a href="ViewSendMail.action">
		<input type="button" value="戻る">
	</a>

</body>
</html>