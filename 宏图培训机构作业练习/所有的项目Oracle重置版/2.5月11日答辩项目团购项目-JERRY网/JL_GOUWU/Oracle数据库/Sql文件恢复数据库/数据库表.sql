prompt PL/SQL Developer import file
prompt Created on 2019年6月8日 by Administrator
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
values (1, '美食');
insert into MOLD (mold_id, mold)
values (2, '电影');
insert into MOLD (mold_id, mold)
values (3, 'KTV');
insert into MOLD (mold_id, mold)
values (4, '休闲娱乐');
insert into MOLD (mold_id, mold)
values (5, '生活服务');
insert into MOLD (mold_id, mold)
values (6, '购物');
insert into MOLD (mold_id, mold)
values (7, '丽人');
insert into MOLD (mold_id, mold)
values (8, '周边游');
commit;
prompt 8 records loaded
prompt Loading BOTTOM...
insert into BOTTOM (bottom_id, bottom, mold_id)
values (1, '东北菜', 1);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (2, '海鲜', 1);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (3, '津菜鲁菜', 1);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (4, '日韩料理', 1);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (5, '西餐', 1);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (17, '酒吧', 4);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (7, '小吃快餐', 1);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (8, '自助餐', 1);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (9, '火锅', 1);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (10, '美发', 7);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (11, '瑜伽', 7);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (12, '烧烤烤肉', 1);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (15, '汤/粥/炖菜', 1);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (14, '香锅烤鱼', 1);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (16, '足疗按摩', 4);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (18, '真人CS', 4);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (19, '温泉', 4);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (20, '网吧/桌球', 4);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (21, '写真', 5);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (22, '婚纱摄影', 5);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (23, '培训课程', 5);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (24, '照片冲印', 5);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (25, '男装', 6);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (26, '女装', 6);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (27, '食品', 6);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (28, '内衣', 6);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (50, 'KTV', 3);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (51, '电影', 2);
insert into BOTTOM (bottom_id, bottom, mold_id)
values (120, '甜点饮品', 1);
commit;
prompt 29 records loaded
prompt Loading JRUSER...
insert into JRUSER (jruser_id, uname, pwd, jr_img, jointime, birthday, moneys, phone)
values (48, '小小', '123456', 'jieruishu', '2018-4-13 19:58:53', '199711', 1000, '18160774016');
insert into JRUSER (jruser_id, uname, pwd, jr_img, jointime, birthday, moneys, phone)
values (106, '大大', '123456', 'jieruishu', '2018-4-13 22:19:54', '199444', 1000, '13670262004');
insert into JRUSER (jruser_id, uname, pwd, jr_img, jointime, birthday, moneys, phone)
values (122, '小瑞', '123456', 'jieruishu', '2018-4-14 12:21:11', '199666', 1000, '13670262004');
insert into JRUSER (jruser_id, uname, pwd, jr_img, jointime, birthday, moneys, phone)
values (123, '小杰', '123456', 'jieruishu', '2018-4-14 12:21:28', '199665', 1000, '18160774016');
commit;
prompt 4 records loaded
prompt Loading COMMENTS...
insert into COMMENTS (c_id, jruser_id, g_id, c_comment, c_time)
values (49, 48, 41, '好吃', '2018-4-13 20:04:15');
insert into COMMENTS (c_id, jruser_id, g_id, c_comment, c_time)
values (124, 123, 121, '好吃，店里环境也不错', '2018-4-14 12:23:24');
commit;
prompt 2 records loaded
prompt Loading GOODS...
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (41, 7, '正新鸡排', '通州区梨园镇云景东路张亮麻辣烫旁', '电话：17310258824 营业时间：周一至周日 10:00-22:00', 'bd0768029aaec1b77d2a8089593a3dcb40995.jpg', 14, 20, 1, 7, 0, 1, '黄渤代言，你值得拥有');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (74, 51, '疯狂动物城', '嘉城影院', '电话：1541025824 营业时间：每天 10:00-24:00 门店服务： 支持WIFI', 'dianying1.png', 60, 90, 1000, 0, 0, 1, '欢迎购买');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (75, 50, 'Mu Studio', '番禺区市桥街禺山大道228号银座酒店A座', '电话： 020-34811333/34818231 营业时间： 周一至周日 18:00-02:00', 'kt1.png', 90, 100, 1000, 0, 0, 1, '提供WiFi' || chr(13) || '' || chr(10) || '免费提供500个停车位');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (76, 20, '金绅士台球', ' 昌平区西三旗上奥世纪c座B1楼 ', '电话： 18301400775 营业时间： 周一至周日 10:00-00:00', 'xxyl1.png', 80, 90, 1000, 0, 0, 1, '欢迎');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (77, 20, '金龙祥宇网咖', '东城区鼎新路23号一幢地下一层', '电话： 13311320687 营业时间： 周一至周日 全天', 'xxyl2.png', 10, 15, 1000, 0, 0, 1, '欢迎');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (78, 19, '春晖园温泉度假酒店', '顺义区高丽营镇于庄（孙河大桥沿河北岸）春晖园温泉度假村', '电话：010-52963270 营业时间：周一至周日 11:00-21:00', 'wenquan4.png', 120, 200, 1, 0, 0, 1, '欢迎');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (79, 19, '裕龙温泉', '海淀区阜成路40号（空军总医院西侧）', '电话： 020-83333999/84600999 营业时间： 周一至周日 10:30-03:00', 'wenquan3.png', 150, 200, 1, 0, 0, 1, '欢迎');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (80, 18, '亲兄弟真人CS俱乐部', '海淀区上庄镇上庄水库南沙河西路740号漠北庄园旁碧清湖畔酒店', '电话： 020-34811333/34818231 营业时间： 周一至周日 18:00-02:00', 'zrcs1.png', 150, 250, 1000, 0, 0, 1, '欢迎');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (81, 18, '反恐联盟真人CS拓展特训基地', '海淀区上庄镇上庄水库南沙河西路740号漠北庄园旁碧清湖畔酒店', '电话： 020-83333999/84600999 营业时间： 周一至周日 10:30-03:00', 'zrcs2.png', 140, 200, 1000, 0, 0, 1, '欢迎');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (42, 9, '老味火锅', '昌平区立汤路186号', '电话：1541025824 营业时间：每天 10:00-24:00 门店服务： 支持WIFI', '360截图20180414113959652.jpg', 30, 40, 1, 0, 0, 1, '好吃美味快来尝试吧');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (43, 14, '麻里麻里', '海淀区融科资讯中心C座B1层（搜狐媒体大厦）', '电话：010-82861665 营业时间：周一至周五 09:30-21:30 周六,周日 09:30-21:00', 'ky1.png', 40, 30, 1000, 0, 0, 1, '欢迎前来消费');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (44, 14, '渝久隆巫山烤全鱼', '丰台区马家堡东路106号院1号月桂树酒店后侧', '电话：010-56170109 营业时间：周一至周日 11:00-22:00', 'ky2.png', 40, 50, 1000, 0, 0, 1, '欢迎前来消费');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (45, 9, '丁丁洋回转自助火锅', '海淀区北三环西路甲18号大钟寺中坤广场东区家乐福商场地下二楼电梯出口处', '电话：010-52963270 营业时间：周一至周日 11:00-21:00 非营业时段 2018-02-15至2018-02-16 全天', 'huoguo3.png', 40, 60, 1000, 0, 0, 1, '欢迎前来消费');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (52, 5, '德意基西式快餐', '章贡区客家大道83号', '门店服务： 支持WIFI 免费提供10个停车位', 'xican.png', 40, 80, 1000, 0, 0, 1, null);
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (53, 15, '银村街粥店', '丰台区丰台南路韩庄子路100号（近新华街邮局）', '电话：010-59854809 营业时间：周一至周日 全天', '2.jpg', 10, 15, 1000, 4, 0, 1, '欢迎前来购买');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (54, 15, '大拇指鸭血粉丝汤', '东城区崇文门外大街40号搜秀购物广场8层（近羊市口）', '电话：18611981143/13718027047 营业时间：周一至周日 10:30-20:00', 'QQ截图20180413202549.png', 10, 16, 1000, 2, 0, 1, '欢迎');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (55, 12, '金语轩烤肉火锅自助餐', '丰台区宋庄路71号扑满山商场3层', '电话：010-87687607 营业时间：周一至周日 11:00-21:30', 'QQ截图20180413202758.png', 60, 80, 1, 0, 0, 1, '欢迎');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (56, 12, '汉丽轩自助涮烤超市', '怀柔区商业街21号（近九九佳面馆）', '电话：010-52963270 营业时间：周一至周日 11:00-21:00', 'QQ截图20180413203004.png', 20, 20, 1000, 0, 0, 1, '欢迎');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (57, 8, '鑫海汇海鲜自助烤肉', '西城区西单北大街133号君太百货B1楼（近西单大悦城）', ' 电话：010-67646197营业时间：周一至周日 全天', 'zz1.png', 60, 80, 1000, 0, 0, 1, '欢迎');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (58, 8, '汉丽轩海鲜火锅烤肉自助 ', '门头沟plus365购物中心二层', '电话：010-81520503 营业时间：周一至周日 11:00-14:30 17:00-21:30 非营业时段 2018-02-15至2018-02-22 全天', 'zz2.png', 80, 90, 1000, 0, 0, 1, '欢迎');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (59, 7, '八爪鱼', '海淀区远大路1号北京世纪金源购物中心B1卜蜂莲花区', '电话：010-81520503 营业时间：周一至周日 11:00-14:30 17:00-21:30 非营业时段 2018-02-15至2018-02-22 全天', '9ce02f267164d0d56f52e7f3ea4806eb30030.jpg', 30, 40, 1000, 0, 0, 1, '欢迎');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (60, 5, '巴贝拉', '海淀区民族大学西路魏公村韦伯豪小区2号楼底商', '电话：010-59452727 营业时间：周一至周日 10:00-21:30', 'xc1.png', 60, 70, 1000, 0, 0, 1, '欢迎');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (61, 5, '纽约客美式餐厅', '丰台区怡海花园北门绿园超市东20米', '电话：010-52963270 营业时间：周一至周日 11:00-21:00', 'xc2.png', 60, 61, 1000, 0, 0, 1, '欢迎');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (62, 4, '金草帽', ' 西城区西单北大街133号君太百货B1楼（近西单大悦城）', '电话：010-59452727 营业时间：周一至周日 10:00-21:30', 'rh.png', 60, 61, 1000, 0, 0, 1, '欢迎啊');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (63, 4, '清太郎日本料理', '海淀区万寿路西街2号寰岛博雅大酒店B层', '电话：010-68226199 营业时间：周一至周日 10:00-14:00 17:00-21:00', 'rh2.png', 90, 98, 1000, 0, 0, 1, '欢迎');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (64, 3, '金百万烤鸭店', '西城区明珠商场8层', '电话：010-52963270 营业时间：周一至周日 11:00-21:00', 'lc1.png', 80, 82, 1000, 0, 0, 1, '欢迎');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (65, 3, '天意小馆', '七圣中街12号院爱琴海购物公园4层', '电话：010-84240002/84240003 营业时间：周一至周日 10:00-22:00', 'lc2.png', 80, 86, 1000, 0, 0, 1, '欢迎');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (66, 2, '成记京城海鲜', '丰台区方庄芳群园四区6号楼裙房1-1', '电话：010-67606608 营业时间：周一至周日 11:00-22:00', 'hx1.png', 80, 90, 1000, 0, 0, 1, '欢迎欢迎');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (67, 2, '阿田大虾', ' 海淀区民族大学西路魏公村韦伯豪小区2号楼底商', ' 电话：010-67646197营业时间：周一至周日 全天', 'hx2.png', 60, 90, 1, 0, 0, 1, '欢迎欢迎');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (68, 1, '东北饺子馆', '西城区西单北大街133号君太百货B1楼（近西单大悦城）', '电话：010-67646197营业时间：周一至周日 全天', 'dobei5.png', 40, 60, 1000, 2, 0, 1, '饺子。。');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (69, 1, '鑫掌勺', '大兴区博兴七路鹿海园四里博客雅苑底商', '电话：010-58984555 营业时间：周一至周日 全天', 'dobei1.png', 50, 70, 1000, 0, 0, 1, '欢迎');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (70, 1, '嘉宴金手勺酱骨石磨老菜馆', '朝阳区吕家营餐饮一条街', '电话：010-87691322 营业时间：周一至周日 10:00-03:00', 'dobei3.png', 60, 90, 1000, 0, 0, 1, '欢迎');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (71, 1, '嘉宴金手勺酱骨石磨老菜馆', '朝阳区吕家营餐饮一条街', '电话：010-87691322 营业时间：周一至周日 10:00-03:00', 'dobei4.png', 40, 60, 1000, 0, 0, 1, '欢迎');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (72, 1, '同得利风味饺子楼', '昌平区创兴路8号（振兴路创兴路交汇处）', '电话：010-80114866 营业时间：周一至周日 10:00-21:00', 'dobei2.png', 40, 50, 1000, 0, 0, 1, '欢迎');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (73, 1, '金手勺', '怀柔区开放路46号（京客隆往北200米）', '电话：010-69612187 营业时间：周一至周日 09:00-22:00', 'QQ截图20180413204618.png', 30, 60, 1, 0, 0, 1, '欢迎');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (82, 16, '喻足轩', '电话： 020-87533799/13560253968 营业时间： 周一至周日 11:00-23:00', ' 天河区体育西路六运一街11号首层', 'wenquan2.png', 40, 120, 1000, 0, 0, 1, '欢迎');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (83, 16, '金时足浴', '丰台区望园路(金时大厦2F）', '电话： 020-87533799/13560253968 营业时间： 周一至周日 11:00-23:00', 'wenquan1.png', 80, 90, 1, 0, 0, 1, '欢迎');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (84, 24, '麦子照相馆', '朝阳区广渠门外大街8号优士阁A座B1层', '电话：010-58613316/18600520996 营业时间：周一至周日 09:00-19:00', 'zpsy1.png', 20, 30, 1000, 0, 0, 1, '欢迎');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (85, 24, 'PepaD澎湃证件照相馆', '丰台区地铁十号线（首经贸站）D出口对面，京客隆超市后面', '电话：13120375858/13811779908 营业时间：周一至周日 09:30-19:30', 'zpsy2.png', 30, 40, 1000, 0, 0, 1, null);
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (86, 23, 'EF英孚教育成人英语培训中心', '朝阳区西大望路1号温特莱中心A座4层', '电话：400-112-3588 营业时间：周一至周日 10:00-22:00', 'QQ截图20180413210320.png', 200, 300, 1000, 0, 0, 1, null);
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (87, 23, '博恩思英语口语培训中心（大悦城英语口语）', '电话：400-176-9440/18401316224 营业时间：周一至周日 09:00-21:00', '朝阳区朝阳北路99号大悦公寓南楼30层3008室（朝阳大悦城）', 'QQ截图20180413210529.png', 400, 500, 1000, 0, 0, 1, '欢迎');
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (88, 10, '聚美国际美容美发', '丰台区富丰路7号韩庄子二里国泰动物医院南五米', '电话：010-67646197营业时间：周一至周日 全天', 'meifa2.png', 60, 80, 1000, 0, 0, 1, null);
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (89, 11, '氧瑜伽会所', '顺义区府前一街60号皇冠假日酒店西区一层', '电话：010-59452727 营业时间：周一至周日 10:00-21:30', 'yj2.png', 300, 400, 1000, 0, 0, 1, null);
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (90, 22, '简影高端定制婚纱摄影', '朝阳区建外SOHO西区13号楼1902号', '电话：010-52963270 营业时间：周一至周日 11:00-21:00', 'gxxz3.png', 60, 80, 1000, 0, 0, 1, null);
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (91, 22, 'CD视觉婚纱摄影·轻奢 定制', '朝阳区百子湾南二路31号院北汽资产大厦院内3号楼A座（双井地铁站B口出）', '电话：010-81520503 营业时间：周一至周日 11:00-14:30 17:00-21:30 非营业时段 2018-02-15至2018-02-22 全', 'hssy2.png', 244, 300, 1000, 0, 0, 1, null);
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (92, 21, '闺蜜个性个人古装写真摄影', '海淀区知春路太月园12号楼1008', ' 电话：010-59452727 营业时间：周一至周日 10:00-21:30', 'gxxz1.png', 80, 90, 1000, 0, 0, 1, null);
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (93, 21, '八度空间写真馆', '朝阳区西大望路金港国际5号楼四单元1401', '付款方式： 不可刷卡 营业时间： 周一至周日 09:00-19:00', 'xz2.png', 266, 300, 1000, 0, 0, 1, null);
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (94, 25, '先生男装定制', '朝阳区广渠路3号竞园图片产业基地49A二层', '付款方式： 可刷卡 营业时间： 周一至周日 10:00-18:30', 'nz1.png', 300, 500, 1, 0, 0, 1, null);
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (95, 25, 'SENS私人定制男装', '广渠路3号竞园A18号', '付款方式： 可刷卡 营业时间： 周一至周日 10:00-18:30', 'nanz2.png', 400, 500, 1000, 0, 0, 1, null);
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (96, 26, 'IMOOD妈咪礼服妈妈装中年婚宴女装量身定制', '朝阳区广渠门外大街8号优士阁A座303室', '付款方式： 可刷卡 营业时间： 周一至周日 10:00-18:30', 'nz2.png', 400, 500, 1000, 0, 0, 1, null);
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (97, 28, '茜比国际精塑内衣', '海淀区远大路1号世纪金源购物中心4层4104', '暂无价格', 'ny1.png', 150, 300, 1000, 0, 0, 1, null);
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (98, 28, '大千内衣世界', '丰台区草桥东路1号上品折扣2层', '暂无标价', 'ny2.png', 150, 300, 1, 0, 0, 1, null);
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (99, 27, '香飘来食品', '丰台区嘉园三里对面嘉祥综合市场北甲地分市场东门甲A十一号', '电话：18600814118/13264423218 营业时间：周一至周日 09:00-21:00', 'sp2.png', 45, 60, 1000, 0, 0, 1, null);
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (100, 1, '尚北八旗味道（天河奥体店）', '天河区奥体南路12号优托邦购物中心C106号（近奥林匹克中心）', '电话：020-82524218/82524268 营业时间：周一至周日 11:00-21:30 非营业时段 2018-02-12至2018-02-12 00:00-08:00', 'QQ截图20180413212659.png', 52, 60, 1000, 0, 0, 1, null);
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (101, 1, '许哥饺子馆', '天河区陶育路23号', '电话：020-38298567 营业时间：周一至周日 10:30-22:00', 'QQ截图20180413212800.png', 50, 60, 1000, 0, 0, 1, null);
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (102, 1, '老刘野生大鱼坊（赛马场店）', '天河区黄埔大道西668号赛马场食街4档（谭村地铁站D出口', '电话：020-38880977 营业时间：周一至周日 午市 11:00-14:30 晚市 17:00-21:30', 'QQ截图20180413212843.png', 60, 70, 1000, 0, 0, 1, null);
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (103, 1, '潮家海鲜砂锅粥（海珠店）', '海珠区南洲路罗马家园北门（盛景正宗潮州砂锅粥店隔壁）', '电话：13128665568 营业时间：17:30-凌晨4:00', 'QQ截图20180413212939.png', 50, 60, 1000, 1, 0, 1, null);
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (104, 20, '南森酒吧', '天河区兴华路38号南洋长胜酒店停车场内（天平架地铁站旁）', '电话：020-61301388 营业时间：周一至周日 20:30-03:00 非营业时段 2018-02-12至2018-02-25 全天', 'QQ截图20180413221557.png', 66, 90, 1000, 0, 0, 1, null);
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (105, 17, '华尔街酒吧', '地址：天河区中山大道中433号', '电话：13826210569', 'QQ截图20180413221606.png', 68, 90, 1000, 0, 0, 1, null);
insert into GOODS (g_id, bottom_id, g_name, g_dress, g_dec, g_img, g_price, g_scj, g_count, g_sale, g_statu, gwccount, g_descrip)
values (121, 120, '黑森林蛋糕坊', '瑞金市京里街中段京里购物中心斜对面', '电话：1541025824 营业时间：每天 10:00-24:00 门店服务： 支持WIFI', 'td1.png', 40, 60, 1000, 1, 0, 1, '门店介绍：' || chr(13) || '' || chr(10) || '他为了爱情选择了这个城市，他曾是上海五星级酒店和厦门大型连锁甜品店的高级甜品师，有了十几年的工作经验。喜欢一个人， 跟他去天涯海角， 而不仅仅是让他记住， 传说提拉米苏是一款属于爱情的甜品, 吃到它的人,会听到爱神的召唤。所以他在与爱人结婚纪念一周年（2011年12月3日）的时候创立了黑森林蛋糕坊。法国芝士、慕斯、提拉米苏、戚风、重油、布丁、布朗尼蛋糕和葡式蛋挞、意大利披萨等都是黑森林蛋糕坊的主营特色产品。他诚信经营，用心服务，以制作卫生、健康、营养美味的蛋糕等各式甜品为理念。自开业以来深受新老客户的喜爱与支持，为感谢顾客的认可他承诺在以后的经营道路上将不断创新，制作更美味、健康的甜品');
commit;
prompt 60 records loaded
prompt Loading ORDERS...
insert into ORDERS (orders_id, jruser_id, xfm, statu, gtime, g_id, gname, gdec, gprice, gwccount, total, gimg)
values (10021, 48, '184228', 2, '2018-4-13 20:03:16', 41, '正新鸡排', '电话：17310258824 营业时间：周一至周日 10:00-22:00', 14, 1, 14, 'bd0768029aaec1b77d2a8089593a3dcb40995.jpg');
insert into ORDERS (orders_id, jruser_id, xfm, statu, gtime, g_id, gname, gdec, gprice, gwccount, total, gimg)
values (10022, 48, '654857', 1, '2018-4-13 21:24:05', 68, '东北饺子馆', '电话：010-67646197营业时间：周一至周日 全天', 40, 1, 40, 'dobei5.png');
insert into ORDERS (orders_id, jruser_id, xfm, statu, gtime, g_id, gname, gdec, gprice, gwccount, total, gimg)
values (10023, 48, '176353', 1, '2018-4-13 21:24:05', 54, '大拇指鸭血粉丝汤', '电话：18611981143/13718027047 营业时间：周一至周日 10:30-20:00', 10, 1, 10, 'QQ截图20180413202549.png');
insert into ORDERS (orders_id, jruser_id, xfm, statu, gtime, g_id, gname, gdec, gprice, gwccount, total, gimg)
values (10024, 48, '592292', 1, '2018-4-13 21:24:05', 53, '银村街粥店', '电话：010-59854809 营业时间：周一至周日 全天', 10, 1, 10, '2.jpg');
insert into ORDERS (orders_id, jruser_id, xfm, statu, gtime, g_id, gname, gdec, gprice, gwccount, total, gimg)
values (10033, 123, '834733', 2, '2018-4-14 12:21:57', 121, '黑森林蛋糕坊', '电话：1541025824 营业时间：每天 10:00-24:00 门店服务： 支持WIFI', 40, 1, 40, 'td1.png');
insert into ORDERS (orders_id, jruser_id, xfm, statu, gtime, g_id, gname, gdec, gprice, gwccount, total, gimg)
values (10034, 123, '374854', 1, '2018-4-14 12:22:37', 68, '东北饺子馆', '电话：010-67646197营业时间：周一至周日 全天', 40, 1, 40, 'dobei5.png');
insert into ORDERS (orders_id, jruser_id, xfm, statu, gtime, g_id, gname, gdec, gprice, gwccount, total, gimg)
values (10035, 123, '433825', 1, '2018-4-14 12:22:37', 103, '潮家海鲜砂锅粥（海珠店）', '电话：13128665568 营业时间：17:30-凌晨4:00', 50, 1, 50, 'QQ截图20180413212939.png');
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
