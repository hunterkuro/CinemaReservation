<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="./script/resurveSeats.js"></script>
<link rel = "stylesheet" type="text/css" href="./css/import.css">
<title>映画の情報・予約サイト</title>
</head>
<body>
<jsp:include page="header.jsp" />
<div class ="wrapper">
			<div id="logined-main-contents">
			<h1>確認画面</h1>
				予約する詳細は<br>
				 映画館:<s:property value="session.resurvedTheater"/><br>
				 予約日:<s:property value="session.resurvedDate"/><br>
				 席番号:
				 <s:iterator value="session.resurvedSeatNumber">
				 	<s:property/>番席
				 </s:iterator>
				 映画　:<s:property value="session.resurvedMovie"/><br>
				 <p>以上でよろしいですか？</p>

				<form action="ResurveDetailsAction">

				 	<input type="hidden" name="theaterName" value="${session.resurvedTheater}"/>
				 	<input type="hidden" name="date" value="${session.resurvedDate}"/>
				 	<%--<input type="hidden" name="seatsNumber" value="${session.resurvedSeatNumber}"/> --%>
				 	<input type="hidden" name="movieName" value="${session.resurvedMovie}"/>

					<input type="submit" value="上記の内容で確定する"/>
				</form>
				<div id="text-right">
					<p>予約のやり直しは
					<a href='<s:url action="GoHomeAction"/>'>TOPページに戻る</a></p>
					<p>日時、席の変更はこちら
					<a href='<s:url action="ResurveAction">
					<s:param name="theaterName" value="session.selected_theater_name"/>
					</s:url>'><s:property value="session.selected_theater_name"/>の予約へ戻る</a></p>
				</div>
			</div>
		</div>
	<footer>
		<div id="pr">
		</div>
	</footer>
</body>
</html>