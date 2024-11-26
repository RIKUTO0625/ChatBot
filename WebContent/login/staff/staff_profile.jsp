<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>プロフィール</title>
<link href="../../common/css/profile.css" rel="stylesheet">
</head>
<body>
	<form action="StaffProfileExecute.action" method="post">
	<div class=profile>
		<div class=pf-table>
		<h1 class=midashi>プロフィール</h1>

			<div class=pflist >
		        <p>名前</p>
		        <p> "${staff_name}"</p>
		    </div>

		    <div class=pflist >
		        <p>年齢</p>
		        <p>"${staff_age}"</p>
		    </div>

			<div class=pflist >
		        <p>所属</p>
		        <p>"${staff_belong}"</p>
		    </div>

		    <div class=pflist >
		        <p>連絡先</p>
		        <p>"${staff_mail}"</p>
			</div>

			<div class=pflist >
		        <p>性別</p>
		        <p>"${gender_cd}"</p>
		    </div>

		    <div class=pflist >
		        <p>趣味</p>
		        <p>"${favorite}"</p>
		    </div>

		    <div class=pflist >
		        <p>備考</p>
		        <p>"${detail}"</p>
		    </div>
		</div>
		<div class=button>
		    <a href="StaffProfileExecute.action" class="up-button">編集</a>
	    </div>
</div>
	    	</form>
</body>
</html>