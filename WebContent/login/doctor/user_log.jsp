<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>回答結果の棒グラフ</title>
    <link href="../../common/css/user_log.css" rel="stylesheet">
</head>
<body>

<h1>質問の回答結果</h1>

<div class="content1">
    <h2 class="c-title">統計グラフ一覧</h2>
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
		    	<p class="graph-title">グラフタイトル</p> <!-- ここにグラフのタイトルを追加 -->
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
		    	<p class="graph-title">グラフタイトル</p> <!-- ここにグラフのタイトルを追加 -->
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
		    	<p class="graph-title">グラフタイトル</p> <!-- ここにグラフのタイトルを追加 -->
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
		    	<p class="graph-title">グラフタイトル</p> <!-- ここにグラフのタイトルを追加 -->
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
		    	<p class="graph-title">グラフタイトル</p> <!-- ここにグラフのタイトルを追加 -->
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
		    	<p class="graph-title">グラフタイトル</p> <!-- ここにグラフのタイトルを追加 -->
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
		    	<p class="graph-title">グラフタイトル</p> <!-- ここにグラフのタイトルを追加 -->
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
		    	<p class="graph-title">グラフタイトル</p> <!-- ここにグラフのタイトルを追加 -->
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
	</div>
</body>
</html>
