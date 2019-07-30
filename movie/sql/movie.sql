set names utf8;
set foreign_key_checks = 0;
drop database if exists movie;

create database if not exists movie;
use movie;

drop table if exists login_user_transaction;

create table login_user_transaction(
id int not null primary key auto_increment,
login_id varchar(16) unique,
login_pass varchar(16),
user_name varchar(50),
insert_date datetime
);

drop table if exists theater_info_transaction;

create table theater_info_transaction(
id int not null primary key auto_increment,
theater_name varchar(32) unique,
Number_of_seats int,
ticket_price int,
region varchar(30),
tell varchar(13),
screening_movie_pattern char(1)/*movie_info_transactionのscreening_theater_patternに対応。(値がXの場合、screening_theater_patternにxが含まれていれば上映映画)*/
);

drop table if exists movie_info_transaction;

create table movie_info_transaction(
id int not null primary key auto_increment,
movie_name varchar(32) unique,
period varchar(32),
screening_theater_pattern char(10) /*theater_info_transactionのscreening_movie_patternに対応。(値がxの場合screening_movie_patternがXの映画館で上映。X,Y,Zなど複数の映画館で上映していればX,Y,Zと必ずカンマ区切りで登録)*/
);

drop table if exists reservation_status_transaction;

create table reservation_status_transaction(
id int not null primary key auto_increment,
theater_name varchar(32),
movie_name varchar(64),
reservation_date varchar(32),
reservation_time varchar(32),
seats_number int(3),
reservation_user_id varchar(32),
insert_date datetime
);

INSERT INTO theater_info_transaction
	VALUES(1,"全国シネマズ東京店",30,1500,"tokyo","03-1234-5678","A"),(2,"シネマ新宿",25,1500,"tokyo","03-5555-5678","B"),(3,"小岩映画館",15,1500,"tokyko","03-1234-9876","C"),
		  (4,"全国シネマズ千葉店",25,1500,"chiba","04-1234-5678","A"),(5,"シネマ船橋",20,1500,"chiba","03-1234-5678","B"),(6,"館山映画館",12,1500,"saitama","03-1234-5678","C"),
		  (7,"全国シネマズ埼玉店",20,1500,"saitama","05-1234-5678","A"),(8,"シネマ大宮",15,1500,"tokyo","03-1234-5678","B"),(9,"蕨映画館",5,1500,"tokyo","03-1234-5678","C");

INSERT INTO login_user_transaction(login_id,login_pass,user_name)
	VALUES("sato","keisuke","ksk"),("a","a","a");

INSERT INTO movie_info_transaction(movie_name,period,screening_theater_pattern)
	VALUES("アラジン","5/10~7/9","A"),("ゴジラ","6/10~8/9","A,B"),("X-MEN","5/20~7/19","A,B,C"),("きみと、波にのれたら","8/20~10/19","A,C");
