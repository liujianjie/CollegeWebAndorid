create table game(
	ID int primary key identity(1,1),
	qqnum varchar(50) null,
	qqname varchar(50) null,
	vip varchar(10) null,
	shescore int null,
	shenode int default 2 null,
	txzgk int null
)
alter table game add constraint mr default '²»ÊÇ' for vip
alter table QQ drop column shescore