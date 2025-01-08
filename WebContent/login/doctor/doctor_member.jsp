<%-- 医者アカウント管理画面 jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>医者アカウント管理</title>

</head>
<body>
	<h2>医者アカウント管理</h2>

	<form action="CreateDoctor.action" method="post">
		<input type="submit" value="新規作成">
	</form>

	<c:if test="${empty doctorList}">
		<p>誰も登録されていません！</p>
	</c:if>

	<c:if test="${not empty doctorList}">

		<form action="DeleteDoctor.action" method="post">

		<c:forEach var="doctor" items="${doctorList}">
			<p>${doctor.dc_belong}病院：${doctor.dc_dept}科：${doctor.dc_name}</p>
			<input type="submit" value="削除">
		</c:forEach>
		</form>
	</c:if>

</body>
</html>