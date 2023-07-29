select * from msg
select * from emp
select * from course
select * from classes for update
select * from student where intenstatus=2
select * from student for update
select * from defenses for update
select * from projectf for update
truncate table projectf;
truncate table defenses

truncate table score;
select * from score
select * from sback for update

select count(*) from defenses
select d.*,p.*,s.intenname from defenses d inner join projectf p on p.pid=d.pid inner join student s on d.dmember=s.intenid where p.pclassid=48 and p.pname=766 order by did
select * from student where intenstatus=1 order by intenid
select * from sback for update
select * from summary for update
select * from says for update
select * from job for update
select * from leave for update
insert into student values(10001,'刘建杰','宏图软件','男',18,'打球,打豆豆','1998-12-10','刘瑞财','18160774016','13549283485','江西省兴国县龙口镇A5栋','能找到女朋友吗？','','student/10001-1b3d4a03b732f545',1,1,3,to_date('2015-8-24','yyyy-mm-dd'),'');

insert into student values(10002,'刘建杰2','宏图软件','女',18,'打球,打豆豆','1998-12-10','刘瑞财','18160774016','13549283485','江西省兴国县龙口镇A5栋','能找到女朋友吗？','','student/ljj.jpg',1,2,4,to_date('2015-8-24','yyyy-mm-dd'));

insert into student values(10003,'刘建杰3','宏图软件','男',18,'打球,打豆豆','1998-12-10','刘瑞财','18160774016','13549283485','江西省兴国县龙口镇A5栋','能找到女朋友吗？','','student/ljj.jpg',1,1,3,to_date('2015-8-24','yyyy-mm-dd'));

insert into student values(10004,'刘建杰4','宏图软件','男',18,'打球,打豆豆','1998-12-10','刘瑞财','18160774016','13549283485','江西省兴国县龙口镇A5栋','能找到女朋友吗？','','student/ljj.jpg',1,1,5,to_date('2015-8-24','yyyy-mm-dd'));
insert into student values(10005,'刘建杰5','宏图软件','女',18,'打球,打豆豆','1998-12-10','刘瑞财','18160774016','13549283485','江西省兴国县龙口镇A5栋','能找到女朋友吗？','','student/ljj.jpg',1,2,4,to_date('2015-8-24','yyyy-mm-dd'));
insert into student values(10006,'刘建杰6','宏图软件','女',18,'打球,打豆豆','1998-12-10','刘瑞财','18160774016','13549283485','江西省兴国县龙口镇A5栋','能找到女朋友吗？','','student/ljj.jpg',1,2,4,to_date('2015-8-24','yyyy-mm-dd'));
insert into student values(10007,'刘建杰7','宏图软件','女',18,'打球,打豆豆','1998-12-10','刘瑞财','18160774016','13549283485','江西省兴国县龙口镇A5栋','能找到女朋友吗？','','student/ljj.jpg',1,2,4,to_date('2015-8-24','yyyy-mm-dd'));
insert into student values(10008,'刘建杰8','宏图软件','女',18,'打球,打豆豆','1998-12-10','刘瑞财','18160774016','13549283485','江西省兴国县龙口镇A5栋','能找到女朋友吗？','','student/ljj.jpg',1,2,4,to_date('2015-8-24','yyyy-mm-dd'));
insert into student values(10009,'刘建杰9','宏图软件','女',18,'打球,打豆豆','1998-12-10','刘瑞财','18160774016','13549283485','江西省兴国县龙口镇A5栋','能找到女朋友吗？','','student/ljj.jpg',1,2,4,to_date('2015-8-24','yyyy-mm-dd'));
insert into student values(10010,'刘建杰10','宏图软件','女',18,'打球,打豆豆','1998-12-10','刘瑞财','18160774016','13549283485','江西省兴国县龙口镇A5栋','能找到女朋友吗？','','student/ljj.jpg',1,2,4,to_date('2015-8-24','yyyy-mm-dd'));
insert into student values(10011,'刘建杰11','宏图软件','女',18,'打球,打豆豆','1998-12-10','刘瑞财','18160774016','13549283485','江西省兴国县龙口镇A5栋','能找到女朋友吗？','','student/ljj.jpg',1,2,4,to_date('2015-8-24','yyyy-mm-dd'));
insert into student values(10012,'刘建杰12','宏图软件','女',18,'打球,打豆豆','1998-12-10','刘瑞财','18160774016','13549283485','江西省兴国县龙口镇A5栋','能找到女朋友吗？','','student/ljj.jpg',1,4,4,to_date('2015-8-24','yyyy-mm-dd'));
insert into student values(10013,'刘建杰13','宏图软件','女',18,'打球,打豆豆','1998-12-10','刘瑞财','18160774016','13549283485','江西省兴国县龙口镇A5栋','能找到女朋友吗？','','student/ljj.jpg',2,4,4,to_date('2015-8-24','yyyy-mm-dd'));
insert into student values(10014,'刘建杰14','宏图软件','女',18,'打球,打豆豆','1998-12-10','刘瑞财','18160774016','13549283485','江西省兴国县龙口镇A5栋','能找到女朋友吗？','','student/ljj.jpg',2,5,4,to_date('2015-8-24','yyyy-mm-dd'));
insert into student values(10015,'刘建杰15','宏图软件','女',18,'打球,打豆豆','1998-12-10','刘瑞财','18160774016','13549283485','江西省兴国县龙口镇A5栋','能找到女朋友吗？','','student/ljj.jpg',2,5,4,to_date('2015-8-24','yyyy-mm-dd'));
select * from classes for update

