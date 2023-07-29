select top 2 * from goods where g_id not in (select top 0  g_id from goods) order by g_sale desc
select top 2 * from goods g where g_id not in order by g_sale desc
select count(*) from goods
select top 2 * from goods g left join bottom b on b.bottom_id=g.bottom_id where g_id not in (select top 0 g_id from goods) order by g_sale desc
create table comment(
	c_id int  identity(1,1) primary key not null,
	jruser_id int references jruser(jruser_id) not null,
	g_id int references goods(g_id) not null,
	c_comment varchar(1000),
	c_time datetime 
)
select top 1 * from comment c left join jruser j on c.jruser_id=j.jruser_id where c_id not in (select top 0 c_id from comment)