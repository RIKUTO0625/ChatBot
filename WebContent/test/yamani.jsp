<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<c:import url="/common/base.jsp">

	<c:param name="title">
	テスト
	</c:param>


	<c:param name="scripts"  src="https://sdk.amazonaws.com/js/aws-sdk-2.1234.0.min.js">


	</c:param>

	<c:param name="content">

	<% out.println("★★★★"); %>

	<h1>${staff.getStaff_id()}</h1>

	<table class="table table-hover">
		<tr>
			<th></th>
			<th>学生番号</th>
			<th>氏名</th>
			<th>クラス</th>
			<th class="text-center">在学中</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach var="staff" items="${staff_list}">
			<tr>
				<td>${staff.getStaff_id()}</td>
				<td>${staff.getStaff_name()}</td>
				<td>${staff.getStaff_mail()}</td>
				<td>${staff.getStaff_age()}</td>
				<td class="text-center">s
			</tr>
		</c:forEach>
	</table>

	<h1>${admin.getAd_cd()}</h1>
	<h1>${doctor.getIs_deleted()}</h1>


	</c:param>


</c:import>
