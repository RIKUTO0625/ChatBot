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
	<div id="bar-graph" class="content2">
	    <h2 class="c-title">縦棒グラフ</h2>
	    <div class="bar-graph-wrap">
	        <!-- 各選択肢の高さをCSS変数で指定 -->
	        <div class="graph blue" style="--bar-height: ${list1[0]}%;">
	            <span class="number">${list1[0]}%</span>
	            <span class="name">1</span>
	        </div>
	        <div class="graph red" style="--bar-height: ${list1[1]}%;">
	            <span class="number">${list1[1]}%</span>
	            <span class="name">2</span>
	        </div>
	        <div class="graph green" style="--bar-height: ${list1[2]}%;">
	            <span class="number">${list1[2]}%</span>
	            <span class="name">3</span>
	        </div>
	        <div class="graph yellow" style="--bar-height: ${list1[3]}%;">
	            <span class="number">${list1[3]}%</span>
	            <span class="name">4</span>
	        </div>
	        <div class="graph purple" style="--bar-height: ${list1[4]}%;">
	            <span class="number">${list1[4]}%</span>
	            <span class="name">5</span>
	        </div>
	    </div>
	</div>
</div>


</body>
</html>
