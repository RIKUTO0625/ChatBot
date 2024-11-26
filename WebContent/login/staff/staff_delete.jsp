<%-- 職員アカウント削除画面 jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>職員アカウント削除</title>

</head>
<body>
	<div>
		<h2>アカウント削除</h2>
		<p>本当にアカウントを削除しますか？</p>
		<form action="DeleteStaffExecute.action" method="post">
			<input type="submit" value="はい">
		</form>

		<!-- 職員マイページへ -->
		<a href="StaffMypage.action">
			<input type="button" value="戻る">
		</a>
	</div>
</body>
</html>