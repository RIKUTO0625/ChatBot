
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/common/doctor_base.jsp">
<c:param name="title">
利用者一覧
</c:param>
<c:param name="scripts"><link href="../../common/css/login.css" rel="stylesheet"></c:param>
<c:param name="content">
<div class="midasi">
<h1>利用者一覧</h1>
   <h2>User：${search_conditions}</h2>
</div>

</c:param>
</c:import>