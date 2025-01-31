<%-- 医者アカウント削除完了画面 jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="/common/admin_base.jsp">
	<c:param name="title">
	医者アカウント削除完了
	</c:param>

	<c:param name="scripts">
		<link href="../../common/css/login.css" rel="stylesheet">
	</c:param>

	<c:param name="content">
		<div class="midasi">
			<h2>医者アカウント削除完了</h2>
			<p>${dc_name}を削除しました</p>
		</div>
		<div class="button">
			<font size="10">
				<a href="ViewDoctor.action">HOME</a>
			</font>
		</div>
	</c:param>
</c:import>