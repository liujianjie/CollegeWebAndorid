create table mold(/*����*/
	mold_id int identity(1,1) primary key not null,
	mold varchar(20) not null
)
create table bottom( /*����*/
	bottom_id int identity(1,1) primary key not null,
	bottom varchar(20) not null,
	mold_id int references mold(mold_id)
)
create table goods(/*��Ʒ*/
	g_id int identity(1,1) primary key not null,
	bottom_id int references bottom(bottom_id) not null,
	g_name varchar(50),
	g_dress varchar(100),
	g_dec varchar(100),
	g_img varchar(50),
	g_price float,
	g_descrip float
)