# MySQL-Front 5.0  (Build 1.0)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;


# Host: localhost    Database: db_oa
# ------------------------------------------------------
# Server version 5.0.67-community-nt

#
# Table structure for table address
#

DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `ID` int(10) unsigned NOT NULL auto_increment,
  `username` varchar(50) NOT NULL default '',
  `name` varchar(50) NOT NULL default '',
  `sex` varchar(10) default NULL,
  `mobile` varchar(20) default NULL,
  `email` varchar(50) default NULL,
  `qq` varchar(20) default NULL,
  `company` varchar(100) default NULL,
  `address` varchar(100) default NULL,
  `postcode` varchar(10) default NULL,
  PRIMARY KEY  (`ID`),
  UNIQUE KEY `ID` (`ID`),
  KEY `ID_2` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=gb2312;
INSERT INTO `address` VALUES (8,'admin','ţ��','��','12345678911','123@126.com','123456','������˰��','�����в�ƽ��','010000');
INSERT INTO `address` VALUES (9,'admin','��ϼ','Ů','12345678911','123@126.com','123456','������˰��','�����в�ƽ��','010000');
INSERT INTO `address` VALUES (10,'admin','���','��','12345678911','123@126.com','123456','������˰��','�����в�ƽ��','010000');
INSERT INTO `address` VALUES (11,'admin','����','��','12345678911','123@126.com','123456','������˰��','�����в�ƽ��','010000');
INSERT INTO `address` VALUES (12,'admin','����','Ů','12345678911','123@126.com','123456','������˰��','�����в�ƽ��','010000');
INSERT INTO `address` VALUES (14,'admin','����','��','13423231212','ege@yahoo.com.cn','32423323','�й�����','�����к�����XXXX','100000');

#
# Table structure for table meeting
#

