<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>医者ログイン</title>
</head>
<body>
	<div class = "erorrcd">
		<c:if test="${errors.get('1') != null}">
			<p>${errors.get("1")}</p>
		</c:if>
	</div>
    <div class="login-container">
        <h2>医者ログイン</h2>
        <form action="DoctorLoginExecute.action" method="post">
            <input type="text" name="ad_cd" placeholder="組織コード" required><br>
            <input type="password" name="doctor_pw" placeholder="パスワード" required><br>
            <input type="submit" value="ログイン">
        </form>
		<p>
		アカウントをお持ちでない方は
		<a href="CreateDoctor.action" class="button-link">こちら</a>
		</p>
        <hr>

        <a href="../staff/StaffLogin.action" class="button-link">職員ログイン画面</a>
        <a href="../admin/AdminLogin.action" class="button-link">組織ログイン画面</a>
    </div>
</body>
</html>
