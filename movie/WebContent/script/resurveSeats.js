
/**
 * 座席を表示する
 * @param seats
 * @param resurvedSeatsNumber
 * @returns
 */
function displySeats(seatsNumber,seats,date){

/*JSPからInteger型のList、seatsNumberが[11,12,13]のように送られるが、受け取り時[ "[", "1", "1", ",", "1", "2" ...]のようになってしまうので変換
 * JSON.parse()は text として与えられた JSON に相当する Object を返す。*/
seatsNumber = JSON.parse(seatsNumber);

alert(date+"の"+seatsNumber+"番席は予約済み。ここの座席数は"+seats+"予約済み座席数は"+seatsNumber.length);
  	var i = seats; // 引数のseatsString　
  	var setL1 =""; // 1列目に出力する文章
  	var setL2 =""; // 2列目に出力する文章
  	var setL3 =""; // 3列目に出力する文章
  	targetL1 = document.getElementById("seatsL1");
  	targetL2 = document.getElementById("seatsL2");
  	targetL3 = document.getElementById("seatsL3");

//.concatはsetに文字列を追加していくための関数
//現時点では座席表の表示は席までしか対応していない。30席以上にする場合改行パターンの見直しと、表示先クラスの自動生成が必要。
	if(seats<=10){ // 開始タグ。①10席以下②11〜20席以下③21席以上で最大３行の表示になるように設定
	  	setL1 = setL1.concat('<table id="seating-chart"><tr>');
	}else if(seats>10 && seats<=20){
	  	setL1 = setL1.concat('<table id="seating-chart"><tr>');
	  	setL2 = setL2.concat('<table id="seating-chart"><tr>');
	}else{
	  	setL1 = setL1.concat('<table id="seating-chart"><tr>');
	  	setL2 = setL2.concat('<table id="seating-chart"><tr>');
	  	setL3 = setL3.concat('<table id="seating-chart"><tr>');
	}

	for(a=1;a<=i;a++){
  		if(a<=10){
	  		setL1 = setL1.concat("<th>"+a+"番席</th>");
	  	}else if(a>10 && a<=20){
	  		setL2 = setL2.concat("<th>"+a+"番席</th>");
	  	}else{
	  		setL3 = setL3.concat("<th>"+a+"番席</th>");
	  	}
  	}

	if(seats<=10){
	  	setL1 = setL1.concat("</tr><tr>");
	}else if(seats>10 && seats<=20){
	  	setL1 = setL1.concat("</tr><tr>");
	  	setL2 = setL2.concat("</tr><tr>");
	}else{
	  	setL1 = setL1.concat("</tr><tr>");
	  	setL2 = setL2.concat("</tr><tr>");
	  	setL3 = setL3.concat("</tr><tr>");
	}

  	i = seats; // for文用変数リセット
  	for(a=1;a<=i;a++){
  		var emputyOrFull = "空";
  		var disabledFlg = "";
  		var found = false;
  		for(var b=0;b<seatsNumber.length;b++){ // 予約済みの座席番号が[2,5,14,22]のような形式でseatsNumberに入っている。
  			if( a == seatsNumber[b]){ // 配列内の数字とループ中の座席番号が一致していれば
  				found = true;
  			}
  		}
  		//var value =seatsNumber.indexOf(a); // 予約済みの席番号の配列seatsNumberに座席番号aが存在すれば空→満に変更
  		if (found){
  			emputyOrFull = "満";
  			disabledFlg = "disabled=disabled";
  		}

  		if(a<=10){
	  		setL1 = setL1.concat('<td><button type="button" class="resurveBtn" id="resurveBtn'); // 座席をボタン化
	  		setL1 = setL1.concat(a); //ボタンのそれぞれのidは resurveBtn + 座席番号
	  		setL1 = setL1.concat('" name="seatNumber" value="' ); // valueはシステム変更しているうちに使わなくなった。
	  		setL1 = setL1.concat(a);
	  		setL1 = setL1.concat('" ');
	  		setL1 = setL1.concat(disabledFlg); // 上のif文より、空満によってdisabledの値は変わる
	  		setL1 = setL1.concat('" onclick=toggleBtn('); // クリックで呼び出すスクリプトに席番号の引数を渡す。
	  		setL1 = setL1.concat(a);
	  		setL1 = setL1.concat(')>');
	  		setL1 = setL1.concat(emputyOrFull); // ボタンの値が空か満になる
	  		setL1 = setL1.concat('</button></form></td>');
  		}else if(a>10 && a<=20){ // 11〜20席の場合concatする変数のみ変える
  			setL2 = setL2.concat('<td><button type="button" class="resurveBtn" id="resurveBtn');
	  		setL2 = setL2.concat(a);
	  		setL2 = setL2.concat('" name="seatNumber" value="' );
	  		setL2 = setL2.concat(a);
	  		setL2 = setL2.concat('" ');
	  		setL2 = setL2.concat(disabledFlg);
	  		setL2 = setL2.concat('" onclick=toggleBtn(');
	  		setL2 = setL2.concat(a);
	  		setL2 = setL2.concat(')>');
	  		setL2 = setL2.concat(emputyOrFull);
	  		setL2 = setL2.concat('</button></form></td>');
  		}else{ // 21席〜の場合もconcatする変数のみ変える
  			setL3 = setL3.concat('<td><button type="button" class="resurveBtn" id="resurveBtn');
	  		setL3 = setL3.concat(a);
	  		setL3 = setL3.concat('" name="seatNumber" value="' );
	  		setL3 = setL3.concat(a);
	  		setL3 = setL3.concat('" ');
	  		setL3 = setL3.concat(disabledFlg);
	  		setL3 = setL3.concat('" onclick=toggleBtn(');
	  		setL3 = setL3.concat(a);
	  		setL3 = setL3.concat(')>');
	  		setL3 = setL3.concat(emputyOrFull);
	  		setL3 = setL3.concat('</button></form></td>');
	  	}
  	}

  	//閉じタグ
  	if(seats<=10){
	  	setL1 = setL1.concat("</tr></table>");
	}else if(seats>10 && seats<=20){
	  	setL1 = setL1.concat("</tr>");
	  	setL2 = setL2.concat("</tr></table>");
	}else{
	  	setL1 = setL1.concat("</tr>");
	  	setL2 = setL2.concat("</tr>");
	  	setL3 = setL3.concat("</tr></table>");
	}
  	//上でconcatした文字列をjspの対応クラスにに反映させる
  	targetL1.innerHTML = setL1;
  	targetL2.innerHTML = setL2;
  	targetL3.innerHTML = setL3;
}

