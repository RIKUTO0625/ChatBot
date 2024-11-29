<%-- 通知用メールアドレス削除画面 jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>通知用メールアドレス削除</title>
</head>

<body>
	<div>
		<h2>通知用メールアドレス削除</h2>
	</div>
	<div>
		<p>${send_mail}を削除しますか？</p>

		<div>
			<!-- 通知用メールアドレス削除完了画面へ -->
			<form action="DeleteSendMailExecute.action" method="post">
				<button type="submit">はい</button>
			</form>

			<!-- 通知用メールアドレス一覧へ -->
			<form action="ViewSendMail.action" method="get">
				<button type="submit">戻る</button>
			</form>
		</div>
	</div>
</body>

</html>