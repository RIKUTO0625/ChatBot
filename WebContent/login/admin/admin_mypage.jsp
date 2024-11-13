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
				<li><a href="#">職員アカウント管理</a></li>
				<li><a href="#">医者アカウント管理</a></li>
				<li><a href="#">通知用メールアドレス管理</a></li>
				<li><a href="#">組織アカウント削除</a></li>
			</ul>
			</nav>
		</header>

		<p>{組織名}</p>

		<h2>組織メンバー一覧</h2>
		<ul>
		<li>{組織メンバー1}<a href="#"><input type="button" value="削除"></a></li>
		</ul>

		<ul>
		<li>{組織メンバー2}<a href="#"><input type="button" value="削除"></a></li>
		</ul>

		<footer>
		</footer>

	</div>
</body>
</html>