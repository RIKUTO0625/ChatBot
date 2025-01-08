<%-- 通知用メールアドレス一覧画面 jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<link href="../../common/css/sendmail.css" rel="stylesheet">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>通知用メールアドレス一覧</title>
</head>

<body>
	<div>
		<div>${ad_name}</div>
		<div class="midasi">
		<h2>通知用メールアドレス一覧</h2>
		</div>

		<form action="AddSendMail.action" method="post">
			<div class="button">
			<input type="submit" value="新規作成">
			</div>
		</form>

		<!-- 1通もない(0通) -->
		<c:if test="${empty mailList}">
			<p>誰も登録されていません！</p>
		</c:if>

		<!-- 登録されているメールアドレスがある -->
		<c:if test="${not empty mailList}">
			<c:forEach var="sendmail" items="${mailList}">
				<form action="DeleteSendMail.action" method="post">
					<p>メールアドレス：${sendmail.mail_id}</p>
					<input type="hidden" name="mail_id" value="${sendmail.mail_id}"/>
					<input type="submit" value="削除">
				</form>

			</c:forEach>
		</c:if>
	</div>
</body>

</html>