<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="css/style.css" rel="stylesheet">
<div style="display: flex; align-items: center;">
    <img src="https://github.com/RIKUTO0625/ChatBot/blob/master/WebContent/image/chatbotheader.png?raw=true"
    alt="chatbot" width=262.5 height=54  style="margin-right: 10px;">
    <div style="display: flex; align-items: center;">
        <a href="#" class=image><img class=image
        src="https://github.com/RIKUTO0625/ChatBot/blob/master/WebContent/image/HOME.drawio.png?raw=true"
        alt="HOME" width=150 height=30></a>
		<header>
		  <nav class="nav">
		    <ul>
		      <li><a href="#">職員ログイン</a></li>
		      <li><a href="#">医者ログイン</a></li>
		      <li><a href="#">組織ログイン</a></li>

		    </ul>
		  </nav>
		  <button type="button" id="navbtn"></button>
		</header>
    </div>
</div>

<!-- Separator -->
<hr color="black">

<!-- JavaScript -->
<script>
document.getElementById("navbtn").onclick = function(){
	  document.querySelector('html').classList.toggle('open');
	}
</script>
