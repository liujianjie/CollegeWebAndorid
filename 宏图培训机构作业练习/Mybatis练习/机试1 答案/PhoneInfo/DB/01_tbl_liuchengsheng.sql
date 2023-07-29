create table informations(
id                  number(10),
title               varchar2(30) not null,
content             varchar2(500) not null,
replyCount          number(10) not null,
viewCount           number(10) not null,
reportTime          date not null,
lastposttime        date not null
);
comment on table scott.informations is '��ѯ��';
comment on column scott.informations.id is '����';
comment on column scott.informations.title is '����';
comment on column scott.informations.content is '����';
comment on column scott.informations.replyCount is '�ظ�����';
comment on column scott.informations.viewCount is '�鿴����';
comment on column scott.informations.reportTime is '����ʱ��';
comment on column scott.informations.lastposttime is '�ظ�ʱ��';
--��������
create unique index un_ix_informations on scott.informations(id);
alter table informations 
      add constraint pk_informations primary key(id)
      using index un_ix_informations;