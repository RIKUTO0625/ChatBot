<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link href="../../common/css/style.css" rel="stylesheet">
    <title>職員ログアウト</title>
</head>
<%@ include file="../../common/staff_header.jsp" %>
<body class="logout_body">

	<h1>ログアウトしますか？</h1>
	<a class="logout" href="StaffLogoutExecute.action">はい</a>
    <a class="logout" href="" onclick="history.back()">いいえ</a>

</body>
<%@ include file="../../common/footer.jsp" %>
</html>
