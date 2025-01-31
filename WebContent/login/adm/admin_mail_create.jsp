<%-- 通知用メールアドレス設定画面 jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/common/admin_base.jsp">
<c:param name="title">通知用メールアドレス設定</c:param>
<c:param name="scripts">
<link href="../../common/css/login.css" rel="stylesheet">
</c:param>
<c:param name="content">
	<div class="midasi"> <!-- 見出し -->
		<h2>通知用メールアドレス設定</h2>
	</div>
	<div> <!-- メインページ -->
		<form action="AddSendMailExecute.action" method="post">
		<div class="input_box">
			<label>メールアドレス</label>
			<input type="email" name="send_mail" placeholder="メールアドレスを入力してください"
				maxlength="30" value="${mail_id}" required />
			<div>${errors.get(mail_id)}</div>
		</div>
			<div class="button56">
			<div class="button_1">
				<a href="#" onclick="history.back(); return false;">戻る</a>
				</div>
				<div class="button_2">
				<input type="submit" value="新規登録">
				</div>
			</div>
		</form>
	</div>
</c:param>
</c:import>
