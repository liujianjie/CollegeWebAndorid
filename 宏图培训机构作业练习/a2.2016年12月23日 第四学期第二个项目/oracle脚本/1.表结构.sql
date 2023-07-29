--1.表创建
create table scott.student(
pk_serial    varchar2(32),
sname        varchar2(30) not null,
age          number(3) not null,
weight       number(5,2),
sex          varchar2(1) default 'M' not null ,
birthday     date
);
--加备注
comment on table scott.student is '学生表';
comment on column scott.student.pk_serial is '主键';
comment on column scott.student.sname is '姓名';
comment on column scott.student.age is '年龄';
comment on column scott.student.weight is '体重';
comment on column scott.student.sex is '性别,M:男 F:女';
comment on column scott.student.birthday is '生日';
--加约束
create unique index un_student_pk on scott.student(pk_serial);
alter table scott.student add constraint pk_student primary key(pk_serial)
using index un_student_pk;

--2.删除表
drop table scott.student;
--3.添加表字段
alter table scott.student add created_by varchar2(100) not null;
alter table scott.student add info varchar2(100) not null;
alter table scott.student add(
created_date      date not null,
updated_by        varchar2(100)  not null,
updated_date      date not null
);
comment on column scott.student.created_by is '创建人';
comment on column scott.student.created_date is '创建时间';
comment on column scott.student.updated_by is '修改人';
comment on column scott.student.updated_date is '修改时间';
--4.修改表字段
alter table scott.student modify updated_by varchar2(50) null;
--5.删除表字段
alter table scott.student drop column info;