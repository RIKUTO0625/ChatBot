<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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

        <!-- 質問と選択肢を同じ枠に -->
        <div class="chat-message received2">
            <span class="message-text">このサービスを使ってみてどう思いましたか？</span>
            <div class="choices">
                <button class="choice-button">とてもそう思う</button>
                <button class="choice-button">そう思う</button>
                <button class="choice-button">どちらでもない</button>
                <button class="choice-button">そう思わない</button>
                <button class="choice-button">とてもそう思わない</button>
            </div>
        </div>

        <!-- ユーザーが「とてもそう思う」を選択した仮定 -->
        <div class="chat-message user">
            <span class="message-text">とてもそう思う</span>
        </div>
    </div>

</body>
</html>
