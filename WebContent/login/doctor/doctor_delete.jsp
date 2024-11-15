<%-- 医者アカウント削除画面 jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>医者アカウント削除</title>

</head>
<body>
	<form action="DeleteDoctorExecute.action" method="post">
		<h2>医者アカウント削除</h2>
		<p>${cd_name}を削除しますか？</p>
		<input type="submit" value="はい">
	</form>

	<!-- 医者アカウント一覧へ -->
	<a href="ViewDoctor.action">
		<input type="button" value="戻る">
	</a>

</body>
</html>