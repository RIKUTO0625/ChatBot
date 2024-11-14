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
			<a href="#">home</a>
			<a href="#">ログアウト</a>
			<nav>
			<ul>
				<li><a href="#">My Page</a></li>
				<li><a href="#">Chatbot</a></li>
				<li><a href="#">log</a></li>
			</ul>
			<ul>
				<li><a href="#">HOME</a></li>
				<li><a href="#">Logout</a></li>
			</ul>

			</nav>
		</header>

		<h2>アカウント削除</h2>

		<p>本当にアカウントを削除しますか？</p>

		<a href="#">
			<input type="button" value="戻る">
		</a>

		<a href="#">
			<input type="button" value="はい">
		</a>

		<footer>
		</footer>

	</div>
</body>
</html>