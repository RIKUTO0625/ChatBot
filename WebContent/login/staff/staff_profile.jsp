<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>プロフィール</title>
</head>
<body>
<h2>アカウント新規作成（職員）</h2>
	<form action="StaffProfileExecute.action" method="post">
		<!-- 名前 -->
	    <label for="staff_name">名前</label>
	    <input type="text" id="staff_name" name="staff_name" value="${staff_name}">

	    <!-- 年齢 -->
	    <label for="staff_age">年齢</label>
	    <input type="text" id="staff_age" name="staff_age" value="${staff_age}">

	    <!-- 所属 -->
	    <label for="staff_belong">所属</label>
	    <input type="text" id="staff_belong" name="staff_belong" value="${staff_belong}">

	    <!-- 連絡先 -->
	    <label for="staff_mail">連絡先</label>
	    <input type="text" id="staff_mail" name="staff_mail" value="${staff_mail}">

	    <!-- 性別 -->
	    <label for="gender_cd">性別</label>
	    <input type="text" id="gender_cd" name="gender_cd" value="${gender_cd}">

	    <!-- 趣味 -->
	    <label for="favorite">趣味</label>
	    <input type="text" id="favorite" name="favorite" value="${favorite}">

	    <!-- 備考 -->
	    <label for="detail">備考</label>
	    <input type="text" id="detail" name="detail" value="${detail}">

	    <input type="submit" value="プロフィール変更">

	</form>
	<a href="＃＃＃.action">戻る</a>
</body>
</html>