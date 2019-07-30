<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script> <%--disabled切り替え --%>
<script src="./script/cmanCalendar_v093.js"></script> <%-- カレンダー表示するためのjavascript (https://web-designer.cman.jp/javascript_ref/keyboard/calendar/)を使用 --%>
<script src="./script/theaterResurve.js"></script>
<link rel = "stylesheet" type="text/css" href="./css/import.css">

<title>映画の情報・予約サイト</title>
</head>
<body>
<jsp:include page="header.jsp" />
	<div class ="wrapper">
		<div class="resurve-contents">
			<h1>映画館選択画面</h1>
<%--javascript:void(0)を入れないとformによってactionクラスが更新されてしまいscript実行後にすぐに文字が消えてしまう --%>
			<form name="form1" action="javascript:void(0)" autocomplete="off">
<%--javascriptを使用したカレンダー表示 --%>
				<input id="textBox1" type="text" cmanCLDat="USE:ON" style="width:150px;" placeholder="予約カレンダーを開く">
				<s:iterator value="session.theaterDetailsList">
				<input type="submit" value="日付を確定する" onclick='onButtonClick(<s:property value="seats"/>)'>
				</s:iterator>
			</form>
			<form action="SeatsCheckAction">
			<ul class="selectedConfirm">
				<li>選択した映画館：<input type="text" name="theater" value="<s:property value="session.selectedTheaterName"/>" disabled ></li>
				<li>選択した映画　：<input type="text" name="movie" value="<s:property value="session.selectedMovieName"/>" disabled ></li>
				<li>選択した日付　：<input id="input_date" type="text" name="date" value="カレンダーより選択" onChange="check_field()" disabled></li>
				<li id="output">日付は上のカレンダーより選択し『日付を確定する』ボタンを押してください</li>
				<li><input id="b_submit" type="submit" value="座席を確認する" onclick='disabledCancel()' disabled></li>
			</ul>
			</form>

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
</body>
</html>