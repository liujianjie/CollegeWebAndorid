
drop table student

select * from student


//1学生表
create table student(
       Intenid number primary key,
       Intenname varchar2(100),
       Intensch varchar2(100),
       Intensex varchar2(10),
       Intenage number,
       Intenhob varchar2(100),
       Intenbir varchar2(100),
       Intenfat varchar2(100),
       Intentel varchar2(12),
       Intenfatel varchar2(12),
       Intenaddr varchar2(150),
       Intenpeo varchar2(120),
       Intenjob varchar2(25),--职位
       Intenimg varchar2(150),-- 头像
       Intenstatus number(1),--0 意向 1 在读 2 毕业
       Classid number,
       hourid number,
       Intentime varchar2(100)
)
select * from student
truncate table student
drop table student
alter table student modify hourid
alter table student modify Classid 

//2谈心记录表
create table says(
       Sayid Number primary key,
       Sayface Number not null,
       Sayempid Number not null,
       Sayscon varchar2(300) not null,
       Sayspro varchar2(300) not null,
       Saydate date,
       Sayback Varchar2(300)
)
alter table says modify saydate varchar2(100)
//3奖罚管理表
create table jc(
       jid number primary key,
       jstuid number not null,
       jtitle Varchar2(100) not null,
       jcontent Varchar2(300) not null,
       jstate number(1) not null--惩1 奖2

)
//4成绩管理表 理论
create table score(
       scoid Number primary key,
       stuid number,
       score float not null,
       sconame number

)
drop table score

//5项目答辩管理父表
create table projectf(
       pid Number primary key,
       pname number,--项目名称
       pteacher number not null,   --指导老师
       pteachers number not null,  --评委老师
       pdate date not null,        --演示日期
       pclassid number    --班级编码 
)
drop table projectf
alter table projectf modify pname number
alter table projectf modify pclassid number
//6项目答辩管理子表
create table defenses(
       did Number primary key,
       pid number,
       dhead number,               --组长
       dmember number,    --成员
       dfunction float,
       ddifficulty float,
       dbeanutiful float,
       ddemo float,
       dexpress float,
       danswer float,
       dscore float,
       dremark varchar2(100)       --备注
)
--增加一个控制合并的字段
alter table defenses add dcount number(1)

drop table defenses
//7学生总结管理表
create table summary(
       sIds number primary key,
       sstuid number not null,
       ssay varchar2(300) not null--学生评语
)
alter table summary add steaches number
//8就业管理表
create table job(
       Jobid number primary key,
       jobstu number not null,
       jobnum varchar2(11),        --联系电话
       jobname varchar2(100) not null,   --职位
       jobsalary float not null,--薪水
       jobaddr varchar2(150),    --住址
       jobdesc varchar2(1000)--职位描述 福利 什么的
)
alter table job add jobdate varchar2(100);
alter table job modify jobdesc varchar2(1000);
alter table job add jobtea number
//9备用电脑申请表
create table Application(
       Aid number primary key,
       aname varchar2(1000),--原因
       atime number(3),--多少天
       astuid number,--学生
       astarttime date,--开始时间
       aendtime date,--结束时间
       ashr number,--审核人
       astate number(1)--0未提交 1审核中 2不同意 3同意
)
alter table Application modify aname varchar2(1000);
insert into application values(1,'电脑坏了',10,10001,to_date('2016-7-6','yyyy-mm-dd'),to_date('2016-7-16','yyyy-mm-dd'),59,1)
drop table Application
//10学生请假管理表
create table leave(
      lid number primary key,
      lname varchar2(1000) not null,
      lstarttime date,
      lendtime date,
      ltime number(3),--多少天
      lshr number,--审核人
      lstuid number,
      ldate date,--创建时间
      lstate number(1) --0未提交 1审核中 2不同意 3同意
)
select * from apl for update
alter table leave modify lname varchar2(1000);
drop table leave
select to_date('2015-6-6','yyyy-mm-dd')，to_date('2015-6-4','yyyy-mm-dd')

--审核人

//11赠送电脑领取表
create table computer(
       cid number primary key,
       cstuid number not null,
       cname varchar2(50) not null,
       cremark varchar2(100) not null
)

select * from Application for update
//12学生意见反馈表
create table sback(
       sbackid number primary key,
       stdid number not null,
       sbacktitle varchar2(50) not null,
       sbackcon varchar2(300) not null,
       sdate date not null,
       sempid number ,              --查看人老师id
       statu number(1)--0为未处理 1为回复 2为不显示   
)
alter table sback modify sempid number 
truncate table sback
drop table sback
drop table sback
select * from sback for update
--回复反馈表
create table reply(
       rid number primary key,
       sbackid number,
       reid number,
      rcon varchar2(300)
    )
drop table reply
//13.班级表
create table classes(
       classid number primary key,
       classname varchar2(50) not null,
       classcount number(3) not null,
       empteach number not null,
       empteachs number,
       empteaches number,
       classaddr varchar2(100)

)
//14.宿舍单元表
create table elements(
       eid number(2) primary key,
       ename varchar2(50) not null
)

//15.宿舍房间表
create table hourse(
       hourid number(4) primary key,
       eid number(2) not null,  --1对多关系
       hourname varchar2(50) not null,
       hhead number, --宿舍长
       hnumber number --能住多少人
)
select user from dual



