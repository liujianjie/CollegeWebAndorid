drop table receiving
create table yfbc.receiving
(
       reid         varchar2(32) not null,
       inid         varchar2(32) not null,
       receivedate date not null,
       whid        varchar2(32) not null,
       productname     varchar2(50) not null,
       sku         varchar2(32) not null,
       purchaseqty number(6) not null,
       unit        number(1) not null,
       shortqty    number(1),
       partflag    number(1) not null,--0���ֵ�����1ȫ������
       putstate    number(1) not null --0ΪΪ�ڻ�   1Ϊ�Ѱڻ�
);
comment on table yfbc.receiving is '�ջ��';
comment on column yfbc.receiving.reid is '����id';
comment on column yfbc.receiving.inid is '���ƻ�����������';
comment on column yfbc.receiving.receivedate is 'ʵ�����ʱ��';
comment on column yfbc.receiving.whid is '�ֿ����';
comment on column yfbc.receiving.productname is '��������';
comment on column yfbc.receiving.sku is '��������';
comment on column yfbc.receiving.purchaseqty is '����';
comment on column yfbc.receiving.unit is '��λ';
comment on column yfbc.receiving.shortqty is 'ȱ������';
comment on column yfbc.receiving.partflag is '0�����ֵ��� 1��ȫ������';
comment on column yfbc.receiving.putstate is '0ΪΪ�ڻ�   1Ϊ�Ѱڻ�';


create index ix_receiving on yfbc.receiving(reid);
alter table yfbc.receiving
      add constraint pk_receiving primary key(reid)
      using index ix_receiving  
     
--drop table receiving
delete r
delete put_away
select * from rack for update
select * from put_away for update
select * from warehouse
select * from receiving where to_date('2017-1-13','yyyy-mm/dd')<receivedate and receivedate<to_date('2018-6-9','yyyy-mm-dd') for update

select * from in_storage for update

select * from (select rownum r,i.* from receiving i where rownum <=(10) order by receivedate desc)where r>(0)

select * from users
select * from permissions
