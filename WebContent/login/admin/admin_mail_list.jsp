<%-- 通知用メールアドレス一覧画面 jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/common/admin_base.jsp">
<c:param name="title">通知用メールアドレス一覧</c:param>
<c:param name="scripts">
<link href="../../common/css/login.css" rel="stylesheet">
</c:param>
<c:param name="content">
	<div>
		<div>${ad_name}</div>
		<div class="midasi">
		<h2>通知用メールアドレス一覧</h2>
		</div>

		<form action="AddSendMail.action" method="post">
			<div class="button">
			<div class="right">
			<input type="submit" value="新規作成">
			</div>
			</div>
		</form>

		<!-- 1通もない(0通) -->
		<c:if test="${empty mailList}">
			<p>誰も登録されていません！</p>
		</c:if>

		<!-- 登録されているメールアドレスがある -->
		<c:if test="${not empty mailList}">
			<c:forEach var="sendmail" items="${mailList}">
				<form action="DeleteSendMail.action" method="post">
				<input type="hidden" name="mail_id" value="${sendmail.mail_id}"/>
				<input type="hidden" name="mail_address" value="${sendmail.mail_address}"/>
				<input type="hidden" name="ad_cd" value="${sendmail.ad_cd}"/>
					<div class="admen2">
						<div class="inline-block">
							<p>${sendmail.mail_address}</p>
						</div>
							<div class="ookisahaibutton">
								<input type="submit"value="削除">
						</div>
					</div>
				</form>
				</c:forEach>
				</c:if>


	</div>
</c:param>
</c:import>