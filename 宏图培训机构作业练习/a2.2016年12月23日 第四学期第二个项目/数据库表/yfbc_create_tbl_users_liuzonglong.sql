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
comment on table scott.users is '用户信息表';
comment on column scott.users.id is '主键id';
comment on column scott.users.username is '用户名';
comment on column scott.users.password is '密码';
comment on column scott.users.age is '年龄';
comment on column scott.users.sex is '性别';
comment on column scott.users.nickname is '昵称';
comment on column scott.users.mobile is '手机';
comment on column scott.users.address is '地址';
comment on column scott.users.limitid is '权限id';
comment on column scott.users.picpath is '头像';


create index ix_users on scott.users(id);
alter table scott.users
      add constraint pk_users primary key (id)
      using index ix_users;
      
