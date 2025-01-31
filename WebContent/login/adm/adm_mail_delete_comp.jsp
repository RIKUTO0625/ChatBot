<%-- 通知用メールアドレス削除完了画面 jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/common/admin_base.jsp">
	<c:param name="title">
	メールアドレス削除完了
	</c:param>

	<c:param name="scripts">
		<link href="../../common/css/login.css" rel="stylesheet">
	</c:param>

	<c:param name="content">
		<div>
			<!-- メールアドレス一覧へ -->
			<form action="./ViewSendMail.action" method="get">
				<div class="midasi">
					<h2>メールアドレス削除完了</h2>
				</div>

				<div class="button">
					<input type="submit" value="一覧へ戻る">
				</div>
			</form>
		</div>
	</c:param>
</c:import>
