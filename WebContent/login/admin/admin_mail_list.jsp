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
	<div>
		<h2>通知用メールアドレス一覧</h2>

		<form action="AddSendMail.action" method="post">
			<button type="submit">新規作成</button>
		</form>

		<!-- 1通もない(0通) -->
		<c:if data="${mail_id == null}">
			<p>誰も登録されていません！</p>
		</c:if>

		<!-- 登録されているメールアドレスがある -->
		<c:if data="${mail_id != null}">
			<form action="DeleteSendMail.action" method="post">
				<c:forEach var="mail_id" items="${mail_id}">
					<p>${mail_id.send_mail}</p>
					<button type="submit">削除</button>
				</c:forEach>
			</form>
		</c:if>
	</div>
</body>

</html>