<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 上記はJSPの基本設定です。ページの言語はJava、文字エンコーディングはUTF-8で設定し、
     JSTLのcoreライブラリ（cタグ）を使用できるようにしています -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>アカウント新規作成（医師）</title> <!-- ページのタイトルを「得点管理システム」としています -->
</head>
<body>
<h2>アカウント新規作成（医師）</h2>
	<form action="CreateDoctorExecute.action" method="post">
		<!-- 学生情報を送信するフォーム。POSTメソッドで「StudentCreateExecute.action」へ送信 -->

		<label>名前</label> <!-- 学生番号の入力欄のラベル -->
		<input type="text" name="dc_name"
			placeholder="名前を入力してください" maxlength="6" value="${dc_name}" required />
		<div>${errors.get("dc_name")}</div>

		<label>所属病院</label> <!-- 学生番号の入力欄のラベル -->
		<input type="text" name="dc_belong"
			placeholder="所属病院を入力してください" maxlength="15" value="${dc_belong}" required />
		<div>${errors.get("dc_belong")}</div> <!-- エラーメッセージ表示エリア：学生番号のエラー -->

		<label>診療科</label> <!-- 氏名の入力欄のラベル -->
		<input type="text" name="cd_dept"
			placeholder="診療科を入力してください" maxlength="10" value="${cd_dept}" required />
		<div>${errors.get("cd_dept")}</div> <!-- エラーメッセージ表示エリア：氏名のエラー -->

		<label>パスワード</label> <!-- 氏名の入力欄のラベル -->
		<input type="text" name="dc_pw"
			placeholder="パスワードを入力してください" maxlength="20" value="${dc_pw}" required />
		<div>${errors.get("dc_pw")}</div> <!-- エラーメッセージ表示エリア：氏名のエラー -->


		<input type="submit" value="登録"> <!-- 登録ボタン -->
	</form>

</body>
</html>
