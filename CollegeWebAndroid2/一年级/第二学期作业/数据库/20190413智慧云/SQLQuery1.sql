create table Books
(
	b_id int,
	b_name nvarchar(20),
	b_chubanshe nvarchar(50),
	b_price float
)
drop table Books
insert into Books values(2,'c#�߼�Ӧ��','ʥͨ����',23);
insert into Books values(2,'JSP����Ӧ��','��е�������',45);
insert into Books values(3,'�ߵ���ѧ','���ϳ������',25);
insert into Books values(3,'���Ӣ��','�廪�������',32);

select
	*
from Books
where b_price > 
(select 
	AVG(b_price)
from Books) 

select
	top 1*
from books
group by b_id