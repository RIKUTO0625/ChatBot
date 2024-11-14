<%-- 組織アカウント削除画面 jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>組織アカウント削除</title>

</head>
<body>
	<form action="AdminDeleteExecute.action" method="post">
		<h2>アカウント削除</h2>

		<p>本当にアカウントを削除しますか？</p>


		<a href="delete">
			<input type="button" value="はい">
		</a>

	</form>

	<a href="#">
			<input type="button" value="戻る">
	</a>

</body>
</html>