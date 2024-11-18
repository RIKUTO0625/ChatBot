<%-- 医者アカウント管理画面 jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>医者アカウント管理</title>

</head>
<body>
	<h2>医者アカウント管理</h2>

		<c:if data="${Doctor == null}">
			<p>誰も登録されていません！</p>
		</c:if>

		<c:if data="${not empty staff_name}">

			<form action="CreateDoctor.action" method="post">
				<input type="submit" value="新規作成">
			</form>

			<form action="DeleteDoctor.action" method="post">

			<c:forEach var="doctor" items="${Doctor}">
				<p>${Doctor.cd_belong}病院：</p>
				<p>${Doctor.cd_dept}科：</p>
				<p>${Doctor.cd_name}</p>
				<input type="submit" value="削除">
			</c:forEach>
			</form>
		</c:if>

</body>
</html>