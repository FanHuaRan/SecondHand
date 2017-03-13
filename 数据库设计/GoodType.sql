/*
Navicat MySQL Data Transfer

Source Server         : centosserver
Source Server Version : 50173
Source Host           : 101.200.55.205:3306
Source Database       : shdb

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2017-03-13 10:40:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for GoodType
-- ----------------------------
DROP TABLE IF EXISTS `GoodType`;
CREATE TABLE `GoodType` (
  `GoodTypeId` int(11) NOT NULL AUTO_INCREMENT,
  `GoodTypeName` varchar(20) NOT NULL,
  PRIMARY KEY (`GoodTypeId`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of GoodType
-- ----------------------------
INSERT INTO `GoodType` VALUES ('1', '数码产品');
INSERT INTO `GoodType` VALUES ('2', '书籍');
INSERT INTO `GoodType` VALUES ('3', '护肤');
INSERT INTO `GoodType` VALUES ('4', '美妆');
INSERT INTO `GoodType` VALUES ('5', '衣物');
INSERT INTO `GoodType` VALUES ('6', '自行车');
INSERT INTO `GoodType` VALUES ('7', '运动户外');
INSERT INTO `GoodType` VALUES ('8', '宠物');
INSERT INTO `GoodType` VALUES ('9', '首饰');
INSERT INTO `GoodType` VALUES ('10', '杂物');
