<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/common/admin_base.jsp">
<c:param name="title">アカウント新規作成（医師）</c:param>
<c:param name="scripts">
<link href="../../common/css/create.css" rel="stylesheet">
</c:param>
<c:param name="content">
<div class="midasi">
    <h2>アカウント新規作成（医師）</h2>
</div>

<%-- セッションに保存されたエラーメッセージを取得して表示 --%>
<c:if test="${not empty sessionScope.errorMessage}">
    <div class="error_message" style="color: red;">
        ${sessionScope.errorMessage}
    </div>
    <%-- 表示後にセッションから削除 --%>
    <%
        session.removeAttribute("errorMessage");
    %>
</c:if>

<form action="CreateDoctorExecute.action" method="post">

	 <div class="input_box">
        <label>組織コード</label>
        <input type="text" name="admin"
            placeholder="組織コードを入力してください" maxlength="6" value="${admin}" required />
        <div>${errors.get("admin")}</div>
    </div>

    <div class="input_box">
        <label>名前</label>
        <input type="text" name="dc_name"
            placeholder="名前を入力してください" maxlength="6" value="${dc_name}" required />
        <div>${errors.get("dc_name")}</div>
    </div>

    <div class="input_box">
        <label>所属病院</label>
        <input type="text" name="dc_belong"
            placeholder="所属病院を入力してください" maxlength="15" value="${dc_belong}" required />
        <div>${errors.get("dc_belong")}</div>
    </div>

    <div class="input_box">
        <label>診療科</label>
        <input type="text" name="dc_dept"
            placeholder="診療科を入力してください" maxlength="10" value="${dc_dept}" required />
        <div>${errors.get("dc_dept")}</div>
    </div>

    <div class="input_box">
        <label>パスワード</label>
        <input type="text" name="dc_pw"
            placeholder="パスワードを入力してください" maxlength="20" value="${dc_pw}" required />
        <div>${errors.get("dc_pw")}</div>
    </div>

    <div class="button">
        <a href="#" onclick="history.back(); return false;">戻る</a>
        <input type="submit" value="登録">
    </div>
</form>
</c:param>
</c:import>
