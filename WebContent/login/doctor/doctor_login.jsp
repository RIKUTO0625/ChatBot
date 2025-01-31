<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>医者ログイン</title>
    <link href="../../common/css/login.css" rel="stylesheet">
</head>
<body>
	<div class = "erorrcd">
		<c:if test="${errors.get('1') != null}">
			<p>${errors.get("1")}</p>
		</c:if>
	</div>
    <div class="login-container">
    	<div class="midasi">
        <h2>医者ログイン</h2>
        </div>
        <form action="DoctorLoginExecute.action" method="post">

        	<div class="input_box">
        	<label>組織コード</label>
            <input type="text" name="ad_cd" placeholder="組織コード" required><br>
            </div>

            <div class="input_box">
        	<label>パスワード</label>
            <input type="password" name="doctor_pw" placeholder="パスワード" required><br>
            </div>

            <div class="button">
            <input type="submit" value="ログイン">
            </div>
        </form>

         <div class="kotira">
		<p>
		アカウントをお持ちでない方は
		<a href="CreateDoctor.action">こちら</a>
		</p>
		</div>

        <hr size="1" width="70%">
		<div class="button">

        <a href="../staff/StaffLogin.action" class="button-link">職員ログイン画面</a>
        <a href="../adm/AdmLogin.action" class="button-link">組織ログイン画面</a>
        </div>
    </div>
</body>
</html>