insert into classes values(1,'15秋4班',28,1,2,3,'4楼')
insert into classes values(2,'15秋3班',28,1,2,3,'5楼')
insert into classes values(seq_datas.nextval,'15秋3班',28,1,2,3,'5楼')
insert into classes values(seq_datas.nextval,'15秋3班',28,1,2,3,'5楼')
insert into classes values(seq_datas.nextval,'16秋1班',28,1,2,3,'5楼')
select * from elements
insert into elements values(1,'1单元');
insert into elements values(2,'2单元');

select * from hourse for update
insert into hourse values(3,1,'3-302',10001,12);
insert into hourse values(4,1,'3-301',10002,12);
insert into hourse values(5,2,'2-301',10004,12);
insert into hourse values(6,NULL,'2-301',10004,12);
update STUDENT set hourid=null where hourid=1

select * from student for update



select * from emp
select * from score for update

insert into score values(1,10001,72,1)
insert into score values(2,10002,71,1)
insert into score values(3,10003,70,2)

select * from course

--查出学生所在的班级为1
select classid from student where classid=2
select intenid from student where Classid=(select classid from classes where classid=1)

--查出科目
select * from classes
 select * from student for update
 select seq_hourse.nextval

--最终 通过 班级和课程条件查出
select o.*,c.classname,s.intenname,u.couname from score o,classes c,student s,course u where sconame=2 and stuid in(select intenid from student where Classid=(select classid from classes where classid=1)) and c.classid=s.classid and o.stuid=s.intenid and o.sconame=u.couid

select o.*,c.classname,s.intenname,u.couname from score o,classes
				c,student s,course u  where sconame=1 and stuid in(select intenid from
				student where Classid=(select classid from classes where classid=1))
				and c.classid=s.classid and o.stuid=s.intenid and o.sconame=u.couid
        
select s.intenname,c.classname,c.classid,s.intenid from student s inner join classes c on c.classid=s.classid where s.classid=1
select * from course where couid=1

所有成绩
select o.*,c.classname,s.intenname,u.couname from score o,classes
				c,student s,course u  where 
				c.classid=s.classid and o.stuid=s.intenid and o.sconame=u.couid and s.intenstatus=1
 --学生的序列
create sequence seq_stu
increment by 1
start with 10020
drop sequence seq_stu
--成绩的序列
create sequence seq_score
increment by 1
start with 4
select * from hourse
select seq_score.nextVal from dual
--宿舍的序列
create sequence seq_hourse
increment by 1
start with 4
--谈心的序列
create sequence seq_says
increment by 1
start with 2
--就业的序列
create sequence seq_job
increment by 1
start with 6
--学生总结的序列
create sequence seq_summary
increment by 1
start with 6
--班级的序列
create sequence seq_cls
increment by 1
start with 5
--意见反馈的序列
create sequence seq_sbk
increment by 1
start with 2
--意见反馈回复的序列
create sequence seq_rly
increment by 1
start with 1
--项目父表的序列
create sequence seq_prj
increment by 1
start with 3
--项目子表的序列
create sequence seq_dfs
increment by 1
start with 5
--请假的序列
create sequence seq_lev
increment by 1
start with 6
--备用电脑的序列
create sequence seq_apl
increment by 1
start with 2
--谈心
select * from says
select * from emp
select * from classes for update
insert into classes values(3,'14秋4班',28,1,2,59,'5楼')
insert into classes values(4,'14秋3班',28,1,2,50,'5楼')

