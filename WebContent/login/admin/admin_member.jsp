<%-- 組織メンバー一覧画面 jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>組織メンバー一覧</title>
<link href="../../common/css/login.css" rel="stylesheet">
</head>
<body>
	<div>

		<div class="sosikimei">
		<div>${ad_name}</div>
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
</body>
</html>
