<%-- 医者アカウント削除画面 jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="/common/admin_base.jsp">
	<c:param name="title">
	医者アカウント削除
	</c:param>

	<c:param name="scripts">
		<link href="../../common/css/login.css" rel="stylesheet">
	</c:param>

	<c:param name="content">




		<div class="midasi">
			<h2>医者アカウント削除</h2>
		</div>

		<div class="midasi">
			<p>${doctor.dc_name}を削除しますか？</p>
		</div>

		<div class="button">
			<div class="haibutton">
				<a href="#" onclick="history.back(); return false;">戻る</a>
			</div>

			<div class="iiebutton">
				<a href="DeleteDoctorExecute.action">はい</a>
			</div>
		</div>
	</c:param>
</c:import>

