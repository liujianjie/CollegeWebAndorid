create table yfbc.shelf
(
       sheid    varchar2(32) not null,
       shename  varchar2(50) not null,
       whid     varchar2(32) not null,
       shestate number(1) not null --0Ϊ���� 1Ϊδ��
);

comment on table yfbc.shelf is '���ܱ�';
comment on column yfbc.shelf.sheid is '����id';
comment on column yfbc.shelf.shename is '��������';
comment on column yfbc.shelf.whid is '�ֿ�id ���1';
comment on column yfbc.shelf.shestate is '״̬ 0Ϊδ�� 1Ϊ���� ';

create index ix_shelf on yfbc.shelf(sheid);
alter table yfbc.shelf
      add constraint pk_shelf primary key(sheid)
      using index ix_shelf    

