<%-- 組織メンバー削除画面 jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/common/staff_base.jsp">
	<c:param name="title">
		面談の希望の申請
	</c:param>

	<c:param name="scripts">
		<link href="../../common/css/login.css" rel="stylesheet">
	</c:param>

	<c:param name="content">


		<div>
			<div class="midasi">
				<h2>面談を希望しますか？</h2>
			</div>
			<div class="button">
	        	<div class="haibutton">
					<a href="CreateAdmin.action">はい</a>
				</div>


				<div class="iiebutton">
					<form action="Request.action" method="get">
						<input type="submit" value="戻る">
					</form>
				</div>
			</div>
		</div>
	</c:param>
</c:import>