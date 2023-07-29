create table district(
       d_id number(3),
       d_name varchar2(30) not null
)
comment on table scott.district is '区域表';
comment on column scott.district.d_id is '主键';
comment on column scott.district.d_name is '名称';

create unique index un_did_index on scott.district(d_id);
alter table district 
      add constraint pk_did primary key(d_id)
          using index un_did_index


insert Into district values(1,'西城区');
insert Into district values(2,'东城区');
insert Into district values(3,'海定区');
insert Into district values(4,'丰台区');
insert Into district values(5,'朝阳区');
