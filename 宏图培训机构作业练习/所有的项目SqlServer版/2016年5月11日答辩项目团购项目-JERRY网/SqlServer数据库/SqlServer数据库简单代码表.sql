create table mold(/*类型*/
	mold_id int identity(1,1) primary key not null,
	mold varchar(20) not null
)
create table bottom( /*分类*/
	bottom_id int identity(1,1) primary key not null,
	bottom varchar(20) not null,
	mold_id int references mold(mold_id)
)
create table goods(/*物品*/
	g_id int identity(1,1) primary key not null,
	bottom_id int references bottom(bottom_id) not null,
	g_name varchar(50),
	g_dress varchar(100),
	g_dec varchar(100),
	g_img varchar(50),
	g_price float,
	g_descrip float
)
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

create table comment(
	c_id int  identity(1,1) primary key not null,
	jruser_id int references jruser(jruser_id) not null,
	g_id int references goods(g_id) not null,
	c_comment varchar(1000),
	c_time datetime 
)