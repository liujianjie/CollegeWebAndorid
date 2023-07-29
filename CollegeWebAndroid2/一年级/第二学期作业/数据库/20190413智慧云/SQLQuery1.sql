create table Books
(
	b_id int,
	b_name nvarchar(20),
	b_chubanshe nvarchar(50),
	b_price float
)
drop table Books
insert into Books values(2,'c#高级应用','圣通出版',23);
insert into Books values(2,'JSP开发应用','机械出版出版',45);
insert into Books values(3,'高等数学','济南出版出版',25);
insert into Books values(3,'疯狂英语','清华出版出版',32);

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