create table users(
       id varchar2(32) not null,
       username varchar2(20) not null,
       password varchar2(40) not null,
       age number(10) not null,
       sex varchar2(4) not null,
       nickname varchar2(20) not null,
       mobile number(15) not null,
       address varchar2(50) not null,
       limitid varchar2(32) not null,
       picpath varchar2(100)
);
comment on table scott.users is '�û���Ϣ��';
comment on column scott.users.id is '����id';
comment on column scott.users.username is '�û���';
comment on column scott.users.password is '����';
comment on column scott.users.age is '����';
comment on column scott.users.sex is '�Ա�';
comment on column scott.users.nickname is '�ǳ�';
comment on column scott.users.mobile is '�ֻ�';
comment on column scott.users.address is '��ַ';
comment on column scott.users.limitid is 'Ȩ��id';
comment on column scott.users.picpath is 'ͷ��';


create index ix_users on scott.users(id);
alter table scott.users
      add constraint pk_users primary key (id)
      using index ix_users;
      
