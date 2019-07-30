<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script src="./script/header.js"></script>

<header>
	<s:form id="form" name="form">
	<ul>
		<li><span><s:property value="#session.loginUserId"/>さん、ようこそ！</span></li>
		<li><s:submit value="ログアウト" onclick="goLogoutAction();"/></li>
		<li><s:submit value="マイページ" onclick="goMyPageAction();"/></li>
	</ul>
	</s:form>
</header>