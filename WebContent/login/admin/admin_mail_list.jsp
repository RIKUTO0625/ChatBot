<%-- 通知用メールアドレス一覧画面 jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>通知用メールアドレス一覧</title>

</head>
<body>
	<h2>通知用メールアドレス一覧</h2>

		<c:if data="${mail_id == null}">
			<p>誰も登録されていません！</p>
		</c:if>

	<!-- 登録されているメールアドレスがある -->
		<c:if data="${not empty mail_id}">
			<form action="AddSendMail.action" method="post">
				<input type="submit" value="新規作成">
			</form>

			<form action="DeleteSendMail.action" method="post">
				<c:forEach var="mail_id" items="${mail_id}">
					<p>${mail_id.send_mail}</p>
					<input type="submit" value="削除">
				</c:forEach>
			</form>
		</c:if>

</body>
</html>