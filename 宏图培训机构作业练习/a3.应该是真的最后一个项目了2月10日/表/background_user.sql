--用户表

create table background_user(
       b_id  varchar2(32) not null,
       b_username varchar2(50) not null,
       b_pwd      varchar2(50) not null,
       b_tel      varchar2(11) not null,
       b_sex      varchar2(2) not null,
       b_address  varchar2(80) not null,
       b_positionid varchar2(32),
       b_touxiang varchar2(200) not null,
       b_statu    number(1) not null
);
comment on table ttz.background_user is '后台用户表'; 
comment on column ttz.background_user.b_id is '主键id';
comment on column ttz.background_user.b_username is '用户姓名';
comment on column ttz.background_user.b_pwd is '密码';
comment on column ttz.background_user.b_tel is '电话';
comment on column ttz.background_user.b_sex is '性别';
comment on column ttz.background_user.b_address is '地址';
comment on column ttz.background_user.b_positionid is '岗位 可为空';
comment on column ttz.background_user.b_touxiang is '头像';
comment on column ttz.background_user.b_statu is '状态,登录与退出';

create index ix_background_user on ttz.background_user(b_id);
alter table ttz.background_user
      add constraint pk_background_user primary key(b_id)
      using index ix_background_user 
      
insert
 into background_user values(sys_guid(),'admin','123','18160774016','男','赣州','超级管理员','image/zf.jpg',1)
 select * from ttz.background_user for update

drop table background_user      
--权限表
insert into permission values(sys_guid(),'E3A83CCEEBAC49E4AF59303BD2DC19BB',1);
drop table permission
select * from permission for update
create table permission(
       p_id  varchar2(32) not null,
       b_id varchar2(32) not null,
       p_list      varchar2(2) not null--还是用 a,b,c代表
);
comment on table ttz.permission is '后台权限表'; 
comment on column ttz.permission.p_id is '主键id';
comment on column ttz.permission.b_id is '用户id';
comment on column ttz.permission.p_list is '权限项';

create index ix_permission on ttz.permission(p_id);
alter table ttz.permission
      add constraint pk_permission primary key(p_id)
      using index ix_permission 
      
