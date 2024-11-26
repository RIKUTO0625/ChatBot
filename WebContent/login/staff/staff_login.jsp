<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>職員ログイン</title>
</head>
<body>
	<div class = "erorrcd">
		<c:if test="${errors.get('1') != null}">
			<p>${errors.get("1")}</p>
		</c:if>
	</div>
    <div class="login-container">
        <h2>職員ログイン</h2>
        <form action="StaffLoginExecute.action" method="post">
            <input type="text" name="staff_id" placeholder="職員コード" required><br>
            <input type="password" name="password" placeholder="パスワード" required><br>
            <input type="submit" value="ログイン">
        </form>
		<p>
		アカウントをお持ちでない方は
		<a href="CreateStaff.action" class="button-link">こちら</a>
		</p>
        <hr>

        <a href="../admin/AdminLogin.action" class="button-link">組織ログイン画面</a>
        <a href="../doctor/DoctorLogin.action" class="button-link">医者ログイン画面</a>
    </div>
</body>
</html>
