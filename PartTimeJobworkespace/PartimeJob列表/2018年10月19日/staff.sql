/*
Navicat MySQL Data Transfer

Source Server         : localhosts
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : menu

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-10-22 17:30:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `staff_id` int(11) NOT NULL AUTO_INCREMENT,
  `staff_user_name` varchar(255) NOT NULL,
  `staff_user_pwd` varchar(255) NOT NULL,
  `staff_detail_id` int(11) DEFAULT NULL,
  `staff_dept_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`staff_id`),
  KEY `fk_staff_dept_id` (`staff_dept_id`),
  CONSTRAINT `fk_staff_dept_id` FOREIGN KEY (`staff_dept_id`) REFERENCES `dept` (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
