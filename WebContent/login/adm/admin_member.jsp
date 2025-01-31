<%-- 組織メンバー一覧画面 jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/common/admin_base.jsp">
<c:param name="title">
組織メンバー一覧
</c:param>
<c:param name="scripts"><link href="../../common/css/login.css" rel="stylesheet"></c:param>
<c:param name="content">
<div class=content>
	<div class="sosikimei">
	</div>

	<div class="midasi">
	<h2>組織メンバーー覧</h2>
	</div>

	<!-- 組織メンバーが誰もいない(0人) -->
	<c:if test="${empty staffList}">
		<p>誰も登録されていません！</p>
	</c:if>

	<!-- 誰かしらの組織メンバーがいる(1人以上) -->
	<c:if test="${not empty staffList}">
		<c:forEach var="staff" items="${staffList}">
			<form action="MemberDelete.action" method="post">
				<div class="admen">
					<div class="inline-block">
						<p>氏名：${staff.staff_name}</p>
					</div>
					<div class="inline-block">
						<p>所属：${staff.staff_belong}</p>
					</div>
					<input type="hidden" name="staff_id" value="${staff.staff_id}"/>
					<input type="hidden" name="staff_pw" value="${staff.staff_pw}"/>

					<div class="button">
						<div class="ookisahaibutton">

							<input type="submit" value="削除">


						</div>
					</div>
				</div>
			</form>

		</c:forEach>
	</c:if>


</div>
</c:param>
</c:import>
