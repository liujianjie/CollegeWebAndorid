--����� ��������һһ��Ӧ ʵ�ʼ���ı�
create table ������.picking
(
       picid varchar2(32) not null,
       piid  varchar2(32) not null,
       packageqty         number(6) not null,
       pickqty            number(6) not null,
       damagedqty         number(6) not null,
       damagedreason      varchar2(200) not null                                                                                                                            
);
        
comment on table ������.picking is 'Ҫ�������';
comment on column ������.picking.picid is '����';
comment on column ������.picking.piid is '�����id';
comment on column ������.picking.packageqty is '���װ����';
comment on column ������.picking.pickqty is '���������λ����';
comment on column ������.picking.damagedqty is '��������';
comment on column ������.picking.damagedreason is '����ԭ����';

create index ix_picking on ������.picking(piid);
alter table ������.picking
      add constraint pk_picking primary key(piid)
      using index ix_picking
                                              
