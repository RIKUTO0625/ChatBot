<%-- 医者アカウント削除完了画面 jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>医者アカウント削除完了</title>

</head>

<body>
	<form action="ViewDoctor.action" method="get">
		<h2>医者アカウント削除完了</h2>
		<p>${cd_name}を削除しました</p>
		<input type="submit" value="一覧へ戻る">
	</form>
</body>

</html>