<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:import url="../common/base.jsp">

	<c:param name="title">
	テスト
	</c:param>

	<c:param name="content">

		<% out.println("★★★★"); %>


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
		        <td>${staff.staff_belong}</td>
		    </tr>
		</c:forEach>
		</table>

		<table class="table table-hover">
			<tr>
				<th>検索職員ID</th>
				<th>検索職員名</th>
				<th>検索職員メール</th>
				<th>職員年齢</th>
			</tr>

		<c:forEach var="staff" items="${search_list}">
		    <tr>
		        <td>${staff.staff_id}</td>
		        <td>${staff.staff_name}</td>
		        <td>${staff.staff_mail}</td>
		        <td>${staff.staff_belong}</td>
		    </tr>
		</c:forEach>

		</table>


		<table class="table table-hover">
			<tr>
				<th>医者ID</th>
				<th>医者名</th>
				<th>医者所属</th>
				<th>診療科</th>
			</tr>

			<c:forEach var="dc" items="${dc_list}">
				<tr>
					<td>${dc.dc_pw}</td>
					<td>${dc.dc_name}</td>
					<td>${dc.dc_belong}</td>
					<td>${dc.dc_dept}</td>
				</tr>
			</c:forEach>
		</table>

		<table class="table table-hover">
			<tr>
				<th>メールID</th>
				<th>メールアドレス</th>
			</tr>
			<c:forEach var="mail" items="${mail_list}">
				<tr>
					<td>${mail.mail_id}</td>
					<td>${mail.send_mail}</td>
				</tr>
			</c:forEach>
		</table>



		<h1>${admin.getAd_cd()}</h1>
		<h1>${doctor.getIs_deleted()}</h1>


	</c:param>


</c:import>
