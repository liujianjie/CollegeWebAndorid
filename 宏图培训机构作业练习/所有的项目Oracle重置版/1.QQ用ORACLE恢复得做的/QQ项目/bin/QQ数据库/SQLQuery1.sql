use QQ数据库;
create table QQ(
	id int primary key identity(1,1),--id
	qqnum varchar(50) not null,--qq号
	qqname varchar(50) not null,--昵称
	pwd varchar(50) not null,--密码
	face varchar(50) not null,--头像
	names varchar(10) null,--真实姓名
	age int null,--年龄
	sex varchar(10) not null,--性别
	Date varchar(10) not null,--农历日历
	years varchar(20) not null,--年份
	months varchar(10) not null,--月份
	days varchar(10) not null,--日份
	country varchar(20) not null,--国家
	province varchar(10) not null,--省份
	city varchar(10) not null,--城市
	mark varchar(100),--个性签名
	nation varchar(10) null,--名族
	levels int null,--等级
	star varchar(20) null,--星座
	status int not null--在线状态 0 离线，1 在线，2 隐身，3 忙碌
)