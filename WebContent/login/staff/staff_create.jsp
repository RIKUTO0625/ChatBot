<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 上記はJSPの基本設定です。ページの言語はJava、文字エンコーディングはUTF-8で設定し、
     JSTLのcoreライブラリ（cタグ）を使用できるようにしています -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>アカウント新規作成（職員）</title> <!-- ページのタイトルを「得点管理システム」としています -->
<link href="../../common/css/create.css" rel="stylesheet">
</head>
<body>
<div class="midasi">
<h2>アカウント新規作成（職員）</h2>
</div>
    <form action="CreateStaffExecute.action" method="post">
        <div class="input_box">
        <label>組織コード</label> <!-- 組織コード入力欄 -->
        <input type="text" name="admin"
            placeholder="組織コードを入力してください" maxlength="6" value="${admin}" required />
        <div>${errors.get("admin")}</div> <!-- エラーメッセージ表示エリア：組織コードのエラー -->
        </div>

        <div class="input_box">
        <label>職員ID</label> <!-- IDの入力欄 -->
        <input type="text" name="staff_id"
            placeholder="IDを入力してください" maxlength="8" value="${staff_id}" required />
        </div>

        <div class="input_box">
        <label>名前</label> <!-- 職員名の入力欄 -->
        <input type="text" name="staff_name"
            placeholder="名前を入力してください" maxlength="20" value="${staff_name}" required />
        <div>${errors.get("staff_name")}</div> <!-- エラーメッセージ表示エリア：職員名のエラー -->
        </div>

        <div class="input_box">
        <label>メールアドレス</label> <!-- メールアドレスの入力欄 -->
        <input type="text" name="staff_mail"
            placeholder="メールアドレスを入力してください" maxlength="30" value="${staff_mail}" required />
        <div>${errors.get("staff_mail")}</div> <!-- エラーメッセージ表示エリア：メールアドレスのエラー -->
        </div>

        <div class="input_box">
        <label>パスワード</label> <!-- パスワードの入力欄 -->
        <input type="text" name="staff_pw"
            placeholder="パスワードを入力してください" maxlength="20" value="${staff_pw}" required />
        <div>${errors.get("staff_pw")}</div> <!-- エラーメッセージ表示エリア：パスワードのエラー -->
        </div>

        <div class="input_box">
        <label>所属</label> <!-- 所属部署の入力欄 -->
        <input type="text" name="staff_belong"
            placeholder="所属部署を入力してください" maxlength="20" value="${staff_belong}" required />
        </div>

        <div>${errors.get("staff_belong")}</div> <!-- エラーメッセージ表示エリア：所属のエラー -->

    <div class="button">
    <a href="StaffCreateExecute.action">戻る</a>

    <input type="submit" value="登録"> <!-- 登録ボタン -->
    </div>
    </form>

</body>
</html>
