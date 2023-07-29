--stage��
--ҵ��Խ�� ���Ϊ0������ͨ�ջ�Ҫ�ڻ�
--          ���Ϊ1����Խ���ջ�Ҫ������⣬���ðڻ�
create table yfbc.stage
(
       stgid varchar2(32) not null,
       reid  varchar2(32) not null,
       SKUmodel varchar2(32) not null,
       packageqty  number(6) not null,
       receiveqty   number(6) not null,
       stgstate number(1) not null
);

comment on table yfbc.stage is 'stage��';
comment on column yfbc.stage.stgid is '����id';
comment on column yfbc.stage.reid is '�ջ�id';
comment on column yfbc.stage.SKUmodel is '��������';
comment on column yfbc.stage.packageqty is '���װ����';
comment on column yfbc.stage.receiveqty is '���������λ����';
comment on column yfbc.stage.stgstate is '�Ƿ�Խ�� 0:δԽ�⣬1ΪԽ��';

create index ix_stage on yfbc.stage(stgid);
alter table yfbc.stage
      add constraint pk_stage primary key(stgid)
      using index ix_stage  
     
