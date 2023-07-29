/*
Navicat MySQL Data Transfer

Source Server         : sso1
Source Server Version : 50147
Source Host           : localhost:3306
Source Database       : dealonline

Target Server Type    : MYSQL
Target Server Version : 50147
File Encoding         : 65001

Date: 2017-10-29 08:36:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `card`
-- ----------------------------
DROP TABLE IF EXISTS `card`;
CREATE TABLE `card` (
  `card_id` int(11) NOT NULL AUTO_INCREMENT,
  `meal` varchar(11) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `price` double(11,0) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`card_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of card
-- ----------------------------

-- ----------------------------
-- Table structure for `caterial`
-- ----------------------------
DROP TABLE IF EXISTS `caterial`;
CREATE TABLE `caterial` (
  `caterial_id` int(50) NOT NULL AUTO_INCREMENT,
  `emp_id` varchar(50) DEFAULT NULL,
  `caterial_name` varchar(50) DEFAULT NULL,
  `demand` int(50) DEFAULT NULL,
  `unit` varchar(50) DEFAULT NULL,
  `number` int(50) DEFAULT NULL,
  `univalent` int(50) DEFAULT NULL,
  `warehouse_date` datetime DEFAULT NULL,
  `caterial_state` int(11) DEFAULT NULL,
  PRIMARY KEY (`caterial_id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of caterial
-- ----------------------------
INSERT INTO `caterial` VALUES ('1', '4', '盐', '864', '袋', '6', '4', '2017-10-22 21:17:56', '0');
INSERT INTO `caterial` VALUES ('2', '4', '蒜', '855', '斤', '5', '10', '2017-10-20 09:47:45', '0');
INSERT INTO `caterial` VALUES ('3', '4', '色拉油', '403', '斤', '3', '10', '2017-10-18 21:20:03', '0');
INSERT INTO `caterial` VALUES ('4', '4', '葱', '859', '斤', '1', '10', '2017-10-21 19:22:59', '0');
INSERT INTO `caterial` VALUES ('5', '4', '生抽', '859', '瓶', '2', '5', '2017-10-18 21:13:56', '0');
INSERT INTO `caterial` VALUES ('6', '4', '糖', '994', '袋', '1', '5', '2017-10-18 21:14:00', '0');
INSERT INTO `caterial` VALUES ('7', '4', '豆瓣酱', '994', '瓶', '1', '10', '2017-10-18 21:23:01', '0');
INSERT INTO `caterial` VALUES ('8', '4', '老抽', '999', '瓶', '2', '10', '2017-10-18 21:14:57', '0');
INSERT INTO `caterial` VALUES ('9', '4', '辣椒面', '999', '斤', '2', '10', '2017-10-18 21:20:58', '0');
INSERT INTO `caterial` VALUES ('10', '4', '蚝油', '999', '斤', '1', '20', '2017-10-18 21:21:07', '0');
INSERT INTO `caterial` VALUES ('11', '4', '味精', '999', '袋', '2', '5', '2017-10-18 21:57:07', '0');
INSERT INTO `caterial` VALUES ('12', '4', '姜', '999', '斤', '4', '8', '2017-10-18 21:57:05', '0');
INSERT INTO `caterial` VALUES ('13', '4', '醋', '999', '瓶', '1', '5', '2017-10-18 21:57:03', '0');
INSERT INTO `caterial` VALUES ('14', '4', '辣椒油', '999', '瓶', '1', '15', '2017-10-18 21:57:00', '0');
INSERT INTO `caterial` VALUES ('15', '4', '冰糖', '999', '斤', '1', '5', '2017-10-18 21:56:58', '0');
INSERT INTO `caterial` VALUES ('16', '4', '桂皮', '999', '斤', '1', '10', '2017-10-18 21:56:56', '0');
INSERT INTO `caterial` VALUES ('17', '4', '八角', '999', '斤', '1', '10', '2017-10-18 21:56:55', '0');
INSERT INTO `caterial` VALUES ('18', '4', '花雕酒', '999', '瓶', '1', '45', '2017-10-18 21:56:53', '0');
INSERT INTO `caterial` VALUES ('19', '4', '白胡椒粉', '999', '斤', '1', '10', '2017-10-18 21:56:51', '0');
INSERT INTO `caterial` VALUES ('20', '4', '蒸鱼豉油', '999', '瓶', '1', '15', '2017-10-18 21:56:50', '0');
INSERT INTO `caterial` VALUES ('21', '4', '李锦记秘制红烧汁', '999', '袋', '1', '15', '2017-10-18 21:56:48', '0');
INSERT INTO `caterial` VALUES ('22', '4', '料酒', '999', '瓶', '1', '15', '2017-10-18 21:56:45', '0');
INSERT INTO `caterial` VALUES ('23', '4', '芝麻香油', '999', '瓶', '1', '20', '2017-10-18 21:56:44', '0');
INSERT INTO `caterial` VALUES ('24', '4', '花椒', '999', '斤', '1', '10', '2017-10-18 21:56:42', '0');
INSERT INTO `caterial` VALUES ('25', '4', '香叶', '999', '斤', '1', '10', '2017-10-18 21:56:40', '0');
INSERT INTO `caterial` VALUES ('26', '4', '鸡精', '999', '袋', '1', '10', '2017-10-18 21:56:38', '0');
INSERT INTO `caterial` VALUES ('27', '4', '苹果醋', '999', '瓶', '1', '10', '2017-10-18 21:56:36', '0');
INSERT INTO `caterial` VALUES ('28', '4', '金针菇', '999', '斤', '1', '15', '2017-10-18 21:56:34', '0');
INSERT INTO `caterial` VALUES ('29', '4', '土豆', '999', '斤', '1', '8', '2017-10-18 21:56:33', '0');
INSERT INTO `caterial` VALUES ('30', '4', '花甲', '999', '斤', '1', '20', '2017-10-18 21:56:31', '0');
INSERT INTO `caterial` VALUES ('31', '4', '青椒', '999', '斤', '1', '5', '2017-10-18 21:56:29', '0');
INSERT INTO `caterial` VALUES ('32', '4', '红椒', '999', '斤', '1', '5', '2017-10-18 21:56:28', '0');
INSERT INTO `caterial` VALUES ('33', '4', '排骨', '999', '斤', '1', '30', '2017-10-18 21:56:26', '0');
INSERT INTO `caterial` VALUES ('34', '4', '海虾', '999', '斤', '1', '40', '2017-10-18 21:56:24', '0');
INSERT INTO `caterial` VALUES ('35', '4', '绿豆粉丝', '999', '斤', '1', '10', '2017-10-18 21:56:22', '0');
INSERT INTO `caterial` VALUES ('36', '4', '鲫鱼', '999', '条', '1', '40', '2017-10-18 21:56:20', '0');
INSERT INTO `caterial` VALUES ('37', '4', '猪肉馅', '999', '斤', '1', '20', '2017-10-18 21:56:18', '0');
INSERT INTO `caterial` VALUES ('38', '4', '鸡蛋', '999', '斤', '1', '15', '2017-10-18 21:56:16', '0');
INSERT INTO `caterial` VALUES ('39', '4', '淀粉', '999', '斤', '1', '5', '2017-10-18 21:56:12', '0');
INSERT INTO `caterial` VALUES ('40', '4', '皮蛋', '999', '斤', '1', '10', '2017-10-18 21:56:10', '0');
INSERT INTO `caterial` VALUES ('41', '4', '芹菜', '999', '斤', '1', '10', '2017-10-18 21:56:08', '0');
INSERT INTO `caterial` VALUES ('42', '4', '木耳', '999', '斤', '1', '12', '2017-10-18 21:56:05', '0');
INSERT INTO `caterial` VALUES ('43', '4', '胡萝卜', '999', '斤', '1', '5', '2017-10-18 21:56:03', '0');
INSERT INTO `caterial` VALUES ('44', '4', '花生米', '999', '斤', '1', '5', '2017-10-18 21:56:01', '0');
INSERT INTO `caterial` VALUES ('45', '4', '菠菜', '999', '斤', '1', '5', '2017-10-18 21:55:57', '0');
INSERT INTO `caterial` VALUES ('46', '4', '嫩豆腐', '998', '斤', '1', '5', '2017-10-18 21:55:54', '0');
INSERT INTO `caterial` VALUES ('47', '4', '榨菜末', '998', '斤', '1', '5', '2017-10-18 21:55:51', '0');
INSERT INTO `caterial` VALUES ('48', '4', '黄瓜', '998', '斤', '1', '5', '2017-10-18 21:55:48', '0');
INSERT INTO `caterial` VALUES ('49', '4', '鸡腿', '998', '斤', '1', '10', '2017-10-18 21:55:45', '0');
INSERT INTO `caterial` VALUES ('50', '4', '小糊涂神', '999', '瓶', '1', '50', '2017-10-18 21:55:42', '0');
INSERT INTO `caterial` VALUES ('51', '4', '茅台迎宾酒', '989', '瓶', '1', '80', '2017-10-18 21:55:39', '0');
INSERT INTO `caterial` VALUES ('52', '4', '可乐', '989', '瓶', '1', '5', '2017-10-18 21:55:35', '0');
INSERT INTO `caterial` VALUES ('53', '4', '雪碧', '989', '瓶', '1', '5', '2017-10-18 21:55:33', '0');
INSERT INTO `caterial` VALUES ('54', '4', '可口可乐', '989', '瓶', '1', '5', '2017-10-18 21:55:30', '0');
INSERT INTO `caterial` VALUES ('55', '4', '芬达', '989', '瓶', '1', '5', '2017-10-18 21:55:26', '0');
INSERT INTO `caterial` VALUES ('56', '4', '瓜', '799', '斤', null, '1', null, '1');

-- ----------------------------
-- Table structure for `code`
-- ----------------------------
DROP TABLE IF EXISTS `code`;
CREATE TABLE `code` (
  `code_id` int(11) NOT NULL,
  `code_no` int(11) DEFAULT NULL,
  `code_value` varchar(200) DEFAULT NULL,
  `code_type` varchar(200) DEFAULT NULL,
  `code_parent` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`code_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of code
-- ----------------------------
INSERT INTO `code` VALUES ('1', '0', '未知', 'BM_SEX', null);
INSERT INTO `code` VALUES ('2', '1', '男性', 'BM_SEX', '');
INSERT INTO `code` VALUES ('3', '2', '女性', 'BM_SEX', '');
INSERT INTO `code` VALUES ('4', '9', '未说明', 'BM_SEX', '');
INSERT INTO `code` VALUES ('5', '0', '汇款', 'BM_GR_PAY_COST_FORM', null);
INSERT INTO `code` VALUES ('6', '1', '支票', 'BM_GR_PAY_COST_FORM', '');
INSERT INTO `code` VALUES ('7', '2', '现金', 'BM_GR_PAY_COST_FORM', '');
INSERT INTO `code` VALUES ('8', '3', '其它', 'BM_GR_PAY_COST_FORM', '');
INSERT INTO `code` VALUES ('9', '4', '注销核减', 'BM_GR_PAY_COST_FORM', '');
INSERT INTO `code` VALUES ('10', '5', '撤销核减', 'BM_GR_PAY_COST_FORM', '');
INSERT INTO `code` VALUES ('11', '6', '提前续展核减', 'BM_GR_PAY_COST_FORM', '');
INSERT INTO `code` VALUES ('12', '440500', '汕头市', 'BM_DISTRICT', '440000');
INSERT INTO `code` VALUES ('13', '440501', '市辖区', 'BM_DISTRICT', '440500');
INSERT INTO `code` VALUES ('14', '440507', '龙湖区', 'BM_DISTRICT', '440500');
INSERT INTO `code` VALUES ('15', '440511', '金平区', 'BM_DISTRICT', '440500');
INSERT INTO `code` VALUES ('16', '140524', '陵川县', 'BM_DISTRICT', '140500');
INSERT INTO `code` VALUES ('17', '140525', '泽州县', 'BM_DISTRICT', '140500');
INSERT INTO `code` VALUES ('18', '140581', '高平市', 'BM_DISTRICT', '140500');
INSERT INTO `code` VALUES ('19', '140600', '朔州市', 'BM_DISTRICT', '140000');
INSERT INTO `code` VALUES ('20', '140601', '市辖区', 'BM_DISTRICT', '140600');
INSERT INTO `code` VALUES ('21', '140602', '朔城区', 'BM_DISTRICT', '140600');
INSERT INTO `code` VALUES ('22', '140603', '平鲁区', 'BM_DISTRICT', '140600');
INSERT INTO `code` VALUES ('23', '140621', '山阴县', 'BM_DISTRICT', '140600');
INSERT INTO `code` VALUES ('24', '140622', '应县', 'BM_DISTRICT', '140600');
INSERT INTO `code` VALUES ('25', '140623', '右玉县', 'BM_DISTRICT', '140600');
INSERT INTO `code` VALUES ('26', '140624', '怀仁县', 'BM_DISTRICT', '140600');
INSERT INTO `code` VALUES ('27', '140700', '晋中市', 'BM_DISTRICT', '140000');
INSERT INTO `code` VALUES ('28', '140701', '市辖区', 'BM_DISTRICT', '140700');
INSERT INTO `code` VALUES ('29', '140702', '榆次区', 'BM_DISTRICT', '140700');
INSERT INTO `code` VALUES ('30', '140721', '榆社县', 'BM_DISTRICT', '140700');
INSERT INTO `code` VALUES ('31', '140722', '左权县', 'BM_DISTRICT', '140700');
INSERT INTO `code` VALUES ('32', '140723', '和顺县', 'BM_DISTRICT', '140700');
INSERT INTO `code` VALUES ('33', '140724', '昔阳县', 'BM_DISTRICT', '140700');
INSERT INTO `code` VALUES ('34', '140725', '寿阳县', 'BM_DISTRICT', '140700');
INSERT INTO `code` VALUES ('35', '140726', '太谷县', 'BM_DISTRICT', '140700');
INSERT INTO `code` VALUES ('36', '140727', '祁县', 'BM_DISTRICT', '140700');
INSERT INTO `code` VALUES ('37', '140728', '平遥县', 'BM_DISTRICT', '140700');
INSERT INTO `code` VALUES ('38', '140729', '灵石县', 'BM_DISTRICT', '140700');
INSERT INTO `code` VALUES ('39', '140781', '介休市', 'BM_DISTRICT', '140700');
INSERT INTO `code` VALUES ('40', '140800', '运城市', 'BM_DISTRICT', '140000');
INSERT INTO `code` VALUES ('41', '140801', '市辖区', 'BM_DISTRICT', '140800');
INSERT INTO `code` VALUES ('42', '140802', '盐湖区', 'BM_DISTRICT', '140800');
INSERT INTO `code` VALUES ('43', '140821', '临猗县', 'BM_DISTRICT', '140800');
INSERT INTO `code` VALUES ('44', '140822', '万荣县', 'BM_DISTRICT', '140800');
INSERT INTO `code` VALUES ('45', '140823', '闻喜县', 'BM_DISTRICT', '140800');
INSERT INTO `code` VALUES ('46', '140824', '稷山县', 'BM_DISTRICT', '140800');
INSERT INTO `code` VALUES ('47', '140825', '新绛县', 'BM_DISTRICT', '140800');
INSERT INTO `code` VALUES ('48', '140826', '绛县', 'BM_DISTRICT', '140800');
INSERT INTO `code` VALUES ('49', '140827', '垣曲县', 'BM_DISTRICT', '140800');
INSERT INTO `code` VALUES ('50', '140828', '夏县', 'BM_DISTRICT', '140800');
INSERT INTO `code` VALUES ('51', '140829', '平陆县', 'BM_DISTRICT', '140800');
INSERT INTO `code` VALUES ('52', '140830', '芮城县', 'BM_DISTRICT', '140800');
INSERT INTO `code` VALUES ('53', '140881', '永济市', 'BM_DISTRICT', '140800');
INSERT INTO `code` VALUES ('54', '140882', '河津市', 'BM_DISTRICT', '140800');
INSERT INTO `code` VALUES ('55', '140900', '忻州市', 'BM_DISTRICT', '140000');
INSERT INTO `code` VALUES ('56', '140901', '市辖区', 'BM_DISTRICT', '140900');
INSERT INTO `code` VALUES ('57', '140902', '忻府区', 'BM_DISTRICT', '140900');
INSERT INTO `code` VALUES ('58', '140921', '定襄县', 'BM_DISTRICT', '140900');
INSERT INTO `code` VALUES ('59', '140922', '五台县', 'BM_DISTRICT', '140900');
INSERT INTO `code` VALUES ('60', '140923', '代县', 'BM_DISTRICT', '140900');
INSERT INTO `code` VALUES ('61', '140924', '繁峙县', 'BM_DISTRICT', '140900');
INSERT INTO `code` VALUES ('62', '140925', '宁武县', 'BM_DISTRICT', '140900');
INSERT INTO `code` VALUES ('63', '140926', '静乐县', 'BM_DISTRICT', '140900');
INSERT INTO `code` VALUES ('64', '140927', '神池县', 'BM_DISTRICT', '140900');
INSERT INTO `code` VALUES ('65', '140928', '五寨县', 'BM_DISTRICT', '140900');
INSERT INTO `code` VALUES ('66', '140929', '岢岚县', 'BM_DISTRICT', '140900');
INSERT INTO `code` VALUES ('67', '140930', '河曲县', 'BM_DISTRICT', '140900');
INSERT INTO `code` VALUES ('68', '140931', '保德县', 'BM_DISTRICT', '140900');
INSERT INTO `code` VALUES ('69', '140932', '偏关县', 'BM_DISTRICT', '140900');
INSERT INTO `code` VALUES ('70', '140981', '原平市', 'BM_DISTRICT', '140900');
INSERT INTO `code` VALUES ('71', '640303', '红寺堡区', 'BM_DISTRICT', '640300');
INSERT INTO `code` VALUES ('72', '640323', '盐池县', 'BM_DISTRICT', '640300');
INSERT INTO `code` VALUES ('73', '640324', '同心县', 'BM_DISTRICT', '640300');
INSERT INTO `code` VALUES ('74', '640381', '青铜峡市', 'BM_DISTRICT', '640300');
INSERT INTO `code` VALUES ('75', '640400', '固原市', 'BM_DISTRICT', '640000');
INSERT INTO `code` VALUES ('76', '640401', '市辖区', 'BM_DISTRICT', '640400');
INSERT INTO `code` VALUES ('77', '640402', '原州区', 'BM_DISTRICT', '640400');
INSERT INTO `code` VALUES ('78', '640422', '西吉县', 'BM_DISTRICT', '640400');
INSERT INTO `code` VALUES ('79', '640423', '隆德县', 'BM_DISTRICT', '640400');
INSERT INTO `code` VALUES ('80', '640424', '泾源县', 'BM_DISTRICT', '640400');
INSERT INTO `code` VALUES ('81', '640425', '彭阳县', 'BM_DISTRICT', '640400');
INSERT INTO `code` VALUES ('82', '640500', '中卫市', 'BM_DISTRICT', '640000');
INSERT INTO `code` VALUES ('83', '640501', '市辖区', 'BM_DISTRICT', '640500');
INSERT INTO `code` VALUES ('84', '640502', '沙坡头区', 'BM_DISTRICT', '640500');
INSERT INTO `code` VALUES ('85', '640521', '中宁县', 'BM_DISTRICT', '640500');
INSERT INTO `code` VALUES ('86', '640522', '海原县', 'BM_DISTRICT', '640500');
INSERT INTO `code` VALUES ('87', '650000', '新疆维吾尔自治区', 'BM_DISTRICT', null);
INSERT INTO `code` VALUES ('88', '650100', '乌鲁木齐市', 'BM_DISTRICT', '650000');
INSERT INTO `code` VALUES ('89', '650101', '市辖区', 'BM_DISTRICT', '650100');
INSERT INTO `code` VALUES ('90', '650102', '天山区', 'BM_DISTRICT', '650100');
INSERT INTO `code` VALUES ('91', '650103', '沙依巴克区', 'BM_DISTRICT', '650100');
INSERT INTO `code` VALUES ('92', '650104', '新市区', 'BM_DISTRICT', '650100');
INSERT INTO `code` VALUES ('93', '650105', '水磨沟区', 'BM_DISTRICT', '650100');
INSERT INTO `code` VALUES ('94', '650106', '头屯河区', 'BM_DISTRICT', '650100');
INSERT INTO `code` VALUES ('95', '650107', '达坂城区', 'BM_DISTRICT', '650100');
INSERT INTO `code` VALUES ('96', '650109', '米东区', 'BM_DISTRICT', '650100');
INSERT INTO `code` VALUES ('97', '650121', '乌鲁木齐县', 'BM_DISTRICT', '650100');
INSERT INTO `code` VALUES ('98', '650200', '克拉玛依市', 'BM_DISTRICT', '650000');
INSERT INTO `code` VALUES ('99', '650201', '市辖区', 'BM_DISTRICT', '650200');
INSERT INTO `code` VALUES ('100', '650202', '独山子区', 'BM_DISTRICT', '650200');
INSERT INTO `code` VALUES ('101', '650203', '克拉玛依区', 'BM_DISTRICT', '650200');
INSERT INTO `code` VALUES ('102', '650204', '白碱滩区', 'BM_DISTRICT', '650200');
INSERT INTO `code` VALUES ('103', '650205', '乌尔禾区', 'BM_DISTRICT', '650200');
INSERT INTO `code` VALUES ('104', '652100', '吐鲁番地区', 'BM_DISTRICT', '650000');
INSERT INTO `code` VALUES ('105', '652101', '吐鲁番市', 'BM_DISTRICT', '652100');
INSERT INTO `code` VALUES ('106', '652122', '鄯善县', 'BM_DISTRICT', '652100');
INSERT INTO `code` VALUES ('107', '652123', '托克逊县', 'BM_DISTRICT', '652100');
INSERT INTO `code` VALUES ('108', '652200', '哈密地区', 'BM_DISTRICT', '650000');
INSERT INTO `code` VALUES ('109', '652201', '哈密市', 'BM_DISTRICT', '652200');
INSERT INTO `code` VALUES ('110', '652222', '巴里坤哈萨克自治县', 'BM_DISTRICT', '652200');
INSERT INTO `code` VALUES ('111', '652223', '伊吾县', 'BM_DISTRICT', '652200');
INSERT INTO `code` VALUES ('112', '652300', '昌吉回族自治州', 'BM_DISTRICT', '650000');
INSERT INTO `code` VALUES ('113', '652301', '昌吉市', 'BM_DISTRICT', '652300');
INSERT INTO `code` VALUES ('114', '652302', '阜康市', 'BM_DISTRICT', '652300');
INSERT INTO `code` VALUES ('115', '652323', '呼图壁县', 'BM_DISTRICT', '652300');
INSERT INTO `code` VALUES ('116', '652324', '玛纳斯县', 'BM_DISTRICT', '652300');
INSERT INTO `code` VALUES ('117', '652325', '奇台县', 'BM_DISTRICT', '652300');
INSERT INTO `code` VALUES ('118', '652327', '吉木萨尔县', 'BM_DISTRICT', '652300');
INSERT INTO `code` VALUES ('119', '652328', '木垒哈萨克自治县', 'BM_DISTRICT', '652300');
INSERT INTO `code` VALUES ('120', '620300', '金昌市', 'BM_DISTRICT', '620000');
INSERT INTO `code` VALUES ('121', '620301', '市辖区', 'BM_DISTRICT', '620300');
INSERT INTO `code` VALUES ('122', '620302', '金川区', 'BM_DISTRICT', '620300');
INSERT INTO `code` VALUES ('123', '620321', '永昌县', 'BM_DISTRICT', '620300');
INSERT INTO `code` VALUES ('124', '620400', '白银市', 'BM_DISTRICT', '620000');
INSERT INTO `code` VALUES ('125', '620401', '市辖区', 'BM_DISTRICT', '620400');
INSERT INTO `code` VALUES ('126', '620402', '白银区', 'BM_DISTRICT', '620400');
INSERT INTO `code` VALUES ('127', '620403', '平川区', 'BM_DISTRICT', '620400');
INSERT INTO `code` VALUES ('128', '620421', '靖远县', 'BM_DISTRICT', '620400');
INSERT INTO `code` VALUES ('129', '620422', '会宁县', 'BM_DISTRICT', '620400');
INSERT INTO `code` VALUES ('130', '620423', '景泰县', 'BM_DISTRICT', '620400');
INSERT INTO `code` VALUES ('131', '620500', '天水市', 'BM_DISTRICT', '620000');
INSERT INTO `code` VALUES ('132', '620501', '市辖区', 'BM_DISTRICT', '620500');
INSERT INTO `code` VALUES ('133', '620502', '秦州区', 'BM_DISTRICT', '620500');
INSERT INTO `code` VALUES ('134', '620503', '麦积区', 'BM_DISTRICT', '620500');
INSERT INTO `code` VALUES ('135', '620521', '清水县', 'BM_DISTRICT', '620500');
INSERT INTO `code` VALUES ('136', '620522', '秦安县', 'BM_DISTRICT', '620500');
INSERT INTO `code` VALUES ('137', '620523', '甘谷县', 'BM_DISTRICT', '620500');
INSERT INTO `code` VALUES ('138', '620524', '武山县', 'BM_DISTRICT', '620500');
INSERT INTO `code` VALUES ('139', '620525', '张家川回族自治县', 'BM_DISTRICT', '620500');
INSERT INTO `code` VALUES ('140', '620600', '武威市', 'BM_DISTRICT', '620000');
INSERT INTO `code` VALUES ('141', '150302', '海勃湾区', 'BM_DISTRICT', '150300');
INSERT INTO `code` VALUES ('142', '150303', '海南区', 'BM_DISTRICT', '150300');
INSERT INTO `code` VALUES ('143', '150304', '乌达区', 'BM_DISTRICT', '150300');
INSERT INTO `code` VALUES ('144', '150400', '赤峰市', 'BM_DISTRICT', '150000');
INSERT INTO `code` VALUES ('145', '350401', '市辖区', 'BM_DISTRICT', '350400');
INSERT INTO `code` VALUES ('146', '350402', '梅列区', 'BM_DISTRICT', '350400');
INSERT INTO `code` VALUES ('147', '350403', '三元区', 'BM_DISTRICT', '350400');
INSERT INTO `code` VALUES ('148', '350421', '明溪县', 'BM_DISTRICT', '350400');
INSERT INTO `code` VALUES ('149', '350423', '清流县', 'BM_DISTRICT', '350400');
INSERT INTO `code` VALUES ('150', '350424', '宁化县', 'BM_DISTRICT', '350400');
INSERT INTO `code` VALUES ('151', '350425', '大田县', 'BM_DISTRICT', '350400');
INSERT INTO `code` VALUES ('152', '350426', '尤溪县', 'BM_DISTRICT', '350400');
INSERT INTO `code` VALUES ('153', '350427', '沙县', 'BM_DISTRICT', '350400');
INSERT INTO `code` VALUES ('154', '350428', '将乐县', 'BM_DISTRICT', '350400');
INSERT INTO `code` VALUES ('155', '350429', '泰宁县', 'BM_DISTRICT', '350400');
INSERT INTO `code` VALUES ('156', '350430', '建宁县', 'BM_DISTRICT', '350400');
INSERT INTO `code` VALUES ('157', '350481', '永安市', 'BM_DISTRICT', '350400');
INSERT INTO `code` VALUES ('158', '350500', '泉州市', 'BM_DISTRICT', '350000');
INSERT INTO `code` VALUES ('159', '350501', '市辖区', 'BM_DISTRICT', '350500');
INSERT INTO `code` VALUES ('160', '350502', '鲤城区', 'BM_DISTRICT', '350500');
INSERT INTO `code` VALUES ('161', '350503', '丰泽区', 'BM_DISTRICT', '350500');
INSERT INTO `code` VALUES ('162', '350504', '洛江区', 'BM_DISTRICT', '350500');
INSERT INTO `code` VALUES ('163', '350505', '泉港区', 'BM_DISTRICT', '350500');
INSERT INTO `code` VALUES ('164', '350521', '惠安县', 'BM_DISTRICT', '350500');
INSERT INTO `code` VALUES ('165', '350524', '安溪县', 'BM_DISTRICT', '350500');
INSERT INTO `code` VALUES ('166', '350525', '永春县', 'BM_DISTRICT', '350500');
INSERT INTO `code` VALUES ('167', '350526', '德化县', 'BM_DISTRICT', '350500');
INSERT INTO `code` VALUES ('168', '350527', '金门县', 'BM_DISTRICT', '350500');
INSERT INTO `code` VALUES ('169', '350581', '石狮市', 'BM_DISTRICT', '350500');
INSERT INTO `code` VALUES ('170', '350582', '晋江市', 'BM_DISTRICT', '350500');
INSERT INTO `code` VALUES ('171', '350583', '南安市', 'BM_DISTRICT', '350500');
INSERT INTO `code` VALUES ('172', '350600', '漳州市', 'BM_DISTRICT', '350000');
INSERT INTO `code` VALUES ('173', '350601', '市辖区', 'BM_DISTRICT', '350600');
INSERT INTO `code` VALUES ('174', '350602', '芗城区', 'BM_DISTRICT', '350600');
INSERT INTO `code` VALUES ('175', '350603', '龙文区', 'BM_DISTRICT', '350600');
INSERT INTO `code` VALUES ('176', '350622', '云霄县', 'BM_DISTRICT', '350600');
INSERT INTO `code` VALUES ('177', '350623', '漳浦县', 'BM_DISTRICT', '350600');
INSERT INTO `code` VALUES ('178', '350624', '诏安县', 'BM_DISTRICT', '350600');
INSERT INTO `code` VALUES ('179', '350625', '长泰县', 'BM_DISTRICT', '350600');
INSERT INTO `code` VALUES ('180', '350626', '东山县', 'BM_DISTRICT', '350600');
INSERT INTO `code` VALUES ('181', '350627', '南靖县', 'BM_DISTRICT', '350600');
INSERT INTO `code` VALUES ('182', '350628', '平和县', 'BM_DISTRICT', '350600');
INSERT INTO `code` VALUES ('183', '350629', '华安县', 'BM_DISTRICT', '350600');
INSERT INTO `code` VALUES ('184', '350681', '龙海市', 'BM_DISTRICT', '350600');
INSERT INTO `code` VALUES ('185', '350700', '南平市', 'BM_DISTRICT', '350000');
INSERT INTO `code` VALUES ('186', '350701', '市辖区', 'BM_DISTRICT', '350700');
INSERT INTO `code` VALUES ('187', '350702', '延平区', 'BM_DISTRICT', '350700');
INSERT INTO `code` VALUES ('188', '350721', '顺昌县', 'BM_DISTRICT', '350700');
INSERT INTO `code` VALUES ('189', '350722', '浦城县', 'BM_DISTRICT', '350700');
INSERT INTO `code` VALUES ('190', '350723', '光泽县', 'BM_DISTRICT', '350700');
INSERT INTO `code` VALUES ('191', '350724', '松溪县', 'BM_DISTRICT', '350700');
INSERT INTO `code` VALUES ('192', '350725', '政和县', 'BM_DISTRICT', '350700');
INSERT INTO `code` VALUES ('193', '350781', '邵武市', 'BM_DISTRICT', '350700');
INSERT INTO `code` VALUES ('194', '350782', '武夷山市', 'BM_DISTRICT', '350700');
INSERT INTO `code` VALUES ('195', '350783', '建瓯市', 'BM_DISTRICT', '350700');
INSERT INTO `code` VALUES ('196', '350784', '建阳市', 'BM_DISTRICT', '350700');
INSERT INTO `code` VALUES ('197', '350800', '龙岩市', 'BM_DISTRICT', '350000');
INSERT INTO `code` VALUES ('198', '350801', '市辖区', 'BM_DISTRICT', '350800');
INSERT INTO `code` VALUES ('199', '350802', '新罗区', 'BM_DISTRICT', '350800');
INSERT INTO `code` VALUES ('200', '350821', '长汀县', 'BM_DISTRICT', '350800');
INSERT INTO `code` VALUES ('201', '210212', '旅顺口区', 'BM_DISTRICT', '210200');
INSERT INTO `code` VALUES ('202', '210213', '金州区', 'BM_DISTRICT', '210200');
INSERT INTO `code` VALUES ('203', '210224', '长海县', 'BM_DISTRICT', '210200');
INSERT INTO `code` VALUES ('204', '210281', '瓦房店市', 'BM_DISTRICT', '210200');
INSERT INTO `code` VALUES ('205', '210282', '普兰店市', 'BM_DISTRICT', '210200');
INSERT INTO `code` VALUES ('206', '210283', '庄河市', 'BM_DISTRICT', '210200');
INSERT INTO `code` VALUES ('207', '210300', '鞍山市', 'BM_DISTRICT', '210000');
INSERT INTO `code` VALUES ('208', '210301', '市辖区', 'BM_DISTRICT', '210300');
INSERT INTO `code` VALUES ('209', '210302', '铁东区', 'BM_DISTRICT', '210300');
INSERT INTO `code` VALUES ('210', '210303', '铁西区', 'BM_DISTRICT', '210300');
INSERT INTO `code` VALUES ('211', '210304', '立山区', 'BM_DISTRICT', '210300');
INSERT INTO `code` VALUES ('212', '210311', '千山区', 'BM_DISTRICT', '210300');
INSERT INTO `code` VALUES ('213', '210321', '台安县', 'BM_DISTRICT', '210300');
INSERT INTO `code` VALUES ('214', '210323', '岫岩满族自治县', 'BM_DISTRICT', '210300');
INSERT INTO `code` VALUES ('215', '210381', '海城市', 'BM_DISTRICT', '210300');
INSERT INTO `code` VALUES ('216', '210400', '抚顺市', 'BM_DISTRICT', '210000');
INSERT INTO `code` VALUES ('217', '210401', '市辖区', 'BM_DISTRICT', '210400');
INSERT INTO `code` VALUES ('218', '210402', '新抚区', 'BM_DISTRICT', '210400');
INSERT INTO `code` VALUES ('219', '511621', '岳池县', 'BM_DISTRICT', '511600');
INSERT INTO `code` VALUES ('220', '511622', '武胜县', 'BM_DISTRICT', '511600');
INSERT INTO `code` VALUES ('221', '511623', '邻水县', 'BM_DISTRICT', '511600');
INSERT INTO `code` VALUES ('222', '511681', '华蓥市', 'BM_DISTRICT', '511600');
INSERT INTO `code` VALUES ('223', '511700', '达州市', 'BM_DISTRICT', '510000');
INSERT INTO `code` VALUES ('224', '511701', '市辖区', 'BM_DISTRICT', '511700');
INSERT INTO `code` VALUES ('225', '511702', '通川区', 'BM_DISTRICT', '511700');
INSERT INTO `code` VALUES ('226', '511721', '达县', 'BM_DISTRICT', '511700');
INSERT INTO `code` VALUES ('227', '511722', '宣汉县', 'BM_DISTRICT', '511700');
INSERT INTO `code` VALUES ('228', '511723', '开江县', 'BM_DISTRICT', '511700');
INSERT INTO `code` VALUES ('229', '511724', '大竹县', 'BM_DISTRICT', '511700');
INSERT INTO `code` VALUES ('230', '511725', '渠县', 'BM_DISTRICT', '511700');
INSERT INTO `code` VALUES ('231', '511781', '万源市', 'BM_DISTRICT', '511700');
INSERT INTO `code` VALUES ('232', '511800', '雅安市', 'BM_DISTRICT', '510000');
INSERT INTO `code` VALUES ('233', '511801', '市辖区', 'BM_DISTRICT', '511800');
INSERT INTO `code` VALUES ('234', '511802', '雨城区', 'BM_DISTRICT', '511800');
INSERT INTO `code` VALUES ('235', '511803', '名山区', 'BM_DISTRICT', '511800');
INSERT INTO `code` VALUES ('236', '511822', '荥经县', 'BM_DISTRICT', '511800');
INSERT INTO `code` VALUES ('237', '511823', '汉源县', 'BM_DISTRICT', '511800');
INSERT INTO `code` VALUES ('238', '532925', '弥渡县', 'BM_DISTRICT', '532900');
INSERT INTO `code` VALUES ('239', '532926', '南涧彝族自治县', 'BM_DISTRICT', '532900');
INSERT INTO `code` VALUES ('240', '620100', '兰州市', 'BM_DISTRICT', '620000');
INSERT INTO `code` VALUES ('241', '620101', '市辖区', 'BM_DISTRICT', '620100');
INSERT INTO `code` VALUES ('242', '620102', '城关区', 'BM_DISTRICT', '620100');
INSERT INTO `code` VALUES ('243', '620103', '七里河区', 'BM_DISTRICT', '620100');
INSERT INTO `code` VALUES ('244', '620104', '西固区', 'BM_DISTRICT', '620100');
INSERT INTO `code` VALUES ('245', '620105', '安宁区', 'BM_DISTRICT', '620100');
INSERT INTO `code` VALUES ('246', '620111', '红古区', 'BM_DISTRICT', '620100');
INSERT INTO `code` VALUES ('247', '620121', '永登县', 'BM_DISTRICT', '620100');
INSERT INTO `code` VALUES ('248', '620122', '皋兰县', 'BM_DISTRICT', '620100');
INSERT INTO `code` VALUES ('249', '620123', '榆中县', 'BM_DISTRICT', '620100');
INSERT INTO `code` VALUES ('250', '620200', '嘉峪关市', 'BM_DISTRICT', '620000');
INSERT INTO `code` VALUES ('251', '620201', '市辖区', 'BM_DISTRICT', '620200');
INSERT INTO `code` VALUES ('252', '620601', '市辖区', 'BM_DISTRICT', '620600');
INSERT INTO `code` VALUES ('253', '620602', '凉州区', 'BM_DISTRICT', '620600');
INSERT INTO `code` VALUES ('254', '620621', '民勤县', 'BM_DISTRICT', '620600');
INSERT INTO `code` VALUES ('255', '620622', '古浪县', 'BM_DISTRICT', '620600');
INSERT INTO `code` VALUES ('256', '620623', '天祝藏族自治县', 'BM_DISTRICT', '620600');
INSERT INTO `code` VALUES ('257', '620700', '张掖市', 'BM_DISTRICT', '620000');
INSERT INTO `code` VALUES ('258', '620701', '市辖区', 'BM_DISTRICT', '620700');
INSERT INTO `code` VALUES ('259', '620702', '甘州区', 'BM_DISTRICT', '620700');
INSERT INTO `code` VALUES ('260', '620721', '肃南裕固族自治县', 'BM_DISTRICT', '620700');
INSERT INTO `code` VALUES ('261', '620722', '民乐县', 'BM_DISTRICT', '620700');
INSERT INTO `code` VALUES ('262', '620723', '临泽县', 'BM_DISTRICT', '620700');
INSERT INTO `code` VALUES ('263', '620724', '高台县', 'BM_DISTRICT', '620700');
INSERT INTO `code` VALUES ('264', '620725', '山丹县', 'BM_DISTRICT', '620700');
INSERT INTO `code` VALUES ('265', '620800', '平凉市', 'BM_DISTRICT', '620000');
INSERT INTO `code` VALUES ('266', '620801', '市辖区', 'BM_DISTRICT', '620800');
INSERT INTO `code` VALUES ('267', '620802', '崆峒区', 'BM_DISTRICT', '620800');
INSERT INTO `code` VALUES ('268', '620821', '泾川县', 'BM_DISTRICT', '620800');
INSERT INTO `code` VALUES ('269', '620822', '灵台县', 'BM_DISTRICT', '620800');
INSERT INTO `code` VALUES ('270', '620823', '崇信县', 'BM_DISTRICT', '620800');
INSERT INTO `code` VALUES ('271', '620824', '华亭县', 'BM_DISTRICT', '620800');
INSERT INTO `code` VALUES ('272', '620825', '庄浪县', 'BM_DISTRICT', '620800');
INSERT INTO `code` VALUES ('273', '620826', '静宁县', 'BM_DISTRICT', '620800');
INSERT INTO `code` VALUES ('274', '620900', '酒泉市', 'BM_DISTRICT', '620000');
INSERT INTO `code` VALUES ('275', '620901', '市辖区', 'BM_DISTRICT', '620900');
INSERT INTO `code` VALUES ('276', '620902', '肃州区', 'BM_DISTRICT', '620900');
INSERT INTO `code` VALUES ('277', '620921', '金塔县', 'BM_DISTRICT', '620900');
INSERT INTO `code` VALUES ('278', '620922', '瓜州县', 'BM_DISTRICT', '620900');
INSERT INTO `code` VALUES ('279', '620923', '肃北蒙古族自治县', 'BM_DISTRICT', '620900');
INSERT INTO `code` VALUES ('280', '620924', '阿克塞哈萨克族自治县', 'BM_DISTRICT', '620900');
INSERT INTO `code` VALUES ('281', '620981', '玉门市', 'BM_DISTRICT', '620900');
INSERT INTO `code` VALUES ('282', '620982', '敦煌市', 'BM_DISTRICT', '620900');
INSERT INTO `code` VALUES ('283', '621000', '庆阳市', 'BM_DISTRICT', '620000');
INSERT INTO `code` VALUES ('284', '621001', '市辖区', 'BM_DISTRICT', '621000');
INSERT INTO `code` VALUES ('285', '621002', '西峰区', 'BM_DISTRICT', '621000');
INSERT INTO `code` VALUES ('286', '621021', '庆城县', 'BM_DISTRICT', '621000');
INSERT INTO `code` VALUES ('287', '621022', '环县', 'BM_DISTRICT', '621000');
INSERT INTO `code` VALUES ('288', '621023', '华池县', 'BM_DISTRICT', '621000');
INSERT INTO `code` VALUES ('289', '621024', '合水县', 'BM_DISTRICT', '621000');
INSERT INTO `code` VALUES ('290', '510903', '船山区', 'BM_DISTRICT', '510900');
INSERT INTO `code` VALUES ('291', '510904', '安居区', 'BM_DISTRICT', '510900');
INSERT INTO `code` VALUES ('292', '510921', '蓬溪县', 'BM_DISTRICT', '510900');
INSERT INTO `code` VALUES ('293', '510922', '射洪县', 'BM_DISTRICT', '510900');
INSERT INTO `code` VALUES ('294', '510923', '大英县', 'BM_DISTRICT', '510900');
INSERT INTO `code` VALUES ('295', '511000', '内江市', 'BM_DISTRICT', '510000');
INSERT INTO `code` VALUES ('296', '511001', '市辖区', 'BM_DISTRICT', '511000');
INSERT INTO `code` VALUES ('297', '511002', '市中区', 'BM_DISTRICT', '511000');
INSERT INTO `code` VALUES ('298', '511011', '东兴区', 'BM_DISTRICT', '511000');
INSERT INTO `code` VALUES ('299', '511024', '威远县', 'BM_DISTRICT', '511000');
INSERT INTO `code` VALUES ('300', '511025', '资中县', 'BM_DISTRICT', '511000');
INSERT INTO `code` VALUES ('301', '511028', '隆昌县', 'BM_DISTRICT', '511000');
INSERT INTO `code` VALUES ('302', '511100', '乐山市', 'BM_DISTRICT', '510000');
INSERT INTO `code` VALUES ('303', '511101', '市辖区', 'BM_DISTRICT', '511100');
INSERT INTO `code` VALUES ('304', '511102', '市中区', 'BM_DISTRICT', '511100');
INSERT INTO `code` VALUES ('305', '511111', '沙湾区', 'BM_DISTRICT', '511100');
INSERT INTO `code` VALUES ('306', '511112', '五通桥区', 'BM_DISTRICT', '511100');
INSERT INTO `code` VALUES ('307', '511113', '金口河区', 'BM_DISTRICT', '511100');
INSERT INTO `code` VALUES ('308', '530426', '峨山彝族自治县', 'BM_DISTRICT', '530400');
INSERT INTO `code` VALUES ('309', '530427', '新平彝族傣族自治县', 'BM_DISTRICT', '530400');
INSERT INTO `code` VALUES ('310', '530428', '元江哈尼族彝族傣族自治县', 'BM_DISTRICT', '530400');
INSERT INTO `code` VALUES ('311', '530500', '保山市', 'BM_DISTRICT', '530000');
INSERT INTO `code` VALUES ('312', '530501', '市辖区', 'BM_DISTRICT', '530500');
INSERT INTO `code` VALUES ('313', '530502', '隆阳区', 'BM_DISTRICT', '530500');
INSERT INTO `code` VALUES ('314', '530521', '施甸县', 'BM_DISTRICT', '530500');
INSERT INTO `code` VALUES ('315', '530522', '腾冲县', 'BM_DISTRICT', '530500');
INSERT INTO `code` VALUES ('316', '530523', '龙陵县', 'BM_DISTRICT', '530500');
INSERT INTO `code` VALUES ('317', '530524', '昌宁县', 'BM_DISTRICT', '530500');
INSERT INTO `code` VALUES ('318', '530600', '昭通市', 'BM_DISTRICT', '530000');
INSERT INTO `code` VALUES ('319', '530601', '市辖区', 'BM_DISTRICT', '530600');
INSERT INTO `code` VALUES ('320', '530602', '昭阳区', 'BM_DISTRICT', '530600');
INSERT INTO `code` VALUES ('321', '530621', '鲁甸县', 'BM_DISTRICT', '530600');
INSERT INTO `code` VALUES ('322', '530622', '巧家县', 'BM_DISTRICT', '530600');
INSERT INTO `code` VALUES ('323', '530623', '盐津县', 'BM_DISTRICT', '530600');
INSERT INTO `code` VALUES ('324', '530624', '大关县', 'BM_DISTRICT', '530600');
INSERT INTO `code` VALUES ('325', '530625', '永善县', 'BM_DISTRICT', '530600');
INSERT INTO `code` VALUES ('326', '530626', '绥江县', 'BM_DISTRICT', '530600');
INSERT INTO `code` VALUES ('327', '530627', '镇雄县', 'BM_DISTRICT', '530600');
INSERT INTO `code` VALUES ('328', '530628', '彝良县', 'BM_DISTRICT', '530600');
INSERT INTO `code` VALUES ('329', '530629', '威信县', 'BM_DISTRICT', '530600');
INSERT INTO `code` VALUES ('330', '530630', '水富县', 'BM_DISTRICT', '530600');
INSERT INTO `code` VALUES ('331', '530700', '丽江市', 'BM_DISTRICT', '530000');
INSERT INTO `code` VALUES ('332', '530701', '市辖区', 'BM_DISTRICT', '530700');
INSERT INTO `code` VALUES ('333', '530702', '古城区', 'BM_DISTRICT', '530700');
INSERT INTO `code` VALUES ('334', '530721', '玉龙纳西族自治县', 'BM_DISTRICT', '530700');
INSERT INTO `code` VALUES ('335', '530722', '永胜县', 'BM_DISTRICT', '530700');
INSERT INTO `code` VALUES ('336', '530723', '华坪县', 'BM_DISTRICT', '530700');
INSERT INTO `code` VALUES ('337', '530724', '宁蒗彝族自治县', 'BM_DISTRICT', '530700');
INSERT INTO `code` VALUES ('338', '530800', '普洱市', 'BM_DISTRICT', '530000');
INSERT INTO `code` VALUES ('339', '530801', '市辖区', 'BM_DISTRICT', '530800');
INSERT INTO `code` VALUES ('340', '530802', '思茅区', 'BM_DISTRICT', '530800');
INSERT INTO `code` VALUES ('341', '530821', '宁洱哈尼族彝族自治县', 'BM_DISTRICT', '530800');
INSERT INTO `code` VALUES ('342', '530822', '墨江哈尼族自治县', 'BM_DISTRICT', '530800');
INSERT INTO `code` VALUES ('343', '530823', '景东彝族自治县', 'BM_DISTRICT', '530800');
INSERT INTO `code` VALUES ('344', '530824', '景谷傣族彝族自治县', 'BM_DISTRICT', '530800');
INSERT INTO `code` VALUES ('345', '530825', '镇沅彝族哈尼族拉祜族自治县', 'BM_DISTRICT', '530800');
INSERT INTO `code` VALUES ('346', '530826', '江城哈尼族彝族自治县', 'BM_DISTRICT', '530800');
INSERT INTO `code` VALUES ('347', '530827', '孟连傣族拉祜族佤族自治县', 'BM_DISTRICT', '530800');
INSERT INTO `code` VALUES ('348', '530828', '澜沧拉祜族自治县', 'BM_DISTRICT', '530800');
INSERT INTO `code` VALUES ('349', '530829', '西盟佤族自治县', 'BM_DISTRICT', '530800');
INSERT INTO `code` VALUES ('350', '530900', '临沧市', 'BM_DISTRICT', '530000');
INSERT INTO `code` VALUES ('351', '530901', '市辖区', 'BM_DISTRICT', '530900');
INSERT INTO `code` VALUES ('352', '530902', '临翔区', 'BM_DISTRICT', '530900');
INSERT INTO `code` VALUES ('353', '530921', '凤庆县', 'BM_DISTRICT', '530900');
INSERT INTO `code` VALUES ('354', '530922', '云县', 'BM_DISTRICT', '530900');
INSERT INTO `code` VALUES ('355', '530923', '永德县', 'BM_DISTRICT', '530900');
INSERT INTO `code` VALUES ('356', '511126', '夹江县', 'BM_DISTRICT', '511100');
INSERT INTO `code` VALUES ('357', '511129', '沐川县', 'BM_DISTRICT', '511100');
INSERT INTO `code` VALUES ('358', '511132', '峨边彝族自治县', 'BM_DISTRICT', '511100');
INSERT INTO `code` VALUES ('359', '652823', '尉犁县', 'BM_DISTRICT', '652800');
INSERT INTO `code` VALUES ('360', '652824', '若羌县', 'BM_DISTRICT', '652800');
INSERT INTO `code` VALUES ('361', '652825', '且末县', 'BM_DISTRICT', '652800');
INSERT INTO `code` VALUES ('362', '652826', '焉耆回族自治县', 'BM_DISTRICT', '652800');
INSERT INTO `code` VALUES ('363', '652827', '和静县', 'BM_DISTRICT', '652800');
INSERT INTO `code` VALUES ('364', '652828', '和硕县', 'BM_DISTRICT', '652800');
INSERT INTO `code` VALUES ('365', '652829', '博湖县', 'BM_DISTRICT', '652800');
INSERT INTO `code` VALUES ('366', '652900', '阿克苏地区', 'BM_DISTRICT', '650000');
INSERT INTO `code` VALUES ('367', '652901', '阿克苏市', 'BM_DISTRICT', '652900');
INSERT INTO `code` VALUES ('368', '652922', '温宿县', 'BM_DISTRICT', '652900');
INSERT INTO `code` VALUES ('369', '652923', '库车县', 'BM_DISTRICT', '652900');
INSERT INTO `code` VALUES ('370', '652924', '沙雅县', 'BM_DISTRICT', '652900');
INSERT INTO `code` VALUES ('371', '652925', '新和县', 'BM_DISTRICT', '652900');
INSERT INTO `code` VALUES ('372', '652926', '拜城县', 'BM_DISTRICT', '652900');
INSERT INTO `code` VALUES ('373', '652927', '乌什县', 'BM_DISTRICT', '652900');
INSERT INTO `code` VALUES ('374', '652928', '阿瓦提县', 'BM_DISTRICT', '652900');
INSERT INTO `code` VALUES ('375', '652929', '柯坪县', 'BM_DISTRICT', '652900');
INSERT INTO `code` VALUES ('376', '653000', '克孜勒苏柯尔克孜自治州', 'BM_DISTRICT', '650000');
INSERT INTO `code` VALUES ('377', '441323', '惠东县', 'BM_DISTRICT', '441300');
INSERT INTO `code` VALUES ('378', '441324', '龙门县', 'BM_DISTRICT', '441300');
INSERT INTO `code` VALUES ('379', '441400', '梅州市', 'BM_DISTRICT', '440000');
INSERT INTO `code` VALUES ('380', '441401', '市辖区', 'BM_DISTRICT', '441400');
INSERT INTO `code` VALUES ('381', '441402', '梅江区', 'BM_DISTRICT', '441400');
INSERT INTO `code` VALUES ('382', '513434', '越西县', 'BM_DISTRICT', '513400');
INSERT INTO `code` VALUES ('383', '513435', '甘洛县', 'BM_DISTRICT', '513400');
INSERT INTO `code` VALUES ('384', '513436', '美姑县', 'BM_DISTRICT', '513400');
INSERT INTO `code` VALUES ('385', '513437', '雷波县', 'BM_DISTRICT', '513400');
INSERT INTO `code` VALUES ('386', '520000', '贵州省', 'BM_DISTRICT', null);
INSERT INTO `code` VALUES ('387', '520100', '贵阳市', 'BM_DISTRICT', '520000');
INSERT INTO `code` VALUES ('388', '520101', '市辖区', 'BM_DISTRICT', '520100');
INSERT INTO `code` VALUES ('389', '520102', '南明区', 'BM_DISTRICT', '520100');
INSERT INTO `code` VALUES ('390', '520103', '云岩区', 'BM_DISTRICT', '520100');
INSERT INTO `code` VALUES ('391', '520111', '花溪区', 'BM_DISTRICT', '520100');
INSERT INTO `code` VALUES ('392', '520112', '乌当区', 'BM_DISTRICT', '520100');
INSERT INTO `code` VALUES ('393', '520113', '白云区', 'BM_DISTRICT', '520100');
INSERT INTO `code` VALUES ('394', '520114', '小河区', 'BM_DISTRICT', '520100');
INSERT INTO `code` VALUES ('395', '520121', '开阳县', 'BM_DISTRICT', '520100');
INSERT INTO `code` VALUES ('396', '520122', '息烽县', 'BM_DISTRICT', '520100');
INSERT INTO `code` VALUES ('397', '520123', '修文县', 'BM_DISTRICT', '520100');
INSERT INTO `code` VALUES ('398', '520181', '清镇市', 'BM_DISTRICT', '520100');
INSERT INTO `code` VALUES ('399', '520200', '六盘水市', 'BM_DISTRICT', '520000');
INSERT INTO `code` VALUES ('400', '520201', '钟山区', 'BM_DISTRICT', '520200');
INSERT INTO `code` VALUES ('401', '520203', '六枝特区', 'BM_DISTRICT', '520200');
INSERT INTO `code` VALUES ('402', '520221', '水城县', 'BM_DISTRICT', '520200');
INSERT INTO `code` VALUES ('403', '520222', '盘县', 'BM_DISTRICT', '520200');
INSERT INTO `code` VALUES ('404', '520300', '遵义市', 'BM_DISTRICT', '520000');
INSERT INTO `code` VALUES ('405', '520301', '市辖区', 'BM_DISTRICT', '520300');
INSERT INTO `code` VALUES ('406', '520302', '红花岗区', 'BM_DISTRICT', '520300');
INSERT INTO `code` VALUES ('407', '520303', '汇川区', 'BM_DISTRICT', '520300');
INSERT INTO `code` VALUES ('408', '520321', '遵义县', 'BM_DISTRICT', '520300');
INSERT INTO `code` VALUES ('409', '520322', '桐梓县', 'BM_DISTRICT', '520300');
INSERT INTO `code` VALUES ('410', '520323', '绥阳县', 'BM_DISTRICT', '520300');
INSERT INTO `code` VALUES ('411', '520324', '正安县', 'BM_DISTRICT', '520300');
INSERT INTO `code` VALUES ('412', '520325', '道真仡佬族苗族自治县', 'BM_DISTRICT', '520300');
INSERT INTO `code` VALUES ('413', '520326', '务川仡佬族苗族自治县', 'BM_DISTRICT', '520300');
INSERT INTO `code` VALUES ('414', '520327', '凤冈县', 'BM_DISTRICT', '520300');
INSERT INTO `code` VALUES ('415', '520328', '湄潭县', 'BM_DISTRICT', '520300');
INSERT INTO `code` VALUES ('416', '520329', '余庆县', 'BM_DISTRICT', '520300');
INSERT INTO `code` VALUES ('417', '520330', '习水县', 'BM_DISTRICT', '520300');
INSERT INTO `code` VALUES ('418', '632221', '门源回族自治县', 'BM_DISTRICT', '632200');
INSERT INTO `code` VALUES ('419', '632222', '祁连县', 'BM_DISTRICT', '632200');
INSERT INTO `code` VALUES ('420', '632223', '海晏县', 'BM_DISTRICT', '632200');
INSERT INTO `code` VALUES ('421', '632224', '刚察县', 'BM_DISTRICT', '632200');
INSERT INTO `code` VALUES ('422', '632300', '黄南藏族自治州', 'BM_DISTRICT', '630000');
INSERT INTO `code` VALUES ('423', '632321', '同仁县', 'BM_DISTRICT', '632300');
INSERT INTO `code` VALUES ('424', '632322', '尖扎县', 'BM_DISTRICT', '632300');
INSERT INTO `code` VALUES ('425', '632323', '泽库县', 'BM_DISTRICT', '632300');
INSERT INTO `code` VALUES ('426', '632324', '河南蒙古族自治县', 'BM_DISTRICT', '632300');
INSERT INTO `code` VALUES ('427', '632500', '海南藏族自治州', 'BM_DISTRICT', '630000');
INSERT INTO `code` VALUES ('428', '632521', '共和县', 'BM_DISTRICT', '632500');
INSERT INTO `code` VALUES ('429', '632522', '同德县', 'BM_DISTRICT', '632500');
INSERT INTO `code` VALUES ('430', '632523', '贵德县', 'BM_DISTRICT', '632500');
INSERT INTO `code` VALUES ('431', '632524', '兴海县', 'BM_DISTRICT', '632500');
INSERT INTO `code` VALUES ('432', '632525', '贵南县', 'BM_DISTRICT', '632500');
INSERT INTO `code` VALUES ('433', '632600', '果洛藏族自治州', 'BM_DISTRICT', '630000');
INSERT INTO `code` VALUES ('434', '632621', '玛沁县', 'BM_DISTRICT', '632600');
INSERT INTO `code` VALUES ('435', '632622', '班玛县', 'BM_DISTRICT', '632600');
INSERT INTO `code` VALUES ('436', '632623', '甘德县', 'BM_DISTRICT', '632600');
INSERT INTO `code` VALUES ('437', '632624', '达日县', 'BM_DISTRICT', '632600');
INSERT INTO `code` VALUES ('438', '632625', '久治县', 'BM_DISTRICT', '632600');
INSERT INTO `code` VALUES ('439', '632626', '玛多县', 'BM_DISTRICT', '632600');
INSERT INTO `code` VALUES ('440', '632700', '玉树藏族自治州', 'BM_DISTRICT', '630000');
INSERT INTO `code` VALUES ('441', '511133', '马边彝族自治县', 'BM_DISTRICT', '511100');
INSERT INTO `code` VALUES ('442', '511181', '峨眉山市', 'BM_DISTRICT', '511100');
INSERT INTO `code` VALUES ('443', '511300', '南充市', 'BM_DISTRICT', '510000');
INSERT INTO `code` VALUES ('444', '511301', '市辖区', 'BM_DISTRICT', '511300');
INSERT INTO `code` VALUES ('445', '511302', '顺庆区', 'BM_DISTRICT', '511300');
INSERT INTO `code` VALUES ('446', '511303', '高坪区', 'BM_DISTRICT', '511300');
INSERT INTO `code` VALUES ('447', '511304', '嘉陵区', 'BM_DISTRICT', '511300');
INSERT INTO `code` VALUES ('448', '511321', '南部县', 'BM_DISTRICT', '511300');
INSERT INTO `code` VALUES ('449', '511322', '营山县', 'BM_DISTRICT', '511300');
INSERT INTO `code` VALUES ('450', '511323', '蓬安县', 'BM_DISTRICT', '511300');
INSERT INTO `code` VALUES ('451', '511324', '仪陇县', 'BM_DISTRICT', '511300');
INSERT INTO `code` VALUES ('452', '511325', '西充县', 'BM_DISTRICT', '511300');
INSERT INTO `code` VALUES ('453', '511381', '阆中市', 'BM_DISTRICT', '511300');
INSERT INTO `code` VALUES ('454', '511400', '眉山市', 'BM_DISTRICT', '510000');
INSERT INTO `code` VALUES ('455', '511401', '市辖区', 'BM_DISTRICT', '511400');
INSERT INTO `code` VALUES ('456', '511402', '东坡区', 'BM_DISTRICT', '511400');
INSERT INTO `code` VALUES ('457', '511421', '仁寿县', 'BM_DISTRICT', '511400');
INSERT INTO `code` VALUES ('458', '511422', '彭山县', 'BM_DISTRICT', '511400');
INSERT INTO `code` VALUES ('459', '511423', '洪雅县', 'BM_DISTRICT', '511400');
INSERT INTO `code` VALUES ('460', '511424', '丹棱县', 'BM_DISTRICT', '511400');
INSERT INTO `code` VALUES ('461', '511425', '青神县', 'BM_DISTRICT', '511400');
INSERT INTO `code` VALUES ('462', '511500', '宜宾市', 'BM_DISTRICT', '510000');
INSERT INTO `code` VALUES ('463', '511501', '市辖区', 'BM_DISTRICT', '511500');
INSERT INTO `code` VALUES ('464', '511502', '翠屏区', 'BM_DISTRICT', '511500');
INSERT INTO `code` VALUES ('465', '511503', '南溪区', 'BM_DISTRICT', '511500');
INSERT INTO `code` VALUES ('466', '511521', '宜宾县', 'BM_DISTRICT', '511500');
INSERT INTO `code` VALUES ('467', '511523', '江安县', 'BM_DISTRICT', '511500');
INSERT INTO `code` VALUES ('468', '511524', '长宁县', 'BM_DISTRICT', '511500');
INSERT INTO `code` VALUES ('469', '511525', '高县', 'BM_DISTRICT', '511500');
INSERT INTO `code` VALUES ('470', '511526', '珙县', 'BM_DISTRICT', '511500');
INSERT INTO `code` VALUES ('471', '511527', '筠连县', 'BM_DISTRICT', '511500');
INSERT INTO `code` VALUES ('472', '511528', '兴文县', 'BM_DISTRICT', '511500');
INSERT INTO `code` VALUES ('473', '511529', '屏山县', 'BM_DISTRICT', '511500');
INSERT INTO `code` VALUES ('474', '511600', '广安市', 'BM_DISTRICT', '510000');
INSERT INTO `code` VALUES ('475', '511601', '市辖区', 'BM_DISTRICT', '511600');
INSERT INTO `code` VALUES ('476', '511602', '广安区', 'BM_DISTRICT', '511600');
INSERT INTO `code` VALUES ('477', '330782', '义乌市', 'BM_DISTRICT', '330700');
INSERT INTO `code` VALUES ('478', '330783', '东阳市', 'BM_DISTRICT', '330700');
INSERT INTO `code` VALUES ('479', '330784', '永康市', 'BM_DISTRICT', '330700');
INSERT INTO `code` VALUES ('480', '340600', '淮北市', 'BM_DISTRICT', '340000');
INSERT INTO `code` VALUES ('481', '340601', '市辖区', 'BM_DISTRICT', '340600');
INSERT INTO `code` VALUES ('482', '340602', '杜集区', 'BM_DISTRICT', '340600');
INSERT INTO `code` VALUES ('483', '340603', '相山区', 'BM_DISTRICT', '340600');
INSERT INTO `code` VALUES ('484', '431301', '市辖区', 'BM_DISTRICT', '431300');
INSERT INTO `code` VALUES ('485', '431302', '娄星区', 'BM_DISTRICT', '431300');
INSERT INTO `code` VALUES ('486', '431321', '双峰县', 'BM_DISTRICT', '431300');
INSERT INTO `code` VALUES ('487', '431322', '新化县', 'BM_DISTRICT', '431300');
INSERT INTO `code` VALUES ('488', '431381', '冷水江市', 'BM_DISTRICT', '431300');
INSERT INTO `code` VALUES ('489', '431382', '涟源市', 'BM_DISTRICT', '431300');
INSERT INTO `code` VALUES ('490', '433100', '湘西土家族苗族自治州', 'BM_DISTRICT', '430000');
INSERT INTO `code` VALUES ('491', '433101', '吉首市', 'BM_DISTRICT', '433100');
INSERT INTO `code` VALUES ('492', '433122', '泸溪县', 'BM_DISTRICT', '433100');
INSERT INTO `code` VALUES ('493', '433123', '凤凰县', 'BM_DISTRICT', '433100');
INSERT INTO `code` VALUES ('494', '433124', '花垣县', 'BM_DISTRICT', '433100');
INSERT INTO `code` VALUES ('495', '433125', '保靖县', 'BM_DISTRICT', '433100');
INSERT INTO `code` VALUES ('496', '433126', '古丈县', 'BM_DISTRICT', '433100');
INSERT INTO `code` VALUES ('497', '433127', '永顺县', 'BM_DISTRICT', '433100');
INSERT INTO `code` VALUES ('498', '433130', '龙山县', 'BM_DISTRICT', '433100');
INSERT INTO `code` VALUES ('499', '440000', '广东省', 'BM_DISTRICT', null);
INSERT INTO `code` VALUES ('500', '440100', '广州市', 'BM_DISTRICT', '440000');
INSERT INTO `code` VALUES ('501', '440101', '市辖区', 'BM_DISTRICT', '440100');
INSERT INTO `code` VALUES ('502', '440103', '荔湾区', 'BM_DISTRICT', '440100');
INSERT INTO `code` VALUES ('503', '440104', '越秀区', 'BM_DISTRICT', '440100');
INSERT INTO `code` VALUES ('504', '440105', '海珠区', 'BM_DISTRICT', '440100');
INSERT INTO `code` VALUES ('505', '440106', '天河区', 'BM_DISTRICT', '440100');
INSERT INTO `code` VALUES ('506', '440111', '白云区', 'BM_DISTRICT', '440100');
INSERT INTO `code` VALUES ('507', '440112', '黄埔区', 'BM_DISTRICT', '440100');
INSERT INTO `code` VALUES ('508', '440113', '番禺区', 'BM_DISTRICT', '440100');
INSERT INTO `code` VALUES ('509', '440114', '花都区', 'BM_DISTRICT', '440100');
INSERT INTO `code` VALUES ('510', '440115', '南沙区', 'BM_DISTRICT', '440100');
INSERT INTO `code` VALUES ('511', '440116', '萝岗区', 'BM_DISTRICT', '440100');
INSERT INTO `code` VALUES ('512', '440183', '增城市', 'BM_DISTRICT', '440100');
INSERT INTO `code` VALUES ('513', '440184', '从化市', 'BM_DISTRICT', '440100');
INSERT INTO `code` VALUES ('514', '440200', '韶关市', 'BM_DISTRICT', '440000');
INSERT INTO `code` VALUES ('515', '440201', '市辖区', 'BM_DISTRICT', '440200');
INSERT INTO `code` VALUES ('516', '440203', '武江区', 'BM_DISTRICT', '440200');
INSERT INTO `code` VALUES ('517', '440204', '浈江区', 'BM_DISTRICT', '440200');
INSERT INTO `code` VALUES ('518', '440205', '曲江区', 'BM_DISTRICT', '440200');
INSERT INTO `code` VALUES ('519', '440222', '始兴县', 'BM_DISTRICT', '440200');
INSERT INTO `code` VALUES ('520', '440224', '仁化县', 'BM_DISTRICT', '440200');
INSERT INTO `code` VALUES ('521', '440229', '翁源县', 'BM_DISTRICT', '440200');
INSERT INTO `code` VALUES ('522', '440232', '乳源瑶族自治县', 'BM_DISTRICT', '440200');
INSERT INTO `code` VALUES ('523', '440233', '新丰县', 'BM_DISTRICT', '440200');
INSERT INTO `code` VALUES ('524', '440281', '乐昌市', 'BM_DISTRICT', '440200');
INSERT INTO `code` VALUES ('525', '440282', '南雄市', 'BM_DISTRICT', '440200');
INSERT INTO `code` VALUES ('526', '440300', '深圳市', 'BM_DISTRICT', '440000');
INSERT INTO `code` VALUES ('527', '440301', '市辖区', 'BM_DISTRICT', '440300');
INSERT INTO `code` VALUES ('528', '440303', '罗湖区', 'BM_DISTRICT', '440300');
INSERT INTO `code` VALUES ('529', '440304', '福田区', 'BM_DISTRICT', '440300');
INSERT INTO `code` VALUES ('530', '440305', '南山区', 'BM_DISTRICT', '440300');
INSERT INTO `code` VALUES ('531', '440306', '宝安区', 'BM_DISTRICT', '440300');
INSERT INTO `code` VALUES ('532', '440307', '龙岗区', 'BM_DISTRICT', '440300');
INSERT INTO `code` VALUES ('533', '440308', '盐田区', 'BM_DISTRICT', '440300');
INSERT INTO `code` VALUES ('534', '440400', '珠海市', 'BM_DISTRICT', '440000');
INSERT INTO `code` VALUES ('535', '440401', '市辖区', 'BM_DISTRICT', '440400');
INSERT INTO `code` VALUES ('536', '440402', '香洲区', 'BM_DISTRICT', '440400');
INSERT INTO `code` VALUES ('537', '440403', '斗门区', 'BM_DISTRICT', '440400');
INSERT INTO `code` VALUES ('538', '440404', '金湾区', 'BM_DISTRICT', '440400');
INSERT INTO `code` VALUES ('539', '500104', '大渡口区', 'BM_DISTRICT', '500100');
INSERT INTO `code` VALUES ('540', '500105', '江北区', 'BM_DISTRICT', '500100');
INSERT INTO `code` VALUES ('541', '500106', '沙坪坝区', 'BM_DISTRICT', '500100');
INSERT INTO `code` VALUES ('542', '141022', '翼城县', 'BM_DISTRICT', '141000');
INSERT INTO `code` VALUES ('543', '141023', '襄汾县', 'BM_DISTRICT', '141000');
INSERT INTO `code` VALUES ('544', '141024', '洪洞县', 'BM_DISTRICT', '141000');
INSERT INTO `code` VALUES ('545', '141025', '古县', 'BM_DISTRICT', '141000');
INSERT INTO `code` VALUES ('546', '141026', '安泽县', 'BM_DISTRICT', '141000');
INSERT INTO `code` VALUES ('547', '141027', '浮山县', 'BM_DISTRICT', '141000');
INSERT INTO `code` VALUES ('548', '141028', '吉县', 'BM_DISTRICT', '141000');
INSERT INTO `code` VALUES ('549', '141029', '乡宁县', 'BM_DISTRICT', '141000');
INSERT INTO `code` VALUES ('550', '141030', '大宁县', 'BM_DISTRICT', '141000');
INSERT INTO `code` VALUES ('551', '141031', '隰县', 'BM_DISTRICT', '141000');
INSERT INTO `code` VALUES ('552', '141032', '永和县', 'BM_DISTRICT', '141000');
INSERT INTO `code` VALUES ('553', '141033', '蒲县', 'BM_DISTRICT', '141000');
INSERT INTO `code` VALUES ('554', '141034', '汾西县', 'BM_DISTRICT', '141000');
INSERT INTO `code` VALUES ('555', '141081', '侯马市', 'BM_DISTRICT', '141000');
INSERT INTO `code` VALUES ('556', '141082', '霍州市', 'BM_DISTRICT', '141000');
INSERT INTO `code` VALUES ('557', '141100', '吕梁市', 'BM_DISTRICT', '140000');
INSERT INTO `code` VALUES ('558', '141101', '市辖区', 'BM_DISTRICT', '141100');
INSERT INTO `code` VALUES ('559', '141102', '离石区', 'BM_DISTRICT', '141100');
INSERT INTO `code` VALUES ('560', '141121', '文水县', 'BM_DISTRICT', '141100');
INSERT INTO `code` VALUES ('561', '141122', '交城县', 'BM_DISTRICT', '141100');
INSERT INTO `code` VALUES ('562', '141123', '兴县', 'BM_DISTRICT', '141100');
INSERT INTO `code` VALUES ('563', '141124', '临县', 'BM_DISTRICT', '141100');
INSERT INTO `code` VALUES ('564', '141125', '柳林县', 'BM_DISTRICT', '141100');
INSERT INTO `code` VALUES ('565', '141126', '石楼县', 'BM_DISTRICT', '141100');
INSERT INTO `code` VALUES ('566', '141127', '岚县', 'BM_DISTRICT', '141100');
INSERT INTO `code` VALUES ('567', '141128', '方山县', 'BM_DISTRICT', '141100');
INSERT INTO `code` VALUES ('568', '141129', '中阳县', 'BM_DISTRICT', '141100');
INSERT INTO `code` VALUES ('569', '141130', '交口县', 'BM_DISTRICT', '141100');
INSERT INTO `code` VALUES ('570', '141181', '孝义市', 'BM_DISTRICT', '141100');
INSERT INTO `code` VALUES ('571', '141182', '汾阳市', 'BM_DISTRICT', '141100');
INSERT INTO `code` VALUES ('572', '150000', '内蒙古自治区', 'BM_DISTRICT', null);
INSERT INTO `code` VALUES ('573', '150100', '呼和浩特市', 'BM_DISTRICT', '150000');
INSERT INTO `code` VALUES ('574', '150101', '市辖区', 'BM_DISTRICT', '150100');
INSERT INTO `code` VALUES ('575', '150102', '新城区', 'BM_DISTRICT', '150100');
INSERT INTO `code` VALUES ('576', '150103', '回民区', 'BM_DISTRICT', '150100');
INSERT INTO `code` VALUES ('577', '150104', '玉泉区', 'BM_DISTRICT', '150100');
INSERT INTO `code` VALUES ('578', '150105', '赛罕区', 'BM_DISTRICT', '150100');
INSERT INTO `code` VALUES ('579', '150121', '土默特左旗', 'BM_DISTRICT', '150100');
INSERT INTO `code` VALUES ('580', '150122', '托克托县', 'BM_DISTRICT', '150100');
INSERT INTO `code` VALUES ('581', '150123', '和林格尔县', 'BM_DISTRICT', '150100');
INSERT INTO `code` VALUES ('582', '150124', '清水河县', 'BM_DISTRICT', '150100');
INSERT INTO `code` VALUES ('583', '150125', '武川县', 'BM_DISTRICT', '150100');
INSERT INTO `code` VALUES ('584', '150200', '包头市', 'BM_DISTRICT', '150000');
INSERT INTO `code` VALUES ('585', '150201', '市辖区', 'BM_DISTRICT', '150200');
INSERT INTO `code` VALUES ('586', '150202', '东河区', 'BM_DISTRICT', '150200');
INSERT INTO `code` VALUES ('587', '150203', '昆都仑区', 'BM_DISTRICT', '150200');
INSERT INTO `code` VALUES ('588', '150204', '青山区', 'BM_DISTRICT', '150200');
INSERT INTO `code` VALUES ('589', '150205', '石拐区', 'BM_DISTRICT', '150200');
INSERT INTO `code` VALUES ('590', '150206', '白云鄂博矿区', 'BM_DISTRICT', '150200');
INSERT INTO `code` VALUES ('591', '150207', '九原区', 'BM_DISTRICT', '150200');
INSERT INTO `code` VALUES ('592', '150221', '土默特右旗', 'BM_DISTRICT', '150200');
INSERT INTO `code` VALUES ('593', '150222', '固阳县', 'BM_DISTRICT', '150200');
INSERT INTO `code` VALUES ('594', '150223', '达尔罕茂明安联合旗', 'BM_DISTRICT', '150200');
INSERT INTO `code` VALUES ('595', '150300', '乌海市', 'BM_DISTRICT', '150000');
INSERT INTO `code` VALUES ('596', '150301', '市辖区', 'BM_DISTRICT', '150300');
INSERT INTO `code` VALUES ('597', '360600', '鹰潭市', 'BM_DISTRICT', '360000');
INSERT INTO `code` VALUES ('598', '360601', '市辖区', 'BM_DISTRICT', '360600');
INSERT INTO `code` VALUES ('599', '360602', '月湖区', 'BM_DISTRICT', '360600');
INSERT INTO `code` VALUES ('600', '532325', '姚安县', 'BM_DISTRICT', '532300');
INSERT INTO `code` VALUES ('601', '532326', '大姚县', 'BM_DISTRICT', '532300');
INSERT INTO `code` VALUES ('602', '532327', '永仁县', 'BM_DISTRICT', '532300');
INSERT INTO `code` VALUES ('603', '532328', '元谋县', 'BM_DISTRICT', '532300');
INSERT INTO `code` VALUES ('604', '532329', '武定县', 'BM_DISTRICT', '532300');
INSERT INTO `code` VALUES ('605', '532331', '禄丰县', 'BM_DISTRICT', '532300');
INSERT INTO `code` VALUES ('606', '532500', '红河哈尼族彝族自治州', 'BM_DISTRICT', '530000');
INSERT INTO `code` VALUES ('607', '532501', '个旧市', 'BM_DISTRICT', '532500');
INSERT INTO `code` VALUES ('608', '532502', '开远市', 'BM_DISTRICT', '532500');
INSERT INTO `code` VALUES ('609', '532503', '蒙自市', 'BM_DISTRICT', '532500');
INSERT INTO `code` VALUES ('610', '532523', '屏边苗族自治县', 'BM_DISTRICT', '532500');
INSERT INTO `code` VALUES ('611', '532524', '建水县', 'BM_DISTRICT', '532500');
INSERT INTO `code` VALUES ('612', '532525', '石屏县', 'BM_DISTRICT', '532500');
INSERT INTO `code` VALUES ('613', '532526', '弥勒县', 'BM_DISTRICT', '532500');
INSERT INTO `code` VALUES ('614', '532527', '泸西县', 'BM_DISTRICT', '532500');
INSERT INTO `code` VALUES ('615', '532528', '元阳县', 'BM_DISTRICT', '532500');
INSERT INTO `code` VALUES ('616', '532529', '红河县', 'BM_DISTRICT', '532500');
INSERT INTO `code` VALUES ('617', '532530', '金平苗族瑶族傣族自治县', 'BM_DISTRICT', '532500');
INSERT INTO `code` VALUES ('618', '532531', '绿春县', 'BM_DISTRICT', '532500');
INSERT INTO `code` VALUES ('619', '532532', '河口瑶族自治县', 'BM_DISTRICT', '532500');
INSERT INTO `code` VALUES ('620', '532600', '文山壮族苗族自治州', 'BM_DISTRICT', '530000');
INSERT INTO `code` VALUES ('621', '532601', '文山市', 'BM_DISTRICT', '532600');
INSERT INTO `code` VALUES ('622', '532622', '砚山县', 'BM_DISTRICT', '532600');
INSERT INTO `code` VALUES ('623', '532623', '西畴县', 'BM_DISTRICT', '532600');
INSERT INTO `code` VALUES ('624', '532624', '麻栗坡县', 'BM_DISTRICT', '532600');
INSERT INTO `code` VALUES ('625', '532625', '马关县', 'BM_DISTRICT', '532600');
INSERT INTO `code` VALUES ('626', '532626', '丘北县', 'BM_DISTRICT', '532600');
INSERT INTO `code` VALUES ('627', '532627', '广南县', 'BM_DISTRICT', '532600');
INSERT INTO `code` VALUES ('628', '532628', '富宁县', 'BM_DISTRICT', '532600');
INSERT INTO `code` VALUES ('629', '532800', '西双版纳傣族自治州', 'BM_DISTRICT', '530000');
INSERT INTO `code` VALUES ('630', '532801', '景洪市', 'BM_DISTRICT', '532800');
INSERT INTO `code` VALUES ('631', '532822', '勐海县', 'BM_DISTRICT', '532800');
INSERT INTO `code` VALUES ('632', '532823', '勐腊县', 'BM_DISTRICT', '532800');
INSERT INTO `code` VALUES ('633', '532900', '大理白族自治州', 'BM_DISTRICT', '530000');
INSERT INTO `code` VALUES ('634', '532901', '大理市', 'BM_DISTRICT', '532900');
INSERT INTO `code` VALUES ('635', '532922', '漾濞彝族自治县', 'BM_DISTRICT', '532900');
INSERT INTO `code` VALUES ('636', '532923', '祥云县', 'BM_DISTRICT', '532900');
INSERT INTO `code` VALUES ('637', '532924', '宾川县', 'BM_DISTRICT', '532900');
INSERT INTO `code` VALUES ('638', '542527', '措勤县', 'BM_DISTRICT', '542500');
INSERT INTO `code` VALUES ('639', '542600', '林芝地区', 'BM_DISTRICT', '540000');
INSERT INTO `code` VALUES ('640', '530924', '镇康县', 'BM_DISTRICT', '530900');
INSERT INTO `code` VALUES ('641', '530925', '双江拉祜族佤族布朗族傣族自治县', 'BM_DISTRICT', '530900');
INSERT INTO `code` VALUES ('642', '530926', '耿马傣族佤族自治县', 'BM_DISTRICT', '530900');
INSERT INTO `code` VALUES ('643', '530927', '沧源佤族自治县', 'BM_DISTRICT', '530900');
INSERT INTO `code` VALUES ('644', '532300', '楚雄彝族自治州', 'BM_DISTRICT', '530000');
INSERT INTO `code` VALUES ('645', '532301', '楚雄市', 'BM_DISTRICT', '532300');
INSERT INTO `code` VALUES ('646', '532322', '双柏县', 'BM_DISTRICT', '532300');
INSERT INTO `code` VALUES ('647', '532323', '牟定县', 'BM_DISTRICT', '532300');
INSERT INTO `code` VALUES ('648', '532324', '南华县', 'BM_DISTRICT', '532300');
INSERT INTO `code` VALUES ('649', '653001', '阿图什市', 'BM_DISTRICT', '653000');
INSERT INTO `code` VALUES ('650', '653022', '阿克陶县', 'BM_DISTRICT', '653000');
INSERT INTO `code` VALUES ('651', '653023', '阿合奇县', 'BM_DISTRICT', '653000');
INSERT INTO `code` VALUES ('652', '653024', '乌恰县', 'BM_DISTRICT', '653000');
INSERT INTO `code` VALUES ('653', '653100', '喀什地区', 'BM_DISTRICT', '650000');
INSERT INTO `code` VALUES ('654', '653101', '喀什市', 'BM_DISTRICT', '653100');
INSERT INTO `code` VALUES ('655', '653121', '疏附县', 'BM_DISTRICT', '653100');
INSERT INTO `code` VALUES ('656', '653122', '疏勒县', 'BM_DISTRICT', '653100');
INSERT INTO `code` VALUES ('657', '653123', '英吉沙县', 'BM_DISTRICT', '653100');
INSERT INTO `code` VALUES ('658', '653124', '泽普县', 'BM_DISTRICT', '653100');
INSERT INTO `code` VALUES ('659', '653125', '莎车县', 'BM_DISTRICT', '653100');
INSERT INTO `code` VALUES ('660', '653126', '叶城县', 'BM_DISTRICT', '653100');
INSERT INTO `code` VALUES ('661', '653127', '麦盖提县', 'BM_DISTRICT', '653100');
INSERT INTO `code` VALUES ('662', '653128', '岳普湖县', 'BM_DISTRICT', '653100');
INSERT INTO `code` VALUES ('663', '653129', '伽师县', 'BM_DISTRICT', '653100');
INSERT INTO `code` VALUES ('664', '653130', '巴楚县', 'BM_DISTRICT', '653100');
INSERT INTO `code` VALUES ('665', '653131', '塔什库尔干塔吉克自治县', 'BM_DISTRICT', '653100');
INSERT INTO `code` VALUES ('666', '653200', '和田地区', 'BM_DISTRICT', '650000');
INSERT INTO `code` VALUES ('667', '653201', '和田市', 'BM_DISTRICT', '653200');
INSERT INTO `code` VALUES ('668', '653221', '和田县', 'BM_DISTRICT', '653200');
INSERT INTO `code` VALUES ('669', '653222', '墨玉县', 'BM_DISTRICT', '653200');
INSERT INTO `code` VALUES ('670', '653223', '皮山县', 'BM_DISTRICT', '653200');
INSERT INTO `code` VALUES ('671', '653224', '洛浦县', 'BM_DISTRICT', '653200');
INSERT INTO `code` VALUES ('672', '653225', '策勒县', 'BM_DISTRICT', '653200');
INSERT INTO `code` VALUES ('673', '653226', '于田县', 'BM_DISTRICT', '653200');
INSERT INTO `code` VALUES ('674', '653227', '民丰县', 'BM_DISTRICT', '653200');
INSERT INTO `code` VALUES ('675', '654000', '伊犁哈萨克自治州', 'BM_DISTRICT', '650000');
INSERT INTO `code` VALUES ('676', '654002', '伊宁市', 'BM_DISTRICT', '654000');
INSERT INTO `code` VALUES ('677', '654003', '奎屯市', 'BM_DISTRICT', '654000');
INSERT INTO `code` VALUES ('678', '654021', '伊宁县', 'BM_DISTRICT', '654000');
INSERT INTO `code` VALUES ('679', '654022', '察布查尔锡伯自治县', 'BM_DISTRICT', '654000');
INSERT INTO `code` VALUES ('680', '654023', '霍城县', 'BM_DISTRICT', '654000');
INSERT INTO `code` VALUES ('681', '654024', '巩留县', 'BM_DISTRICT', '654000');
INSERT INTO `code` VALUES ('682', '654025', '新源县', 'BM_DISTRICT', '654000');
INSERT INTO `code` VALUES ('683', '654026', '昭苏县', 'BM_DISTRICT', '654000');
INSERT INTO `code` VALUES ('684', '654027', '特克斯县', 'BM_DISTRICT', '654000');
INSERT INTO `code` VALUES ('685', '654028', '尼勒克县', 'BM_DISTRICT', '654000');
INSERT INTO `code` VALUES ('686', '654200', '塔城地区', 'BM_DISTRICT', '650000');
INSERT INTO `code` VALUES ('687', '654201', '塔城市', 'BM_DISTRICT', '654200');
INSERT INTO `code` VALUES ('688', '654202', '乌苏市', 'BM_DISTRICT', '654200');
INSERT INTO `code` VALUES ('689', '654221', '额敏县', 'BM_DISTRICT', '654200');
INSERT INTO `code` VALUES ('690', '654223', '沙湾县', 'BM_DISTRICT', '654200');
INSERT INTO `code` VALUES ('691', '654224', '托里县', 'BM_DISTRICT', '654200');
INSERT INTO `code` VALUES ('692', '654225', '裕民县', 'BM_DISTRICT', '654200');
INSERT INTO `code` VALUES ('693', '654226', '和布克赛尔蒙古自治县', 'BM_DISTRICT', '654200');
INSERT INTO `code` VALUES ('694', '654300', '阿勒泰地区', 'BM_DISTRICT', '650000');
INSERT INTO `code` VALUES ('695', '654301', '阿勒泰市', 'BM_DISTRICT', '654300');
INSERT INTO `code` VALUES ('696', '654321', '布尔津县', 'BM_DISTRICT', '654300');
INSERT INTO `code` VALUES ('697', '654322', '富蕴县', 'BM_DISTRICT', '654300');
INSERT INTO `code` VALUES ('698', '654323', '福海县', 'BM_DISTRICT', '654300');
INSERT INTO `code` VALUES ('699', '654324', '哈巴河县', 'BM_DISTRICT', '654300');
INSERT INTO `code` VALUES ('700', '654325', '青河县', 'BM_DISTRICT', '654300');
INSERT INTO `code` VALUES ('701', '654326', '吉木乃县', 'BM_DISTRICT', '654300');
INSERT INTO `code` VALUES ('702', '659000', '自治区直辖县级行政区划', 'BM_DISTRICT', '650000');
INSERT INTO `code` VALUES ('703', '659001', '石河子市', 'BM_DISTRICT', '659000');
INSERT INTO `code` VALUES ('704', '659002', '阿拉尔市', 'BM_DISTRICT', '659000');
INSERT INTO `code` VALUES ('705', '652700', '博尔塔拉蒙古自治州', 'BM_DISTRICT', '650000');
INSERT INTO `code` VALUES ('706', '652701', '博乐市', 'BM_DISTRICT', '652700');
INSERT INTO `code` VALUES ('707', '652722', '精河县', 'BM_DISTRICT', '652700');
INSERT INTO `code` VALUES ('708', '652723', '温泉县', 'BM_DISTRICT', '652700');
INSERT INTO `code` VALUES ('709', '652800', '巴音郭楞蒙古自治州', 'BM_DISTRICT', '650000');
INSERT INTO `code` VALUES ('710', '652801', '库尔勒市', 'BM_DISTRICT', '652800');
INSERT INTO `code` VALUES ('711', '652822', '轮台县', 'BM_DISTRICT', '652800');
INSERT INTO `code` VALUES ('712', '640301', '市辖区', 'BM_DISTRICT', '640300');
INSERT INTO `code` VALUES ('713', '640302', '利通区', 'BM_DISTRICT', '640300');
INSERT INTO `code` VALUES ('714', '522631', '黎平县', 'BM_DISTRICT', '522600');
INSERT INTO `code` VALUES ('715', '522632', '榕江县', 'BM_DISTRICT', '522600');
INSERT INTO `code` VALUES ('716', '522633', '从江县', 'BM_DISTRICT', '522600');
INSERT INTO `code` VALUES ('717', '522634', '雷山县', 'BM_DISTRICT', '522600');
INSERT INTO `code` VALUES ('718', '522635', '麻江县', 'BM_DISTRICT', '522600');
INSERT INTO `code` VALUES ('719', '532927', '巍山彝族回族自治县', 'BM_DISTRICT', '532900');
INSERT INTO `code` VALUES ('720', '532928', '永平县', 'BM_DISTRICT', '532900');
INSERT INTO `code` VALUES ('721', '532929', '云龙县', 'BM_DISTRICT', '532900');
INSERT INTO `code` VALUES ('722', '532930', '洱源县', 'BM_DISTRICT', '532900');
INSERT INTO `code` VALUES ('723', '532931', '剑川县', 'BM_DISTRICT', '532900');
INSERT INTO `code` VALUES ('724', '532932', '鹤庆县', 'BM_DISTRICT', '532900');
INSERT INTO `code` VALUES ('725', '533100', '德宏傣族景颇族自治州', 'BM_DISTRICT', '530000');
INSERT INTO `code` VALUES ('726', '533102', '瑞丽市', 'BM_DISTRICT', '533100');
INSERT INTO `code` VALUES ('727', '533103', '芒市', 'BM_DISTRICT', '533100');
INSERT INTO `code` VALUES ('728', '533122', '梁河县', 'BM_DISTRICT', '533100');
INSERT INTO `code` VALUES ('729', '533123', '盈江县', 'BM_DISTRICT', '533100');
INSERT INTO `code` VALUES ('730', '533124', '陇川县', 'BM_DISTRICT', '533100');
INSERT INTO `code` VALUES ('731', '533300', '怒江傈僳族自治州', 'BM_DISTRICT', '530000');
INSERT INTO `code` VALUES ('732', '533321', '泸水县', 'BM_DISTRICT', '533300');
INSERT INTO `code` VALUES ('733', '533323', '福贡县', 'BM_DISTRICT', '533300');
INSERT INTO `code` VALUES ('734', '533324', '贡山独龙族怒族自治县', 'BM_DISTRICT', '533300');
INSERT INTO `code` VALUES ('735', '533325', '兰坪白族普米族自治县', 'BM_DISTRICT', '533300');
INSERT INTO `code` VALUES ('736', '533400', '迪庆藏族自治州', 'BM_DISTRICT', '530000');
INSERT INTO `code` VALUES ('737', '130128', '深泽县', 'BM_DISTRICT', '130100');
INSERT INTO `code` VALUES ('738', '130129', '赞皇县', 'BM_DISTRICT', '130100');
INSERT INTO `code` VALUES ('739', '511824', '石棉县', 'BM_DISTRICT', '511800');
INSERT INTO `code` VALUES ('740', '511825', '天全县', 'BM_DISTRICT', '511800');
INSERT INTO `code` VALUES ('741', '511826', '芦山县', 'BM_DISTRICT', '511800');
INSERT INTO `code` VALUES ('742', '511827', '宝兴县', 'BM_DISTRICT', '511800');
INSERT INTO `code` VALUES ('743', '511900', '巴中市', 'BM_DISTRICT', '510000');
INSERT INTO `code` VALUES ('744', '511901', '市辖区', 'BM_DISTRICT', '511900');
INSERT INTO `code` VALUES ('745', '511902', '巴州区', 'BM_DISTRICT', '511900');
INSERT INTO `code` VALUES ('746', '511921', '通江县', 'BM_DISTRICT', '511900');
INSERT INTO `code` VALUES ('747', '511922', '南江县', 'BM_DISTRICT', '511900');
INSERT INTO `code` VALUES ('748', '511923', '平昌县', 'BM_DISTRICT', '511900');
INSERT INTO `code` VALUES ('749', '512000', '资阳市', 'BM_DISTRICT', '510000');
INSERT INTO `code` VALUES ('750', '512001', '市辖区', 'BM_DISTRICT', '512000');
INSERT INTO `code` VALUES ('751', '512002', '雁江区', 'BM_DISTRICT', '512000');
INSERT INTO `code` VALUES ('752', '512021', '安岳县', 'BM_DISTRICT', '512000');
INSERT INTO `code` VALUES ('753', '512022', '乐至县', 'BM_DISTRICT', '512000');
INSERT INTO `code` VALUES ('754', '512081', '简阳市', 'BM_DISTRICT', '512000');
INSERT INTO `code` VALUES ('755', '513200', '阿坝藏族羌族自治州', 'BM_DISTRICT', '510000');
INSERT INTO `code` VALUES ('756', '513221', '汶川县', 'BM_DISTRICT', '513200');
INSERT INTO `code` VALUES ('757', '513222', '理县', 'BM_DISTRICT', '513200');
INSERT INTO `code` VALUES ('758', '513223', '茂县', 'BM_DISTRICT', '513200');
INSERT INTO `code` VALUES ('759', '513224', '松潘县', 'BM_DISTRICT', '513200');
INSERT INTO `code` VALUES ('760', '513225', '九寨沟县', 'BM_DISTRICT', '513200');
INSERT INTO `code` VALUES ('761', '513226', '金川县', 'BM_DISTRICT', '513200');
INSERT INTO `code` VALUES ('762', '513227', '小金县', 'BM_DISTRICT', '513200');
INSERT INTO `code` VALUES ('763', '513228', '黑水县', 'BM_DISTRICT', '513200');
INSERT INTO `code` VALUES ('764', '513229', '马尔康县', 'BM_DISTRICT', '513200');
INSERT INTO `code` VALUES ('765', '513230', '壤塘县', 'BM_DISTRICT', '513200');
INSERT INTO `code` VALUES ('766', '513231', '阿坝县', 'BM_DISTRICT', '513200');
INSERT INTO `code` VALUES ('767', '513232', '若尔盖县', 'BM_DISTRICT', '513200');
INSERT INTO `code` VALUES ('768', '513233', '红原县', 'BM_DISTRICT', '513200');
INSERT INTO `code` VALUES ('769', '513300', '甘孜藏族自治州', 'BM_DISTRICT', '510000');
INSERT INTO `code` VALUES ('770', '513321', '康定县', 'BM_DISTRICT', '513300');
INSERT INTO `code` VALUES ('771', '513322', '泸定县', 'BM_DISTRICT', '513300');
INSERT INTO `code` VALUES ('772', '513323', '丹巴县', 'BM_DISTRICT', '513300');
INSERT INTO `code` VALUES ('773', '513324', '九龙县', 'BM_DISTRICT', '513300');
INSERT INTO `code` VALUES ('774', '513325', '雅江县', 'BM_DISTRICT', '513300');
INSERT INTO `code` VALUES ('775', '513326', '道孚县', 'BM_DISTRICT', '513300');
INSERT INTO `code` VALUES ('776', '513327', '炉霍县', 'BM_DISTRICT', '513300');
INSERT INTO `code` VALUES ('777', '513328', '甘孜县', 'BM_DISTRICT', '513300');
INSERT INTO `code` VALUES ('778', '513329', '新龙县', 'BM_DISTRICT', '513300');
INSERT INTO `code` VALUES ('779', '621025', '正宁县', 'BM_DISTRICT', '621000');
INSERT INTO `code` VALUES ('780', '621026', '宁县', 'BM_DISTRICT', '621000');
INSERT INTO `code` VALUES ('781', '621027', '镇原县', 'BM_DISTRICT', '621000');
INSERT INTO `code` VALUES ('782', '621100', '定西市', 'BM_DISTRICT', '620000');
INSERT INTO `code` VALUES ('783', '621101', '市辖区', 'BM_DISTRICT', '621100');
INSERT INTO `code` VALUES ('784', '621102', '安定区', 'BM_DISTRICT', '621100');
INSERT INTO `code` VALUES ('785', '621121', '通渭县', 'BM_DISTRICT', '621100');
INSERT INTO `code` VALUES ('786', '621122', '陇西县', 'BM_DISTRICT', '621100');
INSERT INTO `code` VALUES ('787', '621123', '渭源县', 'BM_DISTRICT', '621100');
INSERT INTO `code` VALUES ('788', '621124', '临洮县', 'BM_DISTRICT', '621100');
INSERT INTO `code` VALUES ('789', '621125', '漳县', 'BM_DISTRICT', '621100');
INSERT INTO `code` VALUES ('790', '621126', '岷县', 'BM_DISTRICT', '621100');
INSERT INTO `code` VALUES ('791', '621200', '陇南市', 'BM_DISTRICT', '620000');
INSERT INTO `code` VALUES ('792', '621201', '市辖区', 'BM_DISTRICT', '621200');
INSERT INTO `code` VALUES ('793', '621202', '武都区', 'BM_DISTRICT', '621200');
INSERT INTO `code` VALUES ('794', '621221', '成县', 'BM_DISTRICT', '621200');
INSERT INTO `code` VALUES ('795', '621222', '文县', 'BM_DISTRICT', '621200');
INSERT INTO `code` VALUES ('796', '621223', '宕昌县', 'BM_DISTRICT', '621200');
INSERT INTO `code` VALUES ('797', '621224', '康县', 'BM_DISTRICT', '621200');
INSERT INTO `code` VALUES ('798', '659003', '图木舒克市', 'BM_DISTRICT', '659000');
INSERT INTO `code` VALUES ('799', '659004', '五家渠市', 'BM_DISTRICT', '659000');
INSERT INTO `code` VALUES ('800', '710000', '台湾省', 'BM_DISTRICT', null);
INSERT INTO `code` VALUES ('801', '810000', '香港特别行政区', 'BM_DISTRICT', null);
INSERT INTO `code` VALUES ('802', '820000', '澳门特别行政区', 'BM_DISTRICT', null);
INSERT INTO `code` VALUES ('803', '131102', '桃城区', 'BM_DISTRICT', '131100');
INSERT INTO `code` VALUES ('804', '131121', '枣强县', 'BM_DISTRICT', '131100');
INSERT INTO `code` VALUES ('805', '131122', '武邑县', 'BM_DISTRICT', '131100');
INSERT INTO `code` VALUES ('806', '131123', '武强县', 'BM_DISTRICT', '131100');
INSERT INTO `code` VALUES ('807', '331121', '青田县', 'BM_DISTRICT', '331100');
INSERT INTO `code` VALUES ('808', '331122', '缙云县', 'BM_DISTRICT', '331100');
INSERT INTO `code` VALUES ('809', '331123', '遂昌县', 'BM_DISTRICT', '331100');
INSERT INTO `code` VALUES ('810', '331124', '松阳县', 'BM_DISTRICT', '331100');
INSERT INTO `code` VALUES ('811', '331125', '云和县', 'BM_DISTRICT', '331100');
INSERT INTO `code` VALUES ('812', '331126', '庆元县', 'BM_DISTRICT', '331100');
INSERT INTO `code` VALUES ('813', '331127', '景宁畲族自治县', 'BM_DISTRICT', '331100');
INSERT INTO `code` VALUES ('814', '331181', '龙泉市', 'BM_DISTRICT', '331100');
INSERT INTO `code` VALUES ('815', '340000', '安徽省', 'BM_DISTRICT', null);
INSERT INTO `code` VALUES ('816', '340100', '合肥市', 'BM_DISTRICT', '340000');
INSERT INTO `code` VALUES ('817', '340101', '市辖区', 'BM_DISTRICT', '340100');
INSERT INTO `code` VALUES ('818', '340102', '瑶海区', 'BM_DISTRICT', '340100');
INSERT INTO `code` VALUES ('819', '340103', '庐阳区', 'BM_DISTRICT', '340100');
INSERT INTO `code` VALUES ('820', '340104', '蜀山区', 'BM_DISTRICT', '340100');
INSERT INTO `code` VALUES ('821', '340111', '包河区', 'BM_DISTRICT', '340100');
INSERT INTO `code` VALUES ('822', '340121', '长丰县', 'BM_DISTRICT', '340100');
INSERT INTO `code` VALUES ('823', '340122', '肥东县', 'BM_DISTRICT', '340100');
INSERT INTO `code` VALUES ('824', '340123', '肥西县', 'BM_DISTRICT', '340100');
INSERT INTO `code` VALUES ('825', '340124', '庐江县', 'BM_DISTRICT', '340100');
INSERT INTO `code` VALUES ('826', '340181', '巢湖市', 'BM_DISTRICT', '340100');
INSERT INTO `code` VALUES ('827', '340200', '芜湖市', 'BM_DISTRICT', '340000');
INSERT INTO `code` VALUES ('828', '340201', '市辖区', 'BM_DISTRICT', '340200');
INSERT INTO `code` VALUES ('829', '340202', '镜湖区', 'BM_DISTRICT', '340200');
INSERT INTO `code` VALUES ('830', '340203', '弋江区', 'BM_DISTRICT', '340200');
INSERT INTO `code` VALUES ('831', '340207', '鸠江区', 'BM_DISTRICT', '340200');
INSERT INTO `code` VALUES ('832', '340208', '三山区', 'BM_DISTRICT', '340200');
INSERT INTO `code` VALUES ('833', '340221', '芜湖县', 'BM_DISTRICT', '340200');
INSERT INTO `code` VALUES ('834', '340222', '繁昌县', 'BM_DISTRICT', '340200');
INSERT INTO `code` VALUES ('835', '340223', '南陵县', 'BM_DISTRICT', '340200');
INSERT INTO `code` VALUES ('836', '340225', '无为县', 'BM_DISTRICT', '340200');
INSERT INTO `code` VALUES ('837', '340300', '蚌埠市', 'BM_DISTRICT', '340000');
INSERT INTO `code` VALUES ('838', '340301', '市辖区', 'BM_DISTRICT', '340300');
INSERT INTO `code` VALUES ('839', '340302', '龙子湖区', 'BM_DISTRICT', '340300');
INSERT INTO `code` VALUES ('840', '340303', '蚌山区', 'BM_DISTRICT', '340300');
INSERT INTO `code` VALUES ('841', '340304', '禹会区', 'BM_DISTRICT', '340300');
INSERT INTO `code` VALUES ('842', '340311', '淮上区', 'BM_DISTRICT', '340300');
INSERT INTO `code` VALUES ('843', '340321', '怀远县', 'BM_DISTRICT', '340300');
INSERT INTO `code` VALUES ('844', '340322', '五河县', 'BM_DISTRICT', '340300');
INSERT INTO `code` VALUES ('845', '340323', '固镇县', 'BM_DISTRICT', '340300');
INSERT INTO `code` VALUES ('846', '340400', '淮南市', 'BM_DISTRICT', '340000');
INSERT INTO `code` VALUES ('847', '340401', '市辖区', 'BM_DISTRICT', '340400');
INSERT INTO `code` VALUES ('848', '340402', '大通区', 'BM_DISTRICT', '340400');
INSERT INTO `code` VALUES ('849', '340403', '田家庵区', 'BM_DISTRICT', '340400');
INSERT INTO `code` VALUES ('850', '340404', '谢家集区', 'BM_DISTRICT', '340400');
INSERT INTO `code` VALUES ('851', '340405', '八公山区', 'BM_DISTRICT', '340400');
INSERT INTO `code` VALUES ('852', '340406', '潘集区', 'BM_DISTRICT', '340400');
INSERT INTO `code` VALUES ('853', '340421', '凤台县', 'BM_DISTRICT', '340400');
INSERT INTO `code` VALUES ('854', '340500', '马鞍山市', 'BM_DISTRICT', '340000');
INSERT INTO `code` VALUES ('855', '340501', '市辖区', 'BM_DISTRICT', '340500');
INSERT INTO `code` VALUES ('856', '340503', '花山区', 'BM_DISTRICT', '340500');
INSERT INTO `code` VALUES ('857', '340504', '雨山区', 'BM_DISTRICT', '340500');
INSERT INTO `code` VALUES ('858', '340506', '博望区', 'BM_DISTRICT', '340500');
INSERT INTO `code` VALUES ('859', '340521', '当涂县', 'BM_DISTRICT', '340500');
INSERT INTO `code` VALUES ('860', '340522', '含山县', 'BM_DISTRICT', '340500');
INSERT INTO `code` VALUES ('861', '340523', '和县', 'BM_DISTRICT', '340500');
INSERT INTO `code` VALUES ('862', '341322', '萧县', 'BM_DISTRICT', '341300');
INSERT INTO `code` VALUES ('863', '341323', '灵璧县', 'BM_DISTRICT', '341300');
INSERT INTO `code` VALUES ('864', '341324', '泗县', 'BM_DISTRICT', '341300');
INSERT INTO `code` VALUES ('865', '341500', '六安市', 'BM_DISTRICT', '340000');
INSERT INTO `code` VALUES ('866', '341501', '市辖区', 'BM_DISTRICT', '341500');
INSERT INTO `code` VALUES ('867', '440512', '濠江区', 'BM_DISTRICT', '440500');
INSERT INTO `code` VALUES ('868', '440513', '潮阳区', 'BM_DISTRICT', '440500');
INSERT INTO `code` VALUES ('869', '440514', '潮南区', 'BM_DISTRICT', '440500');
INSERT INTO `code` VALUES ('870', '440515', '澄海区', 'BM_DISTRICT', '440500');
INSERT INTO `code` VALUES ('871', '440523', '南澳县', 'BM_DISTRICT', '440500');
INSERT INTO `code` VALUES ('872', '440600', '佛山市', 'BM_DISTRICT', '440000');
INSERT INTO `code` VALUES ('873', '440601', '市辖区', 'BM_DISTRICT', '440600');
INSERT INTO `code` VALUES ('874', '440604', '禅城区', 'BM_DISTRICT', '440600');
INSERT INTO `code` VALUES ('875', '440605', '南海区', 'BM_DISTRICT', '440600');
INSERT INTO `code` VALUES ('876', '440606', '顺德区', 'BM_DISTRICT', '440600');
INSERT INTO `code` VALUES ('877', '440607', '三水区', 'BM_DISTRICT', '440600');
INSERT INTO `code` VALUES ('878', '440608', '高明区', 'BM_DISTRICT', '440600');
INSERT INTO `code` VALUES ('879', '440700', '江门市', 'BM_DISTRICT', '440000');
INSERT INTO `code` VALUES ('880', '440701', '市辖区', 'BM_DISTRICT', '440700');
INSERT INTO `code` VALUES ('881', '440703', '蓬江区', 'BM_DISTRICT', '440700');
INSERT INTO `code` VALUES ('882', '440704', '江海区', 'BM_DISTRICT', '440700');
INSERT INTO `code` VALUES ('883', '440705', '新会区', 'BM_DISTRICT', '440700');
INSERT INTO `code` VALUES ('884', '440781', '台山市', 'BM_DISTRICT', '440700');
INSERT INTO `code` VALUES ('885', '440783', '开平市', 'BM_DISTRICT', '440700');
INSERT INTO `code` VALUES ('886', '440784', '鹤山市', 'BM_DISTRICT', '440700');
INSERT INTO `code` VALUES ('887', '440785', '恩平市', 'BM_DISTRICT', '440700');
INSERT INTO `code` VALUES ('888', '440800', '湛江市', 'BM_DISTRICT', '440000');
INSERT INTO `code` VALUES ('889', '440801', '市辖区', 'BM_DISTRICT', '440800');
INSERT INTO `code` VALUES ('890', '440802', '赤坎区', 'BM_DISTRICT', '440800');
INSERT INTO `code` VALUES ('891', '440803', '霞山区', 'BM_DISTRICT', '440800');
INSERT INTO `code` VALUES ('892', '440804', '坡头区', 'BM_DISTRICT', '440800');
INSERT INTO `code` VALUES ('893', '440811', '麻章区', 'BM_DISTRICT', '440800');
INSERT INTO `code` VALUES ('894', '440823', '遂溪县', 'BM_DISTRICT', '440800');
INSERT INTO `code` VALUES ('895', '440825', '徐闻县', 'BM_DISTRICT', '440800');
INSERT INTO `code` VALUES ('896', '440881', '廉江市', 'BM_DISTRICT', '440800');
INSERT INTO `code` VALUES ('897', '440882', '雷州市', 'BM_DISTRICT', '440800');
INSERT INTO `code` VALUES ('898', '440883', '吴川市', 'BM_DISTRICT', '440800');
INSERT INTO `code` VALUES ('899', '440900', '茂名市', 'BM_DISTRICT', '440000');
INSERT INTO `code` VALUES ('900', '440901', '市辖区', 'BM_DISTRICT', '440900');
INSERT INTO `code` VALUES ('901', '440902', '茂南区', 'BM_DISTRICT', '440900');
INSERT INTO `code` VALUES ('902', '440903', '茂港区', 'BM_DISTRICT', '440900');
INSERT INTO `code` VALUES ('903', '440923', '电白县', 'BM_DISTRICT', '440900');
INSERT INTO `code` VALUES ('904', '440981', '高州市', 'BM_DISTRICT', '440900');
INSERT INTO `code` VALUES ('905', '440982', '化州市', 'BM_DISTRICT', '440900');
INSERT INTO `code` VALUES ('906', '440983', '信宜市', 'BM_DISTRICT', '440900');
INSERT INTO `code` VALUES ('907', '441200', '肇庆市', 'BM_DISTRICT', '440000');
INSERT INTO `code` VALUES ('908', '441201', '市辖区', 'BM_DISTRICT', '441200');
INSERT INTO `code` VALUES ('909', '441202', '端州区', 'BM_DISTRICT', '441200');
INSERT INTO `code` VALUES ('910', '441203', '鼎湖区', 'BM_DISTRICT', '441200');
INSERT INTO `code` VALUES ('911', '441223', '广宁县', 'BM_DISTRICT', '441200');
INSERT INTO `code` VALUES ('912', '441224', '怀集县', 'BM_DISTRICT', '441200');
INSERT INTO `code` VALUES ('913', '441225', '封开县', 'BM_DISTRICT', '441200');
INSERT INTO `code` VALUES ('914', '441226', '德庆县', 'BM_DISTRICT', '441200');
INSERT INTO `code` VALUES ('915', '441283', '高要市', 'BM_DISTRICT', '441200');
INSERT INTO `code` VALUES ('916', '441284', '四会市', 'BM_DISTRICT', '441200');
INSERT INTO `code` VALUES ('917', '441300', '惠州市', 'BM_DISTRICT', '440000');
INSERT INTO `code` VALUES ('918', '441301', '市辖区', 'BM_DISTRICT', '441300');
INSERT INTO `code` VALUES ('919', '441302', '惠城区', 'BM_DISTRICT', '441300');
INSERT INTO `code` VALUES ('920', '441303', '惠阳区', 'BM_DISTRICT', '441300');
INSERT INTO `code` VALUES ('921', '441322', '博罗县', 'BM_DISTRICT', '441300');
INSERT INTO `code` VALUES ('922', '150825', '乌拉特后旗', 'BM_DISTRICT', '150800');
INSERT INTO `code` VALUES ('923', '150826', '杭锦后旗', 'BM_DISTRICT', '150800');
INSERT INTO `code` VALUES ('924', '150900', '乌兰察布市', 'BM_DISTRICT', '150000');
INSERT INTO `code` VALUES ('925', '350881', '漳平市', 'BM_DISTRICT', '350800');
INSERT INTO `code` VALUES ('926', '350900', '宁德市', 'BM_DISTRICT', '350000');
INSERT INTO `code` VALUES ('927', '350901', '市辖区', 'BM_DISTRICT', '350900');
INSERT INTO `code` VALUES ('928', '350902', '蕉城区', 'BM_DISTRICT', '350900');
INSERT INTO `code` VALUES ('929', '350921', '霞浦县', 'BM_DISTRICT', '350900');
INSERT INTO `code` VALUES ('930', '350922', '古田县', 'BM_DISTRICT', '350900');
INSERT INTO `code` VALUES ('931', '350923', '屏南县', 'BM_DISTRICT', '350900');
INSERT INTO `code` VALUES ('932', '350924', '寿宁县', 'BM_DISTRICT', '350900');
INSERT INTO `code` VALUES ('933', '350925', '周宁县', 'BM_DISTRICT', '350900');
INSERT INTO `code` VALUES ('934', '350926', '柘荣县', 'BM_DISTRICT', '350900');
INSERT INTO `code` VALUES ('935', '350981', '福安市', 'BM_DISTRICT', '350900');
INSERT INTO `code` VALUES ('936', '350982', '福鼎市', 'BM_DISTRICT', '350900');
INSERT INTO `code` VALUES ('937', '360000', '江西省', 'BM_DISTRICT', null);
INSERT INTO `code` VALUES ('938', '360100', '南昌市', 'BM_DISTRICT', '360000');
INSERT INTO `code` VALUES ('939', '360101', '市辖区', 'BM_DISTRICT', '360100');
INSERT INTO `code` VALUES ('940', '360102', '东湖区', 'BM_DISTRICT', '360100');
INSERT INTO `code` VALUES ('941', '360103', '西湖区', 'BM_DISTRICT', '360100');
INSERT INTO `code` VALUES ('942', '360104', '青云谱区', 'BM_DISTRICT', '360100');
INSERT INTO `code` VALUES ('943', '360105', '湾里区', 'BM_DISTRICT', '360100');
INSERT INTO `code` VALUES ('944', '360111', '青山湖区', 'BM_DISTRICT', '360100');
INSERT INTO `code` VALUES ('945', '360121', '南昌县', 'BM_DISTRICT', '360100');
INSERT INTO `code` VALUES ('946', '360122', '新建县', 'BM_DISTRICT', '360100');
INSERT INTO `code` VALUES ('947', '360123', '安义县', 'BM_DISTRICT', '360100');
INSERT INTO `code` VALUES ('948', '360124', '进贤县', 'BM_DISTRICT', '360100');
INSERT INTO `code` VALUES ('949', '360200', '景德镇市', 'BM_DISTRICT', '360000');
INSERT INTO `code` VALUES ('950', '360201', '市辖区', 'BM_DISTRICT', '360200');
INSERT INTO `code` VALUES ('951', '360202', '昌江区', 'BM_DISTRICT', '360200');
INSERT INTO `code` VALUES ('952', '360203', '珠山区', 'BM_DISTRICT', '360200');
INSERT INTO `code` VALUES ('953', '360222', '浮梁县', 'BM_DISTRICT', '360200');
INSERT INTO `code` VALUES ('954', '360281', '乐平市', 'BM_DISTRICT', '360200');
INSERT INTO `code` VALUES ('955', '360300', '萍乡市', 'BM_DISTRICT', '360000');
INSERT INTO `code` VALUES ('956', '360301', '市辖区', 'BM_DISTRICT', '360300');
INSERT INTO `code` VALUES ('957', '360302', '安源区', 'BM_DISTRICT', '360300');
INSERT INTO `code` VALUES ('958', '360313', '湘东区', 'BM_DISTRICT', '360300');
INSERT INTO `code` VALUES ('959', '360321', '莲花县', 'BM_DISTRICT', '360300');
INSERT INTO `code` VALUES ('960', '360322', '上栗县', 'BM_DISTRICT', '360300');
INSERT INTO `code` VALUES ('961', '360323', '芦溪县', 'BM_DISTRICT', '360300');
INSERT INTO `code` VALUES ('962', '360400', '九江市', 'BM_DISTRICT', '360000');
INSERT INTO `code` VALUES ('963', '360401', '市辖区', 'BM_DISTRICT', '360400');
INSERT INTO `code` VALUES ('964', '360402', '庐山区', 'BM_DISTRICT', '360400');
INSERT INTO `code` VALUES ('965', '360403', '浔阳区', 'BM_DISTRICT', '360400');
INSERT INTO `code` VALUES ('966', '360421', '九江县', 'BM_DISTRICT', '360400');
INSERT INTO `code` VALUES ('967', '360423', '武宁县', 'BM_DISTRICT', '360400');
INSERT INTO `code` VALUES ('968', '360424', '修水县', 'BM_DISTRICT', '360400');
INSERT INTO `code` VALUES ('969', '360425', '永修县', 'BM_DISTRICT', '360400');
INSERT INTO `code` VALUES ('970', '360426', '德安县', 'BM_DISTRICT', '360400');
INSERT INTO `code` VALUES ('971', '360427', '星子县', 'BM_DISTRICT', '360400');
INSERT INTO `code` VALUES ('972', '360428', '都昌县', 'BM_DISTRICT', '360400');
INSERT INTO `code` VALUES ('973', '360429', '湖口县', 'BM_DISTRICT', '360400');
INSERT INTO `code` VALUES ('974', '360430', '彭泽县', 'BM_DISTRICT', '360400');
INSERT INTO `code` VALUES ('975', '360481', '瑞昌市', 'BM_DISTRICT', '360400');
INSERT INTO `code` VALUES ('976', '360482', '共青城市', 'BM_DISTRICT', '360400');
INSERT INTO `code` VALUES ('977', '360500', '新余市', 'BM_DISTRICT', '360000');
INSERT INTO `code` VALUES ('978', '360501', '市辖区', 'BM_DISTRICT', '360500');
INSERT INTO `code` VALUES ('979', '360502', '渝水区', 'BM_DISTRICT', '360500');
INSERT INTO `code` VALUES ('980', '360521', '分宜县', 'BM_DISTRICT', '360500');
INSERT INTO `code` VALUES ('981', '632721', '玉树县', 'BM_DISTRICT', '632700');
INSERT INTO `code` VALUES ('982', '632722', '杂多县', 'BM_DISTRICT', '632700');
INSERT INTO `code` VALUES ('983', '632723', '称多县', 'BM_DISTRICT', '632700');
INSERT INTO `code` VALUES ('984', '632724', '治多县', 'BM_DISTRICT', '632700');
INSERT INTO `code` VALUES ('985', '632725', '囊谦县', 'BM_DISTRICT', '632700');
INSERT INTO `code` VALUES ('986', '632726', '曲麻莱县', 'BM_DISTRICT', '632700');
INSERT INTO `code` VALUES ('987', '632800', '海西蒙古族藏族自治州', 'BM_DISTRICT', '630000');
INSERT INTO `code` VALUES ('988', '632801', '格尔木市', 'BM_DISTRICT', '632800');
INSERT INTO `code` VALUES ('989', '632802', '德令哈市', 'BM_DISTRICT', '632800');
INSERT INTO `code` VALUES ('990', '632821', '乌兰县', 'BM_DISTRICT', '632800');
INSERT INTO `code` VALUES ('991', '632822', '都兰县', 'BM_DISTRICT', '632800');
INSERT INTO `code` VALUES ('992', '632823', '天峻县', 'BM_DISTRICT', '632800');
INSERT INTO `code` VALUES ('993', '640000', '宁夏回族自治区', 'BM_DISTRICT', null);
INSERT INTO `code` VALUES ('994', '640100', '银川市', 'BM_DISTRICT', '640000');
INSERT INTO `code` VALUES ('995', '640101', '市辖区', 'BM_DISTRICT', '640100');
INSERT INTO `code` VALUES ('996', '640104', '兴庆区', 'BM_DISTRICT', '640100');
INSERT INTO `code` VALUES ('997', '640105', '西夏区', 'BM_DISTRICT', '640100');
INSERT INTO `code` VALUES ('998', '640106', '金凤区', 'BM_DISTRICT', '640100');
INSERT INTO `code` VALUES ('999', '640121', '永宁县', 'BM_DISTRICT', '640100');
INSERT INTO `code` VALUES ('1000', '640122', '贺兰县', 'BM_DISTRICT', '640100');
INSERT INTO `code` VALUES ('1001', '640181', '灵武市', 'BM_DISTRICT', '640100');
INSERT INTO `code` VALUES ('1002', '640200', '石嘴山市', 'BM_DISTRICT', '640000');
INSERT INTO `code` VALUES ('1003', '640201', '市辖区', 'BM_DISTRICT', '640200');
INSERT INTO `code` VALUES ('1004', '640202', '大武口区', 'BM_DISTRICT', '640200');
INSERT INTO `code` VALUES ('1005', '640205', '惠农区', 'BM_DISTRICT', '640200');
INSERT INTO `code` VALUES ('1006', '640221', '平罗县', 'BM_DISTRICT', '640200');
INSERT INTO `code` VALUES ('1007', '640300', '吴忠市', 'BM_DISTRICT', '640000');
INSERT INTO `code` VALUES ('1008', '445322', '郁南县', 'BM_DISTRICT', '445300');
INSERT INTO `code` VALUES ('1009', '445323', '云安县', 'BM_DISTRICT', '445300');
INSERT INTO `code` VALUES ('1010', '445381', '罗定市', 'BM_DISTRICT', '445300');
INSERT INTO `code` VALUES ('1011', '450000', '广西壮族自治区', 'BM_DISTRICT', null);
INSERT INTO `code` VALUES ('1012', '451400', '崇左市', 'BM_DISTRICT', '450000');
INSERT INTO `code` VALUES ('1013', '451401', '市辖区', 'BM_DISTRICT', '451400');
INSERT INTO `code` VALUES ('1014', '451402', '江洲区', 'BM_DISTRICT', '451400');
INSERT INTO `code` VALUES ('1015', '451421', '扶绥县', 'BM_DISTRICT', '451400');
INSERT INTO `code` VALUES ('1016', '451422', '宁明县', 'BM_DISTRICT', '451400');
INSERT INTO `code` VALUES ('1017', '451423', '龙州县', 'BM_DISTRICT', '451400');
INSERT INTO `code` VALUES ('1018', '451424', '大新县', 'BM_DISTRICT', '451400');
INSERT INTO `code` VALUES ('1019', '451425', '天等县', 'BM_DISTRICT', '451400');
INSERT INTO `code` VALUES ('1020', '451481', '凭祥市', 'BM_DISTRICT', '451400');
INSERT INTO `code` VALUES ('1021', '460000', '海南省', 'BM_DISTRICT', null);
INSERT INTO `code` VALUES ('1022', '460100', '海口市', 'BM_DISTRICT', '460000');
INSERT INTO `code` VALUES ('1023', '460101', '市辖区', 'BM_DISTRICT', '460100');
INSERT INTO `code` VALUES ('1024', '460105', '秀英区', 'BM_DISTRICT', '460100');
INSERT INTO `code` VALUES ('1025', '460106', '龙华区', 'BM_DISTRICT', '460100');
INSERT INTO `code` VALUES ('1026', '460107', '琼山区', 'BM_DISTRICT', '460100');
INSERT INTO `code` VALUES ('1027', '460108', '美兰区', 'BM_DISTRICT', '460100');
INSERT INTO `code` VALUES ('1028', '460200', '三亚市', 'BM_DISTRICT', '460000');
INSERT INTO `code` VALUES ('1029', '460201', '市辖区', 'BM_DISTRICT', '460200');
INSERT INTO `code` VALUES ('1030', '460300', '三沙市', 'BM_DISTRICT', '460000');
INSERT INTO `code` VALUES ('1031', '460321', '西沙群岛', 'BM_DISTRICT', '460300');
INSERT INTO `code` VALUES ('1032', '460322', '南沙群岛', 'BM_DISTRICT', '460300');
INSERT INTO `code` VALUES ('1033', '460323', '中沙群岛的岛礁及其海域', 'BM_DISTRICT', '460300');
INSERT INTO `code` VALUES ('1034', '469000', '省直辖县级行政区划', 'BM_DISTRICT', '460000');
INSERT INTO `code` VALUES ('1035', '469001', '五指山市', 'BM_DISTRICT', '469000');
INSERT INTO `code` VALUES ('1036', '469002', '琼海市', 'BM_DISTRICT', '469000');
INSERT INTO `code` VALUES ('1037', '469003', '儋州市', 'BM_DISTRICT', '469000');
INSERT INTO `code` VALUES ('1038', '469005', '文昌市', 'BM_DISTRICT', '469000');
INSERT INTO `code` VALUES ('1039', '469006', '万宁市', 'BM_DISTRICT', '469000');
INSERT INTO `code` VALUES ('1040', '469007', '东方市', 'BM_DISTRICT', '469000');
INSERT INTO `code` VALUES ('1041', '469021', '定安县', 'BM_DISTRICT', '469000');
INSERT INTO `code` VALUES ('1042', '469022', '屯昌县', 'BM_DISTRICT', '469000');
INSERT INTO `code` VALUES ('1043', '469023', '澄迈县', 'BM_DISTRICT', '469000');
INSERT INTO `code` VALUES ('1044', '469024', '临高县', 'BM_DISTRICT', '469000');
INSERT INTO `code` VALUES ('1045', '469025', '白沙黎族自治县', 'BM_DISTRICT', '469000');
INSERT INTO `code` VALUES ('1046', '469026', '昌江黎族自治县', 'BM_DISTRICT', '469000');
INSERT INTO `code` VALUES ('1047', '469027', '乐东黎族自治县', 'BM_DISTRICT', '469000');
INSERT INTO `code` VALUES ('1048', '469028', '陵水黎族自治县', 'BM_DISTRICT', '469000');
INSERT INTO `code` VALUES ('1049', '469029', '保亭黎族苗族自治县', 'BM_DISTRICT', '469000');
INSERT INTO `code` VALUES ('1050', '469030', '琼中黎族苗族自治县', 'BM_DISTRICT', '469000');
INSERT INTO `code` VALUES ('1051', '500000', '重庆市', 'BM_DISTRICT', null);
INSERT INTO `code` VALUES ('1052', '500100', '市辖区', 'BM_DISTRICT', '500000');
INSERT INTO `code` VALUES ('1053', '500101', '万州区', 'BM_DISTRICT', '500100');
INSERT INTO `code` VALUES ('1054', '500102', '涪陵区', 'BM_DISTRICT', '500100');
INSERT INTO `code` VALUES ('1055', '500103', '渝中区', 'BM_DISTRICT', '500100');
INSERT INTO `code` VALUES ('1056', '360726', '安远县', 'BM_DISTRICT', '360700');
INSERT INTO `code` VALUES ('1057', '360727', '龙南县', 'BM_DISTRICT', '360700');
INSERT INTO `code` VALUES ('1058', '360728', '定南县', 'BM_DISTRICT', '360700');
INSERT INTO `code` VALUES ('1059', '360729', '全南县', 'BM_DISTRICT', '360700');
INSERT INTO `code` VALUES ('1060', '360730', '宁都县', 'BM_DISTRICT', '360700');
INSERT INTO `code` VALUES ('1061', '360731', '于都县', 'BM_DISTRICT', '360700');
INSERT INTO `code` VALUES ('1062', '360732', '兴国县', 'BM_DISTRICT', '360700');
INSERT INTO `code` VALUES ('1063', '360733', '会昌县', 'BM_DISTRICT', '360700');
INSERT INTO `code` VALUES ('1064', '360734', '寻乌县', 'BM_DISTRICT', '360700');
INSERT INTO `code` VALUES ('1065', '360735', '石城县', 'BM_DISTRICT', '360700');
INSERT INTO `code` VALUES ('1066', '360781', '瑞金市', 'BM_DISTRICT', '360700');
INSERT INTO `code` VALUES ('1067', '360782', '南康市', 'BM_DISTRICT', '360700');
INSERT INTO `code` VALUES ('1068', '360800', '吉安市', 'BM_DISTRICT', '360000');
INSERT INTO `code` VALUES ('1069', '360801', '市辖区', 'BM_DISTRICT', '360800');
INSERT INTO `code` VALUES ('1070', '360802', '吉州区', 'BM_DISTRICT', '360800');
INSERT INTO `code` VALUES ('1071', '360803', '青原区', 'BM_DISTRICT', '360800');
INSERT INTO `code` VALUES ('1072', '360821', '吉安县', 'BM_DISTRICT', '360800');
INSERT INTO `code` VALUES ('1073', '360822', '吉水县', 'BM_DISTRICT', '360800');
INSERT INTO `code` VALUES ('1074', '360823', '峡江县', 'BM_DISTRICT', '360800');
INSERT INTO `code` VALUES ('1075', '360824', '新干县', 'BM_DISTRICT', '360800');
INSERT INTO `code` VALUES ('1076', '360825', '永丰县', 'BM_DISTRICT', '360800');
INSERT INTO `code` VALUES ('1077', '360826', '泰和县', 'BM_DISTRICT', '360800');
INSERT INTO `code` VALUES ('1078', '360827', '遂川县', 'BM_DISTRICT', '360800');
INSERT INTO `code` VALUES ('1079', '360828', '万安县', 'BM_DISTRICT', '360800');
INSERT INTO `code` VALUES ('1080', '360829', '安福县', 'BM_DISTRICT', '360800');
INSERT INTO `code` VALUES ('1081', '360830', '永新县', 'BM_DISTRICT', '360800');
INSERT INTO `code` VALUES ('1082', '360881', '井冈山市', 'BM_DISTRICT', '360800');
INSERT INTO `code` VALUES ('1083', '360900', '宜春市', 'BM_DISTRICT', '360000');
INSERT INTO `code` VALUES ('1084', '360901', '市辖区', 'BM_DISTRICT', '360900');
INSERT INTO `code` VALUES ('1085', '360902', '袁州区', 'BM_DISTRICT', '360900');
INSERT INTO `code` VALUES ('1086', '360921', '奉新县', 'BM_DISTRICT', '360900');
INSERT INTO `code` VALUES ('1087', '360922', '万载县', 'BM_DISTRICT', '360900');
INSERT INTO `code` VALUES ('1088', '360923', '上高县', 'BM_DISTRICT', '360900');
INSERT INTO `code` VALUES ('1089', '360924', '宜丰县', 'BM_DISTRICT', '360900');
INSERT INTO `code` VALUES ('1090', '360925', '靖安县', 'BM_DISTRICT', '360900');
INSERT INTO `code` VALUES ('1091', '360926', '铜鼓县', 'BM_DISTRICT', '360900');
INSERT INTO `code` VALUES ('1092', '360981', '丰城市', 'BM_DISTRICT', '360900');
INSERT INTO `code` VALUES ('1093', '360982', '樟树市', 'BM_DISTRICT', '360900');
INSERT INTO `code` VALUES ('1094', '360983', '高安市', 'BM_DISTRICT', '360900');
INSERT INTO `code` VALUES ('1095', '361000', '抚州市', 'BM_DISTRICT', '360000');
INSERT INTO `code` VALUES ('1096', '361001', '市辖区', 'BM_DISTRICT', '361000');
INSERT INTO `code` VALUES ('1097', '361002', '临川区', 'BM_DISTRICT', '361000');
INSERT INTO `code` VALUES ('1098', '361021', '南城县', 'BM_DISTRICT', '361000');
INSERT INTO `code` VALUES ('1099', '361022', '黎川县', 'BM_DISTRICT', '361000');
INSERT INTO `code` VALUES ('1100', '361023', '南丰县', 'BM_DISTRICT', '361000');
INSERT INTO `code` VALUES ('1101', '361024', '崇仁县', 'BM_DISTRICT', '361000');
INSERT INTO `code` VALUES ('1102', '361025', '乐安县', 'BM_DISTRICT', '361000');
INSERT INTO `code` VALUES ('1103', '361026', '宜黄县', 'BM_DISTRICT', '361000');
INSERT INTO `code` VALUES ('1104', '361027', '金溪县', 'BM_DISTRICT', '361000');
INSERT INTO `code` VALUES ('1105', '130724', '沽源县', 'BM_DISTRICT', '130700');
INSERT INTO `code` VALUES ('1106', '130725', '尚义县', 'BM_DISTRICT', '130700');
INSERT INTO `code` VALUES ('1107', '130726', '蔚县', 'BM_DISTRICT', '130700');
INSERT INTO `code` VALUES ('1108', '130727', '阳原县', 'BM_DISTRICT', '130700');
INSERT INTO `code` VALUES ('1109', '130728', '怀安县', 'BM_DISTRICT', '130700');
INSERT INTO `code` VALUES ('1110', '130729', '万全县', 'BM_DISTRICT', '130700');
INSERT INTO `code` VALUES ('1111', '130730', '怀来县', 'BM_DISTRICT', '130700');
INSERT INTO `code` VALUES ('1112', '130731', '涿鹿县', 'BM_DISTRICT', '130700');
INSERT INTO `code` VALUES ('1113', '130732', '赤城县', 'BM_DISTRICT', '130700');
INSERT INTO `code` VALUES ('1114', '130733', '崇礼县', 'BM_DISTRICT', '130700');
INSERT INTO `code` VALUES ('1115', '130800', '承德市', 'BM_DISTRICT', '130000');
INSERT INTO `code` VALUES ('1116', '130801', '市辖区', 'BM_DISTRICT', '130800');
INSERT INTO `code` VALUES ('1117', '130802', '双桥区', 'BM_DISTRICT', '130800');
INSERT INTO `code` VALUES ('1118', '130803', '双滦区', 'BM_DISTRICT', '130800');
INSERT INTO `code` VALUES ('1119', '130804', '鹰手营子矿区', 'BM_DISTRICT', '130800');
INSERT INTO `code` VALUES ('1120', '130821', '承德县', 'BM_DISTRICT', '130800');
INSERT INTO `code` VALUES ('1121', '130822', '兴隆县', 'BM_DISTRICT', '130800');
INSERT INTO `code` VALUES ('1122', '130823', '平泉县', 'BM_DISTRICT', '130800');
INSERT INTO `code` VALUES ('1123', '130824', '滦平县', 'BM_DISTRICT', '130800');
INSERT INTO `code` VALUES ('1124', '130825', '隆化县', 'BM_DISTRICT', '130800');
INSERT INTO `code` VALUES ('1125', '130826', '丰宁满族自治县', 'BM_DISTRICT', '130800');
INSERT INTO `code` VALUES ('1126', '130827', '宽城满族自治县', 'BM_DISTRICT', '130800');
INSERT INTO `code` VALUES ('1127', '130828', '围场满族蒙古族自治县', 'BM_DISTRICT', '130800');
INSERT INTO `code` VALUES ('1128', '130900', '沧州市', 'BM_DISTRICT', '130000');
INSERT INTO `code` VALUES ('1129', '130901', '市辖区', 'BM_DISTRICT', '130900');
INSERT INTO `code` VALUES ('1130', '130902', '新华区', 'BM_DISTRICT', '130900');
INSERT INTO `code` VALUES ('1131', '130903', '运河区', 'BM_DISTRICT', '130900');
INSERT INTO `code` VALUES ('1132', '130921', '沧县', 'BM_DISTRICT', '130900');
INSERT INTO `code` VALUES ('1133', '130922', '青县', 'BM_DISTRICT', '130900');
INSERT INTO `code` VALUES ('1134', '130923', '东光县', 'BM_DISTRICT', '130900');
INSERT INTO `code` VALUES ('1135', '130924', '海兴县', 'BM_DISTRICT', '130900');
INSERT INTO `code` VALUES ('1136', '130925', '盐山县', 'BM_DISTRICT', '130900');
INSERT INTO `code` VALUES ('1137', '130926', '肃宁县', 'BM_DISTRICT', '130900');
INSERT INTO `code` VALUES ('1138', '130927', '南皮县', 'BM_DISTRICT', '130900');
INSERT INTO `code` VALUES ('1139', '130928', '吴桥县', 'BM_DISTRICT', '130900');
INSERT INTO `code` VALUES ('1140', '130929', '献县', 'BM_DISTRICT', '130900');
INSERT INTO `code` VALUES ('1141', '130930', '孟村回族自治县', 'BM_DISTRICT', '130900');
INSERT INTO `code` VALUES ('1142', '130981', '泊头市', 'BM_DISTRICT', '130900');
INSERT INTO `code` VALUES ('1143', '130982', '任丘市', 'BM_DISTRICT', '130900');
INSERT INTO `code` VALUES ('1144', '130983', '黄骅市', 'BM_DISTRICT', '130900');
INSERT INTO `code` VALUES ('1145', '130984', '河间市', 'BM_DISTRICT', '130900');
INSERT INTO `code` VALUES ('1146', '131000', '廊坊市', 'BM_DISTRICT', '130000');
INSERT INTO `code` VALUES ('1147', '131001', '市辖区', 'BM_DISTRICT', '131000');
INSERT INTO `code` VALUES ('1148', '131002', '安次区', 'BM_DISTRICT', '131000');
INSERT INTO `code` VALUES ('1149', '131003', '广阳区', 'BM_DISTRICT', '131000');
INSERT INTO `code` VALUES ('1150', '131022', '固安县', 'BM_DISTRICT', '131000');
INSERT INTO `code` VALUES ('1151', '131023', '永清县', 'BM_DISTRICT', '131000');
INSERT INTO `code` VALUES ('1152', '131024', '香河县', 'BM_DISTRICT', '131000');
INSERT INTO `code` VALUES ('1153', '131025', '大城县', 'BM_DISTRICT', '131000');
INSERT INTO `code` VALUES ('1154', '131026', '文安县', 'BM_DISTRICT', '131000');
INSERT INTO `code` VALUES ('1155', '131028', '大厂回族自治县', 'BM_DISTRICT', '131000');
INSERT INTO `code` VALUES ('1156', '131081', '霸州市', 'BM_DISTRICT', '131000');
INSERT INTO `code` VALUES ('1157', '131082', '三河市', 'BM_DISTRICT', '131000');
INSERT INTO `code` VALUES ('1158', '131100', '衡水市', 'BM_DISTRICT', '130000');
INSERT INTO `code` VALUES ('1159', '131101', '市辖区', 'BM_DISTRICT', '131100');
INSERT INTO `code` VALUES ('1160', '141000', '临汾市', 'BM_DISTRICT', '140000');
INSERT INTO `code` VALUES ('1161', '542621', '林芝县', 'BM_DISTRICT', '542600');
INSERT INTO `code` VALUES ('1162', '542622', '工布江达县', 'BM_DISTRICT', '542600');
INSERT INTO `code` VALUES ('1163', '542623', '米林县', 'BM_DISTRICT', '542600');
INSERT INTO `code` VALUES ('1164', '542624', '墨脱县', 'BM_DISTRICT', '542600');
INSERT INTO `code` VALUES ('1165', '542625', '波密县', 'BM_DISTRICT', '542600');
INSERT INTO `code` VALUES ('1166', '542626', '察隅县', 'BM_DISTRICT', '542600');
INSERT INTO `code` VALUES ('1167', '542627', '朗县', 'BM_DISTRICT', '542600');
INSERT INTO `code` VALUES ('1168', '610000', '陕西省', 'BM_DISTRICT', null);
INSERT INTO `code` VALUES ('1169', '610100', '西安市', 'BM_DISTRICT', '610000');
INSERT INTO `code` VALUES ('1170', '610101', '市辖区', 'BM_DISTRICT', '610100');
INSERT INTO `code` VALUES ('1171', '610102', '新城区', 'BM_DISTRICT', '610100');
INSERT INTO `code` VALUES ('1172', '610103', '碑林区', 'BM_DISTRICT', '610100');
INSERT INTO `code` VALUES ('1173', '610104', '莲湖区', 'BM_DISTRICT', '610100');
INSERT INTO `code` VALUES ('1174', '610111', '灞桥区', 'BM_DISTRICT', '610100');
INSERT INTO `code` VALUES ('1175', '610112', '未央区', 'BM_DISTRICT', '610100');
INSERT INTO `code` VALUES ('1176', '610113', '雁塔区', 'BM_DISTRICT', '610100');
INSERT INTO `code` VALUES ('1177', '610114', '阎良区', 'BM_DISTRICT', '610100');
INSERT INTO `code` VALUES ('1178', '610115', '临潼区', 'BM_DISTRICT', '610100');
INSERT INTO `code` VALUES ('1179', '610116', '长安区', 'BM_DISTRICT', '610100');
INSERT INTO `code` VALUES ('1180', '610122', '蓝田县', 'BM_DISTRICT', '610100');
INSERT INTO `code` VALUES ('1181', '610124', '周至县', 'BM_DISTRICT', '610100');
INSERT INTO `code` VALUES ('1182', '610125', '户县', 'BM_DISTRICT', '610100');
INSERT INTO `code` VALUES ('1183', '610126', '高陵县', 'BM_DISTRICT', '610100');
INSERT INTO `code` VALUES ('1184', '610200', '铜川市', 'BM_DISTRICT', '610000');
INSERT INTO `code` VALUES ('1185', '610201', '市辖区', 'BM_DISTRICT', '610200');
INSERT INTO `code` VALUES ('1186', '610202', '王益区', 'BM_DISTRICT', '610200');
INSERT INTO `code` VALUES ('1187', '610203', '印台区', 'BM_DISTRICT', '610200');
INSERT INTO `code` VALUES ('1188', '510301', '市辖区', 'BM_DISTRICT', '510300');
INSERT INTO `code` VALUES ('1189', '510302', '自流井区', 'BM_DISTRICT', '510300');
INSERT INTO `code` VALUES ('1190', '533421', '香格里拉县', 'BM_DISTRICT', '533400');
INSERT INTO `code` VALUES ('1191', '533422', '德钦县', 'BM_DISTRICT', '533400');
INSERT INTO `code` VALUES ('1192', '533423', '维西傈僳族自治县', 'BM_DISTRICT', '533400');
INSERT INTO `code` VALUES ('1193', '540000', '西藏自治区', 'BM_DISTRICT', null);
INSERT INTO `code` VALUES ('1194', '540100', '拉萨市', 'BM_DISTRICT', '540000');
INSERT INTO `code` VALUES ('1195', '540101', '市辖区', 'BM_DISTRICT', '540100');
INSERT INTO `code` VALUES ('1196', '540102', '城关区', 'BM_DISTRICT', '540100');
INSERT INTO `code` VALUES ('1197', '540121', '林周县', 'BM_DISTRICT', '540100');
INSERT INTO `code` VALUES ('1198', '540122', '当雄县', 'BM_DISTRICT', '540100');
INSERT INTO `code` VALUES ('1199', '540123', '尼木县', 'BM_DISTRICT', '540100');
INSERT INTO `code` VALUES ('1200', '540124', '曲水县', 'BM_DISTRICT', '540100');
INSERT INTO `code` VALUES ('1201', '540125', '堆龙德庆县', 'BM_DISTRICT', '540100');
INSERT INTO `code` VALUES ('1202', '540126', '达孜县', 'BM_DISTRICT', '540100');
INSERT INTO `code` VALUES ('1203', '540127', '墨竹工卡县', 'BM_DISTRICT', '540100');
INSERT INTO `code` VALUES ('1204', '542100', '昌都地区', 'BM_DISTRICT', '540000');
INSERT INTO `code` VALUES ('1205', '542121', '昌都县', 'BM_DISTRICT', '542100');
INSERT INTO `code` VALUES ('1206', '542122', '江达县', 'BM_DISTRICT', '542100');
INSERT INTO `code` VALUES ('1207', '542123', '贡觉县', 'BM_DISTRICT', '542100');
INSERT INTO `code` VALUES ('1208', '542124', '类乌齐县', 'BM_DISTRICT', '542100');
INSERT INTO `code` VALUES ('1209', '542125', '丁青县', 'BM_DISTRICT', '542100');
INSERT INTO `code` VALUES ('1210', '542126', '察雅县', 'BM_DISTRICT', '542100');
INSERT INTO `code` VALUES ('1211', '542127', '八宿县', 'BM_DISTRICT', '542100');
INSERT INTO `code` VALUES ('1212', '542128', '左贡县', 'BM_DISTRICT', '542100');
INSERT INTO `code` VALUES ('1213', '542129', '芒康县', 'BM_DISTRICT', '542100');
INSERT INTO `code` VALUES ('1214', '542132', '洛隆县', 'BM_DISTRICT', '542100');
INSERT INTO `code` VALUES ('1215', '542133', '边坝县', 'BM_DISTRICT', '542100');
INSERT INTO `code` VALUES ('1216', '542200', '山南地区', 'BM_DISTRICT', '540000');
INSERT INTO `code` VALUES ('1217', '542221', '乃东县', 'BM_DISTRICT', '542200');
INSERT INTO `code` VALUES ('1218', '542222', '扎囊县', 'BM_DISTRICT', '542200');
INSERT INTO `code` VALUES ('1219', '542223', '贡嘎县', 'BM_DISTRICT', '542200');
INSERT INTO `code` VALUES ('1220', '542224', '桑日县', 'BM_DISTRICT', '542200');
INSERT INTO `code` VALUES ('1221', '542225', '琼结县', 'BM_DISTRICT', '542200');
INSERT INTO `code` VALUES ('1222', '542226', '曲松县', 'BM_DISTRICT', '542200');
INSERT INTO `code` VALUES ('1223', '542227', '措美县', 'BM_DISTRICT', '542200');
INSERT INTO `code` VALUES ('1224', '542228', '洛扎县', 'BM_DISTRICT', '542200');
INSERT INTO `code` VALUES ('1225', '542229', '加查县', 'BM_DISTRICT', '542200');
INSERT INTO `code` VALUES ('1226', '542231', '隆子县', 'BM_DISTRICT', '542200');
INSERT INTO `code` VALUES ('1227', '542232', '错那县', 'BM_DISTRICT', '542200');
INSERT INTO `code` VALUES ('1228', '542233', '浪卡子县', 'BM_DISTRICT', '542200');
INSERT INTO `code` VALUES ('1229', '542300', '日喀则地区', 'BM_DISTRICT', '540000');
INSERT INTO `code` VALUES ('1230', '542301', '日喀则市', 'BM_DISTRICT', '542300');
INSERT INTO `code` VALUES ('1231', '542322', '南木林县', 'BM_DISTRICT', '542300');
INSERT INTO `code` VALUES ('1232', '542323', '江孜县', 'BM_DISTRICT', '542300');
INSERT INTO `code` VALUES ('1233', '542324', '定日县', 'BM_DISTRICT', '542300');
INSERT INTO `code` VALUES ('1234', '542325', '萨迦县', 'BM_DISTRICT', '542300');
INSERT INTO `code` VALUES ('1235', '542326', '拉孜县', 'BM_DISTRICT', '542300');
INSERT INTO `code` VALUES ('1236', '140500', '晋城市', 'BM_DISTRICT', '140000');
INSERT INTO `code` VALUES ('1237', '140501', '晋城市市辖区', 'BM_DISTRICT', '140500');
INSERT INTO `code` VALUES ('1238', '140502', '城区', 'BM_DISTRICT', '140500');
INSERT INTO `code` VALUES ('1239', '140521', '沁水县', 'BM_DISTRICT', '140500');
INSERT INTO `code` VALUES ('1240', '140522', '阳城县', 'BM_DISTRICT', '140500');
INSERT INTO `code` VALUES ('1241', '340604', '烈山区', 'BM_DISTRICT', '340600');
INSERT INTO `code` VALUES ('1242', '340621', '濉溪县', 'BM_DISTRICT', '340600');
INSERT INTO `code` VALUES ('1243', '340700', '铜陵市', 'BM_DISTRICT', '340000');
INSERT INTO `code` VALUES ('1244', '340701', '市辖区', 'BM_DISTRICT', '340700');
INSERT INTO `code` VALUES ('1245', '340702', '铜官山区', 'BM_DISTRICT', '340700');
INSERT INTO `code` VALUES ('1246', '340703', '狮子山区', 'BM_DISTRICT', '340700');
INSERT INTO `code` VALUES ('1247', '340711', '郊区', 'BM_DISTRICT', '340700');
INSERT INTO `code` VALUES ('1248', '340721', '铜陵县', 'BM_DISTRICT', '340700');
INSERT INTO `code` VALUES ('1249', '340800', '安庆市', 'BM_DISTRICT', '340000');
INSERT INTO `code` VALUES ('1250', '340801', '市辖区', 'BM_DISTRICT', '340800');
INSERT INTO `code` VALUES ('1251', '340802', '迎江区', 'BM_DISTRICT', '340800');
INSERT INTO `code` VALUES ('1252', '340803', '大观区', 'BM_DISTRICT', '340800');
INSERT INTO `code` VALUES ('1253', '340811', '宜秀区', 'BM_DISTRICT', '340800');
INSERT INTO `code` VALUES ('1254', '340822', '怀宁县', 'BM_DISTRICT', '340800');
INSERT INTO `code` VALUES ('1255', '340823', '枞阳县', 'BM_DISTRICT', '340800');
INSERT INTO `code` VALUES ('1256', '340824', '潜山县', 'BM_DISTRICT', '340800');
INSERT INTO `code` VALUES ('1257', '340825', '太湖县', 'BM_DISTRICT', '340800');
INSERT INTO `code` VALUES ('1258', '340826', '宿松县', 'BM_DISTRICT', '340800');
INSERT INTO `code` VALUES ('1259', '340827', '望江县', 'BM_DISTRICT', '340800');
INSERT INTO `code` VALUES ('1260', '340828', '岳西县', 'BM_DISTRICT', '340800');
INSERT INTO `code` VALUES ('1261', '340881', '桐城市', 'BM_DISTRICT', '340800');
INSERT INTO `code` VALUES ('1262', '341000', '黄山市', 'BM_DISTRICT', '340000');
INSERT INTO `code` VALUES ('1263', '341001', '市辖区', 'BM_DISTRICT', '341000');
INSERT INTO `code` VALUES ('1264', '341002', '屯溪区', 'BM_DISTRICT', '341000');
INSERT INTO `code` VALUES ('1265', '341003', '黄山区', 'BM_DISTRICT', '341000');
INSERT INTO `code` VALUES ('1266', '341004', '徽州区', 'BM_DISTRICT', '341000');
INSERT INTO `code` VALUES ('1267', '341021', '歙县', 'BM_DISTRICT', '341000');
INSERT INTO `code` VALUES ('1268', '341022', '休宁县', 'BM_DISTRICT', '341000');
INSERT INTO `code` VALUES ('1269', '341023', '黟县', 'BM_DISTRICT', '341000');
INSERT INTO `code` VALUES ('1270', '341024', '祁门县', 'BM_DISTRICT', '341000');
INSERT INTO `code` VALUES ('1271', '341100', '滁州市', 'BM_DISTRICT', '340000');
INSERT INTO `code` VALUES ('1272', '341101', '市辖区', 'BM_DISTRICT', '341100');
INSERT INTO `code` VALUES ('1273', '341102', '琅琊区', 'BM_DISTRICT', '341100');
INSERT INTO `code` VALUES ('1274', '341103', '南谯区', 'BM_DISTRICT', '341100');
INSERT INTO `code` VALUES ('1275', '341122', '来安县', 'BM_DISTRICT', '341100');
INSERT INTO `code` VALUES ('1276', '341124', '全椒县', 'BM_DISTRICT', '341100');
INSERT INTO `code` VALUES ('1277', '341125', '定远县', 'BM_DISTRICT', '341100');
INSERT INTO `code` VALUES ('1278', '341126', '凤阳县', 'BM_DISTRICT', '341100');
INSERT INTO `code` VALUES ('1279', '341181', '天长市', 'BM_DISTRICT', '341100');
INSERT INTO `code` VALUES ('1280', '341182', '明光市', 'BM_DISTRICT', '341100');
INSERT INTO `code` VALUES ('1281', '341200', '阜阳市', 'BM_DISTRICT', '340000');
INSERT INTO `code` VALUES ('1282', '341201', '市辖区', 'BM_DISTRICT', '341200');
INSERT INTO `code` VALUES ('1283', '341202', '颍州区', 'BM_DISTRICT', '341200');
INSERT INTO `code` VALUES ('1284', '341203', '颍东区', 'BM_DISTRICT', '341200');
INSERT INTO `code` VALUES ('1285', '341204', '颍泉区', 'BM_DISTRICT', '341200');
INSERT INTO `code` VALUES ('1286', '341221', '临泉县', 'BM_DISTRICT', '341200');
INSERT INTO `code` VALUES ('1287', '341222', '太和县', 'BM_DISTRICT', '341200');
INSERT INTO `code` VALUES ('1288', '341225', '阜南县', 'BM_DISTRICT', '341200');
INSERT INTO `code` VALUES ('1289', '341226', '颍上县', 'BM_DISTRICT', '341200');
INSERT INTO `code` VALUES ('1290', '341282', '界首市', 'BM_DISTRICT', '341200');
INSERT INTO `code` VALUES ('1291', '341300', '宿州市', 'BM_DISTRICT', '340000');
INSERT INTO `code` VALUES ('1292', '341301', '市辖区', 'BM_DISTRICT', '341300');
INSERT INTO `code` VALUES ('1293', '341302', '埇桥区', 'BM_DISTRICT', '341300');
INSERT INTO `code` VALUES ('1294', '341321', '砀山县', 'BM_DISTRICT', '341300');
INSERT INTO `code` VALUES ('1295', '522636', '丹寨县', 'BM_DISTRICT', '522600');
INSERT INTO `code` VALUES ('1296', '522700', '黔南布依族苗族自治州', 'BM_DISTRICT', '520000');
INSERT INTO `code` VALUES ('1297', '522701', '都匀市', 'BM_DISTRICT', '522700');
INSERT INTO `code` VALUES ('1298', '522702', '福泉市', 'BM_DISTRICT', '522700');
INSERT INTO `code` VALUES ('1299', '522722', '荔波县', 'BM_DISTRICT', '522700');
INSERT INTO `code` VALUES ('1300', '522723', '贵定县', 'BM_DISTRICT', '522700');
INSERT INTO `code` VALUES ('1301', '522725', '瓮安县', 'BM_DISTRICT', '522700');
INSERT INTO `code` VALUES ('1302', '522726', '独山县', 'BM_DISTRICT', '522700');
INSERT INTO `code` VALUES ('1303', '522727', '平塘县', 'BM_DISTRICT', '522700');
INSERT INTO `code` VALUES ('1304', '522728', '罗甸县', 'BM_DISTRICT', '522700');
INSERT INTO `code` VALUES ('1305', '522729', '长顺县', 'BM_DISTRICT', '522700');
INSERT INTO `code` VALUES ('1306', '522730', '龙里县', 'BM_DISTRICT', '522700');
INSERT INTO `code` VALUES ('1307', '522731', '惠水县', 'BM_DISTRICT', '522700');
INSERT INTO `code` VALUES ('1308', '522732', '三都水族自治县', 'BM_DISTRICT', '522700');
INSERT INTO `code` VALUES ('1309', '530000', '云南省', 'BM_DISTRICT', null);
INSERT INTO `code` VALUES ('1310', '530100', '昆明市', 'BM_DISTRICT', '530000');
INSERT INTO `code` VALUES ('1311', '530101', '市辖区', 'BM_DISTRICT', '530100');
INSERT INTO `code` VALUES ('1312', '530102', '五华区', 'BM_DISTRICT', '530100');
INSERT INTO `code` VALUES ('1313', '530103', '盘龙区', 'BM_DISTRICT', '530100');
INSERT INTO `code` VALUES ('1314', '530111', '官渡区', 'BM_DISTRICT', '530100');
INSERT INTO `code` VALUES ('1315', '530112', '西山区', 'BM_DISTRICT', '530100');
INSERT INTO `code` VALUES ('1316', '530113', '东川区', 'BM_DISTRICT', '530100');
INSERT INTO `code` VALUES ('1317', '530114', '呈贡区', 'BM_DISTRICT', '530100');
INSERT INTO `code` VALUES ('1318', '530122', '晋宁县', 'BM_DISTRICT', '530100');
INSERT INTO `code` VALUES ('1319', '530124', '富民县', 'BM_DISTRICT', '530100');
INSERT INTO `code` VALUES ('1320', '530125', '宜良县', 'BM_DISTRICT', '530100');
INSERT INTO `code` VALUES ('1321', '530126', '石林彝族自治县', 'BM_DISTRICT', '530100');
INSERT INTO `code` VALUES ('1322', '530127', '嵩明县', 'BM_DISTRICT', '530100');
INSERT INTO `code` VALUES ('1323', '530128', '禄劝彝族苗族自治县', 'BM_DISTRICT', '530100');
INSERT INTO `code` VALUES ('1324', '530129', '寻甸回族彝族自治县', 'BM_DISTRICT', '530100');
INSERT INTO `code` VALUES ('1325', '530181', '安宁市', 'BM_DISTRICT', '530100');
INSERT INTO `code` VALUES ('1326', '530300', '曲靖市', 'BM_DISTRICT', '530000');
INSERT INTO `code` VALUES ('1327', '530301', '市辖区', 'BM_DISTRICT', '530300');
INSERT INTO `code` VALUES ('1328', '530302', '麒麟区', 'BM_DISTRICT', '530300');
INSERT INTO `code` VALUES ('1329', '530321', '马龙县', 'BM_DISTRICT', '530300');
INSERT INTO `code` VALUES ('1330', '530322', '陆良县', 'BM_DISTRICT', '530300');
INSERT INTO `code` VALUES ('1331', '530323', '师宗县', 'BM_DISTRICT', '530300');
INSERT INTO `code` VALUES ('1332', '530324', '罗平县', 'BM_DISTRICT', '530300');
INSERT INTO `code` VALUES ('1333', '530325', '富源县', 'BM_DISTRICT', '530300');
INSERT INTO `code` VALUES ('1334', '530326', '会泽县', 'BM_DISTRICT', '530300');
INSERT INTO `code` VALUES ('1335', '530328', '沾益县', 'BM_DISTRICT', '530300');
INSERT INTO `code` VALUES ('1336', '530381', '宣威市', 'BM_DISTRICT', '530300');
INSERT INTO `code` VALUES ('1337', '530400', '玉溪市', 'BM_DISTRICT', '530000');
INSERT INTO `code` VALUES ('1338', '530402', '红塔区', 'BM_DISTRICT', '530400');
INSERT INTO `code` VALUES ('1339', '530421', '江川县', 'BM_DISTRICT', '530400');
INSERT INTO `code` VALUES ('1340', '530422', '澄江县', 'BM_DISTRICT', '530400');
INSERT INTO `code` VALUES ('1341', '530423', '通海县', 'BM_DISTRICT', '530400');
INSERT INTO `code` VALUES ('1342', '530424', '华宁县', 'BM_DISTRICT', '530400');
INSERT INTO `code` VALUES ('1343', '530425', '易门县', 'BM_DISTRICT', '530400');
INSERT INTO `code` VALUES ('1344', '621225', '西和县', 'BM_DISTRICT', '621200');
INSERT INTO `code` VALUES ('1345', '621226', '礼县', 'BM_DISTRICT', '621200');
INSERT INTO `code` VALUES ('1346', '621227', '徽县', 'BM_DISTRICT', '621200');
INSERT INTO `code` VALUES ('1347', '621228', '两当县', 'BM_DISTRICT', '621200');
INSERT INTO `code` VALUES ('1348', '622900', '临夏回族自治州', 'BM_DISTRICT', '620000');
INSERT INTO `code` VALUES ('1349', '622901', '临夏市', 'BM_DISTRICT', '622900');
INSERT INTO `code` VALUES ('1350', '622921', '临夏县', 'BM_DISTRICT', '622900');
INSERT INTO `code` VALUES ('1351', '622922', '康乐县', 'BM_DISTRICT', '622900');
INSERT INTO `code` VALUES ('1352', '622923', '永靖县', 'BM_DISTRICT', '622900');
INSERT INTO `code` VALUES ('1353', '622924', '广河县', 'BM_DISTRICT', '622900');
INSERT INTO `code` VALUES ('1354', '622925', '和政县', 'BM_DISTRICT', '622900');
INSERT INTO `code` VALUES ('1355', '622926', '东乡族自治县', 'BM_DISTRICT', '622900');
INSERT INTO `code` VALUES ('1356', '622927', '积石山保安族东乡族撒拉族自治县', 'BM_DISTRICT', '622900');
INSERT INTO `code` VALUES ('1357', '623000', '甘南藏族自治州', 'BM_DISTRICT', '620000');
INSERT INTO `code` VALUES ('1358', '623001', '合作市', 'BM_DISTRICT', '623000');
INSERT INTO `code` VALUES ('1359', '623021', '临潭县', 'BM_DISTRICT', '623000');
INSERT INTO `code` VALUES ('1360', '623022', '卓尼县', 'BM_DISTRICT', '623000');
INSERT INTO `code` VALUES ('1361', '623023', '舟曲县', 'BM_DISTRICT', '623000');
INSERT INTO `code` VALUES ('1362', '623024', '迭部县', 'BM_DISTRICT', '623000');
INSERT INTO `code` VALUES ('1363', '623025', '玛曲县', 'BM_DISTRICT', '623000');
INSERT INTO `code` VALUES ('1364', '623026', '碌曲县', 'BM_DISTRICT', '623000');
INSERT INTO `code` VALUES ('1365', '623027', '夏河县', 'BM_DISTRICT', '623000');
INSERT INTO `code` VALUES ('1366', '630000', '青海省', 'BM_DISTRICT', null);
INSERT INTO `code` VALUES ('1367', '630100', '西宁市', 'BM_DISTRICT', '630000');
INSERT INTO `code` VALUES ('1368', '630101', '市辖区', 'BM_DISTRICT', '630100');
INSERT INTO `code` VALUES ('1369', '630102', '城东区', 'BM_DISTRICT', '630100');
INSERT INTO `code` VALUES ('1370', '630103', '城中区', 'BM_DISTRICT', '630100');
INSERT INTO `code` VALUES ('1371', '630104', '城西区', 'BM_DISTRICT', '630100');
INSERT INTO `code` VALUES ('1372', '630105', '城北区', 'BM_DISTRICT', '630100');
INSERT INTO `code` VALUES ('1373', '630121', '大通回族土族自治县', 'BM_DISTRICT', '630100');
INSERT INTO `code` VALUES ('1374', '630122', '湟中县', 'BM_DISTRICT', '630100');
INSERT INTO `code` VALUES ('1375', '630123', '湟源县', 'BM_DISTRICT', '630100');
INSERT INTO `code` VALUES ('1376', '632100', '海东地区', 'BM_DISTRICT', '630000');
INSERT INTO `code` VALUES ('1377', '632121', '平安县', 'BM_DISTRICT', '632100');
INSERT INTO `code` VALUES ('1378', '632122', '民和回族土族自治县', 'BM_DISTRICT', '632100');
INSERT INTO `code` VALUES ('1379', '632123', '乐都县', 'BM_DISTRICT', '632100');
INSERT INTO `code` VALUES ('1380', '632126', '互助土族自治县', 'BM_DISTRICT', '632100');
INSERT INTO `code` VALUES ('1381', '632127', '化隆回族自治县', 'BM_DISTRICT', '632100');
INSERT INTO `code` VALUES ('1382', '632128', '循化撒拉族自治县', 'BM_DISTRICT', '632100');
INSERT INTO `code` VALUES ('1383', '632200', '海北藏族自治州', 'BM_DISTRICT', '630000');
INSERT INTO `code` VALUES ('1384', '542327', '昂仁县', 'BM_DISTRICT', '542300');
INSERT INTO `code` VALUES ('1385', '542328', '谢通门县', 'BM_DISTRICT', '542300');
INSERT INTO `code` VALUES ('1386', '542329', '白朗县', 'BM_DISTRICT', '542300');
INSERT INTO `code` VALUES ('1387', '542330', '仁布县', 'BM_DISTRICT', '542300');
INSERT INTO `code` VALUES ('1388', '542331', '康马县', 'BM_DISTRICT', '542300');
INSERT INTO `code` VALUES ('1389', '542332', '定结县', 'BM_DISTRICT', '542300');
INSERT INTO `code` VALUES ('1390', '542333', '仲巴县', 'BM_DISTRICT', '542300');
INSERT INTO `code` VALUES ('1391', '542334', '亚东县', 'BM_DISTRICT', '542300');
INSERT INTO `code` VALUES ('1392', '542335', '吉隆县', 'BM_DISTRICT', '542300');
INSERT INTO `code` VALUES ('1393', '542336', '聂拉木县', 'BM_DISTRICT', '542300');
INSERT INTO `code` VALUES ('1394', '542337', '萨嘎县', 'BM_DISTRICT', '542300');
INSERT INTO `code` VALUES ('1395', '542338', '岗巴县', 'BM_DISTRICT', '542300');
INSERT INTO `code` VALUES ('1396', '542400', '那曲地区', 'BM_DISTRICT', '540000');
INSERT INTO `code` VALUES ('1397', '542421', '那曲县', 'BM_DISTRICT', '542400');
INSERT INTO `code` VALUES ('1398', '542422', '嘉黎县', 'BM_DISTRICT', '542400');
INSERT INTO `code` VALUES ('1399', '542423', '比如县', 'BM_DISTRICT', '542400');
INSERT INTO `code` VALUES ('1400', '542424', '聂荣县', 'BM_DISTRICT', '542400');
INSERT INTO `code` VALUES ('1401', '542425', '安多县', 'BM_DISTRICT', '542400');
INSERT INTO `code` VALUES ('1402', '542426', '申扎县', 'BM_DISTRICT', '542400');
INSERT INTO `code` VALUES ('1403', '542427', '索县', 'BM_DISTRICT', '542400');
INSERT INTO `code` VALUES ('1404', '542428', '班戈县', 'BM_DISTRICT', '542400');
INSERT INTO `code` VALUES ('1405', '542429', '巴青县', 'BM_DISTRICT', '542400');
INSERT INTO `code` VALUES ('1406', '542430', '尼玛县', 'BM_DISTRICT', '542400');
INSERT INTO `code` VALUES ('1407', '542500', '阿里地区', 'BM_DISTRICT', '540000');
INSERT INTO `code` VALUES ('1408', '542521', '普兰县', 'BM_DISTRICT', '542500');
INSERT INTO `code` VALUES ('1409', '542522', '札达县', 'BM_DISTRICT', '542500');
INSERT INTO `code` VALUES ('1410', '542523', '噶尔县', 'BM_DISTRICT', '542500');
INSERT INTO `code` VALUES ('1411', '542524', '日土县', 'BM_DISTRICT', '542500');
INSERT INTO `code` VALUES ('1412', '542525', '革吉县', 'BM_DISTRICT', '542500');
INSERT INTO `code` VALUES ('1413', '542526', '改则县', 'BM_DISTRICT', '542500');
INSERT INTO `code` VALUES ('1414', '350304', '荔城区', 'BM_DISTRICT', '350300');
INSERT INTO `code` VALUES ('1415', '350305', '秀屿区', 'BM_DISTRICT', '350300');
INSERT INTO `code` VALUES ('1416', '350322', '仙游县', 'BM_DISTRICT', '350300');
INSERT INTO `code` VALUES ('1417', '350400', '三明市', 'BM_DISTRICT', '350000');
INSERT INTO `code` VALUES ('1418', '441421', '梅县', 'BM_DISTRICT', '441400');
INSERT INTO `code` VALUES ('1419', '441422', '大埔县', 'BM_DISTRICT', '441400');
INSERT INTO `code` VALUES ('1420', '441423', '丰顺县', 'BM_DISTRICT', '441400');
INSERT INTO `code` VALUES ('1421', '441424', '五华县', 'BM_DISTRICT', '441400');
INSERT INTO `code` VALUES ('1422', '441426', '平远县', 'BM_DISTRICT', '441400');
INSERT INTO `code` VALUES ('1423', '441427', '蕉岭县', 'BM_DISTRICT', '441400');
INSERT INTO `code` VALUES ('1424', '441481', '兴宁市', 'BM_DISTRICT', '441400');
INSERT INTO `code` VALUES ('1425', '441500', '汕尾市', 'BM_DISTRICT', '440000');
INSERT INTO `code` VALUES ('1426', '441501', '市辖区', 'BM_DISTRICT', '441500');
INSERT INTO `code` VALUES ('1427', '441502', '城区', 'BM_DISTRICT', '441500');
INSERT INTO `code` VALUES ('1428', '441521', '海丰县', 'BM_DISTRICT', '441500');
INSERT INTO `code` VALUES ('1429', '441523', '陆河县', 'BM_DISTRICT', '441500');
INSERT INTO `code` VALUES ('1430', '441581', '陆丰市', 'BM_DISTRICT', '441500');
INSERT INTO `code` VALUES ('1431', '441600', '河源市', 'BM_DISTRICT', '440000');
INSERT INTO `code` VALUES ('1432', '441601', '市辖区', 'BM_DISTRICT', '441600');
INSERT INTO `code` VALUES ('1433', '441602', '源城区', 'BM_DISTRICT', '441600');
INSERT INTO `code` VALUES ('1434', '441621', '紫金县', 'BM_DISTRICT', '441600');
INSERT INTO `code` VALUES ('1435', '441622', '龙川县', 'BM_DISTRICT', '441600');
INSERT INTO `code` VALUES ('1436', '441623', '连平县', 'BM_DISTRICT', '441600');
INSERT INTO `code` VALUES ('1437', '441624', '和平县', 'BM_DISTRICT', '441600');
INSERT INTO `code` VALUES ('1438', '441625', '东源县', 'BM_DISTRICT', '441600');
INSERT INTO `code` VALUES ('1439', '441700', '阳江市', 'BM_DISTRICT', '440000');
INSERT INTO `code` VALUES ('1440', '441701', '市辖区', 'BM_DISTRICT', '441700');
INSERT INTO `code` VALUES ('1441', '441702', '江城区', 'BM_DISTRICT', '441700');
INSERT INTO `code` VALUES ('1442', '441721', '阳西县', 'BM_DISTRICT', '441700');
INSERT INTO `code` VALUES ('1443', '441723', '阳东县', 'BM_DISTRICT', '441700');
INSERT INTO `code` VALUES ('1444', '441781', '阳春市', 'BM_DISTRICT', '441700');
INSERT INTO `code` VALUES ('1445', '441800', '清远市', 'BM_DISTRICT', '440000');
INSERT INTO `code` VALUES ('1446', '441801', '市辖区', 'BM_DISTRICT', '441800');
INSERT INTO `code` VALUES ('1447', '441802', '清城区', 'BM_DISTRICT', '441800');
INSERT INTO `code` VALUES ('1448', '441821', '佛冈县', 'BM_DISTRICT', '441800');
INSERT INTO `code` VALUES ('1449', '441823', '阳山县', 'BM_DISTRICT', '441800');
INSERT INTO `code` VALUES ('1450', '441825', '连山壮族瑶族自治县', 'BM_DISTRICT', '441800');
INSERT INTO `code` VALUES ('1451', '441826', '连南瑶族自治县', 'BM_DISTRICT', '441800');
INSERT INTO `code` VALUES ('1452', '441827', '清新县', 'BM_DISTRICT', '441800');
INSERT INTO `code` VALUES ('1453', '441881', '英德市', 'BM_DISTRICT', '441800');
INSERT INTO `code` VALUES ('1454', '441882', '连州市', 'BM_DISTRICT', '441800');
INSERT INTO `code` VALUES ('1455', '441900', '东莞市', 'BM_DISTRICT', '440000');
INSERT INTO `code` VALUES ('1456', '442000', '中山市', 'BM_DISTRICT', '440000');
INSERT INTO `code` VALUES ('1457', '445100', '潮州市', 'BM_DISTRICT', '440000');
INSERT INTO `code` VALUES ('1458', '445101', '市辖区', 'BM_DISTRICT', '445100');
INSERT INTO `code` VALUES ('1459', '445102', '湘桥区', 'BM_DISTRICT', '445100');
INSERT INTO `code` VALUES ('1460', '445121', '潮安县', 'BM_DISTRICT', '445100');
INSERT INTO `code` VALUES ('1461', '445122', '饶平县', 'BM_DISTRICT', '445100');
INSERT INTO `code` VALUES ('1462', '445200', '揭阳市', 'BM_DISTRICT', '440000');
INSERT INTO `code` VALUES ('1463', '445201', '市辖区', 'BM_DISTRICT', '445200');
INSERT INTO `code` VALUES ('1464', '445202', '榕城区', 'BM_DISTRICT', '445200');
INSERT INTO `code` VALUES ('1465', '445221', '揭东县', 'BM_DISTRICT', '445200');
INSERT INTO `code` VALUES ('1466', '445222', '揭西县', 'BM_DISTRICT', '445200');
INSERT INTO `code` VALUES ('1467', '445224', '惠来县', 'BM_DISTRICT', '445200');
INSERT INTO `code` VALUES ('1468', '445281', '普宁市', 'BM_DISTRICT', '445200');
INSERT INTO `code` VALUES ('1469', '445300', '云浮市', 'BM_DISTRICT', '440000');
INSERT INTO `code` VALUES ('1470', '445301', '市辖区', 'BM_DISTRICT', '445300');
INSERT INTO `code` VALUES ('1471', '445302', '云城区', 'BM_DISTRICT', '445300');
INSERT INTO `code` VALUES ('1472', '445321', '新兴县', 'BM_DISTRICT', '445300');
INSERT INTO `code` VALUES ('1473', '150401', '市辖区', 'BM_DISTRICT', '150400');
INSERT INTO `code` VALUES ('1474', '150402', '红山区', 'BM_DISTRICT', '150400');
INSERT INTO `code` VALUES ('1475', '150403', '元宝山区', 'BM_DISTRICT', '150400');
INSERT INTO `code` VALUES ('1476', '150404', '松山区', 'BM_DISTRICT', '150400');
INSERT INTO `code` VALUES ('1477', '150421', '阿鲁科尔沁旗', 'BM_DISTRICT', '150400');
INSERT INTO `code` VALUES ('1478', '150422', '巴林左旗', 'BM_DISTRICT', '150400');
INSERT INTO `code` VALUES ('1479', '150423', '巴林右旗', 'BM_DISTRICT', '150400');
INSERT INTO `code` VALUES ('1480', '150424', '林西县', 'BM_DISTRICT', '150400');
INSERT INTO `code` VALUES ('1481', '150425', '克什克腾旗', 'BM_DISTRICT', '150400');
INSERT INTO `code` VALUES ('1482', '150426', '翁牛特旗', 'BM_DISTRICT', '150400');
INSERT INTO `code` VALUES ('1483', '150428', '喀喇沁旗', 'BM_DISTRICT', '150400');
INSERT INTO `code` VALUES ('1484', '150429', '宁城县', 'BM_DISTRICT', '150400');
INSERT INTO `code` VALUES ('1485', '150430', '敖汉旗', 'BM_DISTRICT', '150400');
INSERT INTO `code` VALUES ('1486', '150500', '通辽市', 'BM_DISTRICT', '150000');
INSERT INTO `code` VALUES ('1487', '150501', '市辖区', 'BM_DISTRICT', '150500');
INSERT INTO `code` VALUES ('1488', '150502', '科尔沁区', 'BM_DISTRICT', '150500');
INSERT INTO `code` VALUES ('1489', '150521', '科尔沁左翼中旗', 'BM_DISTRICT', '150500');
INSERT INTO `code` VALUES ('1490', '150522', '科尔沁左翼后旗', 'BM_DISTRICT', '150500');
INSERT INTO `code` VALUES ('1491', '150523', '开鲁县', 'BM_DISTRICT', '150500');
INSERT INTO `code` VALUES ('1492', '150524', '库伦旗', 'BM_DISTRICT', '150500');
INSERT INTO `code` VALUES ('1493', '150525', '奈曼旗', 'BM_DISTRICT', '150500');
INSERT INTO `code` VALUES ('1494', '150526', '扎鲁特旗', 'BM_DISTRICT', '150500');
INSERT INTO `code` VALUES ('1495', '150581', '霍林郭勒市', 'BM_DISTRICT', '150500');
INSERT INTO `code` VALUES ('1496', '150600', '鄂尔多斯市', 'BM_DISTRICT', '150000');
INSERT INTO `code` VALUES ('1497', '150601', '市辖区', 'BM_DISTRICT', '150600');
INSERT INTO `code` VALUES ('1498', '150602', '东胜区', 'BM_DISTRICT', '150600');
INSERT INTO `code` VALUES ('1499', '150621', '达拉特旗', 'BM_DISTRICT', '150600');
INSERT INTO `code` VALUES ('1500', '150622', '准格尔旗', 'BM_DISTRICT', '150600');
INSERT INTO `code` VALUES ('1501', '150623', '鄂托克前旗', 'BM_DISTRICT', '150600');
INSERT INTO `code` VALUES ('1502', '150624', '鄂托克旗', 'BM_DISTRICT', '150600');
INSERT INTO `code` VALUES ('1503', '150625', '杭锦旗', 'BM_DISTRICT', '150600');
INSERT INTO `code` VALUES ('1504', '150626', '乌审旗', 'BM_DISTRICT', '150600');
INSERT INTO `code` VALUES ('1505', '150627', '伊金霍洛旗', 'BM_DISTRICT', '150600');
INSERT INTO `code` VALUES ('1506', '150700', '呼伦贝尔市', 'BM_DISTRICT', '150000');
INSERT INTO `code` VALUES ('1507', '150701', '市辖区', 'BM_DISTRICT', '150700');
INSERT INTO `code` VALUES ('1508', '150702', '海拉尔区', 'BM_DISTRICT', '150700');
INSERT INTO `code` VALUES ('1509', '150721', '阿荣旗', 'BM_DISTRICT', '150700');
INSERT INTO `code` VALUES ('1510', '150722', '莫力达瓦达斡尔族自治旗', 'BM_DISTRICT', '150700');
INSERT INTO `code` VALUES ('1511', '150723', '鄂伦春自治旗', 'BM_DISTRICT', '150700');
INSERT INTO `code` VALUES ('1512', '150724', '鄂温克族自治旗', 'BM_DISTRICT', '150700');
INSERT INTO `code` VALUES ('1513', '150725', '陈巴尔虎旗', 'BM_DISTRICT', '150700');
INSERT INTO `code` VALUES ('1514', '150726', '新巴尔虎左旗', 'BM_DISTRICT', '150700');
INSERT INTO `code` VALUES ('1515', '150727', '新巴尔虎右旗', 'BM_DISTRICT', '150700');
INSERT INTO `code` VALUES ('1516', '150781', '满洲里市', 'BM_DISTRICT', '150700');
INSERT INTO `code` VALUES ('1517', '150782', '牙克石市', 'BM_DISTRICT', '150700');
INSERT INTO `code` VALUES ('1518', '150783', '扎兰屯市', 'BM_DISTRICT', '150700');
INSERT INTO `code` VALUES ('1519', '150784', '额尔古纳市', 'BM_DISTRICT', '150700');
INSERT INTO `code` VALUES ('1520', '150785', '根河市', 'BM_DISTRICT', '150700');
INSERT INTO `code` VALUES ('1521', '150800', '巴彦淖尔市', 'BM_DISTRICT', '150000');
INSERT INTO `code` VALUES ('1522', '150801', '市辖区', 'BM_DISTRICT', '150800');
INSERT INTO `code` VALUES ('1523', '150802', '临河区', 'BM_DISTRICT', '150800');
INSERT INTO `code` VALUES ('1524', '150821', '五原县', 'BM_DISTRICT', '150800');
INSERT INTO `code` VALUES ('1525', '150822', '磴口县', 'BM_DISTRICT', '150800');
INSERT INTO `code` VALUES ('1526', '150823', '乌拉特前旗', 'BM_DISTRICT', '150800');
INSERT INTO `code` VALUES ('1527', '150824', '乌拉特中旗', 'BM_DISTRICT', '150800');
INSERT INTO `code` VALUES ('1528', '431230', '通道侗族自治县', 'BM_DISTRICT', '431200');
INSERT INTO `code` VALUES ('1529', '431281', '洪江市', 'BM_DISTRICT', '431200');
INSERT INTO `code` VALUES ('1530', '431300', '娄底市', 'BM_DISTRICT', '430000');
INSERT INTO `code` VALUES ('1531', '520381', '赤水市', 'BM_DISTRICT', '520300');
INSERT INTO `code` VALUES ('1532', '520382', '仁怀市', 'BM_DISTRICT', '520300');
INSERT INTO `code` VALUES ('1533', '520400', '安顺市', 'BM_DISTRICT', '520000');
INSERT INTO `code` VALUES ('1534', '520401', '市辖区', 'BM_DISTRICT', '520400');
INSERT INTO `code` VALUES ('1535', '520402', '西秀区', 'BM_DISTRICT', '520400');
INSERT INTO `code` VALUES ('1536', '520421', '平坝县', 'BM_DISTRICT', '520400');
INSERT INTO `code` VALUES ('1537', '520422', '普定县', 'BM_DISTRICT', '520400');
INSERT INTO `code` VALUES ('1538', '520423', '镇宁布依族苗族自治县', 'BM_DISTRICT', '520400');
INSERT INTO `code` VALUES ('1539', '520424', '关岭布依族苗族自治县', 'BM_DISTRICT', '520400');
INSERT INTO `code` VALUES ('1540', '520425', '紫云苗族布依族自治县', 'BM_DISTRICT', '520400');
INSERT INTO `code` VALUES ('1541', '520500', '毕节市', 'BM_DISTRICT', '520000');
INSERT INTO `code` VALUES ('1542', '520502', '七星关区', 'BM_DISTRICT', '520500');
INSERT INTO `code` VALUES ('1543', '520521', '大方县', 'BM_DISTRICT', '520500');
INSERT INTO `code` VALUES ('1544', '520522', '黔西县', 'BM_DISTRICT', '520500');
INSERT INTO `code` VALUES ('1545', '520523', '金沙县', 'BM_DISTRICT', '520500');
INSERT INTO `code` VALUES ('1546', '520524', '织金县', 'BM_DISTRICT', '520500');
INSERT INTO `code` VALUES ('1547', '520525', '纳雍县', 'BM_DISTRICT', '520500');
INSERT INTO `code` VALUES ('1548', '520526', '威宁彝族回族苗族自治县', 'BM_DISTRICT', '520500');
INSERT INTO `code` VALUES ('1549', '520527', '赫章县', 'BM_DISTRICT', '520500');
INSERT INTO `code` VALUES ('1550', '520600', '铜仁市', 'BM_DISTRICT', '520000');
INSERT INTO `code` VALUES ('1551', '520602', '碧江区', 'BM_DISTRICT', '520600');
INSERT INTO `code` VALUES ('1552', '520603', '万山区', 'BM_DISTRICT', '520600');
INSERT INTO `code` VALUES ('1553', '520621', '江口县', 'BM_DISTRICT', '520600');
INSERT INTO `code` VALUES ('1554', '520622', '玉屏侗族自治县', 'BM_DISTRICT', '520600');
INSERT INTO `code` VALUES ('1555', '520623', '石阡县', 'BM_DISTRICT', '520600');
INSERT INTO `code` VALUES ('1556', '520624', '思南县', 'BM_DISTRICT', '520600');
INSERT INTO `code` VALUES ('1557', '520625', '印江土家族苗族自治县', 'BM_DISTRICT', '520600');
INSERT INTO `code` VALUES ('1558', '520626', '德江县', 'BM_DISTRICT', '520600');
INSERT INTO `code` VALUES ('1559', '520627', '沿河土家族自治县', 'BM_DISTRICT', '520600');
INSERT INTO `code` VALUES ('1560', '520628', '松桃苗族自治县', 'BM_DISTRICT', '520600');
INSERT INTO `code` VALUES ('1561', '522300', '黔西南布依族苗族自治州', 'BM_DISTRICT', '520000');
INSERT INTO `code` VALUES ('1562', '522301', '兴义市', 'BM_DISTRICT', '522300');
INSERT INTO `code` VALUES ('1563', '522322', '兴仁县', 'BM_DISTRICT', '522300');
INSERT INTO `code` VALUES ('1564', '522323', '普安县', 'BM_DISTRICT', '522300');
INSERT INTO `code` VALUES ('1565', '522324', '晴隆县', 'BM_DISTRICT', '522300');
INSERT INTO `code` VALUES ('1566', '522325', '贞丰县', 'BM_DISTRICT', '522300');
INSERT INTO `code` VALUES ('1567', '522326', '望谟县', 'BM_DISTRICT', '522300');
INSERT INTO `code` VALUES ('1568', '522327', '册亨县', 'BM_DISTRICT', '522300');
INSERT INTO `code` VALUES ('1569', '522328', '安龙县', 'BM_DISTRICT', '522300');
INSERT INTO `code` VALUES ('1570', '522600', '黔东南苗族侗族自治州', 'BM_DISTRICT', '520000');
INSERT INTO `code` VALUES ('1571', '522601', '凯里市', 'BM_DISTRICT', '522600');
INSERT INTO `code` VALUES ('1572', '522622', '黄平县', 'BM_DISTRICT', '522600');
INSERT INTO `code` VALUES ('1573', '522623', '施秉县', 'BM_DISTRICT', '522600');
INSERT INTO `code` VALUES ('1574', '522624', '三穗县', 'BM_DISTRICT', '522600');
INSERT INTO `code` VALUES ('1575', '522625', '镇远县', 'BM_DISTRICT', '522600');
INSERT INTO `code` VALUES ('1576', '522626', '岑巩县', 'BM_DISTRICT', '522600');
INSERT INTO `code` VALUES ('1577', '522627', '天柱县', 'BM_DISTRICT', '522600');
INSERT INTO `code` VALUES ('1578', '522628', '锦屏县', 'BM_DISTRICT', '522600');
INSERT INTO `code` VALUES ('1579', '522629', '剑河县', 'BM_DISTRICT', '522600');
INSERT INTO `code` VALUES ('1580', '141001', '市辖区', 'BM_DISTRICT', '141000');
INSERT INTO `code` VALUES ('1581', '610326', '眉县', 'BM_DISTRICT', '610300');
INSERT INTO `code` VALUES ('1582', '610327', '陇县', 'BM_DISTRICT', '610300');
INSERT INTO `code` VALUES ('1583', '610328', '千阳县', 'BM_DISTRICT', '610300');
INSERT INTO `code` VALUES ('1584', '610329', '麟游县', 'BM_DISTRICT', '610300');
INSERT INTO `code` VALUES ('1585', '610330', '凤县', 'BM_DISTRICT', '610300');
INSERT INTO `code` VALUES ('1586', '610331', '太白县', 'BM_DISTRICT', '610300');
INSERT INTO `code` VALUES ('1587', '610400', '咸阳市', 'BM_DISTRICT', '610000');
INSERT INTO `code` VALUES ('1588', '610401', '市辖区', 'BM_DISTRICT', '610400');
INSERT INTO `code` VALUES ('1589', '610402', '秦都区', 'BM_DISTRICT', '610400');
INSERT INTO `code` VALUES ('1590', '610403', '杨陵区', 'BM_DISTRICT', '610400');
INSERT INTO `code` VALUES ('1591', '610404', '渭城区', 'BM_DISTRICT', '610400');
INSERT INTO `code` VALUES ('1592', '610422', '三原县', 'BM_DISTRICT', '610400');
INSERT INTO `code` VALUES ('1593', '610423', '泾阳县', 'BM_DISTRICT', '610400');
INSERT INTO `code` VALUES ('1594', '610424', '乾县', 'BM_DISTRICT', '610400');
INSERT INTO `code` VALUES ('1595', '610425', '礼泉县', 'BM_DISTRICT', '610400');
INSERT INTO `code` VALUES ('1596', '610426', '永寿县', 'BM_DISTRICT', '610400');
INSERT INTO `code` VALUES ('1597', '610427', '彬县', 'BM_DISTRICT', '610400');
INSERT INTO `code` VALUES ('1598', '610428', '长武县', 'BM_DISTRICT', '610400');
INSERT INTO `code` VALUES ('1599', '610429', '旬邑县', 'BM_DISTRICT', '610400');
INSERT INTO `code` VALUES ('1600', '610430', '淳化县', 'BM_DISTRICT', '610400');
INSERT INTO `code` VALUES ('1601', '610431', '武功县', 'BM_DISTRICT', '610400');
INSERT INTO `code` VALUES ('1602', '610481', '兴平市', 'BM_DISTRICT', '610400');
INSERT INTO `code` VALUES ('1603', '610500', '渭南市', 'BM_DISTRICT', '610000');
INSERT INTO `code` VALUES ('1604', '610501', '市辖区', 'BM_DISTRICT', '610500');
INSERT INTO `code` VALUES ('1605', '610502', '临渭区', 'BM_DISTRICT', '610500');
INSERT INTO `code` VALUES ('1606', '610521', '华县', 'BM_DISTRICT', '610500');
INSERT INTO `code` VALUES ('1607', '610522', '潼关县', 'BM_DISTRICT', '610500');
INSERT INTO `code` VALUES ('1608', '610523', '大荔县', 'BM_DISTRICT', '610500');
INSERT INTO `code` VALUES ('1609', '610524', '合阳县', 'BM_DISTRICT', '610500');
INSERT INTO `code` VALUES ('1610', '610525', '澄城县', 'BM_DISTRICT', '610500');
INSERT INTO `code` VALUES ('1611', '610526', '蒲城县', 'BM_DISTRICT', '610500');
INSERT INTO `code` VALUES ('1612', '610527', '白水县', 'BM_DISTRICT', '610500');
INSERT INTO `code` VALUES ('1613', '610528', '富平县', 'BM_DISTRICT', '610500');
INSERT INTO `code` VALUES ('1614', '610581', '韩城市', 'BM_DISTRICT', '610500');
INSERT INTO `code` VALUES ('1615', '610582', '华阴市', 'BM_DISTRICT', '610500');
INSERT INTO `code` VALUES ('1616', '610600', '延安市', 'BM_DISTRICT', '610000');
INSERT INTO `code` VALUES ('1617', '610601', '市辖区', 'BM_DISTRICT', '610600');
INSERT INTO `code` VALUES ('1618', '610602', '宝塔区', 'BM_DISTRICT', '610600');
INSERT INTO `code` VALUES ('1619', '610621', '延长县', 'BM_DISTRICT', '610600');
INSERT INTO `code` VALUES ('1620', '610622', '延川县', 'BM_DISTRICT', '610600');
INSERT INTO `code` VALUES ('1621', '610623', '子长县', 'BM_DISTRICT', '610600');
INSERT INTO `code` VALUES ('1622', '610624', '安塞县', 'BM_DISTRICT', '610600');
INSERT INTO `code` VALUES ('1623', '610625', '志丹县', 'BM_DISTRICT', '610600');
INSERT INTO `code` VALUES ('1624', '610626', '吴起县', 'BM_DISTRICT', '610600');
INSERT INTO `code` VALUES ('1625', '610627', '甘泉县', 'BM_DISTRICT', '610600');
INSERT INTO `code` VALUES ('1626', '610628', '富县', 'BM_DISTRICT', '610600');
INSERT INTO `code` VALUES ('1627', '610629', '洛川县', 'BM_DISTRICT', '610600');
INSERT INTO `code` VALUES ('1628', '500107', '九龙坡区', 'BM_DISTRICT', '500100');
INSERT INTO `code` VALUES ('1629', '500108', '南岸区', 'BM_DISTRICT', '500100');
INSERT INTO `code` VALUES ('1630', '500109', '北碚区', 'BM_DISTRICT', '500100');
INSERT INTO `code` VALUES ('1631', '500110', '綦江区', 'BM_DISTRICT', '500100');
INSERT INTO `code` VALUES ('1632', '500111', '大足区', 'BM_DISTRICT', '500100');
INSERT INTO `code` VALUES ('1633', '500112', '渝北区', 'BM_DISTRICT', '500100');
INSERT INTO `code` VALUES ('1634', '150928', '察哈尔右翼后旗', 'BM_DISTRICT', '150900');
INSERT INTO `code` VALUES ('1635', '150929', '四子王旗', 'BM_DISTRICT', '150900');
INSERT INTO `code` VALUES ('1636', '150981', '丰镇市', 'BM_DISTRICT', '150900');
INSERT INTO `code` VALUES ('1637', '152200', '兴安盟', 'BM_DISTRICT', '150000');
INSERT INTO `code` VALUES ('1638', '152201', '乌兰浩特市', 'BM_DISTRICT', '152200');
INSERT INTO `code` VALUES ('1639', '152202', '阿尔山市', 'BM_DISTRICT', '152200');
INSERT INTO `code` VALUES ('1640', '152221', '科尔沁右翼前旗', 'BM_DISTRICT', '152200');
INSERT INTO `code` VALUES ('1641', '152222', '科尔沁右翼中旗', 'BM_DISTRICT', '152200');
INSERT INTO `code` VALUES ('1642', '152223', '扎赉特旗', 'BM_DISTRICT', '152200');
INSERT INTO `code` VALUES ('1643', '152224', '突泉县', 'BM_DISTRICT', '152200');
INSERT INTO `code` VALUES ('1644', '152500', '锡林郭勒盟', 'BM_DISTRICT', '150000');
INSERT INTO `code` VALUES ('1645', '152501', '二连浩特市', 'BM_DISTRICT', '152500');
INSERT INTO `code` VALUES ('1646', '152502', '锡林浩特市', 'BM_DISTRICT', '152500');
INSERT INTO `code` VALUES ('1647', '152522', '阿巴嘎旗', 'BM_DISTRICT', '152500');
INSERT INTO `code` VALUES ('1648', '152523', '苏尼特左旗', 'BM_DISTRICT', '152500');
INSERT INTO `code` VALUES ('1649', '152524', '苏尼特右旗', 'BM_DISTRICT', '152500');
INSERT INTO `code` VALUES ('1650', '152525', '东乌珠穆沁旗', 'BM_DISTRICT', '152500');
INSERT INTO `code` VALUES ('1651', '152526', '西乌珠穆沁旗', 'BM_DISTRICT', '152500');
INSERT INTO `code` VALUES ('1652', '152527', '太仆寺旗', 'BM_DISTRICT', '152500');
INSERT INTO `code` VALUES ('1653', '152528', '镶黄旗', 'BM_DISTRICT', '152500');
INSERT INTO `code` VALUES ('1654', '152529', '正镶白旗', 'BM_DISTRICT', '152500');
INSERT INTO `code` VALUES ('1655', '152530', '正蓝旗', 'BM_DISTRICT', '152500');
INSERT INTO `code` VALUES ('1656', '152531', '多伦县', 'BM_DISTRICT', '152500');
INSERT INTO `code` VALUES ('1657', '152900', '阿拉善盟', 'BM_DISTRICT', '150000');
INSERT INTO `code` VALUES ('1658', '152921', '阿拉善左旗', 'BM_DISTRICT', '152900');
INSERT INTO `code` VALUES ('1659', '152922', '阿拉善右旗', 'BM_DISTRICT', '152900');
INSERT INTO `code` VALUES ('1660', '152923', '额济纳旗', 'BM_DISTRICT', '152900');
INSERT INTO `code` VALUES ('1661', '210000', '辽宁省', 'BM_DISTRICT', null);
INSERT INTO `code` VALUES ('1662', '210100', '沈阳市', 'BM_DISTRICT', '210000');
INSERT INTO `code` VALUES ('1663', '210101', '市辖区', 'BM_DISTRICT', '210100');
INSERT INTO `code` VALUES ('1664', '210102', '和平区', 'BM_DISTRICT', '210100');
INSERT INTO `code` VALUES ('1665', '210103', '沈河区', 'BM_DISTRICT', '210100');
INSERT INTO `code` VALUES ('1666', '210104', '大东区', 'BM_DISTRICT', '210100');
INSERT INTO `code` VALUES ('1667', '210105', '皇姑区', 'BM_DISTRICT', '210100');
INSERT INTO `code` VALUES ('1668', '210106', '铁西区', 'BM_DISTRICT', '210100');
INSERT INTO `code` VALUES ('1669', '210111', '苏家屯区', 'BM_DISTRICT', '210100');
INSERT INTO `code` VALUES ('1670', '210112', '东陵区', 'BM_DISTRICT', '210100');
INSERT INTO `code` VALUES ('1671', '210113', '沈北新区', 'BM_DISTRICT', '210100');
INSERT INTO `code` VALUES ('1672', '210114', '于洪区', 'BM_DISTRICT', '210100');
INSERT INTO `code` VALUES ('1673', '210122', '辽中县', 'BM_DISTRICT', '210100');
INSERT INTO `code` VALUES ('1674', '210123', '康平县', 'BM_DISTRICT', '210100');
INSERT INTO `code` VALUES ('1675', '210124', '法库县', 'BM_DISTRICT', '210100');
INSERT INTO `code` VALUES ('1676', '210181', '新民市', 'BM_DISTRICT', '210100');
INSERT INTO `code` VALUES ('1677', '210200', '大连市', 'BM_DISTRICT', '210000');
INSERT INTO `code` VALUES ('1678', '210201', '市辖区', 'BM_DISTRICT', '210200');
INSERT INTO `code` VALUES ('1679', '210202', '中山区', 'BM_DISTRICT', '210200');
INSERT INTO `code` VALUES ('1680', '210203', '西岗区', 'BM_DISTRICT', '210200');
INSERT INTO `code` VALUES ('1681', '210204', '沙河口区', 'BM_DISTRICT', '210200');
INSERT INTO `code` VALUES ('1682', '210211', '甘井子区', 'BM_DISTRICT', '210200');
INSERT INTO `code` VALUES ('1683', '360622', '余江县', 'BM_DISTRICT', '360600');
INSERT INTO `code` VALUES ('1684', '360681', '贵溪市', 'BM_DISTRICT', '360600');
INSERT INTO `code` VALUES ('1685', '360700', '赣州市', 'BM_DISTRICT', '360000');
INSERT INTO `code` VALUES ('1686', '360701', '市辖区', 'BM_DISTRICT', '360700');
INSERT INTO `code` VALUES ('1687', '360702', '章贡区', 'BM_DISTRICT', '360700');
INSERT INTO `code` VALUES ('1688', '360721', '赣县', 'BM_DISTRICT', '360700');
INSERT INTO `code` VALUES ('1689', '360722', '信丰县', 'BM_DISTRICT', '360700');
INSERT INTO `code` VALUES ('1690', '360723', '大余县', 'BM_DISTRICT', '360700');
INSERT INTO `code` VALUES ('1691', '360724', '上犹县', 'BM_DISTRICT', '360700');
INSERT INTO `code` VALUES ('1692', '360725', '崇义县', 'BM_DISTRICT', '360700');
INSERT INTO `code` VALUES ('1693', '131124', '饶阳县', 'BM_DISTRICT', '131100');
INSERT INTO `code` VALUES ('1694', '131125', '安平县', 'BM_DISTRICT', '131100');
INSERT INTO `code` VALUES ('1695', '131126', '故城县', 'BM_DISTRICT', '131100');
INSERT INTO `code` VALUES ('1696', '131127', '景县', 'BM_DISTRICT', '131100');
INSERT INTO `code` VALUES ('1697', '131128', '阜城县', 'BM_DISTRICT', '131100');
INSERT INTO `code` VALUES ('1698', '131181', '冀州市', 'BM_DISTRICT', '131100');
INSERT INTO `code` VALUES ('1699', '131182', '深州市', 'BM_DISTRICT', '131100');
INSERT INTO `code` VALUES ('1700', '140000', '山西省', 'BM_DISTRICT', null);
INSERT INTO `code` VALUES ('1701', '140100', '太原市', 'BM_DISTRICT', '140000');
INSERT INTO `code` VALUES ('1702', '140101', '市辖区', 'BM_DISTRICT', '140100');
INSERT INTO `code` VALUES ('1703', '140105', '小店区', 'BM_DISTRICT', '140100');
INSERT INTO `code` VALUES ('1704', '140106', '迎泽区', 'BM_DISTRICT', '140100');
INSERT INTO `code` VALUES ('1705', '140107', '杏花岭区', 'BM_DISTRICT', '140100');
INSERT INTO `code` VALUES ('1706', '140108', '尖草坪区', 'BM_DISTRICT', '140100');
INSERT INTO `code` VALUES ('1707', '140109', '万柏林区', 'BM_DISTRICT', '140100');
INSERT INTO `code` VALUES ('1708', '140110', '晋源区', 'BM_DISTRICT', '140100');
INSERT INTO `code` VALUES ('1709', '140121', '清徐县', 'BM_DISTRICT', '140100');
INSERT INTO `code` VALUES ('1710', '140122', '阳曲县', 'BM_DISTRICT', '140100');
INSERT INTO `code` VALUES ('1711', '140123', '娄烦县', 'BM_DISTRICT', '140100');
INSERT INTO `code` VALUES ('1712', '140181', '古交市', 'BM_DISTRICT', '140100');
INSERT INTO `code` VALUES ('1713', '140200', '大同市', 'BM_DISTRICT', '140000');
INSERT INTO `code` VALUES ('1714', '140201', '市辖区', 'BM_DISTRICT', '140200');
INSERT INTO `code` VALUES ('1715', '140202', '城区', 'BM_DISTRICT', '140200');
INSERT INTO `code` VALUES ('1716', '140203', '矿区', 'BM_DISTRICT', '140200');
INSERT INTO `code` VALUES ('1717', '140211', '南郊区', 'BM_DISTRICT', '140200');
INSERT INTO `code` VALUES ('1718', '140212', '新荣区', 'BM_DISTRICT', '140200');
INSERT INTO `code` VALUES ('1719', '140221', '阳高县', 'BM_DISTRICT', '140200');
INSERT INTO `code` VALUES ('1720', '140222', '天镇县', 'BM_DISTRICT', '140200');
INSERT INTO `code` VALUES ('1721', '140223', '广灵县', 'BM_DISTRICT', '140200');
INSERT INTO `code` VALUES ('1722', '140224', '灵丘县', 'BM_DISTRICT', '140200');
INSERT INTO `code` VALUES ('1723', '140225', '浑源县', 'BM_DISTRICT', '140200');
INSERT INTO `code` VALUES ('1724', '140226', '左云县', 'BM_DISTRICT', '140200');
INSERT INTO `code` VALUES ('1725', '140227', '大同县', 'BM_DISTRICT', '140200');
INSERT INTO `code` VALUES ('1726', '140300', '阳泉市', 'BM_DISTRICT', '140000');
INSERT INTO `code` VALUES ('1727', '140301', '市辖区', 'BM_DISTRICT', '140300');
INSERT INTO `code` VALUES ('1728', '140302', '城区', 'BM_DISTRICT', '140300');
INSERT INTO `code` VALUES ('1729', '140303', '矿区', 'BM_DISTRICT', '140300');
INSERT INTO `code` VALUES ('1730', '140311', '郊区', 'BM_DISTRICT', '140300');
INSERT INTO `code` VALUES ('1731', '140321', '平定县', 'BM_DISTRICT', '140300');
INSERT INTO `code` VALUES ('1732', '140322', '盂县', 'BM_DISTRICT', '140300');
INSERT INTO `code` VALUES ('1733', '140400', '长治市', 'BM_DISTRICT', '140000');
INSERT INTO `code` VALUES ('1734', '140401', '市辖区', 'BM_DISTRICT', '140400');
INSERT INTO `code` VALUES ('1735', '140402', '城区', 'BM_DISTRICT', '140400');
INSERT INTO `code` VALUES ('1736', '140411', '郊区', 'BM_DISTRICT', '140400');
INSERT INTO `code` VALUES ('1737', '140421', '长治县', 'BM_DISTRICT', '140400');
INSERT INTO `code` VALUES ('1738', '140423', '襄垣县', 'BM_DISTRICT', '140400');
INSERT INTO `code` VALUES ('1739', '140424', '屯留县', 'BM_DISTRICT', '140400');
INSERT INTO `code` VALUES ('1740', '140425', '平顺县', 'BM_DISTRICT', '140400');
INSERT INTO `code` VALUES ('1741', '140426', '黎城县', 'BM_DISTRICT', '140400');
INSERT INTO `code` VALUES ('1742', '140427', '壶关县', 'BM_DISTRICT', '140400');
INSERT INTO `code` VALUES ('1743', '140428', '长子县', 'BM_DISTRICT', '140400');
INSERT INTO `code` VALUES ('1744', '140429', '武乡县', 'BM_DISTRICT', '140400');
INSERT INTO `code` VALUES ('1745', '140430', '沁县', 'BM_DISTRICT', '140400');
INSERT INTO `code` VALUES ('1746', '140431', '沁源县', 'BM_DISTRICT', '140400');
INSERT INTO `code` VALUES ('1747', '140481', '潞城市', 'BM_DISTRICT', '140400');
INSERT INTO `code` VALUES ('1748', '141002', '尧都区', 'BM_DISTRICT', '141000');
INSERT INTO `code` VALUES ('1749', '141021', '曲沃县', 'BM_DISTRICT', '141000');
INSERT INTO `code` VALUES ('1750', '341502', '金安区', 'BM_DISTRICT', '341500');
INSERT INTO `code` VALUES ('1751', '341503', '裕安区', 'BM_DISTRICT', '341500');
INSERT INTO `code` VALUES ('1752', '341521', '寿县', 'BM_DISTRICT', '341500');
INSERT INTO `code` VALUES ('1753', '341522', '霍邱县', 'BM_DISTRICT', '341500');
INSERT INTO `code` VALUES ('1754', '341523', '舒城县', 'BM_DISTRICT', '341500');
INSERT INTO `code` VALUES ('1755', '341524', '金寨县', 'BM_DISTRICT', '341500');
INSERT INTO `code` VALUES ('1756', '341525', '霍山县', 'BM_DISTRICT', '341500');
INSERT INTO `code` VALUES ('1757', '341600', '亳州市', 'BM_DISTRICT', '340000');
INSERT INTO `code` VALUES ('1758', '341601', '市辖区', 'BM_DISTRICT', '341600');
INSERT INTO `code` VALUES ('1759', '341602', '谯城区', 'BM_DISTRICT', '341600');
INSERT INTO `code` VALUES ('1760', '341621', '涡阳县', 'BM_DISTRICT', '341600');
INSERT INTO `code` VALUES ('1761', '341622', '蒙城县', 'BM_DISTRICT', '341600');
INSERT INTO `code` VALUES ('1762', '341623', '利辛县', 'BM_DISTRICT', '341600');
INSERT INTO `code` VALUES ('1763', '341700', '池州市', 'BM_DISTRICT', '340000');
INSERT INTO `code` VALUES ('1764', '341701', '市辖区', 'BM_DISTRICT', '341700');
INSERT INTO `code` VALUES ('1765', '341702', '贵池区', 'BM_DISTRICT', '341700');
INSERT INTO `code` VALUES ('1766', '341721', '东至县', 'BM_DISTRICT', '341700');
INSERT INTO `code` VALUES ('1767', '341722', '石台县', 'BM_DISTRICT', '341700');
INSERT INTO `code` VALUES ('1768', '341723', '青阳县', 'BM_DISTRICT', '341700');
INSERT INTO `code` VALUES ('1769', '341800', '宣城市', 'BM_DISTRICT', '340000');
INSERT INTO `code` VALUES ('1770', '341801', '市辖区', 'BM_DISTRICT', '341800');
INSERT INTO `code` VALUES ('1771', '341802', '宣州区', 'BM_DISTRICT', '341800');
INSERT INTO `code` VALUES ('1772', '341821', '郎溪县', 'BM_DISTRICT', '341800');
INSERT INTO `code` VALUES ('1773', '341822', '广德县', 'BM_DISTRICT', '341800');
INSERT INTO `code` VALUES ('1774', '341823', '泾县', 'BM_DISTRICT', '341800');
INSERT INTO `code` VALUES ('1775', '341824', '绩溪县', 'BM_DISTRICT', '341800');
INSERT INTO `code` VALUES ('1776', '341825', '旌德县', 'BM_DISTRICT', '341800');
INSERT INTO `code` VALUES ('1777', '341881', '宁国市', 'BM_DISTRICT', '341800');
INSERT INTO `code` VALUES ('1778', '350000', '福建省', 'BM_DISTRICT', null);
INSERT INTO `code` VALUES ('1779', '350100', '福州市', 'BM_DISTRICT', '350000');
INSERT INTO `code` VALUES ('1780', '350101', '市辖区', 'BM_DISTRICT', '350100');
INSERT INTO `code` VALUES ('1781', '350102', '鼓楼区', 'BM_DISTRICT', '350100');
INSERT INTO `code` VALUES ('1782', '350103', '台江区', 'BM_DISTRICT', '350100');
INSERT INTO `code` VALUES ('1783', '350104', '仓山区', 'BM_DISTRICT', '350100');
INSERT INTO `code` VALUES ('1784', '350105', '马尾区', 'BM_DISTRICT', '350100');
INSERT INTO `code` VALUES ('1785', '350111', '晋安区', 'BM_DISTRICT', '350100');
INSERT INTO `code` VALUES ('1786', '350121', '闽侯县', 'BM_DISTRICT', '350100');
INSERT INTO `code` VALUES ('1787', '350122', '连江县', 'BM_DISTRICT', '350100');
INSERT INTO `code` VALUES ('1788', '350123', '罗源县', 'BM_DISTRICT', '350100');
INSERT INTO `code` VALUES ('1789', '350124', '闽清县', 'BM_DISTRICT', '350100');
INSERT INTO `code` VALUES ('1790', '350125', '永泰县', 'BM_DISTRICT', '350100');
INSERT INTO `code` VALUES ('1791', '350128', '平潭县', 'BM_DISTRICT', '350100');
INSERT INTO `code` VALUES ('1792', '350181', '福清市', 'BM_DISTRICT', '350100');
INSERT INTO `code` VALUES ('1793', '350182', '长乐市', 'BM_DISTRICT', '350100');
INSERT INTO `code` VALUES ('1794', '350200', '厦门市', 'BM_DISTRICT', '350000');
INSERT INTO `code` VALUES ('1795', '350201', '市辖区', 'BM_DISTRICT', '350200');
INSERT INTO `code` VALUES ('1796', '350203', '思明区', 'BM_DISTRICT', '350200');
INSERT INTO `code` VALUES ('1797', '350205', '海沧区', 'BM_DISTRICT', '350200');
INSERT INTO `code` VALUES ('1798', '350206', '湖里区', 'BM_DISTRICT', '350200');
INSERT INTO `code` VALUES ('1799', '350211', '集美区', 'BM_DISTRICT', '350200');
INSERT INTO `code` VALUES ('1800', '350212', '同安区', 'BM_DISTRICT', '350200');
INSERT INTO `code` VALUES ('1801', '350213', '翔安区', 'BM_DISTRICT', '350200');
INSERT INTO `code` VALUES ('1802', '350300', '莆田市', 'BM_DISTRICT', '350000');
INSERT INTO `code` VALUES ('1803', '350301', '市辖区', 'BM_DISTRICT', '350300');
INSERT INTO `code` VALUES ('1804', '350302', '城厢区', 'BM_DISTRICT', '350300');
INSERT INTO `code` VALUES ('1805', '350303', '涵江区', 'BM_DISTRICT', '350300');
INSERT INTO `code` VALUES ('1806', '350822', '永定县', 'BM_DISTRICT', '350800');
INSERT INTO `code` VALUES ('1807', '350823', '上杭县', 'BM_DISTRICT', '350800');
INSERT INTO `code` VALUES ('1808', '510303', '贡井区', 'BM_DISTRICT', '510300');
INSERT INTO `code` VALUES ('1809', '510304', '大安区', 'BM_DISTRICT', '510300');
INSERT INTO `code` VALUES ('1810', '510311', '沿滩区', 'BM_DISTRICT', '510300');
INSERT INTO `code` VALUES ('1811', '510321', '荣县', 'BM_DISTRICT', '510300');
INSERT INTO `code` VALUES ('1812', '510322', '富顺县', 'BM_DISTRICT', '510300');
INSERT INTO `code` VALUES ('1813', '510400', '攀枝花市', 'BM_DISTRICT', '510000');
INSERT INTO `code` VALUES ('1814', '510401', '市辖区', 'BM_DISTRICT', '510400');
INSERT INTO `code` VALUES ('1815', '510402', '东区', 'BM_DISTRICT', '510400');
INSERT INTO `code` VALUES ('1816', '510403', '西区', 'BM_DISTRICT', '510400');
INSERT INTO `code` VALUES ('1817', '510411', '仁和区', 'BM_DISTRICT', '510400');
INSERT INTO `code` VALUES ('1818', '510421', '米易县', 'BM_DISTRICT', '510400');
INSERT INTO `code` VALUES ('1819', '510422', '盐边县', 'BM_DISTRICT', '510400');
INSERT INTO `code` VALUES ('1820', '510500', '泸州市', 'BM_DISTRICT', '510000');
INSERT INTO `code` VALUES ('1821', '510501', '市辖区', 'BM_DISTRICT', '510500');
INSERT INTO `code` VALUES ('1822', '510502', '江阳区', 'BM_DISTRICT', '510500');
INSERT INTO `code` VALUES ('1823', '510503', '纳溪区', 'BM_DISTRICT', '510500');
INSERT INTO `code` VALUES ('1824', '510504', '龙马潭区', 'BM_DISTRICT', '510500');
INSERT INTO `code` VALUES ('1825', '510521', '泸县', 'BM_DISTRICT', '510500');
INSERT INTO `code` VALUES ('1826', '510522', '合江县', 'BM_DISTRICT', '510500');
INSERT INTO `code` VALUES ('1827', '510524', '叙永县', 'BM_DISTRICT', '510500');
INSERT INTO `code` VALUES ('1828', '510525', '古蔺县', 'BM_DISTRICT', '510500');
INSERT INTO `code` VALUES ('1829', '510600', '德阳市', 'BM_DISTRICT', '510000');
INSERT INTO `code` VALUES ('1830', '510601', '市辖区', 'BM_DISTRICT', '510600');
INSERT INTO `code` VALUES ('1831', '510603', '旌阳区', 'BM_DISTRICT', '510600');
INSERT INTO `code` VALUES ('1832', '510623', '中江县', 'BM_DISTRICT', '510600');
INSERT INTO `code` VALUES ('1833', '510626', '罗江县', 'BM_DISTRICT', '510600');
INSERT INTO `code` VALUES ('1834', '510681', '广汉市', 'BM_DISTRICT', '510600');
INSERT INTO `code` VALUES ('1835', '510682', '什邡市', 'BM_DISTRICT', '510600');
INSERT INTO `code` VALUES ('1836', '510683', '绵竹市', 'BM_DISTRICT', '510600');
INSERT INTO `code` VALUES ('1837', '510700', '绵阳市', 'BM_DISTRICT', '510000');
INSERT INTO `code` VALUES ('1838', '510701', '市辖区', 'BM_DISTRICT', '510700');
INSERT INTO `code` VALUES ('1839', '510703', '涪城区', 'BM_DISTRICT', '510700');
INSERT INTO `code` VALUES ('1840', '510704', '游仙区', 'BM_DISTRICT', '510700');
INSERT INTO `code` VALUES ('1841', '510722', '三台县', 'BM_DISTRICT', '510700');
INSERT INTO `code` VALUES ('1842', '510723', '盐亭县', 'BM_DISTRICT', '510700');
INSERT INTO `code` VALUES ('1843', '510724', '安县', 'BM_DISTRICT', '510700');
INSERT INTO `code` VALUES ('1844', '510725', '梓潼县', 'BM_DISTRICT', '510700');
INSERT INTO `code` VALUES ('1845', '510726', '北川羌族自治县', 'BM_DISTRICT', '510700');
INSERT INTO `code` VALUES ('1846', '510727', '平武县', 'BM_DISTRICT', '510700');
INSERT INTO `code` VALUES ('1847', '510781', '江油市', 'BM_DISTRICT', '510700');
INSERT INTO `code` VALUES ('1848', '510800', '广元市', 'BM_DISTRICT', '510000');
INSERT INTO `code` VALUES ('1849', '510801', '市辖区', 'BM_DISTRICT', '510800');
INSERT INTO `code` VALUES ('1850', '510802', '利州区', 'BM_DISTRICT', '510800');
INSERT INTO `code` VALUES ('1851', '510811', '元坝区', 'BM_DISTRICT', '510800');
INSERT INTO `code` VALUES ('1852', '510812', '朝天区', 'BM_DISTRICT', '510800');
INSERT INTO `code` VALUES ('1853', '510821', '旺苍县', 'BM_DISTRICT', '510800');
INSERT INTO `code` VALUES ('1854', '510822', '青川县', 'BM_DISTRICT', '510800');
INSERT INTO `code` VALUES ('1855', '510823', '剑阁县', 'BM_DISTRICT', '510800');
INSERT INTO `code` VALUES ('1856', '510824', '苍溪县', 'BM_DISTRICT', '510800');
INSERT INTO `code` VALUES ('1857', '510900', '遂宁市', 'BM_DISTRICT', '510000');
INSERT INTO `code` VALUES ('1858', '510901', '市辖区', 'BM_DISTRICT', '510900');
INSERT INTO `code` VALUES ('1859', '500113', '巴南区', 'BM_DISTRICT', '500100');
INSERT INTO `code` VALUES ('1860', '500114', '黔江区', 'BM_DISTRICT', '500100');
INSERT INTO `code` VALUES ('1861', '500115', '长寿区', 'BM_DISTRICT', '500100');
INSERT INTO `code` VALUES ('1862', '500116', '江津区', 'BM_DISTRICT', '500100');
INSERT INTO `code` VALUES ('1863', '500117', '合川区', 'BM_DISTRICT', '500100');
INSERT INTO `code` VALUES ('1864', '500118', '永川区', 'BM_DISTRICT', '500100');
INSERT INTO `code` VALUES ('1865', '500119', '南川区', 'BM_DISTRICT', '500100');
INSERT INTO `code` VALUES ('1866', '500200', '县', 'BM_DISTRICT', '500000');
INSERT INTO `code` VALUES ('1867', '500223', '潼南县', 'BM_DISTRICT', '500200');
INSERT INTO `code` VALUES ('1868', '500224', '铜梁县', 'BM_DISTRICT', '500200');
INSERT INTO `code` VALUES ('1869', '500226', '荣昌县', 'BM_DISTRICT', '500200');
INSERT INTO `code` VALUES ('1870', '500227', '璧山县', 'BM_DISTRICT', '500200');
INSERT INTO `code` VALUES ('1871', '500228', '梁平县', 'BM_DISTRICT', '500200');
INSERT INTO `code` VALUES ('1872', '500229', '城口县', 'BM_DISTRICT', '500200');
INSERT INTO `code` VALUES ('1873', '500230', '丰都县', 'BM_DISTRICT', '500200');
INSERT INTO `code` VALUES ('1874', '500231', '垫江县', 'BM_DISTRICT', '500200');
INSERT INTO `code` VALUES ('1875', '500232', '武隆县', 'BM_DISTRICT', '500200');
INSERT INTO `code` VALUES ('1876', '500233', '忠县', 'BM_DISTRICT', '500200');
INSERT INTO `code` VALUES ('1877', '500234', '开县', 'BM_DISTRICT', '500200');
INSERT INTO `code` VALUES ('1878', '500235', '云阳县', 'BM_DISTRICT', '500200');
INSERT INTO `code` VALUES ('1879', '500236', '奉节县', 'BM_DISTRICT', '500200');
INSERT INTO `code` VALUES ('1880', '500237', '巫山县', 'BM_DISTRICT', '500200');
INSERT INTO `code` VALUES ('1881', '500238', '巫溪县', 'BM_DISTRICT', '500200');
INSERT INTO `code` VALUES ('1882', '500240', '石柱土家族自治县', 'BM_DISTRICT', '500200');
INSERT INTO `code` VALUES ('1883', '500241', '秀山土家族苗族自治县', 'BM_DISTRICT', '500200');
INSERT INTO `code` VALUES ('1884', '500242', '酉阳土家族苗族自治县', 'BM_DISTRICT', '500200');
INSERT INTO `code` VALUES ('1885', '500243', '彭水苗族土家族自治县', 'BM_DISTRICT', '500200');
INSERT INTO `code` VALUES ('1886', '510000', '四川省', 'BM_DISTRICT', null);
INSERT INTO `code` VALUES ('1887', '510100', '成都市', 'BM_DISTRICT', '510000');
INSERT INTO `code` VALUES ('1888', '510101', '市辖区', 'BM_DISTRICT', '510100');
INSERT INTO `code` VALUES ('1889', '510104', '锦江区', 'BM_DISTRICT', '510100');
INSERT INTO `code` VALUES ('1890', '510105', '青羊区', 'BM_DISTRICT', '510100');
INSERT INTO `code` VALUES ('1891', '510106', '金牛区', 'BM_DISTRICT', '510100');
INSERT INTO `code` VALUES ('1892', '510107', '武侯区', 'BM_DISTRICT', '510100');
INSERT INTO `code` VALUES ('1893', '510108', '成华区', 'BM_DISTRICT', '510100');
INSERT INTO `code` VALUES ('1894', '510112', '龙泉驿区', 'BM_DISTRICT', '510100');
INSERT INTO `code` VALUES ('1895', '510113', '青白江区', 'BM_DISTRICT', '510100');
INSERT INTO `code` VALUES ('1896', '510114', '新都区', 'BM_DISTRICT', '510100');
INSERT INTO `code` VALUES ('1897', '510115', '温江区', 'BM_DISTRICT', '510100');
INSERT INTO `code` VALUES ('1898', '510121', '金堂县', 'BM_DISTRICT', '510100');
INSERT INTO `code` VALUES ('1899', '510122', '双流县', 'BM_DISTRICT', '510100');
INSERT INTO `code` VALUES ('1900', '510124', '郫县', 'BM_DISTRICT', '510100');
INSERT INTO `code` VALUES ('1901', '510129', '大邑县', 'BM_DISTRICT', '510100');
INSERT INTO `code` VALUES ('1902', '510131', '蒲江县', 'BM_DISTRICT', '510100');
INSERT INTO `code` VALUES ('1903', '610630', '宜川县', 'BM_DISTRICT', '610600');
INSERT INTO `code` VALUES ('1904', '610631', '黄龙县', 'BM_DISTRICT', '610600');
INSERT INTO `code` VALUES ('1905', '610632', '黄陵县', 'BM_DISTRICT', '610600');
INSERT INTO `code` VALUES ('1906', '610700', '汉中市', 'BM_DISTRICT', '610000');
INSERT INTO `code` VALUES ('1907', '610701', '市辖区', 'BM_DISTRICT', '610700');
INSERT INTO `code` VALUES ('1908', '610702', '汉台区', 'BM_DISTRICT', '610700');
INSERT INTO `code` VALUES ('1909', '610721', '南郑县', 'BM_DISTRICT', '610700');
INSERT INTO `code` VALUES ('1910', '610722', '城固县', 'BM_DISTRICT', '610700');
INSERT INTO `code` VALUES ('1911', '610723', '洋县', 'BM_DISTRICT', '610700');
INSERT INTO `code` VALUES ('1912', '610724', '西乡县', 'BM_DISTRICT', '610700');
INSERT INTO `code` VALUES ('1913', '610725', '勉县', 'BM_DISTRICT', '610700');
INSERT INTO `code` VALUES ('1914', '610726', '宁强县', 'BM_DISTRICT', '610700');
INSERT INTO `code` VALUES ('1915', '610727', '略阳县', 'BM_DISTRICT', '610700');
INSERT INTO `code` VALUES ('1916', '610728', '镇巴县', 'BM_DISTRICT', '610700');
INSERT INTO `code` VALUES ('1917', '610729', '留坝县', 'BM_DISTRICT', '610700');
INSERT INTO `code` VALUES ('1918', '610730', '佛坪县', 'BM_DISTRICT', '610700');
INSERT INTO `code` VALUES ('1919', '610800', '榆林市', 'BM_DISTRICT', '610000');
INSERT INTO `code` VALUES ('1920', '610801', '市辖区', 'BM_DISTRICT', '610800');
INSERT INTO `code` VALUES ('1921', '610802', '榆阳区', 'BM_DISTRICT', '610800');
INSERT INTO `code` VALUES ('1922', '610821', '神木县', 'BM_DISTRICT', '610800');
INSERT INTO `code` VALUES ('1923', '610822', '府谷县', 'BM_DISTRICT', '610800');
INSERT INTO `code` VALUES ('1924', '610823', '横山县', 'BM_DISTRICT', '610800');
INSERT INTO `code` VALUES ('1925', '610824', '靖边县', 'BM_DISTRICT', '610800');
INSERT INTO `code` VALUES ('1926', '610825', '定边县', 'BM_DISTRICT', '610800');
INSERT INTO `code` VALUES ('1927', '610826', '绥德县', 'BM_DISTRICT', '610800');
INSERT INTO `code` VALUES ('1928', '610827', '米脂县', 'BM_DISTRICT', '610800');
INSERT INTO `code` VALUES ('1929', '610828', '佳县', 'BM_DISTRICT', '610800');
INSERT INTO `code` VALUES ('1930', '610829', '吴堡县', 'BM_DISTRICT', '610800');
INSERT INTO `code` VALUES ('1931', '610830', '清涧县', 'BM_DISTRICT', '610800');
INSERT INTO `code` VALUES ('1932', '610831', '子洲县', 'BM_DISTRICT', '610800');
INSERT INTO `code` VALUES ('1933', '610900', '安康市', 'BM_DISTRICT', '610000');
INSERT INTO `code` VALUES ('1934', '610901', '市辖区', 'BM_DISTRICT', '610900');
INSERT INTO `code` VALUES ('1935', '610902', '汉滨区', 'BM_DISTRICT', '610900');
INSERT INTO `code` VALUES ('1936', '610921', '汉阴县', 'BM_DISTRICT', '610900');
INSERT INTO `code` VALUES ('1937', '610922', '石泉县', 'BM_DISTRICT', '610900');
INSERT INTO `code` VALUES ('1938', '610923', '宁陕县', 'BM_DISTRICT', '610900');
INSERT INTO `code` VALUES ('1939', '610924', '紫阳县', 'BM_DISTRICT', '610900');
INSERT INTO `code` VALUES ('1940', '610925', '岚皋县', 'BM_DISTRICT', '610900');
INSERT INTO `code` VALUES ('1941', '610926', '平利县', 'BM_DISTRICT', '610900');
INSERT INTO `code` VALUES ('1942', '610927', '镇坪县', 'BM_DISTRICT', '610900');
INSERT INTO `code` VALUES ('1943', '610928', '旬阳县', 'BM_DISTRICT', '610900');
INSERT INTO `code` VALUES ('1944', '610929', '白河县', 'BM_DISTRICT', '610900');
INSERT INTO `code` VALUES ('1945', '611000', '商洛市', 'BM_DISTRICT', '610000');
INSERT INTO `code` VALUES ('1946', '611001', '市辖区', 'BM_DISTRICT', '611000');
INSERT INTO `code` VALUES ('1947', '611002', '商州区', 'BM_DISTRICT', '611000');
INSERT INTO `code` VALUES ('1948', '611021', '洛南县', 'BM_DISTRICT', '611000');
INSERT INTO `code` VALUES ('1949', '611022', '丹凤县', 'BM_DISTRICT', '611000');
INSERT INTO `code` VALUES ('1950', '611023', '商南县', 'BM_DISTRICT', '611000');
INSERT INTO `code` VALUES ('1951', '611024', '山阳县', 'BM_DISTRICT', '611000');
INSERT INTO `code` VALUES ('1952', '611025', '镇安县', 'BM_DISTRICT', '611000');
INSERT INTO `code` VALUES ('1953', '611026', '柞水县', 'BM_DISTRICT', '611000');
INSERT INTO `code` VALUES ('1954', '620000', '甘肃省', 'BM_DISTRICT', null);
INSERT INTO `code` VALUES ('1955', '350824', '武平县', 'BM_DISTRICT', '350800');
INSERT INTO `code` VALUES ('1956', '350825', '连城县', 'BM_DISTRICT', '350800');
INSERT INTO `code` VALUES ('1957', '450100', '南宁市', 'BM_DISTRICT', '450000');
INSERT INTO `code` VALUES ('1958', '450101', '市辖区', 'BM_DISTRICT', '450100');
INSERT INTO `code` VALUES ('1959', '450102', '兴宁区', 'BM_DISTRICT', '450100');
INSERT INTO `code` VALUES ('1960', '450103', '青秀区', 'BM_DISTRICT', '450100');
INSERT INTO `code` VALUES ('1961', '450105', '江南区', 'BM_DISTRICT', '450100');
INSERT INTO `code` VALUES ('1962', '450107', '西乡塘区', 'BM_DISTRICT', '450100');
INSERT INTO `code` VALUES ('1963', '450108', '良庆区', 'BM_DISTRICT', '450100');
INSERT INTO `code` VALUES ('1964', '450109', '邕宁区', 'BM_DISTRICT', '450100');
INSERT INTO `code` VALUES ('1965', '450122', '武鸣县', 'BM_DISTRICT', '450100');
INSERT INTO `code` VALUES ('1966', '450123', '隆安县', 'BM_DISTRICT', '450100');
INSERT INTO `code` VALUES ('1967', '450124', '马山县', 'BM_DISTRICT', '450100');
INSERT INTO `code` VALUES ('1968', '450125', '上林县', 'BM_DISTRICT', '450100');
INSERT INTO `code` VALUES ('1969', '450126', '宾阳县', 'BM_DISTRICT', '450100');
INSERT INTO `code` VALUES ('1970', '450127', '横县', 'BM_DISTRICT', '450100');
INSERT INTO `code` VALUES ('1971', '450200', '柳州市', 'BM_DISTRICT', '450000');
INSERT INTO `code` VALUES ('1972', '450201', '市辖区', 'BM_DISTRICT', '450200');
INSERT INTO `code` VALUES ('1973', '450202', '城中区', 'BM_DISTRICT', '450200');
INSERT INTO `code` VALUES ('1974', '450203', '鱼峰区', 'BM_DISTRICT', '450200');
INSERT INTO `code` VALUES ('1975', '450204', '柳南区', 'BM_DISTRICT', '450200');
INSERT INTO `code` VALUES ('1976', '450205', '柳北区', 'BM_DISTRICT', '450200');
INSERT INTO `code` VALUES ('1977', '450221', '柳江县', 'BM_DISTRICT', '450200');
INSERT INTO `code` VALUES ('1978', '450222', '柳城县', 'BM_DISTRICT', '450200');
INSERT INTO `code` VALUES ('1979', '450223', '鹿寨县', 'BM_DISTRICT', '450200');
INSERT INTO `code` VALUES ('1980', '450224', '融安县', 'BM_DISTRICT', '450200');
INSERT INTO `code` VALUES ('1981', '450225', '融水苗族自治县', 'BM_DISTRICT', '450200');
INSERT INTO `code` VALUES ('1982', '450226', '三江侗族自治县', 'BM_DISTRICT', '450200');
INSERT INTO `code` VALUES ('1983', '450300', '桂林市', 'BM_DISTRICT', '450000');
INSERT INTO `code` VALUES ('1984', '450301', '市辖区', 'BM_DISTRICT', '450300');
INSERT INTO `code` VALUES ('1985', '450302', '秀峰区', 'BM_DISTRICT', '450300');
INSERT INTO `code` VALUES ('1986', '450303', '叠彩区', 'BM_DISTRICT', '450300');
INSERT INTO `code` VALUES ('1987', '450304', '象山区', 'BM_DISTRICT', '450300');
INSERT INTO `code` VALUES ('1988', '450305', '七星区', 'BM_DISTRICT', '450300');
INSERT INTO `code` VALUES ('1989', '610204', '耀州区', 'BM_DISTRICT', '610200');
INSERT INTO `code` VALUES ('1990', '610222', '宜君县', 'BM_DISTRICT', '610200');
INSERT INTO `code` VALUES ('1991', '610300', '宝鸡市', 'BM_DISTRICT', '610000');
INSERT INTO `code` VALUES ('1992', '610301', '市辖区', 'BM_DISTRICT', '610300');
INSERT INTO `code` VALUES ('1993', '610302', '渭滨区', 'BM_DISTRICT', '610300');
INSERT INTO `code` VALUES ('1994', '610303', '金台区', 'BM_DISTRICT', '610300');
INSERT INTO `code` VALUES ('1995', '610304', '陈仓区', 'BM_DISTRICT', '610300');
INSERT INTO `code` VALUES ('1996', '610322', '凤翔县', 'BM_DISTRICT', '610300');
INSERT INTO `code` VALUES ('1997', '610323', '岐山县', 'BM_DISTRICT', '610300');
INSERT INTO `code` VALUES ('1998', '610324', '扶风县', 'BM_DISTRICT', '610300');
INSERT INTO `code` VALUES ('1999', '513330', '德格县', 'BM_DISTRICT', '513300');
INSERT INTO `code` VALUES ('2000', '513331', '白玉县', 'BM_DISTRICT', '513300');
INSERT INTO `code` VALUES ('2001', '513332', '石渠县', 'BM_DISTRICT', '513300');
INSERT INTO `code` VALUES ('2002', '513333', '色达县', 'BM_DISTRICT', '513300');
INSERT INTO `code` VALUES ('2003', '513334', '理塘县', 'BM_DISTRICT', '513300');
INSERT INTO `code` VALUES ('2004', '513335', '巴塘县', 'BM_DISTRICT', '513300');
INSERT INTO `code` VALUES ('2005', '513336', '乡城县', 'BM_DISTRICT', '513300');
INSERT INTO `code` VALUES ('2006', '513337', '稻城县', 'BM_DISTRICT', '513300');
INSERT INTO `code` VALUES ('2007', '513338', '得荣县', 'BM_DISTRICT', '513300');
INSERT INTO `code` VALUES ('2008', '513400', '凉山彝族自治州', 'BM_DISTRICT', '510000');
INSERT INTO `code` VALUES ('2009', '513401', '西昌市', 'BM_DISTRICT', '513400');
INSERT INTO `code` VALUES ('2010', '513422', '木里藏族自治县', 'BM_DISTRICT', '513400');
INSERT INTO `code` VALUES ('2011', '513423', '盐源县', 'BM_DISTRICT', '513400');
INSERT INTO `code` VALUES ('2012', '513424', '德昌县', 'BM_DISTRICT', '513400');
INSERT INTO `code` VALUES ('2013', '513425', '会理县', 'BM_DISTRICT', '513400');
INSERT INTO `code` VALUES ('2014', '513426', '会东县', 'BM_DISTRICT', '513400');
INSERT INTO `code` VALUES ('2015', '513427', '宁南县', 'BM_DISTRICT', '513400');
INSERT INTO `code` VALUES ('2016', '513428', '普格县', 'BM_DISTRICT', '513400');
INSERT INTO `code` VALUES ('2017', '513429', '布拖县', 'BM_DISTRICT', '513400');
INSERT INTO `code` VALUES ('2018', '513430', '金阳县', 'BM_DISTRICT', '513400');
INSERT INTO `code` VALUES ('2019', '513431', '昭觉县', 'BM_DISTRICT', '513400');
INSERT INTO `code` VALUES ('2020', '513432', '喜德县', 'BM_DISTRICT', '513400');
INSERT INTO `code` VALUES ('2021', '513433', '冕宁县', 'BM_DISTRICT', '513400');
INSERT INTO `code` VALUES ('2022', '510132', '新津县', 'BM_DISTRICT', '510100');
INSERT INTO `code` VALUES ('2023', '510181', '都江堰市', 'BM_DISTRICT', '510100');
INSERT INTO `code` VALUES ('2024', '510182', '彭州市', 'BM_DISTRICT', '510100');
INSERT INTO `code` VALUES ('2025', '510183', '邛崃市', 'BM_DISTRICT', '510100');
INSERT INTO `code` VALUES ('2026', '510184', '崇州市', 'BM_DISTRICT', '510100');
INSERT INTO `code` VALUES ('2027', '510300', '自贡市', 'BM_DISTRICT', '510000');
INSERT INTO `code` VALUES ('2028', '511123', '犍为县', 'BM_DISTRICT', '511100');
INSERT INTO `code` VALUES ('2029', '511124', '井研县', 'BM_DISTRICT', '511100');
INSERT INTO `code` VALUES ('2030', '522630', '台江县', 'BM_DISTRICT', '522600');
INSERT INTO `code` VALUES ('2031', '150901', '市辖区', 'BM_DISTRICT', '150900');
INSERT INTO `code` VALUES ('2032', '150902', '集宁区', 'BM_DISTRICT', '150900');
INSERT INTO `code` VALUES ('2033', '150921', '卓资县', 'BM_DISTRICT', '150900');
INSERT INTO `code` VALUES ('2034', '150922', '化德县', 'BM_DISTRICT', '150900');
INSERT INTO `code` VALUES ('2035', '150923', '商都县', 'BM_DISTRICT', '150900');
INSERT INTO `code` VALUES ('2036', '150924', '兴和县', 'BM_DISTRICT', '150900');
INSERT INTO `code` VALUES ('2037', '150925', '凉城县', 'BM_DISTRICT', '150900');
INSERT INTO `code` VALUES ('2038', '150926', '察哈尔右翼前旗', 'BM_DISTRICT', '150900');
INSERT INTO `code` VALUES ('2039', '150927', '察哈尔右翼中旗', 'BM_DISTRICT', '150900');
INSERT INTO `code` VALUES ('2040', '430724', '临澧县', 'BM_DISTRICT', '430700');
INSERT INTO `code` VALUES ('2041', '430725', '桃源县', 'BM_DISTRICT', '430700');
INSERT INTO `code` VALUES ('2042', '430726', '石门县', 'BM_DISTRICT', '430700');
INSERT INTO `code` VALUES ('2043', '430781', '津市市', 'BM_DISTRICT', '430700');
INSERT INTO `code` VALUES ('2044', '430800', '张家界市', 'BM_DISTRICT', '430000');
INSERT INTO `code` VALUES ('2045', '430801', '市辖区', 'BM_DISTRICT', '430800');
INSERT INTO `code` VALUES ('2046', '430802', '永定区', 'BM_DISTRICT', '430800');
INSERT INTO `code` VALUES ('2047', '430811', '武陵源区', 'BM_DISTRICT', '430800');
INSERT INTO `code` VALUES ('2048', '430821', '慈利县', 'BM_DISTRICT', '430800');
INSERT INTO `code` VALUES ('2049', '430822', '桑植县', 'BM_DISTRICT', '430800');
INSERT INTO `code` VALUES ('2050', '430900', '益阳市', 'BM_DISTRICT', '430000');
INSERT INTO `code` VALUES ('2051', '430901', '市辖区', 'BM_DISTRICT', '430900');
INSERT INTO `code` VALUES ('2052', '430902', '资阳区', 'BM_DISTRICT', '430900');
INSERT INTO `code` VALUES ('2053', '430903', '赫山区', 'BM_DISTRICT', '430900');
INSERT INTO `code` VALUES ('2054', '430921', '南县', 'BM_DISTRICT', '430900');
INSERT INTO `code` VALUES ('2055', '430922', '桃江县', 'BM_DISTRICT', '430900');
INSERT INTO `code` VALUES ('2056', '430923', '安化县', 'BM_DISTRICT', '430900');
INSERT INTO `code` VALUES ('2057', '430981', '沅江市', 'BM_DISTRICT', '430900');
INSERT INTO `code` VALUES ('2058', '431000', '郴州市', 'BM_DISTRICT', '430000');
INSERT INTO `code` VALUES ('2059', '431001', '市辖区', 'BM_DISTRICT', '431000');
INSERT INTO `code` VALUES ('2060', '431002', '北湖区', 'BM_DISTRICT', '431000');
INSERT INTO `code` VALUES ('2061', '431003', '苏仙区', 'BM_DISTRICT', '431000');
INSERT INTO `code` VALUES ('2062', '431021', '桂阳县', 'BM_DISTRICT', '431000');
INSERT INTO `code` VALUES ('2063', '431022', '宜章县', 'BM_DISTRICT', '431000');
INSERT INTO `code` VALUES ('2064', '431023', '永兴县', 'BM_DISTRICT', '431000');
INSERT INTO `code` VALUES ('2065', '431024', '嘉禾县', 'BM_DISTRICT', '431000');
INSERT INTO `code` VALUES ('2066', '431025', '临武县', 'BM_DISTRICT', '431000');
INSERT INTO `code` VALUES ('2067', '431026', '汝城县', 'BM_DISTRICT', '431000');
INSERT INTO `code` VALUES ('2068', '431027', '桂东县', 'BM_DISTRICT', '431000');
INSERT INTO `code` VALUES ('2069', '431028', '安仁县', 'BM_DISTRICT', '431000');
INSERT INTO `code` VALUES ('2070', '431081', '资兴市', 'BM_DISTRICT', '431000');
INSERT INTO `code` VALUES ('2071', '431100', '永州市', 'BM_DISTRICT', '430000');
INSERT INTO `code` VALUES ('2072', '431101', '市辖区', 'BM_DISTRICT', '431100');
INSERT INTO `code` VALUES ('2073', '431102', '零陵区', 'BM_DISTRICT', '431100');
INSERT INTO `code` VALUES ('2074', '431103', '冷水滩区', 'BM_DISTRICT', '431100');
INSERT INTO `code` VALUES ('2075', '431121', '祁阳县', 'BM_DISTRICT', '431100');
INSERT INTO `code` VALUES ('2076', '431122', '东安县', 'BM_DISTRICT', '431100');
INSERT INTO `code` VALUES ('2077', '431123', '双牌县', 'BM_DISTRICT', '431100');
INSERT INTO `code` VALUES ('2078', '431124', '道县', 'BM_DISTRICT', '431100');
INSERT INTO `code` VALUES ('2079', '431125', '江永县', 'BM_DISTRICT', '431100');
INSERT INTO `code` VALUES ('2080', '431126', '宁远县', 'BM_DISTRICT', '431100');
INSERT INTO `code` VALUES ('2081', '431127', '蓝山县', 'BM_DISTRICT', '431100');
INSERT INTO `code` VALUES ('2082', '431128', '新田县', 'BM_DISTRICT', '431100');
INSERT INTO `code` VALUES ('2083', '431129', '江华瑶族自治县', 'BM_DISTRICT', '431100');
INSERT INTO `code` VALUES ('2084', '431200', '怀化市', 'BM_DISTRICT', '430000');
INSERT INTO `code` VALUES ('2085', '431201', '市辖区', 'BM_DISTRICT', '431200');
INSERT INTO `code` VALUES ('2086', '431202', '鹤城区', 'BM_DISTRICT', '431200');
INSERT INTO `code` VALUES ('2087', '431221', '中方县', 'BM_DISTRICT', '431200');
INSERT INTO `code` VALUES ('2088', '431222', '沅陵县', 'BM_DISTRICT', '431200');
INSERT INTO `code` VALUES ('2089', '431223', '辰溪县', 'BM_DISTRICT', '431200');
INSERT INTO `code` VALUES ('2090', '431224', '溆浦县', 'BM_DISTRICT', '431200');
INSERT INTO `code` VALUES ('2091', '431225', '会同县', 'BM_DISTRICT', '431200');
INSERT INTO `code` VALUES ('2092', '431226', '麻阳苗族自治县', 'BM_DISTRICT', '431200');
INSERT INTO `code` VALUES ('2093', '431227', '新晃侗族自治县', 'BM_DISTRICT', '431200');
INSERT INTO `code` VALUES ('2094', '431228', '芷江侗族自治县', 'BM_DISTRICT', '431200');
INSERT INTO `code` VALUES ('2095', '431229', '靖州苗族侗族自治县', 'BM_DISTRICT', '431200');
INSERT INTO `code` VALUES ('2096', '321200', '泰州市', 'BM_DISTRICT', '320000');
INSERT INTO `code` VALUES ('2097', '321201', '市辖区', 'BM_DISTRICT', '321200');
INSERT INTO `code` VALUES ('2098', '321202', '海陵区', 'BM_DISTRICT', '321200');
INSERT INTO `code` VALUES ('2099', '321203', '高港区', 'BM_DISTRICT', '321200');
INSERT INTO `code` VALUES ('2100', '321281', '兴化市', 'BM_DISTRICT', '321200');
INSERT INTO `code` VALUES ('2101', '321282', '靖江市', 'BM_DISTRICT', '321200');
INSERT INTO `code` VALUES ('2102', '321283', '泰兴市', 'BM_DISTRICT', '321200');
INSERT INTO `code` VALUES ('2103', '321284', '姜堰市', 'BM_DISTRICT', '321200');
INSERT INTO `code` VALUES ('2104', '321300', '宿迁市', 'BM_DISTRICT', '320000');
INSERT INTO `code` VALUES ('2105', '321301', '市辖区', 'BM_DISTRICT', '321300');
INSERT INTO `code` VALUES ('2106', '321302', '宿城区', 'BM_DISTRICT', '321300');
INSERT INTO `code` VALUES ('2107', '321311', '宿豫区', 'BM_DISTRICT', '321300');
INSERT INTO `code` VALUES ('2108', '321322', '沭阳县', 'BM_DISTRICT', '321300');
INSERT INTO `code` VALUES ('2109', '321323', '泗阳县', 'BM_DISTRICT', '321300');
INSERT INTO `code` VALUES ('2110', '321324', '泗洪县', 'BM_DISTRICT', '321300');
INSERT INTO `code` VALUES ('2111', '330000', '浙江省', 'BM_DISTRICT', null);
INSERT INTO `code` VALUES ('2112', '330100', '杭州市', 'BM_DISTRICT', '330000');
INSERT INTO `code` VALUES ('2113', '330101', '市辖区', 'BM_DISTRICT', '330100');
INSERT INTO `code` VALUES ('2114', '330102', '上城区', 'BM_DISTRICT', '330100');
INSERT INTO `code` VALUES ('2115', '330103', '下城区', 'BM_DISTRICT', '330100');
INSERT INTO `code` VALUES ('2116', '330104', '江干区', 'BM_DISTRICT', '330100');
INSERT INTO `code` VALUES ('2117', '330105', '拱墅区', 'BM_DISTRICT', '330100');
INSERT INTO `code` VALUES ('2118', '330106', '西湖区', 'BM_DISTRICT', '330100');
INSERT INTO `code` VALUES ('2119', '330108', '滨江区', 'BM_DISTRICT', '330100');
INSERT INTO `code` VALUES ('2120', '330109', '萧山区', 'BM_DISTRICT', '330100');
INSERT INTO `code` VALUES ('2121', '330110', '余杭区', 'BM_DISTRICT', '330100');
INSERT INTO `code` VALUES ('2122', '330122', '桐庐县', 'BM_DISTRICT', '330100');
INSERT INTO `code` VALUES ('2123', '330127', '淳安县', 'BM_DISTRICT', '330100');
INSERT INTO `code` VALUES ('2124', '330182', '建德市', 'BM_DISTRICT', '330100');
INSERT INTO `code` VALUES ('2125', '330183', '富阳市', 'BM_DISTRICT', '330100');
INSERT INTO `code` VALUES ('2126', '130502', '桥东区', 'BM_DISTRICT', '130500');
INSERT INTO `code` VALUES ('2127', '130503', '桥西区', 'BM_DISTRICT', '130500');
INSERT INTO `code` VALUES ('2128', '130521', '邢台县', 'BM_DISTRICT', '130500');
INSERT INTO `code` VALUES ('2129', '130522', '临城县', 'BM_DISTRICT', '130500');
INSERT INTO `code` VALUES ('2130', '130523', '内丘县', 'BM_DISTRICT', '130500');
INSERT INTO `code` VALUES ('2131', '130524', '柏乡县', 'BM_DISTRICT', '130500');
INSERT INTO `code` VALUES ('2132', '130525', '隆尧县', 'BM_DISTRICT', '130500');
INSERT INTO `code` VALUES ('2133', '130526', '任县', 'BM_DISTRICT', '130500');
INSERT INTO `code` VALUES ('2134', '130527', '南和县', 'BM_DISTRICT', '130500');
INSERT INTO `code` VALUES ('2135', '130528', '宁晋县', 'BM_DISTRICT', '130500');
INSERT INTO `code` VALUES ('2136', '130529', '巨鹿县', 'BM_DISTRICT', '130500');
INSERT INTO `code` VALUES ('2137', '130530', '新河县', 'BM_DISTRICT', '130500');
INSERT INTO `code` VALUES ('2138', '370682', '莱阳市', 'BM_DISTRICT', '370600');
INSERT INTO `code` VALUES ('2139', '370683', '莱州市', 'BM_DISTRICT', '370600');
INSERT INTO `code` VALUES ('2140', '370684', '蓬莱市', 'BM_DISTRICT', '370600');
INSERT INTO `code` VALUES ('2141', '370685', '招远市', 'BM_DISTRICT', '370600');
INSERT INTO `code` VALUES ('2142', '370686', '栖霞市', 'BM_DISTRICT', '370600');
INSERT INTO `code` VALUES ('2143', '370687', '海阳市', 'BM_DISTRICT', '370600');
INSERT INTO `code` VALUES ('2144', '370700', '潍坊市', 'BM_DISTRICT', '370000');
INSERT INTO `code` VALUES ('2145', '370701', '市辖区', 'BM_DISTRICT', '370700');
INSERT INTO `code` VALUES ('2146', '370702', '潍城区', 'BM_DISTRICT', '370700');
INSERT INTO `code` VALUES ('2147', '370703', '寒亭区', 'BM_DISTRICT', '370700');
INSERT INTO `code` VALUES ('2148', '410601', '市辖区', 'BM_DISTRICT', '410600');
INSERT INTO `code` VALUES ('2149', '410602', '鹤山区', 'BM_DISTRICT', '410600');
INSERT INTO `code` VALUES ('2150', '410603', '山城区', 'BM_DISTRICT', '410600');
INSERT INTO `code` VALUES ('2151', '410611', '淇滨区', 'BM_DISTRICT', '410600');
INSERT INTO `code` VALUES ('2152', '410621', '浚县', 'BM_DISTRICT', '410600');
INSERT INTO `code` VALUES ('2153', '410622', '淇县', 'BM_DISTRICT', '410600');
INSERT INTO `code` VALUES ('2154', '410700', '新乡市', 'BM_DISTRICT', '410000');
INSERT INTO `code` VALUES ('2155', '410701', '市辖区', 'BM_DISTRICT', '410700');
INSERT INTO `code` VALUES ('2156', '410702', '红旗区', 'BM_DISTRICT', '410700');
INSERT INTO `code` VALUES ('2157', '330185', '临安市', 'BM_DISTRICT', '330100');
INSERT INTO `code` VALUES ('2158', '330200', '宁波市', 'BM_DISTRICT', '330000');
INSERT INTO `code` VALUES ('2159', '330201', '市辖区', 'BM_DISTRICT', '330200');
INSERT INTO `code` VALUES ('2160', '330203', '海曙区', 'BM_DISTRICT', '330200');
INSERT INTO `code` VALUES ('2161', '330204', '江东区', 'BM_DISTRICT', '330200');
INSERT INTO `code` VALUES ('2162', '330205', '江北区', 'BM_DISTRICT', '330200');
INSERT INTO `code` VALUES ('2163', '330206', '北仑区', 'BM_DISTRICT', '330200');
INSERT INTO `code` VALUES ('2164', '330211', '镇海区', 'BM_DISTRICT', '330200');
INSERT INTO `code` VALUES ('2165', '330212', '鄞州区', 'BM_DISTRICT', '330200');
INSERT INTO `code` VALUES ('2166', '330225', '象山县', 'BM_DISTRICT', '330200');
INSERT INTO `code` VALUES ('2167', '330226', '宁海县', 'BM_DISTRICT', '330200');
INSERT INTO `code` VALUES ('2168', '330281', '余姚市', 'BM_DISTRICT', '330200');
INSERT INTO `code` VALUES ('2169', '130202', '路南区', 'BM_DISTRICT', '130200');
INSERT INTO `code` VALUES ('2170', '130203', '路北区', 'BM_DISTRICT', '130200');
INSERT INTO `code` VALUES ('2171', '411222', '陕县', 'BM_DISTRICT', '411200');
INSERT INTO `code` VALUES ('2172', '370125', '济阳县', 'BM_DISTRICT', '370100');
INSERT INTO `code` VALUES ('2173', '370126', '商河县', 'BM_DISTRICT', '370100');
INSERT INTO `code` VALUES ('2174', '370181', '章丘市', 'BM_DISTRICT', '370100');
INSERT INTO `code` VALUES ('2175', '370200', '青岛市', 'BM_DISTRICT', '370000');
INSERT INTO `code` VALUES ('2176', '330282', '慈溪市', 'BM_DISTRICT', '330200');
INSERT INTO `code` VALUES ('2177', '330283', '奉化市', 'BM_DISTRICT', '330200');
INSERT INTO `code` VALUES ('2178', '330300', '温州市', 'BM_DISTRICT', '330000');
INSERT INTO `code` VALUES ('2179', '330301', '市辖区', 'BM_DISTRICT', '330300');
INSERT INTO `code` VALUES ('2180', '330302', '鹿城区', 'BM_DISTRICT', '330300');
INSERT INTO `code` VALUES ('2181', '330303', '龙湾区', 'BM_DISTRICT', '330300');
INSERT INTO `code` VALUES ('2182', '330304', '瓯海区', 'BM_DISTRICT', '330300');
INSERT INTO `code` VALUES ('2183', '330322', '洞头县', 'BM_DISTRICT', '330300');
INSERT INTO `code` VALUES ('2184', '330324', '永嘉县', 'BM_DISTRICT', '330300');
INSERT INTO `code` VALUES ('2185', '330326', '平阳县', 'BM_DISTRICT', '330300');
INSERT INTO `code` VALUES ('2186', '330327', '苍南县', 'BM_DISTRICT', '330300');
INSERT INTO `code` VALUES ('2187', '330328', '文成县', 'BM_DISTRICT', '330300');
INSERT INTO `code` VALUES ('2188', '330329', '泰顺县', 'BM_DISTRICT', '330300');
INSERT INTO `code` VALUES ('2189', '330381', '瑞安市', 'BM_DISTRICT', '330300');
INSERT INTO `code` VALUES ('2190', '330382', '乐清市', 'BM_DISTRICT', '330300');
INSERT INTO `code` VALUES ('2191', '330400', '嘉兴市', 'BM_DISTRICT', '330000');
INSERT INTO `code` VALUES ('2192', '330401', '市辖区', 'BM_DISTRICT', '330400');
INSERT INTO `code` VALUES ('2193', '330402', '南湖区', 'BM_DISTRICT', '330400');
INSERT INTO `code` VALUES ('2194', '421081', '石首市', 'BM_DISTRICT', '421000');
INSERT INTO `code` VALUES ('2195', '421083', '洪湖市', 'BM_DISTRICT', '421000');
INSERT INTO `code` VALUES ('2196', '421087', '松滋市', 'BM_DISTRICT', '421000');
INSERT INTO `code` VALUES ('2197', '421100', '黄冈市', 'BM_DISTRICT', '420000');
INSERT INTO `code` VALUES ('2198', '421101', '市辖区', 'BM_DISTRICT', '421100');
INSERT INTO `code` VALUES ('2199', '421102', '黄州区', 'BM_DISTRICT', '421100');
INSERT INTO `code` VALUES ('2200', '421121', '团风县', 'BM_DISTRICT', '421100');
INSERT INTO `code` VALUES ('2201', '421122', '红安县', 'BM_DISTRICT', '421100');
INSERT INTO `code` VALUES ('2202', '421123', '罗田县', 'BM_DISTRICT', '421100');
INSERT INTO `code` VALUES ('2203', '421124', '英山县', 'BM_DISTRICT', '421100');
INSERT INTO `code` VALUES ('2204', '421125', '浠水县', 'BM_DISTRICT', '421100');
INSERT INTO `code` VALUES ('2205', '421126', '蕲春县', 'BM_DISTRICT', '421100');
INSERT INTO `code` VALUES ('2206', '421127', '黄梅县', 'BM_DISTRICT', '421100');
INSERT INTO `code` VALUES ('2207', '421181', '麻城市', 'BM_DISTRICT', '421100');
INSERT INTO `code` VALUES ('2208', '421182', '武穴市', 'BM_DISTRICT', '421100');
INSERT INTO `code` VALUES ('2209', '421200', '咸宁市', 'BM_DISTRICT', '420000');
INSERT INTO `code` VALUES ('2210', '421201', '市辖区', 'BM_DISTRICT', '421200');
INSERT INTO `code` VALUES ('2211', '421202', '咸安区', 'BM_DISTRICT', '421200');
INSERT INTO `code` VALUES ('2212', '421221', '嘉鱼县', 'BM_DISTRICT', '421200');
INSERT INTO `code` VALUES ('2213', '421222', '通城县', 'BM_DISTRICT', '421200');
INSERT INTO `code` VALUES ('2214', '421223', '崇阳县', 'BM_DISTRICT', '421200');
INSERT INTO `code` VALUES ('2215', '421224', '通山县', 'BM_DISTRICT', '421200');
INSERT INTO `code` VALUES ('2216', '421281', '赤壁市', 'BM_DISTRICT', '421200');
INSERT INTO `code` VALUES ('2217', '421300', '随州市', 'BM_DISTRICT', '420000');
INSERT INTO `code` VALUES ('2218', '421301', '市辖区', 'BM_DISTRICT', '421300');
INSERT INTO `code` VALUES ('2219', '421303', '曾都区', 'BM_DISTRICT', '421300');
INSERT INTO `code` VALUES ('2220', '421321', '随县', 'BM_DISTRICT', '421300');
INSERT INTO `code` VALUES ('2221', '421381', '广水市', 'BM_DISTRICT', '421300');
INSERT INTO `code` VALUES ('2222', '422800', '恩施土家族苗族自治州', 'BM_DISTRICT', '420000');
INSERT INTO `code` VALUES ('2223', '410703', '卫滨区', 'BM_DISTRICT', '410700');
INSERT INTO `code` VALUES ('2224', '410704', '凤泉区', 'BM_DISTRICT', '410700');
INSERT INTO `code` VALUES ('2225', '410711', '牧野区', 'BM_DISTRICT', '410700');
INSERT INTO `code` VALUES ('2226', '410721', '新乡县', 'BM_DISTRICT', '410700');
INSERT INTO `code` VALUES ('2227', '410724', '获嘉县', 'BM_DISTRICT', '410700');
INSERT INTO `code` VALUES ('2228', '410725', '原阳县', 'BM_DISTRICT', '410700');
INSERT INTO `code` VALUES ('2229', '410726', '延津县', 'BM_DISTRICT', '410700');
INSERT INTO `code` VALUES ('2230', '410727', '封丘县', 'BM_DISTRICT', '410700');
INSERT INTO `code` VALUES ('2231', '410728', '长垣县', 'BM_DISTRICT', '410700');
INSERT INTO `code` VALUES ('2232', '410781', '卫辉市', 'BM_DISTRICT', '410700');
INSERT INTO `code` VALUES ('2233', '410782', '辉县市', 'BM_DISTRICT', '410700');
INSERT INTO `code` VALUES ('2234', '410800', '焦作市', 'BM_DISTRICT', '410000');
INSERT INTO `code` VALUES ('2235', '370201', '市辖区', 'BM_DISTRICT', '370200');
INSERT INTO `code` VALUES ('2236', '370202', '市南区', 'BM_DISTRICT', '370200');
INSERT INTO `code` VALUES ('2237', '370203', '市北区', 'BM_DISTRICT', '370200');
INSERT INTO `code` VALUES ('2238', '370205', '四方区', 'BM_DISTRICT', '370200');
INSERT INTO `code` VALUES ('2239', '370211', '黄岛区', 'BM_DISTRICT', '370200');
INSERT INTO `code` VALUES ('2240', '370212', '崂山区', 'BM_DISTRICT', '370200');
INSERT INTO `code` VALUES ('2241', '370213', '李沧区', 'BM_DISTRICT', '370200');
INSERT INTO `code` VALUES ('2242', '370214', '城阳区', 'BM_DISTRICT', '370200');
INSERT INTO `code` VALUES ('2243', '370281', '胶州市', 'BM_DISTRICT', '370200');
INSERT INTO `code` VALUES ('2244', '370282', '即墨市', 'BM_DISTRICT', '370200');
INSERT INTO `code` VALUES ('2245', '370283', '平度市', 'BM_DISTRICT', '370200');
INSERT INTO `code` VALUES ('2246', '370284', '胶南市', 'BM_DISTRICT', '370200');
INSERT INTO `code` VALUES ('2247', '370285', '莱西市', 'BM_DISTRICT', '370200');
INSERT INTO `code` VALUES ('2248', '370300', '淄博市', 'BM_DISTRICT', '370000');
INSERT INTO `code` VALUES ('2249', '370301', '市辖区', 'BM_DISTRICT', '370300');
INSERT INTO `code` VALUES ('2250', '370302', '淄川区', 'BM_DISTRICT', '370300');
INSERT INTO `code` VALUES ('2251', '370303', '张店区', 'BM_DISTRICT', '370300');
INSERT INTO `code` VALUES ('2252', '370304', '博山区', 'BM_DISTRICT', '370300');
INSERT INTO `code` VALUES ('2253', '370305', '临淄区', 'BM_DISTRICT', '370300');
INSERT INTO `code` VALUES ('2254', '370306', '周村区', 'BM_DISTRICT', '370300');
INSERT INTO `code` VALUES ('2255', '370321', '桓台县', 'BM_DISTRICT', '370300');
INSERT INTO `code` VALUES ('2256', '370322', '高青县', 'BM_DISTRICT', '370300');
INSERT INTO `code` VALUES ('2257', '370323', '沂源县', 'BM_DISTRICT', '370300');
INSERT INTO `code` VALUES ('2258', '370400', '枣庄市', 'BM_DISTRICT', '370000');
INSERT INTO `code` VALUES ('2259', '370401', '市辖区', 'BM_DISTRICT', '370400');
INSERT INTO `code` VALUES ('2260', '370402', '市中区', 'BM_DISTRICT', '370400');
INSERT INTO `code` VALUES ('2261', '370403', '薛城区', 'BM_DISTRICT', '370400');
INSERT INTO `code` VALUES ('2262', '370404', '峄城区', 'BM_DISTRICT', '370400');
INSERT INTO `code` VALUES ('2263', '450311', '雁山区', 'BM_DISTRICT', '450300');
INSERT INTO `code` VALUES ('2264', '450321', '阳朔县', 'BM_DISTRICT', '450300');
INSERT INTO `code` VALUES ('2265', '450322', '临桂县', 'BM_DISTRICT', '450300');
INSERT INTO `code` VALUES ('2266', '450323', '灵川县', 'BM_DISTRICT', '450300');
INSERT INTO `code` VALUES ('2267', '450324', '全州县', 'BM_DISTRICT', '450300');
INSERT INTO `code` VALUES ('2268', '450325', '兴安县', 'BM_DISTRICT', '450300');
INSERT INTO `code` VALUES ('2269', '450326', '永福县', 'BM_DISTRICT', '450300');
INSERT INTO `code` VALUES ('2270', '450327', '灌阳县', 'BM_DISTRICT', '450300');
INSERT INTO `code` VALUES ('2271', '450328', '龙胜各族自治县', 'BM_DISTRICT', '450300');
INSERT INTO `code` VALUES ('2272', '450329', '资源县', 'BM_DISTRICT', '450300');
INSERT INTO `code` VALUES ('2273', '450330', '平乐县', 'BM_DISTRICT', '450300');
INSERT INTO `code` VALUES ('2274', '450331', '荔浦县', 'BM_DISTRICT', '450300');
INSERT INTO `code` VALUES ('2275', '450332', '恭城瑶族自治县', 'BM_DISTRICT', '450300');
INSERT INTO `code` VALUES ('2276', '450400', '梧州市', 'BM_DISTRICT', '450000');
INSERT INTO `code` VALUES ('2277', '450401', '市辖区', 'BM_DISTRICT', '450400');
INSERT INTO `code` VALUES ('2278', '450403', '万秀区', 'BM_DISTRICT', '450400');
INSERT INTO `code` VALUES ('2279', '371302', '兰山区', 'BM_DISTRICT', '371300');
INSERT INTO `code` VALUES ('2280', '371311', '罗庄区', 'BM_DISTRICT', '371300');
INSERT INTO `code` VALUES ('2281', '371312', '河东区', 'BM_DISTRICT', '371300');
INSERT INTO `code` VALUES ('2282', '371321', '沂南县', 'BM_DISTRICT', '371300');
INSERT INTO `code` VALUES ('2283', '371322', '郯城县', 'BM_DISTRICT', '371300');
INSERT INTO `code` VALUES ('2284', '371323', '沂水县', 'BM_DISTRICT', '371300');
INSERT INTO `code` VALUES ('2285', '371324', '苍山县', 'BM_DISTRICT', '371300');
INSERT INTO `code` VALUES ('2286', '371325', '费县', 'BM_DISTRICT', '371300');
INSERT INTO `code` VALUES ('2287', '371326', '平邑县', 'BM_DISTRICT', '371300');
INSERT INTO `code` VALUES ('2288', '370704', '坊子区', 'BM_DISTRICT', '370700');
INSERT INTO `code` VALUES ('2289', '370705', '奎文区', 'BM_DISTRICT', '370700');
INSERT INTO `code` VALUES ('2290', '370724', '临朐县', 'BM_DISTRICT', '370700');
INSERT INTO `code` VALUES ('2291', '370725', '昌乐县', 'BM_DISTRICT', '370700');
INSERT INTO `code` VALUES ('2292', '410801', '市辖区', 'BM_DISTRICT', '410800');
INSERT INTO `code` VALUES ('2293', '410802', '解放区', 'BM_DISTRICT', '410800');
INSERT INTO `code` VALUES ('2294', '410803', '中站区', 'BM_DISTRICT', '410800');
INSERT INTO `code` VALUES ('2295', '410804', '马村区', 'BM_DISTRICT', '410800');
INSERT INTO `code` VALUES ('2296', '410811', '山阳区', 'BM_DISTRICT', '410800');
INSERT INTO `code` VALUES ('2297', '410821', '修武县', 'BM_DISTRICT', '410800');
INSERT INTO `code` VALUES ('2298', '410822', '博爱县', 'BM_DISTRICT', '410800');
INSERT INTO `code` VALUES ('2299', '410823', '武陟县', 'BM_DISTRICT', '410800');
INSERT INTO `code` VALUES ('2300', '410825', '温县', 'BM_DISTRICT', '410800');
INSERT INTO `code` VALUES ('2301', '410882', '沁阳市', 'BM_DISTRICT', '410800');
INSERT INTO `code` VALUES ('2302', '410883', '孟州市', 'BM_DISTRICT', '410800');
INSERT INTO `code` VALUES ('2303', '410900', '濮阳市', 'BM_DISTRICT', '410000');
INSERT INTO `code` VALUES ('2304', '410901', '市辖区', 'BM_DISTRICT', '410900');
INSERT INTO `code` VALUES ('2305', '410902', '华龙区', 'BM_DISTRICT', '410900');
INSERT INTO `code` VALUES ('2306', '410922', '清丰县', 'BM_DISTRICT', '410900');
INSERT INTO `code` VALUES ('2307', '410923', '南乐县', 'BM_DISTRICT', '410900');
INSERT INTO `code` VALUES ('2308', '410926', '范县', 'BM_DISTRICT', '410900');
INSERT INTO `code` VALUES ('2309', '450603', '防城区', 'BM_DISTRICT', '450600');
INSERT INTO `code` VALUES ('2310', '450621', '上思县', 'BM_DISTRICT', '450600');
INSERT INTO `code` VALUES ('2311', '450681', '东兴市', 'BM_DISTRICT', '450600');
INSERT INTO `code` VALUES ('2312', '450700', '钦州市', 'BM_DISTRICT', '450000');
INSERT INTO `code` VALUES ('2313', '450701', '市辖区', 'BM_DISTRICT', '450700');
INSERT INTO `code` VALUES ('2314', '450702', '钦南区', 'BM_DISTRICT', '450700');
INSERT INTO `code` VALUES ('2315', '450703', '钦北区', 'BM_DISTRICT', '450700');
INSERT INTO `code` VALUES ('2316', '450721', '灵山县', 'BM_DISTRICT', '450700');
INSERT INTO `code` VALUES ('2317', '450722', '浦北县', 'BM_DISTRICT', '450700');
INSERT INTO `code` VALUES ('2318', '450800', '贵港市', 'BM_DISTRICT', '450000');
INSERT INTO `code` VALUES ('2319', '450801', '市辖区', 'BM_DISTRICT', '450800');
INSERT INTO `code` VALUES ('2320', '450802', '港北区', 'BM_DISTRICT', '450800');
INSERT INTO `code` VALUES ('2321', '320200', '无锡市', 'BM_DISTRICT', '320000');
INSERT INTO `code` VALUES ('2322', '320201', '市辖区', 'BM_DISTRICT', '320200');
INSERT INTO `code` VALUES ('2323', '320202', '崇安区', 'BM_DISTRICT', '320200');
INSERT INTO `code` VALUES ('2324', '320203', '南长区', 'BM_DISTRICT', '320200');
INSERT INTO `code` VALUES ('2325', '320204', '北塘区', 'BM_DISTRICT', '320200');
INSERT INTO `code` VALUES ('2326', '320205', '锡山区', 'BM_DISTRICT', '320200');
INSERT INTO `code` VALUES ('2327', '320206', '惠山区', 'BM_DISTRICT', '320200');
INSERT INTO `code` VALUES ('2328', '320211', '滨湖区', 'BM_DISTRICT', '320200');
INSERT INTO `code` VALUES ('2329', '320281', '江阴市', 'BM_DISTRICT', '320200');
INSERT INTO `code` VALUES ('2330', '422801', '恩施市', 'BM_DISTRICT', '422800');
INSERT INTO `code` VALUES ('2331', '422802', '利川市', 'BM_DISTRICT', '422800');
INSERT INTO `code` VALUES ('2332', '422822', '建始县', 'BM_DISTRICT', '422800');
INSERT INTO `code` VALUES ('2333', '422823', '巴东县', 'BM_DISTRICT', '422800');
INSERT INTO `code` VALUES ('2334', '422825', '宣恩县', 'BM_DISTRICT', '422800');
INSERT INTO `code` VALUES ('2335', '422826', '咸丰县', 'BM_DISTRICT', '422800');
INSERT INTO `code` VALUES ('2336', '422827', '来凤县', 'BM_DISTRICT', '422800');
INSERT INTO `code` VALUES ('2337', '422828', '鹤峰县', 'BM_DISTRICT', '422800');
INSERT INTO `code` VALUES ('2338', '429000', '省直辖县级行政区划', 'BM_DISTRICT', '420000');
INSERT INTO `code` VALUES ('2339', '429004', '仙桃市', 'BM_DISTRICT', '429000');
INSERT INTO `code` VALUES ('2340', '429005', '潜江市', 'BM_DISTRICT', '429000');
INSERT INTO `code` VALUES ('2341', '429006', '天门市', 'BM_DISTRICT', '429000');
INSERT INTO `code` VALUES ('2342', '370781', '青州市', 'BM_DISTRICT', '370700');
INSERT INTO `code` VALUES ('2343', '370782', '诸城市', 'BM_DISTRICT', '370700');
INSERT INTO `code` VALUES ('2344', '370783', '寿光市', 'BM_DISTRICT', '370700');
INSERT INTO `code` VALUES ('2345', '370784', '安丘市', 'BM_DISTRICT', '370700');
INSERT INTO `code` VALUES ('2346', '370785', '高密市', 'BM_DISTRICT', '370700');
INSERT INTO `code` VALUES ('2347', '370786', '昌邑市', 'BM_DISTRICT', '370700');
INSERT INTO `code` VALUES ('2348', '370800', '济宁市', 'BM_DISTRICT', '370000');
INSERT INTO `code` VALUES ('2349', '370801', '市辖区', 'BM_DISTRICT', '370800');
INSERT INTO `code` VALUES ('2350', '370802', '市中区', 'BM_DISTRICT', '370800');
INSERT INTO `code` VALUES ('2351', '370811', '任城区', 'BM_DISTRICT', '370800');
INSERT INTO `code` VALUES ('2352', '370826', '微山县', 'BM_DISTRICT', '370800');
INSERT INTO `code` VALUES ('2353', '370827', '鱼台县', 'BM_DISTRICT', '370800');
INSERT INTO `code` VALUES ('2354', '370828', '金乡县', 'BM_DISTRICT', '370800');
INSERT INTO `code` VALUES ('2355', '370829', '嘉祥县', 'BM_DISTRICT', '370800');
INSERT INTO `code` VALUES ('2356', '370830', '汶上县', 'BM_DISTRICT', '370800');
INSERT INTO `code` VALUES ('2357', '370831', '泗水县', 'BM_DISTRICT', '370800');
INSERT INTO `code` VALUES ('2358', '370832', '梁山县', 'BM_DISTRICT', '370800');
INSERT INTO `code` VALUES ('2359', '370881', '曲阜市', 'BM_DISTRICT', '370800');
INSERT INTO `code` VALUES ('2360', '370882', '兖州市', 'BM_DISTRICT', '370800');
INSERT INTO `code` VALUES ('2361', '370883', '邹城市', 'BM_DISTRICT', '370800');
INSERT INTO `code` VALUES ('2362', '370900', '泰安市', 'BM_DISTRICT', '370000');
INSERT INTO `code` VALUES ('2363', '370901', '市辖区', 'BM_DISTRICT', '370900');
INSERT INTO `code` VALUES ('2364', '370902', '泰山区', 'BM_DISTRICT', '370900');
INSERT INTO `code` VALUES ('2365', '370911', '岱岳区', 'BM_DISTRICT', '370900');
INSERT INTO `code` VALUES ('2366', '370921', '宁阳县', 'BM_DISTRICT', '370900');
INSERT INTO `code` VALUES ('2367', '370923', '东平县', 'BM_DISTRICT', '370900');
INSERT INTO `code` VALUES ('2368', '370982', '新泰市', 'BM_DISTRICT', '370900');
INSERT INTO `code` VALUES ('2369', '370983', '肥城市', 'BM_DISTRICT', '370900');
INSERT INTO `code` VALUES ('2370', '450404', '蝶山区', 'BM_DISTRICT', '450400');
INSERT INTO `code` VALUES ('2371', '450405', '长洲区', 'BM_DISTRICT', '450400');
INSERT INTO `code` VALUES ('2372', '450421', '苍梧县', 'BM_DISTRICT', '450400');
INSERT INTO `code` VALUES ('2373', '450422', '藤县', 'BM_DISTRICT', '450400');
INSERT INTO `code` VALUES ('2374', '450423', '蒙山县', 'BM_DISTRICT', '450400');
INSERT INTO `code` VALUES ('2375', '410105', '金水区', 'BM_DISTRICT', '410100');
INSERT INTO `code` VALUES ('2376', '410106', '上街区', 'BM_DISTRICT', '410100');
INSERT INTO `code` VALUES ('2377', '410108', '惠济区', 'BM_DISTRICT', '410100');
INSERT INTO `code` VALUES ('2378', '410122', '中牟县', 'BM_DISTRICT', '410100');
INSERT INTO `code` VALUES ('2379', '410181', '巩义市', 'BM_DISTRICT', '410100');
INSERT INTO `code` VALUES ('2380', '410182', '荥阳市', 'BM_DISTRICT', '410100');
INSERT INTO `code` VALUES ('2381', '410183', '新密市', 'BM_DISTRICT', '410100');
INSERT INTO `code` VALUES ('2382', '410184', '新郑市', 'BM_DISTRICT', '410100');
INSERT INTO `code` VALUES ('2383', '410185', '登封市', 'BM_DISTRICT', '410100');
INSERT INTO `code` VALUES ('2384', '410200', '开封市', 'BM_DISTRICT', '410000');
INSERT INTO `code` VALUES ('2385', '411224', '卢氏县', 'BM_DISTRICT', '411200');
INSERT INTO `code` VALUES ('2386', '411281', '义马市', 'BM_DISTRICT', '411200');
INSERT INTO `code` VALUES ('2387', '411282', '灵宝市', 'BM_DISTRICT', '411200');
INSERT INTO `code` VALUES ('2388', '411300', '南阳市', 'BM_DISTRICT', '410000');
INSERT INTO `code` VALUES ('2389', '429021', '神农架林区', 'BM_DISTRICT', '429000');
INSERT INTO `code` VALUES ('2390', '430000', '湖南省', 'BM_DISTRICT', null);
INSERT INTO `code` VALUES ('2391', '430100', '长沙市', 'BM_DISTRICT', '430000');
INSERT INTO `code` VALUES ('2392', '430101', '市辖区', 'BM_DISTRICT', '430100');
INSERT INTO `code` VALUES ('2393', '430102', '芙蓉区', 'BM_DISTRICT', '430100');
INSERT INTO `code` VALUES ('2394', '430103', '天心区', 'BM_DISTRICT', '430100');
INSERT INTO `code` VALUES ('2395', '430104', '岳麓区', 'BM_DISTRICT', '430100');
INSERT INTO `code` VALUES ('2396', '430105', '开福区', 'BM_DISTRICT', '430100');
INSERT INTO `code` VALUES ('2397', '430111', '雨花区', 'BM_DISTRICT', '430100');
INSERT INTO `code` VALUES ('2398', '430112', '望城区', 'BM_DISTRICT', '430100');
INSERT INTO `code` VALUES ('2399', '430121', '长沙县', 'BM_DISTRICT', '430100');
INSERT INTO `code` VALUES ('2400', '430124', '宁乡县', 'BM_DISTRICT', '430100');
INSERT INTO `code` VALUES ('2401', '430181', '浏阳市', 'BM_DISTRICT', '430100');
INSERT INTO `code` VALUES ('2402', '430200', '株洲市', 'BM_DISTRICT', '430000');
INSERT INTO `code` VALUES ('2403', '430201', '市辖区', 'BM_DISTRICT', '430200');
INSERT INTO `code` VALUES ('2404', '430202', '荷塘区', 'BM_DISTRICT', '430200');
INSERT INTO `code` VALUES ('2405', '430203', '芦淞区', 'BM_DISTRICT', '430200');
INSERT INTO `code` VALUES ('2406', '430204', '石峰区', 'BM_DISTRICT', '430200');
INSERT INTO `code` VALUES ('2407', '320282', '宜兴市', 'BM_DISTRICT', '320200');
INSERT INTO `code` VALUES ('2408', '320300', '徐州市', 'BM_DISTRICT', '320000');
INSERT INTO `code` VALUES ('2409', '320301', '市辖区', 'BM_DISTRICT', '320300');
INSERT INTO `code` VALUES ('2410', '320302', '鼓楼区', 'BM_DISTRICT', '320300');
INSERT INTO `code` VALUES ('2411', '320303', '云龙区', 'BM_DISTRICT', '320300');
INSERT INTO `code` VALUES ('2412', '320305', '贾汪区', 'BM_DISTRICT', '320300');
INSERT INTO `code` VALUES ('2413', '320311', '泉山区', 'BM_DISTRICT', '320300');
INSERT INTO `code` VALUES ('2414', '320312', '铜山区', 'BM_DISTRICT', '320300');
INSERT INTO `code` VALUES ('2415', '320321', '丰县', 'BM_DISTRICT', '320300');
INSERT INTO `code` VALUES ('2416', '320322', '沛县', 'BM_DISTRICT', '320300');
INSERT INTO `code` VALUES ('2417', '320324', '睢宁县', 'BM_DISTRICT', '320300');
INSERT INTO `code` VALUES ('2418', '320381', '新沂市', 'BM_DISTRICT', '320300');
INSERT INTO `code` VALUES ('2419', '330800', '衢州市', 'BM_DISTRICT', '330000');
INSERT INTO `code` VALUES ('2420', '330801', '市辖区', 'BM_DISTRICT', '330800');
INSERT INTO `code` VALUES ('2421', '330802', '柯城区', 'BM_DISTRICT', '330800');
INSERT INTO `code` VALUES ('2422', '330803', '衢江区', 'BM_DISTRICT', '330800');
INSERT INTO `code` VALUES ('2423', '330822', '常山县', 'BM_DISTRICT', '330800');
INSERT INTO `code` VALUES ('2424', '330824', '开化县', 'BM_DISTRICT', '330800');
INSERT INTO `code` VALUES ('2425', '330825', '龙游县', 'BM_DISTRICT', '330800');
INSERT INTO `code` VALUES ('2426', '330881', '江山市', 'BM_DISTRICT', '330800');
INSERT INTO `code` VALUES ('2427', '330900', '舟山市', 'BM_DISTRICT', '330000');
INSERT INTO `code` VALUES ('2428', '330901', '市辖区', 'BM_DISTRICT', '330900');
INSERT INTO `code` VALUES ('2429', '330902', '定海区', 'BM_DISTRICT', '330900');
INSERT INTO `code` VALUES ('2430', '330903', '普陀区', 'BM_DISTRICT', '330900');
INSERT INTO `code` VALUES ('2431', '330921', '岱山县', 'BM_DISTRICT', '330900');
INSERT INTO `code` VALUES ('2432', '330922', '嵊泗县', 'BM_DISTRICT', '330900');
INSERT INTO `code` VALUES ('2433', '331000', '台州市', 'BM_DISTRICT', '330000');
INSERT INTO `code` VALUES ('2434', '331001', '市辖区', 'BM_DISTRICT', '331000');
INSERT INTO `code` VALUES ('2435', '331002', '椒江区', 'BM_DISTRICT', '331000');
INSERT INTO `code` VALUES ('2436', '331003', '黄岩区', 'BM_DISTRICT', '331000');
INSERT INTO `code` VALUES ('2437', '331004', '路桥区', 'BM_DISTRICT', '331000');
INSERT INTO `code` VALUES ('2438', '331021', '玉环县', 'BM_DISTRICT', '331000');
INSERT INTO `code` VALUES ('2439', '331022', '三门县', 'BM_DISTRICT', '331000');
INSERT INTO `code` VALUES ('2440', '331023', '天台县', 'BM_DISTRICT', '331000');
INSERT INTO `code` VALUES ('2441', '331024', '仙居县', 'BM_DISTRICT', '331000');
INSERT INTO `code` VALUES ('2442', '331081', '温岭市', 'BM_DISTRICT', '331000');
INSERT INTO `code` VALUES ('2443', '331082', '临海市', 'BM_DISTRICT', '331000');
INSERT INTO `code` VALUES ('2444', '331100', '丽水市', 'BM_DISTRICT', '330000');
INSERT INTO `code` VALUES ('2445', '331101', '市辖区', 'BM_DISTRICT', '331100');
INSERT INTO `code` VALUES ('2446', '331102', '莲都区', 'BM_DISTRICT', '331100');
INSERT INTO `code` VALUES ('2447', '430211', '天元区', 'BM_DISTRICT', '430200');
INSERT INTO `code` VALUES ('2448', '430221', '株洲县', 'BM_DISTRICT', '430200');
INSERT INTO `code` VALUES ('2449', '430223', '攸县', 'BM_DISTRICT', '430200');
INSERT INTO `code` VALUES ('2450', '430224', '茶陵县', 'BM_DISTRICT', '430200');
INSERT INTO `code` VALUES ('2451', '430225', '炎陵县', 'BM_DISTRICT', '430200');
INSERT INTO `code` VALUES ('2452', '430281', '醴陵市', 'BM_DISTRICT', '430200');
INSERT INTO `code` VALUES ('2453', '430300', '湘潭市', 'BM_DISTRICT', '430000');
INSERT INTO `code` VALUES ('2454', '430301', '市辖区', 'BM_DISTRICT', '430300');
INSERT INTO `code` VALUES ('2455', '430302', '雨湖区', 'BM_DISTRICT', '430300');
INSERT INTO `code` VALUES ('2456', '430304', '岳塘区', 'BM_DISTRICT', '430300');
INSERT INTO `code` VALUES ('2457', '430321', '湘潭县', 'BM_DISTRICT', '430300');
INSERT INTO `code` VALUES ('2458', '430381', '湘乡市', 'BM_DISTRICT', '430300');
INSERT INTO `code` VALUES ('2459', '430382', '韶山市', 'BM_DISTRICT', '430300');
INSERT INTO `code` VALUES ('2460', '430400', '衡阳市', 'BM_DISTRICT', '430000');
INSERT INTO `code` VALUES ('2461', '430401', '市辖区', 'BM_DISTRICT', '430400');
INSERT INTO `code` VALUES ('2462', '430405', '珠晖区', 'BM_DISTRICT', '430400');
INSERT INTO `code` VALUES ('2463', '430406', '雁峰区', 'BM_DISTRICT', '430400');
INSERT INTO `code` VALUES ('2464', '430407', '石鼓区', 'BM_DISTRICT', '430400');
INSERT INTO `code` VALUES ('2465', '430408', '蒸湘区', 'BM_DISTRICT', '430400');
INSERT INTO `code` VALUES ('2466', '430412', '南岳区', 'BM_DISTRICT', '430400');
INSERT INTO `code` VALUES ('2467', '430421', '衡阳县', 'BM_DISTRICT', '430400');
INSERT INTO `code` VALUES ('2468', '430422', '衡南县', 'BM_DISTRICT', '430400');
INSERT INTO `code` VALUES ('2469', '430423', '衡山县', 'BM_DISTRICT', '430400');
INSERT INTO `code` VALUES ('2470', '430424', '衡东县', 'BM_DISTRICT', '430400');
INSERT INTO `code` VALUES ('2471', '430426', '祁东县', 'BM_DISTRICT', '430400');
INSERT INTO `code` VALUES ('2472', '430481', '耒阳市', 'BM_DISTRICT', '430400');
INSERT INTO `code` VALUES ('2473', '430482', '常宁市', 'BM_DISTRICT', '430400');
INSERT INTO `code` VALUES ('2474', '430500', '邵阳市', 'BM_DISTRICT', '430000');
INSERT INTO `code` VALUES ('2475', '430501', '市辖区', 'BM_DISTRICT', '430500');
INSERT INTO `code` VALUES ('2476', '450923', '博白县', 'BM_DISTRICT', '450900');
INSERT INTO `code` VALUES ('2477', '450924', '兴业县', 'BM_DISTRICT', '450900');
INSERT INTO `code` VALUES ('2478', '450981', '北流市', 'BM_DISTRICT', '450900');
INSERT INTO `code` VALUES ('2479', '411301', '市辖区', 'BM_DISTRICT', '411300');
INSERT INTO `code` VALUES ('2480', '411302', '宛城区', 'BM_DISTRICT', '411300');
INSERT INTO `code` VALUES ('2481', '411303', '卧龙区', 'BM_DISTRICT', '411300');
INSERT INTO `code` VALUES ('2482', '411321', '南召县', 'BM_DISTRICT', '411300');
INSERT INTO `code` VALUES ('2483', '411322', '方城县', 'BM_DISTRICT', '411300');
INSERT INTO `code` VALUES ('2484', '411323', '西峡县', 'BM_DISTRICT', '411300');
INSERT INTO `code` VALUES ('2485', '411324', '镇平县', 'BM_DISTRICT', '411300');
INSERT INTO `code` VALUES ('2486', '411325', '内乡县', 'BM_DISTRICT', '411300');
INSERT INTO `code` VALUES ('2487', '411326', '淅川县', 'BM_DISTRICT', '411300');
INSERT INTO `code` VALUES ('2488', '411327', '社旗县', 'BM_DISTRICT', '411300');
INSERT INTO `code` VALUES ('2489', '411328', '唐河县', 'BM_DISTRICT', '411300');
INSERT INTO `code` VALUES ('2490', '411329', '新野县', 'BM_DISTRICT', '411300');
INSERT INTO `code` VALUES ('2491', '411330', '桐柏县', 'BM_DISTRICT', '411300');
INSERT INTO `code` VALUES ('2492', '411381', '邓州市', 'BM_DISTRICT', '411300');
INSERT INTO `code` VALUES ('2493', '411400', '商丘市', 'BM_DISTRICT', '410000');
INSERT INTO `code` VALUES ('2494', '411401', '市辖区', 'BM_DISTRICT', '411400');
INSERT INTO `code` VALUES ('2495', '411402', '梁园区', 'BM_DISTRICT', '411400');
INSERT INTO `code` VALUES ('2496', '411403', '睢阳区', 'BM_DISTRICT', '411400');
INSERT INTO `code` VALUES ('2497', '411421', '民权县', 'BM_DISTRICT', '411400');
INSERT INTO `code` VALUES ('2498', '411422', '睢县', 'BM_DISTRICT', '411400');
INSERT INTO `code` VALUES ('2499', '411423', '宁陵县', 'BM_DISTRICT', '411400');
INSERT INTO `code` VALUES ('2500', '411424', '柘城县', 'BM_DISTRICT', '411400');
INSERT INTO `code` VALUES ('2501', '411425', '虞城县', 'BM_DISTRICT', '411400');
INSERT INTO `code` VALUES ('2502', '411426', '夏邑县', 'BM_DISTRICT', '411400');
INSERT INTO `code` VALUES ('2503', '411481', '永城市', 'BM_DISTRICT', '411400');
INSERT INTO `code` VALUES ('2504', '411500', '信阳市', 'BM_DISTRICT', '410000');
INSERT INTO `code` VALUES ('2505', '411501', '市辖区', 'BM_DISTRICT', '411500');
INSERT INTO `code` VALUES ('2506', '411502', '浉河区', 'BM_DISTRICT', '411500');
INSERT INTO `code` VALUES ('2507', '411503', '平桥区', 'BM_DISTRICT', '411500');
INSERT INTO `code` VALUES ('2508', '411521', '罗山县', 'BM_DISTRICT', '411500');
INSERT INTO `code` VALUES ('2509', '411522', '光山县', 'BM_DISTRICT', '411500');
INSERT INTO `code` VALUES ('2510', '411523', '新县', 'BM_DISTRICT', '411500');
INSERT INTO `code` VALUES ('2511', '411524', '商城县', 'BM_DISTRICT', '411500');
INSERT INTO `code` VALUES ('2512', '320723', '灌云县', 'BM_DISTRICT', '320700');
INSERT INTO `code` VALUES ('2513', '371327', '莒南县', 'BM_DISTRICT', '371300');
INSERT INTO `code` VALUES ('2514', '371328', '蒙阴县', 'BM_DISTRICT', '371300');
INSERT INTO `code` VALUES ('2515', '371329', '临沭县', 'BM_DISTRICT', '371300');
INSERT INTO `code` VALUES ('2516', '371400', '德州市', 'BM_DISTRICT', '370000');
INSERT INTO `code` VALUES ('2517', '320382', '邳州市', 'BM_DISTRICT', '320300');
INSERT INTO `code` VALUES ('2518', '320400', '常州市', 'BM_DISTRICT', '320000');
INSERT INTO `code` VALUES ('2519', '320401', '市辖区', 'BM_DISTRICT', '320400');
INSERT INTO `code` VALUES ('2520', '320402', '天宁区', 'BM_DISTRICT', '320400');
INSERT INTO `code` VALUES ('2521', '320404', '钟楼区', 'BM_DISTRICT', '320400');
INSERT INTO `code` VALUES ('2522', '320405', '戚墅堰区', 'BM_DISTRICT', '320400');
INSERT INTO `code` VALUES ('2523', '320411', '新北区', 'BM_DISTRICT', '320400');
INSERT INTO `code` VALUES ('2524', '320412', '武进区', 'BM_DISTRICT', '320400');
INSERT INTO `code` VALUES ('2525', '320481', '溧阳市', 'BM_DISTRICT', '320400');
INSERT INTO `code` VALUES ('2526', '320482', '金坛市', 'BM_DISTRICT', '320400');
INSERT INTO `code` VALUES ('2527', '320500', '苏州市', 'BM_DISTRICT', '320000');
INSERT INTO `code` VALUES ('2528', '320501', '市辖区', 'BM_DISTRICT', '320500');
INSERT INTO `code` VALUES ('2529', '320505', '虎丘区', 'BM_DISTRICT', '320500');
INSERT INTO `code` VALUES ('2530', '320506', '吴中区', 'BM_DISTRICT', '320500');
INSERT INTO `code` VALUES ('2531', '320507', '相城区', 'BM_DISTRICT', '320500');
INSERT INTO `code` VALUES ('2532', '320508', '姑苏区', 'BM_DISTRICT', '320500');
INSERT INTO `code` VALUES ('2533', '320509', '吴江区', 'BM_DISTRICT', '320500');
INSERT INTO `code` VALUES ('2534', '320581', '常熟市', 'BM_DISTRICT', '320500');
INSERT INTO `code` VALUES ('2535', '411525', '固始县', 'BM_DISTRICT', '411500');
INSERT INTO `code` VALUES ('2536', '411526', '潢川县', 'BM_DISTRICT', '411500');
INSERT INTO `code` VALUES ('2537', '411527', '淮滨县', 'BM_DISTRICT', '411500');
INSERT INTO `code` VALUES ('2538', '411528', '息县', 'BM_DISTRICT', '411500');
INSERT INTO `code` VALUES ('2539', '411600', '周口市', 'BM_DISTRICT', '410000');
INSERT INTO `code` VALUES ('2540', '411601', '市辖区', 'BM_DISTRICT', '411600');
INSERT INTO `code` VALUES ('2541', '411602', '川汇区', 'BM_DISTRICT', '411600');
INSERT INTO `code` VALUES ('2542', '411621', '扶沟县', 'BM_DISTRICT', '411600');
INSERT INTO `code` VALUES ('2543', '411622', '西华县', 'BM_DISTRICT', '411600');
INSERT INTO `code` VALUES ('2544', '411623', '商水县', 'BM_DISTRICT', '411600');
INSERT INTO `code` VALUES ('2545', '411624', '沈丘县', 'BM_DISTRICT', '411600');
INSERT INTO `code` VALUES ('2546', '411625', '郸城县', 'BM_DISTRICT', '411600');
INSERT INTO `code` VALUES ('2547', '411626', '淮阳县', 'BM_DISTRICT', '411600');
INSERT INTO `code` VALUES ('2548', '411627', '太康县', 'BM_DISTRICT', '411600');
INSERT INTO `code` VALUES ('2549', '411628', '鹿邑县', 'BM_DISTRICT', '411600');
INSERT INTO `code` VALUES ('2550', '411681', '项城市', 'BM_DISTRICT', '411600');
INSERT INTO `code` VALUES ('2551', '411700', '驻马店市', 'BM_DISTRICT', '410000');
INSERT INTO `code` VALUES ('2552', '411701', '市辖区', 'BM_DISTRICT', '411700');
INSERT INTO `code` VALUES ('2553', '411702', '驿城区', 'BM_DISTRICT', '411700');
INSERT INTO `code` VALUES ('2554', '411721', '西平县', 'BM_DISTRICT', '411700');
INSERT INTO `code` VALUES ('2555', '411722', '上蔡县', 'BM_DISTRICT', '411700');
INSERT INTO `code` VALUES ('2556', '110229', '延庆县', 'BM_DISTRICT', '110200');
INSERT INTO `code` VALUES ('2557', '120000', '天津市', 'BM_DISTRICT', null);
INSERT INTO `code` VALUES ('2558', '120100', '市辖区', 'BM_DISTRICT', '120000');
INSERT INTO `code` VALUES ('2559', '120101', '和平区', 'BM_DISTRICT', '120100');
INSERT INTO `code` VALUES ('2560', '120102', '河东区', 'BM_DISTRICT', '120100');
INSERT INTO `code` VALUES ('2561', '120103', '河西区', 'BM_DISTRICT', '120100');
INSERT INTO `code` VALUES ('2562', '120104', '南开区', 'BM_DISTRICT', '120100');
INSERT INTO `code` VALUES ('2563', '120105', '河北区', 'BM_DISTRICT', '120100');
INSERT INTO `code` VALUES ('2564', '120106', '红桥区', 'BM_DISTRICT', '120100');
INSERT INTO `code` VALUES ('2565', '451100', '贺州市', 'BM_DISTRICT', '450000');
INSERT INTO `code` VALUES ('2566', '451101', '市辖区', 'BM_DISTRICT', '451100');
INSERT INTO `code` VALUES ('2567', '451102', '八步区', 'BM_DISTRICT', '451100');
INSERT INTO `code` VALUES ('2568', '451121', '昭平县', 'BM_DISTRICT', '451100');
INSERT INTO `code` VALUES ('2569', '451122', '钟山县', 'BM_DISTRICT', '451100');
INSERT INTO `code` VALUES ('2570', '451123', '富川瑶族自治县', 'BM_DISTRICT', '451100');
INSERT INTO `code` VALUES ('2571', '451200', '河池市', 'BM_DISTRICT', '450000');
INSERT INTO `code` VALUES ('2572', '451201', '市辖区', 'BM_DISTRICT', '451200');
INSERT INTO `code` VALUES ('2573', '451202', '金城江区', 'BM_DISTRICT', '451200');
INSERT INTO `code` VALUES ('2574', '451221', '南丹县', 'BM_DISTRICT', '451200');
INSERT INTO `code` VALUES ('2575', '451000', '百色市', 'BM_DISTRICT', '450000');
INSERT INTO `code` VALUES ('2576', '451001', '市辖区', 'BM_DISTRICT', '451000');
INSERT INTO `code` VALUES ('2577', '451002', '右江区', 'BM_DISTRICT', '451000');
INSERT INTO `code` VALUES ('2578', '451021', '田阳县', 'BM_DISTRICT', '451000');
INSERT INTO `code` VALUES ('2579', '451022', '田东县', 'BM_DISTRICT', '451000');
INSERT INTO `code` VALUES ('2580', '451023', '平果县', 'BM_DISTRICT', '451000');
INSERT INTO `code` VALUES ('2581', '451024', '德保县', 'BM_DISTRICT', '451000');
INSERT INTO `code` VALUES ('2582', '451025', '靖西县', 'BM_DISTRICT', '451000');
INSERT INTO `code` VALUES ('2583', '451026', '那坡县', 'BM_DISTRICT', '451000');
INSERT INTO `code` VALUES ('2584', '451027', '凌云县', 'BM_DISTRICT', '451000');
INSERT INTO `code` VALUES ('2585', '451028', '乐业县', 'BM_DISTRICT', '451000');
INSERT INTO `code` VALUES ('2586', '451029', '田林县', 'BM_DISTRICT', '451000');
INSERT INTO `code` VALUES ('2587', '451030', '西林县', 'BM_DISTRICT', '451000');
INSERT INTO `code` VALUES ('2588', '451031', '隆林各族自治县', 'BM_DISTRICT', '451000');
INSERT INTO `code` VALUES ('2589', '130427', '磁县', 'BM_DISTRICT', '130400');
INSERT INTO `code` VALUES ('2590', '130428', '肥乡县', 'BM_DISTRICT', '130400');
INSERT INTO `code` VALUES ('2591', '130429', '永年县', 'BM_DISTRICT', '130400');
INSERT INTO `code` VALUES ('2592', '130430', '邱县', 'BM_DISTRICT', '130400');
INSERT INTO `code` VALUES ('2593', '130431', '鸡泽县', 'BM_DISTRICT', '130400');
INSERT INTO `code` VALUES ('2594', '130432', '广平县', 'BM_DISTRICT', '130400');
INSERT INTO `code` VALUES ('2595', '130433', '馆陶县', 'BM_DISTRICT', '130400');
INSERT INTO `code` VALUES ('2596', '130434', '魏县', 'BM_DISTRICT', '130400');
INSERT INTO `code` VALUES ('2597', '130435', '曲周县', 'BM_DISTRICT', '130400');
INSERT INTO `code` VALUES ('2598', '130481', '武安市', 'BM_DISTRICT', '130400');
INSERT INTO `code` VALUES ('2599', '130500', '邢台市', 'BM_DISTRICT', '130000');
INSERT INTO `code` VALUES ('2600', '130501', '市辖区', 'BM_DISTRICT', '130500');
INSERT INTO `code` VALUES ('2601', '411723', '平舆县', 'BM_DISTRICT', '411700');
INSERT INTO `code` VALUES ('2602', '411724', '正阳县', 'BM_DISTRICT', '411700');
INSERT INTO `code` VALUES ('2603', '411725', '确山县', 'BM_DISTRICT', '411700');
INSERT INTO `code` VALUES ('2604', '411726', '泌阳县', 'BM_DISTRICT', '411700');
INSERT INTO `code` VALUES ('2605', '411727', '汝南县', 'BM_DISTRICT', '411700');
INSERT INTO `code` VALUES ('2606', '411728', '遂平县', 'BM_DISTRICT', '411700');
INSERT INTO `code` VALUES ('2607', '411729', '新蔡县', 'BM_DISTRICT', '411700');
INSERT INTO `code` VALUES ('2608', '419000', '省直辖县级行政区划', 'BM_DISTRICT', '410000');
INSERT INTO `code` VALUES ('2609', '419001', '济源市', 'BM_DISTRICT', '419000');
INSERT INTO `code` VALUES ('2610', '430502', '双清区', 'BM_DISTRICT', '430500');
INSERT INTO `code` VALUES ('2611', '430503', '大祥区', 'BM_DISTRICT', '430500');
INSERT INTO `code` VALUES ('2612', '430511', '北塔区', 'BM_DISTRICT', '430500');
INSERT INTO `code` VALUES ('2613', '371401', '市辖区', 'BM_DISTRICT', '371400');
INSERT INTO `code` VALUES ('2614', '371402', '德城区', 'BM_DISTRICT', '371400');
INSERT INTO `code` VALUES ('2615', '371421', '陵县', 'BM_DISTRICT', '371400');
INSERT INTO `code` VALUES ('2616', '371422', '宁津县', 'BM_DISTRICT', '371400');
INSERT INTO `code` VALUES ('2617', '371423', '庆云县', 'BM_DISTRICT', '371400');
INSERT INTO `code` VALUES ('2618', '371424', '临邑县', 'BM_DISTRICT', '371400');
INSERT INTO `code` VALUES ('2619', '371425', '齐河县', 'BM_DISTRICT', '371400');
INSERT INTO `code` VALUES ('2620', '371426', '平原县', 'BM_DISTRICT', '371400');
INSERT INTO `code` VALUES ('2621', '371427', '夏津县', 'BM_DISTRICT', '371400');
INSERT INTO `code` VALUES ('2622', '371428', '武城县', 'BM_DISTRICT', '371400');
INSERT INTO `code` VALUES ('2623', '371481', '乐陵市', 'BM_DISTRICT', '371400');
INSERT INTO `code` VALUES ('2624', '371482', '禹城市', 'BM_DISTRICT', '371400');
INSERT INTO `code` VALUES ('2625', '371500', '聊城市', 'BM_DISTRICT', '370000');
INSERT INTO `code` VALUES ('2626', '371501', '市辖区', 'BM_DISTRICT', '371500');
INSERT INTO `code` VALUES ('2627', '371502', '东昌府区', 'BM_DISTRICT', '371500');
INSERT INTO `code` VALUES ('2628', '371521', '阳谷县', 'BM_DISTRICT', '371500');
INSERT INTO `code` VALUES ('2629', '371522', '莘县', 'BM_DISTRICT', '371500');
INSERT INTO `code` VALUES ('2630', '371523', '茌平县', 'BM_DISTRICT', '371500');
INSERT INTO `code` VALUES ('2631', '371524', '东阿县', 'BM_DISTRICT', '371500');
INSERT INTO `code` VALUES ('2632', '371525', '冠县', 'BM_DISTRICT', '371500');
INSERT INTO `code` VALUES ('2633', '371526', '高唐县', 'BM_DISTRICT', '371500');
INSERT INTO `code` VALUES ('2634', '371581', '临清市', 'BM_DISTRICT', '371500');
INSERT INTO `code` VALUES ('2635', '371600', '滨州市', 'BM_DISTRICT', '370000');
INSERT INTO `code` VALUES ('2636', '371601', '市辖区', 'BM_DISTRICT', '371600');
INSERT INTO `code` VALUES ('2637', '371602', '滨城区', 'BM_DISTRICT', '371600');
INSERT INTO `code` VALUES ('2638', '371621', '惠民县', 'BM_DISTRICT', '371600');
INSERT INTO `code` VALUES ('2639', '371622', '阳信县', 'BM_DISTRICT', '371600');
INSERT INTO `code` VALUES ('2640', '371623', '无棣县', 'BM_DISTRICT', '371600');
INSERT INTO `code` VALUES ('2641', '371624', '沾化县', 'BM_DISTRICT', '371600');
INSERT INTO `code` VALUES ('2642', '230603', '龙凤区', 'BM_DISTRICT', '230600');
INSERT INTO `code` VALUES ('2643', '230604', '让胡路区', 'BM_DISTRICT', '230600');
INSERT INTO `code` VALUES ('2644', '230605', '红岗区', 'BM_DISTRICT', '230600');
INSERT INTO `code` VALUES ('2645', '230606', '大同区', 'BM_DISTRICT', '230600');
INSERT INTO `code` VALUES ('2646', '230621', '肇州县', 'BM_DISTRICT', '230600');
INSERT INTO `code` VALUES ('2647', '230622', '肇源县', 'BM_DISTRICT', '230600');
INSERT INTO `code` VALUES ('2648', '230623', '林甸县', 'BM_DISTRICT', '230600');
INSERT INTO `code` VALUES ('2649', '230624', '杜尔伯特蒙古族自治县', 'BM_DISTRICT', '230600');
INSERT INTO `code` VALUES ('2650', '230700', '伊春市', 'BM_DISTRICT', '230000');
INSERT INTO `code` VALUES ('2651', '410201', '市辖区', 'BM_DISTRICT', '410200');
INSERT INTO `code` VALUES ('2652', '410202', '龙亭区', 'BM_DISTRICT', '410200');
INSERT INTO `code` VALUES ('2653', '410203', '顺河回族区', 'BM_DISTRICT', '410200');
INSERT INTO `code` VALUES ('2654', '410204', '鼓楼区', 'BM_DISTRICT', '410200');
INSERT INTO `code` VALUES ('2655', '451222', '天峨县', 'BM_DISTRICT', '451200');
INSERT INTO `code` VALUES ('2656', '451223', '凤山县', 'BM_DISTRICT', '451200');
INSERT INTO `code` VALUES ('2657', '451224', '东兰县', 'BM_DISTRICT', '451200');
INSERT INTO `code` VALUES ('2658', '451225', '罗城仫佬族自治县', 'BM_DISTRICT', '451200');
INSERT INTO `code` VALUES ('2659', '451226', '环江毛南族自治县', 'BM_DISTRICT', '451200');
INSERT INTO `code` VALUES ('2660', '451227', '巴马瑶族自治县', 'BM_DISTRICT', '451200');
INSERT INTO `code` VALUES ('2661', '451228', '都安瑶族自治县', 'BM_DISTRICT', '451200');
INSERT INTO `code` VALUES ('2662', '451229', '大化瑶族自治县', 'BM_DISTRICT', '451200');
INSERT INTO `code` VALUES ('2663', '451281', '宜州市', 'BM_DISTRICT', '451200');
INSERT INTO `code` VALUES ('2664', '451300', '来宾市', 'BM_DISTRICT', '450000');
INSERT INTO `code` VALUES ('2665', '451301', '市辖区', 'BM_DISTRICT', '451300');
INSERT INTO `code` VALUES ('2666', '451302', '兴宾区', 'BM_DISTRICT', '451300');
INSERT INTO `code` VALUES ('2667', '451321', '忻城县', 'BM_DISTRICT', '451300');
INSERT INTO `code` VALUES ('2668', '451322', '象州县', 'BM_DISTRICT', '451300');
INSERT INTO `code` VALUES ('2669', '451323', '武宣县', 'BM_DISTRICT', '451300');
INSERT INTO `code` VALUES ('2670', '451324', '金秀瑶族自治县', 'BM_DISTRICT', '451300');
INSERT INTO `code` VALUES ('2671', '451381', '合山市', 'BM_DISTRICT', '451300');
INSERT INTO `code` VALUES ('2672', '130533', '威县', 'BM_DISTRICT', '130500');
INSERT INTO `code` VALUES ('2673', '130534', '清河县', 'BM_DISTRICT', '130500');
INSERT INTO `code` VALUES ('2674', '130535', '临西县', 'BM_DISTRICT', '130500');
INSERT INTO `code` VALUES ('2675', '130581', '南宫市', 'BM_DISTRICT', '130500');
INSERT INTO `code` VALUES ('2676', '130531', '广宗县', 'BM_DISTRICT', '130500');
INSERT INTO `code` VALUES ('2677', '130532', '平乡县', 'BM_DISTRICT', '130500');
INSERT INTO `code` VALUES ('2678', '130582', '沙河市', 'BM_DISTRICT', '130500');
INSERT INTO `code` VALUES ('2679', '130600', '保定市', 'BM_DISTRICT', '130000');
INSERT INTO `code` VALUES ('2680', '130601', '市辖区', 'BM_DISTRICT', '130600');
INSERT INTO `code` VALUES ('2681', '130602', '新市区', 'BM_DISTRICT', '130600');
INSERT INTO `code` VALUES ('2682', '130603', '北市区', 'BM_DISTRICT', '130600');
INSERT INTO `code` VALUES ('2683', '130604', '南市区', 'BM_DISTRICT', '130600');
INSERT INTO `code` VALUES ('2684', '130621', '满城县', 'BM_DISTRICT', '130600');
INSERT INTO `code` VALUES ('2685', '120110', '东丽区', 'BM_DISTRICT', '120100');
INSERT INTO `code` VALUES ('2686', '120111', '西青区', 'BM_DISTRICT', '120100');
INSERT INTO `code` VALUES ('2687', '120112', '津南区', 'BM_DISTRICT', '120100');
INSERT INTO `code` VALUES ('2688', '120113', '北辰区', 'BM_DISTRICT', '120100');
INSERT INTO `code` VALUES ('2689', '120114', '武清区', 'BM_DISTRICT', '120100');
INSERT INTO `code` VALUES ('2690', '120115', '宝坻区', 'BM_DISTRICT', '120100');
INSERT INTO `code` VALUES ('2691', '120116', '滨海新区', 'BM_DISTRICT', '120100');
INSERT INTO `code` VALUES ('2692', '120200', '县', 'BM_DISTRICT', '120000');
INSERT INTO `code` VALUES ('2693', '120221', '宁河县', 'BM_DISTRICT', '120200');
INSERT INTO `code` VALUES ('2694', '120223', '静海县', 'BM_DISTRICT', '120200');
INSERT INTO `code` VALUES ('2695', '120225', '蓟县', 'BM_DISTRICT', '120200');
INSERT INTO `code` VALUES ('2696', '430521', '邵东县', 'BM_DISTRICT', '430500');
INSERT INTO `code` VALUES ('2697', '430522', '新邵县', 'BM_DISTRICT', '430500');
INSERT INTO `code` VALUES ('2698', '430523', '邵阳县', 'BM_DISTRICT', '430500');
INSERT INTO `code` VALUES ('2699', '430524', '隆回县', 'BM_DISTRICT', '430500');
INSERT INTO `code` VALUES ('2700', '430525', '洞口县', 'BM_DISTRICT', '430500');
INSERT INTO `code` VALUES ('2701', '430527', '绥宁县', 'BM_DISTRICT', '430500');
INSERT INTO `code` VALUES ('2702', '430528', '新宁县', 'BM_DISTRICT', '430500');
INSERT INTO `code` VALUES ('2703', '430529', '城步苗族自治县', 'BM_DISTRICT', '430500');
INSERT INTO `code` VALUES ('2704', '430581', '武冈市', 'BM_DISTRICT', '430500');
INSERT INTO `code` VALUES ('2705', '430600', '岳阳市', 'BM_DISTRICT', '430000');
INSERT INTO `code` VALUES ('2706', '430601', '市辖区', 'BM_DISTRICT', '430600');
INSERT INTO `code` VALUES ('2707', '430602', '岳阳楼区', 'BM_DISTRICT', '430600');
INSERT INTO `code` VALUES ('2708', '430603', '云溪区', 'BM_DISTRICT', '430600');
INSERT INTO `code` VALUES ('2709', '430611', '君山区', 'BM_DISTRICT', '430600');
INSERT INTO `code` VALUES ('2710', '430621', '岳阳县', 'BM_DISTRICT', '430600');
INSERT INTO `code` VALUES ('2711', '430623', '华容县', 'BM_DISTRICT', '430600');
INSERT INTO `code` VALUES ('2712', '430624', '湘阴县', 'BM_DISTRICT', '430600');
INSERT INTO `code` VALUES ('2713', '430626', '平江县', 'BM_DISTRICT', '430600');
INSERT INTO `code` VALUES ('2714', '430681', '汨罗市', 'BM_DISTRICT', '430600');
INSERT INTO `code` VALUES ('2715', '430682', '临湘市', 'BM_DISTRICT', '430600');
INSERT INTO `code` VALUES ('2716', '430700', '常德市', 'BM_DISTRICT', '430000');
INSERT INTO `code` VALUES ('2717', '430701', '市辖区', 'BM_DISTRICT', '430700');
INSERT INTO `code` VALUES ('2718', '430702', '武陵区', 'BM_DISTRICT', '430700');
INSERT INTO `code` VALUES ('2719', '430703', '鼎城区', 'BM_DISTRICT', '430700');
INSERT INTO `code` VALUES ('2720', '430721', '安乡县', 'BM_DISTRICT', '430700');
INSERT INTO `code` VALUES ('2721', '430722', '汉寿县', 'BM_DISTRICT', '430700');
INSERT INTO `code` VALUES ('2722', '430723', '澧县', 'BM_DISTRICT', '430700');
INSERT INTO `code` VALUES ('2723', '210403', '东洲区', 'BM_DISTRICT', '210400');
INSERT INTO `code` VALUES ('2724', '210404', '望花区', 'BM_DISTRICT', '210400');
INSERT INTO `code` VALUES ('2725', '210411', '顺城区', 'BM_DISTRICT', '210400');
INSERT INTO `code` VALUES ('2726', '420000', '湖北省', 'BM_DISTRICT', null);
INSERT INTO `code` VALUES ('2727', '420100', '武汉市', 'BM_DISTRICT', '420000');
INSERT INTO `code` VALUES ('2728', '420101', '市辖区', 'BM_DISTRICT', '420100');
INSERT INTO `code` VALUES ('2729', '410205', '禹王台区', 'BM_DISTRICT', '410200');
INSERT INTO `code` VALUES ('2730', '410211', '金明区', 'BM_DISTRICT', '410200');
INSERT INTO `code` VALUES ('2731', '410221', '杞县', 'BM_DISTRICT', '410200');
INSERT INTO `code` VALUES ('2732', '410222', '通许县', 'BM_DISTRICT', '410200');
INSERT INTO `code` VALUES ('2733', '410223', '尉氏县', 'BM_DISTRICT', '410200');
INSERT INTO `code` VALUES ('2734', '410224', '开封县', 'BM_DISTRICT', '410200');
INSERT INTO `code` VALUES ('2735', '410225', '兰考县', 'BM_DISTRICT', '410200');
INSERT INTO `code` VALUES ('2736', '410300', '洛阳市', 'BM_DISTRICT', '410000');
INSERT INTO `code` VALUES ('2737', '410301', '市辖区', 'BM_DISTRICT', '410300');
INSERT INTO `code` VALUES ('2738', '410302', '老城区', 'BM_DISTRICT', '410300');
INSERT INTO `code` VALUES ('2739', '410303', '西工区', 'BM_DISTRICT', '410300');
INSERT INTO `code` VALUES ('2740', '410304', '瀍河回族区', 'BM_DISTRICT', '410300');
INSERT INTO `code` VALUES ('2741', '410305', '涧西区', 'BM_DISTRICT', '410300');
INSERT INTO `code` VALUES ('2742', '410306', '吉利区', 'BM_DISTRICT', '410300');
INSERT INTO `code` VALUES ('2743', '410311', '洛龙区', 'BM_DISTRICT', '410300');
INSERT INTO `code` VALUES ('2744', '410322', '孟津县', 'BM_DISTRICT', '410300');
INSERT INTO `code` VALUES ('2745', '410323', '新安县', 'BM_DISTRICT', '410300');
INSERT INTO `code` VALUES ('2746', '410324', '栾川县', 'BM_DISTRICT', '410300');
INSERT INTO `code` VALUES ('2747', '410325', '嵩县', 'BM_DISTRICT', '410300');
INSERT INTO `code` VALUES ('2748', '410326', '汝阳县', 'BM_DISTRICT', '410300');
INSERT INTO `code` VALUES ('2749', '410327', '宜阳县', 'BM_DISTRICT', '410300');
INSERT INTO `code` VALUES ('2750', '410328', '洛宁县', 'BM_DISTRICT', '410300');
INSERT INTO `code` VALUES ('2751', '410329', '伊川县', 'BM_DISTRICT', '410300');
INSERT INTO `code` VALUES ('2752', '410381', '偃师市', 'BM_DISTRICT', '410300');
INSERT INTO `code` VALUES ('2753', '410400', '平顶山市', 'BM_DISTRICT', '410000');
INSERT INTO `code` VALUES ('2754', '410401', '市辖区', 'BM_DISTRICT', '410400');
INSERT INTO `code` VALUES ('2755', '231101', '市辖区', 'BM_DISTRICT', '231100');
INSERT INTO `code` VALUES ('2756', '231102', '爱辉区', 'BM_DISTRICT', '231100');
INSERT INTO `code` VALUES ('2757', '231121', '嫩江县', 'BM_DISTRICT', '231100');
INSERT INTO `code` VALUES ('2758', '231123', '逊克县', 'BM_DISTRICT', '231100');
INSERT INTO `code` VALUES ('2759', '231124', '孙吴县', 'BM_DISTRICT', '231100');
INSERT INTO `code` VALUES ('2760', '231181', '北安市', 'BM_DISTRICT', '231100');
INSERT INTO `code` VALUES ('2761', '231182', '五大连池市', 'BM_DISTRICT', '231100');
INSERT INTO `code` VALUES ('2762', '231200', '绥化市', 'BM_DISTRICT', '230000');
INSERT INTO `code` VALUES ('2763', '231201', '市辖区', 'BM_DISTRICT', '231200');
INSERT INTO `code` VALUES ('2764', '231202', '北林区', 'BM_DISTRICT', '231200');
INSERT INTO `code` VALUES ('2765', '320724', '灌南县', 'BM_DISTRICT', '320700');
INSERT INTO `code` VALUES ('2766', '320800', '淮安市', 'BM_DISTRICT', '320000');
INSERT INTO `code` VALUES ('2767', '320801', '市辖区', 'BM_DISTRICT', '320800');
INSERT INTO `code` VALUES ('2768', '320802', '清河区', 'BM_DISTRICT', '320800');
INSERT INTO `code` VALUES ('2769', '130000', '河北省', 'BM_DISTRICT', null);
INSERT INTO `code` VALUES ('2770', '130100', '石家庄市', 'BM_DISTRICT', '130000');
INSERT INTO `code` VALUES ('2771', '130101', '市辖区', 'BM_DISTRICT', '130100');
INSERT INTO `code` VALUES ('2772', '130102', '长安区', 'BM_DISTRICT', '130100');
INSERT INTO `code` VALUES ('2773', '130103', '桥东区', 'BM_DISTRICT', '130100');
INSERT INTO `code` VALUES ('2774', '130104', '桥西区', 'BM_DISTRICT', '130100');
INSERT INTO `code` VALUES ('2775', '130105', '新华区', 'BM_DISTRICT', '130100');
INSERT INTO `code` VALUES ('2776', '130107', '井陉矿区', 'BM_DISTRICT', '130100');
INSERT INTO `code` VALUES ('2777', '130108', '裕华区', 'BM_DISTRICT', '130100');
INSERT INTO `code` VALUES ('2778', '110000', '北京市', 'BM_DISTRICT', null);
INSERT INTO `code` VALUES ('2779', '110100', '市辖区', 'BM_DISTRICT', '110000');
INSERT INTO `code` VALUES ('2780', '210902', '海州区', 'BM_DISTRICT', '210900');
INSERT INTO `code` VALUES ('2781', '210903', '新邱区', 'BM_DISTRICT', '210900');
INSERT INTO `code` VALUES ('2782', '210904', '太平区', 'BM_DISTRICT', '210900');
INSERT INTO `code` VALUES ('2783', '210905', '清河门区', 'BM_DISTRICT', '210900');
INSERT INTO `code` VALUES ('2784', '210911', '细河区', 'BM_DISTRICT', '210900');
INSERT INTO `code` VALUES ('2785', '210921', '阜新蒙古族自治县', 'BM_DISTRICT', '210900');
INSERT INTO `code` VALUES ('2786', '210922', '彰武县', 'BM_DISTRICT', '210900');
INSERT INTO `code` VALUES ('2787', '211000', '辽阳市', 'BM_DISTRICT', '210000');
INSERT INTO `code` VALUES ('2788', '211001', '市辖区', 'BM_DISTRICT', '211000');
INSERT INTO `code` VALUES ('2789', '211002', '白塔区', 'BM_DISTRICT', '211000');
INSERT INTO `code` VALUES ('2790', '211003', '文圣区', 'BM_DISTRICT', '211000');
INSERT INTO `code` VALUES ('2791', '211004', '宏伟区', 'BM_DISTRICT', '211000');
INSERT INTO `code` VALUES ('2792', '211005', '弓长岭区', 'BM_DISTRICT', '211000');
INSERT INTO `code` VALUES ('2793', '211011', '太子河区', 'BM_DISTRICT', '211000');
INSERT INTO `code` VALUES ('2794', '211021', '辽阳县', 'BM_DISTRICT', '211000');
INSERT INTO `code` VALUES ('2795', '211081', '灯塔市', 'BM_DISTRICT', '211000');
INSERT INTO `code` VALUES ('2796', '211100', '盘锦市', 'BM_DISTRICT', '210000');
INSERT INTO `code` VALUES ('2797', '211101', '市辖区', 'BM_DISTRICT', '211100');
INSERT INTO `code` VALUES ('2798', '130622', '清苑县', 'BM_DISTRICT', '130600');
INSERT INTO `code` VALUES ('2799', '130623', '涞水县', 'BM_DISTRICT', '130600');
INSERT INTO `code` VALUES ('2800', '130624', '阜平县', 'BM_DISTRICT', '130600');
INSERT INTO `code` VALUES ('2801', '130625', '徐水县', 'BM_DISTRICT', '130600');
INSERT INTO `code` VALUES ('2802', '130626', '定兴县', 'BM_DISTRICT', '130600');
INSERT INTO `code` VALUES ('2803', '130627', '唐县', 'BM_DISTRICT', '130600');
INSERT INTO `code` VALUES ('2804', '130628', '高阳县', 'BM_DISTRICT', '130600');
INSERT INTO `code` VALUES ('2805', '130629', '容城县', 'BM_DISTRICT', '130600');
INSERT INTO `code` VALUES ('2806', '130630', '涞源县', 'BM_DISTRICT', '130600');
INSERT INTO `code` VALUES ('2807', '130631', '望都县', 'BM_DISTRICT', '130600');
INSERT INTO `code` VALUES ('2808', '130632', '安新县', 'BM_DISTRICT', '130600');
INSERT INTO `code` VALUES ('2809', '420102', '江岸区', 'BM_DISTRICT', '420100');
INSERT INTO `code` VALUES ('2810', '420103', '江汉区', 'BM_DISTRICT', '420100');
INSERT INTO `code` VALUES ('2811', '420104', '硚口区', 'BM_DISTRICT', '420100');
INSERT INTO `code` VALUES ('2812', '420105', '汉阳区', 'BM_DISTRICT', '420100');
INSERT INTO `code` VALUES ('2813', '420106', '武昌区', 'BM_DISTRICT', '420100');
INSERT INTO `code` VALUES ('2814', '420107', '青山区', 'BM_DISTRICT', '420100');
INSERT INTO `code` VALUES ('2815', '420111', '洪山区', 'BM_DISTRICT', '420100');
INSERT INTO `code` VALUES ('2816', '420112', '东西湖区', 'BM_DISTRICT', '420100');
INSERT INTO `code` VALUES ('2817', '420113', '汉南区', 'BM_DISTRICT', '420100');
INSERT INTO `code` VALUES ('2818', '420114', '蔡甸区', 'BM_DISTRICT', '420100');
INSERT INTO `code` VALUES ('2819', '420115', '江夏区', 'BM_DISTRICT', '420100');
INSERT INTO `code` VALUES ('2820', '420116', '黄陂区', 'BM_DISTRICT', '420100');
INSERT INTO `code` VALUES ('2821', '420117', '新洲区', 'BM_DISTRICT', '420100');
INSERT INTO `code` VALUES ('2822', '420200', '黄石市', 'BM_DISTRICT', '420000');
INSERT INTO `code` VALUES ('2823', '420201', '市辖区', 'BM_DISTRICT', '420200');
INSERT INTO `code` VALUES ('2824', '420202', '黄石港区', 'BM_DISTRICT', '420200');
INSERT INTO `code` VALUES ('2825', '420203', '西塞山区', 'BM_DISTRICT', '420200');
INSERT INTO `code` VALUES ('2826', '420204', '下陆区', 'BM_DISTRICT', '420200');
INSERT INTO `code` VALUES ('2827', '420205', '铁山区', 'BM_DISTRICT', '420200');
INSERT INTO `code` VALUES ('2828', '420222', '阳新县', 'BM_DISTRICT', '420200');
INSERT INTO `code` VALUES ('2829', '420281', '大冶市', 'BM_DISTRICT', '420200');
INSERT INTO `code` VALUES ('2830', '420300', '十堰市', 'BM_DISTRICT', '420000');
INSERT INTO `code` VALUES ('2831', '420301', '市辖区', 'BM_DISTRICT', '420300');
INSERT INTO `code` VALUES ('2832', '420302', '茅箭区', 'BM_DISTRICT', '420300');
INSERT INTO `code` VALUES ('2833', '420303', '张湾区', 'BM_DISTRICT', '420300');
INSERT INTO `code` VALUES ('2834', '420321', '郧县', 'BM_DISTRICT', '420300');
INSERT INTO `code` VALUES ('2835', '211102', '双台子区', 'BM_DISTRICT', '211100');
INSERT INTO `code` VALUES ('2836', '211103', '兴隆台区', 'BM_DISTRICT', '211100');
INSERT INTO `code` VALUES ('2837', '211121', '大洼县', 'BM_DISTRICT', '211100');
INSERT INTO `code` VALUES ('2838', '211122', '盘山县', 'BM_DISTRICT', '211100');
INSERT INTO `code` VALUES ('2839', '211200', '铁岭市', 'BM_DISTRICT', '210000');
INSERT INTO `code` VALUES ('2840', '211201', '市辖区', 'BM_DISTRICT', '211200');
INSERT INTO `code` VALUES ('2841', '211202', '银州区', 'BM_DISTRICT', '211200');
INSERT INTO `code` VALUES ('2842', '211204', '清河区', 'BM_DISTRICT', '211200');
INSERT INTO `code` VALUES ('2843', '211221', '铁岭县', 'BM_DISTRICT', '211200');
INSERT INTO `code` VALUES ('2844', '211223', '西丰县', 'BM_DISTRICT', '211200');
INSERT INTO `code` VALUES ('2845', '210421', '抚顺县', 'BM_DISTRICT', '210400');
INSERT INTO `code` VALUES ('2846', '210422', '新宾满族自治县', 'BM_DISTRICT', '210400');
INSERT INTO `code` VALUES ('2847', '210423', '清原满族自治县', 'BM_DISTRICT', '210400');
INSERT INTO `code` VALUES ('2848', '320803', '淮安区', 'BM_DISTRICT', '320800');
INSERT INTO `code` VALUES ('2849', '320804', '淮阴区', 'BM_DISTRICT', '320800');
INSERT INTO `code` VALUES ('2850', '320811', '清浦区', 'BM_DISTRICT', '320800');
INSERT INTO `code` VALUES ('2851', '320826', '涟水县', 'BM_DISTRICT', '320800');
INSERT INTO `code` VALUES ('2852', '320829', '洪泽县', 'BM_DISTRICT', '320800');
INSERT INTO `code` VALUES ('2853', '320830', '盱眙县', 'BM_DISTRICT', '320800');
INSERT INTO `code` VALUES ('2854', '320831', '金湖县', 'BM_DISTRICT', '320800');
INSERT INTO `code` VALUES ('2855', '320900', '盐城市', 'BM_DISTRICT', '320000');
INSERT INTO `code` VALUES ('2856', '320901', '市辖区', 'BM_DISTRICT', '320900');
INSERT INTO `code` VALUES ('2857', '320902', '亭湖区', 'BM_DISTRICT', '320900');
INSERT INTO `code` VALUES ('2858', '320903', '盐都区', 'BM_DISTRICT', '320900');
INSERT INTO `code` VALUES ('2859', '320921', '响水县', 'BM_DISTRICT', '320900');
INSERT INTO `code` VALUES ('2860', '320922', '滨海县', 'BM_DISTRICT', '320900');
INSERT INTO `code` VALUES ('2861', '320923', '阜宁县', 'BM_DISTRICT', '320900');
INSERT INTO `code` VALUES ('2862', '320924', '射阳县', 'BM_DISTRICT', '320900');
INSERT INTO `code` VALUES ('2863', '320925', '建湖县', 'BM_DISTRICT', '320900');
INSERT INTO `code` VALUES ('2864', '320981', '东台市', 'BM_DISTRICT', '320900');
INSERT INTO `code` VALUES ('2865', '320982', '大丰市', 'BM_DISTRICT', '320900');
INSERT INTO `code` VALUES ('2866', '321000', '扬州市', 'BM_DISTRICT', '320000');
INSERT INTO `code` VALUES ('2867', '321001', '市辖区', 'BM_DISTRICT', '321000');
INSERT INTO `code` VALUES ('2868', '321002', '广陵区', 'BM_DISTRICT', '321000');
INSERT INTO `code` VALUES ('2869', '321003', '邗江区', 'BM_DISTRICT', '321000');
INSERT INTO `code` VALUES ('2870', '321012', '江都区', 'BM_DISTRICT', '321000');
INSERT INTO `code` VALUES ('2871', '321023', '宝应县', 'BM_DISTRICT', '321000');
INSERT INTO `code` VALUES ('2872', '321081', '仪征市', 'BM_DISTRICT', '321000');
INSERT INTO `code` VALUES ('2873', '321084', '高邮市', 'BM_DISTRICT', '321000');
INSERT INTO `code` VALUES ('2874', '321100', '镇江市', 'BM_DISTRICT', '320000');
INSERT INTO `code` VALUES ('2875', '321101', '市辖区', 'BM_DISTRICT', '321100');
INSERT INTO `code` VALUES ('2876', '321102', '京口区', 'BM_DISTRICT', '321100');
INSERT INTO `code` VALUES ('2877', '321111', '润州区', 'BM_DISTRICT', '321100');
INSERT INTO `code` VALUES ('2878', '321112', '丹徒区', 'BM_DISTRICT', '321100');
INSERT INTO `code` VALUES ('2879', '321181', '丹阳市', 'BM_DISTRICT', '321100');
INSERT INTO `code` VALUES ('2880', '321182', '扬中市', 'BM_DISTRICT', '321100');
INSERT INTO `code` VALUES ('2881', '321183', '句容市', 'BM_DISTRICT', '321100');
INSERT INTO `code` VALUES ('2882', '420322', '郧西县', 'BM_DISTRICT', '420300');
INSERT INTO `code` VALUES ('2883', '420323', '竹山县', 'BM_DISTRICT', '420300');
INSERT INTO `code` VALUES ('2884', '420324', '竹溪县', 'BM_DISTRICT', '420300');
INSERT INTO `code` VALUES ('2885', '420325', '房县', 'BM_DISTRICT', '420300');
INSERT INTO `code` VALUES ('2886', '420381', '丹江口市', 'BM_DISTRICT', '420300');
INSERT INTO `code` VALUES ('2887', '420500', '宜昌市', 'BM_DISTRICT', '420000');
INSERT INTO `code` VALUES ('2888', '420501', '市辖区', 'BM_DISTRICT', '420500');
INSERT INTO `code` VALUES ('2889', '420502', '西陵区', 'BM_DISTRICT', '420500');
INSERT INTO `code` VALUES ('2890', '420503', '伍家岗区', 'BM_DISTRICT', '420500');
INSERT INTO `code` VALUES ('2891', '420504', '点军区', 'BM_DISTRICT', '420500');
INSERT INTO `code` VALUES ('2892', '420505', '猇亭区', 'BM_DISTRICT', '420500');
INSERT INTO `code` VALUES ('2893', '420506', '夷陵区', 'BM_DISTRICT', '420500');
INSERT INTO `code` VALUES ('2894', '420525', '远安县', 'BM_DISTRICT', '420500');
INSERT INTO `code` VALUES ('2895', '420526', '兴山县', 'BM_DISTRICT', '420500');
INSERT INTO `code` VALUES ('2896', '420527', '秭归县', 'BM_DISTRICT', '420500');
INSERT INTO `code` VALUES ('2897', '420528', '长阳土家族自治县', 'BM_DISTRICT', '420500');
INSERT INTO `code` VALUES ('2898', '420529', '五峰土家族自治县', 'BM_DISTRICT', '420500');
INSERT INTO `code` VALUES ('2899', '420581', '宜都市', 'BM_DISTRICT', '420500');
INSERT INTO `code` VALUES ('2900', '420582', '当阳市', 'BM_DISTRICT', '420500');
INSERT INTO `code` VALUES ('2901', '420583', '枝江市', 'BM_DISTRICT', '420500');
INSERT INTO `code` VALUES ('2902', '420600', '襄阳市', 'BM_DISTRICT', '420000');
INSERT INTO `code` VALUES ('2903', '230701', '市辖区', 'BM_DISTRICT', '230700');
INSERT INTO `code` VALUES ('2904', '230702', '伊春区', 'BM_DISTRICT', '230700');
INSERT INTO `code` VALUES ('2905', '230703', '南岔区', 'BM_DISTRICT', '230700');
INSERT INTO `code` VALUES ('2906', '230704', '友好区', 'BM_DISTRICT', '230700');
INSERT INTO `code` VALUES ('2907', '130633', '易县', 'BM_DISTRICT', '130600');
INSERT INTO `code` VALUES ('2908', '130634', '曲阳县', 'BM_DISTRICT', '130600');
INSERT INTO `code` VALUES ('2909', '130635', '蠡县', 'BM_DISTRICT', '130600');
INSERT INTO `code` VALUES ('2910', '130636', '顺平县', 'BM_DISTRICT', '130600');
INSERT INTO `code` VALUES ('2911', '130637', '博野县', 'BM_DISTRICT', '130600');
INSERT INTO `code` VALUES ('2912', '130638', '雄县', 'BM_DISTRICT', '130600');
INSERT INTO `code` VALUES ('2913', '130681', '涿州市', 'BM_DISTRICT', '130600');
INSERT INTO `code` VALUES ('2914', '130682', '定州市', 'BM_DISTRICT', '130600');
INSERT INTO `code` VALUES ('2915', '130683', '安国市', 'BM_DISTRICT', '130600');
INSERT INTO `code` VALUES ('2916', '130684', '高碑店市', 'BM_DISTRICT', '130600');
INSERT INTO `code` VALUES ('2917', '130700', '张家口市', 'BM_DISTRICT', '130000');
INSERT INTO `code` VALUES ('2918', '130701', '市辖区', 'BM_DISTRICT', '130700');
INSERT INTO `code` VALUES ('2919', '130702', '桥东区', 'BM_DISTRICT', '130700');
INSERT INTO `code` VALUES ('2920', '130703', '桥西区', 'BM_DISTRICT', '130700');
INSERT INTO `code` VALUES ('2921', '130705', '宣化区', 'BM_DISTRICT', '130700');
INSERT INTO `code` VALUES ('2922', '130706', '下花园区', 'BM_DISTRICT', '130700');
INSERT INTO `code` VALUES ('2923', '130721', '宣化县', 'BM_DISTRICT', '130700');
INSERT INTO `code` VALUES ('2924', '130722', '张北县', 'BM_DISTRICT', '130700');
INSERT INTO `code` VALUES ('2925', '130723', '康保县', 'BM_DISTRICT', '130700');
INSERT INTO `code` VALUES ('2926', '330411', '秀洲区', 'BM_DISTRICT', '330400');
INSERT INTO `code` VALUES ('2927', '330421', '嘉善县', 'BM_DISTRICT', '330400');
INSERT INTO `code` VALUES ('2928', '330424', '海盐县', 'BM_DISTRICT', '330400');
INSERT INTO `code` VALUES ('2929', '330481', '海宁市', 'BM_DISTRICT', '330400');
INSERT INTO `code` VALUES ('2930', '330482', '平湖市', 'BM_DISTRICT', '330400');
INSERT INTO `code` VALUES ('2931', '330483', '桐乡市', 'BM_DISTRICT', '330400');
INSERT INTO `code` VALUES ('2932', '330500', '湖州市', 'BM_DISTRICT', '330000');
INSERT INTO `code` VALUES ('2933', '330501', '市辖区', 'BM_DISTRICT', '330500');
INSERT INTO `code` VALUES ('2934', '330502', '吴兴区', 'BM_DISTRICT', '330500');
INSERT INTO `code` VALUES ('2935', '330503', '南浔区', 'BM_DISTRICT', '330500');
INSERT INTO `code` VALUES ('2936', '330521', '德清县', 'BM_DISTRICT', '330500');
INSERT INTO `code` VALUES ('2937', '330522', '长兴县', 'BM_DISTRICT', '330500');
INSERT INTO `code` VALUES ('2938', '330523', '安吉县', 'BM_DISTRICT', '330500');
INSERT INTO `code` VALUES ('2939', '330600', '绍兴市', 'BM_DISTRICT', '330000');
INSERT INTO `code` VALUES ('2940', '330601', '市辖区', 'BM_DISTRICT', '330600');
INSERT INTO `code` VALUES ('2941', '330602', '越城区', 'BM_DISTRICT', '330600');
INSERT INTO `code` VALUES ('2942', '330621', '绍兴县', 'BM_DISTRICT', '330600');
INSERT INTO `code` VALUES ('2943', '330624', '新昌县', 'BM_DISTRICT', '330600');
INSERT INTO `code` VALUES ('2944', '330681', '诸暨市', 'BM_DISTRICT', '330600');
INSERT INTO `code` VALUES ('2945', '330682', '上虞市', 'BM_DISTRICT', '330600');
INSERT INTO `code` VALUES ('2946', '330683', '嵊州市', 'BM_DISTRICT', '330600');
INSERT INTO `code` VALUES ('2947', '330700', '金华市', 'BM_DISTRICT', '330000');
INSERT INTO `code` VALUES ('2948', '330701', '市辖区', 'BM_DISTRICT', '330700');
INSERT INTO `code` VALUES ('2949', '330702', '婺城区', 'BM_DISTRICT', '330700');
INSERT INTO `code` VALUES ('2950', '330703', '金东区', 'BM_DISTRICT', '330700');
INSERT INTO `code` VALUES ('2951', '330723', '武义县', 'BM_DISTRICT', '330700');
INSERT INTO `code` VALUES ('2952', '330726', '浦江县', 'BM_DISTRICT', '330700');
INSERT INTO `code` VALUES ('2953', '330727', '磐安县', 'BM_DISTRICT', '330700');
INSERT INTO `code` VALUES ('2954', '330781', '兰溪市', 'BM_DISTRICT', '330700');
INSERT INTO `code` VALUES ('2955', '210500', '本溪市', 'BM_DISTRICT', '210000');
INSERT INTO `code` VALUES ('2956', '210501', '市辖区', 'BM_DISTRICT', '210500');
INSERT INTO `code` VALUES ('2957', '210502', '平山区', 'BM_DISTRICT', '210500');
INSERT INTO `code` VALUES ('2958', '210503', '溪湖区', 'BM_DISTRICT', '210500');
INSERT INTO `code` VALUES ('2959', '210504', '明山区', 'BM_DISTRICT', '210500');
INSERT INTO `code` VALUES ('2960', '210505', '南芬区', 'BM_DISTRICT', '210500');
INSERT INTO `code` VALUES ('2961', '210521', '本溪满族自治县', 'BM_DISTRICT', '210500');
INSERT INTO `code` VALUES ('2962', '210522', '桓仁满族自治县', 'BM_DISTRICT', '210500');
INSERT INTO `code` VALUES ('2963', '210600', '丹东市', 'BM_DISTRICT', '210000');
INSERT INTO `code` VALUES ('2964', '210601', '市辖区', 'BM_DISTRICT', '210600');
INSERT INTO `code` VALUES ('2965', '210602', '元宝区', 'BM_DISTRICT', '210600');
INSERT INTO `code` VALUES ('2966', '210603', '振兴区', 'BM_DISTRICT', '210600');
INSERT INTO `code` VALUES ('2967', '210604', '振安区', 'BM_DISTRICT', '210600');
INSERT INTO `code` VALUES ('2968', '210624', '宽甸满族自治县', 'BM_DISTRICT', '210600');
INSERT INTO `code` VALUES ('2969', '210681', '东港市', 'BM_DISTRICT', '210600');
INSERT INTO `code` VALUES ('2970', '210682', '凤城市', 'BM_DISTRICT', '210600');
INSERT INTO `code` VALUES ('2971', '210700', '锦州市', 'BM_DISTRICT', '210000');
INSERT INTO `code` VALUES ('2972', '210701', '市辖区', 'BM_DISTRICT', '210700');
INSERT INTO `code` VALUES ('2973', '210702', '古塔区', 'BM_DISTRICT', '210700');
INSERT INTO `code` VALUES ('2974', '210703', '凌河区', 'BM_DISTRICT', '210700');
INSERT INTO `code` VALUES ('2975', '210711', '太和区', 'BM_DISTRICT', '210700');
INSERT INTO `code` VALUES ('2976', '210726', '黑山县', 'BM_DISTRICT', '210700');
INSERT INTO `code` VALUES ('2977', '210727', '义县', 'BM_DISTRICT', '210700');
INSERT INTO `code` VALUES ('2978', '210781', '凌海市', 'BM_DISTRICT', '210700');
INSERT INTO `code` VALUES ('2979', '210782', '北镇市', 'BM_DISTRICT', '210700');
INSERT INTO `code` VALUES ('2980', '210800', '营口市', 'BM_DISTRICT', '210000');
INSERT INTO `code` VALUES ('2981', '210801', '市辖区', 'BM_DISTRICT', '210800');
INSERT INTO `code` VALUES ('2982', '210802', '站前区', 'BM_DISTRICT', '210800');
INSERT INTO `code` VALUES ('2983', '210803', '西市区', 'BM_DISTRICT', '210800');
INSERT INTO `code` VALUES ('2984', '210804', '鲅鱼圈区', 'BM_DISTRICT', '210800');
INSERT INTO `code` VALUES ('2985', '210811', '老边区', 'BM_DISTRICT', '210800');
INSERT INTO `code` VALUES ('2986', '210881', '盖州市', 'BM_DISTRICT', '210800');
INSERT INTO `code` VALUES ('2987', '210882', '大石桥市', 'BM_DISTRICT', '210800');
INSERT INTO `code` VALUES ('2988', '210900', '阜新市', 'BM_DISTRICT', '210000');
INSERT INTO `code` VALUES ('2989', '210901', '市辖区', 'BM_DISTRICT', '210900');
INSERT INTO `code` VALUES ('2990', '361028', '资溪县', 'BM_DISTRICT', '361000');
INSERT INTO `code` VALUES ('2991', '361029', '东乡县', 'BM_DISTRICT', '361000');
INSERT INTO `code` VALUES ('2992', '361030', '广昌县', 'BM_DISTRICT', '361000');
INSERT INTO `code` VALUES ('2993', '361100', '上饶市', 'BM_DISTRICT', '360000');
INSERT INTO `code` VALUES ('2994', '361101', '市辖区', 'BM_DISTRICT', '361100');
INSERT INTO `code` VALUES ('2995', '361102', '信州区', 'BM_DISTRICT', '361100');
INSERT INTO `code` VALUES ('2996', '361121', '上饶县', 'BM_DISTRICT', '361100');
INSERT INTO `code` VALUES ('2997', '361122', '广丰县', 'BM_DISTRICT', '361100');
INSERT INTO `code` VALUES ('2998', '361123', '玉山县', 'BM_DISTRICT', '361100');
INSERT INTO `code` VALUES ('2999', '361124', '铅山县', 'BM_DISTRICT', '361100');
INSERT INTO `code` VALUES ('3000', '361125', '横峰县', 'BM_DISTRICT', '361100');
INSERT INTO `code` VALUES ('3001', '361126', '弋阳县', 'BM_DISTRICT', '361100');
INSERT INTO `code` VALUES ('3002', '361127', '余干县', 'BM_DISTRICT', '361100');
INSERT INTO `code` VALUES ('3003', '361128', '鄱阳县', 'BM_DISTRICT', '361100');
INSERT INTO `code` VALUES ('3004', '361129', '万年县', 'BM_DISTRICT', '361100');
INSERT INTO `code` VALUES ('3005', '361130', '婺源县', 'BM_DISTRICT', '361100');
INSERT INTO `code` VALUES ('3006', '361181', '德兴市', 'BM_DISTRICT', '361100');
INSERT INTO `code` VALUES ('3007', '370000', '山东省', 'BM_DISTRICT', null);
INSERT INTO `code` VALUES ('3008', '220323', '伊通满族自治县', 'BM_DISTRICT', '220300');
INSERT INTO `code` VALUES ('3009', '220381', '公主岭市', 'BM_DISTRICT', '220300');
INSERT INTO `code` VALUES ('3010', '220382', '双辽市', 'BM_DISTRICT', '220300');
INSERT INTO `code` VALUES ('3011', '211224', '昌图县', 'BM_DISTRICT', '211200');
INSERT INTO `code` VALUES ('3012', '211281', '调兵山市', 'BM_DISTRICT', '211200');
INSERT INTO `code` VALUES ('3013', '211282', '开原市', 'BM_DISTRICT', '211200');
INSERT INTO `code` VALUES ('3014', '230705', '西林区', 'BM_DISTRICT', '230700');
INSERT INTO `code` VALUES ('3015', '230706', '翠峦区', 'BM_DISTRICT', '230700');
INSERT INTO `code` VALUES ('3016', '230707', '新青区', 'BM_DISTRICT', '230700');
INSERT INTO `code` VALUES ('3017', '230708', '美溪区', 'BM_DISTRICT', '230700');
INSERT INTO `code` VALUES ('3018', '230709', '金山屯区', 'BM_DISTRICT', '230700');
INSERT INTO `code` VALUES ('3019', '230710', '五营区', 'BM_DISTRICT', '230700');
INSERT INTO `code` VALUES ('3020', '230711', '乌马河区', 'BM_DISTRICT', '230700');
INSERT INTO `code` VALUES ('3021', '230712', '汤旺河区', 'BM_DISTRICT', '230700');
INSERT INTO `code` VALUES ('3022', '230713', '带岭区', 'BM_DISTRICT', '230700');
INSERT INTO `code` VALUES ('3023', '230714', '乌伊岭区', 'BM_DISTRICT', '230700');
INSERT INTO `code` VALUES ('3024', '230715', '红星区', 'BM_DISTRICT', '230700');
INSERT INTO `code` VALUES ('3025', '230716', '上甘岭区', 'BM_DISTRICT', '230700');
INSERT INTO `code` VALUES ('3026', '230722', '嘉荫县', 'BM_DISTRICT', '230700');
INSERT INTO `code` VALUES ('3027', '230781', '铁力市', 'BM_DISTRICT', '230700');
INSERT INTO `code` VALUES ('3028', '230800', '佳木斯市', 'BM_DISTRICT', '230000');
INSERT INTO `code` VALUES ('3029', '230801', '市辖区', 'BM_DISTRICT', '230800');
INSERT INTO `code` VALUES ('3030', '230803', '向阳区', 'BM_DISTRICT', '230800');
INSERT INTO `code` VALUES ('3031', '230804', '前进区', 'BM_DISTRICT', '230800');
INSERT INTO `code` VALUES ('3032', '230805', '东风区', 'BM_DISTRICT', '230800');
INSERT INTO `code` VALUES ('3033', '230811', '郊区', 'BM_DISTRICT', '230800');
INSERT INTO `code` VALUES ('3034', '230822', '桦南县', 'BM_DISTRICT', '230800');
INSERT INTO `code` VALUES ('3035', '230826', '桦川县', 'BM_DISTRICT', '230800');
INSERT INTO `code` VALUES ('3036', '230828', '汤原县', 'BM_DISTRICT', '230800');
INSERT INTO `code` VALUES ('3037', '230833', '抚远县', 'BM_DISTRICT', '230800');
INSERT INTO `code` VALUES ('3038', '410402', '新华区', 'BM_DISTRICT', '410400');
INSERT INTO `code` VALUES ('3039', '410403', '卫东区', 'BM_DISTRICT', '410400');
INSERT INTO `code` VALUES ('3040', '410404', '石龙区', 'BM_DISTRICT', '410400');
INSERT INTO `code` VALUES ('3041', '410411', '湛河区', 'BM_DISTRICT', '410400');
INSERT INTO `code` VALUES ('3042', '410421', '宝丰县', 'BM_DISTRICT', '410400');
INSERT INTO `code` VALUES ('3043', '410422', '叶县', 'BM_DISTRICT', '410400');
INSERT INTO `code` VALUES ('3044', '410423', '鲁山县', 'BM_DISTRICT', '410400');
INSERT INTO `code` VALUES ('3045', '410425', '郏县', 'BM_DISTRICT', '410400');
INSERT INTO `code` VALUES ('3046', '410481', '舞钢市', 'BM_DISTRICT', '410400');
INSERT INTO `code` VALUES ('3047', '410482', '汝州市', 'BM_DISTRICT', '410400');
INSERT INTO `code` VALUES ('3048', '410500', '安阳市', 'BM_DISTRICT', '410000');
INSERT INTO `code` VALUES ('3049', '410501', '市辖区', 'BM_DISTRICT', '410500');
INSERT INTO `code` VALUES ('3050', '410502', '文峰区', 'BM_DISTRICT', '410500');
INSERT INTO `code` VALUES ('3051', '410503', '北关区', 'BM_DISTRICT', '410500');
INSERT INTO `code` VALUES ('3052', '410505', '殷都区', 'BM_DISTRICT', '410500');
INSERT INTO `code` VALUES ('3053', '410506', '龙安区', 'BM_DISTRICT', '410500');
INSERT INTO `code` VALUES ('3054', '410522', '安阳县', 'BM_DISTRICT', '410500');
INSERT INTO `code` VALUES ('3055', '410523', '汤阴县', 'BM_DISTRICT', '410500');
INSERT INTO `code` VALUES ('3056', '410526', '滑县', 'BM_DISTRICT', '410500');
INSERT INTO `code` VALUES ('3057', '410527', '内黄县', 'BM_DISTRICT', '410500');
INSERT INTO `code` VALUES ('3058', '410581', '林州市', 'BM_DISTRICT', '410500');
INSERT INTO `code` VALUES ('3059', '410600', '鹤壁市', 'BM_DISTRICT', '410000');
INSERT INTO `code` VALUES ('3060', '231221', '望奎县', 'BM_DISTRICT', '231200');
INSERT INTO `code` VALUES ('3061', '231222', '兰西县', 'BM_DISTRICT', '231200');
INSERT INTO `code` VALUES ('3062', '231223', '青冈县', 'BM_DISTRICT', '231200');
INSERT INTO `code` VALUES ('3063', '231224', '庆安县', 'BM_DISTRICT', '231200');
INSERT INTO `code` VALUES ('3064', '222401', '延吉市', 'BM_DISTRICT', '222400');
INSERT INTO `code` VALUES ('3065', '222402', '图们市', 'BM_DISTRICT', '222400');
INSERT INTO `code` VALUES ('3066', '222403', '敦化市', 'BM_DISTRICT', '222400');
INSERT INTO `code` VALUES ('3067', '222404', '珲春市', 'BM_DISTRICT', '222400');
INSERT INTO `code` VALUES ('3068', '222405', '龙井市', 'BM_DISTRICT', '222400');
INSERT INTO `code` VALUES ('3069', '222406', '和龙市', 'BM_DISTRICT', '222400');
INSERT INTO `code` VALUES ('3070', '222424', '汪清县', 'BM_DISTRICT', '222400');
INSERT INTO `code` VALUES ('3071', '222426', '安图县', 'BM_DISTRICT', '222400');
INSERT INTO `code` VALUES ('3072', '230000', '黑龙江省', 'BM_DISTRICT', null);
INSERT INTO `code` VALUES ('3073', '230100', '哈尔滨市', 'BM_DISTRICT', '230000');
INSERT INTO `code` VALUES ('3074', '230101', '市辖区', 'BM_DISTRICT', '230100');
INSERT INTO `code` VALUES ('3075', '230102', '道里区', 'BM_DISTRICT', '230100');
INSERT INTO `code` VALUES ('3076', '230103', '南岗区', 'BM_DISTRICT', '230100');
INSERT INTO `code` VALUES ('3077', '230104', '道外区', 'BM_DISTRICT', '230100');
INSERT INTO `code` VALUES ('3078', '230108', '平房区', 'BM_DISTRICT', '230100');
INSERT INTO `code` VALUES ('3079', '230109', '松北区', 'BM_DISTRICT', '230100');
INSERT INTO `code` VALUES ('3080', '230110', '香坊区', 'BM_DISTRICT', '230100');
INSERT INTO `code` VALUES ('3081', '230111', '呼兰区', 'BM_DISTRICT', '230100');
INSERT INTO `code` VALUES ('3082', '230112', '阿城区', 'BM_DISTRICT', '230100');
INSERT INTO `code` VALUES ('3083', '450803', '港南区', 'BM_DISTRICT', '450800');
INSERT INTO `code` VALUES ('3084', '450804', '覃塘区', 'BM_DISTRICT', '450800');
INSERT INTO `code` VALUES ('3085', '450821', '平南县', 'BM_DISTRICT', '450800');
INSERT INTO `code` VALUES ('3086', '450881', '桂平市', 'BM_DISTRICT', '450800');
INSERT INTO `code` VALUES ('3087', '450900', '玉林市', 'BM_DISTRICT', '450000');
INSERT INTO `code` VALUES ('3088', '450901', '市辖区', 'BM_DISTRICT', '450900');
INSERT INTO `code` VALUES ('3089', '450902', '玉州区', 'BM_DISTRICT', '450900');
INSERT INTO `code` VALUES ('3090', '450921', '容县', 'BM_DISTRICT', '450900');
INSERT INTO `code` VALUES ('3091', '450922', '陆川县', 'BM_DISTRICT', '450900');
INSERT INTO `code` VALUES ('3092', '211300', '朝阳市', 'BM_DISTRICT', '210000');
INSERT INTO `code` VALUES ('3093', '211301', '市辖区', 'BM_DISTRICT', '211300');
INSERT INTO `code` VALUES ('3094', '211302', '双塔区', 'BM_DISTRICT', '211300');
INSERT INTO `code` VALUES ('3095', '211303', '龙城区', 'BM_DISTRICT', '211300');
INSERT INTO `code` VALUES ('3096', '211321', '朝阳县', 'BM_DISTRICT', '211300');
INSERT INTO `code` VALUES ('3097', '211322', '建平县', 'BM_DISTRICT', '211300');
INSERT INTO `code` VALUES ('3098', '211324', '喀喇沁左翼蒙古族自治县', 'BM_DISTRICT', '211300');
INSERT INTO `code` VALUES ('3099', '211381', '北票市', 'BM_DISTRICT', '211300');
INSERT INTO `code` VALUES ('3100', '211382', '凌源市', 'BM_DISTRICT', '211300');
INSERT INTO `code` VALUES ('3101', '211400', '葫芦岛市', 'BM_DISTRICT', '210000');
INSERT INTO `code` VALUES ('3102', '211401', '市辖区', 'BM_DISTRICT', '211400');
INSERT INTO `code` VALUES ('3103', '211402', '连山区', 'BM_DISTRICT', '211400');
INSERT INTO `code` VALUES ('3104', '211403', '龙港区', 'BM_DISTRICT', '211400');
INSERT INTO `code` VALUES ('3105', '211404', '南票区', 'BM_DISTRICT', '211400');
INSERT INTO `code` VALUES ('3106', '211421', '绥中县', 'BM_DISTRICT', '211400');
INSERT INTO `code` VALUES ('3107', '211422', '建昌县', 'BM_DISTRICT', '211400');
INSERT INTO `code` VALUES ('3108', '211481', '兴城市', 'BM_DISTRICT', '211400');
INSERT INTO `code` VALUES ('3109', '220000', '吉林省', 'BM_DISTRICT', null);
INSERT INTO `code` VALUES ('3110', '220100', '长春市', 'BM_DISTRICT', '220000');
INSERT INTO `code` VALUES ('3111', '220101', '市辖区', 'BM_DISTRICT', '220100');
INSERT INTO `code` VALUES ('3112', '220102', '南关区', 'BM_DISTRICT', '220100');
INSERT INTO `code` VALUES ('3113', '220103', '宽城区', 'BM_DISTRICT', '220100');
INSERT INTO `code` VALUES ('3114', '220104', '朝阳区', 'BM_DISTRICT', '220100');
INSERT INTO `code` VALUES ('3115', '220105', '二道区', 'BM_DISTRICT', '220100');
INSERT INTO `code` VALUES ('3116', '220106', '绿园区', 'BM_DISTRICT', '220100');
INSERT INTO `code` VALUES ('3117', '220112', '双阳区', 'BM_DISTRICT', '220100');
INSERT INTO `code` VALUES ('3118', '220122', '农安县', 'BM_DISTRICT', '220100');
INSERT INTO `code` VALUES ('3119', '220181', '九台市', 'BM_DISTRICT', '220100');
INSERT INTO `code` VALUES ('3120', '370405', '台儿庄区', 'BM_DISTRICT', '370400');
INSERT INTO `code` VALUES ('3121', '370406', '山亭区', 'BM_DISTRICT', '370400');
INSERT INTO `code` VALUES ('3122', '370481', '滕州市', 'BM_DISTRICT', '370400');
INSERT INTO `code` VALUES ('3123', '370500', '东营市', 'BM_DISTRICT', '370000');
INSERT INTO `code` VALUES ('3124', '370501', '市辖区', 'BM_DISTRICT', '370500');
INSERT INTO `code` VALUES ('3125', '370502', '东营区', 'BM_DISTRICT', '370500');
INSERT INTO `code` VALUES ('3126', '370503', '河口区', 'BM_DISTRICT', '370500');
INSERT INTO `code` VALUES ('3127', '370521', '垦利县', 'BM_DISTRICT', '370500');
INSERT INTO `code` VALUES ('3128', '370522', '利津县', 'BM_DISTRICT', '370500');
INSERT INTO `code` VALUES ('3129', '370523', '广饶县', 'BM_DISTRICT', '370500');
INSERT INTO `code` VALUES ('3130', '370600', '烟台市', 'BM_DISTRICT', '370000');
INSERT INTO `code` VALUES ('3131', '370601', '市辖区', 'BM_DISTRICT', '370600');
INSERT INTO `code` VALUES ('3132', '370602', '芝罘区', 'BM_DISTRICT', '370600');
INSERT INTO `code` VALUES ('3133', '370611', '福山区', 'BM_DISTRICT', '370600');
INSERT INTO `code` VALUES ('3134', '370612', '牟平区', 'BM_DISTRICT', '370600');
INSERT INTO `code` VALUES ('3135', '370613', '莱山区', 'BM_DISTRICT', '370600');
INSERT INTO `code` VALUES ('3136', '370634', '长岛县', 'BM_DISTRICT', '370600');
INSERT INTO `code` VALUES ('3137', '370681', '龙口市', 'BM_DISTRICT', '370600');
INSERT INTO `code` VALUES ('3138', '230123', '依兰县', 'BM_DISTRICT', '230100');
INSERT INTO `code` VALUES ('3139', '230124', '方正县', 'BM_DISTRICT', '230100');
INSERT INTO `code` VALUES ('3140', '230125', '宾县', 'BM_DISTRICT', '230100');
INSERT INTO `code` VALUES ('3141', '230126', '巴彦县', 'BM_DISTRICT', '230100');
INSERT INTO `code` VALUES ('3142', '230127', '木兰县', 'BM_DISTRICT', '230100');
INSERT INTO `code` VALUES ('3143', '230128', '通河县', 'BM_DISTRICT', '230100');
INSERT INTO `code` VALUES ('3144', '230129', '延寿县', 'BM_DISTRICT', '230100');
INSERT INTO `code` VALUES ('3145', '230182', '双城市', 'BM_DISTRICT', '230100');
INSERT INTO `code` VALUES ('3146', '230183', '尚志市', 'BM_DISTRICT', '230100');
INSERT INTO `code` VALUES ('3147', '230184', '五常市', 'BM_DISTRICT', '230100');
INSERT INTO `code` VALUES ('3148', '220400', '辽源市', 'BM_DISTRICT', '220000');
INSERT INTO `code` VALUES ('3149', '220401', '市辖区', 'BM_DISTRICT', '220400');
INSERT INTO `code` VALUES ('3150', '220402', '龙山区', 'BM_DISTRICT', '220400');
INSERT INTO `code` VALUES ('3151', '231225', '明水县', 'BM_DISTRICT', '231200');
INSERT INTO `code` VALUES ('3152', '231226', '绥棱县', 'BM_DISTRICT', '231200');
INSERT INTO `code` VALUES ('3153', '231281', '安达市', 'BM_DISTRICT', '231200');
INSERT INTO `code` VALUES ('3154', '231282', '肇东市', 'BM_DISTRICT', '231200');
INSERT INTO `code` VALUES ('3155', '231283', '海伦市', 'BM_DISTRICT', '231200');
INSERT INTO `code` VALUES ('3156', '232700', '大兴安岭地区', 'BM_DISTRICT', '230000');
INSERT INTO `code` VALUES ('3157', '232721', '呼玛县', 'BM_DISTRICT', '232700');
INSERT INTO `code` VALUES ('3158', '232722', '塔河县', 'BM_DISTRICT', '232700');
INSERT INTO `code` VALUES ('3159', '232723', '漠河县', 'BM_DISTRICT', '232700');
INSERT INTO `code` VALUES ('3160', '310000', '上海市', 'BM_DISTRICT', null);
INSERT INTO `code` VALUES ('3161', '310100', '市辖区', 'BM_DISTRICT', '310000');
INSERT INTO `code` VALUES ('3162', '310101', '黄浦区', 'BM_DISTRICT', '310100');
INSERT INTO `code` VALUES ('3163', '310104', '徐汇区', 'BM_DISTRICT', '310100');
INSERT INTO `code` VALUES ('3164', '310105', '长宁区', 'BM_DISTRICT', '310100');
INSERT INTO `code` VALUES ('3165', '310106', '静安区', 'BM_DISTRICT', '310100');
INSERT INTO `code` VALUES ('3166', '310107', '普陀区', 'BM_DISTRICT', '310100');
INSERT INTO `code` VALUES ('3167', '310108', '闸北区', 'BM_DISTRICT', '310100');
INSERT INTO `code` VALUES ('3168', '310109', '虹口区', 'BM_DISTRICT', '310100');
INSERT INTO `code` VALUES ('3169', '310110', '杨浦区', 'BM_DISTRICT', '310100');
INSERT INTO `code` VALUES ('3170', '310112', '闵行区', 'BM_DISTRICT', '310100');
INSERT INTO `code` VALUES ('3171', '310113', '宝山区', 'BM_DISTRICT', '310100');
INSERT INTO `code` VALUES ('3172', '310114', '嘉定区', 'BM_DISTRICT', '310100');
INSERT INTO `code` VALUES ('3173', '310115', '浦东新区', 'BM_DISTRICT', '310100');
INSERT INTO `code` VALUES ('3174', '310116', '金山区', 'BM_DISTRICT', '310100');
INSERT INTO `code` VALUES ('3175', '410927', '台前县', 'BM_DISTRICT', '410900');
INSERT INTO `code` VALUES ('3176', '410928', '濮阳县', 'BM_DISTRICT', '410900');
INSERT INTO `code` VALUES ('3177', '411000', '许昌市', 'BM_DISTRICT', '410000');
INSERT INTO `code` VALUES ('3178', '411001', '市辖区', 'BM_DISTRICT', '411000');
INSERT INTO `code` VALUES ('3179', '411002', '魏都区', 'BM_DISTRICT', '411000');
INSERT INTO `code` VALUES ('3180', '411023', '许昌县', 'BM_DISTRICT', '411000');
INSERT INTO `code` VALUES ('3181', '411024', '鄢陵县', 'BM_DISTRICT', '411000');
INSERT INTO `code` VALUES ('3182', '411025', '襄城县', 'BM_DISTRICT', '411000');
INSERT INTO `code` VALUES ('3183', '411081', '禹州市', 'BM_DISTRICT', '411000');
INSERT INTO `code` VALUES ('3184', '411082', '长葛市', 'BM_DISTRICT', '411000');
INSERT INTO `code` VALUES ('3185', '411100', '漯河市', 'BM_DISTRICT', '410000');
INSERT INTO `code` VALUES ('3186', '411101', '市辖区', 'BM_DISTRICT', '411100');
INSERT INTO `code` VALUES ('3187', '411102', '源汇区', 'BM_DISTRICT', '411100');
INSERT INTO `code` VALUES ('3188', '411103', '郾城区', 'BM_DISTRICT', '411100');
INSERT INTO `code` VALUES ('3189', '411104', '召陵区', 'BM_DISTRICT', '411100');
INSERT INTO `code` VALUES ('3190', '411121', '舞阳县', 'BM_DISTRICT', '411100');
INSERT INTO `code` VALUES ('3191', '411122', '临颍县', 'BM_DISTRICT', '411100');
INSERT INTO `code` VALUES ('3192', '411200', '三门峡市', 'BM_DISTRICT', '410000');
INSERT INTO `code` VALUES ('3193', '411201', '市辖区', 'BM_DISTRICT', '411200');
INSERT INTO `code` VALUES ('3194', '411202', '湖滨区', 'BM_DISTRICT', '411200');
INSERT INTO `code` VALUES ('3195', '411221', '渑池县', 'BM_DISTRICT', '411200');
INSERT INTO `code` VALUES ('3196', '420601', '市辖区', 'BM_DISTRICT', '420600');
INSERT INTO `code` VALUES ('3197', '420602', '襄城区', 'BM_DISTRICT', '420600');
INSERT INTO `code` VALUES ('3198', '420606', '樊城区', 'BM_DISTRICT', '420600');
INSERT INTO `code` VALUES ('3199', '420607', '襄州区', 'BM_DISTRICT', '420600');
INSERT INTO `code` VALUES ('3200', '220403', '西安区', 'BM_DISTRICT', '220400');
INSERT INTO `code` VALUES ('3201', '220421', '东丰县', 'BM_DISTRICT', '220400');
INSERT INTO `code` VALUES ('3202', '220422', '东辽县', 'BM_DISTRICT', '220400');
INSERT INTO `code` VALUES ('3203', '220500', '通化市', 'BM_DISTRICT', '220000');
INSERT INTO `code` VALUES ('3204', '220501', '市辖区', 'BM_DISTRICT', '220500');
INSERT INTO `code` VALUES ('3205', '220502', '东昌区', 'BM_DISTRICT', '220500');
INSERT INTO `code` VALUES ('3206', '220503', '二道江区', 'BM_DISTRICT', '220500');
INSERT INTO `code` VALUES ('3207', '220521', '通化县', 'BM_DISTRICT', '220500');
INSERT INTO `code` VALUES ('3208', '220523', '辉南县', 'BM_DISTRICT', '220500');
INSERT INTO `code` VALUES ('3209', '220524', '柳河县', 'BM_DISTRICT', '220500');
INSERT INTO `code` VALUES ('3210', '220581', '梅河口市', 'BM_DISTRICT', '220500');
INSERT INTO `code` VALUES ('3211', '220582', '集安市', 'BM_DISTRICT', '220500');
INSERT INTO `code` VALUES ('3212', '220600', '白山市', 'BM_DISTRICT', '220000');
INSERT INTO `code` VALUES ('3213', '220601', '市辖区', 'BM_DISTRICT', '220600');
INSERT INTO `code` VALUES ('3214', '220602', '浑江区', 'BM_DISTRICT', '220600');
INSERT INTO `code` VALUES ('3215', '220605', '江源区', 'BM_DISTRICT', '220600');
INSERT INTO `code` VALUES ('3216', '220621', '抚松县', 'BM_DISTRICT', '220600');
INSERT INTO `code` VALUES ('3217', '220622', '靖宇县', 'BM_DISTRICT', '220600');
INSERT INTO `code` VALUES ('3218', '220623', '长白朝鲜族自治县', 'BM_DISTRICT', '220600');
INSERT INTO `code` VALUES ('3219', '220681', '临江市', 'BM_DISTRICT', '220600');
INSERT INTO `code` VALUES ('3220', '220700', '松原市', 'BM_DISTRICT', '220000');
INSERT INTO `code` VALUES ('3221', '220701', '市辖区', 'BM_DISTRICT', '220700');
INSERT INTO `code` VALUES ('3222', '220702', '宁江区', 'BM_DISTRICT', '220700');
INSERT INTO `code` VALUES ('3223', '220721', '前郭尔罗斯蒙古族自治县', 'BM_DISTRICT', '220700');
INSERT INTO `code` VALUES ('3224', '220722', '长岭县', 'BM_DISTRICT', '220700');
INSERT INTO `code` VALUES ('3225', '220723', '乾安县', 'BM_DISTRICT', '220700');
INSERT INTO `code` VALUES ('3226', '220724', '扶余县', 'BM_DISTRICT', '220700');
INSERT INTO `code` VALUES ('3227', '220800', '白城市', 'BM_DISTRICT', '220000');
INSERT INTO `code` VALUES ('3228', '220801', '市辖区', 'BM_DISTRICT', '220800');
INSERT INTO `code` VALUES ('3229', '220802', '洮北区', 'BM_DISTRICT', '220800');
INSERT INTO `code` VALUES ('3230', '220821', '镇赉县', 'BM_DISTRICT', '220800');
INSERT INTO `code` VALUES ('3231', '220822', '通榆县', 'BM_DISTRICT', '220800');
INSERT INTO `code` VALUES ('3232', '220881', '洮南市', 'BM_DISTRICT', '220800');
INSERT INTO `code` VALUES ('3233', '220882', '大安市', 'BM_DISTRICT', '220800');
INSERT INTO `code` VALUES ('3234', '222400', '延边朝鲜族自治州', 'BM_DISTRICT', '220000');
INSERT INTO `code` VALUES ('3235', '371000', '威海市', 'BM_DISTRICT', '370000');
INSERT INTO `code` VALUES ('3236', '371001', '市辖区', 'BM_DISTRICT', '371000');
INSERT INTO `code` VALUES ('3237', '371002', '环翠区', 'BM_DISTRICT', '371000');
INSERT INTO `code` VALUES ('3238', '371081', '文登市', 'BM_DISTRICT', '371000');
INSERT INTO `code` VALUES ('3239', '371082', '荣成市', 'BM_DISTRICT', '371000');
INSERT INTO `code` VALUES ('3240', '371083', '乳山市', 'BM_DISTRICT', '371000');
INSERT INTO `code` VALUES ('3241', '371100', '日照市', 'BM_DISTRICT', '370000');
INSERT INTO `code` VALUES ('3242', '371101', '市辖区', 'BM_DISTRICT', '371100');
INSERT INTO `code` VALUES ('3243', '371102', '东港区', 'BM_DISTRICT', '371100');
INSERT INTO `code` VALUES ('3244', '371103', '岚山区', 'BM_DISTRICT', '371100');
INSERT INTO `code` VALUES ('3245', '371121', '五莲县', 'BM_DISTRICT', '371100');
INSERT INTO `code` VALUES ('3246', '371122', '莒县', 'BM_DISTRICT', '371100');
INSERT INTO `code` VALUES ('3247', '371200', '莱芜市', 'BM_DISTRICT', '370000');
INSERT INTO `code` VALUES ('3248', '371201', '市辖区', 'BM_DISTRICT', '371200');
INSERT INTO `code` VALUES ('3249', '371202', '莱城区', 'BM_DISTRICT', '371200');
INSERT INTO `code` VALUES ('3250', '371203', '钢城区', 'BM_DISTRICT', '371200');
INSERT INTO `code` VALUES ('3251', '371300', '临沂市', 'BM_DISTRICT', '370000');
INSERT INTO `code` VALUES ('3252', '371301', '市辖区', 'BM_DISTRICT', '371300');
INSERT INTO `code` VALUES ('3253', '130204', '古冶区', 'BM_DISTRICT', '130200');
INSERT INTO `code` VALUES ('3254', '130205', '开平区', 'BM_DISTRICT', '130200');
INSERT INTO `code` VALUES ('3255', '130207', '丰南区', 'BM_DISTRICT', '130200');
INSERT INTO `code` VALUES ('3256', '230200', '齐齐哈尔市', 'BM_DISTRICT', '230000');
INSERT INTO `code` VALUES ('3257', '230201', '市辖区', 'BM_DISTRICT', '230200');
INSERT INTO `code` VALUES ('3258', '230202', '龙沙区', 'BM_DISTRICT', '230200');
INSERT INTO `code` VALUES ('3259', '420624', '南漳县', 'BM_DISTRICT', '420600');
INSERT INTO `code` VALUES ('3260', '420625', '谷城县', 'BM_DISTRICT', '420600');
INSERT INTO `code` VALUES ('3261', '420626', '保康县', 'BM_DISTRICT', '420600');
INSERT INTO `code` VALUES ('3262', '420682', '老河口市', 'BM_DISTRICT', '420600');
INSERT INTO `code` VALUES ('3263', '420683', '枣阳市', 'BM_DISTRICT', '420600');
INSERT INTO `code` VALUES ('3264', '420684', '宜城市', 'BM_DISTRICT', '420600');
INSERT INTO `code` VALUES ('3265', '420700', '鄂州市', 'BM_DISTRICT', '420000');
INSERT INTO `code` VALUES ('3266', '420701', '市辖区', 'BM_DISTRICT', '420700');
INSERT INTO `code` VALUES ('3267', '420702', '梁子湖区', 'BM_DISTRICT', '420700');
INSERT INTO `code` VALUES ('3268', '420703', '华容区', 'BM_DISTRICT', '420700');
INSERT INTO `code` VALUES ('3269', '420704', '鄂城区', 'BM_DISTRICT', '420700');
INSERT INTO `code` VALUES ('3270', '420800', '荆门市', 'BM_DISTRICT', '420000');
INSERT INTO `code` VALUES ('3271', '420801', '市辖区', 'BM_DISTRICT', '420800');
INSERT INTO `code` VALUES ('3272', '420802', '东宝区', 'BM_DISTRICT', '420800');
INSERT INTO `code` VALUES ('3273', '420804', '掇刀区', 'BM_DISTRICT', '420800');
INSERT INTO `code` VALUES ('3274', '420821', '京山县', 'BM_DISTRICT', '420800');
INSERT INTO `code` VALUES ('3275', '420822', '沙洋县', 'BM_DISTRICT', '420800');
INSERT INTO `code` VALUES ('3276', '420881', '钟祥市', 'BM_DISTRICT', '420800');
INSERT INTO `code` VALUES ('3277', '420900', '孝感市', 'BM_DISTRICT', '420000');
INSERT INTO `code` VALUES ('3278', '420901', '市辖区', 'BM_DISTRICT', '420900');
INSERT INTO `code` VALUES ('3279', '420902', '孝南区', 'BM_DISTRICT', '420900');
INSERT INTO `code` VALUES ('3280', '420921', '孝昌县', 'BM_DISTRICT', '420900');
INSERT INTO `code` VALUES ('3281', '420922', '大悟县', 'BM_DISTRICT', '420900');
INSERT INTO `code` VALUES ('3282', '420923', '云梦县', 'BM_DISTRICT', '420900');
INSERT INTO `code` VALUES ('3283', '420981', '应城市', 'BM_DISTRICT', '420900');
INSERT INTO `code` VALUES ('3284', '420982', '安陆市', 'BM_DISTRICT', '420900');
INSERT INTO `code` VALUES ('3285', '420984', '汉川市', 'BM_DISTRICT', '420900');
INSERT INTO `code` VALUES ('3286', '421000', '荆州市', 'BM_DISTRICT', '420000');
INSERT INTO `code` VALUES ('3287', '421001', '市辖区', 'BM_DISTRICT', '421000');
INSERT INTO `code` VALUES ('3288', '421002', '沙市区', 'BM_DISTRICT', '421000');
INSERT INTO `code` VALUES ('3289', '421003', '荆州区', 'BM_DISTRICT', '421000');
INSERT INTO `code` VALUES ('3290', '421022', '公安县', 'BM_DISTRICT', '421000');
INSERT INTO `code` VALUES ('3291', '421023', '监利县', 'BM_DISTRICT', '421000');
INSERT INTO `code` VALUES ('3292', '421024', '江陵县', 'BM_DISTRICT', '421000');
INSERT INTO `code` VALUES ('3293', '230203', '建华区', 'BM_DISTRICT', '230200');
INSERT INTO `code` VALUES ('3294', '230204', '铁锋区', 'BM_DISTRICT', '230200');
INSERT INTO `code` VALUES ('3295', '230205', '昂昂溪区', 'BM_DISTRICT', '230200');
INSERT INTO `code` VALUES ('3296', '230206', '富拉尔基区', 'BM_DISTRICT', '230200');
INSERT INTO `code` VALUES ('3297', '230207', '碾子山区', 'BM_DISTRICT', '230200');
INSERT INTO `code` VALUES ('3298', '230208', '梅里斯达斡尔族区', 'BM_DISTRICT', '230200');
INSERT INTO `code` VALUES ('3299', '230221', '龙江县', 'BM_DISTRICT', '230200');
INSERT INTO `code` VALUES ('3300', '230223', '依安县', 'BM_DISTRICT', '230200');
INSERT INTO `code` VALUES ('3301', '230224', '泰来县', 'BM_DISTRICT', '230200');
INSERT INTO `code` VALUES ('3302', '230225', '甘南县', 'BM_DISTRICT', '230200');
INSERT INTO `code` VALUES ('3303', '230227', '富裕县', 'BM_DISTRICT', '230200');
INSERT INTO `code` VALUES ('3304', '230229', '克山县', 'BM_DISTRICT', '230200');
INSERT INTO `code` VALUES ('3305', '230230', '克东县', 'BM_DISTRICT', '230200');
INSERT INTO `code` VALUES ('3306', '230231', '拜泉县', 'BM_DISTRICT', '230200');
INSERT INTO `code` VALUES ('3307', '230281', '讷河市', 'BM_DISTRICT', '230200');
INSERT INTO `code` VALUES ('3308', '230300', '鸡西市', 'BM_DISTRICT', '230000');
INSERT INTO `code` VALUES ('3309', '230301', '市辖区', 'BM_DISTRICT', '230300');
INSERT INTO `code` VALUES ('3310', '230302', '鸡冠区', 'BM_DISTRICT', '230300');
INSERT INTO `code` VALUES ('3311', '230303', '恒山区', 'BM_DISTRICT', '230300');
INSERT INTO `code` VALUES ('3312', '230304', '滴道区', 'BM_DISTRICT', '230300');
INSERT INTO `code` VALUES ('3313', '230305', '梨树区', 'BM_DISTRICT', '230300');
INSERT INTO `code` VALUES ('3314', '230306', '城子河区', 'BM_DISTRICT', '230300');
INSERT INTO `code` VALUES ('3315', '230307', '麻山区', 'BM_DISTRICT', '230300');
INSERT INTO `code` VALUES ('3316', '230321', '鸡东县', 'BM_DISTRICT', '230300');
INSERT INTO `code` VALUES ('3317', '230381', '虎林市', 'BM_DISTRICT', '230300');
INSERT INTO `code` VALUES ('3318', '230382', '密山市', 'BM_DISTRICT', '230300');
INSERT INTO `code` VALUES ('3319', '230400', '鹤岗市', 'BM_DISTRICT', '230000');
INSERT INTO `code` VALUES ('3320', '371625', '博兴县', 'BM_DISTRICT', '371600');
INSERT INTO `code` VALUES ('3321', '371626', '邹平县', 'BM_DISTRICT', '371600');
INSERT INTO `code` VALUES ('3322', '371700', '菏泽市', 'BM_DISTRICT', '370000');
INSERT INTO `code` VALUES ('3323', '371701', '市辖区', 'BM_DISTRICT', '371700');
INSERT INTO `code` VALUES ('3324', '371702', '牡丹区', 'BM_DISTRICT', '371700');
INSERT INTO `code` VALUES ('3325', '371721', '曹县', 'BM_DISTRICT', '371700');
INSERT INTO `code` VALUES ('3326', '371722', '单县', 'BM_DISTRICT', '371700');
INSERT INTO `code` VALUES ('3327', '371723', '成武县', 'BM_DISTRICT', '371700');
INSERT INTO `code` VALUES ('3328', '371724', '巨野县', 'BM_DISTRICT', '371700');
INSERT INTO `code` VALUES ('3329', '371725', '郓城县', 'BM_DISTRICT', '371700');
INSERT INTO `code` VALUES ('3330', '371726', '鄄城县', 'BM_DISTRICT', '371700');
INSERT INTO `code` VALUES ('3331', '371727', '定陶县', 'BM_DISTRICT', '371700');
INSERT INTO `code` VALUES ('3332', '371728', '东明县', 'BM_DISTRICT', '371700');
INSERT INTO `code` VALUES ('3333', '410000', '河南省', 'BM_DISTRICT', null);
INSERT INTO `code` VALUES ('3334', '410100', '郑州市', 'BM_DISTRICT', '410000');
INSERT INTO `code` VALUES ('3335', '410101', '市辖区', 'BM_DISTRICT', '410100');
INSERT INTO `code` VALUES ('3336', '410102', '中原区', 'BM_DISTRICT', '410100');
INSERT INTO `code` VALUES ('3337', '410103', '二七区', 'BM_DISTRICT', '410100');
INSERT INTO `code` VALUES ('3338', '410104', '管城回族区', 'BM_DISTRICT', '410100');
INSERT INTO `code` VALUES ('3339', '130208', '丰润区', 'BM_DISTRICT', '130200');
INSERT INTO `code` VALUES ('3340', '130209', '曹妃甸区', 'BM_DISTRICT', '130200');
INSERT INTO `code` VALUES ('3341', '130223', '滦县', 'BM_DISTRICT', '130200');
INSERT INTO `code` VALUES ('3342', '310117', '松江区', 'BM_DISTRICT', '310100');
INSERT INTO `code` VALUES ('3343', '310118', '青浦区', 'BM_DISTRICT', '310100');
INSERT INTO `code` VALUES ('3344', '310120', '奉贤区', 'BM_DISTRICT', '310100');
INSERT INTO `code` VALUES ('3345', '310200', '县', 'BM_DISTRICT', '310000');
INSERT INTO `code` VALUES ('3346', '310230', '崇明县', 'BM_DISTRICT', '310200');
INSERT INTO `code` VALUES ('3347', '320000', '江苏省', 'BM_DISTRICT', null);
INSERT INTO `code` VALUES ('3348', '320100', '南京市', 'BM_DISTRICT', '320000');
INSERT INTO `code` VALUES ('3349', '320101', '市辖区', 'BM_DISTRICT', '320100');
INSERT INTO `code` VALUES ('3350', '320102', '玄武区', 'BM_DISTRICT', '320100');
INSERT INTO `code` VALUES ('3351', '320103', '白下区', 'BM_DISTRICT', '320100');
INSERT INTO `code` VALUES ('3352', '320104', '秦淮区', 'BM_DISTRICT', '320100');
INSERT INTO `code` VALUES ('3353', '320105', '建邺区', 'BM_DISTRICT', '320100');
INSERT INTO `code` VALUES ('3354', '320106', '鼓楼区', 'BM_DISTRICT', '320100');
INSERT INTO `code` VALUES ('3355', '320107', '下关区', 'BM_DISTRICT', '320100');
INSERT INTO `code` VALUES ('3356', '320111', '浦口区', 'BM_DISTRICT', '320100');
INSERT INTO `code` VALUES ('3357', '320113', '栖霞区', 'BM_DISTRICT', '320100');
INSERT INTO `code` VALUES ('3358', '320114', '雨花台区', 'BM_DISTRICT', '320100');
INSERT INTO `code` VALUES ('3359', '320115', '江宁区', 'BM_DISTRICT', '320100');
INSERT INTO `code` VALUES ('3360', '320116', '六合区', 'BM_DISTRICT', '320100');
INSERT INTO `code` VALUES ('3361', '320124', '溧水县', 'BM_DISTRICT', '320100');
INSERT INTO `code` VALUES ('3362', '320125', '高淳县', 'BM_DISTRICT', '320100');
INSERT INTO `code` VALUES ('3363', '130224', '滦南县', 'BM_DISTRICT', '130200');
INSERT INTO `code` VALUES ('3364', '130225', '乐亭县', 'BM_DISTRICT', '130200');
INSERT INTO `code` VALUES ('3365', '130227', '迁西县', 'BM_DISTRICT', '130200');
INSERT INTO `code` VALUES ('3366', '130229', '玉田县', 'BM_DISTRICT', '130200');
INSERT INTO `code` VALUES ('3367', '130281', '遵化市', 'BM_DISTRICT', '130200');
INSERT INTO `code` VALUES ('3368', '130283', '迁安市', 'BM_DISTRICT', '130200');
INSERT INTO `code` VALUES ('3369', '130300', '秦皇岛市', 'BM_DISTRICT', '130000');
INSERT INTO `code` VALUES ('3370', '130301', '市辖区', 'BM_DISTRICT', '130300');
INSERT INTO `code` VALUES ('3371', '130302', '海港区', 'BM_DISTRICT', '130300');
INSERT INTO `code` VALUES ('3372', '130303', '山海关区', 'BM_DISTRICT', '130300');
INSERT INTO `code` VALUES ('3373', '130304', '北戴河区', 'BM_DISTRICT', '130300');
INSERT INTO `code` VALUES ('3374', '130321', '青龙满族自治县', 'BM_DISTRICT', '130300');
INSERT INTO `code` VALUES ('3375', '130322', '昌黎县', 'BM_DISTRICT', '130300');
INSERT INTO `code` VALUES ('3376', '130323', '抚宁县', 'BM_DISTRICT', '130300');
INSERT INTO `code` VALUES ('3377', '130324', '卢龙县', 'BM_DISTRICT', '130300');
INSERT INTO `code` VALUES ('3378', '130400', '邯郸市', 'BM_DISTRICT', '130000');
INSERT INTO `code` VALUES ('3379', '130401', '市辖区', 'BM_DISTRICT', '130400');
INSERT INTO `code` VALUES ('3380', '130402', '邯山区', 'BM_DISTRICT', '130400');
INSERT INTO `code` VALUES ('3381', '130403', '丛台区', 'BM_DISTRICT', '130400');
INSERT INTO `code` VALUES ('3382', '130404', '复兴区', 'BM_DISTRICT', '130400');
INSERT INTO `code` VALUES ('3383', '130406', '峰峰矿区', 'BM_DISTRICT', '130400');
INSERT INTO `code` VALUES ('3384', '130421', '邯郸县', 'BM_DISTRICT', '130400');
INSERT INTO `code` VALUES ('3385', '130423', '临漳县', 'BM_DISTRICT', '130400');
INSERT INTO `code` VALUES ('3386', '130424', '成安县', 'BM_DISTRICT', '130400');
INSERT INTO `code` VALUES ('3387', '130425', '大名县', 'BM_DISTRICT', '130400');
INSERT INTO `code` VALUES ('3388', '130426', '涉县', 'BM_DISTRICT', '130400');
INSERT INTO `code` VALUES ('3389', '230401', '市辖区', 'BM_DISTRICT', '230400');
INSERT INTO `code` VALUES ('3390', '230402', '向阳区', 'BM_DISTRICT', '230400');
INSERT INTO `code` VALUES ('3391', '230403', '工农区', 'BM_DISTRICT', '230400');
INSERT INTO `code` VALUES ('3392', '230404', '南山区', 'BM_DISTRICT', '230400');
INSERT INTO `code` VALUES ('3393', '230405', '兴安区', 'BM_DISTRICT', '230400');
INSERT INTO `code` VALUES ('3394', '230406', '东山区', 'BM_DISTRICT', '230400');
INSERT INTO `code` VALUES ('3395', '230407', '兴山区', 'BM_DISTRICT', '230400');
INSERT INTO `code` VALUES ('3396', '230421', '萝北县', 'BM_DISTRICT', '230400');
INSERT INTO `code` VALUES ('3397', '230422', '绥滨县', 'BM_DISTRICT', '230400');
INSERT INTO `code` VALUES ('3398', '230500', '双鸭山市', 'BM_DISTRICT', '230000');
INSERT INTO `code` VALUES ('3399', '230501', '市辖区', 'BM_DISTRICT', '230500');
INSERT INTO `code` VALUES ('3400', '230502', '尖山区', 'BM_DISTRICT', '230500');
INSERT INTO `code` VALUES ('3401', '230503', '岭东区', 'BM_DISTRICT', '230500');
INSERT INTO `code` VALUES ('3402', '230505', '四方台区', 'BM_DISTRICT', '230500');
INSERT INTO `code` VALUES ('3403', '230506', '宝山区', 'BM_DISTRICT', '230500');
INSERT INTO `code` VALUES ('3404', '230521', '集贤县', 'BM_DISTRICT', '230500');
INSERT INTO `code` VALUES ('3405', '230522', '友谊县', 'BM_DISTRICT', '230500');
INSERT INTO `code` VALUES ('3406', '230523', '宝清县', 'BM_DISTRICT', '230500');
INSERT INTO `code` VALUES ('3407', '230524', '饶河县', 'BM_DISTRICT', '230500');
INSERT INTO `code` VALUES ('3408', '230600', '大庆市', 'BM_DISTRICT', '230000');
INSERT INTO `code` VALUES ('3409', '230601', '市辖区', 'BM_DISTRICT', '230600');
INSERT INTO `code` VALUES ('3410', '230602', '萨尔图区', 'BM_DISTRICT', '230600');
INSERT INTO `code` VALUES ('3411', '320582', '张家港市', 'BM_DISTRICT', '320500');
INSERT INTO `code` VALUES ('3412', '320583', '昆山市', 'BM_DISTRICT', '320500');
INSERT INTO `code` VALUES ('3413', '320585', '太仓市', 'BM_DISTRICT', '320500');
INSERT INTO `code` VALUES ('3414', '320600', '南通市', 'BM_DISTRICT', '320000');
INSERT INTO `code` VALUES ('3415', '320601', '市辖区', 'BM_DISTRICT', '320600');
INSERT INTO `code` VALUES ('3416', '320602', '崇川区', 'BM_DISTRICT', '320600');
INSERT INTO `code` VALUES ('3417', '320611', '港闸区', 'BM_DISTRICT', '320600');
INSERT INTO `code` VALUES ('3418', '320612', '通州区', 'BM_DISTRICT', '320600');
INSERT INTO `code` VALUES ('3419', '320621', '海安县', 'BM_DISTRICT', '320600');
INSERT INTO `code` VALUES ('3420', '320623', '如东县', 'BM_DISTRICT', '320600');
INSERT INTO `code` VALUES ('3421', '320681', '启东市', 'BM_DISTRICT', '320600');
INSERT INTO `code` VALUES ('3422', '320682', '如皋市', 'BM_DISTRICT', '320600');
INSERT INTO `code` VALUES ('3423', '320684', '海门市', 'BM_DISTRICT', '320600');
INSERT INTO `code` VALUES ('3424', '320700', '连云港市', 'BM_DISTRICT', '320000');
INSERT INTO `code` VALUES ('3425', '320701', '市辖区', 'BM_DISTRICT', '320700');
INSERT INTO `code` VALUES ('3426', '320703', '连云区', 'BM_DISTRICT', '320700');
INSERT INTO `code` VALUES ('3427', '320705', '新浦区', 'BM_DISTRICT', '320700');
INSERT INTO `code` VALUES ('3428', '320706', '海州区', 'BM_DISTRICT', '320700');
INSERT INTO `code` VALUES ('3429', '320721', '赣榆县', 'BM_DISTRICT', '320700');
INSERT INTO `code` VALUES ('3430', '320722', '东海县', 'BM_DISTRICT', '320700');
INSERT INTO `code` VALUES ('3431', '230881', '同江市', 'BM_DISTRICT', '230800');
INSERT INTO `code` VALUES ('3432', '230882', '富锦市', 'BM_DISTRICT', '230800');
INSERT INTO `code` VALUES ('3433', '230900', '七台河市', 'BM_DISTRICT', '230000');
INSERT INTO `code` VALUES ('3434', '230901', '市辖区', 'BM_DISTRICT', '230900');
INSERT INTO `code` VALUES ('3435', '230902', '新兴区', 'BM_DISTRICT', '230900');
INSERT INTO `code` VALUES ('3436', '230903', '桃山区', 'BM_DISTRICT', '230900');
INSERT INTO `code` VALUES ('3437', '230904', '茄子河区', 'BM_DISTRICT', '230900');
INSERT INTO `code` VALUES ('3438', '230921', '勃利县', 'BM_DISTRICT', '230900');
INSERT INTO `code` VALUES ('3439', '231000', '牡丹江市', 'BM_DISTRICT', '230000');
INSERT INTO `code` VALUES ('3440', '231001', '市辖区', 'BM_DISTRICT', '231000');
INSERT INTO `code` VALUES ('3441', '231002', '东安区', 'BM_DISTRICT', '231000');
INSERT INTO `code` VALUES ('3442', '231003', '阳明区', 'BM_DISTRICT', '231000');
INSERT INTO `code` VALUES ('3443', '231004', '爱民区', 'BM_DISTRICT', '231000');
INSERT INTO `code` VALUES ('3444', '231005', '西安区', 'BM_DISTRICT', '231000');
INSERT INTO `code` VALUES ('3445', '231024', '东宁县', 'BM_DISTRICT', '231000');
INSERT INTO `code` VALUES ('3446', '231025', '林口县', 'BM_DISTRICT', '231000');
INSERT INTO `code` VALUES ('3447', '231081', '绥芬河市', 'BM_DISTRICT', '231000');
INSERT INTO `code` VALUES ('3448', '231083', '海林市', 'BM_DISTRICT', '231000');
INSERT INTO `code` VALUES ('3449', '231084', '宁安市', 'BM_DISTRICT', '231000');
INSERT INTO `code` VALUES ('3450', '231085', '穆棱市', 'BM_DISTRICT', '231000');
INSERT INTO `code` VALUES ('3451', '231100', '黑河市', 'BM_DISTRICT', '230000');
INSERT INTO `code` VALUES ('3452', '130130', '无极县', 'BM_DISTRICT', '130100');
INSERT INTO `code` VALUES ('3453', '130131', '平山县', 'BM_DISTRICT', '130100');
INSERT INTO `code` VALUES ('3454', '130132', '元氏县', 'BM_DISTRICT', '130100');
INSERT INTO `code` VALUES ('3455', '130133', '赵县', 'BM_DISTRICT', '130100');
INSERT INTO `code` VALUES ('3456', '130181', '辛集市', 'BM_DISTRICT', '130100');
INSERT INTO `code` VALUES ('3457', '130182', '藁城市', 'BM_DISTRICT', '130100');
INSERT INTO `code` VALUES ('3458', '130183', '晋州市', 'BM_DISTRICT', '130100');
INSERT INTO `code` VALUES ('3459', '130184', '新乐市', 'BM_DISTRICT', '130100');
INSERT INTO `code` VALUES ('3460', '130185', '鹿泉市', 'BM_DISTRICT', '130100');
INSERT INTO `code` VALUES ('3461', '130200', '唐山市', 'BM_DISTRICT', '130000');
INSERT INTO `code` VALUES ('3462', '130201', '市辖区', 'BM_DISTRICT', '130200');
INSERT INTO `code` VALUES ('3463', '220182', '榆树市', 'BM_DISTRICT', '220100');
INSERT INTO `code` VALUES ('3464', '220183', '德惠市', 'BM_DISTRICT', '220100');
INSERT INTO `code` VALUES ('3465', '220200', '吉林市', 'BM_DISTRICT', '220000');
INSERT INTO `code` VALUES ('3466', '220201', '市辖区', 'BM_DISTRICT', '220200');
INSERT INTO `code` VALUES ('3467', '220202', '昌邑区', 'BM_DISTRICT', '220200');
INSERT INTO `code` VALUES ('3468', '220203', '龙潭区', 'BM_DISTRICT', '220200');
INSERT INTO `code` VALUES ('3469', '220204', '船营区', 'BM_DISTRICT', '220200');
INSERT INTO `code` VALUES ('3470', '220211', '丰满区', 'BM_DISTRICT', '220200');
INSERT INTO `code` VALUES ('3471', '220221', '永吉县', 'BM_DISTRICT', '220200');
INSERT INTO `code` VALUES ('3472', '220281', '蛟河市', 'BM_DISTRICT', '220200');
INSERT INTO `code` VALUES ('3473', '220282', '桦甸市', 'BM_DISTRICT', '220200');
INSERT INTO `code` VALUES ('3474', '220283', '舒兰市', 'BM_DISTRICT', '220200');
INSERT INTO `code` VALUES ('3475', '220284', '磐石市', 'BM_DISTRICT', '220200');
INSERT INTO `code` VALUES ('3476', '220300', '四平市', 'BM_DISTRICT', '220000');
INSERT INTO `code` VALUES ('3477', '220301', '市辖区', 'BM_DISTRICT', '220300');
INSERT INTO `code` VALUES ('3478', '220302', '铁西区', 'BM_DISTRICT', '220300');
INSERT INTO `code` VALUES ('3479', '220303', '铁东区', 'BM_DISTRICT', '220300');
INSERT INTO `code` VALUES ('3480', '220322', '梨树县', 'BM_DISTRICT', '220300');
INSERT INTO `code` VALUES ('3481', '110101', '东城区', 'BM_DISTRICT', '110100');
INSERT INTO `code` VALUES ('3482', '110102', '西城区', 'BM_DISTRICT', '110100');
INSERT INTO `code` VALUES ('3483', '110105', '朝阳区', 'BM_DISTRICT', '110100');
INSERT INTO `code` VALUES ('3484', '110106', '丰台区', 'BM_DISTRICT', '110100');
INSERT INTO `code` VALUES ('3485', '110107', '石景山区', 'BM_DISTRICT', '110100');
INSERT INTO `code` VALUES ('3486', '110108', '海淀区', 'BM_DISTRICT', '110100');
INSERT INTO `code` VALUES ('3487', '110109', '门头沟区', 'BM_DISTRICT', '110100');
INSERT INTO `code` VALUES ('3488', '110111', '房山区', 'BM_DISTRICT', '110100');
INSERT INTO `code` VALUES ('3489', '110112', '通州区', 'BM_DISTRICT', '110100');
INSERT INTO `code` VALUES ('3490', '110113', '顺义区', 'BM_DISTRICT', '110100');
INSERT INTO `code` VALUES ('3491', '110114', '昌平区', 'BM_DISTRICT', '110100');
INSERT INTO `code` VALUES ('3492', '110115', '大兴区', 'BM_DISTRICT', '110100');
INSERT INTO `code` VALUES ('3493', '110116', '怀柔区', 'BM_DISTRICT', '110100');
INSERT INTO `code` VALUES ('3494', '110117', '平谷区', 'BM_DISTRICT', '110100');
INSERT INTO `code` VALUES ('3495', '110200', '县', 'BM_DISTRICT', '110000');
INSERT INTO `code` VALUES ('3496', '110228', '密云县', 'BM_DISTRICT', '110200');
INSERT INTO `code` VALUES ('3497', '370100', '济南市', 'BM_DISTRICT', '370000');
INSERT INTO `code` VALUES ('3498', '370101', '市辖区', 'BM_DISTRICT', '370100');
INSERT INTO `code` VALUES ('3499', '370102', '历下区', 'BM_DISTRICT', '370100');
INSERT INTO `code` VALUES ('3500', '370103', '市中区', 'BM_DISTRICT', '370100');
INSERT INTO `code` VALUES ('3501', '370104', '槐荫区', 'BM_DISTRICT', '370100');
INSERT INTO `code` VALUES ('3502', '370105', '天桥区', 'BM_DISTRICT', '370100');
INSERT INTO `code` VALUES ('3503', '370112', '历城区', 'BM_DISTRICT', '370100');
INSERT INTO `code` VALUES ('3504', '370113', '长清区', 'BM_DISTRICT', '370100');
INSERT INTO `code` VALUES ('3505', '370124', '平阴县', 'BM_DISTRICT', '370100');
INSERT INTO `code` VALUES ('3506', '450481', '岑溪市', 'BM_DISTRICT', '450400');
INSERT INTO `code` VALUES ('3507', '450500', '北海市', 'BM_DISTRICT', '450000');
INSERT INTO `code` VALUES ('3508', '450501', '市辖区', 'BM_DISTRICT', '450500');
INSERT INTO `code` VALUES ('3509', '450502', '海城区', 'BM_DISTRICT', '450500');
INSERT INTO `code` VALUES ('3510', '450503', '银海区', 'BM_DISTRICT', '450500');
INSERT INTO `code` VALUES ('3511', '450512', '铁山港区', 'BM_DISTRICT', '450500');
INSERT INTO `code` VALUES ('3512', '450521', '合浦县', 'BM_DISTRICT', '450500');
INSERT INTO `code` VALUES ('3513', '450600', '防城港市', 'BM_DISTRICT', '450000');
INSERT INTO `code` VALUES ('3514', '450601', '市辖区', 'BM_DISTRICT', '450600');
INSERT INTO `code` VALUES ('3515', '450602', '港口区', 'BM_DISTRICT', '450600');
INSERT INTO `code` VALUES ('3516', '130121', '井陉县', 'BM_DISTRICT', '130100');
INSERT INTO `code` VALUES ('3517', '130123', '正定县', 'BM_DISTRICT', '130100');
INSERT INTO `code` VALUES ('3518', '130124', '栾城县', 'BM_DISTRICT', '130100');
INSERT INTO `code` VALUES ('3519', '130125', '行唐县', 'BM_DISTRICT', '130100');
INSERT INTO `code` VALUES ('3520', '130126', '灵寿县', 'BM_DISTRICT', '130100');

-- ----------------------------
-- Table structure for `comments`
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) DEFAULT NULL,
  `emp_id` int(11) DEFAULT NULL,
  `comment_date` varchar(19) DEFAULT NULL,
  `comment_grade` int(11) DEFAULT NULL,
  `comment_content` text,
  `comment_replay` text,
  `replay_time` varchar(19) DEFAULT NULL,
  `meal_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `FK_Relationship_19` (`customer_id`),
  KEY `FK_Relationship_20` (`emp_id`),
  KEY `meal_id` (`meal_id`),
  CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`meal_id`) REFERENCES `meal` (`meal_id`),
  CONSTRAINT `FK_Relationship_19` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`),
  CONSTRAINT `FK_Relationship_20` FOREIGN KEY (`emp_id`) REFERENCES `emp` (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comments
-- ----------------------------
INSERT INTO `comments` VALUES ('1', '1', '1', '2017-10-27 17:46:40', '5', '菜就是这个味道', '欢迎再来', '2017-10-27 18:52:58', '1');
INSERT INTO `comments` VALUES ('2', '1', '1', '2017-10-27 17:47:07', '5', '够辣，够刺激', '哈哈，下次会注意的', '2017-10-27 18:53:19', '2');
INSERT INTO `comments` VALUES ('3', '1', '1', '2017-10-27 17:47:33', '4', '好吃', '谢谢评论', '2017-10-27 18:53:32', '3');
INSERT INTO `comments` VALUES ('4', '1', '1', '2017-10-27 18:25:19', '4', '味道不错', '谢谢', '2017-10-27 18:53:44', '4');
INSERT INTO `comments` VALUES ('5', '2', '1', '2017-10-27 18:57:16', '5', '好好吃，感觉真棒！', '我们会做的更好的', '2017-10-27 18:59:10', '2');
INSERT INTO `comments` VALUES ('6', '2', '1', '2017-10-27 18:57:33', '4', '非常满意', '谢谢你的评论', '2017-10-27 18:59:31', '3');
INSERT INTO `comments` VALUES ('7', '2', '1', '2017-10-27 18:58:24', '5', '这个味道真的不错', '谢谢', '2017-10-27 18:59:43', '1');
INSERT INTO `comments` VALUES ('8', '19', '1', '2017-10-27 19:06:08', '4', '好吃不贵，下次还来', '欢迎', '2017-10-27 19:49:13', '4');
INSERT INTO `comments` VALUES ('9', '18', '1', '2017-10-27 19:22:05', '5', '好好吃，不错', '谢谢评论，我们会做的更好', '2017-10-27 19:49:41', '4');
INSERT INTO `comments` VALUES ('10', '18', '1', '2017-10-27 19:27:30', '5', '哩李', '赞', '2017-10-27 19:50:01', '4');
INSERT INTO `comments` VALUES ('11', '18', '1', '2017-10-27 19:38:56', '5', '好好吃，不错', '谢谢', '2017-10-27 19:50:13', '5');
INSERT INTO `comments` VALUES ('12', '18', '1', '2017-10-27 19:39:14', '5', '非常满意', '谢谢', '2017-10-27 19:50:26', '6');
INSERT INTO `comments` VALUES ('13', '1', '1', '2017-10-27 19:44:24', '3', '哈哈哈，哈哈哈', '客人的评价是对我们最好的回报', '2017-10-27 19:50:59', '1');
INSERT INTO `comments` VALUES ('14', '19', '1', '2017-10-27 19:56:03', '4', '味道刚好', '谢谢评论', '2017-10-27 20:03:06', '7');
INSERT INTO `comments` VALUES ('15', '19', '1', '2017-10-27 19:56:24', '5', '太好吃啦', '谢谢评', '2017-10-28 11:01:42', '8');
INSERT INTO `comments` VALUES ('16', '19', '1', '2017-10-27 19:56:43', '2', '一般般吧', '谢谢评论', '2017-10-27 20:04:06', '9');
INSERT INTO `comments` VALUES ('17', '19', '1', '2017-10-27 19:57:08', '3', '真的很正宗', '谢谢评论', '2017-10-27 20:04:00', '15');
INSERT INTO `comments` VALUES ('18', '19', '1', '2017-10-27 19:57:29', '4', '不错太好吃啦', '谢谢评论', '2017-10-27 20:03:53', '10');
INSERT INTO `comments` VALUES ('19', '19', '1', '2017-10-27 19:58:00', '3', '好吃，非常赞', '谢谢评论', '2017-10-27 20:03:47', '11');
INSERT INTO `comments` VALUES ('20', '19', '1', '2017-10-27 19:58:24', '4', '不错炒好吃', '谢谢评论', '2017-10-27 20:03:40', '12');
INSERT INTO `comments` VALUES ('21', '19', '1', '2017-10-27 19:59:54', '4', '还想再来', '谢谢评论', '2017-10-27 20:03:34', '14');
INSERT INTO `comments` VALUES ('22', '19', '1', '2017-10-27 20:00:20', '4', '超好吃，非常赞', '谢谢评论', '2017-10-27 20:03:20', '13');
INSERT INTO `comments` VALUES ('23', '19', '1', '2017-10-27 20:02:33', '5', '不错', '谢谢评论', '2017-10-27 20:03:12', '8');
INSERT INTO `comments` VALUES ('24', '19', null, '2017-10-27 23:29:37', '5', '哈哈', null, null, '7');
INSERT INTO `comments` VALUES ('25', '19', null, '2017-10-27 23:38:09', '4', '不错，正合我意', null, null, '9');
INSERT INTO `comments` VALUES ('26', '19', null, '2017-10-27 23:43:28', '1', '不好，差评', null, null, '10');
INSERT INTO `comments` VALUES ('27', '19', null, '2017-10-27 23:43:50', '2', '一般般吧', null, null, '11');

-- ----------------------------
-- Table structure for `cook`
-- ----------------------------
DROP TABLE IF EXISTS `cook`;
CREATE TABLE `cook` (
  `cook_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_detail_id` int(11) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  `meal_id` int(11) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `state` int(1) DEFAULT NULL,
  `rank` int(11) DEFAULT NULL,
  PRIMARY KEY (`cook_id`),
  KEY `FK_Relationship_7` (`order_id`),
  KEY `FK_Relationship_9` (`meal_id`),
  CONSTRAINT `cook_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`),
  CONSTRAINT `cook_ibfk_2` FOREIGN KEY (`meal_id`) REFERENCES `meal` (`meal_id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cook
-- ----------------------------
INSERT INTO `cook` VALUES ('1', '1', '1', '1', '1', null, '1', '1', '1');
INSERT INTO `cook` VALUES ('2', '1', '1', '1', '1', null, '1', '1', '1');
INSERT INTO `cook` VALUES ('3', '1', '1', '1', '1', null, '1', '1', '1');
INSERT INTO `cook` VALUES ('4', '1', '1', '1', '1', null, '1', '1', '1');
INSERT INTO `cook` VALUES ('5', '1', '1', '1', '1', null, '1', '1', '1');
INSERT INTO `cook` VALUES ('6', '1', '1', '1', '1', null, '1', '1', '1');
INSERT INTO `cook` VALUES ('7', '2', '1', '2', '1', null, '1', '1', '2');
INSERT INTO `cook` VALUES ('8', '3', '1', '3', '1', null, '1', '1', '3');
INSERT INTO `cook` VALUES ('9', '4', '1', '4', '1', null, '1', '1', '4');
INSERT INTO `cook` VALUES ('10', '4', '1', '4', '1', null, '1', '1', '4');
INSERT INTO `cook` VALUES ('11', '5', '1', '6', '1', null, '1', '1', '5');
INSERT INTO `cook` VALUES ('12', '5', '1', '6', '1', null, '1', '1', '5');
INSERT INTO `cook` VALUES ('13', '6', '1', '7', '1', null, '1', '1', '6');
INSERT INTO `cook` VALUES ('14', '6', '1', '7', '1', null, '1', '1', '6');
INSERT INTO `cook` VALUES ('15', '11', '2', '1', '1', null, '2', '1', '1');
INSERT INTO `cook` VALUES ('16', '12', '2', '2', '1', null, '2', '1', '2');
INSERT INTO `cook` VALUES ('17', '13', '2', '3', '1', null, '2', '1', '3');
INSERT INTO `cook` VALUES ('18', '14', '2', '5', '1', null, '2', '1', '4');
INSERT INTO `cook` VALUES ('19', '15', '2', '4', '1', null, '2', '1', '5');
INSERT INTO `cook` VALUES ('20', '16', '2', '8', '1', null, '2', '1', '6');
INSERT INTO `cook` VALUES ('21', '18', '3', '2', '1', null, null, '1', '1');
INSERT INTO `cook` VALUES ('22', '19', '3', '3', '1', null, null, '1', '2');
INSERT INTO `cook` VALUES ('23', '20', '3', '6', '1', null, null, '1', '3');
INSERT INTO `cook` VALUES ('24', '20', '3', '6', '1', null, null, '1', '3');
INSERT INTO `cook` VALUES ('25', '21', '3', '4', '1', null, null, '1', '4');
INSERT INTO `cook` VALUES ('26', '22', '3', '7', '1', null, null, '1', '5');
INSERT INTO `cook` VALUES ('27', '24', '4', '2', '1', null, '2', '1', '1');
INSERT INTO `cook` VALUES ('28', '25', '4', '3', '1', null, '2', '1', '2');
INSERT INTO `cook` VALUES ('29', '26', '4', '1', '1', null, '2', '1', '3');
INSERT INTO `cook` VALUES ('30', '27', '5', '4', '1', null, '19', '1', '1');
INSERT INTO `cook` VALUES ('31', '28', '5', '5', '1', null, '19', '1', '2');
INSERT INTO `cook` VALUES ('32', '29', '5', '6', '1', null, '19', '1', '3');
INSERT INTO `cook` VALUES ('33', '30', '5', '7', '1', null, '19', '1', '4');
INSERT INTO `cook` VALUES ('34', '31', '5', '8', '1', null, '19', '1', '5');
INSERT INTO `cook` VALUES ('35', '32', '5', '9', '1', null, '19', '1', '6');
INSERT INTO `cook` VALUES ('36', '33', '6', '4', '1', null, '18', '1', '1');
INSERT INTO `cook` VALUES ('37', '34', '6', '5', '1', null, '18', '1', '2');
INSERT INTO `cook` VALUES ('38', '35', '6', '6', '1', null, '18', '1', '3');
INSERT INTO `cook` VALUES ('39', '36', '7', '1', '1', null, '1', '1', '1');
INSERT INTO `cook` VALUES ('40', '37', '8', '7', '1', null, '19', '1', '1');
INSERT INTO `cook` VALUES ('41', '38', '8', '8', '1', null, '19', '1', '2');
INSERT INTO `cook` VALUES ('42', '39', '8', '9', '1', null, '19', '1', '3');
INSERT INTO `cook` VALUES ('43', '46', '9', '1', '1', null, '1', '1', '1');
INSERT INTO `cook` VALUES ('44', '47', '9', '2', '1', null, '1', '1', '2');

-- ----------------------------
-- Table structure for `customer`
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(20) DEFAULT NULL,
  `customer_birthday` date DEFAULT NULL,
  `sex` int(1) DEFAULT NULL,
  `customer_add` varchar(40) DEFAULT NULL,
  `customer_phone` varchar(20) DEFAULT NULL,
  `customer_account_name` varchar(255) DEFAULT NULL,
  `customer_pwd` varchar(255) DEFAULT NULL,
  `customer_city` varchar(255) DEFAULT NULL,
  `customer_province` varchar(255) DEFAULT NULL,
  `customer_district` varchar(255) DEFAULT NULL,
  `date` varchar(19) DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('1', '张三', null, '0', '福建省福州市鼓楼区', '15999999999', 'admin', 'admin', '福州市', '福建省', '鼓楼区', '2017-10-25 15:36:55');
INSERT INTO `customer` VALUES ('2', '李四', '1995-09-13', '0', '牛顿国际A座', '15477787859', 'lisi', '123456', '开封市', '河南省', '鼓楼区', '2017-10-25 15:36:55');
INSERT INTO `customer` VALUES ('11', '王五', '1994-09-05', '0', '楼道小区11号', '15126739253', 'wangwu', '123456', '北京市市辖区', '北京市', '东城区', '2017-10-25 15:36:55');
INSERT INTO `customer` VALUES ('12', '赵六', '1987-09-11', '0', '楼道小区3号', '13546798784', 'mgg', '123456', '合肥市', '安徽省', '瑶海区', '2017-10-25 15:36:55');
INSERT INTO `customer` VALUES ('16', '刘备', '1995-01-26', '0', '河南省郑州市金水区牛顿国际A座', '15517596093', 'lb', '123456', '北京市市辖区', '北京市', '东城区', null);
INSERT INTO `customer` VALUES ('17', '1', '2017-10-27', '0', '1', '1', '1', '1', '北京市市辖区', '北京市', '东城区', null);
INSERT INTO `customer` VALUES ('18', '盖聂', '2017-10-18', '0', '湖南省长沙市芙蓉区东风路20号', '18739487690', 'kolo', '123456', '长沙市', '湖南省', '芙蓉区', null);
INSERT INTO `customer` VALUES ('19', '月儿', '1996-10-16', '1', '北京市北京市市辖区东城区', '18736920890', 'main', '123456', '北京市市辖区', '北京市', '东城区', null);

-- ----------------------------
-- Table structure for `depart`
-- ----------------------------
DROP TABLE IF EXISTS `depart`;
CREATE TABLE `depart` (
  `depart_id` int(11) NOT NULL AUTO_INCREMENT,
  `depart_name` varchar(20) DEFAULT NULL,
  `depart_desc` text,
  `depart_url` varchar(255) DEFAULT NULL,
  `account_id` int(11) DEFAULT NULL,
  `emp_user` varchar(20) DEFAULT NULL,
  `account_date` varchar(20) DEFAULT NULL,
  `state` int(1) DEFAULT NULL,
  PRIMARY KEY (`depart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of depart
-- ----------------------------
INSERT INTO `depart` VALUES ('1', '管理部门', '管理其余的各个部门，以便各个部门能正常运转', null, null, null, null, '0');
INSERT INTO `depart` VALUES ('2', '服务部门', '主要负责整个餐厅的运转', null, null, null, null, '0');
INSERT INTO `depart` VALUES ('3', '后厨部门', '主要负责餐厅的饭菜的制作', null, null, null, null, '0');
INSERT INTO `depart` VALUES ('4', '后勤部门', '维护整个饭店的设备以及一些杂事的处理', null, null, null, null, '0');
INSERT INTO `depart` VALUES ('5', '财务部门', '主要负责对整个饭店的经济方面进行处理', null, null, null, null, '0');
INSERT INTO `depart` VALUES ('6', '线上订餐部', '主要负责对一些网上订餐的处理', null, null, null, null, '0');
INSERT INTO `depart` VALUES ('7', '人事部', '主要负责餐厅的人员安排情况', null, null, null, null, '0');
INSERT INTO `depart` VALUES ('8', '外交部', '主要负责外交事务', null, null, null, null, '0');
INSERT INTO `depart` VALUES ('9', '测试部门', '负责测试', null, null, null, null, '0');
INSERT INTO `depart` VALUES ('10', '饮品     ', '广利饮品', null, '1', 'zhangsan', '2017-10-28 08:29:54', '0');

-- ----------------------------
-- Table structure for `desk`
-- ----------------------------
DROP TABLE IF EXISTS `desk`;
CREATE TABLE `desk` (
  `desk_id` int(11) NOT NULL AUTO_INCREMENT,
  `pre_id` int(11) DEFAULT NULL,
  `desk_number` int(11) DEFAULT NULL,
  `desk_state` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`desk_id`),
  KEY `FK_Relationship_14` (`pre_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of desk
-- ----------------------------
INSERT INTO `desk` VALUES ('1', null, '1', '空');
INSERT INTO `desk` VALUES ('2', null, '2', '空');
INSERT INTO `desk` VALUES ('3', null, '3', '空');

-- ----------------------------
-- Table structure for `duty`
-- ----------------------------
DROP TABLE IF EXISTS `duty`;
CREATE TABLE `duty` (
  `duty_id` int(11) NOT NULL AUTO_INCREMENT,
  `depart_id` int(11) DEFAULT NULL,
  `duty_name` varchar(20) DEFAULT NULL,
  `account_id` int(11) DEFAULT NULL,
  `emp_user` varchar(20) DEFAULT NULL,
  `account_date` varchar(201) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`duty_id`),
  KEY `FK_Relationship_11` (`depart_id`),
  CONSTRAINT `FK_Relationship_11` FOREIGN KEY (`depart_id`) REFERENCES `depart` (`depart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of duty
-- ----------------------------
INSERT INTO `duty` VALUES ('1', '1', '经理', null, null, null, '0');
INSERT INTO `duty` VALUES ('2', '1', '大堂经理', null, null, null, '0');
INSERT INTO `duty` VALUES ('3', '1', '后勤经理', null, null, null, '0');
INSERT INTO `duty` VALUES ('4', '1', '财务经理', null, null, null, '0');
INSERT INTO `duty` VALUES ('5', '1', '人事经理', null, null, null, '0');
INSERT INTO `duty` VALUES ('6', '2', '接待员', null, null, null, '0');
INSERT INTO `duty` VALUES ('7', '2', '点菜员', null, null, null, '0');
INSERT INTO `duty` VALUES ('8', '2', '传菜员', null, null, null, '0');
INSERT INTO `duty` VALUES ('9', '2', '保洁员', null, null, null, '0');
INSERT INTO `duty` VALUES ('10', '3', '热菜厨师', null, null, null, '0');
INSERT INTO `duty` VALUES ('11', '3', '凉菜厨师', null, null, null, '0');
INSERT INTO `duty` VALUES ('12', '3', '面食厨师', null, null, null, '0');
INSERT INTO `duty` VALUES ('13', '3', '糕点师', null, null, null, '0');
INSERT INTO `duty` VALUES ('14', '3', '汤类厨师', null, null, null, '0');
INSERT INTO `duty` VALUES ('15', '4', '物品管理员', null, null, null, '0');
INSERT INTO `duty` VALUES ('16', '4', '采购员', null, null, null, '0');
INSERT INTO `duty` VALUES ('17', '5', '前台收银员', null, null, null, '0');
INSERT INTO `duty` VALUES ('18', '5', '财务管理员', null, null, null, '0');
INSERT INTO `duty` VALUES ('19', '6', '系统维护员', null, null, null, '0');
INSERT INTO `duty` VALUES ('20', '6', '订单处理员', null, null, null, '0');
INSERT INTO `duty` VALUES ('21', '6', '餐饮配送员', null, null, null, '0');
INSERT INTO `duty` VALUES ('22', '6', '菜品发布员', null, null, null, '0');
INSERT INTO `duty` VALUES ('23', '7', '市场调研', null, null, null, '0');
INSERT INTO `duty` VALUES ('24', '7', '人员管理', null, null, null, '0');

-- ----------------------------
-- Table structure for `emp`
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `emp_id` int(11) NOT NULL AUTO_INCREMENT,
  `depart_id` int(11) DEFAULT NULL,
  `duty_id` int(11) DEFAULT NULL,
  `emp_name` varchar(20) NOT NULL,
  `hiredate` date DEFAULT NULL,
  `sex` int(1) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `district` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `date` varchar(19) DEFAULT NULL,
  PRIMARY KEY (`emp_id`),
  KEY `FK_Relationship_1` (`depart_id`),
  KEY `FK_Relationship_10` (`duty_id`),
  CONSTRAINT `FK_Relationship_1` FOREIGN KEY (`depart_id`) REFERENCES `depart` (`depart_id`),
  CONSTRAINT `FK_Relationship_10` FOREIGN KEY (`duty_id`) REFERENCES `duty` (`duty_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES ('1', '1', '1', '超级管理员', '1983-01-01', '0', '23', '15444444444', '山东省济南市历下区', '山东省', '济南市', '历下区', '1', 'zhangsan', '2017-10-27 13:58:45');
INSERT INTO `emp` VALUES ('2', '6', '20', '吴智豪', '1995-08-09', '0', '24', '15666666666', '吉林省长春市南关区', '吉林省', '长春市', '南关区', '1', 'zhangsan', '2017-10-27 14:02:32');
INSERT INTO `emp` VALUES ('3', '2', '7', '马岗岗', '1994-12-11', '0', '25', '15999999996', '安徽省合肥市瑶海区', '安徽省', '合肥市', '瑶海区', '1', 'zhangsan', '2017-10-27 14:10:56');
INSERT INTO `emp` VALUES ('4', '2', '6', '雷超', '1996-02-21', '0', '25', '15999966666', '山东省济南市历下区', '山东省', '济南市', '历下区', '1', 'zhangsan', '2017-10-27 14:05:55');
INSERT INTO `emp` VALUES ('5', '3', '10', '马方伟', '1990-08-01', '0', '25', '15666322223', '河南省郑州市中原区', '河南省', '郑州市', '中原区', '1', 'zhangsan', '2017-10-27 14:10:42');
INSERT INTO `emp` VALUES ('6', '6', '21', '任恒', '1994-11-01', '0', '25', '15996687333', '吉林省长春市南关区', '吉林省', '长春市', '南关区', '1', 'zhangsan', '2017-10-27 17:02:05');
INSERT INTO `emp` VALUES ('7', '2', '7', '马刚', '1980-01-01', '0', '23', '18736938680', '河南省郑州市中原区莲花街120号', '河南省', '郑州市', '中原区', '2', 'wuzhihao', '2017-10-27 16:46:41');
INSERT INTO `emp` VALUES ('8', '6', '21', '白棋', '2017-11-10', '0', '22', '18736529890', '湖北省武汉市江岸区', '湖北省', '武汉市', '江岸区', '1', 'zhangsan', '2017-10-27 17:01:21');

-- ----------------------------
-- Table structure for `empshop`
-- ----------------------------
DROP TABLE IF EXISTS `empshop`;
CREATE TABLE `empshop` (
  `room_id` int(11) DEFAULT NULL,
  `meal_id` int(11) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `price` double(10,2) DEFAULT NULL,
  `meal_name` varchar(255) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  `meal_price` double(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of empshop
-- ----------------------------

-- ----------------------------
-- Table structure for `emp_account`
-- ----------------------------
DROP TABLE IF EXISTS `emp_account`;
CREATE TABLE `emp_account` (
  `emp_account_id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_id` int(11) DEFAULT NULL,
  `emp_user` varchar(20) NOT NULL,
  `emp_password` varchar(8) DEFAULT NULL,
  `state` int(1) DEFAULT NULL,
  PRIMARY KEY (`emp_account_id`),
  KEY `AK_Identifier_1` (`emp_account_id`),
  KEY `FK_Relationship_23` (`emp_id`),
  CONSTRAINT `FK_Relationship_23` FOREIGN KEY (`emp_id`) REFERENCES `emp` (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of emp_account
-- ----------------------------
INSERT INTO `emp_account` VALUES ('1', '1', 'zhangsan', 'zhangsan', '1');
INSERT INTO `emp_account` VALUES ('2', '2', 'wuzhihao', '123456', '1');
INSERT INTO `emp_account` VALUES ('3', '3', 'mgg', '123456', '1');
INSERT INTO `emp_account` VALUES ('4', '4', 'leichao', '123456', '1');
INSERT INTO `emp_account` VALUES ('5', '5', 'mfw', '123456', '1');
INSERT INTO `emp_account` VALUES ('6', '6', 'renheng', '123456', '1');
INSERT INTO `emp_account` VALUES ('7', '7', 'mg', '123456', '1');
INSERT INTO `emp_account` VALUES ('8', '8', 'baiqi', '123456', '1');

-- ----------------------------
-- Table structure for `functions`
-- ----------------------------
DROP TABLE IF EXISTS `functions`;
CREATE TABLE `functions` (
  `function_id` int(11) NOT NULL AUTO_INCREMENT,
  `function_name` varchar(20) DEFAULT NULL,
  `function_dec` text,
  `function_url` varchar(200) DEFAULT NULL,
  `function_parent_id` int(11) DEFAULT NULL,
  `state` int(2) DEFAULT NULL,
  `date` varchar(19) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`function_id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of functions
-- ----------------------------
INSERT INTO `functions` VALUES ('1', '部门管理', '', '/module/Depart/DepartTree.jsp', '7', '0', '2017-10-28 01:12:24', '1', 'zhangsan');
INSERT INTO `functions` VALUES ('2', '订单管理', '', '', null, '0', '2017-10-28 01:57:16', '1', 'zhangsan');
INSERT INTO `functions` VALUES ('3', '顾客管理', '', '/dc/CustomerInfo', '7', '0', '2017-10-28 01:12:31', '1', 'zhangsan');
INSERT INTO `functions` VALUES ('4', '商品管理', '', '', null, '0', '2017-10-28 02:06:51', '1', 'zhangsan');
INSERT INTO `functions` VALUES ('5', '员工管理', '', '/dc/ShowAllEmp', '7', '0', '2017-10-28 01:34:41', '1', 'zhangsan');
INSERT INTO `functions` VALUES ('6', '角色管理', '', '/dc/FindRole', '7', '0', '2017-10-28 02:07:03', '1', 'zhangsan');
INSERT INTO `functions` VALUES ('7', '基本信息管理', '所有基本信息维护', '', null, '0', '2017-10-28 01:55:52', '1', 'zhangsan');
INSERT INTO `functions` VALUES ('8', '员工列表', null, '/dc/ShowAllEmp', '5', '0', null, null, null);
INSERT INTO `functions` VALUES ('9', '统计管理', '', '', null, '0', '2017-10-28 01:52:07', '1', 'zhangsan');
INSERT INTO `functions` VALUES ('10', '线上订单', '', '/order/SelectOrder', '2', '0', '2017-10-28 01:56:10', '1', 'zhangsan');
INSERT INTO `functions` VALUES ('11', '后厨订单', '', '/cook_seeCookRank.action', '2', '0', '2017-10-28 01:36:25', '1', 'zhangsan');
INSERT INTO `functions` VALUES ('12', '菜品管理', null, '/dc/Goods', '4', '0', null, null, null);
INSERT INTO `functions` VALUES ('13', '现场订单列表', null, '/bgO_showAllRoomOrder.action', '2', '0', null, null, null);
INSERT INTO `functions` VALUES ('14', '顾客统计', null, '/total_CustomerTotal.action', '9', '0', null, null, null);
INSERT INTO `functions` VALUES ('15', '评论管理', null, null, null, '0', null, null, null);
INSERT INTO `functions` VALUES ('16', '菜品销量推荐', null, '/mealtotal_MealTotal.action', '9', '0', null, null, null);
INSERT INTO `functions` VALUES ('17', '功能管理', null, '/module/Function/FunctionsTree.jsp', '7', '0', null, null, null);
INSERT INTO `functions` VALUES ('18', '职务管理', null, '/duty/SelectDuty', '7', '0', null, null, null);
INSERT INTO `functions` VALUES ('19', '订单查询', null, null, '9', '0', null, null, null);
INSERT INTO `functions` VALUES ('20', '订单统计', null, '/c_findAll.action', '9', '0', null, null, null);
INSERT INTO `functions` VALUES ('21', '翻盘率统计', null, '/roomTotal_checkAndShowtotal.action', '9', '0', null, null, null);
INSERT INTO `functions` VALUES ('22', '评论列表', null, '/pl_SelectPl.action', '15', '0', null, null, null);
INSERT INTO `functions` VALUES ('23', '开桌结账', null, '/open_openSeeTable.action', '35', '0', null, null, null);
INSERT INTO `functions` VALUES ('24', '订餐上桌', null, '/emp_SetRoom.action', null, '0', null, null, null);
INSERT INTO `functions` VALUES ('30', '预订管理', null, null, null, '0', null, null, null);
INSERT INTO `functions` VALUES ('31', '桌房基础表', '', '/dc/QueryRoomOrDesk', '7', '0', null, null, null);
INSERT INTO `functions` VALUES ('32', '预订单查询', '', '/line_seeLineRoom.action', '30', '0', null, null, null);
INSERT INTO `functions` VALUES ('35', '开桌结账', '', '/open_openSeeTable.action', null, '0', null, null, null);
INSERT INTO `functions` VALUES ('36', '后台预订', '', '/pre_empSelectRoom.action', '30', '0', null, null, null);
INSERT INTO `functions` VALUES ('39', '材料管理', '', '/dc/Caterial', '4', '0', '2017-10-28 01:51:41', '1', 'zhangsan');
INSERT INTO `functions` VALUES ('43', '酒水订单', null, '/bgO_DrinkOrder.action', '2', '0', null, null, null);

-- ----------------------------
-- Table structure for `functions_role`
-- ----------------------------
DROP TABLE IF EXISTS `functions_role`;
CREATE TABLE `functions_role` (
  `function_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`function_id`,`role_id`),
  KEY `FK_Relationship_17` (`role_id`),
  CONSTRAINT `FK_Relationship_16` FOREIGN KEY (`function_id`) REFERENCES `functions` (`function_id`),
  CONSTRAINT `FK_Relationship_17` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of functions_role
-- ----------------------------
INSERT INTO `functions_role` VALUES ('1', '1');
INSERT INTO `functions_role` VALUES ('2', '1');
INSERT INTO `functions_role` VALUES ('3', '1');
INSERT INTO `functions_role` VALUES ('4', '1');
INSERT INTO `functions_role` VALUES ('5', '1');
INSERT INTO `functions_role` VALUES ('6', '1');
INSERT INTO `functions_role` VALUES ('7', '1');
INSERT INTO `functions_role` VALUES ('9', '1');
INSERT INTO `functions_role` VALUES ('10', '1');
INSERT INTO `functions_role` VALUES ('11', '1');
INSERT INTO `functions_role` VALUES ('12', '1');
INSERT INTO `functions_role` VALUES ('13', '1');
INSERT INTO `functions_role` VALUES ('14', '1');
INSERT INTO `functions_role` VALUES ('15', '1');
INSERT INTO `functions_role` VALUES ('16', '1');
INSERT INTO `functions_role` VALUES ('17', '1');
INSERT INTO `functions_role` VALUES ('18', '1');
INSERT INTO `functions_role` VALUES ('19', '1');
INSERT INTO `functions_role` VALUES ('20', '1');
INSERT INTO `functions_role` VALUES ('21', '1');
INSERT INTO `functions_role` VALUES ('22', '1');
INSERT INTO `functions_role` VALUES ('23', '1');
INSERT INTO `functions_role` VALUES ('24', '1');
INSERT INTO `functions_role` VALUES ('30', '1');
INSERT INTO `functions_role` VALUES ('31', '1');
INSERT INTO `functions_role` VALUES ('32', '1');
INSERT INTO `functions_role` VALUES ('35', '1');
INSERT INTO `functions_role` VALUES ('36', '1');
INSERT INTO `functions_role` VALUES ('39', '1');
INSERT INTO `functions_role` VALUES ('43', '1');
INSERT INTO `functions_role` VALUES ('2', '2');
INSERT INTO `functions_role` VALUES ('10', '2');
INSERT INTO `functions_role` VALUES ('11', '2');
INSERT INTO `functions_role` VALUES ('43', '2');
INSERT INTO `functions_role` VALUES ('2', '3');
INSERT INTO `functions_role` VALUES ('11', '3');
INSERT INTO `functions_role` VALUES ('13', '3');
INSERT INTO `functions_role` VALUES ('23', '3');
INSERT INTO `functions_role` VALUES ('35', '3');
INSERT INTO `functions_role` VALUES ('43', '3');
INSERT INTO `functions_role` VALUES ('24', '5');
INSERT INTO `functions_role` VALUES ('30', '6');
INSERT INTO `functions_role` VALUES ('32', '6');
INSERT INTO `functions_role` VALUES ('36', '6');
INSERT INTO `functions_role` VALUES ('4', '7');
INSERT INTO `functions_role` VALUES ('9', '7');
INSERT INTO `functions_role` VALUES ('12', '7');
INSERT INTO `functions_role` VALUES ('14', '7');
INSERT INTO `functions_role` VALUES ('16', '7');
INSERT INTO `functions_role` VALUES ('19', '7');
INSERT INTO `functions_role` VALUES ('20', '7');
INSERT INTO `functions_role` VALUES ('21', '7');
INSERT INTO `functions_role` VALUES ('39', '7');
INSERT INTO `functions_role` VALUES ('15', '8');
INSERT INTO `functions_role` VALUES ('22', '8');

-- ----------------------------
-- Table structure for `meal`
-- ----------------------------
DROP TABLE IF EXISTS `meal`;
CREATE TABLE `meal` (
  `meal_id` int(11) NOT NULL AUTO_INCREMENT,
  `meal_parent_id` int(11) DEFAULT NULL,
  `meal_type` varchar(20) DEFAULT NULL,
  `meal_compose` varchar(20) DEFAULT NULL,
  `meal_name` varchar(20) DEFAULT NULL,
  `meal_budget` varchar(20) DEFAULT NULL,
  `meal_price` int(20) DEFAULT NULL,
  `meal_count` int(11) DEFAULT NULL,
  `meal_desc` text,
  `meal_image` varchar(50) DEFAULT NULL,
  `materials_id` int(50) DEFAULT NULL,
  PRIMARY KEY (`meal_id`),
  KEY `FK_Relationship_15` (`meal_parent_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of meal
-- ----------------------------
INSERT INTO `meal` VALUES ('1', null, '热菜', '能', '蒜蓉蒸金针菇', '10', '20', '1', '盐,蒜,色拉油,葱,金针菇,生抽,糖', '蒜蓉蒸金针菇.jpg', null);
INSERT INTO `meal` VALUES ('2', null, '热菜', '不能', '干锅土豆片', '15', '30', '1', '盐,蒜,葱花,土豆,豆瓣酱,老抽,辣椒面', '干锅土豆片.jpg', null);
INSERT INTO `meal` VALUES ('3', null, '热菜', '能', '蒜香炒花甲', '25', '40', '1', '盐,蒜,葱花,花甲,蚝油,辣椒油,味精', '蒜香炒花甲.jpg', null);
INSERT INTO `meal` VALUES ('4', null, '热菜', '能', '酸辣土豆丝', '5', '10', '1', '盐,蒜,色拉油,土豆,姜,醋,辣椒油,青椒丝,红椒', '家常菜 酸辣土豆丝.jpg', null);
INSERT INTO `meal` VALUES ('5', null, '热菜', '能', '红烧排骨 ', '15', '35', '1', '盐,色拉油,葱花,生抽,姜,排骨,清水,冰糖,桂皮,八角,花雕酒', '红烧排骨.jpg', null);
INSERT INTO `meal` VALUES ('6', null, '热菜', '能', '蒜蓉粉丝蒸虾 ', '45', '80', '1', '盐,蒜,葱花,生抽,糖,高汤（清水）,海虾,绿豆粉丝 ,白胡椒粉, ', '蒜蓉粉丝蒸虾.jpg', null);
INSERT INTO `meal` VALUES ('7', null, '热菜', '能', '蒜香排骨（烤箱）', '60', '95', '1', '盐,蒜,糖,蚝油,姜,红椒,蒸鱼豉油', '香到骨头里的蒜香排骨（烤箱）.jpg', null);
INSERT INTO `meal` VALUES ('8', null, '热菜', '不能', '红烧鲫鱼 ', '35', '45', '1', '盐,蒜,葱花,生抽,老抽,姜,鲫鱼', '红烧鲫鱼.jpg', null);
INSERT INTO `meal` VALUES ('9', null, '热菜', '能', '红烧狮子头 ', '6', '15', '1', '盐,葱花,糖,胡椒粉,猪肉馅 ,鸡蛋,淀粉,李锦记秘制红烧汁 ,料酒', '红烧狮子头.jpg', null);
INSERT INTO `meal` VALUES ('10', null, '凉菜', '', '香辣凉拌皮蛋 ', '5', '8', '1', '盐,蒜,葱花,生抽,姜,醋,辣椒面,皮蛋,芝麻香油,', '香辣凉拌皮蛋.jpeg', null);
INSERT INTO `meal` VALUES ('11', null, '凉菜', '', '凉拌芹菜', '6', '10', '1', '盐,蒜,生抽,糖,醋,香油,芹菜,黑木耳,大料（花椒、香叶、八角）,胡萝卜,花生米', '凉拌芹菜.jpeg', null);
INSERT INTO `meal` VALUES ('12', null, '凉菜', '', '果仁菠菜 ', '4', '10', '1', '盐,蒜,色拉油,生抽,醋,干红辣椒,花椒,花生米,菠菜,鸡精', '果仁菠菜.jpg', null);
INSERT INTO `meal` VALUES ('13', null, '凉菜', '', '皮蛋豆腐 ', '6', '10', '1', '盐,葱花,生抽,辣椒油,皮蛋,芝麻香油,嫩豆腐,榨菜末', '皮蛋豆腐.jpg', null);
INSERT INTO `meal` VALUES ('14', null, '凉菜', '', '翠竹报春', '7', '10', '1', '盐,鸡腿,红椒,黄瓜,苹果醋', '翠竹报春.jpg', null);
INSERT INTO `meal` VALUES ('15', null, '酒水', null, '小糊涂神', '20', '45', '1', null, '小糊涂神.jpg', null);
INSERT INTO `meal` VALUES ('16', null, '酒水', null, '茅台迎宾酒', '120', '400', '1', null, '茅台迎宾酒.jpg', null);
INSERT INTO `meal` VALUES ('17', null, '酒水', null, '可乐', '3', '8', '1', null, '可乐.jpg', null);
INSERT INTO `meal` VALUES ('18', null, '酒水', null, '雪碧', '2', '5', '1', null, '雪碧.jpg', null);
INSERT INTO `meal` VALUES ('19', null, '凉菜', null, '香肠', '10', '15', '1', null, 'po1.jpg', null);
INSERT INTO `meal` VALUES ('20', null, '凉菜', null, '奶油蛋糕', '20', '40', '1', '', 'po3.jpg', null);

-- ----------------------------
-- Table structure for `meal_caterial`
-- ----------------------------
DROP TABLE IF EXISTS `meal_caterial`;
CREATE TABLE `meal_caterial` (
  `caterial_id` int(50) NOT NULL,
  `meal_id` int(50) NOT NULL,
  PRIMARY KEY (`caterial_id`,`meal_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of meal_caterial
-- ----------------------------
INSERT INTO `meal_caterial` VALUES ('1', '1');
INSERT INTO `meal_caterial` VALUES ('1', '2');
INSERT INTO `meal_caterial` VALUES ('1', '3');
INSERT INTO `meal_caterial` VALUES ('1', '4');
INSERT INTO `meal_caterial` VALUES ('1', '5');
INSERT INTO `meal_caterial` VALUES ('1', '6');
INSERT INTO `meal_caterial` VALUES ('1', '7');
INSERT INTO `meal_caterial` VALUES ('1', '8');
INSERT INTO `meal_caterial` VALUES ('1', '9');
INSERT INTO `meal_caterial` VALUES ('1', '10');
INSERT INTO `meal_caterial` VALUES ('1', '11');
INSERT INTO `meal_caterial` VALUES ('1', '12');
INSERT INTO `meal_caterial` VALUES ('1', '13');
INSERT INTO `meal_caterial` VALUES ('1', '14');
INSERT INTO `meal_caterial` VALUES ('2', '1');
INSERT INTO `meal_caterial` VALUES ('2', '2');
INSERT INTO `meal_caterial` VALUES ('2', '3');
INSERT INTO `meal_caterial` VALUES ('2', '4');
INSERT INTO `meal_caterial` VALUES ('2', '6');
INSERT INTO `meal_caterial` VALUES ('2', '7');
INSERT INTO `meal_caterial` VALUES ('2', '8');
INSERT INTO `meal_caterial` VALUES ('2', '10');
INSERT INTO `meal_caterial` VALUES ('2', '11');
INSERT INTO `meal_caterial` VALUES ('2', '12');
INSERT INTO `meal_caterial` VALUES ('3', '1');
INSERT INTO `meal_caterial` VALUES ('3', '4');
INSERT INTO `meal_caterial` VALUES ('3', '5');
INSERT INTO `meal_caterial` VALUES ('3', '12');
INSERT INTO `meal_caterial` VALUES ('4', '1');
INSERT INTO `meal_caterial` VALUES ('4', '2');
INSERT INTO `meal_caterial` VALUES ('4', '3');
INSERT INTO `meal_caterial` VALUES ('4', '5');
INSERT INTO `meal_caterial` VALUES ('4', '6');
INSERT INTO `meal_caterial` VALUES ('4', '8');
INSERT INTO `meal_caterial` VALUES ('4', '9');
INSERT INTO `meal_caterial` VALUES ('4', '10');
INSERT INTO `meal_caterial` VALUES ('4', '13');
INSERT INTO `meal_caterial` VALUES ('5', '1');
INSERT INTO `meal_caterial` VALUES ('5', '5');
INSERT INTO `meal_caterial` VALUES ('5', '6');
INSERT INTO `meal_caterial` VALUES ('5', '8');
INSERT INTO `meal_caterial` VALUES ('5', '10');
INSERT INTO `meal_caterial` VALUES ('5', '11');
INSERT INTO `meal_caterial` VALUES ('5', '12');
INSERT INTO `meal_caterial` VALUES ('5', '13');
INSERT INTO `meal_caterial` VALUES ('6', '1');
INSERT INTO `meal_caterial` VALUES ('6', '6');
INSERT INTO `meal_caterial` VALUES ('6', '7');
INSERT INTO `meal_caterial` VALUES ('6', '9');
INSERT INTO `meal_caterial` VALUES ('6', '11');
INSERT INTO `meal_caterial` VALUES ('7', '2');
INSERT INTO `meal_caterial` VALUES ('8', '2');
INSERT INTO `meal_caterial` VALUES ('9', '2');
INSERT INTO `meal_caterial` VALUES ('9', '10');
INSERT INTO `meal_caterial` VALUES ('10', '3');
INSERT INTO `meal_caterial` VALUES ('10', '7');
INSERT INTO `meal_caterial` VALUES ('11', '3');
INSERT INTO `meal_caterial` VALUES ('12', '4');
INSERT INTO `meal_caterial` VALUES ('12', '5');
INSERT INTO `meal_caterial` VALUES ('12', '7');
INSERT INTO `meal_caterial` VALUES ('12', '8');
INSERT INTO `meal_caterial` VALUES ('12', '10');
INSERT INTO `meal_caterial` VALUES ('13', '4');
INSERT INTO `meal_caterial` VALUES ('13', '10');
INSERT INTO `meal_caterial` VALUES ('13', '11');
INSERT INTO `meal_caterial` VALUES ('13', '12');
INSERT INTO `meal_caterial` VALUES ('14', '3');
INSERT INTO `meal_caterial` VALUES ('14', '4');
INSERT INTO `meal_caterial` VALUES ('14', '13');
INSERT INTO `meal_caterial` VALUES ('15', '5');
INSERT INTO `meal_caterial` VALUES ('16', '5');
INSERT INTO `meal_caterial` VALUES ('17', '5');
INSERT INTO `meal_caterial` VALUES ('17', '11');
INSERT INTO `meal_caterial` VALUES ('18', '5');
INSERT INTO `meal_caterial` VALUES ('19', '6');
INSERT INTO `meal_caterial` VALUES ('19', '9');
INSERT INTO `meal_caterial` VALUES ('20', '7');
INSERT INTO `meal_caterial` VALUES ('21', '9');
INSERT INTO `meal_caterial` VALUES ('22', '9');
INSERT INTO `meal_caterial` VALUES ('23', '10');
INSERT INTO `meal_caterial` VALUES ('23', '11');
INSERT INTO `meal_caterial` VALUES ('23', '13');
INSERT INTO `meal_caterial` VALUES ('24', '11');
INSERT INTO `meal_caterial` VALUES ('24', '12');
INSERT INTO `meal_caterial` VALUES ('25', '11');
INSERT INTO `meal_caterial` VALUES ('26', '12');
INSERT INTO `meal_caterial` VALUES ('27', '14');
INSERT INTO `meal_caterial` VALUES ('28', '1');
INSERT INTO `meal_caterial` VALUES ('29', '2');
INSERT INTO `meal_caterial` VALUES ('29', '4');
INSERT INTO `meal_caterial` VALUES ('30', '3');
INSERT INTO `meal_caterial` VALUES ('31', '4');
INSERT INTO `meal_caterial` VALUES ('32', '4');
INSERT INTO `meal_caterial` VALUES ('32', '7');
INSERT INTO `meal_caterial` VALUES ('32', '12');
INSERT INTO `meal_caterial` VALUES ('32', '14');
INSERT INTO `meal_caterial` VALUES ('33', '5');
INSERT INTO `meal_caterial` VALUES ('34', '6');
INSERT INTO `meal_caterial` VALUES ('35', '6');
INSERT INTO `meal_caterial` VALUES ('36', '8');
INSERT INTO `meal_caterial` VALUES ('37', '9');
INSERT INTO `meal_caterial` VALUES ('38', '9');
INSERT INTO `meal_caterial` VALUES ('39', '9');
INSERT INTO `meal_caterial` VALUES ('40', '10');
INSERT INTO `meal_caterial` VALUES ('40', '13');
INSERT INTO `meal_caterial` VALUES ('41', '11');
INSERT INTO `meal_caterial` VALUES ('42', '11');
INSERT INTO `meal_caterial` VALUES ('43', '11');
INSERT INTO `meal_caterial` VALUES ('44', '11');
INSERT INTO `meal_caterial` VALUES ('44', '12');
INSERT INTO `meal_caterial` VALUES ('45', '12');
INSERT INTO `meal_caterial` VALUES ('46', '13');
INSERT INTO `meal_caterial` VALUES ('47', '13');
INSERT INTO `meal_caterial` VALUES ('48', '14');
INSERT INTO `meal_caterial` VALUES ('49', '14');

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_id` int(11) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `emp_emp_id` int(11) DEFAULT NULL,
  `order_date` varchar(19) DEFAULT NULL,
  `order_content` text,
  `order_count` int(11) DEFAULT NULL,
  `money` double DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `room_id` int(11) DEFAULT NULL,
  `date` varchar(19) DEFAULT NULL,
  `pushfoodcount` int(11) DEFAULT NULL,
  `call` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `FK_Relationship_12` (`customer_id`),
  KEY `FK_accept` (`emp_emp_id`),
  KEY `FK_print` (`emp_id`),
  CONSTRAINT `FK_accept` FOREIGN KEY (`emp_emp_id`) REFERENCES `emp` (`emp_id`),
  CONSTRAINT `FK_print` FOREIGN KEY (`emp_id`) REFERENCES `emp` (`emp_id`),
  CONSTRAINT `FK_Relationship_12` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '6', '1', null, '2017-10-27 15:47:58', '多加点米饭\n', null, '761', '4', null, null, null, null);
INSERT INTO `orders` VALUES ('2', null, '2', null, '2017-10-27 15:51:50', '', null, '190', '5', null, null, null, null);
INSERT INTO `orders` VALUES ('3', null, null, null, '2017-10-27 15:53:52', null, '1', '263', '1', '1', null, '3', null);
INSERT INTO `orders` VALUES ('4', '6', '2', null, '2017-10-27 18:55:10', '尽量快点！！', null, '90', '4', null, null, null, null);
INSERT INTO `orders` VALUES ('5', '6', '19', null, '2017-10-27 19:04:19', '', null, '280', '4', null, null, null, null);
INSERT INTO `orders` VALUES ('6', '8', '18', null, '2017-10-27 19:13:00', '', null, '125', '4', null, null, null, null);
INSERT INTO `orders` VALUES ('7', '8', '1', null, '2017-10-27 19:41:51', '', null, '20', '4', null, null, null, null);
INSERT INTO `orders` VALUES ('8', '6', '19', null, '2017-10-27 19:53:44', '', null, '248', '4', null, null, null, null);
INSERT INTO `orders` VALUES ('9', '8', '1', null, '2017-10-28 10:59:03', '', null, '50', '4', null, null, null, null);

-- ----------------------------
-- Table structure for `order_detail`
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `order_detail_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) DEFAULT NULL,
  `meal_id` int(11) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `state` int(1) DEFAULT NULL,
  `rank` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_detail_id`),
  KEY `FK_Relationship_7` (`order_id`),
  KEY `FK_Relationship_9` (`meal_id`),
  CONSTRAINT `FK_Relationship_7` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`),
  CONSTRAINT `FK_Relationship_9` FOREIGN KEY (`meal_id`) REFERENCES `meal` (`meal_id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO `order_detail` VALUES ('1', '1', '1', '6', '20', '1', '1', '1');
INSERT INTO `order_detail` VALUES ('2', '1', '2', '1', '30', '1', '1', '2');
INSERT INTO `order_detail` VALUES ('3', '1', '3', '1', '40', '1', '1', '3');
INSERT INTO `order_detail` VALUES ('4', '1', '4', '2', '10', '1', '1', '4');
INSERT INTO `order_detail` VALUES ('5', '1', '6', '2', '80', '1', '1', '5');
INSERT INTO `order_detail` VALUES ('6', '1', '7', '2', '95', '1', '1', '6');
INSERT INTO `order_detail` VALUES ('7', '1', '14', '2', '10', '1', '1', null);
INSERT INTO `order_detail` VALUES ('8', '1', '15', '3', '45', '1', '1', null);
INSERT INTO `order_detail` VALUES ('9', '1', '17', '2', '8', '1', '1', null);
INSERT INTO `order_detail` VALUES ('10', '1', '19', '2', '15', '1', '1', null);
INSERT INTO `order_detail` VALUES ('11', '2', '1', '1', '20', '2', '1', '1');
INSERT INTO `order_detail` VALUES ('12', '2', '2', '1', '30', '2', '1', '2');
INSERT INTO `order_detail` VALUES ('13', '2', '3', '1', '40', '2', '1', '3');
INSERT INTO `order_detail` VALUES ('14', '2', '5', '1', '35', '2', '1', '4');
INSERT INTO `order_detail` VALUES ('15', '2', '4', '1', '10', '2', '1', '5');
INSERT INTO `order_detail` VALUES ('16', '2', '8', '1', '45', '2', '1', '6');
INSERT INTO `order_detail` VALUES ('17', '2', '11', '1', '10', '2', '1', null);
INSERT INTO `order_detail` VALUES ('18', '3', '2', '1', null, null, '1', '1');
INSERT INTO `order_detail` VALUES ('19', '3', '3', '1', null, null, '1', '2');
INSERT INTO `order_detail` VALUES ('20', '3', '6', '2', null, null, '1', '3');
INSERT INTO `order_detail` VALUES ('21', '3', '4', '1', null, null, '1', '4');
INSERT INTO `order_detail` VALUES ('22', '3', '7', '1', null, null, '1', '5');
INSERT INTO `order_detail` VALUES ('23', '3', '10', '1', null, null, '1', null);
INSERT INTO `order_detail` VALUES ('24', '4', '2', '1', '30', '2', '1', '1');
INSERT INTO `order_detail` VALUES ('25', '4', '3', '1', '40', '2', '1', '2');
INSERT INTO `order_detail` VALUES ('26', '4', '1', '1', '20', '2', '1', '3');
INSERT INTO `order_detail` VALUES ('27', '5', '4', '1', '10', '19', '1', '1');
INSERT INTO `order_detail` VALUES ('28', '5', '5', '1', '35', '19', '1', '2');
INSERT INTO `order_detail` VALUES ('29', '5', '6', '1', '80', '19', '1', '3');
INSERT INTO `order_detail` VALUES ('30', '5', '7', '1', '95', '19', '1', '4');
INSERT INTO `order_detail` VALUES ('31', '5', '8', '1', '45', '19', '1', '5');
INSERT INTO `order_detail` VALUES ('32', '5', '9', '1', '15', '19', '1', '6');
INSERT INTO `order_detail` VALUES ('33', '6', '4', '1', '10', '18', '1', '1');
INSERT INTO `order_detail` VALUES ('34', '6', '5', '1', '35', '18', '1', '2');
INSERT INTO `order_detail` VALUES ('35', '6', '6', '1', '80', '18', '1', '3');
INSERT INTO `order_detail` VALUES ('36', '7', '1', '1', '20', '1', '1', '1');
INSERT INTO `order_detail` VALUES ('37', '8', '7', '1', '95', '19', '1', '1');
INSERT INTO `order_detail` VALUES ('38', '8', '8', '1', '45', '19', '1', '2');
INSERT INTO `order_detail` VALUES ('39', '8', '9', '1', '15', '19', '1', '3');
INSERT INTO `order_detail` VALUES ('40', '8', '10', '1', '8', '19', '1', null);
INSERT INTO `order_detail` VALUES ('41', '8', '11', '1', '10', '19', '1', null);
INSERT INTO `order_detail` VALUES ('42', '8', '12', '1', '10', '19', '1', null);
INSERT INTO `order_detail` VALUES ('43', '8', '14', '1', '10', '19', '1', null);
INSERT INTO `order_detail` VALUES ('44', '8', '13', '1', '10', '19', '1', null);
INSERT INTO `order_detail` VALUES ('45', '8', '15', '1', '45', '19', '1', null);
INSERT INTO `order_detail` VALUES ('46', '9', '1', '1', '20', '1', '1', '1');
INSERT INTO `order_detail` VALUES ('47', '9', '2', '1', '30', '1', '1', '2');

-- ----------------------------
-- Table structure for `predetermine`
-- ----------------------------
DROP TABLE IF EXISTS `predetermine`;
CREATE TABLE `predetermine` (
  `pre_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) DEFAULT NULL,
  `room_id` int(11) DEFAULT NULL,
  `pre_time` varchar(19) DEFAULT NULL,
  `pre_date` date DEFAULT NULL,
  `pre_frame` varchar(50) DEFAULT NULL,
  `pre_state` varchar(50) DEFAULT NULL,
  `pre_operator` varchar(50) DEFAULT NULL,
  `pre_customer` varchar(50) DEFAULT NULL,
  `pre_phone` varchar(50) DEFAULT NULL,
  `pre_line` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pre_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of predetermine
-- ----------------------------

-- ----------------------------
-- Table structure for `purchase`
-- ----------------------------
DROP TABLE IF EXISTS `purchase`;
CREATE TABLE `purchase` (
  `purchaseid` int(20) NOT NULL AUTO_INCREMENT,
  `quantity` int(50) DEFAULT NULL,
  `total` int(50) DEFAULT NULL,
  `univalent` int(50) DEFAULT NULL,
  PRIMARY KEY (`purchaseid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of purchase
-- ----------------------------

-- ----------------------------
-- Table structure for `purchaseorder`
-- ----------------------------
DROP TABLE IF EXISTS `purchaseorder`;
CREATE TABLE `purchaseorder` (
  `poid` int(20) NOT NULL AUTO_INCREMENT,
  `operatingid` int(20) DEFAULT NULL,
  `operating` varchar(50) DEFAULT NULL,
  `date` timestamp NULL DEFAULT NULL,
  `listid` int(50) DEFAULT NULL,
  PRIMARY KEY (`poid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of purchaseorder
-- ----------------------------

-- ----------------------------
-- Table structure for `repertory`
-- ----------------------------
DROP TABLE IF EXISTS `repertory`;
CREATE TABLE `repertory` (
  `repertoryid` int(20) NOT NULL AUTO_INCREMENT,
  `describe` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`repertoryid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of repertory
-- ----------------------------

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_level` int(11) DEFAULT NULL,
  `role_name` varchar(20) DEFAULT NULL,
  `state` varchar(10) DEFAULT NULL,
  `date` varchar(19) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '1', '超级管理员', '0', '2017-10-23 08:56:29', '1', 'zhangsan');
INSERT INTO `role` VALUES ('2', '2', '网上管理员', '0', null, null, null);
INSERT INTO `role` VALUES ('3', '2', '线下管理员A', '0', '2017-10-25 08:55:57', '1', 'zhangsan');
INSERT INTO `role` VALUES ('5', '2', '线下管理员B', '0', null, null, null);
INSERT INTO `role` VALUES ('6', '2', '预定管理员', '0', null, null, null);
INSERT INTO `role` VALUES ('7', '3', '库存管理员', '0', null, null, null);
INSERT INTO `role` VALUES ('8', '3', '评论管理员', '0', null, null, null);
INSERT INTO `role` VALUES ('9', '4', '员工', '0', null, null, null);

-- ----------------------------
-- Table structure for `role_account`
-- ----------------------------
DROP TABLE IF EXISTS `role_account`;
CREATE TABLE `role_account` (
  `role_id` int(11) NOT NULL,
  `emp_account_id` int(11) NOT NULL,
  PRIMARY KEY (`role_id`,`emp_account_id`),
  KEY `Fk_role_account_account_id` (`emp_account_id`),
  CONSTRAINT `Fk_role_account_account_id` FOREIGN KEY (`emp_account_id`) REFERENCES `emp_account` (`emp_account_id`),
  CONSTRAINT `FK_role_account_roleid` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_account
-- ----------------------------
INSERT INTO `role_account` VALUES ('1', '1');
INSERT INTO `role_account` VALUES ('2', '2');
INSERT INTO `role_account` VALUES ('3', '3');
INSERT INTO `role_account` VALUES ('6', '4');
INSERT INTO `role_account` VALUES ('7', '5');
INSERT INTO `role_account` VALUES ('8', '6');
INSERT INTO `role_account` VALUES ('5', '7');
INSERT INTO `role_account` VALUES ('9', '8');

-- ----------------------------
-- Table structure for `room`
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `room_id` int(11) NOT NULL AUTO_INCREMENT,
  `room_number` varchar(50) DEFAULT NULL,
  `room_state` varchar(50) DEFAULT NULL,
  `peo_count` int(11) DEFAULT NULL,
  `room_type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`room_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES ('1', 'A101', '空闲', '10', '包厢');
INSERT INTO `room` VALUES ('2', 'A102', '空闲', '8', '包厢');
INSERT INTO `room` VALUES ('3', 'A103', '空闲', '8', '包厢');
INSERT INTO `room` VALUES ('4', 'B101', '空闲', '7', '包厢');
INSERT INTO `room` VALUES ('5', 'B102', '空闲', '7', '包厢');
INSERT INTO `room` VALUES ('6', 'B103', '空闲', '8', '包厢');
INSERT INTO `room` VALUES ('7', 'C101', '空闲', '6', '包厢');
INSERT INTO `room` VALUES ('8', 'C102', '空闲', '9', '包厢');
INSERT INTO `room` VALUES ('9', 'C103', '空闲', '8', '包厢');
INSERT INTO `room` VALUES ('10', '1号', '空闲', '10', '桌');
INSERT INTO `room` VALUES ('11', '2号', '空闲', '6', '桌');
INSERT INTO `room` VALUES ('12', '3号', '空闲', '7', '桌');
INSERT INTO `room` VALUES ('13', '4号', '空闲', '9', '桌');
INSERT INTO `room` VALUES ('14', '5号', '空闲', '9', '桌');
INSERT INTO `room` VALUES ('15', '6号', '空闲', '9', '桌');
INSERT INTO `room` VALUES ('16', '7号', '空闲', '7', '桌');
INSERT INTO `room` VALUES ('17', '8号', '空闲', '8', '桌');
INSERT INTO `room` VALUES ('18', '9号', '空闲', '8', '桌');
INSERT INTO `room` VALUES ('19', '10号', '空闲', '6', '桌');
INSERT INTO `room` VALUES ('20', '11号', '空闲', '9', '桌');
