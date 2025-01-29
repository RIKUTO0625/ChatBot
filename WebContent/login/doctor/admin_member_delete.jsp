<%-- 組織メンバー削除画面 jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="/common/doctor_base.jsp">
	<c:param name="title">
	組織メンバー削除
	</c:param>

	<c:param name="scripts">
		<link href="../../common/css/login.css" rel="stylesheet">
	</c:param>

	<c:param name="content">
		<div>
			<div class="midasi">
				<h2>組織メンバー削除</h2>
			</div>
			<div class="midasi">
				<p>${staff_name}を削除しますか？</p>
			</div>

			<div class="button">
				<!-- 組織メンバー削除完了画面へ -->
				<form action="MemberDeleteExecute.action" method="post">
			        	<div class="haibutton">
							<input type="submit" value="はい">
						</div>
				</form>

				<!-- 組織メンバー一覧へ -->
				<form action="Member.action" method="get">
					<div class="iiebutton">
						<input type="submit" value="戻る">
					</div>
				</form>
			</div>
		</div>
	</c:param>
</c:import>
