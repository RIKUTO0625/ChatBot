<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="css/style.css" rel="stylesheet">

<div style="display: flex; align-items: center;">
    <!-- ロゴ -->
    <img src="https://github.com/RIKUTO0625/ChatBot/blob/master/WebContent/image/chatbotheader.png?raw=true"
         alt="chatbot" width="262.5" height="54" style="margin-right: 10px;">

    <div style="display: flex; align-items: center;">
        <!-- ユーザー情報とリンク -->
        <h2><span>user: ${staff_name}</span></h2>
        <a href="#" class="image"><img class="image"
           src="https://github.com/RIKUTO0625/ChatBot/blob/master/WebContent/image/HOME.drawio.png?raw=true"
           alt="HOME" width="150" height="30"></a>
        <a href="#"><img class="image"
           src="https://github.com/RIKUTO0625/ChatBot/blob/master/WebContent/image/logout.png?raw=true"
           alt="ログアウト" width="150" height="30"></a>

		<header>
		  <nav class="nav">
		    <ul>
		      <li><a href="staff/StaffProfile.action">マイページ</a></li>
		      <li><a href="#">チャットボット</a></li>
		      <li><a href="#">履歴</a></li>

		      <li class=footer-menu>
		      <a href="#">HOME</a>
		      <a href="staff/StaffLogout.action">Logout</a>
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

