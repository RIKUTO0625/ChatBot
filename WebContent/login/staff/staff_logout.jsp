<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link href="../../common/css/style.css" rel="stylesheet">
    <title>職員ログアウト</title>
</head>

<body>
<%@ include file="../../common/staff_header.jsp" %>
	<h2>ログアウトしますか？</h2>
	<a class="logout" href="StaffLogoutExecute.action">はい</a>
    <a class="logout" href="" onclick="history.back()">いいえ</a>
<%@ include file="../../common/footer.jsp" %>
</body>
</html>
