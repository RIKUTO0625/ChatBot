<%-- 医者アカウント削除画面 jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>医者アカウント削除</title>
<link href="../../common/css/login.css" rel="stylesheet">
</head>
<body>
	<form action="DeleteDoctorExecute.action" method="post">

		<div class="midasi">
		<h2>医者アカウント削除</h2>
		</div>

		<div class="midasi">
		<p>${dc_name}を削除しますか？</p>
		</div>

		<div class="button">

		<div class="haibutton">
		<a href="ViewDoctor.action">戻る</a>
		</div>

		<div class="iiebutton">
		<a href="DeleteDoctorExecute.action">はい</a>
		</div>
		</div>



	<!-- 医者アカウント一覧へ -->

</body>
</html>