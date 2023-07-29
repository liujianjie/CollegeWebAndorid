select count(*) from goods where bottom_id=1
select top 5 * from goods g left join bottom b on b.bottom_id=g.bottom_id where g_id not in (select top 0 g_id from goods) and g.bottom_id=1
select * from goods g left join bottom b on b.bottom_id=g.bottom_id where g_name like '%вт%'
select top 1 * from goods g left join bottom b on b.bottom_id=g.bottom_id where b.bottom_id=1 order by g_sale desc
select top 5 * from orders where orders_id not in(select top 3 orders_id from orders) and jruser_id=1
select count(*) from orders where jruser_id=1