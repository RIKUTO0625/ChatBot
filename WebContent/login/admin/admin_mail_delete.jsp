<%-- 通知用メールアドレス削除画面 jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>通知用メールアドレス削除</title>
<link href="../../common/css/login.css" rel="stylesheet">
</head>

<body>
	<div>
		<div class="midasi">
		<h2>通知用メールアドレス削除</h2>
		</div>
	</div>
	<div>
	<div class="midasi">
			<p>${param.mail_address}を削除しますか？</p>
			</div>
		<div>
			<!-- 通知用メールアドレス削除完了画面へ -->
			<form action="DeleteSendMailExecute.action" method="post">

				<div class="button">
				<div class="haibutton">
				<input type="submit" value="はい">
				</div>

			</form>

			<!-- 通知用メールアドレス一覧へ -->
			<form action="ViewSendMail.action" method="get">
			<div class="iiebutton">
				<input type="submit" value="戻る">
				</div>
				</div>
			</form>
		</div>
	</div>
</body>

</html>