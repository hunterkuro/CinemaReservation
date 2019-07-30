/**
 * getElementByIdで座席数(seats)を読み取って、出力先タグ(seats)をinnerTextで書き換えてる
 * @param seats
 * @returns
 */
function onButtonClick(seats) { // 親関数
	target = document.getElementById("output"); // outputのテキスト(の場所)を読み取り 変数targetに入れ
	var today = new Date();
	var resurveDate = new Date(document.form1.textBox1.value);
		if(document.form1.textBox1.value != ""){
			if(resurveDate > today){
				target.innerText =" この日の上映開始時間は 12時〜 です。 "; // targetをtextBox1に入っている値(value)に書き換え
				date = document.form1.textBox1.value;
				$('#input_date').prop('disabled', false); //日付の入力不可解除
				$('#input_date').val(document.form1.textBox1.value); //日付をJSPのformのinputに入れる。
				$('#input_date').prop('disabled', true); //日付を再度入力不可
				$('#b_submit').prop('disabled', (document.form1.textBox1.value == ""));
			}else{
				alert('席の予約は明日以降の日付を選択してください。\n現在の時間は'+today.getFullYear() + "年" +  (today.getMonth() + 1) + "月"+ today.getDate()+"日"+ today.getHours()+'時です。\n選択された予約時間は'+ resurveDate.getFullYear() + "年" +  (resurveDate.getMonth() + 1) + "月"+ resurveDate.getDate()+'日12時です。');
			}
		}else{
			alert('ボタン左の枠から予約したい日付を選択してください。');
		}
	}

//最終form1のデータ送信時disabledをtrueにしないと送れない。
function disabledCancel(){
	$('input').prop('disabled', false);
}