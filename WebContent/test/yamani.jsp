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
	<h1>${admin.getAd_cd()}</h1>


	</c:param>


</c:import>
