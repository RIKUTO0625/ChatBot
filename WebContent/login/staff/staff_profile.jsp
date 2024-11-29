<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>プロフィール</title>
<link href="../../common/css/profile.css" rel="stylesheet">
</head>
<body>
	<form action="staff_profile_update.jsp" method="post">
		<div class="profile">
			<div class="pf-table">
				<h1 class="midashi">プロフィール</h1>
				<div class="pf-field">
					<div class="pf-field2">
						<!-- 名前 -->
						<div class="pflist">
							<div class="koumoku"><p>名前</p></div>
							<div class="naiyou">
								<c:choose>
									<c:when test="${empty staff_name}">
										<p>「名前」を入力してください</p>
									</c:when>
									<c:otherwise>
										<p>${staff_name}</p>
									</c:otherwise>
								</c:choose>
							</div>
						</div>

						<!-- 年齢 -->
						<div class="pflist">
							<div class="koumoku"><p>年齢</p></div>
							<div class="naiyou">
								<c:choose>
									<c:when test="${empty staff_age}">
										<p>「年齢」を入力してください</p>
									</c:when>
									<c:otherwise>
										<p>${staff_age}</p>
									</c:otherwise>
								</c:choose>
							</div>
						</div>

						<!-- 所属 -->
						<div class="pflist">
							<div class="koumoku"><p>所属</p></div>
							<div class="naiyou">
								<c:choose>
									<c:when test="${empty staff_belong}">
										<p>「所属」を入力してください</p>
									</c:when>
									<c:otherwise>
										<p>${staff_belong}</p>
									</c:otherwise>
								</c:choose>
							</div>
						</div>

						<!-- 連絡先 -->
						<div class="pflist">
							<div class="koumoku"><p>連絡先</p></div>
							<div class="naiyou">
								<c:choose>
									<c:when test="${empty staff_mail}">
										<p>「連絡先」を入力してください</p>
									</c:when>
									<c:otherwise>
										<p>${staff_mail}</p>
									</c:otherwise>
								</c:choose>
							</div>
						</div>

						<!-- 性別 -->
						<div class="pflist">
							<div class="koumoku"><p>性別</p></div>
							<div class="naiyou">
								<c:choose>
									<c:when test="${empty gender_cd}">
										<p>「性別」を入力してください</p>
									</c:when>
									<c:otherwise>
										<p>${gender_cd}</p>
									</c:otherwise>
								</c:choose>
							</div>
						</div>

						<!-- 趣味 -->
						<div class="pflist">
							<div class="koumoku"><p>趣味</p></div>
							<div class="naiyou">
								<c:choose>
									<c:when test="${empty favorite}">
										<p>「趣味」を入力してください</p>
									</c:when>
									<c:otherwise>
										<p>${favorite}</p>
									</c:otherwise>
								</c:choose>
							</div>
						</div>

						<!-- 備考 -->
						<div class="pflist">
							<div class="koumoku"><p>備考</p></div>
						</div>
					</div>

					<!-- 画像 -->
					<div class="pf-graff">
						<img src="../../image/garff.png" alt="Gear Icon">
					</div>
				</div>

				<!-- 備考詳細 -->
				<div class="pf-bikou">
					<c:choose>
						<c:when test="${empty detail}">
							<p>「備考」を入力してください</p>
						</c:when>
						<c:otherwise>
							<p>${detail}</p>
						</c:otherwise>
					</c:choose>
				</div>
			</div>

			<!-- 編集ボタン -->
			<div class="button">
				<a href="staff_profile_update.jsp" class="up-button">編集</a>
			</div>
		</div>
	</form>
</body>
</html>
