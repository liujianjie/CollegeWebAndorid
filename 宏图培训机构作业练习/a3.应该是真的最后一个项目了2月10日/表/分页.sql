--ȡǰ10������
select * from(select * from notice n order by n_date desc)where rownum<=10 order by rownum 

--��ҳ
select * from(select row_number()over(order by n_date desc) r,s.* from notice s)where r <= (2*3) and r >= (3-1)*2
