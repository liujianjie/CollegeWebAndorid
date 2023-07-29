--咨询表
create table informations(
       in_inforid number(10) primary key,
       in_title varchar2(30) not null,
       in_content varchar2(500) not null,
       in_replyCount number(10) not null,--回复次数
       in_viewCount number(10) not null,--查看次数
       in_reportTime date not null,--发表的时间
       in_lastPostTime date not null--回复时的系统时间
)
--回复表
create table replies(
       re_id number(10) primary key,
       in_inforid number(10) references informations(in_inforid),
       re_content varchar2(200) not null,--回复内容
       re_replyTime date not null--发表的系统时间
      )