DROP TABLE IF EXISTS `meeting`;
CREATE TABLE `meeting` (
  `ID` int(10) unsigned NOT NULL auto_increment,
  `sender` varchar(50) NOT NULL default '',
  `starttime` varchar(20) default NULL,
  `endtime` varchar(20) default NULL,
  `address` varchar(100) default NULL,
  `title` varchar(100) default NULL,
  `content` text,
  PRIMARY KEY  (`ID`),
  UNIQUE KEY `ID` (`ID`),
  KEY `ID_2` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=gb2312;
INSERT INTO `meeting` VALUES (1,'admin','2009-10-21','2009-10-22','��˾T�Ͱ칫��','��ǿԱ���칫Ч�ʣ�','��ǿԱ���칫Ч�ʣ���ǿԱ���칫Ч�ʣ���ǿԱ���칫Ч�ʣ���ǿԱ���칫Ч�ʣ�');

#
# Table structure for table notice
#

DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `ID` int(10) unsigned NOT NULL auto_increment,
  `sender` varchar(50) NOT NULL default '',
  `title` varchar(100) default NULL,
  `content` text,
  `sendtime` varchar(20) default NULL,
  PRIMARY KEY  (`ID`),
  UNIQUE KEY `ID` (`ID`),
  KEY `ID_2` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=gb2312;
INSERT INTO `notice` VALUES (1,'admin','����������������','����������������','2009-12-20 20:06:39');
INSERT INTO `notice` VALUES (2,'admin','�������������ж�����ע��ɱ����','�������������ж�����ע��ɱ����','2009-12-20 20:06:56');
INSERT INTO `notice` VALUES (3,'admin','������ż�֪ͨ��','������ż�֪ͨ��','2009-12-20 20:07:22');
INSERT INTO `notice` VALUES (4,'sanqing','sanqing������','sanqing������sanqing������sanqing������','2010-02-01 16:40:35');

#
# Table structure for table schedule
#

DROP TABLE IF EXISTS `schedule`;
CREATE TABLE `schedule` (
  `ID` int(10) unsigned NOT NULL auto_increment,
  `username` varchar(50) NOT NULL default '',
  `year` int(4) default NULL,
  `month` int(2) default NULL,
  `day` int(2) default NULL,
  `plan` text,
  PRIMARY KEY  (`ID`),
  UNIQUE KEY `ID` (`ID`),
  KEY `ID_2` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=gb2312;
INSERT INTO `schedule` VALUES (1,'admin',2009,10,3,'���');
INSERT INTO `schedule` VALUES (3,'admin',2009,10,5,'��Ŀ���������');
INSERT INTO `schedule` VALUES (4,'admin',2009,10,6,'����Ŀ����̸��Ŀ��');
INSERT INTO `schedule` VALUES (5,'admin',2009,10,7,'�Ϳͻ�̸��Ŀ����');
INSERT INTO `schedule` VALUES (6,'admin',2009,10,8,'��Ŀ���ܷ�����');
INSERT INTO `schedule` VALUES (7,'admin',2010,1,31,'���Ʊ��������');

#
# Table structure for table sms
#

DROP TABLE IF EXISTS `sms`;
CREATE TABLE `sms` (
  `ID` int(10) unsigned NOT NULL auto_increment,
  `username` varchar(50) NOT NULL default '',
  `sender` varchar(50) NOT NULL default '',
  `message` text,
  `sendtime` varchar(20) default NULL,
  `isRead` varchar(1) default '0',
  PRIMARY KEY  (`ID`),
  UNIQUE KEY `ID` (`ID`),
  KEY `ID_2` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=gb2312;
INSERT INTO `sms` VALUES (6,'admin','sanqing','���յ����𣿣�','2010-02-01 16:41:18','1');
INSERT INTO `sms` VALUES (7,'sanqing','admin','�յ��ˣ������Ʊ���𣿣�','2010-02-01 16:41:51','1');

#
# Table structure for table user
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `ID` int(10) unsigned NOT NULL auto_increment,
  `username` varchar(50) default NULL,
  `password` varchar(50) default NULL,
  `email` varchar(50) default NULL,
  PRIMARY KEY  (`ID`),
  UNIQUE KEY `ID` (`ID`),
  KEY `ID_2` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gb2312;
INSERT INTO `user` VALUES (1,'admin','admin','abc@163.com');
INSERT INTO `user` VALUES (2,'sanqing','sanqing','abc@163.com');

#
# Table structure for table worklog
#

DROP TABLE IF EXISTS `worklog`;
CREATE TABLE `worklog` (
  `ID` int(10) unsigned NOT NULL auto_increment,
  `username` varchar(50) NOT NULL default '',
  `year` int(4) default NULL,
  `month` int(2) default NULL,
  `day` int(2) default NULL,
  `title` varchar(100) default NULL,
  `description` text,
  `logtime` varchar(20) default NULL,
  PRIMARY KEY  (`ID`),
  UNIQUE KEY `ID` (`ID`),
  KEY `ID_2` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=gb2312;
INSERT INTO `worklog` VALUES (1,'admin',2009,11,1,'�ܸ��˿ͻ��Ѿ������ˣ�','�ܸ��˿ͻ��Ѿ������ˣ�','2009-12-20 19:54:37');
INSERT INTO `worklog` VALUES (2,'admin',2009,11,2,'������䰡��','������䰡��','2009-12-20 19:55:05');
INSERT INTO `worklog` VALUES (3,'admin',2009,11,3,'�ͻ�Ҫ���޸Ĺ��ܣ�','�ͻ�Ҫ���޸Ĺ��ܣ�','2009-12-20 19:55:31');
INSERT INTO `worklog` VALUES (4,'admin',2009,11,4,'�ͻ����ϵۣ�Ҫ��һ��Ҫ�ﵽ��','�ͻ����ϵۣ�Ҫ��һ��Ҫ�ﵽ��','2009-12-20 19:55:47');
INSERT INTO `worklog` VALUES (6,'admin',2010,2,2,'���Թ�����־','���Թ�����־������','2010-02-01 16:39:18');

/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
