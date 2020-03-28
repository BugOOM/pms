/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : pms

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2020-02-03 12:02:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for charge
-- ----------------------------
DROP TABLE IF EXISTS `charge`;
CREATE TABLE `charge` (
  `charge_type` int(10) NOT NULL AUTO_INCREMENT COMMENT '费用类型',
  `charge_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '费用名称',
  `charge_threshold` int(10) DEFAULT NULL COMMENT '收费的阈值',
  `charge_low` int(10) DEFAULT NULL COMMENT '低于阈值的价格',
  `charge_high` int(10) DEFAULT NULL COMMENT '高于阈值的价格',
  PRIMARY KEY (`charge_type`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of charge
-- ----------------------------
INSERT INTO `charge` VALUES ('1', '水费', '20', '1', '2');
INSERT INTO `charge` VALUES ('2', '电费', '100', '2', '3');
INSERT INTO `charge` VALUES ('3', '煤气费', '50', '3', '4');
INSERT INTO `charge` VALUES ('4', '电梯费', '6', '200', '300');

-- ----------------------------
-- Table structure for complaint
-- ----------------------------
DROP TABLE IF EXISTS `complaint`;
CREATE TABLE `complaint` (
  `complaint_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '投诉编号',
  `complaint_user` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '哪个住户投诉',
  `complaint_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `complaint_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '投诉内容',
  `complaint_time` date NOT NULL COMMENT '投诉时间',
  `complaint_status` int(10) NOT NULL DEFAULT '0' COMMENT '是否处理',
  PRIMARY KEY (`complaint_id`),
  KEY `complaint_user` (`complaint_user`),
  CONSTRAINT `complaint_ibfk_1` FOREIGN KEY (`complaint_user`) REFERENCES `user` (`username`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of complaint
-- ----------------------------
INSERT INTO `complaint` VALUES ('1', 'peng', '测试', '没别的，就是测试一下这个系统好不好用', '2020-01-01', '2');

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `dept_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '楼栋编号\r\n',
  `dept_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '楼栋名称',
  `dept_floor` int(10) NOT NULL COMMENT '楼栋层数',
  `dept_num` int(10) NOT NULL COMMENT '每层住房个数',
  `dept_area` int(10) DEFAULT NULL,
  `dept_time` date NOT NULL COMMENT '建成日期',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('1', '计算机学院', '11', '6', '132', '2020-01-01');
INSERT INTO `dept` VALUES ('2', '理学院', '6', '30', '80', '2020-01-01');

-- ----------------------------
-- Table structure for house
-- ----------------------------
DROP TABLE IF EXISTS `house`;
CREATE TABLE `house` (
  `house_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '住房编号',
  `house_num` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '门牌号',
  `dept_id` int(10) NOT NULL COMMENT '所属楼栋',
  `owner_id` int(10) DEFAULT NULL COMMENT '所属业主',
  PRIMARY KEY (`house_id`),
  KEY `house_dept_id` (`dept_id`),
  KEY `house_owner_id` (`owner_id`),
  CONSTRAINT `house_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `dept` (`dept_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `house_ibfk_2` FOREIGN KEY (`owner_id`) REFERENCES `owner` (`owner_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=247 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of house
-- ----------------------------
INSERT INTO `house` VALUES ('1', '1-1', '1', null);
INSERT INTO `house` VALUES ('2', '1-2', '1', null);
INSERT INTO `house` VALUES ('3', '1-3', '1', null);
INSERT INTO `house` VALUES ('4', '1-4', '1', null);
INSERT INTO `house` VALUES ('5', '1-5', '1', null);
INSERT INTO `house` VALUES ('6', '1-6', '1', null);
INSERT INTO `house` VALUES ('7', '2-1', '1', null);
INSERT INTO `house` VALUES ('8', '2-2', '1', null);
INSERT INTO `house` VALUES ('9', '2-3', '1', null);
INSERT INTO `house` VALUES ('10', '2-4', '1', null);
INSERT INTO `house` VALUES ('11', '2-5', '1', null);
INSERT INTO `house` VALUES ('12', '2-6', '1', null);
INSERT INTO `house` VALUES ('13', '3-1', '1', null);
INSERT INTO `house` VALUES ('14', '3-2', '1', null);
INSERT INTO `house` VALUES ('15', '3-3', '1', '1');
INSERT INTO `house` VALUES ('16', '3-4', '1', null);
INSERT INTO `house` VALUES ('17', '3-5', '1', null);
INSERT INTO `house` VALUES ('18', '3-6', '1', null);
INSERT INTO `house` VALUES ('19', '4-1', '1', null);
INSERT INTO `house` VALUES ('20', '4-2', '1', null);
INSERT INTO `house` VALUES ('21', '4-3', '1', null);
INSERT INTO `house` VALUES ('22', '4-4', '1', null);
INSERT INTO `house` VALUES ('23', '4-5', '1', null);
INSERT INTO `house` VALUES ('24', '4-6', '1', null);
INSERT INTO `house` VALUES ('25', '5-1', '1', null);
INSERT INTO `house` VALUES ('26', '5-2', '1', null);
INSERT INTO `house` VALUES ('27', '5-3', '1', null);
INSERT INTO `house` VALUES ('28', '5-4', '1', null);
INSERT INTO `house` VALUES ('29', '5-5', '1', null);
INSERT INTO `house` VALUES ('30', '5-6', '1', null);
INSERT INTO `house` VALUES ('31', '6-1', '1', null);
INSERT INTO `house` VALUES ('32', '6-2', '1', null);
INSERT INTO `house` VALUES ('33', '6-3', '1', null);
INSERT INTO `house` VALUES ('34', '6-4', '1', null);
INSERT INTO `house` VALUES ('35', '6-5', '1', null);
INSERT INTO `house` VALUES ('36', '6-6', '1', null);
INSERT INTO `house` VALUES ('37', '7-1', '1', null);
INSERT INTO `house` VALUES ('38', '7-2', '1', null);
INSERT INTO `house` VALUES ('39', '7-3', '1', null);
INSERT INTO `house` VALUES ('40', '7-4', '1', null);
INSERT INTO `house` VALUES ('41', '7-5', '1', null);
INSERT INTO `house` VALUES ('42', '7-6', '1', null);
INSERT INTO `house` VALUES ('43', '8-1', '1', null);
INSERT INTO `house` VALUES ('44', '8-2', '1', null);
INSERT INTO `house` VALUES ('45', '8-3', '1', null);
INSERT INTO `house` VALUES ('46', '8-4', '1', null);
INSERT INTO `house` VALUES ('47', '8-5', '1', null);
INSERT INTO `house` VALUES ('48', '8-6', '1', null);
INSERT INTO `house` VALUES ('49', '9-1', '1', null);
INSERT INTO `house` VALUES ('50', '9-2', '1', null);
INSERT INTO `house` VALUES ('51', '9-3', '1', null);
INSERT INTO `house` VALUES ('52', '9-4', '1', null);
INSERT INTO `house` VALUES ('53', '9-5', '1', null);
INSERT INTO `house` VALUES ('54', '9-6', '1', null);
INSERT INTO `house` VALUES ('55', '10-1', '1', null);
INSERT INTO `house` VALUES ('56', '10-2', '1', null);
INSERT INTO `house` VALUES ('57', '10-3', '1', null);
INSERT INTO `house` VALUES ('58', '10-4', '1', null);
INSERT INTO `house` VALUES ('59', '10-5', '1', null);
INSERT INTO `house` VALUES ('60', '10-6', '1', null);
INSERT INTO `house` VALUES ('61', '11-1', '1', null);
INSERT INTO `house` VALUES ('62', '11-2', '1', null);
INSERT INTO `house` VALUES ('63', '11-3', '1', null);
INSERT INTO `house` VALUES ('64', '11-4', '1', null);
INSERT INTO `house` VALUES ('65', '11-5', '1', null);
INSERT INTO `house` VALUES ('66', '11-6', '1', null);
INSERT INTO `house` VALUES ('67', '1-1', '2', null);
INSERT INTO `house` VALUES ('68', '1-2', '2', null);
INSERT INTO `house` VALUES ('69', '1-3', '2', null);
INSERT INTO `house` VALUES ('70', '1-4', '2', null);
INSERT INTO `house` VALUES ('71', '1-5', '2', null);
INSERT INTO `house` VALUES ('72', '1-6', '2', null);
INSERT INTO `house` VALUES ('73', '1-7', '2', null);
INSERT INTO `house` VALUES ('74', '1-8', '2', null);
INSERT INTO `house` VALUES ('75', '1-9', '2', null);
INSERT INTO `house` VALUES ('76', '1-10', '2', null);
INSERT INTO `house` VALUES ('77', '1-11', '2', null);
INSERT INTO `house` VALUES ('78', '1-12', '2', null);
INSERT INTO `house` VALUES ('79', '1-13', '2', null);
INSERT INTO `house` VALUES ('80', '1-14', '2', null);
INSERT INTO `house` VALUES ('81', '1-15', '2', null);
INSERT INTO `house` VALUES ('82', '1-16', '2', null);
INSERT INTO `house` VALUES ('83', '1-17', '2', null);
INSERT INTO `house` VALUES ('84', '1-18', '2', null);
INSERT INTO `house` VALUES ('85', '1-19', '2', null);
INSERT INTO `house` VALUES ('86', '1-20', '2', null);
INSERT INTO `house` VALUES ('87', '1-21', '2', null);
INSERT INTO `house` VALUES ('88', '1-22', '2', null);
INSERT INTO `house` VALUES ('89', '1-23', '2', null);
INSERT INTO `house` VALUES ('90', '1-24', '2', null);
INSERT INTO `house` VALUES ('91', '1-25', '2', null);
INSERT INTO `house` VALUES ('92', '1-26', '2', null);
INSERT INTO `house` VALUES ('93', '1-27', '2', null);
INSERT INTO `house` VALUES ('94', '1-28', '2', null);
INSERT INTO `house` VALUES ('95', '1-29', '2', null);
INSERT INTO `house` VALUES ('96', '1-30', '2', null);
INSERT INTO `house` VALUES ('97', '2-1', '2', null);
INSERT INTO `house` VALUES ('98', '2-2', '2', null);
INSERT INTO `house` VALUES ('99', '2-3', '2', null);
INSERT INTO `house` VALUES ('100', '2-4', '2', null);
INSERT INTO `house` VALUES ('101', '2-5', '2', null);
INSERT INTO `house` VALUES ('102', '2-6', '2', null);
INSERT INTO `house` VALUES ('103', '2-7', '2', null);
INSERT INTO `house` VALUES ('104', '2-8', '2', null);
INSERT INTO `house` VALUES ('105', '2-9', '2', null);
INSERT INTO `house` VALUES ('106', '2-10', '2', null);
INSERT INTO `house` VALUES ('107', '2-11', '2', null);
INSERT INTO `house` VALUES ('108', '2-12', '2', null);
INSERT INTO `house` VALUES ('109', '2-13', '2', null);
INSERT INTO `house` VALUES ('110', '2-14', '2', null);
INSERT INTO `house` VALUES ('111', '2-15', '2', null);
INSERT INTO `house` VALUES ('112', '2-16', '2', null);
INSERT INTO `house` VALUES ('113', '2-17', '2', null);
INSERT INTO `house` VALUES ('114', '2-18', '2', null);
INSERT INTO `house` VALUES ('115', '2-19', '2', null);
INSERT INTO `house` VALUES ('116', '2-20', '2', null);
INSERT INTO `house` VALUES ('117', '2-21', '2', null);
INSERT INTO `house` VALUES ('118', '2-22', '2', null);
INSERT INTO `house` VALUES ('119', '2-23', '2', null);
INSERT INTO `house` VALUES ('120', '2-24', '2', null);
INSERT INTO `house` VALUES ('121', '2-25', '2', null);
INSERT INTO `house` VALUES ('122', '2-26', '2', null);
INSERT INTO `house` VALUES ('123', '2-27', '2', null);
INSERT INTO `house` VALUES ('124', '2-28', '2', null);
INSERT INTO `house` VALUES ('125', '2-29', '2', null);
INSERT INTO `house` VALUES ('126', '2-30', '2', null);
INSERT INTO `house` VALUES ('127', '3-1', '2', null);
INSERT INTO `house` VALUES ('128', '3-2', '2', null);
INSERT INTO `house` VALUES ('129', '3-3', '2', null);
INSERT INTO `house` VALUES ('130', '3-4', '2', null);
INSERT INTO `house` VALUES ('131', '3-5', '2', null);
INSERT INTO `house` VALUES ('132', '3-6', '2', null);
INSERT INTO `house` VALUES ('133', '3-7', '2', null);
INSERT INTO `house` VALUES ('134', '3-8', '2', null);
INSERT INTO `house` VALUES ('135', '3-9', '2', null);
INSERT INTO `house` VALUES ('136', '3-10', '2', null);
INSERT INTO `house` VALUES ('137', '3-11', '2', null);
INSERT INTO `house` VALUES ('138', '3-12', '2', null);
INSERT INTO `house` VALUES ('139', '3-13', '2', null);
INSERT INTO `house` VALUES ('140', '3-14', '2', null);
INSERT INTO `house` VALUES ('141', '3-15', '2', null);
INSERT INTO `house` VALUES ('142', '3-16', '2', null);
INSERT INTO `house` VALUES ('143', '3-17', '2', null);
INSERT INTO `house` VALUES ('144', '3-18', '2', null);
INSERT INTO `house` VALUES ('145', '3-19', '2', null);
INSERT INTO `house` VALUES ('146', '3-20', '2', null);
INSERT INTO `house` VALUES ('147', '3-21', '2', null);
INSERT INTO `house` VALUES ('148', '3-22', '2', null);
INSERT INTO `house` VALUES ('149', '3-23', '2', null);
INSERT INTO `house` VALUES ('150', '3-24', '2', null);
INSERT INTO `house` VALUES ('151', '3-25', '2', null);
INSERT INTO `house` VALUES ('152', '3-26', '2', null);
INSERT INTO `house` VALUES ('153', '3-27', '2', null);
INSERT INTO `house` VALUES ('154', '3-28', '2', null);
INSERT INTO `house` VALUES ('155', '3-29', '2', null);
INSERT INTO `house` VALUES ('156', '3-30', '2', null);
INSERT INTO `house` VALUES ('157', '4-1', '2', null);
INSERT INTO `house` VALUES ('158', '4-2', '2', null);
INSERT INTO `house` VALUES ('159', '4-3', '2', null);
INSERT INTO `house` VALUES ('160', '4-4', '2', null);
INSERT INTO `house` VALUES ('161', '4-5', '2', null);
INSERT INTO `house` VALUES ('162', '4-6', '2', null);
INSERT INTO `house` VALUES ('163', '4-7', '2', null);
INSERT INTO `house` VALUES ('164', '4-8', '2', null);
INSERT INTO `house` VALUES ('165', '4-9', '2', null);
INSERT INTO `house` VALUES ('166', '4-10', '2', null);
INSERT INTO `house` VALUES ('167', '4-11', '2', null);
INSERT INTO `house` VALUES ('168', '4-12', '2', null);
INSERT INTO `house` VALUES ('169', '4-13', '2', null);
INSERT INTO `house` VALUES ('170', '4-14', '2', null);
INSERT INTO `house` VALUES ('171', '4-15', '2', null);
INSERT INTO `house` VALUES ('172', '4-16', '2', null);
INSERT INTO `house` VALUES ('173', '4-17', '2', null);
INSERT INTO `house` VALUES ('174', '4-18', '2', null);
INSERT INTO `house` VALUES ('175', '4-19', '2', null);
INSERT INTO `house` VALUES ('176', '4-20', '2', null);
INSERT INTO `house` VALUES ('177', '4-21', '2', null);
INSERT INTO `house` VALUES ('178', '4-22', '2', null);
INSERT INTO `house` VALUES ('179', '4-23', '2', null);
INSERT INTO `house` VALUES ('180', '4-24', '2', null);
INSERT INTO `house` VALUES ('181', '4-25', '2', null);
INSERT INTO `house` VALUES ('182', '4-26', '2', null);
INSERT INTO `house` VALUES ('183', '4-27', '2', null);
INSERT INTO `house` VALUES ('184', '4-28', '2', null);
INSERT INTO `house` VALUES ('185', '4-29', '2', null);
INSERT INTO `house` VALUES ('186', '4-30', '2', null);
INSERT INTO `house` VALUES ('187', '5-1', '2', null);
INSERT INTO `house` VALUES ('188', '5-2', '2', null);
INSERT INTO `house` VALUES ('189', '5-3', '2', null);
INSERT INTO `house` VALUES ('190', '5-4', '2', null);
INSERT INTO `house` VALUES ('191', '5-5', '2', null);
INSERT INTO `house` VALUES ('192', '5-6', '2', null);
INSERT INTO `house` VALUES ('193', '5-7', '2', null);
INSERT INTO `house` VALUES ('194', '5-8', '2', null);
INSERT INTO `house` VALUES ('195', '5-9', '2', null);
INSERT INTO `house` VALUES ('196', '5-10', '2', null);
INSERT INTO `house` VALUES ('197', '5-11', '2', null);
INSERT INTO `house` VALUES ('198', '5-12', '2', null);
INSERT INTO `house` VALUES ('199', '5-13', '2', null);
INSERT INTO `house` VALUES ('200', '5-14', '2', null);
INSERT INTO `house` VALUES ('201', '5-15', '2', null);
INSERT INTO `house` VALUES ('202', '5-16', '2', null);
INSERT INTO `house` VALUES ('203', '5-17', '2', null);
INSERT INTO `house` VALUES ('204', '5-18', '2', null);
INSERT INTO `house` VALUES ('205', '5-19', '2', null);
INSERT INTO `house` VALUES ('206', '5-20', '2', null);
INSERT INTO `house` VALUES ('207', '5-21', '2', null);
INSERT INTO `house` VALUES ('208', '5-22', '2', null);
INSERT INTO `house` VALUES ('209', '5-23', '2', null);
INSERT INTO `house` VALUES ('210', '5-24', '2', null);
INSERT INTO `house` VALUES ('211', '5-25', '2', null);
INSERT INTO `house` VALUES ('212', '5-26', '2', null);
INSERT INTO `house` VALUES ('213', '5-27', '2', null);
INSERT INTO `house` VALUES ('214', '5-28', '2', null);
INSERT INTO `house` VALUES ('215', '5-29', '2', null);
INSERT INTO `house` VALUES ('216', '5-30', '2', null);
INSERT INTO `house` VALUES ('217', '6-1', '2', null);
INSERT INTO `house` VALUES ('218', '6-2', '2', null);
INSERT INTO `house` VALUES ('219', '6-3', '2', null);
INSERT INTO `house` VALUES ('220', '6-4', '2', null);
INSERT INTO `house` VALUES ('221', '6-5', '2', null);
INSERT INTO `house` VALUES ('222', '6-6', '2', null);
INSERT INTO `house` VALUES ('223', '6-7', '2', null);
INSERT INTO `house` VALUES ('224', '6-8', '2', null);
INSERT INTO `house` VALUES ('225', '6-9', '2', null);
INSERT INTO `house` VALUES ('226', '6-10', '2', null);
INSERT INTO `house` VALUES ('227', '6-11', '2', null);
INSERT INTO `house` VALUES ('228', '6-12', '2', null);
INSERT INTO `house` VALUES ('229', '6-13', '2', null);
INSERT INTO `house` VALUES ('230', '6-14', '2', null);
INSERT INTO `house` VALUES ('231', '6-15', '2', null);
INSERT INTO `house` VALUES ('232', '6-16', '2', null);
INSERT INTO `house` VALUES ('233', '6-17', '2', null);
INSERT INTO `house` VALUES ('234', '6-18', '2', null);
INSERT INTO `house` VALUES ('235', '6-19', '2', null);
INSERT INTO `house` VALUES ('236', '6-20', '2', null);
INSERT INTO `house` VALUES ('237', '6-21', '2', null);
INSERT INTO `house` VALUES ('238', '6-22', '2', null);
INSERT INTO `house` VALUES ('239', '6-23', '2', null);
INSERT INTO `house` VALUES ('240', '6-24', '2', null);
INSERT INTO `house` VALUES ('241', '6-25', '2', null);
INSERT INTO `house` VALUES ('242', '6-26', '2', null);
INSERT INTO `house` VALUES ('243', '6-27', '2', null);
INSERT INTO `house` VALUES ('244', '6-28', '2', null);
INSERT INTO `house` VALUES ('245', '6-29', '2', null);
INSERT INTO `house` VALUES ('246', '6-30', '2', null);

-- ----------------------------
-- Table structure for owner
-- ----------------------------
DROP TABLE IF EXISTS `owner`;
CREATE TABLE `owner` (
  `owner_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '业主编号',
  `owner_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '业主姓名',
  `owner_sex` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '业主性别',
  `owner_age` int(10) NOT NULL COMMENT '业主年龄',
  `owner_num` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '业主身份证号',
  `owner_phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '业主电话',
  PRIMARY KEY (`owner_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of owner
-- ----------------------------
INSERT INTO `owner` VALUES ('1', 'pengtongqing', '男', '22', '123321456654', '13366668888');

-- ----------------------------
-- Table structure for pay
-- ----------------------------
DROP TABLE IF EXISTS `pay`;
CREATE TABLE `pay` (
  `pay_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '缴费编号',
  `charge_type` int(10) NOT NULL COMMENT '费用类型',
  `pay_use` int(10) NOT NULL COMMENT '用量',
  `pay_total` int(10) NOT NULL COMMENT '总价',
  `pay_status` int(10) NOT NULL DEFAULT '0' COMMENT '是否缴费',
  `pay_time` date DEFAULT NULL COMMENT '上次缴费时间',
  `house_id` int(10) NOT NULL COMMENT '所属住房',
  PRIMARY KEY (`pay_id`),
  KEY `pay_charge_type` (`charge_type`),
  KEY `pay_house_id` (`house_id`),
  CONSTRAINT `pay_ibfk_1` FOREIGN KEY (`charge_type`) REFERENCES `charge` (`charge_type`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `pay_ibfk_2` FOREIGN KEY (`house_id`) REFERENCES `house` (`house_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of pay
-- ----------------------------
INSERT INTO `pay` VALUES ('1', '2', '132', '396', '1', '2019-08-09', '15');
INSERT INTO `pay` VALUES ('2', '3', '42', '126', '1', '2019-12-31', '15');
INSERT INTO `pay` VALUES ('3', '1', '100', '200', '1', '2020-12-12', '15');
INSERT INTO `pay` VALUES ('4', '3', '100', '400', '1', '2019-11-11', '15');
INSERT INTO `pay` VALUES ('5', '3', '320', '1230', '0', null, '15');
INSERT INTO `pay` VALUES ('6', '2', '100', '200', '0', null, '15');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'ROLE_ADMIN');
INSERT INTO `role` VALUES ('2', 'ROLE_USER');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `owner_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `owner_id` (`owner_id`),
  KEY `username` (`username`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`owner_id`) REFERENCES `owner` (`owner_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '$2a$10$PBVO7MZWtBL0bzdKNjYJr.Ul4crl4BovDVz/Nu03wkaD7sViUuGyG', '927710825@qq.com', null);
INSERT INTO `user` VALUES ('6', 'peng', '$2a$10$Cge76qxJVZTjj1MHtzB5gO4uLeeuhDr42MYAwJOjhQTsPDrQ0W5KW', '927710825@qq.com', '1');
INSERT INTO `user` VALUES ('7', 'test', '$2a$10$I3Tve/JHnGB4EEW7HfzHL.c3MNfJ34Spbw3ThvhkYto9V7HI7Zgre', '927710825@qq.com', null);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` int(10) NOT NULL,
  `role_id` int(10) NOT NULL,
  KEY `user_id` (`user_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1');
INSERT INTO `user_role` VALUES ('6', '2');
INSERT INTO `user_role` VALUES ('7', '2');
