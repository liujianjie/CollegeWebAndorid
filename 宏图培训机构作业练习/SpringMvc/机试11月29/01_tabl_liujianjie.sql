
create table users
(
       u_id number(10) not null,
       u_username varchar2(20) not null,
       u_password varchar2(40) not null,
       u_age number(10) not null,
       u_sex varchar2(10) not null,
       u_nickname varchar2(20) not null,
       u_mobile varchar2(15) not null,
       u_address varchar2(50) not null,
       u_supper number(10) not null,
       u_picpath varchar2(200) not null
);

comment on table scott.users is '微博用户表';
comment on column scott.users.u_id is '主键';
comment on column scott.users.u_username is '用户名';
comment on column scott.users.u_password is '密码';
comment on column scott.users.u_age is '年龄';
comment on column scott.users.u_sex is '性别';
comment on column scott.users.u_nickname is '昵称';
comment on column scott.users.u_mobile is '手机';
comment on column scott.users.u_address is '住址';
comment on column scott.users.u_supper is '管理员';
comment on column scott.users.u_picpath is '头像名称';

create unique index un_ix_users on scott.users(u_id);
alter table users    
      add constraint pk_users_u_id primary key(u_id)
      using index un_ix_users