insert into says values(1,10001,59,'早恋','早恋不好','少啰嗦');

select s.*,t.intenname from says s inner join student t on t.intenid=s.sayface where sayface=10001 and sayempid=59
select s.*,c.classname,t.intenname from says s inner join classes c on s.sayempid=c.empteaches inner join student t on t.intenid=s.sayface where sayempid=59
select s.*,c.classname,t.intenname from says s inner join classes c on s.sayempid=c.empteaches inner join student t on t.intenid=s.sayface where sayface=10001
select e.ename,e.eid from classes c inner join emp e on e.eid=c.empteaches

select s.*,t.intenname,t.intenid from says s inner join student t on s.sayface=t.intenid where sayempid=59

select * from Classes c inner join emp e on c.empteaches=e.eid and c.empteach=e.eid and c.empteachs=e.eid
select * from classes c inner join emp e on c.empteaches=e.eid 
select * from course
--学生总结
select * from summary
insert into summary values(1,10001,'很好 very good',59);
insert into summary values(2,10002,'很好2 very good',59);
insert into summary values(3,10003,'很好3 very good',59);
insert into summary values(4,10004,'很好4 very good',51);
insert into summary values(5,10005,'很好5 very good',51);

select s.*,t.intenname,e.ename from summary s inner join student t on t.intenid=s.sstuid inner join emp e on e.eid=s.steaches where sstuid=10001--学生

select s.*,t.intenname,e.ename from summary s inner join student t on t.intenid=s.sstuid inner join emp e on e.eid=s.steaches

select intenid from student s where classid=(select classid from classes where classid=1)
select s.*,t.intenname,e.ename from summary s inner join student t on t.intenid=s.sstuid inner join emp e on e.eid=s.steaches where sstuid in(select intenid from student s where classid=(select classid from classes where classid=2))

--就业
select * from job for update
insert into job values(1,10001,18160774016,'java软件',10000,'上海','五险一金','2016-12-10',59);
insert into job values(2,10002,18160774016,'java软件',10000,'上海','五险一金','2016-12-10',3);
insert into job values(5,10005,18160774016,'java软件',10000,'上海','五险一金','2016-12-10',3);
insert into job values(3,10003,18160774016,'java软件',10000,'上海','五险一金','2016-12-10',48);
insert into job values(4,10004,18160774016,'java软件',10000,'上海','五险一金','2016-12-10',50);
truncate table job



select empteaches from classes where classid=3
select j.*,s.intenname,e.ename from job j inner join student s on s.intenid=j.jobstu inner join emp e on e.eid=j.jobtea where jobtea=(select empteaches from classes where classid=2)
select j.*,s.intenname,e.ename from job j inner join student s on s.intenid=j.jobstu inner join emp e on e.eid=j.jobtea where jobtea=(select empteaches from classes where classid=3) and jobstu=10001
select j.*,s.intenname,e.ename from job j inner join student s on s.intenid=j.jobstu inner join emp e on e.eid=j.jobtea where   jobstu=10001

select j.*,s.intenname,e.ename from job j inner join student s on s.intenid=j.jobstu inner join emp e on e.eid=j.jobtea where jobtea=59

--项目
select seq_dfs.nextval from dual
select * from projectf for update
select * from defenses
truncate table defenses
select * from emp
insert into projectf values(1,1,48,53,to_date('2016-9-20','yyyy-mm-dd'),1);
insert into projectf values(2,2,48,53,to_date('2016-9-20','yyyy-mm-dd'),1);
insert into defenses values(1,1,10001,10001,49,10,10,6,6,10,91,'很不错！我喜欢');
insert into defenses values(2,1,10002,10002,49,10,10,6,6,10,91,'很不错！我喜欢2');
insert into defenses values(3,3,10003,10003,49,10,10,6,6,10,91,'很不错！我喜欢3');
insert into defenses values(4,2,'',10001,49,10,10,6,6,10,91,'很不错！我喜欢4');

select * from defenses d inner join projectf p on p.pid=d.pid where dmember=10001
select * from defenses d inner join projectf p on p.pid=d.pid where p.pclassid=1 and p.pname=1
select * from projectf p where p.pclassid=1 and p.pname=1



--意见
select * from sback

select * from sback where stdid=10012--学生

--意见反馈 学生
select s.*,t.intenname from sback s inner join student t on t.intenid=s.stdid where stdid=10012--学生 a
select * from reply

