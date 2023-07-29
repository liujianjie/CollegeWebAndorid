create table backposition(
       p_id  varchar2(32) not null,
       p_name  varchar2(50) not null
);
comment on table ttz.backposition is '��̨��λ��'; 
comment on column ttz.backposition.p_id is '����id';
comment on column ttz.backposition.p_name is '����';

create index ix_backposition on ttz.backposition(p_id);
alter table ttz.backposition
      add constraint pk_backposition primary key(p_id)
      using index ix_backposition
      
insert into backposition values(sys_guid(),'��������Ա');

insert into backposition values(sys_guid(),'���');

select * from backposition
