<%-- 組織メンバー削除画面 jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/common/staff_base.jsp">
	<c:param name="title">
		面談の希望の申請完了
	</c:param>

	<c:param name="scripts">
		<link href="../../common/css/login.css" rel="stylesheet">
	</c:param>

	<c:param name="content">


		<div class=request_cp>
			<div>
				<div class="midasi">
					<h2>面談の申請を完了しました</h2>
				</div>
				<!-- 組織メンバー一覧へ -->
				<form action="Request.action" method="get">
					<div class="button">
						<input type="submit" value="戻る">
					</div>
				</form>
			</div>
		</div>
	</c:param>
</c:import>

</body>
</html>