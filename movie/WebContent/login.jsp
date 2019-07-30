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
	<div class ="wrapper">
		<div class="container">
			<div class="left-contents">
				<h3>ユーザー登録済みの方はログインをお願いします。</h3>
				<div class="message"><s:property value="session.errMessage"/></div>
				<div class="login">
					<s:form action="LoginAction">
					<ul>
						<li><s:textfield name="loginUserId" placeholder="ユーザーID" onfocus="this.placeholder=''" onblur="this.placeholder='ユーザーID'"/></li>
						<li><s:password name="password" placeholder="パスワード" onfocus="this.placeholder=''" onblur="this.placeholder='パスワード'"/></li>
						<li><s:submit value="ログイン"/></li>
					</ul>
					</s:form>
				</div>

				<br/>
				<div class="text-link">
					<p>新規ユーザー登録は
					<a href='<s:url action="UserCreateAction"/>'>こちら</a></p>
					<p>Homeへ戻る場合は
					<a href='<s:url action="GoHomeAction"/>'>こちら</a></p>
				</div>
			</div>

			<div class="main-contents">
				<div class="movie-box">
				<img src="./images/シネマ新宿.jpg">
				<img src="./images/全国シネマズ東京店.jpg">
				<img src="./images/小岩映画館.jpg">
				</div>
			</div>

			<div class="right-contents">
				☆☆☆最新映画情報☆☆☆
				<br>
				<div class="theater-box">
				<img src="./images/アラジン.jpg">
				<img src="./images/ゴジラ.jpg">
				<img src="./images/きみと、波にのれたら.jpg">
				</div>
			</div>
		</div>
	</div>
</body>
</html>