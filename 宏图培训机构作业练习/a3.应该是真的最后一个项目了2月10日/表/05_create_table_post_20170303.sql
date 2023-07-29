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
comment on table ttz.Post is '��λ��';
comment on column Post.p_id is '����';
comment on column Post.p_name is '����';
comment on column Post.p_jianjie is '��λ���� 150��';
comment on column Post.p_list is '��λ��Ĭ��Ȩ�� 100��';

create index ix_Post on ttz.Post(p_id);
alter table ttz.Post
      add constraint pk_Post primary key(p_id)
      using index ix_Post   
      
insert into ttz.post values(sys_guid(),'��������Ա','��Ҫ�Ժ�̨�û���һЩ����','1,2,3,4,5');
insert into ttz.post values(sys_guid(),'���Ա','��ǰ̨�û���һЩ��֤','6,7,8,9');


select * from background_user for update
select * from permission
