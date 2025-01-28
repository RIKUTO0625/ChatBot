<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link href="css/style.css" rel="stylesheet">
<div style="display: flex; align-items: center;">
    <img src="https://github.com/RIKUTO0625/ChatBot/blob/master/WebContent/image/chatbotheader.png?raw=true"
    alt="chatbot" width=240 height=90  style="margin-right: 10px;">
    <div style="display: flex; align-items: center;">
    	<h2><span>user:${dc_name}</span></h2>
    	<div class="images">

	        <a href="User.action"><img src="https://github.com/RIKUTO0625/ChatBot/blob/master/WebContent/image/HOME.drawio.png?raw=true"
	         alt="HOME" width=150 height=30></a>
	        <a href="DoctorLogout.action"><img src="https://github.com/RIKUTO0625/ChatBot/blob/master/WebContent/image/logout.png?raw=true"
	        alt="ログアウト" width=150 height=30></a>
        </div>
		<header>
		  <nav class="nav">
		    <ul>
		      <li><a href="User.action">職員検索</a></li>

		      <li class=footer-menu>
		      <a href="User.action">HOME</a>
		      <a href="DoctorLogout.action">Logout</a>
		      </li>
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
