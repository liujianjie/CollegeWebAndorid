create table backposition(
       p_id  varchar2(32) not null,
       p_name  varchar2(50) not null
);
comment on table ttz.backposition is '后台岗位表'; 
comment on column ttz.backposition.p_id is '主键id';
comment on column ttz.backposition.p_name is '名称';

create index ix_backposition on ttz.backposition(p_id);
alter table ttz.backposition
      add constraint pk_backposition primary key(p_id)
      using index ix_backposition
      
insert into backposition values(sys_guid(),'超级管理员');

insert into backposition values(sys_guid(),'会计');

select * from backposition
