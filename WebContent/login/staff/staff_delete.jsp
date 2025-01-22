<%-- 職員アカウント削除画面 jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>職員アカウント削除</title>
<link href="../../common/css/login.css" rel="stylesheet">

</head>
<body>
	<div>
		<div class="midasi">
		<h2>アカウント削除</h2>
		<p>本当にアカウントを削除しますか？</p>
		</div>

		<div class="button">

		<!-- 職員マイページへ -->

		<div class="haibutton">
		<a href="#" onclick="history.back(); return false;">戻る</a>
		</div>

		<div class="iiebutton">
		<a href="MemberDeleteExecute.action">はい</a>
		</div>

	</div>
</body>
</html>