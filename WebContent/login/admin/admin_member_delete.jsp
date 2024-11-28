<%-- 組織メンバー削除画面 jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>組織メンバー削除</title>
</head>

<body>
	<div>
		<h2>組織メンバー削除</h2>
		<p>${staff_name}を削除しますか？</p>

		<!-- 組織メンバー削除完了画面へ -->
		<form action="MemberDeleteExecute.action" method="post">
			<input type="submit" value="はい">
		</form>

	<!-- 組織メンバー一覧へ -->
	<form action="Member.action" method="get">
		<input type="submit" value="戻る">
	</form>
</div>

</body>
</html>