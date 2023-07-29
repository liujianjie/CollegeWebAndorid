prompt PL/SQL Developer import file
prompt Created on 2019年6月8日 by Administrator
set feedback off
set define off
prompt Creating GAME...
create table GAME
(
  id        INTEGER not null,
  qqnum     VARCHAR2(50),
  qqname    VARCHAR2(50),
  vip       VARCHAR2(10) default '不是',
  shescore  INTEGER,
  shenode   INTEGER default 2,
  txzgk     INTEGER default 1,
  shetoux0  INTEGER,
  shetouy0  INTEGER,
  shetoux1  INTEGER,
  shetouy1  INTEGER,
  foodx     INTEGER,
  foody     INTEGER,
  direction INTEGER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table GAME
  add constraint PK_GAME primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt Creating HISTORY...
create table HISTORY
(
  id     INTEGER not null,
  qqnum  VARCHAR2(50) not null,
  qqpwd  VARCHAR2(50),
  qqface VARCHAR2(50) not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table HISTORY
  add constraint PK_HISTORY primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt Creating QQ...
create table QQ
(
  id        INTEGER not null,
  qqnum     VARCHAR2(50) not null,
  qqname    VARCHAR2(50) not null,
  pwd       VARCHAR2(50) not null,
  face      VARCHAR2(50) not null,
  names     VARCHAR2(50),
  age       INTEGER,
  sex       VARCHAR2(50) not null,
  dateremix VARCHAR2(50) not null,
  years     VARCHAR2(20) not null,
  months    VARCHAR2(50) not null,
  days      VARCHAR2(50) not null,
  country   VARCHAR2(20) not null,
  province  VARCHAR2(50) not null,
  city      VARCHAR2(50) not null,
  mark      VARCHAR2(100),
  nation    VARCHAR2(50),
  levels    INTEGER,
  star      VARCHAR2(20),
  status    INTEGER not null,
  ipadd     VARCHAR2(50),
  port      INTEGER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table QQ
  add constraint PK_QQ primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt Creating QQFRID...
create table QQFRID
(
  id        INTEGER not null,
  myqq      VARCHAR2(20) not null,
  friqq     VARCHAR2(20) not null,
  groupname VARCHAR2(20) not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table QQFRID
  add constraint PK_QQFRID primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt Creating WEIYUN...
create table WEIYUN
(
  qqnum      VARCHAR2(50),
  qqname     VARCHAR2(50),
  filepath   VARCHAR2(100),
  filenames  VARCHAR2(100),
  dateremix  VARCHAR2(100),
  filelayout VARCHAR2(100)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt Disabling triggers for GAME...
alter table GAME disable all triggers;
prompt Disabling triggers for HISTORY...
alter table HISTORY disable all triggers;
prompt Disabling triggers for QQ...
alter table QQ disable all triggers;
prompt Disabling triggers for QQFRID...
alter table QQFRID disable all triggers;
prompt Disabling triggers for WEIYUN...
alter table WEIYUN disable all triggers;
prompt Deleting WEIYUN...
delete from WEIYUN;
commit;
prompt Deleting QQFRID...
delete from QQFRID;
commit;
prompt Deleting QQ...
delete from QQ;
commit;
prompt Deleting HISTORY...
delete from HISTORY;
commit;
prompt Deleting GAME...
delete from GAME;
commit;
prompt Loading GAME...
insert into GAME (id, qqnum, qqname, vip, shescore, shenode, txzgk, shetoux0, shetouy0, shetoux1, shetouy1, foodx, foody, direction)
values (132, '5343', '小小', '不是', 40, 2, 1, 0, 0, 0, 0, 0, 0, 0);
insert into GAME (id, qqnum, qqname, vip, shescore, shenode, txzgk, shetoux0, shetouy0, shetoux1, shetouy1, foodx, foody, direction)
values (134, '4685', '大大', '是', 140, 8, 10, 320, 240, 320, 260, 100, 120, 3);
commit;
prompt 2 records loaded
prompt Loading HISTORY...
insert into HISTORY (id, qqnum, qqpwd, qqface)
values (139, '5343', '123456', 'img/4.png');
insert into HISTORY (id, qqnum, qqpwd, qqface)
values (135, '4685', '123456', 'img/7.png');
commit;
prompt 2 records loaded
prompt Loading QQ...
insert into QQ (id, qqnum, qqname, pwd, face, names, age, sex, dateremix, years, months, days, country, province, city, mark, nation, levels, star, status, ipadd, port)
values (131, '5343', '小小', '123456', 'img/4.png', null, 0, '男', '公历', '2016年', '1月', '1日', '中国', '江西', '赣州', '我想起那天夕阳下的奔跑 是我逝去的青春，走马灯在我脑海里闪回，仿佛回到那个懵懂无知年代', '汉族', 0, '白羊座', 0, '127.0.0.1', 10358);
insert into QQ (id, qqnum, qqname, pwd, face, names, age, sex, dateremix, years, months, days, country, province, city, mark, nation, levels, star, status, ipadd, port)
values (133, '4685', '大大', '123456', 'img/7.png', null, 0, '女', '公历', '2016年', '1月', '1日', '中国', '江西', '赣州', '我想起那天夕阳下的奔跑 不是我逝去的青春，走马灯在我脑海里闪回，仿佛回到那个懵懂无知年代', '汉族', 0, '白羊座', 0, '127.0.0.1', 18808);
commit;
prompt 2 records loaded
prompt Loading QQFRID...
prompt Table is empty
prompt Loading WEIYUN...
insert into WEIYUN (qqnum, qqname, filepath, filenames, dateremix, filelayout)
values ('4685', '大大', 'G:\\1.要读的数据.txt', '1.要读的数据.txt', '2018-04-12 14:49:19', '文档');
insert into WEIYUN (qqnum, qqname, filepath, filenames, dateremix, filelayout)
values ('4685', '大大', 'G:\\v2-b7b7fd93e8944e7197ccfe412c960282_b.jpg', 'v2-b7b7fd93e8944e7197ccfe412c960282_b.jpg', '2018-04-12 14:49:05', '图片');
insert into WEIYUN (qqnum, qqname, filepath, filenames, dateremix, filelayout)
values ('4685', '大大', 'G:\\Log.txt', 'Log.txt', '2018-04-12 14:49:14', '文档');
commit;
prompt 3 records loaded
prompt Enabling triggers for GAME...
alter table GAME enable all triggers;
prompt Enabling triggers for HISTORY...
alter table HISTORY enable all triggers;
prompt Enabling triggers for QQ...
alter table QQ enable all triggers;
prompt Enabling triggers for QQFRID...
alter table QQFRID enable all triggers;
prompt Enabling triggers for WEIYUN...
alter table WEIYUN enable all triggers;
set feedback on
set define on
prompt Done.