select s.*,t.intenname,r.rcon,r.rid from sback s inner join student t on t.intenid=s.stdid inner join reply r on r.sbackid=s.sbackid where s.statu=1
select s.*,t.intenname from sback s inner join student t on t.intenid=s.stdid where s.statu=0

select s.*,t.intenname,r.rcon,r.rid from sback s inner join student t on t.intenid=s.stdid inner join reply r on r.sbackid=s.sbackid where s.statu=0 and s.sempid=59

insert into sback values(1,10001,'早恋','老子早恋管你屁事',to_date('2016-7-23','yyyy-mm-dd'),59,0);

select * from reply for update
insert into reply values(seq_rly.nextval,1,59,'呵呵');

select s.intenname,c.classname,c.classid,
				s.intenid from student s inner join classes c on
				c.classid=s.classid where s.classid=1
        
        select * from projectf p where p.pclassid=3 and p.pname=1
        
--请假

select l.*,s.intenname from leave l inner join student s on s.intenid=l.lstuid where lshr=59 and lstate in(1,2)

insert into leave values(3,'肚子痛',to_date('2016-7-6','yyyy-mm-dd'),to_date('2016-7-7','yyyy-mm-dd'),1,59,10001,to_date('2016-7-6','yyyy-mm-dd'),0);
insert into leaselect * from leave for updateve values(4,'肚子痛',to_date('2016-7-6','yyyy-mm-dd'),to_date('2016-7-7','yyyy-mm-dd'),1,59,10001,to_date('2016-7-6','yyyy-mm-dd'),2);
insert into leave values(5,'肚子痛',to_date('2016-7-6','yyyy-mm-dd'),to_date('2016-7-7','yyyy-mm-dd'),1,59,10001,to_date('2016-7-6','yyyy-mm-dd'),1);

select * from leave

--日期
select * from leave where lstarttime<to_date('2016-8-3','yyyy-mm-dd')

select * from student where to_date(intenbir,'yyyy-mm-dd')>to_date('1998-12-10','yyyy-mm-dd')

--备用电脑领用


select * from application for update

--scbb
select * from defenses d inner join projectf p on p.pid=d.pid where p.pclassid=1 and p.pname=1

select d.*,p.*,s.intenname from defenses d inner join projectf p on p.pid=d.pid inner join student s on d.dmember=s.intenid where p.pclassid=1 and p.pname=1

select p.*,c.classname from projectf p inner join classes c on c.classid=p.pclassid

select s.*,t.intenname,t.classid from says s inner join student t on t.intenid=s.sayface where t.intenstatus=1

select s.*,t.intenname,e.ename from summary s inner join student t on t.intenid=s.sstuid inner join emp e on e.eid=s.steaches where sstuid=10001
select s.*,t.intenname,e.ename from summary s inner join student t on t.intenid=s.sstuid inner join emp e on e.eid=s.steaches where sstuid in(select intenid from student s where classid=(select classid from classes where classid=1))

--没有记录的学生 去除重复记录
select * from summary
select * from job
select * from student where intenid not in(select sstuid from summary) and classid=4

select * from student where intenid not in(select jobstu from job) and classid=4

select s.*,t.intenname,e.ename,t.classid from summary s inner join student t on t.intenid=s.sstuid inner join emp e on e.eid=s.steaches

select s.*,t.intenname,t.intenid,t.classid from says s inner join student t on s.sayface=t.intenid where sayempid=59 and t.intenstatus=2

select * from says

select s.*,t.intenname,t.intenid,t.classid from says s inner join student t on s.sayface=t.intenid where sayempid=59 and t.intenstatus=2

--学生在校记录
select distinct e.ename,e.eid from classes c inner join emp e on e.eid=c.empteaches 
select * from classes
--学生在校记录
select * from emp
select * from defenses for update
select * from student
select * from score where stuid=1
select * from says where sayface=1
select * from defenses d inner join projectf p on p.pid=d.pid where dmember=10001
select * from summary where sstuid=10027
select * from leave where lstuid=10027
select * from course
truncate table says

select s.*,t.intenname,t.classid from says s inner join student t on t.intenid=s.sayface order by sayid desc

--试试邮件系统
create table email(
       email_id number primary key,
       email_fid number not null,
       email_sid number not null,
       email_con varchar2(300),
       email_pro varchar2(10000),
       email_file varchar2(300),
       email_state number(1) not null,
       email_date date
)
