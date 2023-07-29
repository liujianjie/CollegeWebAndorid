
drop table student

select * from student

//1学生表
create table student(
       Intenid number primary key,
       Intenname varchar2(100) not null,
       Intensch varchar2(100) not null,
       Intensex varchar2(10) not null,
       Intenage number not null,
       Intenhob varchar2(100),
       Intenbir date not null,
       Intenfat varchar2(100) not null,
       Intentel varchar2(12) not null,
       Intenfatel varchar2(12) not null,
       Intenaddr varchar2(150) not null,
       Intenpeo varchar2(120),
       Intenjob varchar2(25),--职位
       Intenimg varchar2(150),-- 头像
       Intenstatus number(1) not null,--0 意向 1 在读 2 毕业
       Classid number not null,
       hourid number not null,
       Intentime date not null
)
//2谈心记录表
create table says(
       Sayid Number primary key,
       Sayface Number not null,
       Sayempid Number not null,
       Sayscon varchar2(300) not null,
       Sayspro varchar2(300) not null,
       Sayback Varchar2(300)
)
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
       stuid number not null,
       score float not null,
       sconame varchar2(50) not null

)
//5项目答辩管理父表
create table projectf(
       pid Number primary key,
       pname varchar2(50) not null,--项目名称
       pteacher number not null,   --指导老师
       pteachers number not null,  --评委老师
       pdate date not null,        --演示日期
       pclassid number not null    --班级编码 
)
//6项目答辩管理子表
create table defenses(
       did Number primary key,
       pid number not null,
       dhead number,               --组长
       dmember number not null,    --成员
       dfunction float not null,
       ddifficulty float not null,
       dbeanutiful float not null,
       ddemo float not null,
       dexpress float not null,
       danswer float not null,
       dscore float not null,
       dremark varchar2(100)       --备注
)
//7学生总结管理表
create table summary(
       sIds number primary key,
       sstuid number not null,
       ssay varchar2(300) not null--学生评语
)
//8就业管理表
create table job(
       Jobid number primary key,
       jobstu number not null,
       jobnum varchar2(11),
       jobname varchar2(100) not null,
       jobsalary float not null,
       jobaddr varchar2(150),
       jobdesc varchar2(100)--职位描述 福利 什么的
)
//9备用电脑申请表
create table Application(
       Aid number primary key,
       aname varchar2(100) not null,
       atime number(3) not null,--多少天
       astuid number not null,
       adate date not null,
       ateacher number(1) not null,--班主任
       ateachers number(1) not null,--任课老师
       alogistis number(1) not null,--后勤部
       astate number(1) not null
)
//10学生请假管理表
create table leave(
      lid number primary key,
      lname varchar2(100) not null,
      ltime number(3) not null,--多少天
      lteacher number(1) not null,
      lteachers number(1) not null,
      lhead number(1) not null,
      lstuid number not null,
      ldate date not null,
      lstate number(1) not null
)
//11赠送电脑领取表
create table computer(
       cid number primary key,
       cstuid number not null,
       cname varchar2(50) not null,
       cremark varchar2(100) not null
)


//12学生意见反馈表
create table sback(
       sbackid number primary key,
       stdid number not null,
       sbacktitle varchar2(50) not null,
       sbackcon varchar2(300) not null,
       sdate date not null
)
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

