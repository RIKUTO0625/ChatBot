<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- ここで受け取った値を変数にセット -->
<c:set var="staff_name" value="${param.staff_name}" />
<c:set var="staff_age" value="${param.staff_age}" />
<c:set var="staff_belong" value="${param.staff_belong}" />
<c:set var="staff_mail" value="${param.staff_mail}" />
<c:set var="gender_cd" value="${param.gender_cd}" />
<c:set var="favorite" value="${param.favorite}" />
<c:set var="detail" value="${param.detail}" />

<c:import url="../../common/staff_base.jsp">
<c:param name="title">
プロフィール編集
</c:param>
<c:param name="scripts"><link href="../../common/css/profile.css" rel="stylesheet"></c:param>
<c:param name="content">
<div class="content2">
<h1 class="midashi">プロフィール編集</h1>
<form action="StaffProfileExecute.action" method="post">
    <div class="input_box">
        <div class="form-group">
            <!-- 名前 -->
            <label for="staff_name">名前</label>
            <input type="text" id="staff_name" name="staff_name" value="${staff_name}" required>
        </div>
        <div class="form-group">
            <!-- 年齢 -->
            <label for="staff_age">年齢</label>
            <input type="text" id="staff_age" name="staff_age" value="${staff_age}" required>
        </div>
        <div class="form-group">
            <!-- 所属 -->
            <label for="staff_belong">所属</label>
            <input type="text" id="staff_belong" name="staff_belong" value="${staff_belong}" required>
        </div>
        <div class="form-group">
            <!-- 連絡先 -->
            <label for="staff_mail">連絡先</label>
            <input type="text" id="staff_mail" name="staff_mail" value="${staff_mail}" required>
        </div>
        <div class="form-group">
            <!-- 性別 -->
            <label for="gender_cd">性別</label>
            <input type="text" id="gender_cd" name="gender_cd" value="${gender_cd}" required>
        </div>
        <div class="form-group">
            <!-- 趣味 -->
            <label for="favorite">趣味</label>
            <input type="text" id="favorite" name="favorite" value="${favorite}" required>
        </div>
        <div class="form-group">
            <!-- 備考 -->
            <label for="detail">備考</label>
            <div class="up_bikou">
                <input type="text" id="detail" name="detail" value="${detail}">
            </div>
        </div>

        <!-- 更新ボタン -->
        <div class="button-container">
            <button type="submit" class="left-button">更新</button>
                <a href="#" onclick="history.back(); return false;">戻る</a>
        </div>
    </div>
</form>
</div>
</c:param>
</c:import>
