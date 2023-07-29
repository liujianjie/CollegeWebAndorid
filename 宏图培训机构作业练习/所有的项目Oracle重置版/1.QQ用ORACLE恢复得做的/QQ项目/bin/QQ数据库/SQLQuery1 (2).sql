create table history(
	id int primary key identity(1,1),
	qqnum varchar(50) not null,
	qqpwd varchar(50) null,
	qqface varchar(50) not null
)