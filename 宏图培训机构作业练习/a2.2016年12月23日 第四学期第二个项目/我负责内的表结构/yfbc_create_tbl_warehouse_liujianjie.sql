--�ֿ��
create table ������.warehouse
(
       whid     varchar2(32) not null,
       whiname  varchar2(100) not null,
       userid   varchar2(32) not null,
       whistate   number(1)    not null --0����ʹ�� 1 ͣ��

);
comment on table ������.warehouse is '�ֿ��';
comment on column ������.warehouse.whid is '����id';
comment on column ������.warehouse.whiname is '��������';
comment on column ������.warehouse.userid is '�û�id';
comment on column ������.warehouse.whistate is '״̬ 0ͣ�� 1 ����ʹ�� ';

create index ix_warehouse on ������.warehouse(whid);
alter table ������.warehouse
      add constraint pk_warehouse primary key(whid)
      using index ix_warehouse    


