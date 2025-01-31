<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>職員ログイン</title>
    <link href="../../common/css/login.css" rel="stylesheet">
</head>
<body>
<div class=container>
	<div class = "erorrcd">
		<c:if test="${errors.get('1') != null}">
			<p>${errors.get("1")}</p>
		</c:if>
	</div>
    <div class="login-container">
    	<div class="midasi">
        <h2>職員ログイン</h2>
        </div>
        <form action="StaffLoginExecute.action" method="post">


        	<div class="input_box">
        	<label>職員ID</label>
            <input type="text" name="staff_id" placeholder="職員IDを入力してください" required><br>
            </div>

            <div class="input_box">
            <label>パスコード</label>
            <input type="password" name="staff_pw" placeholder="パスワードを入力してください" required><br>
            </div>

			<div class="button">
            <input type="submit" value="ログイン">
            </div>

        </form>

		<div class="kotira">
		<p>
		アカウントをお持ちでない方は
		<a href="CreateStaff.action">こちら</a>
		</p>
		</div>
        <hr size="1" width="70%">
        <div class="button">
			<div class="hokalogin">
	        <a href="../adm/AdmLogin.action" class="button-link">組織ログインはこちら</a>
	        </div>

	        <div class="hokalogin2">
	        <a href="../doctor/DoctorLogin.action" class="button-link2">医者ログインはこちら</a>
	        </div>
    	</div>
    </div>
</div>
</body>
</html>
