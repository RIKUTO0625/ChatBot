<%-- ヘッダー --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<img src="chatbotheader" width=100 height=100 alt="chatbot">
</div>
<c:if test="${user.isAuthenticated()}">
	<div>
		<span>${}様</span>
		<a href="Logout.action">ログアウト</a>
	</div>
</c:if>