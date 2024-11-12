<%-- 共通テンプレート --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<title>${param.title}</title>

${param.scripts}
</head>
<body>
	<div id="wrapper" class="container">
		<header>
			<h2>chatbot</h2>
			<input type="button" onclick="#" value="HOME">
			<a href="#">ログイン</a>
		</header>


		<h2>組織ログイン</h2>

		<label>組織コード</label>
		<input type="text" maxlength="6">


		<label>パスワード</label>
		<input type="text" maxlength="20">

		<input type="button" onclick="#" value="ログイン">

		<p>アカウントをお持ちでない場合<a href="#">こちら</a></p>

		<input type="button" onclick="#" value="医者アカウントでログイン">
		<input type="button" onclick="#" value="職員アカウントでログイン">


		<footer>
		</footer>

	</div>
</body>
</html>