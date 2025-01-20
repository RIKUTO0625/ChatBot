<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>チャットボットテスト</title>
    <link href="../../common/css/chatbot.css" rel="stylesheet">
</head>
<body>
	<!-- ★★★チャット想定★★★ -->
    <div class="contents">
    <!-- チャットメッセージ表示エリア -->
    <div class="chat-message received">
        <span class="message-text">こんにちは！何かお手伝いできますか？</span>
    </div>
    <div class="chat-message sent">
        <span class="message-text">はい、次の予定を確認したいです。</span>
    </div>
    <div class="chat-message received">
        <span class="message-text">少々お待ちください。</span>
    </div>
    <div class="chat-message sent">
        <span class="message-text">ありがとうございます！</span>
    </div>
    <!-- 以下テスト用のやり取り -->
    <div class="chat-message received">
        <span class="message-text">お住まいの地域を教えていただけますか？</span>
    </div>
    <div class="chat-message sent">
        <span class="message-text">東京です。</span>
    </div>
    <div class="chat-message received">
        <span class="message-text">わかりました。次の予定は明日の10時です。</span>
    </div>
    <div class="chat-message sent">
        <span class="message-text">ありがとうございます！</span>
    </div>
    <div class="chat-message received">
        <span class="message-text">他に何かお手伝いできることはありますか？</span>
    </div>
    <div class="chat-message sent">
        <span class="message-text">今週末の予定も教えてください。</span>
    </div>
    <div class="chat-message received">
        <span class="message-text">はい、今週末の予定を確認しますね。</span>
    </div>
    <div class="chat-message sent">
        <span class="message-text">よろしくお願いします。</span>
    </div>
    <div class="chat-message received">
        <span class="message-text">今週末は土曜日の14時に会議があります。</span>
    </div>
    <div class="chat-message sent">
        <span class="message-text">了解しました。</span>
    </div>
    <div class="chat-message received">
        <span class="message-text">他に確認したい予定はありますか？</span>
    </div>
    <div class="chat-message sent">
        <span class="message-text">特にないです。ありがとう！</span>
    </div>
    <div class="chat-message received">
        <span class="message-text">こちらこそありがとうございます！</span>
    </div>
    <div class="chat-message sent">
        <span class="message-text">またお願いするかもしれません。</span>
    </div>
    <div class="chat-message received">
        <span class="message-text">いつでもどうぞ！</span>
    </div>
    <div class="chat-message sent">
        <span class="message-text">お疲れ様です。</span>
    </div>

</div>
    <div class="chat-input-area">
        <input type="text" class="chat-input" placeholder="メッセージを入力">
           <button class="send-button">
	    	<img src="../../image/sousin.png" alt="Gear Icon" class="button-icon">
		</button>
    </div>
</body>
</html>
