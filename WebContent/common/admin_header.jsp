<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link href="css/style.css" rel="stylesheet">
<div style="display: flex; align-items: center;">
    <img src="https://github.com/RIKUTO0625/ChatBot/blob/master/WebContent/image/chatbotheader.png?raw=true"
    alt="chatbot" width=262.5 height=54  style="margin-right: 10px;">
    <div style="display: flex; align-items: center;">
        <h2><span>user:${admin_name}</span></h2>
        <a href="#" class=image><img class=image
        src="https://github.com/RIKUTO0625/ChatBot/blob/master/WebContent/image/HOME.drawio.png?raw=true"
        alt="HOME" width=150 height=30></a>
        <a href="#"><img class=image
        src="https://github.com/RIKUTO0625/ChatBot/blob/master/WebContent/image/logout.png?raw=true"
        alt="ログアウト" width=150 height=30></a>
		<header>
		  <nav class="nav">
		    <ul>
		      <li><a href="admin/Member.action">職員アカウント管理</a></li>
		      <li><a href="doctor/ViewDoctor.action">医者アカウント管理</a></li>
		      <li><a href="admin/ViewSendMail.action">通知用メールアドレス管理</a></li>
		      <li class=footer-menu>
		      <a href="#">HOME</a>
		      <a href="admin/AdminLogout.action">Logout</a>
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