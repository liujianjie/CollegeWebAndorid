prompt PL/SQL Developer import file
prompt Created on 2019Äê6ÔÂ14ÈÕ by Administrator
set feedback off
set define off
prompt Creating ANDROID_QQ_DYNAMIC...
create table ANDROID_QQ_DYNAMIC
(
  dy_id       NUMBER(5) not null,
  qq_id       NUMBER(5),
  qq_zhanghao VARCHAR2(15),
  qq_name     VARCHAR2(20),
  qq_touxiang VARCHAR2(100),
  dy_date     VARCHAR2(30),
  dy_content  VARCHAR2(500),
  dy_photos   VARCHAR2(500)
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
alter table ANDROID_QQ_DYNAMIC
  add primary key (DY_ID)
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

prompt Creating ANDROID_QQ_HY...
create table ANDROID_QQ_HY
(
  hy_id         NUMBER(5) not null,
  myqq_id       NUMBER(5),
  myqq_zhanghao VARCHAR2(15),
  myqq_name     VARCHAR2(20),
  myqq_touxiang VARCHAR2(100),
  myqq_mark     VARCHAR2(100),
  myqq_statu    NUMBER(1),
  myqq_fengzu   NUMBER(1),
  hyqq_id       NUMBER(5),
  hyqq_zhanghao VARCHAR2(15),
  hyqq_name     VARCHAR2(20),
  hyqq_touxiang VARCHAR2(100),
  hyqq_mark     VARCHAR2(100),
  hyqq_statu    NUMBER(1),
  hyqq_fengzu   NUMBER(1),
  hy_statu      NUMBER(1)
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
alter table ANDROID_QQ_HY
  add primary key (HY_ID)
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

prompt Creating ANDROID_QQ_MESSAGE...
create table ANDROID_QQ_MESSAGE
(
  m_id        NUMBER(6) not null,
  qq_id       NUMBER(5),
  qq_zhanghao VARCHAR2(15),
  qq_name     VARCHAR2(20),
  qq_touxiang VARCHAR2(100),
  m_message   VARCHAR2(200),
  m_date      DATE,
  m_jsid      NUMBER(5),
  m_zhanghao  VARCHAR2(15),
  m_name      VARCHAR2(20),
  m_touxiang  VARCHAR2(100),
  m_statu     NUMBER(1)
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
alter table ANDROID_QQ_MESSAGE
  add primary key (M_ID)
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

prompt Creating ANDROID_QQ_USER...
create table ANDROID_QQ_USER
(
  qq_id       NUMBER(5) not null,
  qq_zhanghao VARCHAR2(15) not null,
  qq_mima     VARCHAR2(11) not null,
  qq_touxiang VARCHAR2(100),
  qq_name     VARCHAR2(20),
  qq_mark     VARCHAR2(100),
  qq_sex      VARCHAR2(2),
  qq_address  VARCHAR2(80),
  qq_phone    VARCHAR2(11),
  qq_statu    NUMBER(1)
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
alter table ANDROID_QQ_USER
  add primary key (QQ_ID)
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

prompt Disabling triggers for ANDROID_QQ_DYNAMIC...
alter table ANDROID_QQ_DYNAMIC disable all triggers;
prompt Disabling triggers for ANDROID_QQ_HY...
alter table ANDROID_QQ_HY disable all triggers;
prompt Disabling triggers for ANDROID_QQ_MESSAGE...
alter table ANDROID_QQ_MESSAGE disable all triggers;
prompt Disabling triggers for ANDROID_QQ_USER...
alter table ANDROID_QQ_USER disable all triggers;
prompt Deleting ANDROID_QQ_USER...
delete from ANDROID_QQ_USER;
commit;
prompt Deleting ANDROID_QQ_MESSAGE...
delete from ANDROID_QQ_MESSAGE;
commit;
prompt Deleting ANDROID_QQ_HY...
delete from ANDROID_QQ_HY;
commit;
prompt Deleting ANDROID_QQ_DYNAMIC...
delete from ANDROID_QQ_DYNAMIC;
commit;
prompt Loading ANDROID_QQ_DYNAMIC...
prompt Table is empty
prompt Loading ANDROID_QQ_HY...
prompt Table is empty
prompt Loading ANDROID_QQ_MESSAGE...
prompt Table is empty
prompt Loading ANDROID_QQ_USER...
prompt Table is empty
prompt Enabling triggers for ANDROID_QQ_DYNAMIC...
alter table ANDROID_QQ_DYNAMIC enable all triggers;
prompt Enabling triggers for ANDROID_QQ_HY...
alter table ANDROID_QQ_HY enable all triggers;
prompt Enabling triggers for ANDROID_QQ_MESSAGE...
alter table ANDROID_QQ_MESSAGE enable all triggers;
prompt Enabling triggers for ANDROID_QQ_USER...
alter table ANDROID_QQ_USER enable all triggers;
set feedback on
set define on
prompt Done.
