<%-- 通知用メールアドレス削除完了画面 jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>通知用メールアドレス削除完了</title>
</head>

<body>
	<div class="page">
		<!-- メールアドレス一覧へ -->
		<form action="./ViewSendMail.action" method="get">
			<h2>メールアドレス削除完了</h2>
			<button type="submit" id="return">一覧へ戻る</button>
		</form>
	</div>
</body>

</html>