/*座席のクリックでの 選択・非選択切り替え*/
function toggleBtn(a){
	var selectedSeats = document.getElementsByClassName("resurved"); // 選択されクラス名が変更されている要素の取得
	var selectedBox = document.getElementsByClassName("select"); // 選択中の座席を表示するテーブルの要素を取得
	//クリック時に未選択枠が１つでも残っている or 選択済みの座席をクリックしている時はtrue
	if(document.getElementsByClassName("resurved").length<4
			|| selectedBox[0].innerText.indexOf(a) !== -1
			|| selectedBox[1].innerText.indexOf(a) !== -1
			|| selectedBox[2].innerText.indexOf(a) !== -1
			|| selectedBox[3].innerText.indexOf(a) !== -1)
		{
	  document.getElementById("resurveBtn"+a).classList.toggle("resurved"); // 座席のボタンクリックでクラス名を書き換えCSSを切り替える
	  //alert("選択済み席"+selectedBox[0].innerText +selectedBox[1].innerText +selectedBox[2].innerText +selectedBox[3].innerText +"選択席"+ a);
	  for(var i=0; i<selectedBox.length; i++){ // 選択中の座席の解除を想定して選択中の座席を表示するテーブルの初期化
		  selectedBox[i].innerText = "未選択";
		  selectedBox[i].style.background = "#fff";
	  }
	  for( var i=0; i<selectedSeats.length; i++) { // 選択されている座席をテーブルに反映
		  document.getElementById("select"+i).innerText = selectedSeats[i].value;
		  document.getElementById("select"+i).style.background = "#ffea5e";
	  }
	}else{
		alert("一度に予約できる座席は４席までです"); // 選択解除ではない5席目以降のクリック時はアラート
	}
}
/**
 * 座席予約するボタン押下でテーブルに表示している選択済み座席情報をinput hiddenのvalueに反映させsubmit()する
 */
function completeResurve(){
	var selectedBox = document.getElementsByClassName("select");
	var check =0; // すべて未選択の場合をチェック
	for(var i=0;i<=3;i++){
		/* 送信時未選択となっている表示を""に変える */
		if(selectedBox[i].innerHTML == "未選択"){
			selectedBox[i].innerHTML = "";
			check += 1;
		}
	document.getElementById("seatNumber"+ i).value = selectedBox[i].innerHTML;//
	}
	if(check == 4){
		alert("予約する席が一つも選択されていません");
		/* ""にした表示を未選択に戻す */
		for(var i=0;i<=3;i++){
			selectedBox[i].innerHTML = "未選択";
		}
	}else{
	document.completeSeats.submit();
	}
}