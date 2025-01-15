<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>利用者一覧</title>
    <link href="../../common/css/sendmail.css" rel="stylesheet">
</head>
<body>
    <div class="staff_list">
    <div class="midasi">
        <h2>利用者一覧</h2>
        </div>
	    <form method="get" action="User.action">
	    	<div class="searchForm">
	        	<input class="searchForm-input" type="text" name="name" placeholder="名前から検索" value="<c:out value='${param.name}' />">
	        	<button class="searchForm-submit" type="submit"></button>
	    	</div>
	    </form>
	<c:choose>
		<c:when test="${not empty staffs}">
			<table class="staff_table">
				<tr>
					<th>名前</th>
					<th>所属</th>
					<th></th>
				</tr>
				<c:forEach var="staff" items="${staffs}">
					<tr>
						<td>${staff.staff_name}</td>
						<td>${staff.staff_belong}</td>
						<td>
							<a href="User.action?no=${staff.staff_id}">詳細</a>
						</td>
					</tr>
				</c:forEach>

			</table>
		</c:when>
		<c:otherwise>
		<div class="midasi">
			<div>該当者なし</div>
		</div>
		</c:otherwise>
	</c:choose>
	</div>

</body>
</html>
