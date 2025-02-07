<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../../common/staff_base.jsp">
<c:param name="title">
プロフィール
</c:param>
<c:param name="scripts"><link href="../../common/css/profile.css" rel="stylesheet"></c:param>
<c:param name="content">
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
										<p style="color: #ccc;">「名前」を入力してください</p>
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
										<p style="color: #ccc;">「年齢」を入力してください</p>
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
										<p style="color: #ccc;">「所属」を入力してください</p>
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
										<p style="color: #ccc;">「連絡先」を入力してください</p> <!-- 色変更 -->
									</c:when>
									<c:otherwise>
										<p style="color: black;">${staff_mail}</p> <!-- 黒色 -->
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
										<p style="color: #ccc;">「性別」を入力してください</p>
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
										<p style="color: #ccc;">「趣味」を入力してください</p>
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
					<div class="kibun">
					<p>今日の気分</p>
					</div>
					    <c:choose>
						    <c:when test="${not empty selectedAnswers && selectedAnswers[0] == 0}">
						        <img src="../../image/garff_0.png" alt="Answer 0" style="width: 300px; height: 300px;">
						    	<p id="kibun0">今日はまだメンタルチェックを行っていません</p>
						    </c:when>
						    <c:when test="${not empty selectedAnswers && selectedAnswers[0] == 1}">
							    <img src="../../image/garff_1.png" alt="Answer 1" style="width: 300px; height: 300px;">
							    <p id="kibun1">最高!!</p>
							</c:when>
						    <c:when test="${not empty selectedAnswers && selectedAnswers[0] == 2}">
						        <img src="../../image/garff_2.png" alt="Answer 2" style="width: 300px; height: 300px;">
						        <p id="kibun2">良好</p>
						    </c:when>
						    <c:when test="${not empty selectedAnswers && selectedAnswers[0] == 3}">
						        <img src="../../image/garff_3.png" alt="Answer 3" style="width: 300px; height: 300px;">
						        <p id="kibun3">ふつう</p>
						    </c:when>
						    <c:when test="${not empty selectedAnswers && selectedAnswers[0] == 4}">
						        <img src="../../image/garff_4.png" alt="Answer 4" style="width: 300px; height: 300px;">
						        <p id="kibun4">ダメかも</p>
						    </c:when>
						    <c:when test="${not empty selectedAnswers && selectedAnswers[0] == 5}">
						        <img src="../../image/garff_5.png" alt="Answer 5" style="width: 300px; height: 300px;">
						        <p id="kibun5">危険!!</p>
						    </c:when>
						    <c:otherwise>
						        <img src="../../image/garff_default.png" alt="Default Answer">
						    </c:otherwise>
						</c:choose>

					</div>


				</div>

				<!-- 備考詳細 -->
				<div class="pf-bikou">
					<c:choose>
						<c:when test="${empty detail}">
							<p style="color: #ccc;">「備考」を入力してください</p> <!-- 色変更 -->
						</c:when>
						<c:otherwise>
							<p style="color: black;">${detail}</p>
						</c:otherwise>
					</c:choose>
				</div>
			</div>

			<!-- 編集ボタン -->
			<div class="button">
			    <form action="staff_profile_update.jsp" method="post">
			        <input type="hidden" name="staff_name" value="${staff_name}">
			        <input type="hidden" name="staff_age" value="${staff_age}">
			        <input type="hidden" name="staff_belong" value="${staff_belong}">
			        <input type="hidden" name="staff_mail" value="${staff_mail}">
			        <input type="hidden" name="gender_cd" value="${gender_cd}">
			        <input type="hidden" name="favorite" value="${favorite}">
			        <input type="hidden" name="detail" value="${detail}">
			        <button type="submit" class="up-button">編集</button>
			    </form>
			</div>
		</div>
	</form>
</c:param>
</c:import>

