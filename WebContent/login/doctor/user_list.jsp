<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../../common/doctor_base.jsp">
<c:param name="title">
利用者一覧
</c:param>
<c:param name="scripts"><link href="../../common/css/sendmail.css" rel="stylesheet"></c:param>
<c:param name="content">
<div class="content2">
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
		<
		</c:otherwise>
	</c:choose>
	</div>
</div>
</c:param>
</c:import>
