use QQ数据库

create table qqfrid(
	id int primary key identity(1,1),
	myqq varchar(20) not null,
	friqq varchar(20) not null,
	groupname varchar(20) not null

)
insert into qqfrid values('6208' ,'7068' ,'家人')
insert into qqfrid values('6208' ,'2023' ,'家人')
insert into qqfrid values('6208' ,'5654' ,'同学')
insert into qqfrid values('6208' ,'6570' ,'同学')
insert into qqfrid values('6208' ,'8644' ,'黑名单')
insert into qqfrid values('6208' ,'10455' ,'黑名单')

select * from QQ where qqnum in(select friqq from qqfrid where myqq='6208' and groupname='好友')