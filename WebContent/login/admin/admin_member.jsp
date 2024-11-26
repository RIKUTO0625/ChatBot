<%-- 組織メンバー一覧画面 jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>組織メンバー一覧</title>

</head>
<body>
	<div>
		<div>"${ad_name}"</div>
		<h2>組織メンバー一覧</h2>

		<form action="CreateAdmin.action" method="post">
			<input type="submit" value="新規作成">
		</form>

		<!-- 組織メンバーが誰もいない(0人) -->
		<c:if data="${Staff == null}">
			<p>誰も登録されていません！</p>
		</c:if>

		<!-- 誰かしらの組織メンバーがいる(1人以上) -->
		<c:if data="${not empty staff_name}">
			<form action="MemberDelete.action" method="post">
				<c:forEach var="admin" items="${Admin}">
					<p>氏名：${Admin.staff_name}</p>
					<p>所属：${Admin.staff_belong}</p>
					<input type="submit" value="削除">
				</c:forEach>
			</form>
		</c:if>
	</div>

</body>
</html>