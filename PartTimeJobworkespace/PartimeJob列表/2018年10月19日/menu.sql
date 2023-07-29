/*
Navicat MySQL Data Transfer

Source Server         : localhosts
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : menu

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-10-22 11:23:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for buy_car
-- ----------------------------
DROP TABLE IF EXISTS `buy_car`;
CREATE TABLE `buy_car` (
  `buy_car_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`buy_car_id`),
  KEY `fk4_user_id` (`user_id`),
  CONSTRAINT `fk4_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of buy_car
-- ----------------------------

-- ----------------------------
-- Table structure for buy_car_menu
-- ----------------------------
DROP TABLE IF EXISTS `buy_car_menu`;
CREATE TABLE `buy_car_menu` (
  `menu_id` int(11) NOT NULL,
  `out_order_id` int(11) NOT NULL,
  KEY `fk3_menu_id` (`menu_id`),
  KEY `fk3_out_order_id` (`out_order_id`),
  CONSTRAINT `fk3_menu_id` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`menu_id`),
  CONSTRAINT `fk3_out_order_id` FOREIGN KEY (`out_order_id`) REFERENCES `out_order` (`out_order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of buy_car_menu
-- ----------------------------

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `evaluate` varchar(255) NOT NULL,
  `user_id` int(11) NOT NULL,
  `out_order_id` int(11) NOT NULL,
  `replay` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `fk3_user_id` (`user_id`),
  KEY `fk_out_order_id` (`out_order_id`),
  CONSTRAINT `fk3_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `fk_out_order_id` FOREIGN KEY (`out_order_id`) REFERENCES `out_order` (`out_order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('7', '不错', '1', '1', null);

-- ----------------------------
-- Table structure for country
-- ----------------------------
DROP TABLE IF EXISTS `country`;
CREATE TABLE `country` (
  `country_id` int(11) NOT NULL AUTO_INCREMENT,
  `country_name` varchar(255) NOT NULL,
  PRIMARY KEY (`country_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of country
-- ----------------------------
INSERT INTO `country` VALUES ('1', '新乡');

-- ----------------------------
-- Table structure for delivery
-- ----------------------------
DROP TABLE IF EXISTS `delivery`;
CREATE TABLE `delivery` (
  `delivery_id` int(11) NOT NULL AUTO_INCREMENT,
  `delivery_name` varchar(255) NOT NULL,
  `delivery_phone` varchar(255) NOT NULL,
  PRIMARY KEY (`delivery_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of delivery
-- ----------------------------
INSERT INTO `delivery` VALUES ('1', '王朝', '13232323332');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `department_id` int(11) NOT NULL AUTO_INCREMENT,
  `department_name` varchar(255) NOT NULL,
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '管理部门');
INSERT INTO `department` VALUES ('2', '后勤部门');
INSERT INTO `department` VALUES ('3', '财务部门');
INSERT INTO `department` VALUES ('4', '人事部门');

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(255) NOT NULL,
  `department_id` int(11) NOT NULL,
  PRIMARY KEY (`dept_id`),
  KEY `fk_department_id` (`department_id`),
  CONSTRAINT `fk_department_id` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('1', '超级管理员', '1');
INSERT INTO `dept` VALUES ('2', '真的好', '2');
INSERT INTO `dept` VALUES ('3', '打杂1', '4');
INSERT INTO `dept` VALUES ('4', '打杂2', '4');

-- ----------------------------
-- Table structure for level
-- ----------------------------
DROP TABLE IF EXISTS `level`;
CREATE TABLE `level` (
  `level_id` int(11) NOT NULL AUTO_INCREMENT,
  `level_name` varchar(255) NOT NULL,
  `level_url` varchar(255) DEFAULT NULL,
  `level_point` int(11) DEFAULT NULL,
  PRIMARY KEY (`level_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of level
-- ----------------------------
INSERT INTO `level` VALUES ('1', '基本信息维护 ', '', '-1');
INSERT INTO `level` VALUES ('2', '评论管理 ', '', '1');
INSERT INTO `level` VALUES ('3', '统计管理 ', '', '1');
INSERT INTO `level` VALUES ('4', '管理员管理  ', '', '-1');
INSERT INTO `level` VALUES ('5', '职位管理 ', '', '4');
INSERT INTO `level` VALUES ('6', '部门管理 ', '', '4');
INSERT INTO `level` VALUES ('7', '用户管理 ', '', '-1');
INSERT INTO `level` VALUES ('8', '用户权限管理 ', '', '7');
INSERT INTO `level` VALUES ('9', '基本信息维护 ', '', '-1');
INSERT INTO `level` VALUES ('10', '评论管理 ', '', '1');
INSERT INTO `level` VALUES ('11', '统计管理 ', '', '1');
INSERT INTO `level` VALUES ('12', '管理员管理  ', '', '-1');
INSERT INTO `level` VALUES ('13', '职位管理 ', '', '4');
INSERT INTO `level` VALUES ('14', '部门管理 ', '', '4');
INSERT INTO `level` VALUES ('15', '用户管理 ', '', '-1');
INSERT INTO `level` VALUES ('16', '用户权限管理 ', '', '7');
INSERT INTO `level` VALUES ('17', '基本信息维护 ', '', '-1');
INSERT INTO `level` VALUES ('18', '评论管理 ', '', '1');
INSERT INTO `level` VALUES ('19', '统计管理 ', '', '1');
INSERT INTO `level` VALUES ('20', '管理员管理  ', '', '-1');
INSERT INTO `level` VALUES ('21', '职位管理 ', '', '4');
INSERT INTO `level` VALUES ('22', '部门管理 ', '', '4');
INSERT INTO `level` VALUES ('23', '用户管理 ', '', '-1');
INSERT INTO `level` VALUES ('24', '用户权限管理 ', '', '7');

-- ----------------------------
-- Table structure for level_dept
-- ----------------------------
DROP TABLE IF EXISTS `level_dept`;
CREATE TABLE `level_dept` (
  `dept_id` int(11) NOT NULL,
  `level_id` int(11) NOT NULL,
  KEY `fk3_dept_id` (`dept_id`),
  KEY `fk_level_id` (`level_id`),
  CONSTRAINT `fk3_dept_id` FOREIGN KEY (`dept_id`) REFERENCES `dept` (`dept_id`),
  CONSTRAINT `fk_level_id` FOREIGN KEY (`level_id`) REFERENCES `level` (`level_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of level_dept
-- ----------------------------
INSERT INTO `level_dept` VALUES ('1', '2');
INSERT INTO `level_dept` VALUES ('1', '4');
INSERT INTO `level_dept` VALUES ('1', '7');
INSERT INTO `level_dept` VALUES ('1', '1');
INSERT INTO `level_dept` VALUES ('1', '3');
INSERT INTO `level_dept` VALUES ('1', '5');
INSERT INTO `level_dept` VALUES ('1', '6');
INSERT INTO `level_dept` VALUES ('1', '8');
INSERT INTO `level_dept` VALUES ('1', '1');
INSERT INTO `level_dept` VALUES ('1', '2');
INSERT INTO `level_dept` VALUES ('1', '3');
INSERT INTO `level_dept` VALUES ('1', '4');
INSERT INTO `level_dept` VALUES ('1', '5');
INSERT INTO `level_dept` VALUES ('1', '6');
INSERT INTO `level_dept` VALUES ('2', '1');
INSERT INTO `level_dept` VALUES ('2', '1');
INSERT INTO `level_dept` VALUES ('2', '2');
INSERT INTO `level_dept` VALUES ('2', '3');
INSERT INTO `level_dept` VALUES ('3', '1');
INSERT INTO `level_dept` VALUES ('3', '4');
INSERT INTO `level_dept` VALUES ('3', '7');
INSERT INTO `level_dept` VALUES ('4', '1');
INSERT INTO `level_dept` VALUES ('4', '4');
INSERT INTO `level_dept` VALUES ('4', '7');
INSERT INTO `level_dept` VALUES ('3', '1');
INSERT INTO `level_dept` VALUES ('3', '2');
INSERT INTO `level_dept` VALUES ('3', '4');
INSERT INTO `level_dept` VALUES ('3', '7');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(255) NOT NULL,
  `menu_price` varchar(255) NOT NULL,
  `type_id` int(11) NOT NULL,
  PRIMARY KEY (`menu_id`),
  KEY `fk_type_id` (`type_id`),
  CONSTRAINT `fk_type_id` FOREIGN KEY (`type_id`) REFERENCES `type` (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------

-- ----------------------------
-- Table structure for offbill
-- ----------------------------
DROP TABLE IF EXISTS `offbill`;
CREATE TABLE `offbill` (
  `off_id` int(11) NOT NULL AUTO_INCREMENT,
  `off_price` varchar(255) NOT NULL,
  `off_season` varchar(255) NOT NULL,
  `off_date` date NOT NULL,
  PRIMARY KEY (`off_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of offbill
-- ----------------------------

-- ----------------------------
-- Table structure for onbill
-- ----------------------------
DROP TABLE IF EXISTS `onbill`;
CREATE TABLE `onbill` (
  `on_id` int(11) NOT NULL AUTO_INCREMENT,
  `on_price` varchar(255) NOT NULL,
  `on_season` varchar(255) NOT NULL,
  `on_date` date NOT NULL,
  PRIMARY KEY (`on_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of onbill
-- ----------------------------

-- ----------------------------
-- Table structure for order_menu
-- ----------------------------
DROP TABLE IF EXISTS `order_menu`;
CREATE TABLE `order_menu` (
  `menu_id` int(11) NOT NULL,
  `out_order_id` int(11) NOT NULL,
  KEY `fk2_menu_id` (`menu_id`),
  KEY `fk2_out_order_id` (`out_order_id`),
  CONSTRAINT `fk2_menu_id` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`menu_id`),
  CONSTRAINT `fk2_out_order_id` FOREIGN KEY (`out_order_id`) REFERENCES `out_order` (`out_order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_menu
-- ----------------------------

-- ----------------------------
-- Table structure for out_order
-- ----------------------------
DROP TABLE IF EXISTS `out_order`;
CREATE TABLE `out_order` (
  `out_order_id` int(11) NOT NULL AUTO_INCREMENT,
  `out_ouder_num` int(11) NOT NULL,
  `out_create_date` date NOT NULL,
  `out_user_message` varchar(255) DEFAULT NULL,
  `out_order_type` int(255) NOT NULL,
  `user_id` int(11) NOT NULL,
  `delivery_id` int(11) NOT NULL,
  PRIMARY KEY (`out_order_id`),
  KEY `fk_user_id` (`user_id`),
  KEY `fk_delivery_id` (`delivery_id`),
  CONSTRAINT `fk_delivery_id` FOREIGN KEY (`delivery_id`) REFERENCES `delivery` (`delivery_id`),
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of out_order
-- ----------------------------
INSERT INTO `out_order` VALUES ('1', '100001', '2018-10-15', '多放辣椒，少放醋', '1', '1', '1');

-- ----------------------------
-- Table structure for point
-- ----------------------------
DROP TABLE IF EXISTS `point`;
CREATE TABLE `point` (
  `point_id` int(11) NOT NULL AUTO_INCREMENT,
  `point_num` int(11) NOT NULL,
  PRIMARY KEY (`point_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of point
-- ----------------------------

-- ----------------------------
-- Table structure for point_conversion
-- ----------------------------
DROP TABLE IF EXISTS `point_conversion`;
CREATE TABLE `point_conversion` (
  `pc_id` int(11) NOT NULL AUTO_INCREMENT,
  `pc_name` varchar(255) NOT NULL,
  `pc_need_point` int(255) NOT NULL,
  `pc_num` int(11) NOT NULL,
  PRIMARY KEY (`pc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of point_conversion
-- ----------------------------

-- ----------------------------
-- Table structure for purchase
-- ----------------------------
DROP TABLE IF EXISTS `purchase`;
CREATE TABLE `purchase` (
  `purchase_id` int(11) NOT NULL AUTO_INCREMENT,
  `pd_id` int(11) NOT NULL,
  `supplier_id` int(11) NOT NULL,
  PRIMARY KEY (`purchase_id`),
  KEY `fk_pd_id` (`pd_id`),
  KEY `supplier_id` (`supplier_id`),
  CONSTRAINT `fk_pd_id` FOREIGN KEY (`pd_id`) REFERENCES `purchase_detail` (`pd_id`),
  CONSTRAINT `supplier_id` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`supplier_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of purchase
-- ----------------------------

-- ----------------------------
-- Table structure for purchase_detail
-- ----------------------------
DROP TABLE IF EXISTS `purchase_detail`;
CREATE TABLE `purchase_detail` (
  `pd_id` int(11) NOT NULL AUTO_INCREMENT,
  `pd_name` varchar(255) NOT NULL,
  `pd_num` int(11) NOT NULL,
  `pd_price` varchar(255) NOT NULL,
  `pd_total` varchar(255) NOT NULL,
  `pd_state` int(255) NOT NULL,
  PRIMARY KEY (`pd_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of purchase_detail
-- ----------------------------

-- ----------------------------
-- Table structure for repertory
-- ----------------------------
DROP TABLE IF EXISTS `repertory`;
CREATE TABLE `repertory` (
  `rp_id` int(11) NOT NULL AUTO_INCREMENT,
  `rp_name` varchar(255) NOT NULL,
  `rp_num` int(11) NOT NULL,
  PRIMARY KEY (`rp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of repertory
-- ----------------------------

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `room_id` int(11) NOT NULL AUTO_INCREMENT,
  `room_num` int(11) NOT NULL,
  `room_name` varchar(255) NOT NULL,
  `room_state` int(255) NOT NULL,
  PRIMARY KEY (`room_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room
-- ----------------------------

-- ----------------------------
-- Table structure for room_order
-- ----------------------------
DROP TABLE IF EXISTS `room_order`;
CREATE TABLE `room_order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_num` int(11) NOT NULL,
  `create_date` date NOT NULL,
  `order_room` int(255) NOT NULL,
  `order_type` int(255) NOT NULL,
  `room_id` int(11) NOT NULL,
  `menu_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `fk_room_id` (`room_id`),
  KEY `fk_menu_id` (`menu_id`),
  KEY `fk2_user_id` (`user_id`),
  CONSTRAINT `fk2_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `fk_menu_id` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`menu_id`),
  CONSTRAINT `fk_room_id` FOREIGN KEY (`room_id`) REFERENCES `room` (`room_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room_order
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES ('1', '1', '1', null, '1');
INSERT INTO `staff` VALUES ('2', '1', '1', null, '1');
INSERT INTO `staff` VALUES ('3', '3', '3', null, '1');
INSERT INTO `staff` VALUES ('4', '666', '666', null, '1');
INSERT INTO `staff` VALUES ('5', '6', '6', null, '1');
INSERT INTO `staff` VALUES ('6', '0', '0', null, '1');
INSERT INTO `staff` VALUES ('7', 'super', '123456', null, '1');
INSERT INTO `staff` VALUES ('8', 'superme', '123456', null, '1');
INSERT INTO `staff` VALUES ('9', 'supermeme', '123456', null, '1');
INSERT INTO `staff` VALUES ('10', 'xx', '123456', null, '1');
INSERT INTO `staff` VALUES ('11', 'test', '123456', null, '1');
INSERT INTO `staff` VALUES ('12', 'test1', '123456', null, '2');
INSERT INTO `staff` VALUES ('13', 'test2', '123456', null, '1');

-- ----------------------------
-- Table structure for staff_dept
-- ----------------------------
DROP TABLE IF EXISTS `staff_dept`;
CREATE TABLE `staff_dept` (
  `staff_detail_id` int(11) NOT NULL,
  `dept_id` int(11) NOT NULL,
  KEY `fk2_staff_detail_id` (`staff_detail_id`),
  KEY `fk_dept_id` (`dept_id`),
  CONSTRAINT `fk2_staff_detail_id` FOREIGN KEY (`staff_detail_id`) REFERENCES `staff_detail` (`staff_detail_id`),
  CONSTRAINT `fk_dept_id` FOREIGN KEY (`dept_id`) REFERENCES `dept` (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff_dept
-- ----------------------------

-- ----------------------------
-- Table structure for staff_detail
-- ----------------------------
DROP TABLE IF EXISTS `staff_detail`;
CREATE TABLE `staff_detail` (
  `staff_detail_id` int(11) NOT NULL AUTO_INCREMENT,
  `staff_name` varchar(255) NOT NULL,
  `staff_age` int(255) NOT NULL,
  `staff_phone` varchar(255) NOT NULL,
  `staff_address` varchar(255) DEFAULT NULL,
  `staff_pay` varchar(255) NOT NULL,
  PRIMARY KEY (`staff_detail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff_detail
-- ----------------------------

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier` (
  `supplier_id` int(11) NOT NULL,
  `supplier_name` varchar(255) NOT NULL,
  `supplier_address` varchar(255) NOT NULL,
  `supplier_phone` varchar(255) NOT NULL,
  PRIMARY KEY (`supplier_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of supplier
-- ----------------------------

-- ----------------------------
-- Table structure for town
-- ----------------------------
DROP TABLE IF EXISTS `town`;
CREATE TABLE `town` (
  `town_id` int(11) NOT NULL AUTO_INCREMENT,
  `town_name` varchar(255) NOT NULL,
  PRIMARY KEY (`town_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of town
-- ----------------------------

-- ----------------------------
-- Table structure for turnover
-- ----------------------------
DROP TABLE IF EXISTS `turnover`;
CREATE TABLE `turnover` (
  `turnover_id` int(11) NOT NULL AUTO_INCREMENT,
  `on_total` varchar(255) NOT NULL,
  `off_total` varchar(255) NOT NULL,
  `over_total` varchar(255) NOT NULL,
  PRIMARY KEY (`turnover_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of turnover
-- ----------------------------

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(255) NOT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of type
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) NOT NULL,
  `user_pwd` varchar(255) NOT NULL,
  `user_address` varchar(255) NOT NULL,
  `user_phone` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '张三', '123', '新乡', '12345678910');
INSERT INTO `user` VALUES ('2', '李四', '456', '泗水', '23456789101');

-- ----------------------------
-- Table structure for warehouse
-- ----------------------------
DROP TABLE IF EXISTS `warehouse`;
CREATE TABLE `warehouse` (
  `ws_id` int(11) NOT NULL AUTO_INCREMENT,
  `purchase_id` int(11) NOT NULL,
  PRIMARY KEY (`ws_id`),
  KEY `fk_purchase_id` (`purchase_id`),
  CONSTRAINT `fk_purchase_id` FOREIGN KEY (`purchase_id`) REFERENCES `purchase` (`purchase_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of warehouse
-- ----------------------------
