<%-- 組織メンバー削除画面 jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>組織メンバー削除</title>
<link href="../../common/css/login.css" rel="stylesheet">
</head>

<body>
	<div>
		<div class="midasi">
		<h2>組織メンバー削除</h2>
		</div>
		<div class="midasi">
		<p>${staff_name}を削除しますか？</p>
		</div>

		<!-- 組織メンバー削除完了画面へ -->
		<form action="MemberDeleteExecute.action" method="post">
		<div class="button">
        <div class="haibutton">
			<input type="submit" value="はい">
		</form>
		</div>

	<!-- 組織メンバー一覧へ -->
	<form action="Member.action" method="get">
	<div class="iiebutton">
	<input type="submit" value="戻る">
	</div>
	</form>
</div>
</div>

</body>
</html>