<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="css/style.css" rel="stylesheet">
<div style="display: flex; align-items: center;">
    <img src="../image/chatbotheader.png" alt="chatbot" width=262.5 height=54  style="margin-right: 10px;">
    <div style="display: flex; align-items: center;">
        <a href="#" class=image><img class=image src="../image/HOME.drawio.png" alt="HOME" width=150 height=30></a>
        <nav id="nav">
            <ul>
                <li><h2><a href="#">職員ログイン</a></h2></li>
                <li><h2><a href="#">医者ログイン</a></h2></li>
                <li><h2><a href="#">組織ログイン</a></h2></li>
            </ul>
        </nav>
        <div id="hamburger">
            <span class="inner_line" id="line1"></span>
            <span class="inner_line" id="line2"></span>
            <span class="inner_line" id="line3"></span>
        </div>

        <script>
            function hamburger(){
                document.getElementById('line1').classList.toggle('line_1');
                document.getElementById('line2').classList.toggle('line_2');
                document.getElementById('line3').classList.toggle('line_3');
                document.getElementById('nav').classList.toggle('in');
            };
            document.getElementById('hamburger').addEventListener('click',function(){
                hamburger();
            });
        </script>

    </div>
</div>
<br>
<hr color=black>