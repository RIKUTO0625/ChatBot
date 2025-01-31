<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../../common/staff_base.jsp">
<c:param name="title">
回答統計
</c:param>
<c:param name="scripts"><link href="../../common/css/user_log.css" rel="stylesheet"></c:param>
<c:param name="content">

<div class="content1">
    <h2 class="c-title">統計グラフ一覧</h2>
    <c:if test="${not empty errorMessage}">
	    <div class="error-message">
	        <p>${errorMessage}<p>
	    </div>
	</c:if>


	<div class="search">
	    <form action="StaffLog.action" method="post">
		    <label for="yearSelect">年を選択してください:</label>
		    <select name="year" id="yearSelect">
		        <%
				    // 現在の年を取得して、選択肢を動的に生成する
				    java.util.Calendar calendar = java.util.Calendar.getInstance();
				    int currentYear = calendar.get(java.util.Calendar.YEAR);  // 現在の年を取得
				    for (int i = currentYear; i >= 2000; i--) { // 2000年から現在までを表示
				%>
				    <option value="<%= i %>"><%= i %></option>  <!-- 年を表示 -->
				<%
				    }
				%>
		    </select>

		    <label for="monthSelect">月を選択してください:</label>
	        <select name="month" id="monthSelect">
	            <option value="なし">なし</option>  <!-- なしの選択肢 -->
	            <%
	                // 1から12までの月を生成
	                for (int i = 1; i <= 12; i++) {
	            %>
	                <option value="<%= i %>"><%= i %>月</option> <!-- 月を表示 -->
	            <%
	                }
	            %>
	        </select>
		    <button type="submit" class="custom-button">検索</button>
		</form>
	</div>

	<c:if test="${empty errorMessage}">
   	    <div class="answer_box1">
        	<div class="answer_title" id="answer1">
		    <span class="name">そう思う</span>
			</div>
			<div class="answer_title" id="answer2">
			    <span class="name">どちらかといえばそう思う</span>
			</div>
			<div class="answer_title" id="answer3">
			    <span class="name">わからない</span>
			</div>
			<div class="answer_title" id="answer4">
			    <span class="name">どちらかといえばそう思わない</span>
			</div>
			<div class="answer_title" id="answer5">
			    <span class="name">そう思わない</span>
			</div>
        </div>
	    <!-- グラフ1段目 -->
    	<div class="content2">
	    <!-- グラフ1 -->
	    <div class="content3">
	    	<p class="graph-title">質問	今日の気分は良いと思いますか？</p> <!-- ここにグラフのタイトルを追加 -->
	        <div class="bar-graph-wrap">
	            <div class="graph blue" style="--bar-height: ${list1[0]}%;">
	            </div>
	            <div class="graph red" style="--bar-height: ${list1[1]}%;">
	            </div>
	            <div class="graph green" style="--bar-height: ${list1[2]}%;">
	            </div>
	            <div class="graph yellow" style="--bar-height: ${list1[3]}%;">
	            </div>
	            <div class="graph purple" style="--bar-height: ${list1[4]}%;">
	            </div>
	        </div>

	        <div class="answer_box2">
		        <span class="percentage">${list1[0]}%</span>
		        <span class="percentage">${list1[1]}%</span>
		        <span class="percentage">${list1[2]}%</span>
		        <span class="percentage">${list1[3]}%</span>
		        <span class="percentage">${list1[4]}%</span>
	        </div>
	    </div>

	    <!-- グラフ2 -->
	    <div class="content3">
	    	<p class="graph-title">質問 今日の睡眠は十分とれたと思いますか？</p> <!-- ここにグラフのタイトルを追加 -->
	        <div class="bar-graph-wrap">
	            <div class="graph blue" style="--bar-height: ${list2[0]}%;">
	            </div>
	            <div class="graph red" style="--bar-height: ${list2[1]}%;">
	            </div>
	            <div class="graph green" style="--bar-height: ${list2[2]}%;">
	            </div>
	            <div class="graph yellow" style="--bar-height: ${list2[3]}%;">
	            </div>
	            <div class="graph purple" style="--bar-height: ${list2[4]}%;">
	            </div>
	        </div>

	        <div class="answer_box2">
		        <span class="percentage">${list2[0]}%</span>
		        <span class="percentage">${list2[1]}%</span>
		        <span class="percentage">${list2[2]}%</span>
		        <span class="percentage">${list2[3]}%</span>
		        <span class="percentage">${list2[4]}%</span>
	        </div>
	    </div>

	    <!-- グラフ3 -->
	    <div class="content3">
	    	<p class="graph-title">質問 食欲はいつも通りと思いますか？</p> <!-- ここにグラフのタイトルを追加 -->
	        <div class="bar-graph-wrap">
	            <div class="graph blue" style="--bar-height: ${list3[0]}%;">
	            </div>
	            <div class="graph red" style="--bar-height: ${list3[1]}%;">
	            </div>
	            <div class="graph green" style="--bar-height: ${list3[2]}%;">
	            </div>
	            <div class="graph yellow" style="--bar-height: ${list3[3]}%;">
	            </div>
	            <div class="graph purple" style="--bar-height: ${list3[4]}%;">
	            </div>
	        </div>

	        <div class="answer_box2">
		        <span class="percentage">${list3[0]}%</span>
		        <span class="percentage">${list3[1]}%</span>
		        <span class="percentage">${list3[2]}%</span>
		        <span class="percentage">${list3[3]}%</span>
		        <span class="percentage">${list3[4]}%</span>
	        </div>
	    </div>
	</div>

	<!-- グラフ2段目 -->
	<div class="content2">
	    <!-- グラフ4 -->
	    <div class="content3">
	    	<p class="graph-title">質問 ネガティブな思考が多いと思いますか？</p> <!-- ここにグラフのタイトルを追加 -->
	        <div class="bar-graph-wrap">
	            <div class="graph blue" style="--bar-height: ${list4[0]}%;">
	            </div>
	            <div class="graph red" style="--bar-height: ${list4[1]}%;">
	            </div>
	            <div class="graph green" style="--bar-height: ${list4[2]}%;">
	            </div>
	            <div class="graph yellow" style="--bar-height: ${list4[3]}%;">
	            </div>
	            <div class="graph purple" style="--bar-height: ${list4[4]}%;">
	            </div>
	        </div>

	        <div class="answer_box2">
		        <span class="percentage">${list4[0]}%</span>
		        <span class="percentage">${list4[1]}%</span>
		        <span class="percentage">${list4[2]}%</span>
		        <span class="percentage">${list4[3]}%</span>
		        <span class="percentage">${list4[4]}%</span>
	        </div>
	    </div>

	    <!-- グラフ5 -->
	    <div class="content3">
	    	<p class="graph-title">質問 誰かとコミュニケーションをとれたと思いますか？</p> <!-- ここにグラフのタイトルを追加 -->
	        <div class="bar-graph-wrap">
	            <div class="graph blue" style="--bar-height: ${list5[0]}%;">
	            </div>
	            <div class="graph red" style="--bar-height: ${list5[1]}%;">
	            </div>
	            <div class="graph green" style="--bar-height: ${list5[2]}%;">
	            </div>
	            <div class="graph yellow" style="--bar-height: ${list5[3]}%;">
	            </div>
	            <div class="graph purple" style="--bar-height: ${list5[4]}%;">
	            </div>
	        </div>

	        <div class="answer_box2">
		        <span class="percentage">${list5[0]}%</span>
		        <span class="percentage">${list5[1]}%</span>
		        <span class="percentage">${list5[2]}%</span>
		        <span class="percentage">${list5[3]}%</span>
		        <span class="percentage">${list5[4]}%</span>
	        </div>
	    </div>

	    <!-- グラフ6 -->
	    <div class="content3">
	    	<p class="graph-title">質問 誰かに助けてもらいたいと思いましたか？</p> <!-- ここにグラフのタイトルを追加 -->
	        <div class="bar-graph-wrap">
	            <div class="graph blue" style="--bar-height: ${list6[0]}%;">
	            </div>
	            <div class="graph red" style="--bar-height: ${list6[1]}%;">
	            </div>
	            <div class="graph green" style="--bar-height: ${list6[2]}%;">
	            </div>
	            <div class="graph yellow" style="--bar-height: ${list6[3]}%;">
	            </div>
	            <div class="graph purple" style="--bar-height: ${list6[4]}%;">
	            </div>
	        </div>

	        <div class="answer_box2">
		        <span class="percentage">${list6[0]}%</span>
		        <span class="percentage">${list6[1]}%</span>
		        <span class="percentage">${list6[2]}%</span>
		        <span class="percentage">${list6[3]}%</span>
		        <span class="percentage">${list6[4]}%</span>
	        </div>
	    </div>
	</div>

	<!-- グラフ3段目 -->
	<div class="content2">
	    <!-- グラフ7 -->
	    <div class="content3">
	    	<p class="graph-title">質問 自分のペースで過ごせていますか？</p> <!-- ここにグラフのタイトルを追加 -->
	        <div class="bar-graph-wrap">
	            <div class="graph blue" style="--bar-height: ${list7[0]}%;">
	            </div>
	            <div class="graph red" style="--bar-height: ${list7[1]}%;">
	            </div>
	            <div class="graph green" style="--bar-height: ${list7[2]}%;">
	            </div>
	            <div class="graph yellow" style="--bar-height: ${list7[3]}%;">
	            </div>
	            <div class="graph purple" style="--bar-height: ${list7[4]}%;">
	            </div>
	        </div>

	        <div class="answer_box2">
		        <span class="percentage">${list7[0]}%</span>
		        <span class="percentage">${list7[1]}%</span>
		        <span class="percentage">${list7[2]}%</span>
		        <span class="percentage">${list7[3]}%</span>
		        <span class="percentage">${list7[4]}%</span>
	        </div>
	    </div>

	    <!-- グラフ8 -->
	    <div class="content3">
	    	<p class="graph-title">質問	解決が必要だと思うことがありましたか？</p> <!-- ここにグラフのタイトルを追加 -->
	        <div class="bar-graph-wrap">
	            <div class="graph blue" style="--bar-height: ${list8[0]}%;">
	            </div>
	            <div class="graph red" style="--bar-height: ${list8[1]}%;">
	            </div>
	            <div class="graph green" style="--bar-height: ${list8[2]}%;">
	            </div>
	            <div class="graph yellow" style="--bar-height: ${list8[3]}%;">
	            </div>
	            <div class="graph purple" style="--bar-height: ${list8[4]}%;">
	            </div>
	        </div>

	        <div class="answer_box2">
		        <span class="percentage">${list8[0]}%</span>
		        <span class="percentage">${list8[1]}%</span>
		        <span class="percentage">${list8[2]}%</span>
		        <span class="percentage">${list8[3]}%</span>
		        <span class="percentage">${list8[4]}%</span>
	        </div>
	    </div>

	    <!-- グラフ9 -->
	    <div class="content3">
	    	<p class="graph-title"></p> <!-- ここにグラフのタイトルを追加 -->
	        <div class="bar-graph-wrap2">
	        </div>
	    </div>
	    </div>
	    </c:if>
	</div>
</c:param>
</c:import>