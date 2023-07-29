
drop table student

select * from student

//1ѧ����
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
       Intenjob varchar2(25),--ְλ
       Intenimg varchar2(150),-- ͷ��
       Intenstatus number(1) not null,--0 ���� 1 �ڶ� 2 ��ҵ
       Classid number not null,
       hourid number not null,
       Intentime date not null
)
//2̸�ļ�¼��
create table says(
       Sayid Number primary key,
       Sayface Number not null,
       Sayempid Number not null,
       Sayscon varchar2(300) not null,
       Sayspro varchar2(300) not null,
       Sayback Varchar2(300)
)
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
       stuid number not null,
       score float not null,
       sconame varchar2(50) not null

)
//5��Ŀ��������
create table projectf(
       pid Number primary key,
       pname varchar2(50) not null,--��Ŀ����
       pteacher number not null,   --ָ����ʦ
       pteachers number not null,  --��ί��ʦ
       pdate date not null,        --��ʾ����
       pclassid number not null    --�༶���� 
)
//6��Ŀ�������ӱ�
create table defenses(
       did Number primary key,
       pid number not null,
       dhead number,               --�鳤
       dmember number not null,    --��Ա
       dfunction float not null,
       ddifficulty float not null,
       dbeanutiful float not null,
       ddemo float not null,
       dexpress float not null,
       danswer float not null,
       dscore float not null,
       dremark varchar2(100)       --��ע
)
//7ѧ���ܽ�����
create table summary(
       sIds number primary key,
       sstuid number not null,
       ssay varchar2(300) not null--ѧ������
)
//8��ҵ�����
create table job(
       Jobid number primary key,
       jobstu number not null,
       jobnum varchar2(11),
       jobname varchar2(100) not null,
       jobsalary float not null,
       jobaddr varchar2(150),
       jobdesc varchar2(100)--ְλ���� ���� ʲô��
)
//9���õ��������
create table Application(
       Aid number primary key,
       aname varchar2(100) not null,
       atime number(3) not null,--������
       astuid number not null,
       adate date not null,
       ateacher number(1) not null,--������
       ateachers number(1) not null,--�ο���ʦ
       alogistis number(1) not null,--���ڲ�
       astate number(1) not null
)
//10ѧ����ٹ����
create table leave(
      lid number primary key,
      lname varchar2(100) not null,
      ltime number(3) not null,--������
      lteacher number(1) not null,
      lteachers number(1) not null,
      lhead number(1) not null,
      lstuid number not null,
      ldate date not null,
      lstate number(1) not null
)
//11���͵�����ȡ��
create table computer(
       cid number primary key,
       cstuid number not null,
       cname varchar2(50) not null,
       cremark varchar2(100) not null
)


//12ѧ�����������
create table sback(
       sbackid number primary key,
       stdid number not null,
       sbacktitle varchar2(50) not null,
       sbackcon varchar2(300) not null,
       sdate date not null
)
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

