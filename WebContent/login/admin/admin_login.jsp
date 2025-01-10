<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>組織ログイン</title>
    <link href="../../common/css/login.css" rel="stylesheet">
</head>

<body>
<div class=container>
	<div class = "erorrcd">
		<c:if test="${errors.get('1') != null}">
			<p>${errors.get("1")}</p>
		</c:if>
		</div>
	</div>
    <div class="login-container">
    	<div class="midasi">
        <h2>組織ログイン</h2>
        </div>
        <form action="AdminLoginExecute.action" method="post">

        	<div class="input_box">
        	<label>組織コード</label>
            <input type="text" name="ad_cd" placeholder="組織コードを入力してください" required><br>
            </div>

            <div class="input_box">
            <label>パスワード</label>
            <input type="password" name="admin_pw" placeholder="パスワードを入力してください" required><br>
          	</div>

          	<div class="button">
            <input type="submit" value="ログイン">

            </div>
        </form>

        <div class="kotira">
		<p>
		アカウントをお持ちでない方は
		<a href="CreateAdmin.action">こちら</a>
		</p>
		</div>
        <hr size="1" width="70%">

		 <div class="button">
        <a href="../staff/StaffLogin.action" class="button-link">職員ログインはこちら</a>
        <a href="../doctor/DoctorLogin.action" class="button-link2">医者ログインはこちら</a>
        </div>
    </div>
</body>
</html>