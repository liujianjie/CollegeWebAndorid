create table jruser(
	jruser_id int identity(1,1) primary key,
	uname varchar(10) ,
	pwd varchar(20),
	jointime datetime,
	birthday datetime,
	moneys float
)

create table orders(
	orders_id int identity(10000,1) primary key,
	jruser_id int ,
	gtime datetime,
	statu int ,
	xfm varchar(50),
	g_id int ,
	gcount int ,
	gimg varchar(50),
	gname varchar(50),
	gprice float
)
select top 1 bottom_id from bottom where mold_id=1
truncate table orders