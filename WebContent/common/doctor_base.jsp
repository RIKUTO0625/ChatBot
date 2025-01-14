<%-- 共通テンプレート --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../../common/css/style.css" rel="stylesheet">
<title>${param.title}</title>

${param.scripts}

</head>
<body>
	<div id="wrapper">
		<header class="css">
			<c:import url="../../common/doctor_header.jsp" />
		</header>

		${param.content}

		<footer class="css">
			<c:import url="../../common/footer.jsp" />
		</footer>

	</div>
</body>
</html>
