use QQ���ݿ�

create table qqfrid(
	id int primary key identity(1,1),
	myqq varchar(20) not null,
	friqq varchar(20) not null,
	groupname varchar(20) not null

)
insert into qqfrid values('6208' ,'7068' ,'����')
insert into qqfrid values('6208' ,'2023' ,'����')
insert into qqfrid values('6208' ,'5654' ,'ͬѧ')
insert into qqfrid values('6208' ,'6570' ,'ͬѧ')
insert into qqfrid values('6208' ,'8644' ,'������')
insert into qqfrid values('6208' ,'10455' ,'������')

select * from QQ where qqnum in(select friqq from qqfrid where myqq='6208' and groupname='����')