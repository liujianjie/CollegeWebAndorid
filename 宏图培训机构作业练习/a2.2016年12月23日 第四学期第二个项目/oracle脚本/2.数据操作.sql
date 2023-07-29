--1.插入数据 commit;--提交 rollback;--回滚 
insert into student(pk_serial,sname,age,weight,sex,birthday,created_by,created_date,updated_by,updated_date)
             values('pk1','张三',18,65,'M',sysdate,'system',sysdate,'system',sysdate);
insert into student(pk_serial,sname,age,weight,sex,birthday,created_by,created_date,updated_by,updated_date)
             values('pk2','李四',18,65,'M',sysdate,'system',sysdate,'system',sysdate);
insert into student(pk_serial,sname,age,weight,sex,birthday,created_by,created_date,updated_by,updated_date)
             values('pk3','王五',18,65,'M',sysdate,'system',sysdate,'system',sysdate);
insert into student(pk_serial,sname,age,weight,sex,birthday,created_by,created_date,updated_by,updated_date)
             values('pk4','陆六',18,65,'M',sysdate,'system',sysdate,'system',sysdate);                                       
commit;--提交
--2.修改数据
update student set sex='F',updated_by='me',updated_date=sysdate where sex='M';
commit;
--3.删除数据
delete from student;--可恢复，会保留日志,属于DML
commit;
truncate table student;--截断表，会删除所有数据，清空所有日志，不可恢复，使表回归刚创建的状态
--4.拷贝表数据及结构       
create table student_bak as 
select * from student where 1<>1;

select a.*,rowid from student_bak a;
--5.批量拷贝数据
insert into student_bak(pk_serial,sname,age,weight,sex,birthday,created_by,created_date,updated_by,updated_date)  
select pk_serial,sname,age,weight,sex,birthday,created_by,created_date,updated_by,updated_date from student;
commit;
--6.ORACLE伪列
--rowid数据在表中的行地址
select a.*,rowid from student_bak a;
--rownum查询出来的数据所对应的行号
select a.*,rownum from student a where rownum<=3 order by a.pk_serial desc;  
--7.oracle分页语句
--每页2条，取第2页
select * from (select a.*, rownum rn from student a where rownum<5 ) b
where b.rn>2;          