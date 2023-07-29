--1
create trigger t_1
on reader
after insert
as
select * from reader

insert into reader values('2015216010','小小',1,null)

go
--2
create trigger t_2
on reader
after update
as
print '信息修改成功！'

update reader set rname='李瑛' where rname='张英'

go
--3
create trigger t_3
on readertype
after update
as
begin 
declare @new varchar(10),@old varchar(10)
set @new =(select typeid from inserted)
set @old =(select typeid from deleted)
update reader
set typeid=@new
where typeid=@old
end

update readertype set typeid='01' where typeid='1'


--4
create trigger ReaderTri
on reader
after insert
as
begin
declare @newtypeid varchar(11)
set @newtypeid = (select typeid from inserted)
insert into readertype values(@newtypeid,
	(select rname from inserted)+'的读者类别',3,30)
end
insert into reader values('2015216013','燕小七','5',null)

--5
alter trigger r_5
on borrow
after insert
as
begin 
	declare @nbid varchar(15),@nrid varchar(15),@ntypeid varchar(15)
	set @nbid = (select bid from inserted)
	set @nrid = (select rid from inserted)
	set @ntypeid = (select typeid from reader where rid = @nrid)
	if exists (select * from book where bid=@nbid and Lentout = 'false')
		begin
			print @nbid; 
			print @nrid;
			print @ntypeid;
			update borrow set returndate = 
			dateadd(dd,(select limitdays from readertype where typeid = @ntypeid),lenddate)
			where rid = @nrid and bid = @nrid and returndate is null;
			update reader set lendnum = lendnum+1 where rid = @nrid;
			update book set lentout = 'true' where bid = @nbid;
		end
	else
		begin 
			print '该书已被借出'
			rollback
		end
end

update borrow set returndate = 
			dateadd(dd,(select limitdays from readertype where typeid = '01'),'2017-11-30')
			where rid = '2000186010' and bid = 'tp312/429' and returndate is null;
			
insert into borrow(rid,lenddate,bid)
	values('2000186010','2017-11-30','tp312/429')

delete from borrow where rid = '2000186010' and bid = 'tp312/429' and returndate is null;
update book set lentout = 'false' where bid = 'tp312/429'; 

--6
create trigger r_6
on borrow
after update
as
begin
declare @days int,@dzbn char(10),@tsbn char(9),@hsrq date
set @dzbn = (select rid from inserted)
set @tsbn = (select rid from inserted)
set @hsrq = (select returndate from inserted)
select @days = datediff(day,sreturndate,returndate)
from borrow
where rid = @dzbn and bid = @tsbn and returndate = @hsrq
if @days <= 0
	print '没有过期'
else 
	print '过期'+convert(char(6),@days)+'天'
update reader set lendnum = lendnum-1 where rid = @dzbh
update book set lentout = 0 where bid = @tsbh

end 



	
end


select * from book
select * from borrow
select * from reader
select * from readertype