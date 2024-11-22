<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 上記はJSPの基本設定です。ページの言語はJava、文字エンコーディングはUTF-8で設定し、
     JSTLのcoreライブラリ（cタグ）を使用できるようにしています -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>アカウント新規作成（職員）</title> <!-- ページのタイトルを「得点管理システム」としています -->
</head>
<body>
<h2>アカウント新規作成（職員）</h2>
	<form action="CreateStaffExecute.action" method="post">
		<!-- 学生情報を送信するフォーム。POSTメソッドで「StudentCreateExecute.action」へ送信 -->

		<label>組織コード</label> <!-- 学生番号の入力欄のラベル -->
		<input type="text" name="ad_cd"
			placeholder="組織コードを入力してください" maxlength="6" value="${ad_cd}" required />
		<div>${errors.get("ad_cd")}</div>


		<label>名前</label> <!-- 学生番号の入力欄のラベル -->
		<input type="text" name="staff_name"
			placeholder="名前を入力してください" maxlength="20" value="${staff_name}" required />
		<div>${errors.get("staff_name")}</div> <!-- エラーメッセージ表示エリア：学生番号のエラー -->

		<label>メールアドレス</label> <!-- 氏名の入力欄のラベル -->
		<input type="text" name="staff_mail"
			placeholder="メールアドレスを入力してください" maxlength="30" value="${staff_mail}" required />
		<div>${errors.get("staff_mail")}</div> <!-- エラーメッセージ表示エリア：氏名のエラー -->

		<label>パスワード</label> <!-- 氏名の入力欄のラベル -->
		<input type="text" name="staff_pw"
			placeholder="パスワードを入力してください" maxlength="20" value="${staff_pw}" required />
		<div>${errors.get("staff_pw")}</div> <!-- エラーメッセージ表示エリア：氏名のエラー -->


		<label>所属</label> <!-- 学生番号の入力欄のラベル -->
		<input type="text" name="staff_belong"
			placeholder="所属部署を入力してください" maxlength="20" value="${staff_belong}" required />

		<div>${errors.get("staff_belong")}</div> <!-- エラーメッセージ表示エリア：学生番号のエラー -->


		<input type="submit" value="登録"> <!-- 登録ボタン -->
	</form>

	<a href="StaffExecute.action">戻る</a>
</body>
</html>