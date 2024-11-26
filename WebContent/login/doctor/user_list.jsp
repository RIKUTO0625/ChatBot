<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>利用者一覧</title>
</head>
<body>
    <div class="staff_list">
        <h2>利用者一覧</h2>
	    <form method="get" action="User.action">
	        <label>氏名</label>
	        <input type="text" name="name" value="<c:out value='${param.name}' />">
	        <button><img src="../../image/serchi.png" width=10 height=10></button>
	    </form>
	<c:choose>
		<c:when "${not empty staffs}">
			<table class="staff_table">
				<tr>
					<th>名前</th>
					<th>所属</th>
					<th>状態</th>
					<th></th>
				</tr>
				<c:forEach var="staff" items="${staffs}">
					<tr>
						<td>${staff.name}</td>
						<td>${staff.belong}</td>
						<!-- <td>${staff.####}</td> 感情のデータ（AWS）	-->
						<td><a href="User.action?no=${staff.staff_id}">詳細</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<div>該当者なし</div>
		</c:otherwise>
	</c:choose>
	</div>

</body>
</html>

