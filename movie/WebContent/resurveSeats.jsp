<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel = "stylesheet" type="text/css" href="./css/import.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="./script/resurveSeats.js"></script>
<title>映画の情報・予約サイト</title>
</head>
<body>
<jsp:include page="header.jsp" />
	<div class ="wrapper">
		<div class="resurve-contents">
			<h1>映画館選択画面</h1>
			映画館：<span id="theater"><s:property value="session.selectedTheaterName"/></span>
			映画　：<span id="movie"><s:property value="session.selectedMovieName"/></span>
			日付　：<span id="date"><s:property value="date"/></span>

	<%--座席表の表示タグ--%>
			<div class="center">
			<div id="seatsL1"></div>
			<div id="seatsL2"></div>
			<div id="seatsL3"></div>
			</div>
			【選択座席】
			<table class="center">
				<tr>
					<th>#</th><th>選択中①</th><th>選択中②</th><th>選択中③</th><th>選択中④</th>
				</tr>
				<tr>
					<th>席番号</th><td class="select" id="select0">未選択</td><td class="select" id="select1">未選択</td>
					<td class="select" id="select2">未選択</td><td class="select" id="select3">未選択</td>
				</tr>
			</table>
			<s:form name="completeSeats" action="ResurveConfirmAction">
			<input type="hidden" id="seatNumber0" name="seatNumber0" value="">
			<input type="hidden" id="seatNumber1" name="seatNumber1" value="">
			<input type="hidden" id="seatNumber2" name="seatNumber2" value="">
			<input type="hidden" id="seatNumber3" name="seatNumber3" value="">
			<input type="hidden" name="date" value='<s:property value="date"/>'>
			<input type="button" value="座席予約する" onClick="completeResurve()">
			</s:form>

			<div id="text-right">
				<p>予約のやり直しは
				<a href='<s:url action="GoHomeAction"/>'>こちら</a></p>
				<p>映画から選ぶ場合は
				<a href='<s:url action="GoHomeAction"/>'>こちら</a></p>
			</div>
		</div>
	</div>
	<footer>
		<div id="pr">
		</div>
	</footer>

<%--Actionクラスで定義された埋まっている座席番号を引数にScriptを呼び出し --%>
<script>
window.onload = displySeats('${seatsNumber}','${seats}','${date}');
</script>
</body>
</html>