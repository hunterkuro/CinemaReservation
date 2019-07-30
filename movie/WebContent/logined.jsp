<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%--<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript">
	function submitAction(url){
		$('form').attr('action',url);
		$('form').submit();
	}
</script>
 --%>
<link rel = "stylesheet" type="text/css" href="./css/import.css">

<title>映画の情報・予約サイト</title>
</head>
<body>
<jsp:include page="header.jsp" />
<div class ="wrapper">
	<div class ="container">
			<div class="logined-left-contents">
				<h1>予約する映画館を選ぶ</h1>
<%-- 映画館の情報theaterDetailsListを読み取って画像と店舗名を自動生成。リンク先にはparamでidを送る --%>
					<s:iterator value="session.theaterInfoList">
					<div class="list-box">
						<img src="./images/<s:property value="theaterName"/>.jpg">
						<div class="mask1"></div>
						<div class="mask2"></div>
						<div class="caption">
							<a href='<s:url action="TheaterDetailsAction">
							<s:param name="theaterName" value="theaterName"/>
							</s:url>'><s:property value="theaterName"/></a>
						</div>
					</div>
					</s:iterator>
			</div>

			<div class="logined-right-contents">
				<h1>見たい映画を選ぶ</h1>
<%-- 映画館の情報theaterDetailsListを読み取って画像と店舗名を自動生成。リンク先にはparamでidを送る --%>
				<s:iterator value="session.movieInfoList">
				<div class="list-box">
					<img src="./images/<s:property value="movieName"/>.jpg">
					<div class="mask1"></div>
					<div class="mask2"></div>
					<div class="caption">
						<a href='<s:url action="MovieDetailsAction">
						<s:param name="movieName" value="movieName"/>
						</s:url>'><s:property value="movieName"/></a>
					</div>
				</div>
				</s:iterator>
			</div>
		</div>
	</div>

	<footer>
		<div id="pr">
		</div>
	</footer>
</body>
</html>