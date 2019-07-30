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
		<h1>映画詳細画面</h1>
				<h3>映画の情報は以下になります。</h3>
				<table>
					<tr>
						<th>映画名</th>
						<th>上映期間</th>
					</tr>

					<s:iterator value="session.movieDetailsList">
					<tr>
						<td><s:property value="movieName"/></td>
						<td><s:property value="period"/></td>
					</tr>
					</s:iterator>
				</table>

				<div class="text-center">
					<img src="./images/<s:property value="session.selectedMovieName"/>.jpg">
					<h3>この映画を上映している映画館は以下になります。</h3>
				</div>

				<table class="stable">
					<tr>
						<th>映画館名</th>
						<th>席数</th>
						<th>チケット価格(大人)</th>
						<th>チケット価格(子供)</th>
						<th>電話番号</th>
						<th>地域</th>
					</tr>

					<s:iterator value="session.screeningTheater">
						<tr>
							<td><s:property value="theaterName"/></td>
							<td><s:property value="seats"/>席</td>
							<td><s:property value="ticketPrice"/>円</td>
							<td><s:property value="ticketPrice"/>円</td>
							<td><s:property value="tell"/></td>
							<td><s:property value="region"/></td>
							<td>
							<a href="
								<s:url action="ResurveAction">
								<s:param name="theaterName" value = "theaterName" /></s:url>
								">
								<s:property value="session.selectedMovieName"/>の席の予約をする
							</a>
							</td>
						</tr>
					</s:iterator>
				</table>

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