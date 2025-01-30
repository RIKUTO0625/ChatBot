<%-- 通知用メールアドレス削除画面 jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/common/admin_base.jsp">
	<c:param name="title">
	通知用メールアドレス削除
	</c:param>

	<c:param name="scripts">
		<link href="../../common/css/login.css" rel="stylesheet">
	</c:param>

	<c:param name="content">
		<div>
			<div class="midasi">
				<h2>通知用メールアドレス削除</h2>
			</div>
		</div>
		<div>
			<div class="midasi">
				<p>${param.mail_address}を削除しますか？</p>
			</div>
			<div>
				<div class="button">
					<!-- 通知用メールアドレス削除完了画面へ -->
					<form action="DeleteSendMailExecute.action" method="post">
						<div class="haibutton">
							<input type="submit" value="はい">
						</div>
					</form>

					<!-- 通知用メールアドレス一覧へ -->
					<form action="ViewSendMail.action" method="get">
						<div class="iiebutton">
							<input type="submit" value="戻る">
						</div>
					</form>
				</div> <!-- class button -->
			</div>
		</div>
	</c:param>
</c:import>