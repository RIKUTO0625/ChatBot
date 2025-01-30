<%-- 医者アカウント管理画面 jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/common/admin_base.jsp">
<c:param name="title">
医者アカウント管理
</c:param>

	<c:param name="scripts">
		<link href="../../common/css/login.css" rel="stylesheet">
	</c:param>

	<c:param name="content">
		<div class="midasi">
			<h2>医者アカウント管理</h2>
		</div>
		<form action="CreateDoctor.action" method="post">
			<div class="button">
				<div class="right">
					<input type="submit" value="新規作成">
				</div>
			</div>
		</form>

		<c:choose>
			<%-- 誰も登録していない(0人) --%>

			<c:when test="${empty doctorList}">
			<div class="midasi">
				<p>誰も登録されていません！</p>
				</div>
			</c:when>

			<%-- 1人以上登録されている --%>

			<c:when test="${not empty doctorList}">
				<c:forEach var="doctor" items="${doctorList}">
					<form action="DeleteDoctor.action" method="post">
						<div class="admen3">
							<div class="inline-block2">
								<p>病院：${doctor.dc_belong}</p>
							</div>
							<div class="inline-block2">
								<p>診療科目:${doctor.dc_dept}</p>
							</div>
							<div class="inline-block2">
								<p>名前：${doctor.dc_name}</p>
							</div>
							<input type="hidden" name="password" value="${doctor.dc_pw}">

							<div class="button">
								<input type="submit" value="削除">
							</div>
						</div>
					</form>
				</c:forEach>
			</c:when>

		</c:choose>
	</c:param>
</c:import>