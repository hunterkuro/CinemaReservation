<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel = "stylesheet" type="text/css" href="./css/import.css">
<title>映画の情報・予約サイト</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class ="wrapper">
		<div class="details-contents">
		<h1>マイページ画面</h1>
		<table>
			<tr>
				<th scope="row"><s:label value="ユーザー名"/></th>
				<td><s:property value="session.loginUserId"/></td>
			</tr>
			<tr>
				<th scope="col"><s:label value="予約日"/></th>
				<th scope="col"><s:label value="予約時間"/></th>
				<th scope="col"><s:label value="映画館名"/></th>
				<th scope="col"><s:label value="映画名"/></th>
				<th scope="col"><s:label value="座席番号"/></th>
				<th scope="col"><s:label value="更新日"/></th>
			</tr>
			<s:iterator value="resurvedDetailsList">
				<tr>
					<td><s:property value="date"/></td>
					<td><s:property value="time"/></td>
					<td><s:property value="theaterName"/></td>
					<td><s:property value="movieName"/></td>
					<td><s:property value="seatsNumber"/></td>
					<td><s:property value="insertDate"/></td>
				</tr>
			</s:iterator>
		</table>
			<div class="center_btn_box">
				<s:form action="PurchaseHistoryAction"><!-- 遷移先 -->
				<s:submit class="btn_blue" value="購入履歴"/>
				</s:form>
			</div>
			<div id="text-right">
				<p>前のページに戻るには
				<a href='<s:url action="GoHomeAction"/>'>こちら</a></p>
					<p>Home画面に戻る場合は
				<a href='<s:url action="HomeAction"/>'>こちら</a></p>
				</div>
			</div>
	</div>
	<footer>
		<div id="pr">
		</div>
	</footer>
</body>
</html>