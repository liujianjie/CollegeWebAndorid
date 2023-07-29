create table district(
       d_id number(3),
       d_name varchar2(30) not null
)
comment on table scott.district is '�����';
comment on column scott.district.d_id is '����';
comment on column scott.district.d_name is '����';

create unique index un_did_index on scott.district(d_id);
alter table district 
      add constraint pk_did primary key(d_id)
          using index un_did_index


insert Into district values(1,'������');
insert Into district values(2,'������');
insert Into district values(3,'������');
insert Into district values(4,'��̨��');
insert Into district values(5,'������');
