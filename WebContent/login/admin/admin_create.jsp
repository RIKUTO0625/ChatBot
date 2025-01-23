<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 上記はJSPの基本設定です。ページの言語はJava、文字エンコーディングはUTF-8で設定し、
     JSTLのcoreライブラリ（cタグ）を使用できるようにしています -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>アカウント新規作成（組織）</title> <!-- ページのタイトルを「得点管理システム」としています -->
<link href="../../common/css/create.css" rel="stylesheet">
</head>
<body>
<div class="midasi">
<h2>アカウント新規作成（組織）</h2>
</div>
	<form action="CreateAdminExecute.action" method="post">
		<!-- 学生情報を送信するフォーム。POSTメソッドで「StudentCreateExecute.action」へ送信 -->
		<div class="input_box">
		<label>組織コード</label> <!-- 学生番号の入力欄のラベル -->
		<input type="text" name="ad_cd"
			placeholder="組織コードを入力してください" maxlength="6" value="${ad_cd}" required />
		<div>${errors.get("ad_cd")}</div>
		</div>

		<div class="input_box">
		<label>パスワード</label> <!-- パスワードの入力欄のラベル -->
		<input type="text" name="ad_pw"
			placeholder="パスワードを入力してください" maxlength="20" value="${ad_pw}" required />
		<div>${errors.get("ad_pw")}</div> <!-- エラーメッセージ表示エリア：氏名のエラー -->
		</div>
		<div class="button">
		<a href="#" onclick="history.back(); return false;">
		<input type="submit" value="登録"> <!-- 登録ボタン -->
		</div>
	</form>

</body>
</html>
