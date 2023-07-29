
create table ������.consignment
(
       conid    varchar2(32) not null,
       DONO     varchar2(32) not null,
       pickdate date         not null,
       whid     varchar2(32) not null,
       PickID   varchar2(32) not null,
       SKUmodel varchar2(32) not null,
       packageqty number(6),
       pickqty    number(6),  
       damagedqty number(6),
       damagedreason   varchar2(100),
       totalweight     number(6),
       totalvolume     number(6)
);

comment on table ������.consignment is '������';
comment on column ������.consignment.conid is '����id';
comment on column ������.consignment.DONO is 'ԭDoNo.�˵���';
comment on column ������.consignment.pickdate is 'ʵ�ʳ���ʱ��';
comment on column ������.consignment.whid is '�ֿ���� ';
comment on column ������.consignment.PickID is '����ID';
comment on column ������.consignment.SKUmodel is '�����ͺ�';
comment on column ������.consignment.packageqty is '���װ����';
comment on column ������.consignment.pickqty is '���������λ���� ';
comment on column ������.consignment.damagedqty is '��������';
comment on column ������.consignment.damagedreason is '����ԭ����';
comment on column ������.consignment.totalweight is '�ջ�ë��';
comment on column ������.consignment.totalvolume is '�ջ���� ';


create index ix_consignment on ������.consignment(conid);
alter table ������.consignment
      add constraint pk_consignment primary key(conid)
      using index ix_consignment    

