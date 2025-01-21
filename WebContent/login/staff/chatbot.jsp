<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html lang="ja">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>質問画面</title>
    <link href="../../common/css/chatbot.css" rel="stylesheet">
</head>
<body>
    <!-- ★★★選択肢付き質問★★★ -->
    <div class="contents">
        <!-- 「次の質問に答えてください」のメッセージ -->
        <div class="chat-message received">
            <span class="message-text question">次の質問に答えてください：</span>
        </div>
		<c:if test="${not empty question_list}">
		<c:forEach var="i" begin="0" end="${fn:length(question_list) - 1}">
			<!-- item1 と item2 を同時に処理 -->
			<c:set var="q" value="${question_list[i]}" />
			<c:set var="a" value="${answer_list[i]}" />
			<p>質問の値: ${q}, 解答の値: ${a}</p>
		</c:forEach>
		</c:if>

		<form action="UserChatBot.action" method="post">
		<!-- 質問の値を隠しフィールドとして送信 -->
    	<input type="hidden" name="qu_id" value="${qu_id}" />

        <!-- 質問と選択肢を同じ枠に -->
        <div class="chat-message received2">
            <span class="message-text">${question}</span>
            <div class="choices">
                <button class="choice-button" name="answer" value="1" type="submit">そう思う</button>
                <button class="choice-button" name="answer" value="2" type="submit">どちらかといえばそう思う</button>
                <button class="choice-button" name="answer" value="3" type="submit">わからない</button>
                <button class="choice-button" name="answer" value="4" type="submit">どちらかといえばそう思わない</button>
                <button class="choice-button" name="answer" value="5" type="submit">そう思わない</button>
            </div>
        </div>
        </form>

        <!-- ユーザーが「とてもそう思う」を選択した仮定 -->
        <div class="chat-message user">
            <span class="message-text">とてもそう思う</span>
        </div>
    </div>

</body>
</html>
