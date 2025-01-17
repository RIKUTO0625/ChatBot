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

<%-- セッションに保存されたエラーメッセージを取得して表示 --%>
<c:if test="${not empty sessionScope.errorMessage}">
    <div class="error_message" style="color: red;">
        ${sessionScope.errorMessage}
    </div>
    <%-- 表示後にセッションから削除 --%>
    <%
        session.removeAttribute("errorMessage");
    %>
</c:if>

<form action="CreateStaffExecute.action" method="post">
    <!-- 入力欄はそのまま -->
    <div class="input_box">
        <label>組織コード</label>
        <input type="text" name="admin"
            placeholder="組織コードを入力してください" maxlength="6" value="${admin}" required />
        <div>${errors.get("admin")}</div>
    </div>

    <div class="input_box">
        <label>職員ID</label>
        <input type="text" name="staff_id"
            placeholder="IDを入力してください" maxlength="8" value="${staff_id}" required />
    </div>

    <div class="input_box">
        <label>名前</label>
        <input type="text" name="staff_name"
            placeholder="名前を入力してください" maxlength="20" value="${staff_name}" required />
        <div>${errors.get("staff_name")}</div>
    </div>

    <div class="input_box">
        <label>メールアドレス</label>
        <input type="text" name="staff_mail"
            placeholder="メールアドレスを入力してください" maxlength="30" value="${staff_mail}" required />
        <div>${errors.get("staff_mail")}</div>
    </div>

    <div class="input_box">
        <label>パスワード</label>
        <input type="text" name="staff_pw"
            placeholder="パスワードを入力してください" maxlength="20" value="${staff_pw}" required />
        <div>${errors.get("staff_pw")}</div>
    </div>

    <div class="input_box">
        <label>所属</label>
        <input type="text" name="staff_belong"
            placeholder="所属部署を入力してください" maxlength="20" value="${staff_belong}" required />
    </div>

    <div>${errors.get("staff_belong")}</div>

    <div class="button">
        <a href="#" onclick="history.back(); return false;">戻る</a>
        <input type="submit" value="登録">
    </div>
</form>
</body>

</html>
