<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="../common/base.jsp">

	<c:param name="title">
	テスト
	</c:param>

	<c:param name="content">

		<% out.println("★★★★"); %>

		<h1>${staff.getStaff_id()}</h1>

		<table class="table table-hover">
			<tr>
				<th>職員ID</th>
				<th>職員名</th>
				<th>職員メール</th>
				<th>職員年齢</th>
			</tr>
			<c:forEach var="staff" items="${staff_list}">
				<tr>
					<td>${staff.staff_id}</td>
					<td>${staff.staff_name}</td>
					<td>${staff.staff_mail}</td>
					<td>${staff.staff_age}</td>
				</tr>
			</c:forEach>
		</table>

		<h1>${admin.getAd_cd()}</h1>
		<h1>${doctor.getIs_deleted()}</h1>


	</c:param>


</c:import>
