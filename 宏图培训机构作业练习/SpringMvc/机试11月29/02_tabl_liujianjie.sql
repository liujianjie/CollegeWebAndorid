select * from users where u_id = 1
create table blog
(
       b_id number(10) not null,
       b_content varchar2(1000) not null,
       b_publishtime date not null,
       b_userid number(10) not null
      
);

comment on table scott.blog is '΢������';
comment on column scott.blog.b_id is '����';
comment on column scott.blog.b_content is '����';
comment on column scott.blog.b_publishtime is '����ʱ��';
comment on column scott.blog.b_userid is '�û�';


create unique index un_ix_blog on scott.blog(b_id);
alter table blog    
      add constraint pk_blog_b_id primary key(b_id)
      using index un_ix_blog
