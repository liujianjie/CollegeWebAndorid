drop table post
select sys_guid() from dual
select * from post
create table Post
(
       p_id varchar2(32),
       p_name varchar2(100) not null,
       p_jianjie varchar2(300) not null,
       p_list varchar2(200)
);
comment on table ttz.Post is '岗位表';
comment on column Post.p_id is '主键';
comment on column Post.p_name is '名称';
comment on column Post.p_jianjie is '岗位描述 150字';
comment on column Post.p_list is '岗位的默认权限 100个';

create index ix_Post on ttz.Post(p_id);
alter table ttz.Post
      add constraint pk_Post primary key(p_id)
      using index ix_Post   
      
insert into ttz.post values(sys_guid(),'超级管理员','主要对后台用户的一些操作','1,2,3,4,5');
insert into ttz.post values(sys_guid(),'审核员','对前台用户的一些认证','6,7,8,9');


select * from background_user for update
select * from permission
