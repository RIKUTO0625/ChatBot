<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="../common/base.jsp">

<!-- 上記はJSPの基本設定です。ページの言語はJava、文字エンコーディングはUTF-8で設定し、
     JSTLのcoreライブラリ（cタグ）を使用できるようにしています -->

<link href="../../common/css/create.css" rel="stylesheet">
	<c:param name="title">
	テスト
	</c:param>

	<c:param name="content">

<div class="midasi">
<h2>アカウント新規作成（医師）</h2>
</div>
	<form action="CreateDoctorExecute.action" method="post">
		<!-- 学生情報を送信するフォーム。POSTメソッドで「StudentCreateExecute.action」へ送信 -->
		<div class="input_box">
		<label>名前</label> <!-- 学生番号の入力欄のラベル -->
		<input type="text" name="dc_name"
			placeholder="名前を入力してください" maxlength="6" value="${dc_name}" required />
		<div>${errors.get("dc_name")}</div>
		</div>
		<div class="input_box">
		<label>所属病院</label> <!-- 学生番号の入力欄のラベル -->
		<input type="text" name="dc_belong"
			placeholder="所属病院を入力してください" maxlength="15" value="${dc_belong}" required />
		<div>${errors.get("dc_belong")}</div> <!-- エラーメッセージ表示エリア：学生番号のエラー -->
		</div>

		<div class="input_box">
		<label>診療科</label> <!-- 氏名の入力欄のラベル -->
		<input type="text" name="dc_dept"
			placeholder="診療科を入力してください" maxlength="10" value="${dc_dept}" required />
		<div>${errors.get("dc_dept")}</div> <!-- エラーメッセージ表示エリア：氏名のエラー -->
		</div>

		<div class="input_box">
		<label>パスワード</label> <!-- 氏名の入力欄のラベル -->
		<input type="text" name="dc_pw"
			placeholder="パスワードを入力してください" maxlength="20" value="${dc_pw}" required />
		<div>${errors.get("dc_pw")}</div> <!-- エラーメッセージ表示エリア：氏名のエラー -->
		</div>

		<div class="button">
		<a href="DoctorCreateExecute.action">戻る</a>
		<input type="submit" value="登録"> <!-- 登録ボタン -->
		</div>

	</form>

	</c:param>

</c:import>
