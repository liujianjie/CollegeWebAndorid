--1.����
create table scott.student(
pk_serial    varchar2(32),
sname        varchar2(30) not null,
age          number(3) not null,
weight       number(5,2),
sex          varchar2(1) default 'M' not null ,
birthday     date
);
--�ӱ�ע
comment on table scott.student is 'ѧ����';
comment on column scott.student.pk_serial is '����';
comment on column scott.student.sname is '����';
comment on column scott.student.age is '����';
comment on column scott.student.weight is '����';
comment on column scott.student.sex is '�Ա�,M:�� F:Ů';
comment on column scott.student.birthday is '����';
--��Լ��
create unique index un_student_pk on scott.student(pk_serial);
alter table scott.student add constraint pk_student primary key(pk_serial)
using index un_student_pk;

--2.ɾ����
drop table scott.student;
--3.��ӱ��ֶ�
alter table scott.student add created_by varchar2(100) not null;
alter table scott.student add info varchar2(100) not null;
alter table scott.student add(
created_date      date not null,
updated_by        varchar2(100)  not null,
updated_date      date not null
);
comment on column scott.student.created_by is '������';
comment on column scott.student.created_date is '����ʱ��';
comment on column scott.student.updated_by is '�޸���';
comment on column scott.student.updated_date is '�޸�ʱ��';
--4.�޸ı��ֶ�
alter table scott.student modify updated_by varchar2(50) null;
--5.ɾ�����ֶ�
alter table scott.student drop column info;