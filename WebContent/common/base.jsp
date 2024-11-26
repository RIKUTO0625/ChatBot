<%-- 共通テンプレート --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<title>${param.title}</title>

${param.scripts}
</head>
<body>
	<div id="wrapper" class="container">
		<header>
		<c:import url="/common/staff_header.jsp" />
		</header>


		<footer>
		<c:import url="/common/footer.jsp" />
		</footer>

	</div>
</body>
</html>
