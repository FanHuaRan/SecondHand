/*
Navicat MySQL Data Transfer

Source Server         : centosserver
Source Server Version : 50173
Source Host           : 101.200.55.205:3306
Source Database       : shdb

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2017-03-13 16:34:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for Good
-- ----------------------------
DROP TABLE IF EXISTS `Good`;
CREATE TABLE `Good` (
  `GoodId` int(11) NOT NULL AUTO_INCREMENT,
  `ShUserId` int(11) NOT NULL,
  `GoodTypeId` int(11) NOT NULL,
  `GoodName` varchar(10) NOT NULL,
  `DesTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `Description` varchar(50) NOT NULL,
  `ImageUrl` varchar(30) NOT NULL,
  `IsSell` tinyint(4) NOT NULL,
  `GoodPrice` float NOT NULL,
  PRIMARY KEY (`GoodId`),
  KEY `FK_Reference_5` (`ShUserId`),
  KEY `FK_Reference_6` (`GoodTypeId`)
) ENGINE=MyISAM AUTO_INCREMENT=112 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Good
-- ----------------------------
INSERT INTO `Good` VALUES ('101', '101', '1', 'Samsung', '2017-03-13 10:27:30', 'wodei jlgjadhgljhfdjhgjdshgjfdjj', 'Resource/images/test.png', '0', '3000');
INSERT INTO `Good` VALUES ('102', '102', '2', '五年高考三年模拟', '2017-03-13 10:27:31', '就会受到客观环境都卡死联合国4', 'Resource/images/test.png', '0', '50');
INSERT INTO `Good` VALUES ('103', '102', '3', 'ipsa流金水', '2017-03-13 10:27:33', '砂锅捣蒜广泛的施工队施工事故多发伤', 'Resource/images/test.png', '0', '200');
INSERT INTO `Good` VALUES ('104', '101', '4', '腮红', '2017-03-13 10:27:34', '三代富贵第三方公司的', 'Resource/images/test.png', '0', '80');
INSERT INTO `Good` VALUES ('105', '103', '5', 'nikeT恤', '2017-03-13 10:27:36', '我爷爷给我买的二胡，可好用啦。技术的客观环境的方式', 'Resource/images/test.png', '0', '400');
INSERT INTO `Good` VALUES ('106', '104', '6', '死飞单车', '2017-03-13 10:27:37', '觉得更加深刻领会结构良好的方式将会更加开放的', 'Resource/images/test.png', '0', '600');
INSERT INTO `Good` VALUES ('107', '105', '7', '滑板', '2017-03-13 10:27:39', '我的滑板，最呀么最哭选', 'Resource/images/test.png', '0', '1000');
INSERT INTO `Good` VALUES ('108', '106', '8', '波斯猫', '2017-03-13 10:27:40', '养在宿舍三年了，简直就是我们宿舍的皇啊', 'Resource/images/test.png', '0', '200');
INSERT INTO `Good` VALUES ('109', '107', '9', '银手镯', '2017-03-13 10:27:42', '是法国大使馆是古代服饰公司', 'Resource/images/test.png', '0', '300');
INSERT INTO `Good` VALUES ('110', '106', '10', '眼镜盒', '2017-03-13 10:27:45', '可爱，很喜欢', 'Resource/images/test.png', '0', '20');
