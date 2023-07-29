prompt PL/SQL Developer import file
prompt Created on 2019��6��8�� by Administrator
set feedback off
set define off
prompt Creating MOLD...
create table MOLD
(
  mold_id INTEGER not null,
  mold    VARCHAR2(50)
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
alter table MOLD
  add constraint PK_MOLD_MID primary key (MOLD_ID)
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

prompt Creating BOTTOM...
create table BOTTOM
(
  bottom_id INTEGER not null,
  bottom    VARCHAR2(20) not null,
  mold_id   INTEGER default 0
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
alter table BOTTOM
  add constraint PK_BOTTOM_ID primary key (BOTTOM_ID)
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
alter table BOTTOM
  add constraint FK_BOTTOM_MOLDID foreign key (MOLD_ID)
  references MOLD (MOLD_ID);

prompt Creating JRUSER...
create table JRUSER
(
  jruser_id INTEGER not null,
  uname     VARCHAR2(50),
  pwd       VARCHAR2(20),
  jr_img    VARCHAR2(100),
  jointime  VARCHAR2(100),
  birthday  VARCHAR2(100),
  moneys    FLOAT,
  phone     VARCHAR2(50)
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
alter table JRUSER
  add constraint PK_JRUSER_JID primary key (JRUSER_ID)
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

prompt Creating COMMENTS...
create table COMMENTS
(
  c_id      INTEGER not null,
  jruser_id INTEGER not null,
  g_id      INTEGER not null,
  c_comment VARCHAR2(1000),
  c_time    VARCHAR2(100)
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
alter table COMMENTS
  add constraint PK_COMMENT_CID primary key (C_ID)
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
alter table COMMENTS
  add constraint FK_COMMENT_JRUSER_ID foreign key (JRUSER_ID)
  references JRUSER (JRUSER_ID);

prompt Creating GOODS...
create table GOODS
(
  g_id      INTEGER not null,
  bottom_id INTEGER,
  g_name    VARCHAR2(500),
  g_dress   VARCHAR2(1000),
  g_dec     VARCHAR2(1000),
  g_img     VARCHAR2(50),
  g_price   FLOAT,
  g_scj     FLOAT,
  g_count   INTEGER,
  g_sale    INTEGER,
  g_statu   INTEGER,
  gwccount  INTEGER,
  g_descrip VARCHAR2(1000)
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
alter table GOODS
  add constraint PK_GOODS_GID primary key (G_ID)
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
alter table GOODS
  add constraint FK_GOODS_BOTTOM_ID foreign key (BOTTOM_ID)
  references BOTTOM (BOTTOM_ID);

prompt Creating ORDERS...
create table ORDERS
(
  orders_id INTEGER not null,
  jruser_id INTEGER,
  xfm       VARCHAR2(50),
  statu     INTEGER,
  gtime     VARCHAR2(100),
  g_id      INTEGER,
  gname     VARCHAR2(50),
  gdec      VARCHAR2(1000),
  gprice    FLOAT,
  gwccount  INTEGER,
  total     FLOAT,
  gimg      VARCHAR2(50)
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
alter table ORDERS
  add constraint PK_ORDERS_OID primary key (ORDERS_ID)
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
alter table ORDERS
  add constraint FK_ORDER_JRUSER_ID foreign key (JRUSER_ID)
  references JRUSER (JRUSER_ID);

prompt Disabling triggers for MOLD...
alter table MOLD disable all triggers;
prompt Disabling triggers for BOTTOM...
alter table BOTTOM disable all triggers;
prompt Disabling triggers for JRUSER...
alter table JRUSER disable all triggers;
prompt Disabling triggers for COMMENTS...
alter table COMMENTS disable all triggers;
prompt Disabling triggers for GOODS...
alter table GOODS disable all triggers;
prompt Disabling triggers for ORDERS...
alter table ORDERS disable all triggers;
prompt Deleting ORDERS...
delete from ORDERS;
commit;
prompt Deleting GOODS...
delete from GOODS;
commit;
prompt Deleting COMMENTS...
delete from COMMENTS;
commit;
prompt Deleting JRUSER...
delete from JRUSER;
commit;
prompt Deleting BOTTOM...
delete from BOTTOM;
commit;
prompt Deleting MOLD...
delete from MOLD;
commit;
prompt Loading MOLD...
insert into MOLD (mold_id, mold)
values (1, '��ʳ');
insert into MOLD (mold_id, mold)
values (2, '��Ӱ');
insert into MOLD (mold_id, mold)
values (3, 'KTV');
insert into MOLD (mold_id, mold)
values (4, '��������');
insert into MOLD (mold_id, mold)
values (5, '�������');
insert into MOLD (mold_id, mold)
values (6, '����');
insert into MOLD (mold_id, mold)
values (7, '����');
insert into MOLD (mold_id, mold)
values (8, '�ܱ���');
commit;
prompt 8 records loaded
prompt Loading BOTTOM...
insert into BOTTOM (bottom_id, bottom, mold_id)
values (1, '������', 1);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (2, '����', 1);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (3, '���³��', 1);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (4, '�պ�����', 1);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (5, '����', 1);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (17, '�ư�', 4);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (7, 'С�Կ��', 1);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (8, '������', 1);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (9, '���', 1);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (10, '����', 7);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (11, '�٤', 7);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (12, '�տ�����', 1);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (15, '��/��/����', 1);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (14, '�������', 1);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (16, '���ư�Ħ', 4);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (18, '����CS', 4);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (19, '��Ȫ', 4);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (20, '����/����', 4);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (21, 'д��', 5);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (22, '��ɴ��Ӱ', 5);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (23, '��ѵ�γ�', 5);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (24, '��Ƭ��ӡ', 5);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (25, '��װ', 6);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (26, 'Ůװ', 6);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (27, 'ʳƷ', 6);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (28, '����', 6);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (50, 'KTV', 3);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (51, '��Ӱ', 2);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (120, '�����Ʒ', 1);
commit;
prompt 29 records loaded
prompt Loading JRUSER...
insert into JRUSER (jruser_id, uname, pwd, jr_img, jointime, birthday, moneys, phone)
values (48, 'СС', '123456', 'jieruishu', '2018-4-13 19:58:53', '199711', 1000, '18160774016');
insert into JRUSER (jruser_id, uname, pwd, jr_img, jointime, birthday, moneys, phone)
values (106, '���', '123456', 'jieruishu', '2018-4-13 22:19:54', '199444', 1000, '13670262004');
insert into JRUSER (jruser_id, uname, pwd, jr_img, jointime, birthday, moneys, phone)
values (122, 'С��', '123456', 'jieruishu', '2018-4-14 12:21:11', '199666', 1000, '13670262004');
insert into JRUSER (jruser_id, uname, pwd, jr_img, jointime, birthday, moneys, phone)
values (123, 'С��', '123456', 'jieruishu', '2018-4-14 12:21:28', '199665', 1000, '18160774016');
commit;
prompt 4 records loaded
prompt Loading COMMENTS...
insert into COMMENTS (c_id, jruser_id, g_id, c_comment, c_time)
values (49, 48, 41, '�ó�', '2018-4-13 20:04:15');
insert into COMMENTS (c_id, jruser_id, g_id, c_comment, c_time)
values (124, 123, 121, '�óԣ����ﻷ��Ҳ����', '2018-4-14 12:23:24');
commit;
prompt 2 records loaded
prompt Loading GOODS...
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (41, 7, '���¼���', 'ͨ������԰���ƾ���·������������', '�绰��17310258824 Ӫҵʱ�䣺��һ������ 10:00-22:00', 'bd0768029aaec1b77d2a8089593a3dcb40995.jpg', 14, 20, 1, 7, 0, 1, '�Ʋ����ԣ���ֵ��ӵ��');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (74, 51, '������', '�γ�ӰԺ', '�绰��1541025824 Ӫҵʱ�䣺ÿ�� 10:00-24:00 �ŵ���� ֧��WIFI', 'dianying1.png', 60, 90, 1000, 0, 0, 1, '��ӭ����');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (75, 50, 'Mu Studio', '��خ�����Ž�خɽ���228�������Ƶ�A��', '�绰�� 020-34811333/34818231 Ӫҵʱ�䣺 ��һ������ 18:00-02:00', 'kt1.png', 90, 100, 1000, 0, 0, 1, '�ṩWiFi' || chr(13) || '' || chr(10) || '����ṩ500��ͣ��λ');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (76, 20, '����ʿ̨��', ' ��ƽ���������ϰ�����c��B1¥ ', '�绰�� 18301400775 Ӫҵʱ�䣺 ��һ������ 10:00-00:00', 'xxyl1.png', 80, 90, 1000, 0, 0, 1, '��ӭ');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (77, 20, '������������', '����������·23��һ������һ��', '�绰�� 13311320687 Ӫҵʱ�䣺 ��һ������ ȫ��', 'xxyl2.png', 10, 15, 1000, 0, 0, 1, '��ӭ');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (78, 19, '����԰��Ȫ�ȼپƵ�', '˳��������Ӫ����ׯ����Ӵ����غӱ���������԰��Ȫ�ȼٴ�', '�绰��010-52963270 Ӫҵʱ�䣺��һ������ 11:00-21:00', 'wenquan4.png', 120, 200, 1, 0, 0, 1, '��ӭ');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (79, 19, 'ԣ����Ȫ', '����������·40�ţ��վ���ҽԺ���ࣩ', '�绰�� 020-83333999/84600999 Ӫҵʱ�䣺 ��һ������ 10:30-03:00', 'wenquan3.png', 150, 200, 1, 0, 0, 1, '��ӭ');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (80, 18, '���ֵ�����CS���ֲ�', '��������ׯ����ׯˮ����ɳ����·740��Į��ׯ԰�Ա�����ϾƵ�', '�绰�� 020-34811333/34818231 Ӫҵʱ�䣺 ��һ������ 18:00-02:00', 'zrcs1.png', 150, 250, 1000, 0, 0, 1, '��ӭ');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (81, 18, '������������CS��չ��ѵ����', '��������ׯ����ׯˮ����ɳ����·740��Į��ׯ԰�Ա�����ϾƵ�', '�绰�� 020-83333999/84600999 Ӫҵʱ�䣺 ��һ������ 10:30-03:00', 'zrcs2.png', 140, 200, 1000, 0, 0, 1, '��ӭ');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (42, 9, '��ζ���', '��ƽ������·186��', '�绰��1541025824 Ӫҵʱ�䣺ÿ�� 10:00-24:00 �ŵ���� ֧��WIFI', '360��ͼ20180414113959652.jpg', 30, 40, 1, 0, 0, 1, '�ó���ζ�������԰�');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (43, 14, '��������', '�������ڿ���Ѷ����C��B1�㣨�Ѻ�ý����ã�', '�绰��010-82861665 Ӫҵʱ�䣺��һ������ 09:30-21:30 ����,���� 09:30-21:00', 'ky1.png', 40, 30, 1000, 0, 0, 1, '��ӭǰ������');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (44, 14, '���¡��ɽ��ȫ��', '��̨����ұ���·106��Ժ1���¹����Ƶ���', '�绰��010-56170109 Ӫҵʱ�䣺��һ������ 11:00-22:00', 'ky2.png', 40, 50, 1000, 0, 0, 1, '��ӭǰ������');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (45, 9, '�������ת�������', '��������������·��18�Ŵ����������㳡�������ָ��̳����¶�¥���ݳ��ڴ�', '�绰��010-52963270 Ӫҵʱ�䣺��һ������ 11:00-21:00 ��Ӫҵʱ�� 2018-02-15��2018-02-16 ȫ��', 'huoguo3.png', 40, 60, 1000, 0, 0, 1, '��ӭǰ������');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (52, 5, '�������ʽ���', '�¹����ͼҴ��83��', '�ŵ���� ֧��WIFI ����ṩ10��ͣ��λ', 'xican.png', 40, 80, 1000, 0, 0, 1, null);
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (53, 15, '��������', '��̨����̨��·��ׯ��·100�ţ����»����ʾ֣�', '�绰��010-59854809 Ӫҵʱ�䣺��һ������ ȫ��', '2.jpg', 10, 15, 1000, 4, 0, 1, '��ӭǰ������');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (54, 15, '��ĴָѼѪ��˿��', '����������������40�����㹺��㳡8�㣨�����пڣ�', '�绰��18611981143/13718027047 Ӫҵʱ�䣺��һ������ 10:30-20:00', 'QQ��ͼ20180413202549.png', 10, 16, 1000, 2, 0, 1, '��ӭ');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (55, 12, '������������������', '��̨����ׯ·71������ɽ�̳�3��', '�绰��010-87687607 Ӫҵʱ�䣺��һ������ 11:00-21:30', 'QQ��ͼ20180413202758.png', 60, 80, 1, 0, 0, 1, '��ӭ');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (56, 12, '�����������̿�����', '��������ҵ��21�ţ����žż���ݣ�', '�绰��010-52963270 Ӫҵʱ�䣺��һ������ 11:00-21:00', 'QQ��ͼ20180413203004.png', 20, 20, 1000, 0, 0, 1, '��ӭ');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (57, 8, '�κ��㺣����������', '���������������133�ž�̫�ٻ�B1¥�����������óǣ�', ' �绰��010-67646197Ӫҵʱ�䣺��һ������ ȫ��', 'zz1.png', 60, 80, 1000, 0, 0, 1, '��ӭ');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (58, 8, '���������ʻ���������� ', '��ͷ��plus365�������Ķ���', '�绰��010-81520503 Ӫҵʱ�䣺��һ������ 11:00-14:30 17:00-21:30 ��Ӫҵʱ�� 2018-02-15��2018-02-22 ȫ��', 'zz2.png', 80, 90, 1000, 0, 0, 1, '��ӭ');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (59, 7, '��צ��', '������Զ��·1�ű������ͽ�Դ��������B1����������', '�绰��010-81520503 Ӫҵʱ�䣺��һ������ 11:00-14:30 17:00-21:30 ��Ӫҵʱ�� 2018-02-15��2018-02-22 ȫ��', '9ce02f267164d0d56f52e7f3ea4806eb30030.jpg', 30, 40, 1000, 0, 0, 1, '��ӭ');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (60, 5, '�ͱ���', '�����������ѧ��·κ����Τ����С��2��¥����', '�绰��010-59452727 Ӫҵʱ�䣺��һ������ 10:00-21:30', 'xc1.png', 60, 70, 1000, 0, 0, 1, '��ӭ');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (61, 5, 'ŦԼ����ʽ����', '��̨��������԰������԰���ж�20��', '�绰��010-52963270 Ӫҵʱ�䣺��һ������ 11:00-21:00', 'xc2.png', 60, 61, 1000, 0, 0, 1, '��ӭ');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (62, 4, '���ñ', ' ���������������133�ž�̫�ٻ�B1¥�����������óǣ�', '�绰��010-59452727 Ӫҵʱ�䣺��һ������ 10:00-21:30', 'rh.png', 60, 61, 1000, 0, 0, 1, '��ӭ��');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (63, 4, '��̫���ձ�����', '����������·����2��徵����Ŵ�Ƶ�B��', '�绰��010-68226199 Ӫҵʱ�䣺��һ������ 10:00-14:00 17:00-21:00', 'rh2.png', 90, 98, 1000, 0, 0, 1, '��ӭ');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (64, 3, '�����Ѽ��', '�����������̳�8��', '�绰��010-52963270 Ӫҵʱ�䣺��һ������ 11:00-21:00', 'lc1.png', 80, 82, 1000, 0, 0, 1, '��ӭ');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (65, 3, '����С��', '��ʥ�н�12��Ժ���ٺ����﹫԰4��', '�绰��010-84240002/84240003 Ӫҵʱ�䣺��һ������ 10:00-22:00', 'lc2.png', 80, 86, 1000, 0, 0, 1, '��ӭ');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (66, 2, '�ɼǾ��Ǻ���', '��̨����ׯ��Ⱥ԰����6��¥ȹ��1-1', '�绰��010-67606608 Ӫҵʱ�䣺��һ������ 11:00-22:00', 'hx1.png', 80, 90, 1000, 0, 0, 1, '��ӭ��ӭ');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (67, 2, '�����Ϻ', ' �����������ѧ��·κ����Τ����С��2��¥����', ' �绰��010-67646197Ӫҵʱ�䣺��һ������ ȫ��', 'hx2.png', 60, 90, 1, 0, 0, 1, '��ӭ��ӭ');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (68, 1, '�������ӹ�', '���������������133�ž�̫�ٻ�B1¥�����������óǣ�', '�绰��010-67646197Ӫҵʱ�䣺��һ������ ȫ��', 'dobei5.png', 40, 60, 1000, 2, 0, 1, '���ӡ���');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (69, 1, '������', '������������·¹��԰���ﲩ����Է����', '�绰��010-58984555 Ӫҵʱ�䣺��һ������ ȫ��', 'dobei1.png', 50, 70, 1000, 0, 0, 1, '��ӭ');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (70, 1, '��������׽���ʯĥ�ϲ˹�', '����������Ӫ����һ����', '�绰��010-87691322 Ӫҵʱ�䣺��һ������ 10:00-03:00', 'dobei3.png', 60, 90, 1000, 0, 0, 1, '��ӭ');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (71, 1, '��������׽���ʯĥ�ϲ˹�', '����������Ӫ����һ����', '�绰��010-87691322 Ӫҵʱ�䣺��һ������ 10:00-03:00', 'dobei4.png', 40, 60, 1000, 0, 0, 1, '��ӭ');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (72, 1, 'ͬ������ζ����¥', '��ƽ������·8�ţ�����·����·���㴦��', '�绰��010-80114866 Ӫҵʱ�䣺��һ������ 10:00-21:00', 'dobei2.png', 40, 50, 1000, 0, 0, 1, '��ӭ');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (73, 1, '������', '����������·46�ţ�����¡����200�ף�', '�绰��010-69612187 Ӫҵʱ�䣺��һ������ 09:00-22:00', 'QQ��ͼ20180413204618.png', 30, 60, 1, 0, 0, 1, '��ӭ');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (82, 16, '������', '�绰�� 020-87533799/13560253968 Ӫҵʱ�䣺 ��һ������ 11:00-23:00', ' �����������·����һ��11���ײ�', 'wenquan2.png', 40, 120, 1000, 0, 0, 1, '��ӭ');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (83, 16, '��ʱ��ԡ', '��̨����԰·(��ʱ����2F��', '�绰�� 020-87533799/13560253968 Ӫҵʱ�䣺 ��һ������ 11:00-23:00', 'wenquan1.png', 80, 90, 1, 0, 0, 1, '��ӭ');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (84, 24, '���������', '����������������8����ʿ��A��B1��', '�绰��010-58613316/18600520996 Ӫҵʱ�䣺��һ������ 09:00-19:00', 'zpsy1.png', 20, 30, 1000, 0, 0, 1, '��ӭ');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (85, 24, 'PepaD����֤�������', '��̨������ʮ���ߣ��׾�óվ��D���ڶ��棬����¡���к���', '�绰��13120375858/13811779908 Ӫҵʱ�䣺��һ������ 09:30-19:30', 'zpsy2.png', 30, 40, 1000, 0, 0, 1, null);
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (86, 23, 'EFӢ�ڽ�������Ӣ����ѵ����', '������������·1������������A��4��', '�绰��400-112-3588 Ӫҵʱ�䣺��һ������ 10:00-22:00', 'QQ��ͼ20180413210320.png', 200, 300, 1000, 0, 0, 1, null);
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (87, 23, '����˼Ӣ�������ѵ���ģ����ó�Ӣ����', '�绰��400-176-9440/18401316224 Ӫҵʱ�䣺��һ������ 09:00-21:00', '������������·99�Ŵ��ù�Ԣ��¥30��3008�ң��������óǣ�', 'QQ��ͼ20180413210529.png', 400, 500, 1000, 0, 0, 1, '��ӭ');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (88, 10, '����������������', '��̨������·7�ź�ׯ�Ӷ����̩����ҽԺ������', '�绰��010-67646197Ӫҵʱ�䣺��һ������ ȫ��', 'meifa2.png', 60, 80, 1000, 0, 0, 1, null);
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (89, 11, '���٤����', '˳������ǰһ��60�Żʹڼ��վƵ�����һ��', '�绰��010-59452727 Ӫҵʱ�䣺��һ������ 10:00-21:30', 'yj2.png', 300, 400, 1000, 0, 0, 1, null);
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (90, 22, '��Ӱ�߶˶��ƻ�ɴ��Ӱ', '����������SOHO����13��¥1902��', '�绰��010-52963270 Ӫҵʱ�䣺��һ������ 11:00-21:00', 'gxxz3.png', 60, 80, 1000, 0, 0, 1, null);
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (91, 22, 'CD�Ӿ���ɴ��Ӱ������ ����', '�������������϶�·31��Ժ�����ʲ�����Ժ��3��¥A����˫������վB�ڳ���', '�绰��010-81520503 Ӫҵʱ�䣺��һ������ 11:00-14:30 17:00-21:30 ��Ӫҵʱ�� 2018-02-15��2018-02-22 ȫ', 'hssy2.png', 244, 300, 1000, 0, 0, 1, null);
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (92, 21, '���۸��Ը��˹�װд����Ӱ', '������֪��·̫��԰12��¥1008', ' �绰��010-59452727 Ӫҵʱ�䣺��һ������ 10:00-21:30', 'gxxz1.png', 80, 90, 1000, 0, 0, 1, null);
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (93, 21, '�˶ȿռ�д���', '������������·��۹���5��¥�ĵ�Ԫ1401', '���ʽ�� ����ˢ�� Ӫҵʱ�䣺 ��һ������ 09:00-19:00', 'xz2.png', 266, 300, 1000, 0, 0, 1, null);
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (94, 25, '������װ����', '����������·3�ž�԰ͼƬ��ҵ����49A����', '���ʽ�� ��ˢ�� Ӫҵʱ�䣺 ��һ������ 10:00-18:30', 'nz1.png', 300, 500, 1, 0, 0, 1, null);
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (95, 25, 'SENS˽�˶�����װ', '����·3�ž�԰A18��', '���ʽ�� ��ˢ�� Ӫҵʱ�䣺 ��һ������ 10:00-18:30', 'nanz2.png', 400, 500, 1000, 0, 0, 1, null);
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (96, 26, 'IMOOD�����������װ�������Ůװ������', '����������������8����ʿ��A��303��', '���ʽ�� ��ˢ�� Ӫҵʱ�䣺 ��һ������ 10:00-18:30', 'nz2.png', 400, 500, 1000, 0, 0, 1, null);
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (97, 28, '��ȹ��ʾ�������', '������Զ��·1�����ͽ�Դ��������4��4104', '���޼۸�', 'ny1.png', 150, 300, 1000, 0, 0, 1, null);
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (98, 28, '��ǧ��������', '��̨�����Ŷ�·1����Ʒ�ۿ�2��', '���ޱ��', 'ny2.png', 150, 300, 1, 0, 0, 1, null);
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (99, 27, '��Ʈ��ʳƷ', '��̨����԰�����������ۺ��г����׵ط��г����ż�Aʮһ��', '�绰��18600814118/13264423218 Ӫҵʱ�䣺��һ������ 09:00-21:00', 'sp2.png', 45, 60, 1000, 0, 0, 1, null);
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (100, 1, '�б�����ζ������Ӱ���꣩', '�����������·12�����а������C106�ţ�������ƥ�����ģ�', '�绰��020-82524218/82524268 Ӫҵʱ�䣺��һ������ 11:00-21:30 ��Ӫҵʱ�� 2018-02-12��2018-02-12 00:00-08:00', 'QQ��ͼ20180413212659.png', 52, 60, 1000, 0, 0, 1, null);
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (101, 1, '�����ӹ�', '���������·23��', '�绰��020-38298567 Ӫҵʱ�䣺��һ������ 10:30-22:00', 'QQ��ͼ20180413212800.png', 50, 60, 1000, 0, 0, 1, null);
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (102, 1, '����Ұ�����㷻�������꣩', '��������Ҵ����668������ʳ��4����̷�����վD����', '�绰��020-38880977 Ӫҵʱ�䣺��һ������ ���� 11:00-14:30 ���� 17:00-21:30', 'QQ��ͼ20180413212843.png', 60, 70, 1000, 0, 0, 1, null);
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (103, 1, '���Һ���ɰ���ࣨ����꣩', '����������·�����԰���ţ�ʢ�����ڳ���ɰ�������ڣ�', '�绰��13128665568 Ӫҵʱ�䣺17:30-�賿4:00', 'QQ��ͼ20180413212939.png', 50, 60, 1000, 1, 0, 1, null);
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (104, 20, '��ɭ�ư�', '������˻�·38������ʤ�Ƶ�ͣ�����ڣ���ƽ�ܵ���վ�ԣ�', '�绰��020-61301388 Ӫҵʱ�䣺��һ������ 20:30-03:00 ��Ӫҵʱ�� 2018-02-12��2018-02-25 ȫ��', 'QQ��ͼ20180413221557.png', 66, 90, 1000, 0, 0, 1, null);
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (105, 17, '�����־ư�', '��ַ���������ɽ�����433��', '�绰��13826210569', 'QQ��ͼ20180413221606.png', 68, 90, 1000, 0, 0, 1, null);
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (121, 120, '��ɭ�ֵ��ⷻ', '����о�����жξ��ﹺ������б����', '�绰��1541025824 Ӫҵʱ�䣺ÿ�� 10:00-24:00 �ŵ���� ֧��WIFI', 'td1.png', 40, 60, 1000, 1, 0, 1, '�ŵ���ܣ�' || chr(13) || '' || chr(10) || '��Ϊ�˰���ѡ����������У��������Ϻ����Ǽ��Ƶ�����Ŵ���������Ʒ��ĸ߼���Ʒʦ������ʮ����Ĺ������顣ϲ��һ���ˣ� ����ȥ���ĺ��ǣ� ����������������ס�� ��˵����������һ�����ڰ������Ʒ, �Ե�������,������������ٻ������������밮�˽�����һ���꣨2011��12��3�գ���ʱ�����˺�ɭ�ֵ��ⷻ������֥ʿ��Ľ˹���������ա��ݷ硢���͡������������ᵰ�����ʽ��̢������������ȶ��Ǻ�ɭ�ֵ��ⷻ����Ӫ��ɫ��Ʒ�������ž�Ӫ�����ķ���������������������Ӫ����ζ�ĵ���ȸ�ʽ��ƷΪ����Կ�ҵ�����������Ͽͻ���ϲ����֧�֣�Ϊ��л�˿͵��Ͽ�����ŵ���Ժ�ľ�Ӫ��·�Ͻ����ϴ��£���������ζ����������Ʒ');
commit;
prompt 60 records loaded
prompt Loading ORDERS...
insert into ORDERS (orders_id, jruser_id, xfm, statu, gtime, g_id, gname, gdec, gprice, gwccount, total, gimg)
values (10021, 48, '184228', 2, '2018-4-13 20:03:16', 41, '���¼���', '�绰��17310258824 Ӫҵʱ�䣺��һ������ 10:00-22:00', 14, 1, 14, 'bd0768029aaec1b77d2a8089593a3dcb40995.jpg');
insert into ORDERS (orders_id, jruser_id, xfm, statu, gtime, g_id, gname, gdec, gprice, gwccount, total, gimg)
values (10022, 48, '654857', 1, '2018-4-13 21:24:05', 68, '�������ӹ�', '�绰��010-67646197Ӫҵʱ�䣺��һ������ ȫ��', 40, 1, 40, 'dobei5.png');
insert into ORDERS (orders_id, jruser_id, xfm, statu, gtime, g_id, gname, gdec, gprice, gwccount, total, gimg)
values (10023, 48, '176353', 1, '2018-4-13 21:24:05', 54, '��ĴָѼѪ��˿��', '�绰��18611981143/13718027047 Ӫҵʱ�䣺��һ������ 10:30-20:00', 10, 1, 10, 'QQ��ͼ20180413202549.png');
insert into ORDERS (orders_id, jruser_id, xfm, statu, gtime, g_id, gname, gdec, gprice, gwccount, total, gimg)
values (10024, 48, '592292', 1, '2018-4-13 21:24:05', 53, '��������', '�绰��010-59854809 Ӫҵʱ�䣺��һ������ ȫ��', 10, 1, 10, '2.jpg');
insert into ORDERS (orders_id, jruser_id, xfm, statu, gtime, g_id, gname, gdec, gprice, gwccount, total, gimg)
values (10033, 123, '834733', 2, '2018-4-14 12:21:57', 121, '��ɭ�ֵ��ⷻ', '�绰��1541025824 Ӫҵʱ�䣺ÿ�� 10:00-24:00 �ŵ���� ֧��WIFI', 40, 1, 40, 'td1.png');
insert into ORDERS (orders_id, jruser_id, xfm, statu, gtime, g_id, gname, gdec, gprice, gwccount, total, gimg)
values (10034, 123, '374854', 1, '2018-4-14 12:22:37', 68, '�������ӹ�', '�绰��010-67646197Ӫҵʱ�䣺��һ������ ȫ��', 40, 1, 40, 'dobei5.png');
insert into ORDERS (orders_id, jruser_id, xfm, statu, gtime, g_id, gname, gdec, gprice, gwccount, total, gimg)
values (10035, 123, '433825', 1, '2018-4-14 12:22:37', 103, '���Һ���ɰ���ࣨ����꣩', '�绰��13128665568 Ӫҵʱ�䣺17:30-�賿4:00', 50, 1, 50, 'QQ��ͼ20180413212939.png');
commit;
prompt 7 records loaded
prompt Enabling triggers for MOLD...
alter table MOLD enable all triggers;
prompt Enabling triggers for BOTTOM...
alter table BOTTOM enable all triggers;
prompt Enabling triggers for JRUSER...
alter table JRUSER enable all triggers;
prompt Enabling triggers for COMMENTS...
alter table COMMENTS enable all triggers;
prompt Enabling triggers for GOODS...
alter table GOODS enable all triggers;
prompt Enabling triggers for ORDERS...
alter table ORDERS enable all triggers;
set feedback on
set define on
prompt Done.
