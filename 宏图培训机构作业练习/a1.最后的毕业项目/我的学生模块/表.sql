
drop table student

select * from student


//1ѧ����
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
       Intenjob varchar2(25),--ְλ
       Intenimg varchar2(150),-- ͷ��
       Intenstatus number(1),--0 ���� 1 �ڶ� 2 ��ҵ
       Classid number,
       hourid number,
       Intentime varchar2(100)
)
select * from student
truncate table student
drop table student
alter table student modify hourid
alter table student modify Classid 

//2̸�ļ�¼��
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
//3���������
create table jc(
       jid number primary key,
       jstuid number not null,
       jtitle Varchar2(100) not null,
       jcontent Varchar2(300) not null,
       jstate number(1) not null--��1 ��2

)
//4�ɼ������ ����
create table score(
       scoid Number primary key,
       stuid number,
       score float not null,
       sconame number

)
drop table score

//5��Ŀ��������
create table projectf(
       pid Number primary key,
       pname number,--��Ŀ����
       pteacher number not null,   --ָ����ʦ
       pteachers number not null,  --��ί��ʦ
       pdate date not null,        --��ʾ����
       pclassid number    --�༶���� 
)
drop table projectf
alter table projectf modify pname number
alter table projectf modify pclassid number
//6��Ŀ�������ӱ�
create table defenses(
       did Number primary key,
       pid number,
       dhead number,               --�鳤
       dmember number,    --��Ա
       dfunction float,
       ddifficulty float,
       dbeanutiful float,
       ddemo float,
       dexpress float,
       danswer float,
       dscore float,
       dremark varchar2(100)       --��ע
)
--����һ�����ƺϲ����ֶ�
alter table defenses add dcount number(1)

drop table defenses
//7ѧ���ܽ�����
create table summary(
       sIds number primary key,
       sstuid number not null,
       ssay varchar2(300) not null--ѧ������
)
alter table summary add steaches number
//8��ҵ�����
create table job(
       Jobid number primary key,
       jobstu number not null,
       jobnum varchar2(11),        --��ϵ�绰
       jobname varchar2(100) not null,   --ְλ
       jobsalary float not null,--нˮ
       jobaddr varchar2(150),    --סַ
       jobdesc varchar2(1000)--ְλ���� ���� ʲô��
)
alter table job add jobdate varchar2(100);
alter table job modify jobdesc varchar2(1000);
alter table job add jobtea number
//9���õ��������
create table Application(
       Aid number primary key,
       aname varchar2(1000),--ԭ��
       atime number(3),--������
       astuid number,--ѧ��
       astarttime date,--��ʼʱ��
       aendtime date,--����ʱ��
       ashr number,--�����
       astate number(1)--0δ�ύ 1����� 2��ͬ�� 3ͬ��
)
alter table Application modify aname varchar2(1000);
insert into application values(1,'���Ի���',10,10001,to_date('2016-7-6','yyyy-mm-dd'),to_date('2016-7-16','yyyy-mm-dd'),59,1)
drop table Application
//10ѧ����ٹ����
create table leave(
      lid number primary key,
      lname varchar2(1000) not null,
      lstarttime date,
      lendtime date,
      ltime number(3),--������
      lshr number,--�����
      lstuid number,
      ldate date,--����ʱ��
      lstate number(1) --0δ�ύ 1����� 2��ͬ�� 3ͬ��
)
select * from apl for update
alter table leave modify lname varchar2(1000);
drop table leave
select to_date('2015-6-6','yyyy-mm-dd')��to_date('2015-6-4','yyyy-mm-dd')

--�����

//11���͵�����ȡ��
create table computer(
       cid number primary key,
       cstuid number not null,
       cname varchar2(50) not null,
       cremark varchar2(100) not null
)

select * from Application for update
//12ѧ�����������
create table sback(
       sbackid number primary key,
       stdid number not null,
       sbacktitle varchar2(50) not null,
       sbackcon varchar2(300) not null,
       sdate date not null,
       sempid number ,              --�鿴����ʦid
       statu number(1)--0Ϊδ���� 1Ϊ�ظ� 2Ϊ����ʾ   
)
alter table sback modify sempid number 
truncate table sback
drop table sback
drop table sback
select * from sback for update
--�ظ�������
create table reply(
       rid number primary key,
       sbackid number,
       reid number,
      rcon varchar2(300)
    )
drop table reply
//13.�༶��
create table classes(
       classid number primary key,
       classname varchar2(50) not null,
       classcount number(3) not null,
       empteach number not null,
       empteachs number,
       empteaches number,
       classaddr varchar2(100)

)
//14.���ᵥԪ��
create table elements(
       eid number(2) primary key,
       ename varchar2(50) not null
)

//15.���᷿���
create table hourse(
       hourid number(4) primary key,
       eid number(2) not null,  --1�Զ��ϵ
       hourname varchar2(50) not null,
       hhead number, --���᳤
       hnumber number --��ס������
)
select user from dual



