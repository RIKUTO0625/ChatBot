<%-- 組織メンバー削除完了画面 jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>組織メンバー削除完了</title>
<link href="../../common/css/login.css" rel="stylesheet">
</head>

<body>
	<div>
	<div class="midasi">
		<h2>組織メンバー削除完了</h2>
		<p>${staff_name}を削除しました</p>
		</div>

		<!-- 組織メンバー一覧へ -->
		<form action="Member.action" method="get">
		<div class="button">
			<input type="submit" value="一覧へ戻る">
			</div>
		</form>
	</div>
</body>

</html>