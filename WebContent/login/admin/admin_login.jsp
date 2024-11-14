<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>組織ログイン</title>
</head>
<body>
    <div class="login-container">
        <h2>組織ログイン</h2>
        <form action="AdminLoginExecute.action" method="post">
            <input type="text" name="ad_cd" placeholder="組織コード" required><br>
            <input type="password" name="password" placeholder="パスワード" required><br>
            <input type="submit" value="ログイン">
        </form>
		<p>
		アカウントをお持ちでない方は
		<a href="CreateAdmin.action" class="button-link">こちら</a>
		</p>
        <hr>

        <a href="../staff/StaffLogin.action" class="button-link">職員ログイン画面</a>
        <a href="../doctor/DoctorLogin.action" class="button-link">医者ログイン画面</a>
    </div>
</body>
</html>
