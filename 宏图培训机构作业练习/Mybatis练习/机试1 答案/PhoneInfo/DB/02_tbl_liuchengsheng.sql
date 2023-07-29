create table replies(
id number(10),
content       varchar2(200) not null,
replytime date not null,
infoId    number(10)
);
comment on table scott.replies is '�ظ���';
comment on column scott.replies.id is '����';
comment on column scott.replies.replytime is '�ظ�ʱ��';
comment on column scott.replies.content is '����';
comment on column scott.replies.infoId is '��ѯid';
--��Ӽ�
create unique index un_ix_replies on scott.replies(id);
alter table replies 
      add constraint pk_replies primary key(id)
      using index un_ix_replies;
alter table replies 
      add constraint fk_replies_info 
      foreign key(infoId) references informations(id);