--�û���

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
comment on table ttz.background_user is '��̨�û���'; 
comment on column ttz.background_user.b_id is '����id';
comment on column ttz.background_user.b_username is '�û�����';
comment on column ttz.background_user.b_pwd is '����';
comment on column ttz.background_user.b_tel is '�绰';
comment on column ttz.background_user.b_sex is '�Ա�';
comment on column ttz.background_user.b_address is '��ַ';
comment on column ttz.background_user.b_positionid is '��λ ��Ϊ��';
comment on column ttz.background_user.b_touxiang is 'ͷ��';
comment on column ttz.background_user.b_statu is '״̬,��¼���˳�';

create index ix_background_user on ttz.background_user(b_id);
alter table ttz.background_user
      add constraint pk_background_user primary key(b_id)
      using index ix_background_user 
      
insert
 into background_user values(sys_guid(),'admin','123','18160774016','��','����','��������Ա','image/zf.jpg',1)
 select * from ttz.background_user for update

drop table background_user      
--Ȩ�ޱ�
insert into permission values(sys_guid(),'E3A83CCEEBAC49E4AF59303BD2DC19BB',1);
drop table permission
select * from permission for update
create table permission(
       p_id  varchar2(32) not null,
       b_id varchar2(32) not null,
       p_list      varchar2(2) not null--������ a,b,c����
);
comment on table ttz.permission is '��̨Ȩ�ޱ�'; 
comment on column ttz.permission.p_id is '����id';
comment on column ttz.permission.b_id is '�û�id';
comment on column ttz.permission.p_list is 'Ȩ����';

create index ix_permission on ttz.permission(p_id);
alter table ttz.permission
      add constraint pk_permission primary key(p_id)
      using index ix_permission 
      
